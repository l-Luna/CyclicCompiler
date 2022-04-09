package cyclic.lang.compiler.configuration.dependencies;

import cyclic.lang.compiler.configuration.Dependency;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.external.ClassfileTypeRef;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Base class for dependencies that use compiled classfiles.
 */
public abstract class CompiledDependency implements Dependency{
	
	private Map<String, TypeReference> types;
	
	protected void loadTypes(){
		types = getClasses().stream()
				.map(ClassfileTypeRef::new)
				.collect(Collectors.toMap(TypeReference::fullyQualifiedName, y -> y));
	}
	
	protected abstract List<byte[]> getClasses();
	
	public Optional<TypeReference> find(String fullyQualifiedName){
		return Optional.ofNullable(types.get(fullyQualifiedName));
	}
	
	public void resolveRefs(){
		types.values().forEach(TypeReference::resolveRefs);
	}
	
	public void resolveInheritance(){
		types.values().forEach(TypeReference::resolveInheritance);
	}
}