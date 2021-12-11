package cyclic.lang.compiler.model;

import java.util.List;

public interface MethodReference{
	
	TypeReference in();
	
	String name();
	
	TypeReference returns();
	
	List<TypeReference> parameters();
	
	List<String> parameterNames();
	
	AccessFlags flags();
	
	boolean isNative();
	
	boolean isSynchronized();
	
	boolean isStatic();
	
	// body: local vars, instructions
}