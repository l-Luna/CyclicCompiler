package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class StringConcatValue extends Value{
	
	private static final Handle MAKE_CONCAT_HANDLE =
			new Handle(
					Opcodes.H_INVOKESTATIC,
					Constants.STRING_CONCAT_FACTORY_INT,
					Constants.MAKE_CONCAT_WITH_CONSTANTS,
					Constants.MAKE_CONCAT_DESC,
					false
			);
	
	private static final String TAG_ARG = "\u0001";
	private static final int MAX_CONCAT_SLOTS = 200;
	private static final Predicate<Value> isConstString = x -> (x instanceof StringConcatValue scv && scv.constantString != null) || x instanceof StringLiteralValue;
	
	private Value initialLeft, initialRight;
	private boolean simplified = false;
	
	// actual string concatenation
	private List<Value> components = new ArrayList<>();
	// constant strings, like "a" + "b"
	private String constantString = null;
	
	public StringConcatValue(Value left, Value right){
		this.initialLeft = left;
		this.initialRight = right;
	}
	
	// used in long (>200 elements) expressions
	private StringConcatValue(List<Value> components){
		this.components = components;
		simplified = true;
	}
	
	public TypeReference type(){
		return TypeResolver.resolveFq(Constants.STRING);
	}
	
	public void write(MethodVisitor mv){
		if(!simplified)
			throw new IllegalStateException("Tried to write string concatenation expression before simplifying it!");
		
		if(constantString != null){
			mv.visitLdcInsn(constantString);
			return;
		}
		
		for(Value component : components)
			if(!isConstString.test(component))
				component.write(mv);
		
		// TODO: actually do non-string constants
		String args = components.stream().filter(isConstString.negate()).map(Value::type).map(TypeReference::descriptor).collect(Collectors.joining("", "(", ")"));
		String recipe = components.stream().map(x ->
				x instanceof StringLiteralValue slv ? slv.value :
				x instanceof StringConcatValue scv && scv.constantString != null ? scv.constantString :
				TAG_ARG)
				.collect(Collectors.joining());
		mv.visitInvokeDynamicInsn("makeConcatWithConstants", args + "Ljava/lang/String;", MAKE_CONCAT_HANDLE, recipe);
	}
	
	public void simplify(Statement in){
		// walk down initialLeft and initialRight and flatten all StringConcatValues
		components = collect(this);
		components.forEach(value -> value.simplify(in));
		// if we have more than 200, split off the extras into a new value
		if(components.size() > MAX_CONCAT_SLOTS){
			int cuts = (int)(components.size() / (float)MAX_CONCAT_SLOTS);
			for(int i = 0; i < cuts; i++){
				// remove the first 200 elements and make them a new one
				List<Value> subset = components.stream().limit(200).toList();
				components.removeAll(subset);
				components.add(0, new StringConcatValue(subset));
			}
		}
		if(components.stream().allMatch(isConstString)){
			StringBuilder constValue = new StringBuilder();
			for(var part : components)
				constValue.append(part instanceof StringLiteralValue slv ? slv.value : ((StringConcatValue)part).constantString);
			constantString = constValue.toString();
		}
		simplified = true;
	}
	
	private List<Value> collect(StringConcatValue v){
		List<Value> ret = new ArrayList<>();
		if(v.initialLeft instanceof StringConcatValue l)
			ret.addAll(collect(l));
		else
			ret.add(v.initialLeft);
		if(v.initialRight instanceof StringConcatValue r)
			ret.addAll(collect(r));
		else
			ret.add(v.initialRight);
		return ret;
	}
}
