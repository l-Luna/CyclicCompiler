package cyclic.lang.compiler.model;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.model.cyclic.CyclicTypeBuilder;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Opcodes;

import java.lang.annotation.ElementType;
import java.util.List;

/**
 * Represents a reference to a type. Types have names and members, and may extend one class and implement many.
 *
 * <p>A newly created type reference (e.g. from {@linkplain CyclicTypeBuilder}) will not have references to other types,
 * and will only properly return information about its name. Calling {@linkplain TypeReference#resolveRefs()} will fill in
 * information about references to other types that can be resolved, and perform basic validation.
 * <p>Inherited methods and fields may also not be visible until {@linkplain TypeReference#resolveInheritance()} has been called
 * after all supertypes have had their references resolved. This also performs some inheritance-related validation.
 * <p>To write a type to a file, you will also need to call {@linkplain TypeReference#resolveBodies()} after all referenced
 * types and resolved references, so that callable member bodies and default field values can also be filled in.
 *
 * @see CyclicTypeBuilder
 * @see TypeResolver
 */
public interface TypeReference extends AnnotatableElement, MemberReference{
	
	/**
	 * Returns the short name of this type. For example, the short name of <code>cyclic.lang.compiler.model.TypeReference</code>
	 * is <code>TypeReference</code>.
	 *
	 * @return The short name of this type.
	 */
	String shortName();
	
	/**
	 * Returns the package name of this type. For example, the package name of <code>cyclic.lang.compiler.model.TypeReference</code>
	 * is <code>cyclic.lang.compiler.model</code>.
	 *
	 * @return The package name of this type.
	 */
	String packageName();
	
	/**
	 * Returns the kind of a type that this represents, such as a class, interface, or enum.
	 *
	 * @return The kind of this type.
	 */
	TypeKind kind();
	
	/**
	 * Returns the access flags of this type.
	 */
	AccessFlags flags();
	
	/**
	 * Returns a reference to this type's outer class, or null if this is not an inner class.
	 *
	 * @return This type's outer class.
	 */
	TypeReference outerClass();
	
	/**
	 * Returns a reference to this type's super class. This may be null for {@linkplain Object} or primitives.
	 *
	 * @return A reference to this type's super class.
	 */
	@Nullable
	TypeReference superClass();
	
	/**
	 * Returns a list of references to the types that this type implements.
	 * For an interface, this will be the list of types it extends.
	 *
	 * @return The types that this type implements.
	 */
	List<? extends TypeReference> superInterfaces();
	
	/**
	 * Returns a list of references to the inner classes of this type. Usually empty.
	 *
	 * @return The inner classes of this type.
	 */
	List<? extends TypeReference> innerClasses();
	
	/**
	 * Returns a list of references to the methods of this type, including inherited methods.
	 * Non-public methods may not be included for externally defined types.
	 * Inherited methods may be missing if {@linkplain TypeReference#resolveInheritance()} has not been called on this type.
	 *
	 * @return The methods of this type.
	 */
	List<? extends MethodReference> methods();
	
	/**
	 * Returns a list of references to the fields of this type, including inherited fields.
	 * Non-public fields may not be included for externally defined types.
	 * Inherited fields may be missing if {@linkplain TypeReference#resolveInheritance()} has not been called on this type.
	 *
	 * @return The fields of this type.
	 */
	List<? extends FieldReference> fields();
	
	/**
	 * Returns a list of references to the constructors of this type.
	 * Non-public constructors may not be included for externally defined types.
	 *
	 * @return The constructors of this type.
	 */
	List<? extends ConstructorReference> constructors();
	
	/**
	 * Returns whether this is a reference to the same type as the given other type reference.
	 * <p>Two references to the same type must have the same {@linkplain TypeReference#fullyQualifiedName()}.
	 *
	 * @return Whether this is a reference to the same type as the given type reference.
	 */
	boolean equals(Object other);
	
	/**
	 * Returns a hash code for this type reference. This is always equal to {@code fullyQualifiedName().hashCode()}.
	 *
	 * @return A hash code for this type reference.
	 */
	int hashCode();
	
	/**
	 * If this is a reference to a record type, returns a list of references to the components of this record.
	 * <p>Otherwise, returns an empty list.
	 *
	 * @return The components of this record type.
	 */
	default List<? extends RecordComponentReference> recordComponents(){
		return List.of();
	}
	
	/**
	 * Resolves references in this type reference to other type references, filling in information like
	 * its super class. Also performs basic validation, such as checking duplicate method descriptors.
	 */
	default void resolveRefs(){}
	
	/**
	 * Resolves members inherited from supertypes. Should be called after {@linkplain TypeReference#resolveRefs()} has
	 * been called on all types to be compiled. Also performs validation related to inheritance.
	 */
	default void resolveInheritance(){}
	
