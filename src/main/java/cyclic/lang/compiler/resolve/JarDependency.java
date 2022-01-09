package cyclic.lang.compiler.resolve;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.external.ClassfileTypeRef;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * Implements {@linkplain Dependency} for classes that have been compiled and packaged into a jar file.
 * <p>This dependency must be closed to release the underlying jar file.
 */
public class JarDependency implements Dependency{
	
	private final JarFile underlying;
	private final Map<String, TypeReference> loaded;
	
	public JarDependency(File file) throws IOException{
		underlying = new JarFile(file, false, JarFile.OPEN_READ, Runtime.version());
		loaded = underlying.versionedStream()
				.map(ze -> {
					try{
						return underlying.getInputStream(ze).readAllBytes();
					}catch(IOException e){
						throw new RuntimeException("An IO error occurred trying to read jar entry \"" + ze.getName() + "\": " + e);
					}
				})
				// check that the entry begins with 0xCAFEBABE, which is required for class files
				.filter(x -> x.length > 4 && (x[0] == (byte)0xCA && x[1] == (byte)0xFE && x[2] == (byte)0xBA && x[3] == (byte)0xBE))
				.map(ClassfileTypeRef::new)
				.collect(Collectors.toMap(TypeReference::fullyQualifiedName, Function.identity()));
	}
	
	public void resolve(){
		loaded.values().forEach(TypeReference::resolveRefs);
		loaded.values().forEach(TypeReference::resolveInheritance);
	}
	
	public Optional<TypeReference> find(String fullyQualifiedName){
		return Optional.ofNullable(loaded.get(fullyQualifiedName));
	}
	
	public void close() throws IOException{
		underlying.close();
	}
}