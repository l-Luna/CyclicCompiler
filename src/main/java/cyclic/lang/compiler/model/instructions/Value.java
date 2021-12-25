package cyclic.lang.compiler.model.instructions;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.gen.Operations;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.List;

public abstract class Value{
	
	public static Value fromAst(CyclicLangParser.ValueContext ctx, Scope scope, CyclicType type, CallableReference method){
		CompileTimeException.pushContext(ctx);
		
		Value result = null;
		if(ctx instanceof CyclicLangParser.NullLitContext){
			result = new NullLiteralValue();
		}else if(ctx instanceof CyclicLangParser.IntLitContext intLit){
			String text = intLit.INTLIT().getText();
			if(text.endsWith("f")){
				result = new FloatLiteralValue(Float.parseFloat(text));
			}else if(text.endsWith("d")){
				result = new DoubleLiteralValue(Double.parseDouble(text));
			}else{
				result = new IntLiteralValue(Integer.parseInt(text));
			}
		}else if(ctx instanceof CyclicLangParser.DecLitContext decLit){
			String text = decLit.DECLIT().getText();
			if(text.endsWith("f")){
				result = new FloatLiteralValue(Float.parseFloat(text));
			}else{
				result = new DoubleLiteralValue(Double.parseDouble(text));
			}
		}else if(ctx instanceof CyclicLangParser.BoolLitContext boolLit){
			result = new IntLiteralValue(boolLit.getText().equals("true") ? 1 : 0, true);
		}else if(ctx instanceof CyclicLangParser.StrLitContext strLit){
			String text = strLit.getText();
			result = new StringLiteralValue(text.substring(1, text.length() - 1));
		}else if(ctx instanceof CyclicLangParser.VarValueContext val){
			String name = val.ID().getText();
			// if a value is present, check if it's a partial type name, and add to it if so; otherwise return a field
			if(val.value() != null){
				Value on = fromAst(val.value(), scope, type, method);
				if(on instanceof TypeValue v && v.getPartialTypeName() != null){
					var newTypeName = v.getPartialTypeName() + "." + name;
					var target = TypeResolver.resolveOptional(newTypeName, type.imports, type.packageName());
					result = target.map(TypeValue::new).orElseGet(() -> new TypeValue(newTypeName));
				}else{
					result = new FieldValue(name, on);
				}
			}else{// otherwise, it could be a local variable,
				Variable local = scope.get(name);
				if(local != null)
					result = new LocalVarValue(local);
				else{// or a static field of the current type, or an instance field of the current type for a non-static method
					for(var field : method.in().fields())
						if(field.name().equals(name) && (field.isStatic() || !method.isStatic())){
							result = new FieldValue(field);
							break;
						}
					if(result == null){// or a partial or full type name
						var target = TypeResolver.resolveOptional(name, type.imports, type.packageName());
						result = target.map(TypeValue::new).orElseGet(() -> new TypeValue(name));
					}
				}
			}
		}else if(ctx instanceof CyclicLangParser.FunctionValueContext func){
			Value on = func.value() != null ? Value.fromAst(func.value(), scope, type, method) : null;
			List<Value> args = func.call().arguments().value().stream().map(x -> Value.fromAst(x, scope, type, method)).toList();
			result = new CallValue(on, args, Utils.resolveMethod(func.call().ID().getText(), on, args, method));
		}else if(ctx instanceof CyclicLangParser.InitialisationValueContext init){
			List<Value> args = init.initialisation().arguments().value().stream().map(x -> Value.fromAst(x, scope, type, method)).toList();
			TypeReference of = TypeResolver.resolve(init.initialisation().type().getText(), type.imports, type.packageName());
			result = new InitializationValue(args, Utils.resolveConstructor(of, args, method));
		}else if(ctx instanceof CyclicLangParser.BinaryOpValueContext bin){
			Value left = Value.fromAst(bin.left, scope, type, method);
			Value right = Value.fromAst(bin.right, scope, type, method);
			result = Operations.resolveBinary(bin.binaryop().getText(), left, right);
		}else if(ctx instanceof CyclicLangParser.UnaryOpValueContext uop){
			result = Operations.resolveUnary(uop.unaryop().getText(), fromAst(uop.value(), scope, type, method));
		}else if(ctx instanceof CyclicLangParser.ParenValueContext paren){
			result = fromAst(paren.value(), scope, type, method);
		}else if(ctx instanceof CyclicLangParser.ThisValueContext){
			if(method.isStatic())
				throw new CompileTimeException("Can't use \"this\" in a static method!");
			result = new ThisValue(method.in());
		}else if(ctx instanceof CyclicLangParser.ClassValueContext clss){
			// TODO: generics
			result = new ClassValue(TypeResolver.resolve(clss.id().getText(), type.imports, type.packageName()));
		}else if(ctx instanceof CyclicLangParser.InstanceCheckValueContext inst){
			var check = new InstanceofValue(TypeResolver.resolve(inst.type().getText(), type.imports, type.packageName()), fromAst(inst.value(), scope, type, method));
			result = inst.EXCLAMATION() != null ? new Operations.BranchBoolBinaryOpValue(TypeResolver.resolve("boolean"), Opcodes.IFEQ, check, null) : check;
		}else if(ctx instanceof CyclicLangParser.CastValueContext castCtx){
			TypeReference target = TypeResolver.resolve(castCtx.cast().type().getText(), type.imports, type.packageName());
			Value casting = fromAst(castCtx.cast().value(), scope, type, method);
			// if it fits, just pass it along
			var fit = casting.fit(target);
			if(fit != null){
				result = fit;
			}else if(target instanceof PrimitiveTypeRef p){
				if(p.type == PrimitiveTypeRef.Primitive.NULL){
					result = casting;
				}else if(casting.type() instanceof PrimitiveTypeRef c){
					if(c.narrowingOpcodes(p.type) == null)
						throw new CompileTimeException("Cannot convert value of type " + c.type + " to " + p.type);
					else{
						result = new PrimitiveCastValue(casting, p.type);
					}
				}else
					throw new CompileTimeException("Cannot convert non-primitive value of type " + casting.type().fullyQualifiedName() + " to primitive type " + p.type);
			}else if(casting.type() instanceof PrimitiveTypeRef p)
				throw new CompileTimeException("Cannot convert primitive value of type " + p.type + " to non-primitive type " + target.fullyQualifiedName());
			else{
				result = new ClassCastValue(casting, target);
			}
		}else if(ctx instanceof CyclicLangParser.ArrayIndexValueContext ind){
			result = new ArrayIndexValue(fromAst(ind.array, scope, type, method), fromAst(ind.index, scope, type, method));
		}else if(ctx instanceof CyclicLangParser.NewArrayValueContext array){
			TypeReference component = TypeResolver.resolve(array.newArray().type().getText(), type.imports, type.packageName());
			Value length = fromAst(array.newArray().value(), scope, type, method);
			if(component instanceof PrimitiveTypeRef p)
				result = new NewPrimitiveArrayValue(p, length);
			else
				result = new NewArrayValue(component, length);
		}else if(ctx instanceof CyclicLangParser.NewListedArrayValueContext array){
			TypeReference component = TypeResolver.resolve(array.newListedArray().type().getText(), type.imports, type.packageName());
			List<Value> entries = array.newListedArray().value().stream().map(k -> fromAst(k, scope, type, method)).toList();
			Value length = new IntLiteralValue(entries.size());
			Value arrayValue;
			if(component instanceof PrimitiveTypeRef p)
				arrayValue = new NewPrimitiveArrayValue(p, length);
			else
				arrayValue = new NewArrayValue(component, length);
			result = new NewListedArrayValue(arrayValue, entries, (ArrayTypeRef)arrayValue.type());
		}
		
		CompileTimeException.popContext();
		return result;
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
		if(target instanceof PrimitiveTypeRef prim)
			if(type().fullyQualifiedName().equals(prim.boxedTypeName()))
				ret = new UnboxValue(this, prim.type);
			else
				ret = new TryUnboxValue(this, prim.type);
		
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
		
		// make sure that changes here are mirrored in InitializationValue
		// and CallStatement
		public void write(MethodVisitor mv){
			if(on != null)
				on.write(mv);
			// implicit this for instance method calls with no explicit value
			if(on == null && !target.isStatic())
				mv.visitVarInsn(Opcodes.ALOAD, 0);
			for(int i = 0; i < args.size(); i++){
				Value v = args.get(i);
				v.fit(target.parameters().get(i)).write(mv);
			}
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
	
	// when casting an unknown value to a primitive
	public static class TryUnboxValue extends Value{
		Value underlying;
		PrimitiveTypeRef.Primitive type;
		
		public TryUnboxValue(Value underlying, PrimitiveTypeRef.Primitive type){
			this.underlying = underlying;
			this.type = type;
		}
		
		public void write(MethodVisitor mv){
			underlying.write(mv); // is a boxed value
			String box = PrimitiveTypeRef.boxedTypeName(type).replace('.', '/');
			mv.visitTypeInsn(Opcodes.CHECKCAST, box);
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, box, type.name().toLowerCase() + "Value", "()" + PrimitiveTypeRef.getPrimitiveDesc(type), false);
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
			for(int i = 0; i < args.size(); i++){
				Value v = args.get(i);
				v.fit(ctor.parameters().get(i)).write(mv);
			}
			ctor.writeInvoke(mv);
		}
		
		public TypeReference type(){
			return ctor.in();
		}
	}
	
	public static class ClassValue extends Value{
		private TypeReference of;
		
		public ClassValue(TypeReference of){
			this.of = of;
		}
		
		public void write(MethodVisitor mv){
			mv.visitLdcInsn(Type.getType(of.descriptor()));
		}
		
		public TypeReference type(){
			// TODO: generics
			return TypeResolver.resolve("java.lang.Class");
		}
	}
	
	public static class InstanceofValue extends Value{
		private TypeReference target;
		Value checking;
		
		public InstanceofValue(TypeReference target, Value checking){
			this.target = target;
			this.checking = checking;
		}
		
		public void write(MethodVisitor mv){
			checking.write(mv);
			mv.visitTypeInsn(Opcodes.INSTANCEOF, target.internalName());
		}
		
		public TypeReference type(){
			return TypeResolver.resolve("boolean");
		}
	}
	
	public static class PrimitiveCastValue extends Value{
		Value casting;
		PrimitiveTypeRef.Primitive to;
		
		public PrimitiveCastValue(Value casting, PrimitiveTypeRef.Primitive to){
			this.casting = casting;
			this.to = to;
		}
		
		public void write(MethodVisitor mv){
			casting.write(mv);
			if(casting.type() instanceof PrimitiveTypeRef from){
				List<Integer> opcodes = from.narrowingOpcodes(to);
				if(opcodes == null)
					throw new IllegalStateException("Can't convert from " + from.type + " to " + to + " by narrowing!");
				for(var op : opcodes)
					mv.visitInsn(op);
			}
		}
		
		public TypeReference type(){
			return new PrimitiveTypeRef(to);
		}
	}
	
	public static class ClassCastValue extends Value{
		Value casting;
		TypeReference target;
		
		public ClassCastValue(Value casting, TypeReference target){
			this.casting = casting;
			this.target = target;
		}
		
		public void write(MethodVisitor mv){
			casting.write(mv);
			mv.visitTypeInsn(Opcodes.CHECKCAST, target.internalName());
		}
		
		public TypeReference type(){
			return target;
		}
	}
	
	public static class ArrayIndexValue extends Value{
		Value array, index;
		ArrayTypeRef arrayType;
		
		public ArrayIndexValue(Value array, Value index){
			this.array = array;
			this.index = index.fit(TypeResolver.resolve("int"));
			if(this.index == null){
				throw new IllegalStateException("Cannot index an array using an index of type " + index.type().fullyQualifiedName() + ", which cannot be fit to an integer!");
			}
			if(array.type() instanceof ArrayTypeRef a)
				arrayType = a;
			else
				throw new IllegalStateException("Tried to index a value of type " + array.type().fullyQualifiedName() + ", which is not an array!");
		}
		
		public void write(MethodVisitor mv){
			array.write(mv);
			index.write(mv);
			mv.visitInsn(arrayType.getComponent().arrayLoadOpcode());
		}
		
		public TypeReference type(){
			return arrayType.getComponent();
		}
	}
	
	public static class NewArrayValue extends Value{
		TypeReference componentType;
		Value length;
		
		public NewArrayValue(TypeReference componentType, Value length){
			this.componentType = componentType;
			this.length = length;
		}
		
		public void write(MethodVisitor mv){
			length.write(mv);
			mv.visitTypeInsn(Opcodes.ANEWARRAY, componentType.internalName());
		}
		
		public TypeReference type(){
			return new ArrayTypeRef(componentType);
		}
	}
	
	public static class NewPrimitiveArrayValue extends Value{
		PrimitiveTypeRef componentType;
		Value length;
		
		public NewPrimitiveArrayValue(PrimitiveTypeRef componentType, Value length){
			this.componentType = componentType;
			this.length = length;
		}
		
		public void write(MethodVisitor mv){
			length.write(mv);
			mv.visitIntInsn(Opcodes.NEWARRAY, componentType.arrayTypeCode());
		}
		
		public TypeReference type(){
			return new ArrayTypeRef(componentType);
		}
	}
	
	public static class NewListedArrayValue extends Value{
		Value array;
		List<Value> entries;
		ArrayTypeRef arrayType;
		
		public NewListedArrayValue(Value array, List<Value> entries, ArrayTypeRef arrayType){
			this.array = array;
			this.entries = entries;
			this.arrayType = arrayType;
		}
		
		public void write(MethodVisitor mv){
			array.write(mv);
			for(int i = 0; i < entries.size(); i++){
				Value e = entries.get(i);
				mv.visitInsn(Opcodes.DUP);
				new IntLiteralValue(i).write(mv);
				e.write(mv);
				mv.visitInsn(arrayType.getComponent().arrayStoreOpcode());
			}
		}
		
		public TypeReference type(){
			return arrayType;
		}
	}
}