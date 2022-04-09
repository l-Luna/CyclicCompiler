package cyclic.lang.compiler.configuration;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.resolve.TypeResolver;

import java.io.Closeable;
import java.io.IOException;
import java.util.Optional;

/**
 * A dependency represents a provider of types and symbols that can be looked up via
 * {@linkplain TypeResolver}.
 *
 * @see TypeResolver
 * @see cyclic.lang.compiler.model.TypeReference
 */
public interface Dependency extends Closeable{
	
	/**
	 * Tries to find a type with the given fully qualified name, returning it contained within an optional
	 * or {@linkplain Optional#empty()} if it does not exist within this dependency.
	 *
	 * @param fullyQualifiedName
	 * 		The fully qualified name of the type to find.
	 * @return A type with the given fully qualified name if it exists within this dependency.
	 */
	Optional<TypeReference> find(String fullyQualifiedName);
	
	/**
	 * Closes this dependency and releases any resources associated with it.
	 * Most dependencies will not need to implement this method.
	 */
	default void close() throws IOException{}
	
	/**
	 * Resolves initial references in types within this dependency to other types, which may be in other dependencies.
	 */
	default void resolveRefs(){}
	
	/**
	 * Resolves complex references in types within this dependency to other types, which may be in other dependencies,
	 * such as inherited members.
	 * <p/>This method must be called after {@link #resolveRefs()} has been called.
	 */
	default void resolveInheritance(){}
}