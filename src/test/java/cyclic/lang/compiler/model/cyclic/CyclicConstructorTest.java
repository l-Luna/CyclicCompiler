package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.CompilerLauncher;
import cyclic.lang.compiler.problems.CompileTimeException;
import org.junit.jupiter.api.Test;

import static cyclic.lang.compiler.CyclicAssertions.compile;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CyclicConstructorTest{
	
	@Test
	void testValidate(){
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
				import java.lang.module.*;   // base library abstract class with no 0-arg ctors
				abstract class MR extends ModuleReference{
					public MR(){}
				}
				"""));
		
		assertDoesNotThrow(() -> CompilerLauncher.compileString("""
				import java.lang.module.*;   // base library abstract class with no 0-arg ctors
				abstract class MR extends ModuleReference{
					public MR(){ super(null, null); } // invalid args but its never run
				}
				"""));
		
		compile("""
				class T implements Cloneable{
					public T(){  }
				}
				""");
	}
}