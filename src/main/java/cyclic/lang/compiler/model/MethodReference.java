package cyclic.lang.compiler.model;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.stream.Collectors;

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