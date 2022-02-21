package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CompileTimeException;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;

import static cyclic.lang.compiler.Compiler.compileSingleMethod;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CallsTest{
	
	@Test
	void testMethodCalls() throws IllegalAccessException, InvocationTargetException{
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		
		assertEquals(5, compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				class Holder{
					static int test(String x) -> Integer.parseInt(x);
				}
				""", lookup).invoke(null, "5"));
		
		assertEquals(false, compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				class Holder{
					static boolean test(Object x) -> new Holder().equals(x);
				}
				""", lookup).invoke(null, (Object)null));
		
		assertThrows(CompileTimeException.class, () -> compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				class Holder{
					static boolean test(Object x) -> Integer.parseInt(x);
				}
				""", lookup).invoke(null, (Object)null));
		
		assertEquals("abcde", compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				class Holder{
					static String test() -> new String("abcde".toCharArray());
				}
				""", lookup).invoke(null));
	}
	
	@Test
	void testConvertedCalls() throws IllegalAccessException, InvocationTargetException{
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		
		assertEquals("5", compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				class Holder{
					static String test(int x) -> String.valueOf(x);
				}
				""", lookup).invoke(null, 5));
		
		assertEquals("5", compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				class Holder{
					static String test(char x) -> String.valueOf(x);
				}
				""", lookup).invoke(null, '5'));
		
		assertEquals("53", compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				class Holder{
					static String test(char x) -> String.valueOf((int)x);
				}
				""", lookup).invoke(null, '5'));
	}
	
	@Test
	void testPassedCalls() throws IllegalAccessException, InvocationTargetException{
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		
		assertEquals(5, compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				class Holder{
					static int test(String x) -> x |> Integer.parseInt();
				}
				""", lookup).invoke(null, "5"));
		
		assertEquals(false, compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				class Holder{
					static boolean test(Object x) -> x |> new Holder().equals();
				}
				""", lookup).invoke(null, (Object)null));
		
		//noinspection PrimitiveArrayArgumentToVarargsMethod
		assertEquals("abcde", compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				class Holder{
					static String test(char[] x) -> x |> new String();
				}
				""", lookup).invoke(null, "abcde".toCharArray()));
	}
}