package cyclic.lang.compiler.model.instructions;

import cyclic.lang.compiler.CompileTimeException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scope{
	
	/**
	 * Scope attributes are temporarily added to scopes during codegen to hook into the generation of
	 * particular instructions, such as returns in try/catch, break/continue statements, yields, etc.
	*/
	public interface ScopeAttribute{}
	public record InterferingScope(Runnable returnWriter) implements ScopeAttribute{
		public void writeReturn(){
			returnWriter.run();
		}
	}
	// TODO: yielding scope
	public record BreakingScope(Label endLabel) implements ScopeAttribute{}
	public record ContinuingScope(Label restartLabel) implements ScopeAttribute{}
	
	@Nullable
	private Scope parent;
	private List<Variable> variables = new ArrayList<>();
	private List<Variable> vIndexList = new ArrayList<>();
	private Map<Class<? extends ScopeAttribute>, ScopeAttribute> attributes = new HashMap<>();
	
	public Label end;
	
	public Scope(){
		this(null);
	}
	
	public Scope(@Nullable Scope parent){
		this.parent = parent;
	}
	
	public List<Variable> getIndexList(){
		if(parent != null)
			return parent.getIndexList();
		else
			return vIndexList;
	}
	
	public Variable get(String name){
		if(name.startsWith("~"))
			return null;
		for(var var : variables)
			if(var.name.equals(name))
				return var;
		return parent != null ? parent.get(name) : null;
	}
	
	public int addVariable(Variable v){
		if(get(v.name) != null)
			throw new CompileTimeException("Trying to create a local variable \"" + v.name + "\" when one already exists in scope!");
		List<Variable> list = getIndexList();
		list.add(v);
		variables.add(v);
		return list.indexOf(v);
	}
	
	public void putAttribute(ScopeAttribute attribute){
		attributes.put(attribute.getClass(), attribute);
	}
	
	@Nullable
	public <T extends ScopeAttribute> T getAttribute(@NotNull Class<T> type){
		return type.cast(attributes.get(type));
	}
	
	@Nullable
	public <T extends ScopeAttribute> T getAttributeInHierarchy(@NotNull Class<T> type){
		if(attributes.containsKey(type))
			return getAttribute(type);
		return parent != null ? parent.getAttributeInHierarchy(type) : null;
	}
}