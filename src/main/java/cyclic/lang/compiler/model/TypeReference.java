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
}