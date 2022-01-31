package cyclic.lang.compiler.model.platform;

import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.objectweb.asm.Opcodes;

import java.util.Collections;
import java.util.List;

import static cyclic.lang.compiler.model.platform.PrimitiveTypeRef.Primitive.*;

public class PrimitiveTypeRef implements TypeReference{
	
	// int, (boolean), long, float, double, char, void, (null)
	public Primitive type;
	
	public PrimitiveTypeRef(Primitive type){
		this.type = type;
	}
	
	public enum Primitive{
		BYTE, SHORT, INT, BOOLEAN, LONG, FLOAT, DOUBLE, CHAR, VOID, NULL;
	}
	
	public String shortName(){
		return type.name().toLowerCase();
	}
	
	public String packageName(){
		return "";
	}
	
	public String internalName(){
		return shortName();
	}
	
	public TypeKind kind(){
		return TypeKind.CONSTRUCTED;
	}
	
	public AccessFlags flags(){
		return new AccessFlags(Visibility.PUBLIC, false, true);
	}
	
	public TypeReference outerClass(){
		return null;
	}
	
	public TypeReference superClass(){
		return null;
	}
	
	public List<? extends TypeReference> superInterfaces(){
		return Collections.emptyList();
	}
	
	public List<? extends TypeReference> innerClasses(){
		return Collections.emptyList();
	}
	
	public List<? extends MethodReference> methods(){
		return Collections.emptyList();
	}
	
	public List<? extends FieldReference> fields(){
		return Collections.emptyList();
	}
	
	public List<? extends CallableReference> constructors(){
		return Collections.emptyList();
	}
	
	public String descriptor(){
		return getPrimitiveDesc(type);
	}
	
	public boolean isAssignableTo(TypeReference target){
		if(type == NULL) // null is assignable to any non-primitive type
			return !(target instanceof PrimitiveTypeRef other) || other.type == NULL;
		return fullyQualifiedName().equals(target.fullyQualifiedName());
	}
	
	public static String getPrimitiveDesc(String name){
		return switch(name){
			case "boolean" -> "Z";
			case "byte" -> "B";
			case "short" -> "S";
			case "int" -> "I";
			case "char" -> "C";
			case "long" -> "J";
			case "float" -> "F";
			case "double" -> "D";
			case "void" -> "V";
			default -> throw new IllegalArgumentException();
		};
	}
	
	public static String getPrimitiveDesc(Primitive type){
		return switch(type){
			case BOOLEAN -> "Z";
			case BYTE -> "B";
			case SHORT -> "S";
			case INT -> "I";
			case CHAR -> "C";
			case LONG -> "J";
			case FLOAT -> "F";
			case DOUBLE -> "D";
			case NULL -> "Ljava/lang/Object;";
			case VOID -> "V";
		};
	}
	
	public int localLoadOpcode(){
		return switch(type){
			case NULL -> Opcodes.ALOAD;
			case BYTE, BOOLEAN, CHAR, SHORT, INT -> Opcodes.ILOAD;
			case LONG -> Opcodes.LLOAD;
			case FLOAT -> Opcodes.FLOAD;
			case DOUBLE -> Opcodes.DLOAD;
			case VOID -> throw new IllegalStateException("Trying to load from a void local variable!");
		};
	}
	
	public int localStoreOpcode(){
		return switch(type){
			case NULL -> Opcodes.ASTORE;
			case BYTE, BOOLEAN, CHAR, SHORT, INT -> Opcodes.ISTORE;
			case LONG -> Opcodes.LSTORE;
			case FLOAT -> Opcodes.FSTORE;
			case DOUBLE -> Opcodes.DSTORE;
			case VOID -> throw new IllegalStateException("Trying to store a void value in a local variable!");
		};
	}
	
	public int arrayLoadOpcode(){
		return switch(type){
			case NULL -> Opcodes.AALOAD;
			case BYTE, BOOLEAN -> Opcodes.BALOAD;
			case INT -> Opcodes.IALOAD;
			case SHORT -> Opcodes.SALOAD;
			case CHAR -> Opcodes.CALOAD;
			case LONG -> Opcodes.LALOAD;
			case FLOAT -> Opcodes.FALOAD;
			case DOUBLE -> Opcodes.DALOAD;
			case VOID -> throw new IllegalStateException("Trying to load from a void array!");
		};
	}
	
	public int arrayStoreOpcode(){
		return switch(type){
			case NULL -> Opcodes.AASTORE;
			case BYTE, BOOLEAN -> Opcodes.BASTORE;
			case CHAR, SHORT, INT -> Opcodes.IASTORE;
			case LONG -> Opcodes.LASTORE;
			case FLOAT -> Opcodes.FASTORE;
			case DOUBLE -> Opcodes.DASTORE;
			case VOID -> throw new IllegalStateException("Trying to store a void value in an array!");
		};
	}
	
	public int returnOpcode(){
		return switch(type){
			case NULL -> Opcodes.ARETURN;
			case BYTE, BOOLEAN, CHAR, SHORT, INT -> Opcodes.IRETURN;
			case LONG -> Opcodes.LRETURN;
			case FLOAT -> Opcodes.FRETURN;
			case DOUBLE -> Opcodes.DRETURN;
			case VOID -> Opcodes.RETURN;
		};
	}
	
	public String boxedTypeName(){
		return boxedTypeName(type);
	}
	
