package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.model.CallableReference;
import cyclic.lang.compiler.model.instructions.Statement;

public interface CyclicCallable extends CallableReference, CyclicMember{
	
	Statement getBody();
}