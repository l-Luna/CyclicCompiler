package cyclic.lang.compiler.resolve;

import cyclic.lang.compiler.Compiler;
import cyclic.lang.compiler.model.TypeReference;

import java.util.Optional;

/**
 * Implements {@linkplain Dependency} for Cyclic types currently being compiled.
 */
public class CyclicDependency implements Dependency{
	
	public Optional<TypeReference> find(String fqName){
		return Optional.ofNullable(Compiler.toCompile.get(fqName));
	}
}