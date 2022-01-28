package cyclic.lang.compiler;

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
	
	/*package-private*/ void updatePaths(Path root){
		this.root = root;
		sourcePath = root.resolve(source).normalize();
		outputPath = root.resolve(output).normalize();
	}
	
	/*package-private*/ void validate(){
		int curJdk = Runtime.version().feature();
		if(curJdk != jdk)
			throw new IllegalStateException("Incorrect compiler JDK " + curJdk + ", project requires " + jdk);
	}
}