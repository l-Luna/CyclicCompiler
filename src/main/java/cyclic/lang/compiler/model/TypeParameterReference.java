package cyclic.lang.compiler.model;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A reference to a type parameter.
 *
 * @see TypeReference
 */
public interface TypeParameterReference extends TypeReference{
	
	enum Variance{
		INVARIANT,
		IN,
		OUT;
		
		String prefix(){
			return switch(this){
				case INVARIANT -> "";
				case IN -> "in ";
				case OUT -> "out ";
			};
		}
	}
	
	// the type this is a parameter of
	// TODO: methods
	@Nullable
	TypeReference from();
	
	@NotNull
	TypeReference in();
	
	int index();
	
	@NotNull
	List<TypeReference> bounds();
	
	@NotNull
	Variance variance();
	
	boolean isReified();
	
	// default impls
	
	default String packageName(){
		return in().packageName();
	}
	
	default TypeKind kind(){
		return TypeKind.CONSTRUCTED;
	}
	
	default TypeReference erasure(){
		return bounds().size() > 0 && bounds().get(0).kind() == TypeKind.CLASS
				? bounds().get(0)
				: TypeResolver.resolveFq(Constants.OBJECT);
	}
	
	@NotNull
	default TypeReference superClass(){
		return erasure();
	}
	
	default List<? extends TypeReference> superInterfaces(){
		return bounds().stream()
				.filter(t -> t.kind() == TypeKind.INTERFACE)
				.toList();
	}
	
	// use erasure's methods/fields
	default List<? extends MethodReference> methods(){
		return erasure().methods();
	}
	
	default List<? extends FieldReference> fields(){
		return erasure().fields();
	}
	
	// a type parameter has no constructors
	default List<? extends CallableReference> constructors(){
		return List.of();
	}
	
	default AccessFlags flags(){
		return in().flags();
	}
	
	default List<? extends TypeReference> innerClasses(){
		return List.of();
	}
	
	default TypeReference outerClass(){
		return null;
	}
	
	default @NotNull String fullyQualifiedName(){
		return erasure().fullyQualifiedName();
	}
	
	/**
	 * Returns whether this is a reference to the same type parameter as this.
	 * <p>Two references to the same type parameter must be from an equal type/method and have an equal index.
	 *
	 * @return Whether this is a reference to the same type parameter as this.
	 */
	boolean equals(Object other);
	
	default String summary(){
		// e.g. "T", "T extends X", "T extends X & Y", "in T", "out class T extends X & Y & Z"
		return variance().prefix()
				+ (isReified() ? "class " : "")
				+ shortName()
				+ (bounds().size() > 0
					? " extends " + bounds().stream().map(TypeReference::shortName).collect(Collectors.joining(" & ")) : "");
	}
}