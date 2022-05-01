package cyclic.lang.compiler.model.generic;

import cyclic.lang.compiler.model.TypeParameterReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class GenericUtils{
	
	public static TypeReference substitute(TypeReference type, Map<TypeParameterReference, TypeReference> args){
		if(type instanceof TypeParameterReference tpr && args.containsKey(tpr))
			return args.get(tpr);
		if(type instanceof ArrayTypeRef atr) // T[] -> U[], T[][] -> U[][], etc
			return new ArrayTypeRef(substitute(atr.getComponent(), args));
		if(type instanceof ParameterizedTypeRef ptr) // List<T> -> List<U>, List<List<T>> -> List<List<U>>, etc
			return new ParameterizedTypeRef(ptr.erasure(), withSubstitutions(ptr.getTypeArguments(), args));
		return type;
	}
	
	public static Map<TypeParameterReference, TypeReference> withSubstitutions(Map<TypeParameterReference, TypeReference> types,
	                                                                           Map<TypeParameterReference, TypeReference> substitutions){
		return types.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> substitute(e.getValue(), substitutions)));
	}
	
	public static List<TypeReference> withSubstitutions(List<TypeReference> types,
	                                                    Map<TypeParameterReference, TypeReference> substitutions){
		return types.stream().map(t -> substitute(t, substitutions)).collect(Collectors.toList());
	}
}