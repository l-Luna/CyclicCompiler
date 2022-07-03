package cyclic.lang.compiler.configuration.dependencies;

import cyclic.lang.compiler.configuration.CyclicProject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.jar.JarFile;

public class WebJarDependency extends CompiledDependency{
	
	private final File file;
	
	public WebJarDependency(String url, CyclicProject project){
		System.out.println("Downloading dependency from \"" + url + "\"");
		try{
			file = File.createTempFile("cyclic-dep-for-" + project.name + "-" + url.hashCode(), ".jar");
			try(ReadableByteChannel channel = Channels.newChannel(new URL(url).openStream())){
				try(FileOutputStream output = new FileOutputStream(file)){
					output.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
				}
			}
			loadTypes();
			//noinspection ResultOfMethodCallIgnored
			file.delete();
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
	
	// TODO: dedup with JarDependency
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
		}catch(IOException e){
			throw new RuntimeException("An IO error occurred trying to read jar file \"" + file + "\": " + e, e);
		}
	}
}