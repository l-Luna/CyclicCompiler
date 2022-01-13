package cyclic.lang.compiler.resolve;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.jdk.JdkTypeRef;

import java.util.*;

/**
 * Implements {@linkplain Dependency} for JDK types. This uses the JDK that the compiler is being run on.
 */
public final class JdkDependency implements Dependency{
	
	private Set<String> notFound = new HashSet<>();
	private Map<String, TypeReference> found = new HashMap<>();
	
	public Optional<TypeReference> find(String fqName){
		if(notFound.contains(fqName))
			return Optional.empty();
		if(found.containsKey(fqName))
			return Optional.of(found.get(fqName));
		
		ClassLoader sysLoader = ClassLoader.getPlatformClassLoader();
		try{
			Class<?> type = sysLoader.loadClass(fqName);
			JdkTypeRef value = new JdkTypeRef(type);
			found.put(fqName, value);
			return Optional.of(value);
		}catch(ClassNotFoundException e){
			notFound.add(fqName);
			return Optional.empty();
		}
	}
}