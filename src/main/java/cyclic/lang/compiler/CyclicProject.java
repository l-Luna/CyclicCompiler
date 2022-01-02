package cyclic.lang.compiler;

import java.nio.file.Path;
import java.util.List;

/**
 * Represents a Cyclic project.
 * <p>When compiling from a project file ("project.cyc.yaml"), settings are parsed from the file.
 * Otherwise, a dummy project is used.
 */
public class CyclicProject{
	
	// raw path strings, must be public for snakeyaml
	public String source, output;
	
	public Path sourcePath, outputPath;
	
	public int jdk = Runtime.version().feature(),
	           cyclic_lib = jdk;
	
	public boolean include_debug = true;
	
	public List<CyclicPackage> packages;
	
	/*package-private*/ void updatePaths(Path root){
		sourcePath = root.resolve(source).normalize();
		outputPath = root.resolve(output).normalize();
	}
	
	/*package-private*/ void validate(){
		int curJdk = Runtime.version().feature();
		if(curJdk != jdk)
			throw new IllegalStateException("Incorrect compiler JDK " + curJdk + ", project requires " + jdk);
	}
}