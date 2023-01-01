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
	
	public static boolean isSubstitutableFor(TypeReference type, TypeReference with){
		if(type.equals(with)) // List<String> instanceof List<String>
			return true;
		if(!(type instanceof WildcardTypeRef wtr)) // List<String> !instanceof List<CS>
			return false;
		if(wtr.isAny()) // List<String> instanceof List<?>
			return true;
		if(wtr.getUpper() != null && with.isAssignableTo(wtr.getUpper())) // List<String> instanceof List<? extends CS>
			return true;
		return wtr.getLower().isAssignableTo(with); // List<CS> instanceof List<? super String>
	}
	
	public static boolean isAllSubstitutableFor(Map<TypeParameterReference, TypeReference> types,
	                                            Map<TypeParameterReference, TypeReference> with){
		if(!types.keySet().equals(with.keySet()))
			return false;
		for(TypeParameterReference param : types.keySet())
			if(!isSubstitutableFor(types.get(param), with.get(param)))
				return false;
		return true;
	}
}