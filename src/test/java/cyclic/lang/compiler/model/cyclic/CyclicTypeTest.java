package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.Compiler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicTypeTest{
	
	@Test
	void testDefinitions(){
		assertAll(
				() -> assertDoesNotThrow(() -> Compiler.compileString("class T{}")),
				
				() -> assertDoesNotThrow(() -> Compiler.compileString("class T;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("interface T;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("enum T;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("@interface T;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("annotation T;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("record T(int component);")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("single T;")),
				
				() -> assertDoesNotThrow(() -> Compiler.compileString("class permits;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("annotation annotation;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("class out;")),
				
				() -> assertDoesNotThrow(() -> Compiler.compileString("class T<A, in B, out C, in class D, out class E>;")),
				
				() -> assertDoesNotThrow(() -> Compiler.compileString("class T extends Object;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("class T implements Cloneable, java.io.Serializable;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("interface T extends Cloneable, java.io.Serializable;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("sealed class T permits F { final class F extends T; }")),
				
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileString("class T(Object component);"))
		);
	}
	
	@Test
	void testSupertypeValidation(){
		assertAll(
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileString("class T extends String;")),
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileString("class T extends java.util.List;")),
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileString("interface T implements java.util.List;")),
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileString("interface T extends Object;")),
				
				() -> assertDoesNotThrow(() -> Compiler.compileString("annotation T;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("annotation T extends Object;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("annotation T implements java.lang.annotation.Annotation;")),
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileString("annotation T extends F { class F; }")),
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileString("annotation T implements java.io.Serializable;")),
				
				() -> assertDoesNotThrow(() -> Compiler.compileString("enum T;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("enum T extends Object;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("enum T extends Enum;")),
				() -> assertDoesNotThrow(() -> Compiler.compileString("enum T implements java.io.Serializable;")),
				() -> assertThrows(CompileTimeException.class, () -> Compiler.compileString("enum T extends F { class F; }"))
				
				//() -> assertDoesNotThrow(() -> Compiler.compileString("record T extends Object;"))
		);
	}
	
	@Test
	void testInheritanceValidation(){
	
	}
}