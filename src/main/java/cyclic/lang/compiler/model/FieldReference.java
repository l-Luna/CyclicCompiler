package cyclic.lang.compiler.model;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public interface FieldReference{
	
	TypeReference in();
	
	String name();
	
	TypeReference type();
	
	AccessFlags flags();
	
	boolean isStatic();
	
	boolean isVolatile();
	
	default void writeFetch(MethodVisitor mv){
		mv.visitFieldInsn(isStatic() ? Opcodes.GETSTATIC : Opcodes.GETFIELD, in().internalName(), name(), type().descriptor());
	}
	
	default void writePut(MethodVisitor mv){
		if(flags().isFinal())
			throw new IllegalStateException("Trying to write a put instruction for a final field!");
		mv.visitFieldInsn(isStatic() ? Opcodes.PUTSTATIC : Opcodes.PUTFIELD, in().internalName(), name(), type().descriptor());
	}
}