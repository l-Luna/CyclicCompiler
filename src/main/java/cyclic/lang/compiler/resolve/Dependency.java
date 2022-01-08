package cyclic.lang.compiler.resolve;

import cyclic.lang.compiler.model.TypeReference;

import java.util.Optional;

/**
 * A dependency represents a provider of types and symbols that can be looked up via
 * {@linkplain TypeResolverOld}.
 *
 * @see TypeResolverOld
 * @see cyclic.lang.compiler.model.TypeReference
 */
public interface Dependency{
	
	/**
	 * Tries to find a type with the given fully qualified name, returning it contained within an optional
	 * or {@linkplain Optional#empty()} if it does not exist within this dependency.
	 *
	 * @param fullyQualifiedName
	 * 		The fully qualified name of the type to find.
	 * @return A type with the given fully qualified name if it exists within this dependency.
	 */
	Optional<TypeReference> find(String fullyQualifiedName);
}