package cyclic.lang.compiler.model.external;

import cyclic.lang.compiler.model.AnnotatableElement;
import cyclic.lang.compiler.model.AnnotationTag;
import cyclic.lang.compiler.model.EnumConstant;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.resolve.TypeResolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds annotation info for external classes before types can be resolved.
*/
/*package-private*/ record ClassfileAnnotationPrototype(String typeName, Map<String, Object> values){
	
	/*
	* Since we might not have type resolution for the relevant types yet, we can't use
	* EnumConstant, TypeReference, AnnotationTag as values. For AnnotationTag we'll use
	* ClassfileAnnotationPrototype.
	*
	* The rest we'll encode as strings:
	* - enum:p.q.EnumName#CONSTANT
	* - type:p.q.Type
	* - str:string (to avoid literal text being mistaken)
	*/
	
	public ClassfileAnnotationPrototype(String typeName){
		this(typeName, new HashMap<>());
	}
	
	public AnnotationTag resolve(AnnotatableElement on){
		TypeReference reference = TypeResolver.resolveFq(typeName);
		Map<String, Object> convertedValues = new HashMap<>(values.size());
		values.forEach((s, o) -> convertedValues.put(s, convertToReal(o)));
		return new AnnotationTag(reference, Map.of(), convertedValues, on);
	}
	
	public static Object convertToReal(Object prototype){
		if(prototype instanceof ClassfileAnnotationPrototype ptt)
			return ptt.resolve(null);
		if(prototype instanceof String s){
			if(s.startsWith("str:"))
				return s.substring(4);
			if(s.startsWith("type:"))
				return TypeResolver.resolveFq(s.substring(5));
			if(s.startsWith("enum:")){
				s = s.substring(5);
				var split = s.split("#");
				// array patterns when >.<
				return new EnumConstant(TypeResolver.resolveFq(split[0]), split[1]);
			}
		}
		if(prototype instanceof Object[] arr)
			return Arrays.stream(arr).map(ClassfileAnnotationPrototype::convertToReal).toArray();
		return prototype;
	}
}