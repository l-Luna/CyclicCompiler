package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.CompilerLauncher;
import cyclic.lang.compiler.problems.CompileTimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static cyclic.lang.compiler.CyclicAssertions.assertDoesntCompile;
import static cyclic.lang.compiler.CyclicAssertions.compile;
import static org.junit.jupiter.api.Assertions.assertAll;

class CyclicTypeTest{
	
	@Test
	void testDefinitions(){
		assertAll(
				() -> compile("class T{}"),
				
				() -> compile("class T;"),
				() -> compile("interface T;"),
				() -> compile("enum T;"),
				() -> compile("@interface T;"),
				() -> Assertions.assertDoesNotThrow(() -> CompilerLauncher.compileString("annotation T;")),
				() -> compile("record T(int component);"),
				() -> compile("single T;"),
				
				() -> compile("class permits;"),
				() -> Assertions.assertDoesNotThrow(() -> CompilerLauncher.compileString("annotation annotation;")),
				() -> compile("class out;"),
				
				() -> compile("class T<A, in B, out C, in class D, out class E>;"),
				
				() -> compile("class T extends Object;"),
				() -> compile("class T implements Cloneable, java.io.Serializable;"),
				() -> compile("interface T extends Cloneable, java.io.Serializable;"),
				() -> compile("sealed class T permits F { final class F extends T; }"),
				
				() -> assertDoesntCompile("class T(Object component);"),
				() -> assertDoesntCompile("record T(Object component) { Object field; }"),
				() -> compile("record T(Object component) { static Object template; Object component() -> component; }"),
				
				() -> compile("class T{ final void v(); }"),
				
				() -> assertDoesntCompile("class E{ val A; val B; val C; }"),
				() -> assertDoesntCompile("class E{ int A(3); }"),
				() -> compile("enum E{ val A; val B; val C; }"),
				() -> compile("enum E{ val A(); }"),
				() -> assertDoesntCompile("enum E{ val A; static E X = new E(); }"),
				() -> compile("enum E{ val A(3); E(int i){  } }"),
				
				() -> assertDoesntCompile("class T{ U(); }"),
				
				() -> compile("single S{ }"),
				() -> compile("single S{ private S(){ } }"),
				() -> assertDoesntCompile("single S{ S(int i); }"),
				() -> compile("single S{ S(int i); S(){ this(0); } }"),
				() -> compile("single S{ S(); void test(){ System.out.println(S); } }"),
				
				() -> compile("static single S{ }"),
				() -> compile("static single S{ String text = \"\"; void test(){ System.out.println(text); } }"),
				() -> assertDoesntCompile("static abstract single S{  }")
		);
	}
	
	@Test
	void testSupertypeValidation(){
		assertAll(
				() -> assertDoesntCompile("class T extends String;"),
				() -> assertDoesntCompile("class T extends java.util.List;"),
				() -> assertDoesntCompile("interface T implements java.util.List;"),
				() -> assertDoesntCompile("interface T extends Object;"),
				
				() -> Assertions.assertDoesNotThrow(() -> CompilerLauncher.compileString("annotation T;")),
				() -> Assertions.assertDoesNotThrow(() -> CompilerLauncher.compileString("annotation T extends Object;")),
				() -> Assertions.assertDoesNotThrow(() -> CompilerLauncher.compileString("annotation T implements java.lang.annotation.Annotation;")),
				() -> Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("annotation T extends F { class F; }")),
				() -> Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("annotation T implements java.io.Serializable;")),
				
				() -> compile("enum T;"),
				() -> compile("enum T extends Object;"),
				() -> compile("enum T extends Enum;"),
				() -> compile("enum T implements java.io.Serializable;"),
				() -> assertDoesntCompile("enum T extends F { class F; }"),
				
				() -> compile("record T extends Object;")
		);
	}
	
	@Test
	void testInvalidOverrides(){
		assertDoesntCompile("""
				abstract class Super{
					abstract int a();
				}
				class Sub extends Super{
				}
				""");
		
		compile("""
				abstract class Super{
					abstract int a();
				}
				class Sub extends Super{
					int a() -> 0;
				}
				""");
		
		assertDoesntCompile("""
				abstract class Super{
					abstract int a();
				}
				class Sub extends Super{
					Integer a() -> 0;
				}
				""");
		
		assertDoesntCompile("""
				abstract class Super{
					int a() -> 0;
				}
				class Sub extends Super{
					Integer a() -> 0;
				}
				""");
		
		assertDoesntCompile("""
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
		
		assertDoesntCompile("""
				interface IA{
					int a() -> 0;
				}
				interface IB{
					int a() -> 1;
				}
				class Sub implements IA, IB{
				
				}
				""");
		
		assertDoesntCompile("""
				interface IA{
					int a() -> 0;
				}
				interface IB{
					String a() -> "";
				}
				class Sub implements IA, IB{
				
				}
				""");
		
		assertDoesntCompile("""
				interface IA{
					Long a() -> 0;
				}
				interface IB{
					String a() -> "";
				}
				class Sub implements IA, IB{
				
				}
				""");
		
		compile("""
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
		
		assertDoesntCompile("""
				class A{
					void a();
				}
				abstract class B extends A{
					abstract void a();
				}
				abstract class C extends B;
				class D extends C;
				""");
		
		compile("""
				interface IF{
					boolean a();
				}
				class Super{
					boolean a() -> false;
				}
				abstract class Sub extends Super implements IF{}
				""");
		
		compile("""
				interface IF{
					boolean a();
				}
				class Super{
					boolean a() -> false;
				}
				class Sub extends Super implements IF{}
				""");
	}
	
	@Test
	void testInheritance(){
		compile("""
				class A extends B{
					
					void test() -> v();
					
					class B extends C;
					class C extends D;
					class D{
						void v();
					}
				}
				""");
	}
}