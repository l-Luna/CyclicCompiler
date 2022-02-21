package cyclic.lang.compiler.model;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A reference to a class member that contains code and can be invoked - either a constructor or a method.
 *
 * @see TypeReference
 * @see MethodReference
 */
public interface CallableReference extends AnnotatableElement, MemberReference{
	
	/**
	 * Returns a list of references to the types of this callable's parameters, in order.
	 * There will always be one entry per parameter.
	 *
	 * @return A list of parameter types.
	 */
	List<TypeReference> parameters();
	
	/**
	 * Returns a list of names of this callable's parameters.
	 * This list may have fewer entries than {@linkplain CallableReference#parameters()}, as class files may not declare parameter names.
	 *
	 * @return A list of parameter names.
	 */
	List<String> parameterNames();
	
	/**
	 * Returns whether this callable is static. True for static methods and static initializers.
	 *
	 * @return Whether this callable is static.
	 */
	boolean isStatic();
	
	/**
	 * Returns whether this callable is defined as var-args. Var-args callables must have at least one parameter, and
	 * the last parameter must be a list type.
	 *
	 * @return Whether this callable is var-args.
	 */
	boolean isVarargs();
	
	default String elementType(){
		return ElementType.CONSTRUCTOR.name();
	}
	
	/**
	 * Returns a list of the annotation references to the parameters of this method.
	 * The returned list should have a length equal to the number of parameters of this method.
	 */
	default List<Set<AnnotationTag>> parameterAnnotations(){
		return new ArrayList<>(parameters().size());
	}
	
	/**
	 * Returns the descriptor of this callable. For a constructor, this always has a return type of <code>V</code>.
	 * Does not include the name of this callable, which does not exist for constructors.
	 *
	 * @return The descriptor of this callable.
	 */
	default String descriptor(){
		return "(" + parameters().stream().map(TypeReference::descriptor).collect(Collectors.joining()) + ")V";
	}
	
	/**
	 * Writes an invocation of this callable using the given {@linkplain MethodVisitor}.
	 * Instructions for pushing the parameter values to the stack should have already been written,
	 * though this is not checked.
	 *
	 * @param mv
	 * 		The method visitor to write an invocation to.
	 */
	default void writeInvoke(MethodVisitor mv){
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, in().internalName(), "<init>", descriptor(), false);
	}
}