package cyclic.lang.compiler.model;

import org.objectweb.asm.Opcodes;

import static cyclic.lang.compiler.model.Utils.isBitSet;

/**
 * Represents the kind of a type, e.g. whether it is a class, interface, or enum.
 */
public enum TypeKind{
	
	// note that only classes, interfaces, and annotations are properly implemented
	
	/** A type that is a regular class. */
	CLASS,
	
	/** A type that is an interface. Interfaces are stateless and many interfaces can be implemented on one type. */
    INTERFACE,
	
	/** A type that is an enum. Enums have a limited set of possible values, all of which are constants. */
	ENUM,
	
	/** A type that is an annotation. Types, members, and variables can be annotated with a reference to annotations. */
	ANNOTATION,
	
	/** A type that is a record class. Records are transparent carriers of data. */
	RECORD,
	
	/** A type that is a singleton type. Only one value of a singleton type can exist.
	 * Unlike an enum, singles can inherit from other regular classes. */
	SINGLE,
	
	/** A type that does not correspond to any declared type. This includes primitives and the {@code void} and {@code null} types. */
	CONSTRUCTED;
	
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