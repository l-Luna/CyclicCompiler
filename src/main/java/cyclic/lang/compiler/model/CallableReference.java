package cyclic.lang.compiler.model;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.stream.Collectors;

public interface CallableReference{
	
	TypeReference in();
	
	List<TypeReference> parameters();
	
	List<String> parameterNames();
	
	AccessFlags flags();
	
	boolean isStatic();
	
	default String descriptor(){
		return "(" + parameters().stream().map(TypeReference::descriptor).collect(Collectors.joining()) + ")V";
	}
	
	default void writeInvoke(MethodVisitor mv){
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, in().internalName(), "<init>", descriptor(), false);
	}
}