package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.Compiler;
import cyclic.lang.compiler.model.AnnotationTag;
import cyclic.lang.compiler.model.cyclic.CyclicConstructor;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypeReference;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;

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
		
		// note that these are ASM TypeReferences, not Cyclic TypeReferences
		// all annotations are applied to both the return type and method as a whole if applicable
		Set<AnnotationTag> annotations = new HashSet<>(method.annotations());
		annotations.addAll(method.returnTypeAnnotations());
		for(AnnotationTag annotation : annotations){
			var retention = annotation.retention();
			if(retention != RetentionPolicy.SOURCE){
				boolean methodApplicable = annotation.isApplicable(method);
				boolean typeApplicable = annotation.isApplicable(ElementType.TYPE_USE.name());
				if(methodApplicable){
					var av = mv.visitAnnotation(annotation.annotationType().descriptor(), retention == RetentionPolicy.RUNTIME);
					writeAnnotation(av, annotation);
				}
				if(typeApplicable){
					var av = mv.visitTypeAnnotation(TypeReference.newTypeReference(TypeReference.METHOD_RETURN).getValue(), null, annotation.annotationType().descriptor(), retention == RetentionPolicy.RUNTIME);
					writeAnnotation(av, annotation);
				}
				if(!methodApplicable && !typeApplicable){
					System.err.printf("Annotation %s on method %s in type %s is not applicable to it or its return type, and will be ignored.%n",
							annotation.annotationType().fullyQualifiedName(), method.nameAndDescriptor(), method.in().fullyQualifiedName());
				}
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