package cyclic.lang.compiler.model.statements;

import cyclic.lang.compiler.model.TypeReference;

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
}