package cyclic.lang.compiler.resolve;

import cyclic.lang.compiler.model.TypeParameterReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import cyclic.lang.compiler.model.generic.ParameterizedTypeRef;

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
	public static Map<TypeReference, TypeReference> match(List<Entry<TypeReference, TypeReference>> supplied){
		// reduce generics: {A<X> -> A<Y>} -> {X -> Y}
		boolean happened;
		do{
			happened = false;
			for(Entry<TypeReference, TypeReference> entry : supplied)
				if(!(entry.getKey() instanceof TypeParameterReference) && !(entry.getValue() instanceof TypeParameterReference)){
					TypeReference asKey = Utils.asGenericSupertype(entry.getValue(), entry.getKey());
					if(asKey instanceof ParameterizedTypeRef valPtr && entry.getKey() instanceof ParameterizedTypeRef superPtr){
						supplied.remove(entry);
						valPtr.getTypeArguments().forEach((key, value) -> supplied.add(Map.entry(superPtr.getTypeArguments().get(key), value)));
						happened = true;
					}
				}
		}while(happened);
		// reduce lower bounds {T -> Long, T -> Double} -> {T -> Number}
		Map<TypeReference, List<TypeReference>> bounds = supplied.stream().collect(groupingBy(Entry::getKey, mapping(Entry::getValue, toList())));
		return bounds.entrySet().stream()
				.map(x -> Map.entry(x.getKey(), lowestCommonSupertype(x.getValue())))
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