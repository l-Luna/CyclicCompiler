package cyclic.lang.compiler.model.jdk;

import cyclic.lang.compiler.model.*;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JdkMethodRef implements MethodReference{
	Method underlying;
	
	public JdkMethodRef(Method underlying){
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
	
	public Set<AnnotationTag> annotations(){
		return Arrays.stream(underlying.getAnnotations()).map(k -> AnnotationTag.fromAnnotation(k, this)).collect(Collectors.toSet());
	}
	
	public Set<AnnotationTag> returnTypeAnnotations(){
		return Arrays.stream(underlying.getAnnotatedReturnType().getAnnotations()).map(k -> AnnotationTag.fromAnnotation(k, this)).collect(Collectors.toSet());
	}
	
	public Object defaultValueForAnnotation(){
		return underlying.getDefaultValue();
	}
}
