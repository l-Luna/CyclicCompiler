package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.instructions.Value;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

public final class DynamicCallValue extends Value{
	
	List<Value> args;
	Handle bootstrapHandle;
	String name, descriptor;
	
	TypeReference type;
	
	List<?> constArgs = new ArrayList<>();
	
	public DynamicCallValue(TypeReference type, List<Value> args, Handle bootstrapHandle, String name, String descriptor){
		super();
		this.type = type;
		this.args = args;
		this.bootstrapHandle = bootstrapHandle;
		this.name = name;
		this.descriptor = descriptor;
	}
	
	public void write(MethodVisitor mv){
		mv.visitVarInsn(Opcodes.ALOAD, 0);
		args.forEach(x -> x.write(mv));
		mv.visitInvokeDynamicInsn(name, descriptor, bootstrapHandle, constArgs.toArray());
	}
	
	public void simplify(){
		args.forEach(Value::simplify);
	}
	
	public TypeReference type(){
		return type;
	}
}