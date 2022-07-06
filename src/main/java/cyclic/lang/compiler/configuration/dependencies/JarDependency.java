package cyclic.lang.compiler.configuration.dependencies;

import cyclic.lang.compiler.configuration.ConfigurationException;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.jar.JarFile;

/**
 * Provides types from compiled classfiles in a jar file.
 */
public class JarDependency extends CompiledDependency{
	
	private final File file;
	
	public JarDependency(File file){
		this.file = file;
		if(this.file == null)
			throw new ConfigurationException("Missing dependency jar file");
		loadTypes();
	}
	
	protected List<byte[]> getClasses(){
		try(JarFile underlying = new JarFile(file, false, JarFile.OPEN_READ, Runtime.version())){
			return underlying.versionedStream()
					.map(ze -> {
						try{
							return underlying.getInputStream(ze).readAllBytes();
						}catch(IOException e){
							throw new RuntimeException("An IO error occurred trying to read jar entry \"" + ze.getName() + "\": " + e);
						}
					})
					// check that the entry begins with 0xCAFEBABE, which is required for class files
					.filter(x -> x.length > 4 && (x[0] == (byte)0xCA && x[1] == (byte)0xFE && x[2] == (byte)0xBA && x[3] == (byte)0xBE))
					.toList();
		}catch(NoSuchFileException nsfe){
			throw new ConfigurationException("Missing dependency jar file \"" + file + "\"", nsfe);
		}catch(IOException e){
			throw new RuntimeException("An IO error occurred trying to read jar file \"" + file + "\": " + e, e);
		}
	}
}