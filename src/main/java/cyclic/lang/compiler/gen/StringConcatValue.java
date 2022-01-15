package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringConcatValue extends Value{
	private static final Handle MAKE_CONCAT_HANDLE =
			new Handle(
					Opcodes.H_INVOKESTATIC,
					Constants.STRING_CONCAT_FACTORY_INT,
					Constants.MAKE_CONCAT,
					Constants.MAKE_CONCAT_DESC,
					false
			);
	
	private Value initialLeft, initialRight;
	private boolean simplified = false;
	
	private List<Value> components = new ArrayList<>();
	
	public StringConcatValue(Value left, Value right){
		this.initialLeft = left;
		this.initialRight = right;
	}
	
	public TypeReference type(){
		return TypeResolver.resolveFq(Constants.STRING);
	}
	
	public void write(MethodVisitor mv){
		if(!simplified)
			throw new IllegalStateException("Tried to write string concatenation expression before simplifying it!");
		
		components.forEach(x -> x.write(mv));
		// TODO: use makeConcatWithConstants?
		String args = components.stream().map(Value::type).map(TypeReference::descriptor).collect(Collectors.joining("", "(", ")"));
		mv.visitInvokeDynamicInsn("makeConcat", args + "Ljava/lang/String;", MAKE_CONCAT_HANDLE);
	}
	
	public void simplify(){
		initialLeft.simplify();
		initialRight.simplify();
		components.add(initialLeft);
		components.add(initialRight);
		simplified = true;
	}
}
