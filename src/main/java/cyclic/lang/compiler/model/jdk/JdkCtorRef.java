package cyclic.lang.compiler.model.jdk;

import cyclic.lang.compiler.model.AccessFlags;
import cyclic.lang.compiler.model.ConstructorReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// An instance constructor for a system type
public class JdkCtorRef implements ConstructorReference{
	Constructor<?> underlying;
	
	public JdkCtorRef(Constructor<?> underlying){
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
	
	public boolean isVarargs(){
		return underlying.isVarArgs();
	}
}