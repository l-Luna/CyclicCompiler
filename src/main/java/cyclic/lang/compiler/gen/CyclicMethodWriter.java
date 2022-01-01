package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.Compiler;
import cyclic.lang.compiler.model.AnnotationTag;
import cyclic.lang.compiler.model.cyclic.CyclicConstructor;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypeReference;

import java.lang.annotation.RetentionPolicy;

import static cyclic.lang.compiler.gen.CyclicClassWriter.writeAnnotation;

public final class CyclicMethodWriter{
	
	public static void writeMethod(MethodVisitor mv, CyclicMethod method){
		if(Compiler.includeDebugInfo)
			for(String paramName : method.parameterNames())
				mv.visitParameter(paramName, 0);
		
		if(!(method.flags().isAbstract() || method.isNative())){
			mv.visitCode();
			method.body.write(mv);
			mv.visitInsn(Opcodes.RETURN);
		}
		
		for(AnnotationTag annotation : method.annotations()){
			var retention = annotation.retention();
			if(retention != RetentionPolicy.SOURCE){
				var av = mv.visitAnnotation(annotation.annotationType().descriptor(), retention == RetentionPolicy.RUNTIME);
				writeAnnotation(av, annotation);
			}
		}
		
		for(AnnotationTag annotation : method.returnTypeAnnotations()){
			var retention = annotation.retention();
			if(retention != RetentionPolicy.SOURCE){
				// note that this is an ASM TypeReference, not Cyclic TypeReference
				var av = mv.visitTypeAnnotation(TypeReference.newTypeReference(TypeReference.METHOD_RETURN).getValue(), null, annotation.annotationType().descriptor(), retention == RetentionPolicy.RUNTIME);
				writeAnnotation(av, annotation);
			}
		}
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