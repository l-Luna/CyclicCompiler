package cyclic.lang.compiler.model;

/**
 * Represents the kind of a type, e.g. whether it is a class, interface, or enum.
 */
public enum TypeKind{
	
	CLASS, INTERFACE, ENUM, ANNOTATION, RECORD, SINGLE, CONSTRUCTED
}