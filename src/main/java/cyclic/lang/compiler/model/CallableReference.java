package cyclic.lang.compiler.model;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.annotation.ElementType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A reference to a class member that contains code and can be invoked - either a constructor or a method.
 *
 * @see TypeReference
 * @see MethodReference
 */
public interface CallableReference extends AnnotatableElement{
	
	/**
	 * Returns a reference to the type that this callable is declared in.
	 *
	 * @return The type this is in.
	 */
	TypeReference in();
	
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
	 * Returns the shared access flags of this callable.
	 *
	 * @return The access flags.
	 */
	AccessFlags flags();
	
	/**
	 * Returns whether this callable is static. True for static methods and static initializers.
	 *
	 * @return Whether this callable is static.
	 */
	boolean isStatic();
	
	default String elementType(){
		return ElementType.CONSTRUCTOR.name();
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
	 * Instructions for pushing the parameter values for the stack should have already been written,
	 * though this is not checked.
	 *
	 * @param mv
	 * 		The method visitor to write an invocation to.
	 */
	default void writeInvoke(MethodVisitor mv){
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, in().internalName(), "<init>", descriptor(), false);
	}
}