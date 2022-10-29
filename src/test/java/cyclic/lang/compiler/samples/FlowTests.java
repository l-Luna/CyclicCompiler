package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CompilerLauncher;
import cyclic.lang.compiler.CyclicAssertions;
import cyclic.lang.compiler.problems.CompileTimeException;
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
		
		CyclicAssertions.compile("""
				void test(boolean a, boolean b, int i){
					if(a)
						if(b){
							int cc = i;
							cc = cc + 1;
						}
				}
				""");
		
		CyclicAssertions.compile("""
				void test(boolean a, boolean b, int i){
				    if(a){
				    
					}else if(b){
						int cc = i;
						cc = cc + 1;
					}
				}
				""");
		
		CyclicAssertions.compile("""
				void test(boolean a, boolean b, int i){
					while(a)
						if(b){
							int cc = i;
							cc = cc + 1;
						}
				}
				""");
	}
	
	@Test
	void testFinalFieldAssignment(){
		CyclicAssertions.compile("""
				final int i = 0;
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				final int i;
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				final int i;
				Holder(){}
				""");
		
		CyclicAssertions.compile("""
				final int i;
				Holder(){
					i = 0;
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				final int i;
				Holder(){
					i = 0;
					i = 1;
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				final int i;
				Holder(){
					i = 0;
					if(Math.random() > 0.5)
						i = 1;
				}
				""");
		
		CyclicAssertions.compile("""
				final int i;
				Holder(){
					i = 0;
				}
				Holder(int dummy){
					i = 1;
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				final int i;
				Holder(){
					i = 0;
				}
				Holder(int dummy){
					this();
					i = 1;
				}
				""");
		
		CyclicAssertions.compile("""
				final int i;
				Holder(){
					i = 0;
				}
				Holder(int dummy){
					this();
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				final int i;
				Holder(){
					if(Math.random() > 0.5)
						i = 0;
				}
				""");
		
		CyclicAssertions.assertDoesntCompile("""
				final int i = 0;
				void u(){
					i = 0;
				}
				""");
	}
	
	@Test
	void testStaticFinalFieldAssignment(){
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

		CyclicAssertions.compile("""
				static final String s;
				static{
					s = "".intern();
				}
				""");
	}
}