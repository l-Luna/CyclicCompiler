package cyclic.lang.compiler.model.platform;

import cyclic.lang.compiler.model.*;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ArrayLengthField implements FieldReference{
	ArrayTypeRef in;
	
	public ArrayLengthField(ArrayTypeRef in){
		this.in = in;
	}
	
	public TypeReference in(){
		return in;
	}
	
	public String name(){
		return "length";
	}
	
	public TypeReference type(){
		return TypeResolver.resolve("int");
	}
	
	public AccessFlags flags(){
		return new AccessFlags(Visibility.PUBLIC, false, true);
	}
	
	public boolean isStatic(){
		return false;
	}
	
	public boolean isVolatile(){
		return false;
	}
	
	public void writeFetch(MethodVisitor mv){
		mv.visitInsn(Opcodes.ARRAYLENGTH);
	}
}
