package cyclic.lang.compiler.gen.asm;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.ByteVector;
import org.objectweb.asm.ClassWriter;

/**
 * Attribute that marks a class as being a single-type.
 */
public class IsSingleAttribute extends Attribute{
	
	public static final String SINGLE_ATTR_NAME = "Cyclic:IsSingle";
	
	public IsSingleAttribute(){
		super(SINGLE_ATTR_NAME);
	}
	
	protected ByteVector write(ClassWriter classWriter, byte[] code, int codeLength, int maxStack, int maxLocals){
		return new ByteVector(0);
	}
}