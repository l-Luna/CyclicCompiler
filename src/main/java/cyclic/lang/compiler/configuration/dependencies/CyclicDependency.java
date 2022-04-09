package cyclic.lang.compiler.configuration.dependencies;

import cyclic.lang.compiler.CompilerLauncher;
import cyclic.lang.compiler.configuration.Dependency;
import cyclic.lang.compiler.model.TypeReference;

import java.util.Optional;

/**
 * Provides the types currently being compiled.
 */
public final class CyclicDependency implements Dependency{
	
	public Optional<TypeReference> find(String fqName){
		return Optional.ofNullable(CompilerLauncher.toCompile.get(fqName));
	}
}