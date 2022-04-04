package cyclic.lang.compiler.gen.asm;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.objectweb.asm.ClassWriter;

/**
 * An implementation of {@linkplain ClassWriter} that correctly calculates the common superclass of types
 * being compiled.
 */
public class AsmCyclicCW extends ClassWriter{
	
	public AsmCyclicCW(int flags){
		super(flags);
	}
	
	protected String getCommonSuperClass(String type1, String type2){
		TypeReference left = TypeResolver.resolveFq(type1.replace('/', '.'));
		TypeReference right = TypeResolver.resolveFq(type2.replace('/', '.'));
		return left.commonSuperType(right).internalName();
	}
}