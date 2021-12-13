package cyclic.lang.compiler.model;

import java.util.List;

public interface TypeReference{
	
	// e.g. TypeReference or A$B
	String shortName();
	
	// e.g. cyclic.lang.compiler.types
	String packageName();
	
	TypeKind kind();
	
	AccessFlags flags();
	
	TypeReference outerClass();
	
	TypeReference superClass();
	
	List<? extends TypeReference> superInterfaces();
	
	List<? extends TypeReference> innerClasses();
	
	List<? extends MethodReference> methods();
	
	List<? extends FieldReference> fields();
	
	List<? extends ConstructorReference> constructors();
	
	default void resolveRefs(){}
	
	/// Default implementations
	
	// e.g. cyclic.lang.compiler.types.TypeReference
	default String fullyQualifiedName(){
		return packageName().isBlank() ? shortName() : packageName() + "." + shortName();
	}
	
	// e.g. cyclic/lang/compiler/types/TypeReference
	default String internalName(){
		return fullyQualifiedName().replace('.', '/');
	}
	
	default String descriptor(){
		return "L" + internalName() + ";";
	}
	
	default boolean isAssignableTo(TypeReference target){
		// either we're the target, we're a subtype of the target, or we implement the target
		if(fullyQualifiedName().equals(target.fullyQualifiedName()))
			return true;
		
		TypeReference p = superClass();
		while(p != null){
			if(p.fullyQualifiedName().equals(target.fullyQualifiedName()))
				return true;
			p = p.superClass();
		}
		
		return superInterfaces().stream().anyMatch(x -> x.isAssignableTo(target));
	}
}