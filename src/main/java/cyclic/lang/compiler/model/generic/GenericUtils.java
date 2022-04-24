package cyclic.lang.compiler.model.generic;

import cyclic.lang.compiler.model.TypeParameterReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;

import java.util.List;

public final class GenericUtils{
	
	public static TypeReference substitute(TypeReference type, List<TypeReference> args){
		if(type instanceof TypeParameterReference tpr && args.size() > tpr.index())
			return args.get(tpr.index());
		if(type instanceof ArrayTypeRef atr) // T[] -> U[], T[][] -> U[][], etc
			return new ArrayTypeRef(substitute(atr.getComponent(), args));
		return type;
	}
	
	public static List<TypeReference> withSubstitutions(List<TypeReference> args, List<TypeReference> substitutions){
		return args.stream()
				.map(arg -> substitute(arg, substitutions))
				.toList();
	}
}