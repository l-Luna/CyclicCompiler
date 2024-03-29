package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CompilerLauncher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;

public class OperationsTests{
	
	@Test
	void testBasicOps() throws IllegalAccessException, InvocationTargetException{
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		// TODO: rewrite with CyclicAssertions
		
		Assertions.assertEquals(5, CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int test(int x) -> +x;
					}
					""", lookup)
				.invoke(null, 5));
		
		Assertions.assertEquals(-5, CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int test(int x) -> -x;
					}
					""", lookup)
				.invoke(null, 5));
		
		Assertions.assertEquals(-5L, CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static long test(long x) -> -x;
					}
					""", lookup)
				.invoke(null, 5L));
		
		Assertions.assertEquals(-5F, CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static float test(float x) -> -x;
					}
					""", lookup)
				.invoke(null, 5F));
		
		Assertions.assertEquals(-5D, CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static double test(double x) -> -x;
					}
					""", lookup)
				.invoke(null, 5D));
		
		Assertions.assertEquals(false, CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static boolean test(boolean x) -> !x;
					}
					""", lookup)
				.invoke(null, true));
		
		Assertions.assertEquals(true, CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static boolean test(int x) -> x > 3;
					}
					""", lookup)
				.invoke(null, 5));
		
		Assertions.assertEquals(false, CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static boolean test(int x) -> x < 3;
					}
					""", lookup)
				.invoke(null, 5));
		
		Assertions.assertEquals(10 << 2, CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int test(int x) -> x << 2;
					}
					""", lookup)
				.invoke(null, 10));
		
		Assertions.assertEquals(10 >> 2, CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int test(int x) -> x >> 2;
					}
					""", lookup)
				.invoke(null, 10));
		
		Assertions.assertEquals(10 >>> 2, CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int test(int x) -> x >>> 2;
					}
					""", lookup)
				.invoke(null, 10));
	}
	
	@Test
	void testAssignOps() throws IllegalAccessException, InvocationTargetException{
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		
		Assertions.assertArrayEquals(new int[]{ 1, 1 }, (int[])CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int[] test(int x) -> new int[] { ++x, x };
					}
					""", lookup)
				.invoke(null, 0));
		
		Assertions.assertArrayEquals(new int[]{ 0, 1 }, (int[])CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int[] test(int x) -> new int[] { x++, x };
					}
					""", lookup)
				.invoke(null, 0));
		
		Assertions.assertArrayEquals(new int[]{ -1, -1 }, (int[])CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int[] test(int x) -> new int[] { --x, x };
					}
					""", lookup)
				.invoke(null, 0));
		
		Assertions.assertArrayEquals(new int[]{ 0, -1 }, (int[])CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int[] test(int x) -> new int[] { x--, x };
					}
					""", lookup)
				.invoke(null, 0));
		
		Assertions.assertArrayEquals(new int[]{ 5, 5 }, (int[])CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int[] test(int x) -> new int[] { x += 5, x };
					}
					""", lookup)
				.invoke(null, 0));
		
		Assertions.assertArrayEquals(new int[]{ 0, 0 }, (int[])CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int[] test(int x) -> new int[] { x %= 5, x };
					}
					""", lookup)
				.invoke(null, 5));
		
		Assertions.assertArrayEquals(new int[]{ 5, 7, 7 }, (int[])CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int[] test(int x) -> new int[] { x, x ^= 2, x };
					}
					""", lookup)
				.invoke(null, 5));
		
		Assertions.assertArrayEquals(new int[]{ 7, 7, 5 }, (int[])(CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int value = 0;
						static int[] test(int x) -> new int[] { value += x, value--, --value };
					}
					""", lookup)
				.invoke(null, 7)));
		
		Assertions.assertArrayEquals(new int[]{ 7, 7, 5 }, (int[])CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						int value = 0;
						static int[] test(int x){
							var h = new Holder();
							return new int[] { h.value += x, h.value--, --h.value };
						}
					}
					""", lookup)
				.invoke(null, 7));
		
		Assertions.assertArrayEquals(new int[]{ 8, 0, -2, 0 }, (int[])CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int[] value = new int[]{ 0, 1, 2 };
						static int[] test(int x) -> new int[] { value[1] += x, value[0]--, --value[0], value[2] %= 2 };
					}
					""", lookup)
				.invoke(null, 7));
		
		Assertions.assertArrayEquals(new int[]{ 8, 0, -2, 2}, (int[])CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						int[] value = new int[] { 0, 1, 2, 3 };
						static int[] test(int x){
							var h = new Holder();
							return new int[] { h.value[1] += x, h.value[0]--, --h.value[0], h.value[2] %= 3 };
						}
					}
					""", lookup)
				.invoke(null, 7));
	}
	
	@Test
	void testShortCircuitOps(){
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		
		Assertions.assertThrows(InvocationTargetException.class, () -> CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static boolean test(){
							String k = null;
							if(k != null & k.equals(""))
								return true;
							return false;
						}
					}
					""", lookup)
				.invoke(null));
		
		Assertions.assertDoesNotThrow(() -> CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static boolean test(){
							String k = null;
							if(k != null && k.equals(""))
								return true;
							return false;
						}
					}
					""", lookup)
				.invoke(null));
		
		Assertions.assertThrows(InvocationTargetException.class, () -> CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static boolean test(){
							String k = null;
							if(k == null | k.equals(""))
								return true;
							return false;
						}
					}
					""", lookup)
				.invoke(null));
		
		Assertions.assertDoesNotThrow(() -> CompilerLauncher.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static boolean test(){
							String k = null;
							if(k == null || k.equals(""))
								return true;
							return false;
						}
					}
					""", lookup)
				.invoke(null));
	}
}