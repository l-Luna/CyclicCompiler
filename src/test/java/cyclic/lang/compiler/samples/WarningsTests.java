package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.CyclicAssertions;
import cyclic.lang.compiler.problems.WarningType;
import org.junit.jupiter.api.Test;

public class WarningsTests{
	
	@Test
	void testDeprecated(){
		CyclicAssertions.assertWarns(WarningType.DEPRECATION, """
				@Deprecated
				static String s;
				
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertDoesNotWarn(WarningType.DEPRECATION, """
				@Deprecated
				static String s;
				
				@SuppressWarnings("deprecation")
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertDoesNotWarn(WarningType.DEPRECATION, """
				@Deprecated
				static String s;
				
				@SuppressWarnings(new String[]{"deprecation"})
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertWarns(WarningType.DEPRECATION, """
				@Deprecated
				static String s;
				
				static String test() -> return s = "";
				""");
		
		CyclicAssertions.assertWarns(WarningType.DEPRECATION, """
				@Deprecated
				class T;
				
				static Object test() -> T.class;
				""");
		
		CyclicAssertions.assertWarns(WarningType.DEPRECATION, """
				@Deprecated
				static void bad();
				
				static void test() -> bad();
				""");
		
		CyclicAssertions.assertWarns(WarningType.DEPRECATION, """
				@Deprecated
				static Object bad() -> null;
				
				static Object test() -> return bad();
				""");
		
		CyclicAssertions.assertWarns(WarningType.DEPRECATION, """
				@Deprecated
				class T;
				
				static Object test() -> (T)null;
				""");
		
		CyclicAssertions.assertWarns(WarningType.DEPRECATION, """
				@Deprecated
				class T;
				
				static Object test() -> (T)(new Object());
				""");
		
		CyclicAssertions.assertWarns(WarningType.DEPRECATION, """
				class T{
					@Deprecated
					public T();
				}
				
				static Object test() -> new T();
				""");
		
		CyclicAssertions.assertWarns(WarningType.DEPRECATION, """
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
		CyclicAssertions.assertWarns(WarningType.IMPOSSIBLE_CAST, """
				static Integer zero() -> 0;
				
				static String test() -> (String)zero();
				""");
		
		CyclicAssertions.assertDoesNotWarn(WarningType.IMPOSSIBLE_CAST, """
				static Integer zero() -> 0;
				
				@SuppressWarnings("impossible_cast")
				static String test() -> (String)zero();
				""");
		
		CyclicAssertions.assertDoesNotWarn(WarningType.IMPOSSIBLE_CAST, """
				static Object zero() -> (Integer)0;
				
				static String test() -> (String)zero();
				""");
		
		CyclicAssertions.assertDoesNotWarn(WarningType.IMPOSSIBLE_CAST, """
				static ArrayList empty() -> new ArrayList();
				
				static List test() -> (List)empty();
				""");
	}
	
	// TODO: test @MustUse
	//  - requires adding stdlib to tests
	//  - could use stubs as necessary, would be better to make stdlib fully available for other tests though
}