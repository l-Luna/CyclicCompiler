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
public interface MethodReference extends CallableReference{
	
	/**
	 * Returns the name of this method.
	 */
	String name();
	
	/**
	 * Returns the return type of this method. For a void method, this is an {@linkplain cyclic.lang.compiler.model.platform.PrimitiveTypeRef}
	 * with a <code>VOID</code> type.
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
		return "(" + parameters().stream().map(TypeReference::descriptor).collect(Collectors.joining()) + ")" + returns().descriptor();
	}
	
	/**
	 * Returns the name of this method followed by its descriptor.
	 */
	default String nameAndDescriptor(){
		return name() + descriptor();
	}
	
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
	default void writeInvoke(MethodVisitor mv){
		if(isStatic()){
			mv.visitMethodInsn(Opcodes.INVOKESTATIC, in().internalName(), name(), descriptor(), in().kind() == TypeKind.INTERFACE);
		}else{
			boolean isIface = in().kind() == TypeKind.INTERFACE;
			mv.visitMethodInsn(isIface ? Opcodes.INVOKEINTERFACE : Opcodes.INVOKEVIRTUAL, in().internalName(), name(), descriptor(), isIface);
		}
	}
}