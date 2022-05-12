package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.CompilerLauncher;
import org.junit.jupiter.api.Test;

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
		
		assertDoesNotThrow(() -> CompilerLauncher.compileString("""
				class T implements Cloneable{
					public T(){  }
				}
				"""));
	}
}