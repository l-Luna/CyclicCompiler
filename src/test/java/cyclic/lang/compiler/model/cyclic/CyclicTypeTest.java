package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.CompilerLauncher;
import cyclic.lang.compiler.CyclicAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicTypeTest{
	
	@Test
	void testDefinitions(){
		assertAll(
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("class T{}")),
				
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("class T;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("interface T;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("enum T;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("@interface T;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("annotation T;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("record T(int component);")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("single T;")),
				
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("class permits;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("annotation annotation;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("class out;")),
				
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("class T<A, in B, out C, in class D, out class E>;")),
				
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("class T extends Object;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("class T implements Cloneable, java.io.Serializable;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("interface T extends Cloneable, java.io.Serializable;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("sealed class T permits F { final class F extends T; }")),
				
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T(Object component);")),
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("record T(Object component) { Object field; }")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("record T(Object component) { static Object template; Object component() -> component; }")),
				
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class E{ val A; val B; val C; }")),
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class E{ int A(3); }")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("enum E{ val A; val B; val C; }")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("enum E{ val A(); }")),
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("enum E{ val A; static E X = new E(); }")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("enum E{ val A(3); E(int i){  } }")),
				
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T{ U(); }")),
				
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("single S{ }")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("single S{ private S(){ } }")),
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("single S{ S(int i); }")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("single S{ S(int i); S(){ this(0); } }")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("single S{ S(); void test(){ System.out.println(S); } }")),
				
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("static single S{ }")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("static single S{ String text = \"\"; void test(){ System.out.println(text); } }")),
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("static abstract single S{  }"))
		);
	}
	
	@Test
	void testSupertypeValidation(){
		assertAll(
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T extends String;")),
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("class T extends java.util.List;")),
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("interface T implements java.util.List;")),
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("interface T extends Object;")),
				
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("annotation T;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("annotation T extends Object;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("annotation T implements java.lang.annotation.Annotation;")),
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("annotation T extends F { class F; }")),
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("annotation T implements java.io.Serializable;")),
				
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("enum T;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("enum T extends Object;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("enum T extends Enum;")),
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("enum T implements java.io.Serializable;")),
				() -> assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("enum T extends F { class F; }")),
				
				() -> assertDoesNotThrow(() -> CompilerLauncher.compileString("record T extends Object;"))
		);
	}
	
	@Test
	void testInvalidOverrides(){
		CyclicAssertions.assertDoesntCompile("""
				abstract class Super{
					abstract int a();
				}
				class Sub extends Super{
				}
				""");
		
		CyclicAssertions.compile("""
				abstract class Super{
					abstract int a();
				}
				class Sub extends Super{
					int a() -> 0;
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				abstract class Super{
					abstract int a();
				}
				class Sub extends Super{
					Integer a() -> 0;
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				abstract class Super{
					int a() -> 0;
				}
				class Sub extends Super{
					Integer a() -> 0;
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				interface IA{
					int a();
				}
				interface IB extends IA{
					int a() -> 0;
				}
				interface IC extends IB{
					String a() -> "";
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				interface IA{
					int a() -> 0;
				}
				interface IB{
					String a() -> "";
				}
				class Sub implements IA, IB{
				
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				interface IA{
					Long a() -> 0;
				}
				interface IB{
					String a() -> "";
				}
				class Sub implements IA, IB{
				
				}
				""");
		
		CyclicAssertions.compile("""
				interface IA{
					IA a() -> null;
				}
				interface IB{
					IB a() -> null;
				}
				class Sub implements IA, IB{
					Sub a() -> null;
				}
				""");
		
		CyclicAssertions.compile("""
				interface IF{
					boolean a();
				}
				class Super{
					boolean a() -> false;
				}
				class Sub extends Super implements IF{}
				""");
	}
}