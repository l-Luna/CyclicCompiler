package cyclic.lang.compiler.resolve;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.external.SystemTypeRef;

import java.util.Optional;

public final class ExternalTypeResolver{
	
	public static Optional<TypeReference> resolveSystem(String fqName){
		ClassLoader sysLoader = ClassLoader.getPlatformClassLoader();
		try{
			Class<?> type = sysLoader.loadClass(fqName);
			return Optional.of(new SystemTypeRef(type));
		}catch(ClassNotFoundException e){
			return Optional.empty();
		}
	}
}