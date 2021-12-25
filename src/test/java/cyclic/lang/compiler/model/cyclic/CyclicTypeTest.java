package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.Compiler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CyclicTypeTest{
	
	@Test
	void testSupertypeValidation(){
		assertAll(
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileText("class T extends String;")),
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileText("class T extends java.util.List;")),
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileText("interface T implements java.util.List;")),
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileText("interface T extends Object;"))
		);
	}
}