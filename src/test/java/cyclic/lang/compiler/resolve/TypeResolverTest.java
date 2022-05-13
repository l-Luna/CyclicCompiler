package cyclic.lang.compiler.resolve;

import cyclic.lang.compiler.CompilerLauncher;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TypeResolverTest{
	
	@Test
	void testClassResolution() throws IllegalAccessException, InvocationTargetException{
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		
		Method method = CompilerLauncher.compileSingleMethod("""
				package cyclic.lang.compiler.resolve;
				import cyclic.lang.compiler.resolve.XClass; // confuse import resolution due to ending with target name
				class XClass{
					static Class getJLClass(){
						return Class.class;
					}
				}
				""", lookup);
		assertEquals(Class.class, method.invoke(null));
	}
}