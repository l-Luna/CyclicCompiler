package cyclic.lang.compiler.model.external;

import cyclic.lang.compiler.model.AccessFlags;
import cyclic.lang.compiler.model.CallableReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// An instance constructor for a system type
public class SystemCtorRef implements CallableReference{
	Constructor<?> underlying;
	
	public SystemCtorRef(Constructor<?> underlying){
		this.underlying = underlying;
	}
	
	public TypeReference in(){
		return Utils.forAnyClass(underlying.getDeclaringClass());
	}
	
	public List<TypeReference> parameters(){
		return Arrays.stream(underlying.getParameterTypes()).map(Utils::forAnyClass).collect(Collectors.toList());
	}
	
	public List<String> parameterNames(){
		// class files don't necessarily have this information
		return Collections.emptyList();
	}
	
	public AccessFlags flags(){
		return Utils.fromBitfield(underlying.getModifiers());
	}
	
	// System static constructors are none of our business.
	public boolean isStatic(){
		return false;
	}
}
