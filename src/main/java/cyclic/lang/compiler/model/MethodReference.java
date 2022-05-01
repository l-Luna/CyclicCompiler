package cyclic.lang.compiler.model;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.annotation.ElementType;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A reference to a method. Unlike constructors, methods have names, return types, and can be synchronized or native.
 *
 * @see TypeReference
 * @see CallableReference
 */
public interface MethodReference extends CallableReference, GenericElement<MethodReference>{
	
	/**
	 * Returns the name of this method.
	 */
	String name();
	
	/**
	 * Returns the return type of this method. For a void method, this is a
	 * {@linkplain cyclic.lang.compiler.model.platform.PrimitiveTypeRef} with a <code>VOID</code> type.
	 *
	 * @return The return type of this method.
	 */
	TypeReference returns();
	
	/**
	 * Returns whether this method is marked as native.
	 *
	 * @return If this method is marked as native.
	 */
	boolean isNative();
	
	/**
	 * Returns whether this method is synchronized.
	 *
	 * @return If this method is synchronized.
	 */
	boolean isSynchronized();
	
	/**
	 * Returns whether this method would override the given method if it was in a subclass.
	 * <p>True if both methods have the same name, same parameter types, and the return type of this method is assignable
	 * to the return type of the other.
	 *
	 * @param other
	 * 		The method that is being considered overriding.
	 * @return Whether this method would override the given method.
	 */
	default boolean overrides(MethodReference other){
		return other.name().equals(name()) && returns().isAssignableTo(other.returns()) && other.parameters().equals(parameters());
	}
	
	/**
	 * If this method is an annotation component, returns the default value of this component if it exists; otherwise returns null.
	 * <p>{@linkplain Enum}, {@linkplain Class}, and {@linkplain java.lang.annotation.Annotation} values are represented as
	 * {@linkplain EnumConstant}, {@linkplain TypeReference}, and {@linkplain AnnotationTag} values, mirroring {@linkplain AnnotationTag}.
	 * Primitive types are represented by their wrappers.
	 *
	 * @return The default value of annotation components.
	 * @see AnnotationTag
	 */
	default Object defaultValueForAnnotation(){
		return null;
	}
	
	/**
	 * Returns the descriptor of this method, not including the name of this method.
	 *
	 * @return The descriptor of this method.
	 */
	default String descriptor(){
		return parameterDescriptor() + returns().descriptor();
	}
	
	default String parameterDescriptor(){
		return "(" + parameters().stream().map(TypeReference::descriptor).collect(Collectors.joining()) + ")";
	}
	
	/**
	 * Returns the name of this method followed by its descriptor.
	 */
	default String nameAndDescriptor(){
		return name() + descriptor();
	}
	
	/**
	 * Returns a string summarizing this method's signature in a human-readable form for error messages.
	 * such as {@code "String concat(String, String)"}.
	 * <p>The return value of this method should not be parsed and can change at any time.
	 */
	default String summary(){
		// TODO: consider cases where multiple types have the same short name
		//  and use summarized package names (e.g. j.u.List vs j.a.List) when that occurs
		// TODO: exclude synthetic parameters?
		return "%s %s(%s)".formatted(
				returns().shortName(),
				name(),
				parameters().stream().map(TypeReference::shortName).collect(Collectors.joining(", ")));
	}
	
	/**
	 * {@inheritDoc}
	 */
	default String elementType(){
		return ElementType.METHOD.name();
	}
	
	/**
	 * Returns a set of references to the annotations on the return type of this method.
	 */
	default Set<AnnotationTag> returnTypeAnnotations(){
		return Collections.emptySet();
	}
	
	/**
	 * {@inheritDoc}
	 */
	default boolean isConcrete(){
		return parameters().stream().allMatch(TypeReference::isConcrete)
				&& returns().isConcrete();
	}
	
	/**
	 * {@inheritDoc}
	 */
	default void writeInvoke(MethodVisitor mv){
		if(isStatic())
			mv.visitMethodInsn(Opcodes.INVOKESTATIC, in().internalName(), name(), descriptor(), in().kind() == TypeKind.INTERFACE);
		else{
			boolean isInterface = in().kind() == TypeKind.INTERFACE;
			mv.visitMethodInsn(isInterface ? Opcodes.INVOKEINTERFACE : Opcodes.INVOKEVIRTUAL, in().internalName(), name(), descriptor(), isInterface);
		}
	}
	
	// don't like this
	/**
	 * Writes an invocation of this method using the given {@linkplain MethodVisitor} that does not participate
	 * in dynamic type checking, e.g. for <code>super.X()</code> expressions.
	 * <p>Instructions for pushing parameter values to the stack should have already been written, though this
	 * is not checked.
	 * <p>If this method reference is static, this acts identically to {@linkplain MethodReference#writeInvoke(MethodVisitor)}.
	 *
	 * @param mv
	 * 		The method visitor to write an invocation to.
	 */
	default void writeInvokeSpecial(MethodVisitor mv){
		if(isStatic())
			writeInvoke(mv);
		else{
			boolean isInterface = in().kind() == TypeKind.INTERFACE;
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, in().internalName(), name(), descriptor(), isInterface);
		}
	}
}