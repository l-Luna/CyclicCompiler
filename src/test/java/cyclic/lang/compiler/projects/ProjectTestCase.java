package cyclic.lang.compiler.projects;

import cyclic.lang.compiler.CompilerLauncher;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ProjectTestCase{
	
	@TempDir
	Path tempFolder;
	
	Map<String, Path> projectFiles = new HashMap<>();
	
	public Path addFile(String name, String content) throws IOException{
		Path file = tempFolder.resolve(name);
		var parentFolder = file.getParent().toFile();
		var succeeded = parentFolder.mkdirs();
		if(!succeeded && !parentFolder.exists())
			throw new IOException("Failed to create parent directories for test case file");
		Files.write(file, content.getBytes());
		return file;
	}
	
	public void addProjectFile(String name, String content) throws IOException{
		var path = addFile(name + ".cyc.yaml", content);
		projectFiles.put(name, path);
	}
	
	// for language injection in IDEA
	public void addCyclicFile(String name, String content) throws IOException{
		addFile(name + ".cyc", content);
	}
	
	public void addFolder(String name) throws IOException{
		var path = tempFolder.resolve(name);
		var asFile = path.toFile();
		var succeeded = asFile.mkdir();
		if(!succeeded && !asFile.exists())
			throw new IOException("Failed to create test case folder");
	}
	
	public void compileProject(String projectName){
		Path projectFile = projectFiles.get(projectName);
		CompilerLauncher.main("-p", projectFile.toString());
	}
}