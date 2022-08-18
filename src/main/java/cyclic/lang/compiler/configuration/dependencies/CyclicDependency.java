package cyclic.lang.compiler.configuration.dependencies;

import cyclic.lang.compiler.configuration.Dependency;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.cyclic.CyclicType;

import java.util.Optional;

import static cyclic.lang.compiler.CompilerLauncher.toCompile;

/**
 * Provides the types currently being compiled.
 */
public final class CyclicDependency implements Dependency{
	
	public Optional<TypeReference> find(String fqName){
		return Optional.ofNullable(toCompile.get(fqName));
	}
	
	public void resolveRefs(){
		toCompile.values().parallelStream().forEach(CyclicType::resolveRefs);
	}
	
	public void resolveInheritance(){
		toCompile.values().parallelStream().forEach(CyclicType::resolveInheritance);
	}
}