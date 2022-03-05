package cyclic.lang.compiler.model;

import org.jetbrains.annotations.NotNull;
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
	
	public static boolean visibleFrom(MemberReference member, @NotNull MemberReference from){
		return switch(member.flags().visibility()){
			case PUBLIC -> true;
			case PACKAGE_PRIVATE -> member.in().packageName().equals(from.in().packageName());
			case PROTECTED -> member.in().packageName().equals(from.in().packageName()) || from.in().isAssignableTo(member.in());
			// TODO: some sort of nest system?
			case PRIVATE -> member.in().equals(from.in());
			case null -> false;
		};
	}
}