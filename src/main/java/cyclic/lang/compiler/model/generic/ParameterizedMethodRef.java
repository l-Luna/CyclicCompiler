package cyclic.lang.compiler.model.generic;

import cyclic.lang.compiler.model.AccessFlags;
import cyclic.lang.compiler.model.MethodReference;
import cyclic.lang.compiler.model.TypeParameterReference;
import cyclic.lang.compiler.model.TypeReference;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;

public class ParameterizedMethodRef implements MethodReference{
	
	private MethodReference base;
	private Map<TypeParameterReference, TypeReference> typeArguments;
	private TypeReference container;
	
	public  ParameterizedMethodRef(MethodReference base, Map<TypeParameterReference, TypeReference> typeArguments, @Nullable TypeReference container){
		this.base = base;
		this.typeArguments = typeArguments;
		this.container = container;
	}
	
	public List<TypeReference> parameters(){
		return GenericUtils.withSubstitutions(base.parameters(), typeArguments);
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
		return container != null ? container : base.in();
	}
	
	public AccessFlags flags(){
		return base.flags();
	}
	
	public String name(){
		return base.name();
	}
	
	public TypeReference returns(){
		return GenericUtils.substitute(base.returns(), typeArguments);
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
	
	public MethodReference erasure(){
		return base.erasure();
	}
	
	public boolean isConcrete(){
		return typeArguments.values().stream().allMatch(TypeReference::isConcrete)
				&& parameters().stream().allMatch(TypeReference::isConcrete)
				&& returns().isConcrete();
	}
}