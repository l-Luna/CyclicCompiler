package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.Compiler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CyclicMethodTest{
	
	@Test
	void testModifierValidation(){
		assertThrows(CompileTimeException.class, () -> Compiler.compileString("class T{ abstract final void V(); }"));
		assertThrows(CompileTimeException.class, () -> Compiler.compileString("class T{ abstract static void V(); }"));
		assertThrows(CompileTimeException.class, () -> Compiler.compileString("class T{ abstract native void V(); }"));
		
		assertDoesNotThrow(() -> Compiler.compileString("class T{ void V(); }"));
		
		assertThrows(CompileTimeException.class, () -> Compiler.compileString("class T{ abstract void V(){} }"));
		assertThrows(CompileTimeException.class, () -> Compiler.compileString("class T{ native void V(){} }"));
	}
}