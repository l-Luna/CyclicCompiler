package cyclic.lang.compiler.model.jdk;

import cyclic.lang.compiler.model.AccessFlags;
import cyclic.lang.compiler.model.FieldReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Field;

public class JdkFieldRef implements FieldReference{
	
	Field underlying;
	TypeReference in;
	
	public JdkFieldRef(Field underlying, TypeReference in){
		this.underlying = underlying;
		this.in = in;
	}
	
	public TypeReference in(){
		return in;
	}
	
	public String name(){
		return underlying.getName();
	}
	
	public TypeReference type(){
		return Utils.forAnyClass(underlying.getType());
	}
	
	public AccessFlags flags(){
		return Utils.fromBitfield(underlying.getModifiers());
	}
	
	public boolean isStatic(){
		return Utils.isBitSet(underlying.getModifiers(), Opcodes.ACC_STATIC);
	}
	
	public boolean isVolatile(){
		return Utils.isBitSet(underlying.getModifiers(), Opcodes.ACC_VOLATILE);
	}
	
	public boolean isEnumDefinition(){
		return underlying.isEnumConstant();
	}
}