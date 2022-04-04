package cyclic.lang.compiler;

import cyclic.lang.compiler.model.TypeKind;
import cyclic.lang.compiler.model.external.ClassfileTypeRef;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AttributeTest{
	
	@Test
	void testAttributes(){
		var compiled = Compiler.compileSingleClass("single S;");
		ClassfileTypeRef ref = new ClassfileTypeRef(compiled);
		// skip resolution
		Assertions.assertEquals(TypeKind.SINGLE, ref.kind());
	}
}