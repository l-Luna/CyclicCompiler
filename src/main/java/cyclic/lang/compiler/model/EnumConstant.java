package cyclic.lang.compiler.model;

/**
 * Represents an enum constant.
 */
public record EnumConstant(TypeReference enumType, String name){
	public EnumConstant(FieldReference reference){
		this(reference.type(), reference.name());
	}
}