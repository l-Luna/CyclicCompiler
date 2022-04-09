package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.CompilerLauncher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CyclicFieldTest{
	
	@Test
	void testTypeValidation(){
		assertDoesNotThrow(() -> CompilerLauncher.compileString("class T{ int t; }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ var t; }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ void t; }"));
	}
	
	@Test
	void testVisibilityChecks(){
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ StringLatin1 t; }"));
	}
}