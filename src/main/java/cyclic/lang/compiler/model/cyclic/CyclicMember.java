package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.model.AnnotatableElement;
import cyclic.lang.compiler.model.AnnotationTag;
import cyclic.lang.compiler.model.MemberReference;

import java.util.HashSet;
import java.util.Set;

import static cyclic.lang.compiler.Constants.SUPPRESS_WARNINGS;

public interface CyclicMember extends AnnotatableElement, MemberReference{
	
	default void resolve(){}
	
	default void resolveBody(){}
	
	default Set<String> suppressedWarnings(){
		return Set.of();
	}
	
	default Set<String> findSuppressedWarnings(){
		Set<String> set = new HashSet<>();
		for(AnnotationTag x : annotations()){
			if(x.annotationType().fullyQualifiedName().equals(SUPPRESS_WARNINGS)){
				Object arg = x.arguments().get("value");
				if(arg instanceof String s){
					set.add(s);
					continue;
				}
				Object[] values = (Object[])arg;
				for(Object o : values){
					String s = (String)o;
					set.add(s);
				}
			}
		}
		return set;
	}
}