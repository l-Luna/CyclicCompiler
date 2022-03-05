package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CompileTimeException;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static cyclic.lang.compiler.Compiler.compileClass;
import static cyclic.lang.compiler.Compiler.compileSingleMethod;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CallsTests{
	
	@Test
	void testMethodCalls() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
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
		
		var conflicted = compileClass("""
				package cyclic.lang.compiler.samples;
				import java.util.*;
				class Holder{
					static int len(Object x) -> -1;
					static int len(String s) -> s.length();
					static int len(CharSequence x) -> x.length() * 3;
					
					static List test() -> List.of(len(new Object()), len("abcd"), len(new StringBuilder("abcd")));
					
					static int lenNull(Object x) -> -1;
					static int lenNull(String s) -> -2;
					
					static int test2() -> lenNull(null);
				}
				""", lookup);
		
		assertEquals(List.of(-1, 4, 12),
				conflicted.getDeclaredMethod("test").invoke(null));
		
		assertEquals(-2,
				conflicted.getDeclaredMethod("test2").invoke(null));
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
	void testVarargCalls() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		
		assertEquals(Arrays.asList(0, 1, 2, 3), compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				import java.util.*;
				class Holder{
					static List test() -> Arrays.asList(0, 1, 2, 3);
				}
				""", lookup).invoke(null));
		
		var holder = compileClass("""
				package cyclic.lang.compiler.samples;
				import java.util.*;
				class Holder{
					static int sumInt(int... parts){
						int total = 0;
						for(int p : parts)
							total += p;
						return total;
					}
					static long sumLong(long... parts){
						long total = 0;
						for(long p : parts)
							total += p;
						return total;
					}
					static int count(Object... in) -> in.length;
					static int count(String... in) -> in.length * 2;
					
					static int testNoSum() -> sumInt();
					static int testSumInt() -> sumInt(1, 2, 3, 4);
					static int testSumInt2() -> sumInt(1);
					static long testSumLong() -> sumLong(1, 2, 3, 4);
					static long testSumLongExplicit() -> sumLong(new long[]{1, 2, 3, 4});
					static int testCount() -> count(new Object(), "", new Object());
					static int testCountStrings() -> count("", "", "");
				}
				""", lookup);
		
		assertEquals(0, (int)holder.getDeclaredMethod("testNoSum").invoke(null));
		assertEquals(1 + 2 + 3 + 4, (int)holder.getDeclaredMethod("testSumInt").invoke(null));
		assertEquals(1, (int)holder.getDeclaredMethod("testSumInt2").invoke(null));
		assertEquals(1 + 2 + 3 + 4, (long)holder.getDeclaredMethod("testSumLong").invoke(null));
		assertEquals(1 + 2 + 3 + 4, (long)holder.getDeclaredMethod("testSumLongExplicit").invoke(null));
		assertEquals(3, (int)holder.getDeclaredMethod("testCount").invoke(null));
		assertEquals(6, (int)holder.getDeclaredMethod("testCountStrings").invoke(null));
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
		
		assertEquals(List.of(2, 1, 0), compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				import java.util.List;
				class Holder{
					static List test() -> 2 |> (1 |> (0 |> List.of()));
				}
				""", lookup).invoke(null));
		
		assertEquals("abcde", compileSingleMethod("""
				package cyclic.lang.compiler.samples;
				class Holder{
					static String test(String[] x){
						var b = new StringBuilder();
						for(String s : x)
							b = s |> b.append();
						return b.toString();
					}
				}
				""", lookup).invoke(null, (Object)new String[]{"a", "b", "c", "d", "e"}));
	}
}