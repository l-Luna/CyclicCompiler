package cyclic.lang.compiler.model.platform;

import cyclic.lang.compiler.model.*;
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
		BYTE, SHORT, INT, BOOLEAN, LONG, FLOAT, DOUBLE, CHAR, VOID, NULL
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
		return null; // TODO: autoboxing
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
	
	public List<? extends ConstructorReference> constructors(){
		return Collections.emptyList();
	}
	
	public String descriptor(){
		return getPrimitiveDesc(type);
	}
	
	public static String getPrimitiveDesc(Primitive type){
		return switch(type){
			case BYTE -> "B";
			case SHORT -> "S";
			case INT -> "I";
			case CHAR -> "C";
			case BOOLEAN -> "Z";
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
	
	private static String boxedTypeName(Primitive type){
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
		return TypeResolver.resolveOptional(boxedTypeName()).orElseThrow(() -> new IllegalStateException("Could not resolve box type " + boxedTypeName() + " for boxing conversions!"));
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
}