package cyclic.lang.compiler.configuration;

import cyclic.lang.compiler.configuration.dependencies.CompiledClassesDependency;
import cyclic.lang.compiler.configuration.dependencies.JarDependency;
import cyclic.lang.compiler.configuration.dependencies.SourceFolderDependency;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public final class Dependencies{
	
	public static final Map<String, BiFunction<CyclicPackage, CyclicProject, Dependency>> TYPES = new HashMap<>();
	
	static{
		TYPES.put("jar", (dep, project) -> new JarDependency(project.fileFromRoot(dep.location)));
		TYPES.put("classFolder", (dep, project) -> new CompiledClassesDependency(project.fileFromRoot(dep.location)));
		TYPES.put("sourceFolder", (dep, project) -> new SourceFolderDependency(project.fileFromRoot(dep.location)));
		// TODO: jmod dependencies for other JDKs; mavenJar, ghReleasesJar
	}
	
	public static Dependency create(CyclicPackage dep, CyclicProject project){
		var function = TYPES.get(dep.type);
		if(function == null)
			throw new IllegalArgumentException("Unknown dependency type: \"" + dep.type + "\"; supported types: " + TYPES.keySet());
		return function.apply(dep, project);
	}
}