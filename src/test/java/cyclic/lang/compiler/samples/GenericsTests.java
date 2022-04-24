package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CompileTimeException;
import org.junit.jupiter.api.Test;

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
	}
}