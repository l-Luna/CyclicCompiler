package cyclic.lang.compiler.projects;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SingleFileProjectTest extends ProjectTestCase{
	
	@Test
	void testSingleFileProject() throws IOException{
		addProjectFile("singleFile", """
				source: "cyclic/"
				output: "out/"
				
				jdk: 17
				
				internal: true
				""");
		
		addCyclicFile("cyclic/SimpleFile", """
				class SimpleFile{
					public static void main(String[] args){
						System.out.println("Hello World!");
					}
				}
				""");
		
		compileProject("singleFile");
	}
}