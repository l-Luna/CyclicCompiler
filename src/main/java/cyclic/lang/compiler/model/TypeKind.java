package cyclic.lang.compiler.model;

import org.objectweb.asm.Opcodes;

import static cyclic.lang.compiler.model.Utils.isBitSet;

/**
 * Represents the kind of a type, e.g. whether it is a class, interface, or enum.
 */
public enum TypeKind{
	
	CLASS, INTERFACE, ENUM, ANNOTATION, RECORD, SINGLE, CONSTRUCTED;
	
	// TODO: check for singles (via annotation?)
	/**
	 * Returns the type kind that corresponds to the given class access flags.
	 *
	 * @param flags
	 * 		The class access flags to check.
	 * @return The corresponding type kind.
	 */
	public static TypeKind fromFlags(int flags){
		if(isBitSet(flags, Opcodes.ACC_RECORD))
			return RECORD;
		if(isBitSet(flags, Opcodes.ACC_ANNOTATION))
			return ANNOTATION;
		if(isBitSet(flags, Opcodes.ACC_ENUM))
			return ENUM;
		if(isBitSet(flags, Opcodes.ACC_INTERFACE))
			return INTERFACE;
		return CLASS;
	}
}