	public static String boxedTypeName(Primitive type){
		return switch(type){
			case NULL, VOID -> "java.lang.Object";
			case BOOLEAN -> "java.lang.Boolean";
			case CHAR -> "java.lang.Character";
			case SHORT -> "java.lang.Short";
			case INT -> "java.lang.Integer";
			case BYTE -> "java.lang.Byte";
			case LONG -> "java.lang.Long";
			case FLOAT -> "java.lang.Float";
			case DOUBLE -> "java.lang.Double";
		};
	}
	
	public TypeReference boxedType(){
		return TypeResolver.resolveFqOptional(boxedTypeName()).orElseThrow(() -> new IllegalStateException("Could not resolve box type " + boxedTypeName() + " for boxing conversions!"));
	}
	
	// -1 for incompatible primitives, 0 for no-op conversions, or the conversion opcode for compatible types
	public int wideningOpcode(Primitive target){
		return switch(type){
			case BYTE -> {
				if(target == SHORT || target == INT)
					yield 0;
				else if(target == LONG)
					yield Opcodes.I2L;
				else if(target == FLOAT)
					yield Opcodes.I2F;
				else if(target == DOUBLE)
					yield Opcodes.I2D;
				yield -1;
			}
			case SHORT, CHAR -> {
				if(target == INT)
					yield 0;
				else if(target == LONG)
					yield Opcodes.I2L;
				else if(target == FLOAT)
					yield Opcodes.I2F;
				else if(target == DOUBLE)
					yield Opcodes.I2D;
				yield -1;
			}
			case INT -> {
				if(target == LONG)
					yield Opcodes.I2L;
				else if(target == FLOAT)
					yield Opcodes.I2F;
				else if(target == DOUBLE)
					yield Opcodes.I2D;
				yield -1;
			}
			case BOOLEAN, VOID, NULL, DOUBLE -> -1;
			case LONG -> {
				if(target == FLOAT)
					yield Opcodes.L2F;
				else if(target == DOUBLE)
					yield Opcodes.L2D;
				yield -1;
			}
			case FLOAT -> {
				if(target == DOUBLE)
					yield Opcodes.F2D;
				yield -1;
			}
		};
	}
	
	public boolean isNumber(){
		return type == BYTE || type == SHORT || type == INT || type == LONG || type == FLOAT || type == DOUBLE;
	}
	
	// empty list for free conversions, null for incompatible conversions, or a list of opcodes to convert types
	public List<Integer> narrowingOpcodes(Primitive target){
		switch(type){
			case SHORT -> {
				if(target == BYTE)
					return List.of(Opcodes.I2B);
				else if(target == CHAR)
					return List.of(Opcodes.I2C);
			}
			case INT -> {
				if(target == BYTE)
					return List.of(Opcodes.I2B);
				else if(target == CHAR)
					return List.of(Opcodes.I2C);
				else if(target == SHORT)
					return List.of(Opcodes.I2S);
			}
			case BOOLEAN, NULL, VOID -> {
				// NULL to non-primitive conversion is handled in CastValue
				return null;
			}
			case LONG -> {
				if(target == BYTE)
					return List.of(Opcodes.L2I, Opcodes.I2B);
				else if(target == CHAR)
					return List.of(Opcodes.L2I, Opcodes.I2C);
				else if(target == SHORT)
					return List.of(Opcodes.L2I, Opcodes.I2S);
				else if(target == INT)
					return List.of(Opcodes.L2I);
			}
			case FLOAT -> {
				if(target == BYTE)
					return List.of(Opcodes.F2I, Opcodes.I2B);
				else if(target == CHAR)
					return List.of(Opcodes.F2I, Opcodes.I2C);
				else if(target == SHORT)
					return List.of(Opcodes.F2I, Opcodes.I2S);
				else if(target == INT)
					return List.of(Opcodes.F2I);
				else if(target == LONG)
					return List.of(Opcodes.F2L);
			}
			case DOUBLE -> {
				if(target == BYTE)
					return List.of(Opcodes.D2I, Opcodes.I2B);
				else if(target == CHAR)
					return List.of(Opcodes.D2I, Opcodes.I2C);
				else if(target == SHORT)
					return List.of(Opcodes.D2I, Opcodes.I2S);
				else if(target == INT)
					return List.of(Opcodes.D2I);
				else if(target == LONG)
					return List.of(Opcodes.D2L);
				else if(target == FLOAT)
					return List.of(Opcodes.D2F);
			}
			case CHAR -> {
				if(target == BYTE)
					return List.of(Opcodes.I2B);
				else if(target == SHORT)
					return List.of(Opcodes.I2S);
			}
		}
		return null;
	}
	
	public int arrayTypeCode(){
		return switch(type){
			case BYTE -> Opcodes.T_BYTE;
			case SHORT -> Opcodes.T_SHORT;
			case INT -> Opcodes.T_INT;
			case BOOLEAN -> Opcodes.T_BOOLEAN;
			case LONG -> Opcodes.T_LONG;
			case FLOAT -> Opcodes.T_FLOAT;
			case DOUBLE -> Opcodes.T_DOUBLE;
			case CHAR -> Opcodes.T_CHAR;
			case VOID, NULL -> throw new IllegalStateException();
		};
	}
	
	// don't hardcode this here, it's technically valid to have another impl of this
	public boolean equals(Object o){
		return o instanceof TypeReference t && t.fullyQualifiedName().equals(fullyQualifiedName());
	}
	
	public int hashCode(){
		return fullyQualifiedName().hashCode();
	}
}