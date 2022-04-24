package cyclic.lang.compiler.resolve;

/**
 * Thrown when a type referenced by name is not found in any dependency.
 */
public class TypeNotFoundException extends RuntimeException{
	
	public TypeNotFoundException(String message){
		super(message);
	}
}