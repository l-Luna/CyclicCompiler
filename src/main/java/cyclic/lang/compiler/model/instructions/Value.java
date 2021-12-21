package cyclic.lang.compiler.model.instructions;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.gen.Operations;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

public abstract class Value{
	
	public static Value fromAst(CyclicLangParser.ValueContext ctx, Scope scope, CyclicType type, CallableReference method){
		if(ctx instanceof CyclicLangParser.NullLitContext)
			return new NullLiteralValue();
		if(ctx instanceof CyclicLangParser.IntLitContext intLit){
			String text = intLit.INTLIT().getText();
			if(text.endsWith("f"))
				return new FloatLiteralValue(Float.parseFloat(text));
			else if(text.endsWith("d"))
				return new DoubleLiteralValue(Double.parseDouble(text));
			else
				return new IntLiteralValue(Integer.parseInt(text));
		}
		if(ctx instanceof CyclicLangParser.DecLitContext decLit){
			String text = decLit.DECLIT().getText();
			if(text.endsWith("f"))
				return new FloatLiteralValue(Float.parseFloat(text));
			else
				return new DoubleLiteralValue(Double.parseDouble(text));
		}
		if(ctx instanceof CyclicLangParser.BoolLitContext boolLit)
			return new IntLiteralValue(boolLit.getText().equals("true") ? 1 : 0, true);
		if(ctx instanceof CyclicLangParser.StrLitContext strLit){
			String text = strLit.getText();
			return new StringLiteralValue(text.substring(1, text.length() - 1));
		}
		if(ctx instanceof CyclicLangParser.VarValueContext val){
			String name = val.ID().getText();
			// if a value is present, check if it's a partial type name, and add to it if so; otherwise return a field
			if(val.value() != null){
				Value on = fromAst(val.value(), scope, type, method);
				if(on instanceof TypeValue v && v.getPartialTypeName() != null){
					var newTypeName = v.getPartialTypeName() + "." + name;
					var target = TypeResolver.resolveOptional(newTypeName, type.imports, type.packageName());
					return target.map(TypeValue::new).orElseGet(() -> new TypeValue(newTypeName));
				}else
					return new FieldValue(name, on);
			}
			// otherwise, it could be a local variable,
			Variable local = scope.get(name);
			if(local != null)
				return new LocalVarValue(local);
			// or a static field of the current type, or an instance field of the current type for a non-static method
			for(var field : method.in().fields())
				if(field.name().equals(name) && (field.isStatic() || !method.isStatic()))
					return new FieldValue(field);
			// or a partial or full type name
			var target = TypeResolver.resolveOptional(name, type.imports, type.packageName());
			return target.map(TypeValue::new).orElseGet(() -> new TypeValue(name));
		}
		if(ctx instanceof CyclicLangParser.FunctionValueContext func){
			Value on = func.value() != null ? Value.fromAst(func.value(), scope, type, method) : null;
			List<Value> args = func.call().arguments().value().stream().map(x -> Value.fromAst(x, scope, type, method)).toList();
			return new CallValue(on, args, Utils.resolveMethod(func.call().ID().getText(), on, args, method));
		}
		if(ctx instanceof CyclicLangParser.InitialisationValueContext init){
			List<Value> args = init.initialisation().arguments().value().stream().map(x -> Value.fromAst(x, scope, type, method)).toList();
			TypeReference of = TypeResolver.resolve(init.initialisation().type().getText(), type.imports, type.packageName());
			return new InitializationValue(args, Utils.resolveConstructor(of, args, method));
		}
		if(ctx instanceof CyclicLangParser.BinaryOpValueContext bin){
			Value left = Value.fromAst(bin.left, scope, type, method);
			Value right = Value.fromAst(bin.right, scope, type, method);
			return Operations.resolveBinary(bin.binaryop().getText(), left, right);
		}
		if(ctx instanceof CyclicLangParser.UnaryOpValueContext uop){
			return Operations.resolveUnary(uop.unaryop().getText(), fromAst(uop.value(), scope, type, method));
		}
		if(ctx instanceof CyclicLangParser.ParenValueContext paren)
			return fromAst(paren.value(), scope, type, method);
		if(ctx instanceof CyclicLangParser.ThisValueContext){
			if(method.isStatic())
				throw new IllegalStateException("Can't use \"this\" in a static method!");
			return new ThisValue(method.in());
		}
		System.out.println("Unknown expression " + ctx.getText());
		return null;
	}
	
