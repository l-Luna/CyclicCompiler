package cyclic.lang.compiler.model.instructions;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class Variable{
	
	String name;
	TypeReference type;
	Scope in;
	Statement owner;
	public boolean isFinal = false, /* parameter, catch block */ fakeAssigned = false;
	private int index;
	
	// we track variable end labels for plugins (eventually)
	// scope end label is preferred by LVT to stop variables being dropped after use while still in scope
	public Label start = null, end = null;
	
	public Variable(String name, @NotNull TypeReference type, Scope in, Statement owner){
		this.name = name;
		this.type = type;
		this.in = in;
		this.owner = owner;
		
		index = in.addVariable(this);
	}
	
	public int getVarIndex(){
		return index;
	}
	
	public int getAdjIndex(){
		return Utils.adjustedIndex(this);
	}
	
	@NotNull
	public TypeReference type(){
		return type;
	}
	
	public Scope in(){
		return in;
	}
	
	public String name(){
		return name;
	}
	
	public void writeStore(MethodVisitor mv){
		mv.visitVarInsn(type.localStoreOpcode(), getAdjIndex());
	}
	
	public void writeLoad(MethodVisitor mv){
		mv.visitVarInsn(type.localLoadOpcode(), getAdjIndex());
	}
}