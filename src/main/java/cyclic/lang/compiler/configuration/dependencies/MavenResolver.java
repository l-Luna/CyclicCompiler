package cyclic.lang.compiler.configuration.dependencies;

import cyclic.lang.compiler.configuration.CyclicPackage;
import cyclic.lang.compiler.configuration.CyclicProject;
import cyclic.lang.compiler.configuration.Dependency;

public final class MavenResolver{
	
	public static Dependency resolveMavenDep(CyclicPackage dependency, CyclicProject project){
		// location = maven repo (optional)
		// name = groupId:artefactId
		// version = version
		String groupId = dependency.name.split(":")[0];
		String artefactId = dependency.name.split(":")[1];
		String url = "%1$s/%2$s/%3$s/%2$s-%3$s.jar".formatted(groupId.replace('.', '/'), artefactId, dependency.version);
		if(dependency.location != null && !dependency.location.isBlank())
			return new WebJarDependency(dependency.location + (dependency.location.endsWith("/") ? "" : "/") + url, project);
		else
			throw new RuntimeException("TODO");
	}
}