package cyclic.lang.compiler.configuration;

import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Cyclic project.
 * <p>When compiling from a project file ("<code>&lt;name&gt;.cyc.yaml</code>"), settings are parsed from the file.
 * Otherwise, a dummy project is used.
 */
public class CyclicProject{
	
	public static final String PROJECT_FILE_EXTENSION = ".cyc.yaml";
	
	// raw path strings, must be public for snakeyaml
	public String source, output;
	
	// if not set, inferred from filename
	public String name = null;
	
	public Path sourcePath, outputPath, root;
	
	public int jdk = Runtime.version().feature(),
	           cyclicLib = jdk;
	
	public boolean includeDebug = true,
	               includeCyclicLibRefs = true,
	               noOutput = false,
	               internal = false;
	
	public List<String> defaultImports = new ArrayList<>();
	
	public List<CyclicPackage> packages = new ArrayList<>();
	public List<CyclicPackage> dependencies = new ArrayList<>();
	
	public List<String> mavenRepos = new ArrayList<>();
	
	@NotNull
	public static CyclicProject parse(Path projectPath) throws IOException{
		var yaml = new Yaml();
		var text = Files.readString(projectPath);
		var project = yaml.loadAs(text, CyclicProject.class);
		project.postParse(projectPath.getParent());
		if(project.name == null){
			var filename = projectPath.getFileName().toString();
			project.name = filename.substring(0, filename.length() - PROJECT_FILE_EXTENSION.length());
		}
		return project;
	}
	
	/*package-private*/ void postParse(Path root){
		this.root = root;
		sourcePath = root.resolve(source).normalize();
		outputPath = root.resolve(output).normalize();
		
		// Maven central
		mavenRepos.add("https://repo1.maven.org/maven2/");
	}
	
	public void validate(){
		int curJdk = Runtime.version().feature();
		if(curJdk != jdk)
			throw new ConfigurationException("Incorrect compiler JDK " + curJdk + ", project requires " + jdk);
	}
	
	public Path pathFromRoot(String path){
		return root.resolve(path).normalize();
	}
	
	public File fileFromRoot(String path){
		return pathFromRoot(path).toFile();
	}
}