package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.model.AnnotatableElement;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static cyclic.lang.compiler.Constants.SUPPRESS_WARNINGS;

public interface CyclicMember extends AnnotatableElement{
	
	default void resolve(){}
	
	default void resolveBody(){}
	
	default Set<String> suppressedWarnings(){
		return Set.of();
	}
	
	default Set<String> findSuppressedWarnings(){
		return annotations().stream()
				.filter(x -> x.annotationType().fullyQualifiedName().equals(SUPPRESS_WARNINGS))
				.map(x -> (Object[])x.arguments().get("value"))
				.flatMap(Arrays::stream)
				.map(String.class::cast)
				.collect(Collectors.toSet());
	}
}