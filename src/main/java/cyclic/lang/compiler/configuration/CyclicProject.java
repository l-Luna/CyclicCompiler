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
 * <p>When compiling from a project file ("project.cyc.yaml"), settings are parsed from the file.
 * Otherwise, a dummy project is used.
 */
public class CyclicProject{
	
	// raw path strings, must be public for snakeyaml
	public String source, output;
	
	public Path sourcePath, outputPath, root;
	
	public int jdk = Runtime.version().feature(),
	           cyclic_lib = jdk;
	
	public boolean include_debug = true,
	               include_cyclic_lib_refs = true,
	               no_output = false;
	
	public List<String> default_imports = new ArrayList<>();
	
	public List<CyclicPackage> packages = new ArrayList<>();
	public List<CyclicPackage> dependencies = new ArrayList<>();
	
	@NotNull
	public static CyclicProject parse(Path projectPath) throws IOException{
		var yaml = new Yaml();
		var text = Files.readString(projectPath);
		var project = yaml.loadAs(text, CyclicProject.class);
		project.updatePaths(projectPath.getParent());
		return project;
	}
	
	/*package-private*/ void updatePaths(Path root){
		this.root = root;
		sourcePath = root.resolve(source).normalize();
		outputPath = root.resolve(output).normalize();
	}
	
	public void validate(){
		int curJdk = Runtime.version().feature();
		if(curJdk != jdk)
			throw new IllegalStateException("Incorrect compiler JDK " + curJdk + ", project requires " + jdk);
	}
	
	public Path pathFromRoot(String path){
		return root.resolve(path).normalize();
	}
	
	public File fileFromRoot(String path){
		return pathFromRoot(path).toFile();
	}
}