package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.Compiler;
import cyclic.lang.compiler.CyclicAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

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
			
			CyclicAssertions.assertEquals(12, """
					static int test(){
						int i = 0;
						for(var e : java.lang.annotation.ElementType){
							i++;
						}
						return i;
					}
					""");
			
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
					static void test() -> System.out.println("Hello from Cyclic! (Annotations)");
				}
				""");
	}
	
	@Test
	void testGeneratedMethods() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		
		// Must use `defineClass` instead of normal hidden classes to avoid NoClassDefFoundError
		Class<?> holderEnum = lookup.defineClass(Compiler.compileSingleClass("""
				package cyclic.lang.compiler.samples;
				enum EnumHolder0{
					val A; val B; val C;
					
					static String all(){
						val builder = new StringBuilder();
						for(EnumHolder0 e : EnumHolder0){
							builder.append(e.name());
						}
						for(var e : EnumHolder0){
							builder.append(e.ordinal());
						}
						return builder.toString();
					}
				}
				"""));
		Method valuesMethod = holderEnum.getDeclaredMethod("values");
		var values = (Object[])valuesMethod.invoke(null);
		var moreValues = (Object[])valuesMethod.invoke(null);
		Assertions.assertNotNull(values);
		Assertions.assertEquals(values.length, 3);
		Assertions.assertNotEquals(values, moreValues);
		
		Method valOfMethod = holderEnum.getDeclaredMethod("valueOf", String.class);
		var valA = valOfMethod.invoke(null, "A");
		Assertions.assertNotNull(valA);
		Assertions.assertTrue(Arrays.asList(values).contains(valA));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			try{
				valOfMethod.invoke(null, "Fake");
			}catch(InvocationTargetException ite){
				throw ite.getCause();
			}
		});
		
		Method entriesMethod = holderEnum.getDeclaredMethod("entries");
		var entries = entriesMethod.invoke(null);
		var entriesAgain = entriesMethod.invoke(null);
		Assertions.assertNotNull(entries);
		Assertions.assertTrue(entries instanceof List<?>);
		Assertions.assertEquals(3, ((List<?>)entries).size());
		Assertions.assertSame(entries, entriesAgain);
		
		Method iterTestMethod = holderEnum.getDeclaredMethod("all");
		Assertions.assertEquals(iterTestMethod.invoke(null), "ABC012");
		
		Assertions.assertThrows(CompileTimeException.class, () -> Compiler.compileSingleClass("""
				package cyclic.lang.compiler.samples;
				enum EnumHolder1{
					static void all(){
						for(String e : EnumHolder1)
							;
					}
				}
				"""));
		
		Assertions.assertDoesNotThrow(() -> Compiler.compileSingleClass("""
				package cyclic.lang.compiler.samples;
				enum EnumHolder1{
					static void all(){
						for(Object e : EnumHolder1)
							;
					}
				}
				"""));
	}
	
	@Test
	void testTryCatch(){
		CyclicAssertions.assertEquals(1, """
				static int test(){
					try{
						return 1;
					}
				}
				""");
		
		CyclicAssertions.assertThrows(IllegalStateException.class, """
				static int test(){
					try{
						throw new IllegalStateException();
					}catch(IllegalArgumentException e){
						return 2;
					}
				}
				""");
		
		CyclicAssertions.assertEquals(2, """
				static int test(){
					try{
						throw new IllegalStateException();
					}catch(IllegalStateException e){
						return 2;
					}
				}
				""");
		
		CyclicAssertions.assertEquals(List.of(1, 3, 2), """
				static List test(){
					var collected = new ArrayList();
					for(int i = 0; i < 3; i++;){
						try{
							if(i % 3 == 0)
								throw new IllegalStateException();
							if(i % 3 == 1)
								throw new RuntimeException();
							if(i % 3 == 2)
								throw new IllegalArgumentException();
						}catch(IllegalStateException e){
							collected.add(1);
						}catch(IllegalArgumentException e){
							collected.add(2);
						}catch(RuntimeException e){
							collected.add(3);
						}
					}
					return collected;
				}
				""");
		
		CyclicAssertions.assertThrows(IllegalStateException.class, """
				static List test(){
					var collected = new ArrayList();
					for(int i = 0; i < 3; i++;){
						try{
							if(i % 3 == 0)
								throw new IllegalStateException();
							if(i % 3 == 1)
								throw new RuntimeException();
							if(i % 3 == 2)
								throw new IllegalArgumentException();
						}catch(IllegalStateException e){
							collected.add(1);
						}catch(IllegalArgumentException e){
							throw new IllegalStateException();
						}catch(RuntimeException e){
							collected.add(3);
						}
					}
					return collected;
				}
				""");
		
		CyclicAssertions.assertEquals(2, """
				static int test(){
					try{
						throw new IllegalStateException();
					}finally{
						return 2;
					}
				}
				""");
		
		CyclicAssertions.assertThrows(IllegalStateException.class, """
				static int test(){
					try{
						throw new IllegalStateException();
					}finally{
						// do nothing
					}
				}
				""");
		
		CyclicAssertions.assertEquals(3, """
				static int test(){
					try{
						throw new IllegalArgumentException();
					}catch(IllegalArgumentException e){
						throw new IllegalStateException();
					}finally{
						return 3;
					}
				}
				""");
		
		CyclicAssertions.assertThrows(IllegalStateException.class, """
				static int test(){
					try{
						throw new IllegalArgumentException();
					}catch(IllegalArgumentException e){
						throw new IllegalStateException();
					}finally{
						// do nothing
					}
				}
				""");
		
		CyclicAssertions.assertThrows(CompileTimeException.class, """
				static int test(){
					int i;
					try{
						i = 1;
						throw new IllegalArgumentException();
					}catch(IllegalArgumentException e){
						// do nothing
					}
					return i;
				}
				""");
		
		CyclicAssertions.assertEquals(2, """
				static int test(){
					int i = 0;
					try{
						i = 1;
						throw new IllegalArgumentException();
					}catch(IllegalArgumentException e){
						i = 2;
						// do nothing
					}
					return i;
				}
				""");
		
		CyclicAssertions.assertEquals(1, """
				static int test(){
					try{
						throw new IllegalArgumentException();
					}catch(IllegalArgumentException e){
						if(e != null)
							return 1;
					}
					return 0;
				}
				""");
		
		CyclicAssertions.assertEquals(3, """
				static int test(){
					int i = 0;
					try{
						i = 1;
						throw new IllegalArgumentException();
					}catch(IllegalArgumentException e){
						// do nothing
					}finally{
						i = 3;
					}
					return i;
				}
				""");
		
		// `finally` blocks should capture returns to ensure cleanup in all cases
		CyclicAssertions.assertEquals(3, """
				static int test(){
					try{
						return 1;
					}finally{
						return 3;
					}
				}
				""");
		
		CyclicAssertions.assertEquals(3, """
				static int test(){
					try{
						throw new IllegalStateException();
					}catch(IllegalStateException e){
						return -1;
					}finally{
						return 3;
					}
				}
				""");
		
		CyclicAssertions.assertEquals(3, """
				static int test(){
					try{
						throw new IllegalStateException();
					}catch(IllegalStateException e){
						try{
							return -1;
						}finally{
							return -2;
						}
					}finally{
						return 3;
					}
				}
				""");
	}
	
	@Test
	void testBreakContinue(){
		CyclicAssertions.assertEquals(99, """
				static int test(){
					int i = 0;
					while(true){
						i++;
						if(i == 99)
							break;
					}
					return i;
				}
				""");
		
		CyclicAssertions.assertEquals(List.of(1, 2, 4, 5), """
				static List test(){
					List list = new ArrayList();
					int i = 0;
					while(i < 6){
						i++;
						if(i == 6)
							continue;
						if(i == 3)
							continue;
						list.add(i);
					}
					return list;
				}
				""");
		
		CyclicAssertions.assertEquals(1 + 2 + 3, """
				static int test(){
					int total = 0;
					for(int i = 0; i < 5; i++;){
						total += i;
						if(i == 3)
							break;
					}
					return total;
				}
				""");
		
		CyclicAssertions.assertEquals(1 + 2 + 4 + 6, """
				static int test(){
					int total = 0;
					for(int i = 0; i < 7; i++;){
						if((i == 3) || (i == 5))
							continue;
						total += i;
					}
					return total;
				}
				""");
		
		CyclicAssertions.assertEquals(2, """
				static int test(){
					int i = 0;
					do{
						i++;
						if(i == 2)
							break;
					}while(i != 0);
					return i;
				}
				""");
		
		CyclicAssertions.assertEquals(List.of(1, 2, 3, 4, 5, 7), """
				static List test(){
					List list = new ArrayList();
					int i = 0;
					do{
						i++;
						if(i == 6)
							continue;
						if(i == 8)
							continue;
						list.add(i);
					}while(i < 8);
					return list;
				}
				""");
		
		CyclicAssertions.assertEquals(1 + 5 + 7, """
				static int test(){
					int i = 0;
					for(Object o : List.of(1, -2, 5, 7)){
						int oi = (Integer)o;
						if(oi == -2)
							continue;
						i += oi;
					}
					return i;
				}
				""");
	}
}