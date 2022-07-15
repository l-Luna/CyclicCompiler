package cyclic.lang.compiler.model.cyclic;

import org.junit.jupiter.api.Test;

import static cyclic.lang.compiler.CyclicAssertions.assertDoesntCompile;
import static cyclic.lang.compiler.CyclicAssertions.compile;

class CyclicFieldTest{
	
	@Test
	void testTypeValidation(){
		compile("class T{ int t; }");
		assertDoesntCompile("class T{ var t; }");
		assertDoesntCompile("class T{ void t; }");
	}
	
	@Test
	void testVisibilityChecks(){
		assertDoesntCompile("class T{ StringLatin1 t; }");
	}
}