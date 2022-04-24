package cyclic.lang.compiler.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a declaration that may have type parameters.
 *
 * @see TypeReference
 */
public interface GenericElement{
	
	/**
	 * If this is a raw generic declaration, returns the list of type parameters.
	 * <p>Otherwise, returns an empty list. This includes non-generic declarations and parameterized declarations.
	 *
	 * @return The list of type parameters.
	 */
	default List<? extends TypeParameterReference> typeParameters(){
		return List.of();
	}
	
	default String genericSummary(){
		if(!typeParameters().isEmpty()){
			return "<" +
					typeParameters().stream()
					.map(TypeParameterReference::summary)
					.collect(Collectors.joining(", ")) +
					">";
		}
		return "";
	}
}