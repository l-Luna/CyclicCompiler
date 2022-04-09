package cyclic.lang.compiler;

import cyclic.lang.compiler.model.TypeKind;
import cyclic.lang.compiler.model.external.ClassfileTypeRef;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AttributeTest{
	
	@Test
	void testAttributes(){
		var compiledSingle = CompilerLauncher.compileSingleClass("single S;");
		ClassfileTypeRef singleRef = new ClassfileTypeRef(compiledSingle);
		Assertions.assertEquals(TypeKind.SINGLE, singleRef.kind());
		
		var compiledClass = CompilerLauncher.compileSingleClass("class C;");
		ClassfileTypeRef classRef = new ClassfileTypeRef(compiledClass);
		Assertions.assertEquals(TypeKind.CLASS, classRef.kind());
	}
}