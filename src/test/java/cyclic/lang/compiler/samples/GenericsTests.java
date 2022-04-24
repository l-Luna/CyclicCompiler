package cyclic.lang.compiler.samples;

import org.junit.jupiter.api.Test;

import static cyclic.lang.compiler.CyclicAssertions.assertEquals;

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
	}
}