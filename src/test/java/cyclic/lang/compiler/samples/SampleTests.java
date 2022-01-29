package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.Compiler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SampleTests{
	
	@Test
	void testEmptyMethod(){
		try{
			MethodHandles.Lookup lookup = MethodHandles.lookup();
			
			Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static void test();
					}
					""", lookup)
					.invoke(null);
			
			Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static void test(){}
					}
					""", lookup)
					.invoke(null);
			
			Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static void test() -> ;
					}
					""", lookup)
					.invoke(null);
			
		}catch(IllegalAccessException | InvocationTargetException e){
			throw new AssertionError(e);
		}
	}
	
	@Test
	void testSimpleMethods(){
		try{
			MethodHandles.Lookup lookup = MethodHandles.lookup();
			
			Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static void test() -> System.out.println("Hello from Cyclic! (1/2)");
					}
					""", lookup)
					.invoke(null);
			
			Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static void test(){
							System.out.println("Hello from Cyclic! (2/2)");
						}
					}
					""", lookup)
					.invoke(null);
			
			Assertions.assertEquals(1, Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int test() -> 1;
					}
					""", lookup)
					.invoke(null));
			
			Assertions.assertEquals("1", Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static String test() -> "1";
					}
					""", lookup)
					.invoke(null));
			
			Assertions.assertEquals(4, Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int test() -> (1 + 1) + (1 + 1);
					}
					""", lookup)
					.invoke(null));
			
			Assertions.assertEquals(0, Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int test() -> (1 + 1) - (1 + 1);
					}
					""", lookup)
					.invoke(null));
			
			Method oneOrTwo = Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int test(boolean one){
							if(one)
								return 1;
							else
								return 2;
						}
					}
					""", lookup);
			Assertions.assertEquals(1, oneOrTwo.invoke(null, true));
			Assertions.assertEquals(2, oneOrTwo.invoke(null, false));
			
			Method loops = Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int test(int times){
							int counter = 0;
							
							int x = 0;
							counter = counter;
							if(true)
								x = x;
							while(x < times){
								counter += 1;
								x += 1;
							}
							
							for(int b = 0; b < times; b++;){
								counter += 1;
								int z = b;
							}
							
							do{
								int f = 1;
								counter += f;
							}while(false);
							
							for(Object i : java.util.List.of(0, 0, 0))
								counter += (Integer)i;
							
							var array = new int[]{ 0, 1, 2, 3 };
							for(int y : array)
								counter += y;
							
							for(int y : array){
								for(Object i : java.util.List.of(0, 0, 0)){
									counter += (Integer)i;
								}
							}
							
							return counter;
						}
					}
					""", lookup);
			Assertions.assertEquals(207, loops.invoke(null, 100));
			
			Assertions.assertEquals("12", Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static String test() -> "1" + "2";
					}
					""", lookup)
					.invoke(null));
			
			Assertions.assertEquals("1k2345k", Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static String test(String obj) -> "1" + obj + "2" + "3" + "4" + "5" + obj;
					}
					""", lookup)
					.invoke(null, "k"));
			
			Assertions.assertEquals("12345", Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static String test() -> ("1" + "2") + ("3" + "4" + 5);
					}
					""", lookup)
					.invoke(null));
			
			Assertions.assertEquals("k".repeat(14 * 21), Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static String repetition(String obj) -> obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj
														+ obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj + obj;
					}
					""", lookup)
					.invoke(null, "k"));
			
			Assertions.assertEquals(26f, Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static float test(int obj) -> (float)(obj + 1) + 1;
					}
					""", lookup)
					.invoke(null, 24));
			
			Assertions.assertArrayEquals(new int[]{24}, (int[])Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int[] test(int obj) -> new int[]{obj};
					}
					""", lookup)
					.invoke(null, 24));
			
			Assertions.assertEquals(1, Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static int test(int obj) -> new int[]{obj}.length;
					}
					""", lookup)
					.invoke(null, 0));
			
			Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static void test(){
							boolean z = false;
							z = true;
							byte b = 0;
							b = 1;
							short s = 0;
							s = ((byte)1);
							s = 1;
							int i = 0;
							i = 1;
							i = -1;
							i = 3;
							i = 4;
							i = 5;
							i = 20;
							i = 12345678;
							i = 32766;
							i = 2147483646;
							long l = 0;
							l = 1;
							float f = 0;
							f = 1;
							double d = 0;
							d = 1;
							Object k = new Object();
							k = null;
							String str = "";
							str = null;
							Integer in = 5;
							int ini = in;
						}
					}
					""", lookup)
					.invoke(null);
			
			Assertions.assertEquals(Integer.class, Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static Object test() -> Integer.class;
					}
					""", lookup)
					.invoke(null));
			
			Assertions.assertEquals(int.class, Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static Object test() -> int.class;
					}
					""", lookup)
					.invoke(null));
			
			Assertions.assertEquals(void.class, Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						static Object test() -> void.class;
					}
					""", lookup)
					.invoke(null));
			
			Compiler.compileSingleMethod("""
					package cyclic.lang.compiler.samples;
					class Holder{
						Object test() -> this;
					}
					""", lookup);
			
		}catch(IllegalAccessException | InvocationTargetException e){
			throw new AssertionError(e);
		}
	}
	
	@Test
	void testAnnotations(){
		
		Compiler.compileString("""
				package cyclic.lang.compiler.samples;
				import java.lang.annotation.*;
				@Deprecated
				class Holder{
					@Deprecated(since = "3", forRemoval = false)
					@SuppressWarnings(new String[] {"unchecked"})
					@Retention(RetentionPolicy.RUNTIME)
					static void test() -> System.out.println("Hello from Cyclic! (1/2)");
				}
				""");
		
	}
}