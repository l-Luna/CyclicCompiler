package cyclic.lang.compiler.model.instructions;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;

public class Variable{
	
	String name;
	TypeReference type;
	Scope in;
	Statement owner;
	public boolean isFinal = false;
	private int index;
	
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