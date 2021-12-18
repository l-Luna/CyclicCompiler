package cyclic.lang.compiler.model.instructions;

import java.util.ArrayList;
import java.util.List;

public class Scope{
	
	Scope parent;
	List<Variable> variables = new ArrayList<>();
	List<Variable> vIndexList = new ArrayList<>();
	
	public Scope(){
		this(null);
	}
	
	public Scope(Scope parent){
		this.parent = parent;
	}
	
	public List<Variable> getIndexList(){
		if(parent != null)
			return parent.getIndexList();
		else
			return vIndexList;
	}
	
	public Variable get(String name){
		for(var var : variables)
			if(var.name.equals(name))
				return var;
		return parent != null ? parent.get(name) : null;
	}
	
	public int addVariable(Variable v){
		if(get(v.name) != null)
			throw new IllegalStateException("Trying to create a local variable " + v.name + " when one already exists in scope!");
		List<Variable> list = getIndexList();
		list.add(v);
		variables.add(v);
		return list.indexOf(v);
	}
}