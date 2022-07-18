package cyclic.lang.compiler;

import cyclic.lang.compiler.model.EnumConstant;
import cyclic.lang.compiler.model.TypeKind;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.external.ClassfileTypeRef;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

public class RoundtripTest{
	
	@Test
	void testMembers(){
		var withMethod = miniCompile("class C{ void v(int i, long l, String s); }");
		Assertions.assertEquals(1, withMethod.methods().size());
		var method = withMethod.methods().get(0);
		Assertions.assertEquals("v(IJLjava/lang/String;)V", method.nameAndDescriptor());
	}
	
	@Test
	void testAttributes(){
		var compiledSingle = CompilerLauncher.compileSingleClass("single S;");
		ClassfileTypeRef singleRef = new ClassfileTypeRef(compiledSingle);
		Assertions.assertEquals(TypeKind.SINGLE, singleRef.kind());
		
		var compiledClass = CompilerLauncher.compileSingleClass("class C;");
		ClassfileTypeRef classRef = new ClassfileTypeRef(compiledClass);
		Assertions.assertEquals(TypeKind.CLASS, classRef.kind());
	}
	
	@Test
	void testAnnotations(){
		var deprecatedClass = miniCompile("@Deprecated class C;");
		Assertions.assertEquals(1, deprecatedClass.annotations().size());
		Assertions.assertTrue(deprecatedClass.getAnnotationByName(Constants.DEPRECATED).isPresent());
		
		var dfrClass = miniCompile("@Deprecated(forRemoval = true) class C;");
		Assertions.assertEquals(1, dfrClass.annotations().size());
		Assertions.assertTrue(dfrClass.getAnnotationByName(Constants.DEPRECATED).isPresent());
		Assertions.assertTrue((Boolean)dfrClass.getAnnotationByName(Constants.DEPRECATED).get().arguments().get("forRemoval"));
		
		var dSinceClass = miniCompile("@Deprecated(since = \"now\") class C;");
		Assertions.assertEquals(1, dSinceClass.annotations().size());
		Assertions.assertTrue(dSinceClass.getAnnotationByName(Constants.DEPRECATED).isPresent());
		Assertions.assertEquals("now", dSinceClass.getAnnotationByName(Constants.DEPRECATED).get().arguments().get("since"));
		
		var ann = miniCompile("""
                import java.lang.annotation.*;
                
                @Retention(RetentionPolicy.RUNTIME)
                @Target(new ElementType[]{ElementType.FIELD})
                @Repeatable(Class.class) // obviously nonsense, but not checked (yet)
                annotation A;
                """);
		Assertions.assertEquals(3, ann.annotations().size());
		
		Assertions.assertTrue(ann.getAnnotationByName(Constants.RETENTION).isPresent());
		EnumConstant retentionValue = (EnumConstant)ann.getAnnotationByName(Constants.RETENTION).get().arguments().get("value");
		assertEnumEq(retentionValue, RetentionPolicy.RUNTIME);
		
		Assertions.assertTrue(ann.getAnnotationByName(Constants.TARGET).isPresent());
		Object[] targetValues = (Object[])ann.getAnnotationByName(Constants.TARGET).get().arguments().get("value");
		Assertions.assertEquals(1, targetValues.length);
		assertEnumEq((EnumConstant)targetValues[0], ElementType.FIELD);
		
		Assertions.assertTrue(ann.getAnnotationByName(Constants.REPEATABLE).isPresent());
		TypeReference repeatableValue = (TypeReference)ann.getAnnotationByName(Constants.REPEATABLE).get().arguments().get("value");
		Assertions.assertEquals(Class.class.getName(), repeatableValue.fullyQualifiedName());
		
		// TODO: test nested annotations
	}
	
	private static ClassfileTypeRef miniCompile(String source){
		var clss = new ClassfileTypeRef(CompilerLauncher.compileSingleClass(source));
		clss.resolveRefs();
		clss.resolveInheritance();
		return clss;
	}
	
	private static void assertEnumEq(EnumConstant ec, Enum<?> en){
		Assertions.assertEquals(ec.name(), en.name());
		Assertions.assertEquals(ec.enumType().fullyQualifiedName(), en.getClass().getName());
	}
}