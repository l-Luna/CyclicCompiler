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
	
	public Variable get(String name){
		for(var var : variables)
			if(var.name.equals(name))
				return var;
		if(parent != null)
			return parent.get(name);
		return null;
	}
}