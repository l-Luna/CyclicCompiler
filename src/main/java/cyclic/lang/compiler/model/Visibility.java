package cyclic.lang.compiler.model;

import org.objectweb.asm.Opcodes;

/**
 * Represents the visibility of a class or class member, and stores the modifier flag that represents it.
 */
public enum Visibility{
	PACKAGE_PRIVATE(0),
	PRIVATE(Opcodes.ACC_PRIVATE),
	PUBLIC(Opcodes.ACC_PUBLIC),
	PROTECTED(Opcodes.ACC_PROTECTED);
	
	/**
	 * The modifier flag that represents this visibility.
	 *
	 * @see Opcodes#ACC_PUBLIC
	 */
	public final int modifier;
	
	Visibility(int modifier){
		this.modifier = modifier;
	}
}