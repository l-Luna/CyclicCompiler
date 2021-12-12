package cyclic.lang.compiler.model.platform;

import cyclic.lang.compiler.model.*;

import java.util.Collections;
import java.util.List;

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
		return switch(type){
			case BYTE -> "B";
			case SHORT -> "S";
			case INT -> "I";
			case CHAR -> "C";
			case BOOLEAN -> "Z";
			case LONG -> "J";
			case FLOAT -> "F";
			case DOUBLE -> "D";
			case VOID, NULL -> "V";
		};
	}
}
