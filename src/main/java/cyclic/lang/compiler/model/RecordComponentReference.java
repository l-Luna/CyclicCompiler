package cyclic.lang.compiler.model;

/**
 * Represents a reference to a component of a record type. Record components have a name and type, and
 * have an associated private final field and public accessor method.
 *
 * @see TypeReference#recordComponents()
 * @see FieldReference
 * @see MethodReference
 */
public interface RecordComponentReference{
	
	/**
	 * Returns a reference to the record type that this component is declared in.
	 *
	 * @return The type this is in.
	 */
	TypeReference in();
	
	/**
	 * Returns the name of this component.
	 *
	 * @return The name of this component.
	 */
	String name();
	
	/**
	 * Returns the type of value stored in this component.
	 *
	 * @return The type of this component.
	 */
	TypeReference type();
	
	/**
	 * Returns a reference to the underlying private final field that stores the value of this component.
	 *
	 * @return The underlying field of this component.
	 */
	FieldReference field();
	
	/**
	 * Returns a reference to the public accessor method that returns the value of this component.
	 *
	 * @return The accessor method of this component.
	 */
	MethodReference accessor();
}