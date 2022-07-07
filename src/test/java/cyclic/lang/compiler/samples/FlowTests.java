package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.CompilerLauncher;
import cyclic.lang.compiler.CyclicAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlowTests{
	
	@Test
	void testDefiniteAssignment(){
		CompilerLauncher.compileString("""
				class Holder{
					void test(){
						int a = 1;
						System.out.println(a);
					}
				}
				""");
		
		CompilerLauncher.compileString("""
				class Holder{
					void test(int a){
						System.out.println(a);
					}
				}
				""");
		
		Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
				class Holder{
					void test(){
						System.out.println(a);
					}
				}
				"""));
		
		Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
				class Holder{
					void test(){
						int a;
						System.out.println(a);
					}
				}
				"""));
		
		Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
				class Holder{
					void test(boolean def){
						int a;
						if(def)
							a = 1;
						System.out.println(a);
					}
				}
				"""));
		
		CompilerLauncher.compileString("""
				class Holder{
					void test(boolean def){
						int a;
						if(def)
							a = 1;
						else
							a = 2;
						System.out.println(a);
					}
				}
				""");
		
		CompilerLauncher.compileString("""
				class Holder{
					void test(boolean def){
						int a;
						if(def)
							a = 1;
						else
							return;
						System.out.println(a);
					}
				}
				""");
		
		CompilerLauncher.compileString("""
				class Holder{
					void test(boolean def){
						int a;
						if(def)
							a = 1;
						else
							throw new IllegalStateException();
						System.out.println(a);
					}
				}
				""");
		
		CompilerLauncher.compileString("""
				class Holder{
					void test(boolean def){
						int a;
						if(def){
							a = 1;
							System.out.println(a);
						}
					}
				}
				""");
		
		Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
				class Holder{
					void test(boolean def){
						int a;
						if(def)
							System.out.println(a);
						else
							a = 1;
					}
				}
				"""));
		
		Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
				class Holder{
					void test(boolean def){
						int a;
						if(def)
							a = 1;
						else
							System.out.println(a);
					}
				}
				"""));
		
		CompilerLauncher.compileString("""
				class Holder{
					void test(boolean def){
						int a;
						do{
							a = 1;
						}while(def);
						System.out.println(a);
					}
				}
				""");
		
		CompilerLauncher.compileString("""
				class Holder{
					void test(boolean def){
						int a;
						for(a = 1; false;);
						System.out.println(a);
					}
				}
				""");
		
		Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
				class Holder{
					void test(boolean def){
						int a;
						while(def)
							a = 1;
						System.out.println(a);
					}
				}
				"""));
		
		Assertions.assertThrows(CompileTimeException.class, () -> CompilerLauncher.compileString("""
				class Holder{
					void test(boolean def){
						int a;
						for(; false;)
							a = 1;
						System.out.println(a);
					}
				}
				"""));
	}
	
	@Test
	void testFinalFieldAssignment(){
		CyclicAssertions.compile("""
				static final int i = 0;
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				static final int i;
				""");
		
		CyclicAssertions.compile("""
				static final int i;
				static{
					i = 0;
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				static final int i;
				static{
					i = 0;
					i = 1;
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				static final int i;
				static{
					i = 0;
				}
				static{
					i = 1;
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				static final int i;
				static{
					if(Math.random() > 0.5)
						i = 0;
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				static final int i = 0;
				static void u(){
					i = 0;
				}
				""");
	}
}