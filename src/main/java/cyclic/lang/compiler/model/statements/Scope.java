package cyclic.lang.compiler.model.statements;

import java.util.ArrayList;
import java.util.List;

public class Scope{
	
	Scope parent;
	List<Variable> variables = new ArrayList<>();
	
	public Scope(){
		this(null);
	}
	
	public Scope(Scope parent){
		this.parent = parent;
	}
	
	public List<Variable> getList(){
		if(parent != null)
			return parent.getList();
		else
			return variables;
	}
	
	public Variable get(String name){
		for(var var : getList())
			if(var.name.equals(name))
				return var;
		return null;
	}
	
	public int addVariable(Variable v){
		if(get(v.name) != null)
			throw new IllegalStateException("Trying to create a local variable " + v.name + " when one already exists in scope!");
		List<Variable> list = getList();
		list.add(v);
		return list.indexOf(v);
	}
}