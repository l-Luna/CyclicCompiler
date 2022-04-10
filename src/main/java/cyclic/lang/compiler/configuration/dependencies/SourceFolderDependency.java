package cyclic.lang.compiler.configuration.dependencies;

import cyclic.lang.compiler.configuration.ConfigurationException;
import cyclic.lang.compiler.configuration.Dependency;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.cyclic.CyclicTypeBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Provides types from source code in a folder.
 */
public class SourceFolderDependency implements Dependency{
	
	private final Map<String, TypeReference> types;
	
	public SourceFolderDependency(File folder){
		if(!folder.isDirectory())
			throw new ConfigurationException("Sources dependency folder must be a directory: " + folder);
		types = new HashMap<>();
		Path from = folder.toPath();
		CyclicTypeBuilder.visitFiles(folder, file -> {
			if(file.getName().endsWith(".cyc"))
				try{
					Path relative = from.relativize(file.toPath());
					for(CyclicType type : CyclicTypeBuilder.fromFile(Files.readString(file.toPath()), relative))
						types.put(type.fullyQualifiedName(), type);
				}catch(IOException e){
					throw new RuntimeException("Failed to read dependency source file: " + file, e);
				}
		});
	}
	
	public Optional<TypeReference> find(String fullyQualifiedName){
		return Optional.ofNullable(types.get(fullyQualifiedName));
	}
	
	public void resolveRefs(){
		types.values().forEach(TypeReference::resolveRefs);
	}
	
	public void resolveInheritance(){
		types.values().forEach(TypeReference::resolveInheritance);
	}
}