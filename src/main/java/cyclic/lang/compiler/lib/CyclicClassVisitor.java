package cyclic.lang.compiler.lib;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;

import java.lang.reflect.Field;

/**
 * A class visitor that can parse cyclic-specific attributes.
 */
public class CyclicClassVisitor extends ClassVisitor{
	
	private static final Field ATTRIBUTE_CONTENT_FIELD;
	
	static{
		try{
			ATTRIBUTE_CONTENT_FIELD = Attribute.class.getDeclaredField("content");
		}catch(NoSuchFieldException e){
			throw new RuntimeException(e);
		}
	}
	
	// seriously, ASM?
	private static byte[] getAttributeContent(Attribute attribute){
		try{
			ATTRIBUTE_CONTENT_FIELD.setAccessible(true);
			var bytes = (byte[])ATTRIBUTE_CONTENT_FIELD.get(attribute);
			ATTRIBUTE_CONTENT_FIELD.setAccessible(false);
			return bytes;
		}catch(IllegalAccessException e){
			throw new RuntimeException(e);
		}
	}
	
	public CyclicClassVisitor(int api){
		super(api);
	}
	
	public CyclicClassVisitor(int api, ClassVisitor classVisitor){
		super(api, classVisitor);
	}
	
	public void visitAttribute(Attribute attribute){
		if(attribute.type.equals(CyclicModifiersAttribute.CYC_MODIFIERS_ATTR_NAME)){
			var bytes = getAttributeContent(attribute);
			assert bytes.length == 4 : "CyclicModifiersAttribute length must be 4";
			int modifiers = (bytes[0] & 0xFF) << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
			visitCyclicModifiers(modifiers);
		}else
			super.visitAttribute(attribute);
	}
	
	/**
	 * Visits a cyclic modifiers attribute.
	 *
	 * @param modifiers
	 * 		The cyclic-specific modifiers.
	 */
	public void visitCyclicModifiers(int modifiers){
		if(cv instanceof CyclicClassVisitor ccv)
			ccv.visitCyclicModifiers(modifiers);
	}
}