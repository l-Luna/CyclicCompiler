package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.problems.CompileTimeException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static cyclic.lang.compiler.CyclicAssertions.assertEquals;
import static cyclic.lang.compiler.CyclicAssertions.assertThrows;

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
	}
}