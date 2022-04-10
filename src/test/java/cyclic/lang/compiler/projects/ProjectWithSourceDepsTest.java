package cyclic.lang.compiler.projects;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ProjectWithSourceDepsTest extends ProjectTestCase{
	
	@Test
	void testProjectWithSourceDeps() throws IOException{
		addProjectFile("sourceDeps", """
				source: "cyclic/"
				output: "out/"
				
				jdk: 17
				
				include_cyclic_lib_refs: false
				
				dependencies:
				- location: "dependency"
				  type: "sourceFolder"
				""");
		
		addCyclicFile("cyclic/SimpleFile1", """
				class SimpleFile1{
					public static SimpleFile2 obj; // depend on SimpleFile2
				}
				""");
		addCyclicFile("dependency/SimpleFile2", """
				class SimpleFile2{
					public static SimpleFile1 obj; // depend on SimpleFile1
					Object stub(){
						// incorrect method body isn't checked
					}
				}
				""");
		
		invokeCompiler("sourceDeps");
	}
}