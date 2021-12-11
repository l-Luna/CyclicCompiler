package cyclic.lang.compiler.model.statements;

import cyclic.lang.compiler.model.TypeReference;

public class Variable{
	
	String name;
	TypeReference type;
	Scope in;
	Statement owner;
	int firstAssignInstrIndex;
	
	public Variable(String name, TypeReference type, Scope in, Statement owner){
		this.name = name;
		this.type = type;
		this.in = in;
		this.owner = owner;
		
		in.variables.add(this);
	}
	
	public int getVarIndex(){
		return in.variables.indexOf(this);
	}
}