package cyclic.lang.compiler.lib;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.ByteVector;
import org.objectweb.asm.ClassWriter;

/**
 * Attribute that stores Cyclic-related modifiers.
 */
public class CyclicModifiersAttribute extends Attribute{
	
	public static final String CYC_MODIFIERS_ATTR_NAME = "Cyclic:Modifiers";
	
	public static final int MOD_SINGLE = 0x1;
	
	private final int modifiers;
	
	public CyclicModifiersAttribute(int modifiers){
		super(CYC_MODIFIERS_ATTR_NAME);
		this.modifiers = modifiers;
	}
	
	protected ByteVector write(ClassWriter classWriter, byte[] code, int codeLength, int maxStack, int maxLocals){
		var vector = new ByteVector(4);
		vector.putInt(modifiers);
		return vector;
	}
}