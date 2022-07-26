package cyclic.lang.compiler.configuration.dependencies;

import cyclic.lang.compiler.configuration.ConfigurationException;
import cyclic.lang.compiler.configuration.CyclicPackage;
import cyclic.lang.compiler.configuration.CyclicProject;
import cyclic.lang.compiler.configuration.Dependency;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
		else for(String repoUrl : project.mavenRepos){
				var targetUrl = repoUrl + (repoUrl.endsWith("/") ? "" : "/") + url;
				if(exists(targetUrl))
					return new WebJarDependency(targetUrl, project);
			}
		throw new ConfigurationException("Invalid mavenJar dependency; could not find \"" + dependency.name + ":" + dependency.version + "\"");
	}
	
	private static boolean exists(String url){
		try{
			var connection = (HttpURLConnection)new URL(url).openConnection();
			connection.setRequestMethod("HEAD"); // only checking
			return connection.getResponseCode() == HttpURLConnection.HTTP_OK;
		}catch(MalformedURLException e){
			throw new ConfigurationException("Maven repo URL or mavenJar settings are invalid", e);
		}catch(IOException e){
			return false;
		}
	}
}