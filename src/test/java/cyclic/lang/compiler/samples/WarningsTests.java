package cyclic.lang.compiler.samples;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.CyclicAssertions;
import org.junit.jupiter.api.Test;

public class WarningsTests{
	
	@Test
	void testDeprecated(){
		CyclicAssertions.assertWarns(Constants.SUPPRESS_DEPRECATED, """
				@Deprecated
				static String s;
				
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertDoesNotWarn(Constants.SUPPRESS_DEPRECATED, """
				@Deprecated
				static String s;
				
				@SuppressWarnings("deprecation")
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertDoesNotWarn(Constants.SUPPRESS_DEPRECATED, """
				@Deprecated
				static String s;
				
				@SuppressWarnings(new String[]{"deprecation"})
				static void test(){
					s = "";
				}
				""");
		
		CyclicAssertions.assertWarns(Constants.SUPPRESS_DEPRECATED, """
				@Deprecated
				static String s;
				
				static String test() -> return s = "";
				""");
		
		CyclicAssertions.assertWarns(Constants.SUPPRESS_DEPRECATED, """
				@Deprecated
				class T;
				
				static Object test() -> T.class;
				""");
		
		CyclicAssertions.assertWarns(Constants.SUPPRESS_DEPRECATED, """
				@Deprecated
				static void bad();
				
				static void test() -> bad();
				""");
		
		CyclicAssertions.assertWarns(Constants.SUPPRESS_DEPRECATED, """
				@Deprecated
				static Object bad() -> null;
				
				static Object test() -> return bad();
				""");
		
		CyclicAssertions.assertWarns(Constants.SUPPRESS_DEPRECATED, """
				@Deprecated
				class T;
				
				static Object test() -> (T)null;
				""");
		
		CyclicAssertions.assertWarns(Constants.SUPPRESS_DEPRECATED, """
				@Deprecated
				class T;
				
				static Object test() -> (T)(new Object());
				""");
		
		CyclicAssertions.assertWarns(Constants.SUPPRESS_DEPRECATED, """
				class T{
					@Deprecated
					public T();
				}
				
				static Object test() -> new T();
				""");
		
		CyclicAssertions.assertWarns(Constants.SUPPRESS_DEPRECATED, """
				class T{
					@Deprecated
					public T();
					
					public T(String dummy){
						this();
					}
				}
				""");
	}
	
	// TODO: test @MustUse
	//  - requires adding stdlib to tests
	//  - could add pretend types, would be better to make fully available for other tests though
}