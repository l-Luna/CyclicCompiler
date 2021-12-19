package cyclic.lang.compiler.model;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.stream.Collectors;

public interface MethodReference extends CallableReference{
	
	String name();
	
	TypeReference returns();
	
	boolean isNative();
	
	boolean isSynchronized();
	
	default String descriptor(){
		return "(" + parameters().stream().map(TypeReference::descriptor).collect(Collectors.joining()) + ")" + returns().descriptor();
	}
	
	default void writeInvoke(MethodVisitor mv){
		if(isStatic()){
			mv.visitMethodInsn(Opcodes.INVOKESTATIC, in().internalName(), name(), descriptor(), false);
		}else{
			boolean isIface = in().kind() == TypeKind.INTERFACE;
			mv.visitMethodInsn(isIface ? Opcodes.INVOKEINTERFACE : Opcodes.INVOKEVIRTUAL, in().internalName(), name(), descriptor(), isIface);
		}
	}
}