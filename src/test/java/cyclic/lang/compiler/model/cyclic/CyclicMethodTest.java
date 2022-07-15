package cyclic.lang.compiler.model.cyclic;

import org.junit.jupiter.api.Test;

import static cyclic.lang.compiler.CyclicAssertions.assertDoesntCompile;
import static cyclic.lang.compiler.CyclicAssertions.compile;

class CyclicMethodTest{
	
	@Test
	void testModifierValidation(){
		assertDoesntCompile("class T{ abstract final void V(); }");
		assertDoesntCompile("class T{ abstract static void V(); }");
		assertDoesntCompile("class T{ abstract native void V(); }");
		
		compile("class T{ void V(); }");
		
		assertDoesntCompile("class T{ abstract void V(){} }");
		assertDoesntCompile("class T{ native void V(){} }");
	}
	
	@Test
	void testSignatureValidation(){
		assertDoesntCompile("class T{ void V(int x, int x){} }");
		
		assertDoesntCompile("class T{ int I(){} }");
		compile("class T{ int I() -> 1; }");
		compile("class T{ int I(){ return 1; } }");
		compile("class T{ int I(boolean b){ if(b) return 1; else return 2; } }");
		compile("class T{ int I() -> throw new RuntimeException(); }");
		
		assertDoesntCompile("class T{ int I(){ return; } }");
		assertDoesntCompile("class T{ int I(){ return null; } }");
		assertDoesntCompile("class T{ int I(){ return 1f; } }");
		assertDoesntCompile("class T{ int I(){ return 1.0f; } }");
		assertDoesntCompile("class T{ int I(){ return \"string\"; } }");
		
		assertDoesntCompile("class T{ int I(boolean b){ if(b) return 1; } }");
		assertDoesntCompile("class T{ int I(int i){ for(int t = 0; t < i; t += 1;) return 1; } }");
		compile("class T{ int I(boolean b){ if(b) return 1; return 2; } }");
	}
	
	@Test
	void testVisibilityChecks(){
		assertDoesntCompile("class T{ void V(){ StringLatin1 sl; } }");
		assertDoesntCompile("class T{ void V(StringLatin1 sl){} }");
		assertDoesntCompile("class T{ void V(){ Object o = (StringLatin1)null; } }");
		assertDoesntCompile("class T{ void V(){ Class o = StringLatin1.class; } }");
	}
	
	@Test
	void testAllowed(){
		assertDoesntCompile("record T(int i){ double i() -> 0.0; }");
		assertDoesntCompile("enum T{ static T valueOf(String s) -> null; }");
	}
	
	@Test
	void testVarAssignedBeforeUse(){
		assertDoesntCompile("class T{ double i(){ int e; return e; } }");
		compile("class T{ double i(){ int e = 1; return e; } }");
		compile("class T{ double i(){ int e; e = 2; return e; } }");
	}
}