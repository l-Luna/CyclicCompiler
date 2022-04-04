package cyclic.lang.compiler.model;

/**
 * Represents a constant value of an enum type.
 */
public record EnumConstant(TypeReference enumType, String name){
	
	public EnumConstant(FieldReference reference){
		this(reference.type(), reference.name());
	}
}