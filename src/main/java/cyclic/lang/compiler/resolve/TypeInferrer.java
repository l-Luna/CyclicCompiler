package cyclic.lang.compiler.resolve;

import cyclic.lang.compiler.model.TypeParameterReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import cyclic.lang.compiler.model.generic.ParameterizedTypeRef;
import cyclic.lang.compiler.model.generic.WildcardTypeRef;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.*;

public class TypeInferrer{
	
	// supplied is {param -> value, param -> value}
	// e.g.
	// {T -> Double, T -> Long} -> {T -> Number},
	// {T -> String, T -> Integer} -> {T -> Object},
	// {List<T> -> ArrayList<Integer>} -> {T -> Integer}
	public static Map<TypeParameterReference, TypeReference> match(List<Entry<TypeReference, TypeReference>> supplied){
		// reduce generics: {A<X> -> A<Y>} -> {X -> Y}, {? extends T -> U} -> {T -> U}
		// FIXME: {? super T -> U} -> {U -> T}
		boolean happened;
		do{
			happened = false;
			for(Entry<TypeReference, TypeReference> entry : supplied){
				if(!(entry.getKey() instanceof TypeParameterReference) && !(entry.getValue() instanceof TypeParameterReference)
				&& !(entry.getKey() instanceof WildcardTypeRef) && !(entry.getValue() instanceof WildcardTypeRef)){
					TypeReference asKey = Utils.asGenericSupertype(entry.getValue(), entry.getKey());
					if(asKey instanceof ParameterizedTypeRef valPtr && entry.getKey() instanceof ParameterizedTypeRef superPtr){
						supplied.remove(entry);
						valPtr.getTypeArguments().forEach((key, value) -> supplied.add(Map.entry(superPtr.getTypeArguments().get(key), value)));
						happened = true;
						continue;
					}
				}
				if(entry.getKey() instanceof WildcardTypeRef kwtr){
					supplied.remove(entry);
					happened = true;
					// no effect on inference
					if(kwtr.getUpper() != null)
						supplied.add(Map.entry(kwtr.getUpper(), entry.getValue()));
					if(kwtr.getLower() != null)
						supplied.add(Map.entry(entry.getValue(), kwtr.getLower()));
					// ? provides no information
					continue;
				}
				if(entry.getValue() instanceof WildcardTypeRef vwtr){
					supplied.remove(entry);
					happened = true;
					// no effect on inference
					if(vwtr.getUpper() != null)
						supplied.add(Map.entry(entry.getValue(), vwtr.getUpper()));
					if(vwtr.getLower() != null)
						supplied.add(Map.entry(vwtr.getLower(), entry.getValue()));
					// ? provides no information
				}
			}
		}while(happened);
		// collect type parameter uses: {T -> Long, T -> Double} -> {T -> [Long, Double]}
		Map<TypeReference, List<TypeReference>> bounds = supplied.stream()
				.map(x -> Map.entry(x.getKey(), x.getValue() instanceof PrimitiveTypeRef p ? p.boxedType() : x.getValue()))
				.collect(groupingBy(Entry::getKey, mapping(Entry::getValue, toList())));
		// reduce uses: {T -> [Long, Double]} -> {T -> Number}
		return bounds.entrySet().stream()
				.filter(x -> x.getKey() instanceof TypeParameterReference)
				.map(x -> Map.entry((TypeParameterReference)x.getKey(), lowestCommonSupertype(x.getValue())))
				.collect(toMap(Entry::getKey, Entry::getValue));
	}
	
	// {String, Integer} -> {Object}, {Integer, Double, Long} -> {Number}
	private static TypeReference lowestCommonSupertype(List<TypeReference> references){
		TypeReference acc = references.get(0);
		for(int i = 1; i < references.size(); i++)
			acc = references.get(i).commonSuperType(acc);
		return acc;
	}
}