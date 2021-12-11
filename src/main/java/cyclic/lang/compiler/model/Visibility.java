package cyclic.lang.compiler.model;

import org.objectweb.asm.Opcodes;

public enum Visibility{
	PACKAGE_PRIVATE(0),
	PRIVATE(Opcodes.ACC_PRIVATE),
	PUBLIC(Opcodes.ACC_PUBLIC),
	PROTECTED(Opcodes.ACC_PROTECTED);
	
	public final int modifier;
	
	Visibility(int modifier){
		this.modifier = modifier;
	}
}