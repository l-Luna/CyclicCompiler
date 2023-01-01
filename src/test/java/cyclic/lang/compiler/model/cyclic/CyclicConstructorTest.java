package cyclic.lang.compiler.model.cyclic;

import org.junit.jupiter.api.Test;

import static cyclic.lang.compiler.CyclicAssertions.assertDoesntCompile;
import static cyclic.lang.compiler.CyclicAssertions.compile;

class CyclicConstructorTest{
	
	@Test
	void testValidate(){
		assertDoesntCompile("""
				// base library abstract class with no 0-arg ctors
				abstract class MR extends java.lang.module.ModuleReference{
					public new MR(){}
				}
				""");
		
		compile("""
				// base library abstract class with no 0-arg ctors
				abstract class MR extends java.lang.module.ModuleReference{
					public new MR(){ super(null, null); } // invalid args but its never run
				}
				""");
		
		compile("""
				class T implements Cloneable{
					public new T(){  }
				}
				""");
	}
}