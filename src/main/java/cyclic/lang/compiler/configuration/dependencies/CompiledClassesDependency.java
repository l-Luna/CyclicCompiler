package cyclic.lang.compiler.configuration.dependencies;

import cyclic.lang.compiler.configuration.ConfigurationException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

/**
 * Provides types from compiled classfiles in a folder.
 */
public class CompiledClassesDependency extends CompiledDependency{
	
	private final File folder;
	
	public CompiledClassesDependency(File file){
		this.folder = file;
		if(file == null)
			throw new ConfigurationException("Missing dependency folder");
		if(!file.isDirectory())
			throw new ConfigurationException("Compiled class dependency folder must be a directory: " + file);
		loadTypes();
	}
	
	protected List<byte[]> getClasses(){
		var files = folder.listFiles();
		if(files == null)
			throw new IllegalStateException("Could not get files in dependency folder: " + folder);
		return Arrays.stream(files)
				.filter(File::isFile)
				.filter(f -> f.getName().endsWith(".class"))
				.map(f -> {
					try{
						return Files.readAllBytes(f.toPath());
					}catch(IOException e){
						throw new IllegalStateException("Could not read contents of class file: " + f, e);
					}
				})
				.toList();
	}
}