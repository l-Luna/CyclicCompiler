package cyclic.lang.compiler.model;

/**
 * Represents the access flags of a class or class member.
 * This only tracks visibility, abstractness, and finality - other attributes are not shared between classes and members,
 * and can be accessed from the particular reference.
 *
 * @see TypeReference
 * @see CallableReference
 * @see MethodReference
 * @see FieldReference
 */
public record AccessFlags(Visibility visibility, boolean isAbstract, boolean isFinal){}