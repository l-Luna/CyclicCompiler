package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.Compiler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VisibilityTest{
	
	// Note that private members are not visible within the same file, unlike in Java; no implicit nesting.
	// This does make private classes useless currently...
	// TODO: cross-package visibility tests
	
	@Test
	void testConstructorVisibility(){
		Compiler.compileString("""
				class Holder{
					class A{
						public A();
					}
					class B{
						Object test() -> new A();
					}
				}
				""");
		
		Compiler.compileString("""
				class Holder{
					class A{
						protected A();
					}
					class B{
						Object test() -> new A();
					}
				}
				""");
		
		Compiler.compileString("""
				class Holder{
					class A{
						A();
					}
					class B{
						Object test() -> new A();
					}
				}
				""");
		
		Assertions.assertThrows(CompileTimeException.class, () -> Compiler.compileString("""
				class Holder{
					class A{
						private A();
					}
					class B{
						Object test() -> new A();
					}
				}
				"""));
	}
	
	@Test
	void testFieldVisibility(){
		Compiler.compileString("""
				class Holder{
					class A{
						public Object field = null;
					}
					class B{
						Object test() -> new A().field;
					}
				}
				""");
		
		Compiler.compileString("""
				class Holder{
					class A{
						protected Object field = null;
					}
					class B{
						Object test() -> new A().field;
					}
				}
				""");
		
		Compiler.compileString("""
				class Holder{
					class A{
						Object field = null;
					}
					class B{
						Object test() -> new A().field;
					}
				}
				""");
		
		Assertions.assertThrows(CompileTimeException.class, () -> Compiler.compileString("""
				class Holder{
					class A{
						private Object field = null;
					}
					class B{
						Object test() -> new A().field;
					}
				}
				"""));
	}
	
	@Test
	void testMethodVisibility(){
		Compiler.compileString("""
				class Holder{
					class A{
						public Object method() -> null;
					}
					class B{
						Object test() -> new A().method();
					}
				}
				""");
		
		Compiler.compileString("""
				class Holder{
					class A{
						protected Object method() -> null;
					}
					class B{
						Object test() -> new A().method();
					}
				}
				""");
		
		Compiler.compileString("""
				class Holder{
					class A{
						Object method() -> null;
					}
					class B{
						Object test() -> new A().method();
					}
				}
				""");
		
		Assertions.assertThrows(CompileTimeException.class, () -> Compiler.compileString("""
				class Holder{
					class A{
						private Object method() -> null;
					}
					class B{
						Object test() -> new A().method();
					}
				}
				"""));
	}
	
	@Test
	void testClassVisibility(){
		Compiler.compileString("""
				class Holder{
					class A;
					class B{
						Object test() -> A.class;
					}
				}
				""");
		
		Assertions.assertThrows(CompileTimeException.class, () -> Compiler.compileString("""
				class Holder{
					private class A;
					class B{
						Object test() -> A.class;
					}
				}
				"""));
	}
}