	/**
	 * Resolves the bodies of callable members and the default values of fields, required before this type
	 * can be written to a file. Should be called after {@linkplain TypeReference#resolveInheritance()} has
	 * been called on all types to be compiled.
	 */
	default void resolveBodies(){}
	
	/**
	 * Returns the fully qualified name of this type. This is usually the package name, followed by a dot, followed by its
	 * short name, e.g. <code>cyclic.lang.compiler.model.TypeReference</code>.
	 * Types in the default (blank) package will simply return their short name.
	 *
	 * @return The fully qualified name of this type.
	 */
	default String fullyQualifiedName(){
		return packageName().isBlank() ? shortName() : packageName() + "." + shortName();
	}
	
	/**
	 * Returns the fully qualified name of this type, with all dots replaced with forward slashes, e.g.
	 * <code>cyclic/lang/compiler/types/TypeReference</code>.
	 *
	 * @return The internal name of this type.
	 */
	default String internalName(){
		return fullyQualifiedName().replace('.', '/');
	}
	
	/**
	 * Returns the descriptor of this type. This is usually in the form <code>LinternalName;</code>,
	 * @return The descriptor of this type.
	 */
	default String descriptor(){
		return "L" + internalName() + ";";
	}
	
	/**
	 * Returns the closest supertype of two types.
	 *
	 * <p>If this type is a primitive, or if the other type is a primitive or null, this
	 * returns null.
	 * <p>If either type is an interface, this returns Object.
	 * <p>Otherwise, this finds the first supertype of this type that the other type can be assigned to.
	 *
	 * @param other
	 * 		The type to find a common supertype with.
	 * @return The closest supertype of two types.
	 */
	@Nullable
	default TypeReference commonSuperType(TypeReference other){
		if(other == null)
			return null;
		if(this instanceof PrimitiveTypeRef || other instanceof PrimitiveTypeRef)
			return null;
		if(kind() == TypeKind.INTERFACE || other.kind() == TypeKind.INTERFACE)
			return TypeResolver.resolveFq(Constants.OBJECT);
		if(isAssignableTo(other))
			return other;
		if(other.isAssignableTo(this))
			return this;
		TypeReference ref = this;
		do{
			ref = ref.superClass();
		}while(!other.isAssignableTo(ref) && ref != null);
		return ref;
	}
	
	/**
	 * Returns whether an instance of this type can be assigned to a variable or parameter of the target type.
	 * <p>
	 * For a primitive type, this is true iff the target represents the same primitive type. For the null type,
	 * this is true if the target is a reference type.
	 * <p>
	 * For an array type, this is true if the target is <code>java.lang.Object</code>, or the target is an array and the
	 * component type of this array is assignable to the other array's component type.
	 * <p>
	 * For any other reference type, this is true if the target has the same fully qualified name
	 * (i.e. is the same type) as this, or any implemented interface is assignable to the target, or this type's superclass
	 * is assignable to the target.
	 * <p>
	 * Note that this is always true if the target is a reference to <code>java.lang.Object</code> and this is a reference
	 * type.
	 *
	 * @param target
	 * 		The type that is being tested.
	 * @return Whether an instance of this type is assignable to the target type.
	 */
	default boolean isAssignableTo(@Nullable TypeReference target){
		if(target == null)
			return false;
		
		// special case Object for interfaces
		if(target.fullyQualifiedName().equals(Constants.OBJECT))
			return true;
		
		// either we're the target, we're a subtype of the target, or we implement the target
		if(fullyQualifiedName().equals(target.fullyQualifiedName()))
			return true;
		
		if(superClass() != null && superClass().isAssignableTo(target))
			return true;
		
		return superInterfaces().stream().anyMatch(x -> x.isAssignableTo(target));
	}
	
	default String elementType(){
		return ElementType.TYPE.name();
	}
	
	default TypeReference in(){
		return this;
	}
	
	/**
	 * Returns the opcode used by return statements to return values of this type.
	 */
	default int returnOpcode(){
		return Opcodes.ARETURN;
	}
	
	/**
	 * Returns the opcode used by local variable values to load local variables of this type.
	 */
	default int localLoadOpcode(){
		return Opcodes.ALOAD;
	}
	
	/**
	 * Returns the opcode used by assignment statements to store local variables of this type.
	 */
	default int localStoreOpcode(){
		return Opcodes.ASTORE;
	}
	
	/**
	 * Returns the opcode used by array index values to load array entries of this type.
	 */
	default int arrayLoadOpcode(){
		return Opcodes.AALOAD;
	}
	
	/**
	 * Returns the opcode used by assignment statements to store array entries of this type.
	 */
	default int arrayStoreOpcode(){
		return Opcodes.AASTORE;
	}
}