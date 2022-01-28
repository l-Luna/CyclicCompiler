package cyclic.lang.compiler.model;

public interface MemberReference{
	/**
	 * Returns a reference to the type that this callable is declared in.
	 *
	 * @return The type this is in.
	 */
	TypeReference in();
	
	/**
	 * Returns the shared access flags of this callable.
	 *
	 * @return The access flags.
	 */
	AccessFlags flags();
}
