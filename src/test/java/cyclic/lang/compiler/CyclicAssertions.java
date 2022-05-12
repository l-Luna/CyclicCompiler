package cyclic.lang.compiler;

import org.jetbrains.annotations.Nullable;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class CyclicAssertions{
	
	private static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();
	
	public static Object evaluate(String sourceToEvaluate){
		String wrapped =
                """
				package cyclic.lang.compiler;
				import java.util.*;
				class Holder{
				""" + sourceToEvaluate + "}";
		try{
			return CompilerLauncher.compileSingleMethod(wrapped, LOOKUP).invoke(null);
		}catch(IllegalAccessException | InvocationTargetException e){
			throw new RuntimeException(e);
		}
	}
	
	public static void assertThrows(Class<? extends Throwable> expected, String sourceToEvaluate){
		try{
			try{
				evaluate(sourceToEvaluate);
			}catch(RuntimeException e){
				// unwrap InvocationTargetExceptions
				if(e.getCause() instanceof InvocationTargetException)
					// RuntimeException -> InvocationTargetException -> underlying exception
					throw e.getCause().getCause();
				throw e;
			}
			// then check the exception type
		}catch(Throwable t){
			if(!expected.isInstance(t))
				throw new RuntimeException("Expected " + expected.getName() + " but got " + t.getClass().getName(), t);
		}
	}
	
	public static void assertEquals(@Nullable Object expected, String sourceToEvaluate){
		Object actual = evaluate(sourceToEvaluate);
		if(!Objects.equals(expected, actual))
			throw new RuntimeException("Expected " + expected + " but got " + actual);
	}
	
	public static void assertInstanceof(Class<?> expected, String sourceToEvaluate){
		Object actual = evaluate(sourceToEvaluate);
		if(!expected.isInstance(actual))
			throw new RuntimeException("Expected object of type " + expected + " but got " + actual);
	}
}