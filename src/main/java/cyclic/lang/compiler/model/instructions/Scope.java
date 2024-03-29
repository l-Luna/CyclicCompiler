package cyclic.lang.compiler.model.instructions;

import cyclic.lang.compiler.problems.CompileTimeException;
import cyclic.lang.compiler.problems.Formatter;
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
	
	public record FinallyScope(Runnable cleanupWriter) implements ScopeAttribute{
		public void writeCleanup(){
			cleanupWriter.run();
		}
	}
	// TODO: yielding scope
	public record BreakingScope(Label targetLabel, Scope targetScope) implements ScopeAttribute{}
	public record ContinuingScope(Label targetLabel, Scope targetScope) implements ScopeAttribute{}
	
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
		Variable existing = get(v.name);
		if(existing != null)
			if(existing.owner != null && existing.owner.text != null)
				throw new CompileTimeException("Trying to create a local variable \"" + v.name + "\" when one already exists in scope", List.of("Already defined at \n" + Formatter.renderHighlight(existing.owner.text)));
			else
				throw new CompileTimeException("Trying to create a local variable \"" + v.name + "\" when one already exists in scope");
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
	
	@Nullable
	public <T extends ScopeAttribute> T getAttributesUpTo(@NotNull Class<T> type, @NotNull Scope limit){
		Scope current = this;
		while(current != limit && current != null){
			T attribute = current.getAttribute(type);
			if(attribute != null)
				return attribute;
			current = current.parent;
		}
		return null;
	}
}