package cyclic.lang.compiler.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a declaration that may have type parameters.
 *
 * @see TypeReference
 */
public interface GenericElement<Self extends GenericElement<Self>>{
	
	/**
	 * If this is a raw generic declaration, returns the list of type parameters.
	 * <p>Otherwise, returns an empty list. This includes non-generic declarations and parameterized declarations.
	 *
	 * @return The list of type parameters.
	 */
	default List<? extends TypeParameterReference> typeParameters(){
		return List.of();
	}
	
	/**
	 * If this is a generic declaration with type parameters, returns the erasure of this declaration.
	 * Otherwise, returns this.
	 *
	 * @return The erasure of this declaration.
	 */
	@SuppressWarnings("unchecked")
	default Self erasure(){
		return (Self)this;
	}
	
	/**
	 * Returns true if all types named by this declaration are concrete types.
	 * <p>Type parameters are not concrete. Any type that names a non-concrete type is also not concrete.
	 * <p>A type names itself and its type arguments; a method names its parameters, return type, and any other
	 * type arguments.
	 *
	 * @return True if all type arguments are concrete types.
	 */
	default boolean isConcrete(){
		return true;
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