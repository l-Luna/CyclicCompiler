package cyclic.lang.compiler.model.instructions;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import org.objectweb.asm.Label;

public class Variable{
	
	String name;
	TypeReference type;
	Scope in;
	Statement owner;
	public boolean isFinal = false;
	private int index;
	
	// we track variable end labels for plugins (eventually)
	// scope end label is preferred by LVT to stop variables being dropped after use while still in scope
	public Label start = null, end = null;
	
	public Variable(String name, TypeReference type, Scope in, Statement owner){
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
	
	public TypeReference type(){
		return type;
	}
	
	public Scope in(){
		return in;
	}
	
	public String name(){
		return name;
	}
}