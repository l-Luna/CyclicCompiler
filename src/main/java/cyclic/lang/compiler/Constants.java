package cyclic.lang.compiler;

/**
 * Contains type and method names in constant fields.
 */
public final class Constants{
	
	public static final String OBJECT = "java.lang.Object";
	public static final String STRING = "java.lang.String";
	public static final String CLASS = "java.lang.Class";
	
	// Super types
	public static final String ENUM = "java.lang.Enum";
	public static final String ANNOTATION = "java.lang.annotation.Annotation";
	public static final String RECORD = "java.lang.Record";
	
	// For-each loop constants
	public static final String ITERABLE = "java.lang.Iterable";
	public static final String ITERABLE_ITERATOR = "iterator";
	
	public static final String ITERATOR = "java.util.Iterator";
	public static final String ITERATOR_HAS_NEXT = "hasNext";
	public static final String ITERATOR_NEXT = "next";
	
	public static final String OBJECTS = "java.util.Objects";
	public static final String OBJECTS_REQUIRE_NONNULL = "requireNonNull";
	
	// String concatenation constants
	public static final String STRING_CONCAT_FACTORY_INT = "java/lang/invoke/StringConcatFactory";
	public static final String MAKE_CONCAT_WITH_CONSTANTS = "makeConcatWithConstants";
	public static final String MAKE_CONCAT_DESC
			= "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;";
	
	// Primitive class (e.g. int.class) constants
	public static final String CONSTANT_BOOTSTRAPS_INT = "java/lang/invoke/ConstantBootstraps";
	public static final String PRIMITIVE_CLASS = "primitiveClass";
	public static final String PRIMITIVE_CLASS_DESC
			= "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Class;";
	
	// Generated record methods constants
	public static final String OBJECT_METHODS_INT = "java/lang/runtime/ObjectMethods";
	public static final String OBJECT_METHODS_BOOTSTRAP = "bootstrap";
	public static final String OBJECT_METHODS_DESC
			= "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/TypeDescriptor;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/invoke/MethodHandle;)Ljava/lang/Object;";
	
	public static final String EQUALS_DESC = "(Ljava/lang/Object;)Z";
	public static final String HASHCODE_DESC = "()I";
	public static final String TO_STRING_DESC = "()Ljava/lang/String;";
	
	// Throw statement
	public static final String THROWABLE = "java.lang.Throwable";
	
	// Compiler checked annotations
	public static final String OVERRIDE = "java.lang.Override";
	public static final String DEPRECATED = "java.lang.Deprecated";
	public static final String FUNCTIONAL_INTERFACE = "java.lang.FunctionalInterface";
	public static final String SAFE_VARARGS = "java.lang.SafeVarargs";
	
	public static final String SUPPRESS_WARNINGS = "java.lang.SuppressWarnings";
	
	public static final String REPEATABLE = "java.lang.annotation.Repeatable";
	public static final String RETENTION = "java.lang.annotation.Retention";
	public static final String TARGET = "java.lang.annotation.Target";
	
	// SuppressWarnings IDs
	public static final String SUPPRESS_DEPRECTAED = "deprecation";
	
	// Cyclic lib types
	public static final String CYCLIC_ANNOTATION_CAN_IMPLEMENT = "cyclic.lang.AnnotationCanImplement";
}