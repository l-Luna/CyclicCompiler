package cyclic.lang.compiler;

import cyclic.lang.compiler.problems.CompileTimeException;
import cyclic.lang.compiler.problems.ProblemsHolder;
import cyclic.lang.compiler.problems.WarningType;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Assertions;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CyclicAssertions{
	
	private static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();
	private static Set<WarningType> lastSuppressedWarns;
	
	public static Object evaluate(String sourceToEvaluate, @Nullable String methodName){
		String wrapped =
                """
				package cyclic.lang.compiler;
				import java.util.*;
				class Holder{
				""" + sourceToEvaluate + "}";
		try{
			return methodName == null
					? CompilerLauncher.compileSingleMethod(wrapped, LOOKUP).invoke(null)
					: CompilerLauncher.compileSingleMethod(wrapped, methodName, LOOKUP).invoke(null);
		}catch(IllegalAccessException | InvocationTargetException e){
			throw new RuntimeException(e);
		}finally{
			lastSuppressedWarns = new HashSet<>(ProblemsHolder.warned);
			ProblemsHolder.warned.clear();
		}
	}
	
	public static void compile(String sourceToCompile){
		String wrapped =
				"""
				package cyclic.lang.compiler;
				import java.util.*;
				class Holder{
				""" + sourceToCompile + "}";
		try{
			CompilerLauncher.compileString(wrapped);
		}finally{
			lastSuppressedWarns = new HashSet<>(ProblemsHolder.warned);
			ProblemsHolder.warned.clear();
		}
	}
	
	public static void assertThrows(Class<? extends Throwable> expected, String sourceToEvaluate){
		try{
			try{
				evaluate(sourceToEvaluate, null);
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
				throw new AssertionError("Expected " + expected.getName() + " but got " + t.getClass().getName(), t);
		}
	}
	
	public static void assertEquals(@Nullable Object expected, String sourceToEvaluate){
		Object actual = evaluate(sourceToEvaluate, null);
		if(!Objects.equals(expected, actual))
			throw new AssertionError("Expected " + expected + " but got " + actual);
	}
	
	public static void assertInstanceof(Class<?> expected, String sourceToEvaluate){
		Object actual = evaluate(sourceToEvaluate, null);
		if(!expected.isInstance(actual))
			throw new AssertionError("Expected object of type " + expected + " but got " + actual);
	}
	
	public static void assertWarns(WarningType warningType, String sourceToEvaluate){
		compile(sourceToEvaluate);
		if(!lastSuppressedWarns.contains(warningType))
			throw new AssertionError("Expected warning \"" + warningType.ID + "\" to be issued");
	}
	
	public static void assertDoesNotWarn(WarningType warningType, String sourceToEvaluate){
		compile(sourceToEvaluate);
		if(lastSuppressedWarns.contains(warningType))
			throw new AssertionError("Expected warning \"" + warningType.ID + "\" not to be issued");
	}
	
	public static void assertDoesntCompile(String sourceToCompile){
		Assertions.assertThrows(CompileTimeException.class, () -> compile(sourceToCompile));
	}
}