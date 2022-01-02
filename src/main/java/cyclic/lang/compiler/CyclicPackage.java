package cyclic.lang.compiler;

/**
 * Represents a packaged file that can be produced by compilation, such as a jar file.
 */
public class CyclicPackage{
	
	public String name;
	public String version;
	public String type;
	public String location; // relative to project file
}