	/**
	 * Returns a value equivalent to this value of the target type,
	 * or null if no conversion exists between this type and the target.
	 * May return the same value.
	 *
	 * @param target
	 * 		The target type to convert to
	 * @return An equivalent to this as the target, or null.
	 */
	public Value fit(TypeReference target){
		if(type().isAssignableTo(target))
			return this;
		
		Value ret = null;
		// unboxing conversion
		if(target instanceof PrimitiveTypeRef prim && type().fullyQualifiedName().equals(prim.boxedTypeName()))
			ret = new UnboxValue(this, prim.type);
		
		if(type() instanceof PrimitiveTypeRef p){
			// boxing conversion
			if(p.boxedType().isAssignableTo(target) && p.type != PrimitiveTypeRef.Primitive.NULL && p.type != PrimitiveTypeRef.Primitive.VOID)
				ret = new BoxValue(this, p.boxedType());
			// widening conversion
			if(target instanceof PrimitiveTypeRef to && to.type != p.type){
				int op = p.wideningOpcode(to.type);
				if(op == 0)
					ret = new SubstituteTypeValue(target, this);
				else if(op != -1)
					ret = new Operations.UnaryOpValue(to, this, op);
			}
		}
		
		// allows for multi-step conversions
		return ret != null ? ret.fit(target) : null;
	}
	
	public void write(MethodVisitor mv){}
	
	public abstract TypeReference type();
	
	public static class NullLiteralValue extends Value{
		
		public TypeReference type(){
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.NULL);
		}
		
