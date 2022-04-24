package cyclic.lang.compiler.model.generic;

import cyclic.lang.compiler.model.AccessFlags;
import cyclic.lang.compiler.model.MethodReference;
import cyclic.lang.compiler.model.TypeReference;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

public class ParameterizedMethodRef implements MethodReference{
	
	private MethodReference base;
	private List<TypeReference> typeParameters;
	private TypeReference container;
	
	public ParameterizedMethodRef(MethodReference base, List<TypeReference> typeParameters, TypeReference container){
		this.base = base;
		this.typeParameters = typeParameters;
		this.container = container;
	}
	
	public List<TypeReference> parameters(){
		return GenericUtils.withSubstitutions(base.parameters(), typeParameters);
	}
	
	public List<String> parameterNames(){
		return base.parameterNames();
	}
	
	public boolean isStatic(){
		return base.isStatic();
	}
	
	public boolean isVarargs(){
		return base.isVarargs();
	}
	
	public TypeReference in(){
		return container;
	}
	
	public AccessFlags flags(){
		return base.flags();
	}
	
	public String name(){
		return base.name();
	}
	
	public TypeReference returns(){
		return GenericUtils.substitute(base.returns(), typeParameters);
	}
	
	public boolean isNative(){
		return base.isNative(); // is this even allowed?
	}
	
	public boolean isSynchronized(){
		return base.isSynchronized();
	}
	
	public void writeInvoke(MethodVisitor mv){
		MethodReference.super.writeInvoke(mv);
		if(!returns().equals(base.returns()))
			mv.visitTypeInsn(Opcodes.CHECKCAST, returns().internalName());
	}
	
	public void writeInvokeSpecial(MethodVisitor mv){
		MethodReference.super.writeInvokeSpecial(mv);
		if(!returns().equals(base.returns()))
			mv.visitTypeInsn(Opcodes.CHECKCAST, returns().internalName());
	}
	
	public String descriptor(){
		return base.descriptor(); // erase type parameters
	}
}