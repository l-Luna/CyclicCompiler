package cyclic.lang.compiler.model;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.jetbrains.annotations.NotNull;

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
	
	@NotNull
	MemberReference owner();
	
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
	
	default @NotNull TypeReference erasure(){
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
	default List<? extends ConstructorReference> constructors(){
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
	
	/**
	 * Returns the fully qualified name of this type parameter.
	 * <p/>For a class type parameter, this is the fully qualified name of the class,
	 * plus <code>/</code>, plus the name of the type parameter.
	 * <p>Example: <code>org.example.Example/A</code>
	 *
	 * <p/>For a method type parameter, this is the fully qualified name of the type
	 * that declares the method, plus <code>::</code>, plus the name and descriptor
	 * of the method, plus <code>/</code>, plus the name of the type parameter.
	 * <p>Example: <code>org.example.Example::foo(ILjava/lang/String;)V/A</code>
	 *
	 * @return The fully qualified name of this type parameter.
	 */
	default @NotNull String fullyQualifiedName(){
		return switch(owner()){
			case TypeReference tr -> tr.fullyQualifiedName() + "/" + shortName();
			case MethodReference mr -> mr.in().fullyQualifiedName() + "::" + mr.nameAndDescriptor() + "/" + shortName();
			default -> throw new IllegalStateException();
		};
	}
	
	default String summary(){
		// e.g. "T", "T extends X", "T extends X & Y", "in T", "out class T extends X & Y & Z"
		return variance().prefix()
				+ (isReified() ? "class " : "")
				+ shortName()
				+ (bounds().size() > 0
					? " extends " + bounds().stream().map(TypeReference::shortName).collect(Collectors.joining(" & ")) : "");
	}
	
	default boolean isConcrete(){
		return false;
	}
}