package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.Compiler;
import cyclic.lang.compiler.model.cyclic.CyclicConstructor;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import org.objectweb.asm.MethodVisitor;

public final class CyclicMethodWriter{
	
	public static void writeMethod(MethodVisitor mv, CyclicMethod method){
		if(Compiler.includeDebugInfo)
			for(String paramName : method.parameterNames())
				mv.visitParameter(paramName, 0);
		
		if(!(method.flags().isAbstract() || method.isNative())){
			mv.visitCode();
			method.body.write(mv);
		}else if(method.flags().isAbstract() && !method.in().flags().isAbstract())
			System.err.println("Found abstract method in non-abstract class: \"" + method.name() + method.descriptor() + "\" in " + method.in().fullyQualifiedName());
	}
	
	public static void writeCtor(MethodVisitor mv, CyclicConstructor ctor){
		// TODO: allow hiding metadata
		for(String paramName : ctor.parameterNames())
			mv.visitParameter(paramName, 0);
		
		mv.visitCode();
		if(ctor.body != null)
			ctor.body.write(mv);
	}
}