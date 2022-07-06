package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.CyclicAssertions;
import org.junit.jupiter.api.Test;

public class WarningsTests{
	
	@Test
	void testDeprecated(){
		CyclicAssertions.assertWarns(Constants.DEPRECATED_ID, """
				@Deprecated
				static String s;
				
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertDoesNotWarn(Constants.DEPRECATED_ID, """
				@Deprecated
				static String s;
				
				@SuppressWarnings("deprecation")
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertDoesNotWarn(Constants.DEPRECATED_ID, """
				@Deprecated
				static String s;
				
				@SuppressWarnings(new String[]{"deprecation"})
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertWarns(Constants.DEPRECATED_ID, """
				@Deprecated
				static String s;
				
				static String test() -> return s = "";
				""");
		
		CyclicAssertions.assertWarns(Constants.DEPRECATED_ID, """
				@Deprecated
				class T;
				
				static Object test() -> T.class;
				""");
		
		CyclicAssertions.assertWarns(Constants.DEPRECATED_ID, """
				@Deprecated
				static void bad();
				
				static void test() -> bad();
				""");
		
		CyclicAssertions.assertWarns(Constants.DEPRECATED_ID, """
				@Deprecated
				static Object bad() -> null;
				
				static Object test() -> return bad();
				""");
		
		CyclicAssertions.assertWarns(Constants.DEPRECATED_ID, """
				@Deprecated
				class T;
				
				static Object test() -> (T)null;
				""");
		
		CyclicAssertions.assertWarns(Constants.DEPRECATED_ID, """
				@Deprecated
				class T;
				
				static Object test() -> (T)(new Object());
				""");
		
		CyclicAssertions.assertWarns(Constants.DEPRECATED_ID, """
				class T{
					@Deprecated
					public T();
				}
				
				static Object test() -> new T();
				""");
		
		CyclicAssertions.assertWarns(Constants.DEPRECATED_ID, """
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
		CyclicAssertions.assertWarns(Constants.IMPOSSIBLE_CAST_ID, """
				static Integer zero() -> 0;
				
				static String test() -> (String)zero();
				""");
		
		CyclicAssertions.assertDoesNotWarn(Constants.IMPOSSIBLE_CAST_ID, """
				static Integer zero() -> 0;
				
				@SuppressWarnings("impossible_cast")
				static String test() -> (String)zero();
				""");
		
		CyclicAssertions.assertDoesNotWarn(Constants.IMPOSSIBLE_CAST_ID, """
				static Object zero() -> (Integer)0;
				
				static String test() -> (String)zero();
				""");
		
		CyclicAssertions.assertDoesNotWarn(Constants.IMPOSSIBLE_CAST_ID, """
				static ArrayList empty() -> new ArrayList();
				
				static List test() -> (List)empty();
				""");
	}
	
	// TODO: test @MustUse
	//  - requires adding stdlib to tests
	//  - could use stubs as necessary, would be better to make stdlib fully available for other tests though
}