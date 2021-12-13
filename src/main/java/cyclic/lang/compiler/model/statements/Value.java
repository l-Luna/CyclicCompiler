package cyclic.lang.compiler.model.statements;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

public abstract class Value{
	
	public static Value fromAst(CyclicLangParser.ValueContext ctx, List<String> imports, CyclicMethod method){
		if(ctx instanceof CyclicLangParser.NullLitContext)
			return new NullLiteralValue();
		if(ctx instanceof CyclicLangParser.IntLitContext intLit)
			return new IntLiteralValue(Integer.parseInt(intLit.INTLIT().getText()));
		if(ctx instanceof CyclicLangParser.DecLitContext decLit)
			return new DecimalLiteralValue(Double.parseDouble(decLit.DECLIT().getText()));
		if(ctx instanceof CyclicLangParser.BoolLitContext boolLit)
			return new IntLiteralValue(boolLit.getText().equals("true") ? 1 : 0);
		if(ctx instanceof CyclicLangParser.StrLitContext strLit){
			String text = strLit.getText();
			return new StringLiteralValue(text.substring(1, text.length() - 1));
		}
		if(ctx instanceof CyclicLangParser.TypeValueContext type){
			String text = type.id().getText();
			return new TypeValue(TypeResolver.resolve(text, imports));
		}
		if(ctx instanceof CyclicLangParser.VarValueContext val){
			// if a value is present, it's a field value
			if(val.value() != null)
				return new FieldValue(val.ID().getText(), fromAst(val.value(), imports, method));
			// otherwise, it could be a local variable, or a static field of the current type,
			// or an instance field of the current type for a non-static method
		}
		if(ctx instanceof CyclicLangParser.FunctionValueContext func){
			Value on = func.value() != null ? Value.fromAst(func.value(), imports, method) : null;
			List<Value> args = func.call().arguments().value().stream().map(x -> Value.fromAst(x, imports, method)).toList();
			return new CallValue(on, args, Utils.resolveMethod(func.call().ID().getText(), on, args, method));
		}
		System.out.println("Unknown expression " + ctx.getText());
		return null;
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
	
	public static class IntLiteralValue extends Value{
		
		int value;
		
		public IntLiteralValue(int value){
			this.value = value;
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
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.INT);
		}
	}
	
	public static class DecimalLiteralValue extends Value{
		
		double value;
		
		public DecimalLiteralValue(double value){
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
		
		public TypeValue(TypeReference target){
			this.target = target;
		}
		
		public void write(MethodVisitor mv){
			// TODO: check for singleton types
			throw new IllegalStateException("Tried to write the value of a non-singleton type!");
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
			ref = from.type().fields().stream().filter(x -> x.name().equals(fieldName)).findFirst().orElseThrow();
		}
		
		public void write(MethodVisitor mv){
			// TODO: consider singletons
			if(!(from instanceof TypeValue))
				from.write(mv);
			ref.writeFetch(mv);
		}
		
		public TypeReference type(){
			return ref.type();
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
			if(on != null && !(on instanceof Value.TypeValue)) // TODO: consider singletons
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
}