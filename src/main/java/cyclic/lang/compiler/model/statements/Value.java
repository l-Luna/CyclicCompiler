package cyclic.lang.compiler.model.statements;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.TypeResolver;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

public abstract class Value{
	
	public static Value fromAst(CyclicLangParser.ValueContext ctx, List<String> imports){
		if(ctx instanceof CyclicLangParser.NullLitContext)
			return new NullLiteralValue();
		if(ctx instanceof CyclicLangParser.IntLitContext intLit)
			return new IntLiteralValue(Integer.parseInt(intLit.INTLIT().getText()));
		if(ctx instanceof CyclicLangParser.DecLitContext decLit)
			return new DecimalLiteralValue(Double.parseDouble(decLit.DECLIT().getText()));
		if(ctx instanceof CyclicLangParser.BoolLitContext boolLit)
			return new IntLiteralValue(boolLit.getText().equals("true") ? 1 : 0);
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
			return TypeResolver.resolve("java.lang.String").orElseThrow(() -> new IllegalStateException("Couldn't resolve java.lang.String for string constant!"));
		}
	}
}