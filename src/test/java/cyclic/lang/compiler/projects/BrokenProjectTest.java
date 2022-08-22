package cyclic.lang.compiler.projects;

import cyclic.lang.compiler.configuration.ConfigurationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BrokenProjectTest extends ProjectTestCase{
	
	@Test
	void testWrongJdkVersion() throws IOException{
		addProjectFile("wrongJdk", """
				source: "cyclic/"
				output: "out/"
				
				jdk: 1
				""");
		
		Assertions.assertThrows(ConfigurationException.class,
		                       () -> compileProject("wrongJdk"));
	}
	
	@Test
	void testInvalidDependencyType() throws IOException{
		addProjectFile("invalidDep", """
				source: "cyclic/"
				output: "out/"
				
				jdk: 17
				
				dependencies:
				- type: "what"
				""");
		
		Assertions.assertThrows(ConfigurationException.class,
		                       () -> compileProject("invalidDep"));
	}
	
	@Test
	void testMissingJar() throws IOException{
		addProjectFile("missingJar", """
				source: "cyclic/"
				output: "out/"
				
				jdk: 17
				
				dependencies:
				- type: "jar"
				  location: "nowhere.jar"
				""");
		
		Assertions.assertThrows(ConfigurationException.class,
		                       () -> compileProject("missingJar"));
	}
	
	@Test
	void testMissingSourcesFolder() throws IOException{
		addProjectFile("missingSource", """
				source: "cyclic/"
				output: "out/"
				
				jdk: 17
				
				dependencies:
				- type: "sourceFolder"
				  location: "noFolder"
				""");
		
		Assertions.assertThrows(ConfigurationException.class,
		                       () -> compileProject("missingSource"));
	}
	
	@Test
	void testFileNotFolder() throws IOException{
		addProjectFile("fileNotFolder", """
				source: "cyclic/"
				output: "out/"
				
				jdk: 17
				
				dependencies:
				- type: "sourceFolder"
				  location: "isFile"
				""");
		
		addFile("isFile.txt", "not a folder!");
		
		Assertions.assertThrows(ConfigurationException.class,
		                       () -> compileProject("fileNotFolder"));
	}
}