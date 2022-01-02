package cyclic.lang.compiler;

public final class Constants{
	
	public static final String OBJECT = "java.lang.Object";
	public static final String STRING = "java.lang.String";
	
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
	
	// Compiler checked annotations
	public static final String OVERRIDE = "java.lang.Override";
	public static final String DEPRECATED = "java.lang.Deprecated";
	public static final String FUNCTIONAL_INTERFACE = "java.lang.FunctionalInterface";
	public static final String SAFE_VARARGS = "java.lang.SafeVarargs";
	public static final String SUPPRESS_WARNINGS = "java.lang.SuppressWarnings";
	
	public static final String REPEATABLE = "java.lang.annotation.Repeatable";
	public static final String RETENTION = "java.lang.annotation.Retention";
	public static final String TARGET = "java.lang.annotation.Target";
	
	// Cyclic lib types
	public static final String CYCLIC_FILE_MARKER = "cyclic.lang.CyclicFile";
	public static final String CYCLIC_ANNOTATION_CAN_IMPLEMENT = "cyclic.lang.AnnotationCanImplement";
}