package cyclic.lang.compiler.projects;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MultiFileProjectTest extends ProjectTestCase{
	
	@Test
	void testMultiFileProject() throws IOException{
		addProjectFile("multiFile", """
				source: "cyclic/"
				output: "out/"
				
				jdk: 17
				
				includeCyclicLibRefs: false
				""");
		
		addCyclicFile("cyclic/SimpleFile1", """
				class SimpleFile1{
					public static SimpleFile2 obj; // depend on SimpleFile2
				}
				""");
		addCyclicFile("cyclic/SimpleFile2", """
				class SimpleFile2{
					public static SimpleFile1 obj; // depend on SimpleFile1
				}
				""");
		
		compileProject("multiFile");
	}
}