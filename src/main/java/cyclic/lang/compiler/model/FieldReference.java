package cyclic.lang.compiler.model;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * A reference to a field in a class.
 *
 * @see TypeReference
 */
public interface FieldReference{
	
	/**
	 * Returns a reference to the type that this field is declared in.
	 *
	 * @return The type this is in.
	 */
	TypeReference in();
	
	/**
	 * Returns the name of this field.
	 */
	String name();
	
	/**
	 * Returns the type of value stored in this field.
	 *
	 * @return The type of this field.
	 */
	TypeReference type();
	
	/**
	 * Returns the shared access flags of this field.
	 *
	 * @return The access flags.
	 */
	AccessFlags flags();
	
	/**
	 * Returns whether this field is static.
	 */
	boolean isStatic();
	
	/**
	 * Returns whether this field is marked as volatile. Volatile fields are given special attention by the JVM
	 * in regard to multi-thread access.
	 *
	 * @return Whether this field is volatile.
	 */
	boolean isVolatile();
	
	/**
	 * Writes a fetch of this field using the given {@linkplain MethodVisitor}.
	 * Instructions for pushing the instance to load the field from should already have been written if this field
	 * is non-static, though this is not checked.
	 *
	 * @param mv
	 * 		The method visitor to write a fetch to.
	 */
	default void writeFetch(MethodVisitor mv){
		mv.visitFieldInsn(isStatic() ? Opcodes.GETSTATIC : Opcodes.GETFIELD, in().internalName(), name(), type().descriptor());
	}
	
	/**
	 * Writes a store of this field using the given {@linkplain MethodVisitor}.
	 * Instructions for pushing the instance to store the field to (if non-static) followed by the value to store
	 * should already have been written, though this is not checked.
	 *
	 * @param mv
	 * 		The method visitor to write a store to.
	 */
	default void writePut(MethodVisitor mv){
		if(flags().isFinal())
			throw new IllegalStateException("Trying to write a put instruction for a final field!");
		mv.visitFieldInsn(isStatic() ? Opcodes.PUTSTATIC : Opcodes.PUTFIELD, in().internalName(), name(), type().descriptor());
	}
}