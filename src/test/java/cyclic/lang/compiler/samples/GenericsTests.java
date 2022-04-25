package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CompileTimeException;
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
	}
}