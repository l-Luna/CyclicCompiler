package cyclic.lang.compiler.model;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.model.cyclic.CyclicTypeBuilder;
import cyclic.lang.compiler.model.generic.ParameterizedTypeRef;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
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
public interface TypeReference extends AnnotatableElement, GenericElement<TypeReference>, MemberReference{
	
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
	@Nullable("null -> Object or primitives")
	@Contract(pure = true)
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
	
	List<? extends MethodReference> declaredMethods();
	
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
	 * <p>Two references to the same type must have the same {@linkplain TypeReference#fullyQualifiedName()}
	 * and type arguments (if any).
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
	 * If this is a raw generic type, returns a list of references to the type parameters of this generic type.
	 * <p>Otherwise, returns an empty list. This includes non-generic types and parameterized generic types.
	 * <p>This list must be in the same order as the type parameters are declared.
	 *
	 * @return The type parameters of this generic type.
	 */
	default List<? extends TypeParameterReference> typeParameters(){
		return GenericElement.super.typeParameters();
	}
	
	/**
	 * If this is a raw type, returns this. If this is a parameterized type, returns its raw type.
	 * If this is a type parameter, returns the bound type. If this is an array of any of the above,
	 * returns an array of the component's erasure.
	 *
	 * @return The erasure of this type.
	 */
	@NotNull
	default TypeReference erasure(){
		return this;
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
	@NotNull
	default String fullyQualifiedName(){
		return packageName().isBlank() ? shortName() : packageName() + "." + shortName();
	}
	
	/**
	 * Returns the internal name of this type.
	 * <p>
	 * If this type has an erasure, this is the internal name of that type.
	 * <p>
	 * For an array type, this is the descriptor.
	 * <p>
	 * Otherwise, returns the fully qualified name of this type, with all dots replaced with forward slashes, e.g.
	 * <code>cyclic/lang/compiler/types/TypeReference</code>.
	 *
	 * @return The internal name of this type.
	 */
	default String internalName(){
		var erasure = erasure();
		if(!erasure.equals(this))
			return erasure.internalName();
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
	
	// TODO: consider unchecked conversion
	// TODO: wildcard types
	/**
	 * Returns whether an instance of this type can be assigned to a variable or parameter of the target type.
	 * <p>
	 * For a primitive type, this is true iff the target represents the same primitive type. For the null type,
	 * this is true if the target is a reference type.
	 * <p>
	 * For an array type, this is true if the target is <code>java.lang.Object</code>, or the target is an array and the
	 * component type of this array is assignable to the other array's component type.
	 * <p>
	 * If the target is a generic type parameter (i.e. unparameterized), this is true if this is assignable to the type
	 * parameter's erasure.
	 * <p>
	 * If the target is a parameterized type and this type is not, this is true if this is assignable to the erasure of the target.
	 * <p>
	 * For any other reference type, this is true if the target has the same fully qualified name
	 * (i.e. is the same type) as this, or any implemented generic interface is assignable to the target, or this type's
	 * generic superclass is assignable to the target.
	 * <p>
	 * If this is a parameterized type, it is also required that all type arguments are equal.
	 * <p>
	 * Note that this is always true if the target is a reference to <code>java.lang.Object</code> and this is a reference
	 * type.
	 *
	 * @param target
	 * 		The type that is being tested.
	 * @return Whether an instance of this type is assignable to the target type.
	 */
	default boolean isAssignableTo(@Nullable TypeReference target){
		if(this == target)
			return true;
		
		if(target == null)
			return false;
		
		// special case Object for interfaces
		if(target.fullyQualifiedName().equals(Constants.OBJECT))
			return true;
		
		if(target instanceof TypeParameterReference tpr)
			return isAssignableTo(tpr.erasure());
		
		if(target instanceof ParameterizedTypeRef ptr && !(this instanceof ParameterizedTypeRef))
			return isAssignableTo(ptr.erasure());
		
		// either we're the target, we're a subtype of the target, or we implement the target
		if(fullyQualifiedName().equals(target.fullyQualifiedName())){
			if(this instanceof ParameterizedTypeRef thisPtr && target instanceof ParameterizedTypeRef targetPtr)
				return thisPtr.getTypeArguments().equals(targetPtr.getTypeArguments());
			return true;
		}
		
		if(genericSuperClass() != null && genericSuperClass().isAssignableTo(target))
			return true;
		
		if(target.kind() == TypeKind.INTERFACE)
			for(TypeReference x : genericSuperInterfaces())
				if(x.isAssignableTo(target))
					return true;
		
		return false;
	}
	
	/**
	 * Returns the superclass of this type, with type arguments supplied by this type.
	 * Returns null if this is <code>java.lang.Object</code> or a primitive type.
	 * <p>
	 * <p/> Consider <code>class Sub&lt;T&gt; extends Super&lt;String, T&gt;</code>. Calling
	 * {@linkplain TypeReference#superClass()} on Sub will return <code>Super</code>, while calling
	 * this on Sub will return <code>Super&lt;java.lang.String, Sub/T&gt;</code>.
	 *
	 * @return The superclass of this type with type arguments, or <code>null</code> if this is <code>java.lang.Object</code>
	 * or a primitive type.
	 */
	@Nullable("null -> Object or primitives")
	@Contract(pure = true)
	default TypeReference genericSuperClass(){
		return superClass();
	}
	
	/**
	 * Returns a list of references to the types that this type implements, with type arguments supplied by this type.
	 * For an interface, this will be the list of types it extends.
	 * <p>See {@linkplain #genericSuperClass()} for more information.
	 *
	 * @return The types that this type implements.
	 */
	default List<? extends TypeReference> genericSuperInterfaces(){
		return superInterfaces();
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