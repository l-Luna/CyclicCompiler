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
				
				include_cyclic_lib_refs: false
				""");
		
		addCyclicFile("cyclic/SimpleFile", """
				class SimpleFile{
					public static void main(String[] args){
						System.out.println("Hello World!");
					}
				}
				""");
		
		invokeCompiler("singleFile");
	}
}