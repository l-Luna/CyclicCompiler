package cyclic.lang.compiler.model.external;

import cyclic.lang.compiler.model.AccessFlags;
import cyclic.lang.compiler.model.MethodReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SystemMethodRef implements MethodReference{
	Method underlying;
	
	public SystemMethodRef(Method underlying){
		this.underlying = underlying;
	}
	
	public TypeReference in(){
		return Utils.forAnyClass(underlying.getDeclaringClass());
	}
	
	public String name(){
		return underlying.getName();
	}
	
	public TypeReference returns(){
		return Utils.forAnyClass(underlying.getReturnType());
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
	
	public boolean isNative(){
		return Utils.isBitSet(underlying.getModifiers(), Opcodes.ACC_NATIVE);
	}
	
	public boolean isSynchronized(){
		return Utils.isBitSet(underlying.getModifiers(), Opcodes.ACC_SYNCHRONIZED);
	}
	
	public boolean isStatic(){
		return Utils.isBitSet(underlying.getModifiers(), Opcodes.ACC_STATIC);
	}
	
	public Object defaultValueForAnnotation(){
		return underlying.getDefaultValue();
	}
}
