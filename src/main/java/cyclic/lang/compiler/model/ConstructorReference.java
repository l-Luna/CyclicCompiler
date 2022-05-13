package cyclic.lang.compiler.model;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.stream.Collectors;

/**
 * A reference to a constructor.
 */
public interface ConstructorReference extends CallableReference{
	
	/**
	 * {@inheritDoc}
	 */
	default void writeInvoke(MethodVisitor mv){
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, in().internalName(), "<init>", descriptor(), false);
	}
	
	/**
	 * Returns a string summarizing this constructor's signature in a human-readable form for error messages.
	 * such as {@code "new String(String)"}.
	 * <p>The return value of this method should not be parsed and can change at any time.
	 */
	default String summary(){
		// TODO: consider cases where multiple types have the same short name
		//  and use summarized package names (e.g. j.u.List vs j.a.List) when that occurs
		// TODO: exclude synthetic parameters?
		return "new %s(%s)".formatted(in().shortName(),
				parameters().stream().map(TypeReference::shortName).collect(Collectors.joining(", ")));
	}
	
	default void writeCreate(MethodVisitor mv){
		mv.visitTypeInsn(Opcodes.NEW, in().internalName());
		mv.visitInsn(Opcodes.DUP);
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, in().internalName(), "<init>", descriptor(), false);
	}
}