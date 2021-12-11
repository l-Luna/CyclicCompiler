package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.model.MethodReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import org.objectweb.asm.MethodVisitor;

import java.util.stream.Collectors;

public final class CyclicMethodWriter{
	
	public static void writeMethod(MethodVisitor mv, CyclicMethod method){
		// TODO: allow hiding metadata
		for(String paramName : method.parameterNames())
			mv.visitParameter(paramName, 0);
		
		if(!(method.flags().isAbstract() || method.isNative())){
			mv.visitCode();
			method.body.write(mv);
		}else if(method.flags().isAbstract() && !method.in().flags().isAbstract())
			System.err.println("Found abstract method in non-abstract class: \"" + method.name() + getMethodDescriptor(method) + "\" in " + method.in().fullyQualifiedName());
	}
	
	public static String getMethodDescriptor(MethodReference ref){
		return "(" + ref.parameters().stream().map(TypeReference::descriptor).collect(Collectors.joining()) + ")" + ref.returns().descriptor();
	}
}