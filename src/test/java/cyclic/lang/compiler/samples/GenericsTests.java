package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.problems.CompileTimeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static cyclic.lang.compiler.CyclicAssertions.*;

public class GenericsTests{
	
	@Test
	void testJdkGenerics(){
		assertEquals("yes", """
				static String test(){
					List<String> list = new ArrayList<String>();
					list.add("yes");
					return list.get(0);
				}
				""");
		
		assertThrows(CompileTimeException.class, """
				static void test(){
					List<String> list = new ArrayList<String>();
					list.add(0);
				}
				""");
		
		assertEquals("yes", """
				static String test(){
					List<String> list = List.<String>of("yes");
					return list.get(0);
				}
				""");
		
		// TODO: unchecked warning
		assertEquals(List.of("yes"), """
				static List<String> test(){
					List<String> list = List.of("yes");
					return list;
				}
				""");
		
		assertThrows(CompileTimeException.class, """
				static void test(){
					List<String> list = List.<Integer>of("yes");
				}
				""");
		
		assertThrows(CompileTimeException.class, """
				static List<String> test(){
					List<String> list = List.<Integer>of(1);
					return list;
				}
				""");
		
		assertThrows(CompileTimeException.class, """
				static void test(){
					List<String> list = List.<List<String>>of(List.<String>of("yes"));
				}
				""");
		
		assertEquals(null, """
				static void test(){
					List<List<String>> list = List.<List<String>>of(List.<String>of("yes"));
				}
				""");
		
		assertEquals("aabbcc", """
				static String test(){
					List<String> parts = List.<String>of("a", "ab", "bc", "c");
					String s = "";
					for(String p : parts)
						s += p;
					return s;
				}
				""");
		
		assertEquals("aabbcc", """
				static String test(){
					List<String> parts = List.of("a", "ab", "bc", "c");
					String s = "";
					for(String p : parts)
						s += p;
					return s;
				}
				""");
		
		assertDoesntCompile( """
				static void test(){
					List<Integer> is = List.of("a", "b", "c");
				}
				""");
		
		// TODO: warning
		compile("""
				static void test(){
					List<Integer> is = (List<Integer>)(List)List.of("a", "b", "c");
				}
				""");
		
		compile("""
				static void test(){
					List<String> l = new ArrayList<String>();
					l.add("a");
					List<String> l2 = List.copyOf(l);
				}
				""");
	}
	
	@Test
	void testClassLiteralGenerics(){
		compile("""
				static void test(){
					Class<Integer> clazz = Integer.class;
					Class<String> c2 = String.class;
					Class c3 = Class.class;
					Class<Integer> c4 = int.class;
					Class<Void> c5 = (Class<Void>)(Class)System.class;
					Class<Void> c6 = void.class;
				}
				""");
		
		assertDoesntCompile("""
				static void test(){
					Class<String> clazz = Integer.class;
					Class<Integer> c2 = String.class;
				}
				""");
		
		assertDoesntCompile("""
				static void test(){
					Class<int> clazz = int.class;
				}
				""");
	}
	
	@Test
	void testWrongParameterization(){
		assertDoesntCompile("""
				static void test(){
					String<Integer> s;
				}
				""");
		
		assertDoesntCompile("""
				static void test(){
					Class<String, String> clazz;
				}
				""");
		
		compile("""
				static void test(){
					Class<String> clazz;
				}
				""");
		
		assertDoesntCompile("""
				static void test(){
					Map<String, String, String> map;
				}
				""");
		
		assertDoesntCompile("""
				static void test(){
					Map<String> map;
				}
				""");
		
		compile("""
				static void test(){
					Map<String, String> clazz;
				}
				""");
		
		// TODO: improve error messages
		assertDoesntCompile("""
				static void test(){
					List<String> strs = List.<String, String>of("a", "b");
				}
				""");
		
		compile("""
				static void test(){
					List<String> strs = List.<String>of("a", "b");
				}
				""");
		
		assertDoesntCompile("""
				static void test(){
					Map<String, String> strs = Map.<String>of("a", "b");
				}
				""");
		
		compile("""
				static void test(){
					Map<String, String> strs = Map.<String, String>of("a", "b");
				}
				""");
		
		assertDoesntCompile("""
				static void test(){
					Class<int> clazz;
				}
				""");
		
		assertDoesntCompile("""
				static void test(){
					Class<void> clazz;
				}
				""");
	}
}