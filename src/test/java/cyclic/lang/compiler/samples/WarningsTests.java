package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CyclicAssertions;
import cyclic.lang.compiler.problems.ProblemType;
import org.junit.jupiter.api.Test;

public class WarningsTests{
	
	@Test
	void testDeprecated(){
		CyclicAssertions.assertWarns(ProblemType.DEPRECATION, """
				@Deprecated
				static String s;
				
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertDoesNotWarn(ProblemType.DEPRECATION, """
				@Deprecated
				static String s;
				
				@SuppressWarnings("deprecation")
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertDoesNotWarn(ProblemType.DEPRECATION, """
				@Deprecated
				static String s;
				
				@SuppressWarnings(new String[]{"deprecation"})
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertWarns(ProblemType.DEPRECATION, """
				@Deprecated
				static String s;
				
				static String test() -> return s = "";
				""");
		
		CyclicAssertions.assertWarns(ProblemType.DEPRECATION, """
				@Deprecated
				class T;
				
				static Object test() -> T.class;
				""");
		
		CyclicAssertions.assertWarns(ProblemType.DEPRECATION, """
				@Deprecated
				static void bad();
				
				static void test() -> bad();
				""");
		
		CyclicAssertions.assertWarns(ProblemType.DEPRECATION, """
				@Deprecated
				static Object bad() -> null;
				
				static Object test() -> return bad();
				""");
		
		CyclicAssertions.assertWarns(ProblemType.DEPRECATION, """
				@Deprecated
				class T;
				
				static Object test() -> (T)null;
				""");
		
		CyclicAssertions.assertWarns(ProblemType.DEPRECATION, """
				@Deprecated
				class T;
				
				static Object test() -> (T)(new Object());
				""");
		
		CyclicAssertions.assertWarns(ProblemType.DEPRECATION, """
				class T{
					@Deprecated
					public T();
				}
				
				static Object test() -> new T();
				""");
		
		CyclicAssertions.assertWarns(ProblemType.DEPRECATION, """
				class T{
					@Deprecated
					public T();
					
					public T(String dummy){
						this();
					}
				}
				""");
	}
	
	@Test
	void testImpossibleCast(){
		CyclicAssertions.assertWarns(ProblemType.IMPOSSIBLE_CAST, """
				static Integer zero() -> 0;
				
				static String test() -> (String)zero();
				""");
		
		CyclicAssertions.assertDoesNotWarn(ProblemType.IMPOSSIBLE_CAST, """
				static Integer zero() -> 0;
				
				@SuppressWarnings("impossible_cast")
				static String test() -> (String)zero();
				""");
		
		CyclicAssertions.assertDoesNotWarn(ProblemType.IMPOSSIBLE_CAST, """
				static Object zero() -> (Integer)0;
				
				static String test() -> (String)zero();
				""");
		
		CyclicAssertions.assertDoesNotWarn(ProblemType.IMPOSSIBLE_CAST, """
				static ArrayList empty() -> new ArrayList();
				
				static List test() -> (List)empty();
				""");
	}
	
	// TODO: test @MustUse
	//  - requires adding stdlib to tests
	//  - could use stubs as necessary, would be better to make stdlib fully available for other tests though
}