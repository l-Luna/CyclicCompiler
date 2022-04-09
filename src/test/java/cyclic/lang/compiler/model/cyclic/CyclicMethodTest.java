package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.CompilerLauncher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CyclicMethodTest{
	
	@Test
	void testModifierValidation(){
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ abstract final void V(); }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ abstract static void V(); }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ abstract native void V(); }"));
		
		assertDoesNotThrow(() -> CompilerLauncher.compileString("class T{ void V(); }"));
		
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ abstract void V(){} }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ native void V(){} }"));
	}
	
	@Test
	void testSignatureValidation(){
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ void V(int x, int x){} }"));
		
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ int I(){} }"));
		assertDoesNotThrow(() -> CompilerLauncher.compileString("class T{ int I() -> 1; }"));
		assertDoesNotThrow(() -> CompilerLauncher.compileString("class T{ int I(){ return 1; } }"));
		assertDoesNotThrow(() -> CompilerLauncher.compileString("class T{ int I(boolean b){ if(b) return 1; else return 2; } }"));
		assertDoesNotThrow(() -> CompilerLauncher.compileString("class T{ int I() -> throw new RuntimeException(); }"));
		
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ int I(){ return; } }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ int I(){ return null; } }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ int I(){ return 1f; } }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ int I(){ return 1.0f; } }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ int I(){ return \"string\"; } }"));
		
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ int I(boolean b){ if(b) return 1; } }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ int I(int i){ for(int t = 0; t < i; t += 1;) return 1; } }"));
		assertDoesNotThrow(() -> CompilerLauncher.compileString("class T{ int I(boolean b){ if(b) return 1; return 2; } }"));
	}
	
	@Test
	void testVisibilityChecks(){
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ void V(){ StringLatin1 sl; } }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ void V(StringLatin1 sl){} }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ void V(){ Object o = (StringLatin1)null; } }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ void V(){ Class o = StringLatin1.class; } }"));
	}
	
	@Test
	void testAllowed(){
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("record T(int i){ double i() -> 0.0; }"));
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("enum T{ static T valueOf(String s) -> null; }"));
	}
	
	@Test
	void testVarAssignedBeforeUse(){
		assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ double i(){ int e; return e; } }"));
		assertDoesNotThrow(() -> CompilerLauncher.compileString("class T{ double i(){ int e = 1; return e; } }"));
		assertDoesNotThrow(() -> CompilerLauncher.compileString("class T{ double i(){ int e; e = 2; return e; } }"));
	}
}