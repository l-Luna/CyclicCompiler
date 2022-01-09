package cyclic.lang.compiler.resolve;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.jdk.JdkTypeRef;

import java.util.Optional;

/**
 * Implements {@linkplain Dependency} for JDK types. This uses the JDK that the compiler is being run on.
 */
public final class JdkDependency implements Dependency{
	
	public Optional<TypeReference> find(String fqName){
		ClassLoader sysLoader = ClassLoader.getPlatformClassLoader();
		try{
			Class<?> type = sysLoader.loadClass(fqName);
			return Optional.of(new JdkTypeRef(type));
		}catch(ClassNotFoundException e){
			return Optional.empty();
		}
	}
}