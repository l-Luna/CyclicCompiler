package cyclic.lang.compiler.model;

import cyclic.lang.compiler.Compiler;
import cyclic.lang.compiler.model.external.ExternalTypeResolver;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;

import java.util.*;

public final class TypeResolver{
	
	private static final Map<String, TypeReference> cache = new HashMap<>();
	
	public static Optional<TypeReference> resolve(String name, List<String> imports){
		// if the type ends with [], it's an array type; wrap with ArrayTypeRef.
		if(name.endsWith("[]"))
			return resolve(name.substring(0, name.length() - 2), imports).map(ArrayTypeRef::new);
		
		// imports: e.g. "cyclic.lang.compiler.Compiler", "cyclic.*"
		List<String> candidates = new ArrayList<>();
		candidates.add(name);
		
		// TODO: custom default imports
		imports.add("java.lang.*");
		
		for(var im : imports){
			if(im.endsWith(".*"))
				candidates.add(im.substring(0, im.length() - 1) + name);
			else if(im.endsWith(name))
				candidates.add(im);
		}
			
		Optional<TypeReference> ret = Optional.empty();
		for(var candidate : candidates){
			ret = resolve(candidate);
			if(ret.isPresent()){
				cache.put(candidate, ret.get());
				break;
			}
		}
		
		return ret;
	}
	
	public static Optional<TypeReference> resolve(String fqName){
		if(cache.containsKey(fqName))
			return Optional.of(cache.get(fqName));
		
		for(var primitive : PrimitiveTypeRef.Primitive.values())
			if(primitive.name().toLowerCase().equals(fqName))
				return Optional.of(new PrimitiveTypeRef(primitive));
		
		// TODO: check jar-path
		var systemRef = ExternalTypeResolver.resolveSystem(fqName);
		if(systemRef.isPresent())
			return systemRef;
		
		var cyclicRef = Compiler.toCompile.get(fqName);
		if(cyclicRef != null)
			return Optional.of(cyclicRef);
		
		return Optional.empty();
	}
}