		public void write(MethodVisitor mv){
			mv.visitInsn(Opcodes.ACONST_NULL);
		}
	}
	
	// TODO: combine primitive literal values?
	public static class IntLiteralValue extends Value{
		int value;
		boolean isBool = false;
		
		public IntLiteralValue(int value){
			this.value = value;
		}
		
		public IntLiteralValue(int value, boolean isBool){
			this.value = value;
			this.isBool = isBool;
		}
		
		public void write(MethodVisitor mv){
			if(value >= -1 && value <= 5)
				mv.visitInsn(switch(value){
					case -1 -> Opcodes.ICONST_M1;
					case 0 -> Opcodes.ICONST_0;
					case 1 -> Opcodes.ICONST_1;
					case 2 -> Opcodes.ICONST_2;
					case 3 -> Opcodes.ICONST_3;
					case 4 -> Opcodes.ICONST_4;
					case 5 -> Opcodes.ICONST_5;
					default -> throw new IllegalStateException("Unexpected value: " + value);
				});
			else if(value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE)
				mv.visitIntInsn(Opcodes.BIPUSH, value);
			else if(value >= Short.MIN_VALUE && value <= Short.MAX_VALUE)
				mv.visitIntInsn(Opcodes.SIPUSH, value);
			else
				mv.visitLdcInsn(value);
		}
		
		public TypeReference type(){
			return isBool ? new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.BOOLEAN) : new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.INT);
		}
	}
	
	public static class FloatLiteralValue extends Value{
		
		float value;
		
		public FloatLiteralValue(float value){
			this.value = value;
		}
		
		public void write(MethodVisitor mv){
			if(value == 0)
				mv.visitInsn(Opcodes.FCONST_0);
			else if(value == 1)
				mv.visitInsn(Opcodes.FCONST_1);
			else if(value == 2)
				mv.visitInsn(Opcodes.FCONST_2);
			else
				mv.visitLdcInsn(value);
		}
		
		public TypeReference type(){
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.FLOAT);
		}
	}
	
	public static class DoubleLiteralValue extends Value{
		
		double value;
		
		public DoubleLiteralValue(double value){
			this.value = value;
		}
		
		public void write(MethodVisitor mv){
			if(value == 0)
				mv.visitInsn(Opcodes.DCONST_0);
			else if(value == 1)
				mv.visitInsn(Opcodes.DCONST_1);
			else
				mv.visitLdcInsn(value);
		}
		
		public TypeReference type(){
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.DOUBLE);
		}
	}
	
	public static class LongLiteralValue extends Value{
		
		long value;
		
		public LongLiteralValue(long value){
			this.value = value;
		}
		
		public void write(MethodVisitor mv){
			if(value == 0)
				mv.visitInsn(Opcodes.LCONST_0);
			else if(value == 1)
				mv.visitInsn(Opcodes.LCONST_1);
			else
				mv.visitLdcInsn(value);
		}
		
		public TypeReference type(){
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.LONG);
		}
	}
	
	public static class StringLiteralValue extends Value{
		
		String value;
		
		public StringLiteralValue(String value){
			this.value = value;
		}
		
		public void write(MethodVisitor mv){
			mv.visitLdcInsn(value);
		}
		
		public TypeReference type(){
			return TypeResolver.resolveOptional("java.lang.String").orElseThrow(() -> new IllegalStateException("Couldn't resolve java.lang.String for string constant!"));
		}
	}
	
	/**
	 * If the target is a singleton type, this is the single value of that type.
	 * Otherwise, it's an exception to use this value directly.
	 * Calls, field references, and anything else that can be applied to types statically should check for this.
	 */
	public static class TypeValue extends Value{
		TypeReference target;
		String partialTypeName = null;
		
		public TypeValue(TypeReference target){
			this.target = target;
		}
		
		public TypeValue(String partialTypeName){
			this.partialTypeName = partialTypeName;
		}
		
		public String getPartialTypeName(){
			return partialTypeName;
		}
		
		public void write(MethodVisitor mv){
			// write singleton types
		}
		
		public TypeReference type(){
			return target;
		}
	}
	
	public static class FieldValue extends Value{
		String fieldName;
		Value from;
		FieldReference ref;
		
		public FieldValue(String fieldName, Value from){
			this.fieldName = fieldName;
			this.from = from;
			ref = from.type().fields().stream().filter(x -> x.name().equals(fieldName)).findFirst().orElseThrow(() -> new IllegalStateException("Could not find field of name " + fieldName + " in type " + from.type().fullyQualifiedName() + "!"));
		}
		
		public FieldValue(FieldReference ref){
			this.ref = ref;
		}
		
		public void write(MethodVisitor mv){
			if(from != null)
				from.write(mv);
			// implicit this when needed
			if(from == null && !ref.isStatic())
				mv.visitVarInsn(Opcodes.ALOAD, 0);
			ref.writeFetch(mv);
		}
		
		public TypeReference type(){
			return ref.type();
		}
	}
	
	public static class LocalVarValue extends Value{
		
		Variable local;
		
		public LocalVarValue(Variable local){
			this.local = local;
		}
		
		public void write(MethodVisitor mv){
			mv.visitVarInsn(type().localLoadOpcode(), local.getVarIndex());
		}
		
		public TypeReference type(){
			return local.type;
		}
	}
	
	public static class CallValue extends Value{
		Value on;
		List<Value> args;
		MethodReference target;
		
		public CallValue(Value on, List<Value> args, MethodReference target){
			this.on = on;
			this.args = args;
			this.target = target;
		}
		
		public void write(MethodVisitor mv){
			if(on != null)
				on.write(mv);
			// implicit this for instance method calls with no explicit value
			if(on == null && !target.isStatic())
				mv.visitVarInsn(Opcodes.ALOAD, 0);
			for(var v : args)
				v.write(mv);
			target.writeInvoke(mv);
		}
		
		public TypeReference type(){
			return target.returns();
		}
	}
	
	// could just use call values
	public static class UnboxValue extends Value{
		Value underlying;
		PrimitiveTypeRef.Primitive type;
		
		public UnboxValue(Value underlying, PrimitiveTypeRef.Primitive type){
			this.underlying = underlying;
			this.type = type;
		}
		
		public void write(MethodVisitor mv){
			underlying.write(mv); // is a boxed value
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, underlying.type().internalName(), type.name().toLowerCase() + "Value", "()" + PrimitiveTypeRef.getPrimitiveDesc(type), false);
		}
		
		public TypeReference type(){
			return new PrimitiveTypeRef(type);
		}
	}
	
	public static class BoxValue extends Value{
		Value underlying;
		TypeReference targetType; // e.g. java.lang.Integer
		
		public BoxValue(Value underlying, TypeReference targetType){
			this.underlying = underlying;
			this.targetType = targetType;
		}
		
		public void write(MethodVisitor mv){
			underlying.write(mv);
			mv.visitMethodInsn(Opcodes.INVOKESTATIC, targetType.internalName(), "valueOf", "(" + underlying.type().descriptor() + ")" + targetType.descriptor(), false);
		}
		
		public TypeReference type(){
			return targetType;
		}
	}
	
	public static class SubstituteTypeValue extends Value{
		TypeReference substitute;
		Value underlying;
		
		public SubstituteTypeValue(TypeReference substitute, Value underlying){
			this.substitute = substitute;
			this.underlying = underlying;
		}
		
		public void write(MethodVisitor mv){
			underlying.write(mv);
		}
		
		public TypeReference type(){
			return substitute;
		}
	}
	
	public static class ThisValue extends Value{
		TypeReference thisType;
		
		public ThisValue(TypeReference thisType){
			this.thisType = thisType;
		}
		
		public void write(MethodVisitor mv){
			mv.visitVarInsn(Opcodes.ALOAD, 0);
		}
		
		public TypeReference type(){
			return thisType;
		}
	}
	
	public static class InitializationValue extends Value{
		List<Value> args;
		CallableReference ctor;
		
		public InitializationValue(List<Value> args, CallableReference ctor){
			this.args = args;
			this.ctor = ctor;
		}
		
		public void write(MethodVisitor mv){
			// TODO: constructor overloading (this(...), super(...))
			mv.visitTypeInsn(Opcodes.NEW, ctor.in().internalName());
			mv.visitInsn(Opcodes.DUP);
			for(var v : args)
				v.write(mv);
			ctor.writeInvoke(mv);
		}
		
		public TypeReference type(){
			return ctor.in();
		}
	}
}