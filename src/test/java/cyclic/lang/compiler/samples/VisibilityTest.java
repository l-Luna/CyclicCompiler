package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CompilerLauncher;
import cyclic.lang.compiler.problems.CompileTimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: cross-package visibility tests
public class VisibilityTest{
	
	@Test
	void testConstructorVisibility(){
		CompilerLauncher.compileString("""
				class Holder{
					class A{
						public A();
					}
					class B{
						Object test() -> new A();
					}
				}
				""");
		
		CompilerLauncher.compileString("""
				class Holder{
					class A{
						protected A();
					}
					class B{
						Object test() -> new A();
					}
				}
				""");
		
		CompilerLauncher.compileString("""
				class Holder{
					class A{
						A();
					}
					class B{
						Object test() -> new A();
					}
				}
				""");
		
		Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
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
		CompilerLauncher.compileString("""
				class Holder{
					class A{
						public Object field = null;
					}
					class B{
						Object test() -> new A().field;
					}
				}
				""");
		
		CompilerLauncher.compileString("""
				class Holder{
					class A{
						protected Object field = null;
					}
					class B{
						Object test() -> new A().field;
					}
				}
				""");
		
		CompilerLauncher.compileString("""
				class Holder{
					class A{
						Object field = null;
					}
					class B{
						Object test() -> new A().field;
					}
				}
				""");
		
		Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
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
		CompilerLauncher.compileString("""
				class Holder{
					class A{
						public Object method() -> null;
					}
					class B{
						Object test() -> new A().method();
					}
				}
				""");
		
		CompilerLauncher.compileString("""
				class Holder{
					class A{
						protected Object method() -> null;
					}
					class B{
						Object test() -> new A().method();
					}
				}
				""");
		
		CompilerLauncher.compileString("""
				class Holder{
					class A{
						Object method() -> null;
					}
					class B{
						Object test() -> new A().method();
					}
				}
				""");
		
		Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
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
		CompilerLauncher.compileString("""
				class Holder{
					class A;
					class B{
						Object test() -> A.class;
					}
				}
				""");
		
		Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
				class Holder{
					private class A;
					class B{
						Object test() -> A.class;
					}
				}
				"""));
	}
}