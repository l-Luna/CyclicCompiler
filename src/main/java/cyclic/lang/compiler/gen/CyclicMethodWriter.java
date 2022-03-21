package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.Compiler;
import cyclic.lang.compiler.model.AnnotationTag;
import cyclic.lang.compiler.model.cyclic.CyclicConstructor;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import cyclic.lang.compiler.model.instructions.Variable;
import org.objectweb.asm.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;

import static cyclic.lang.compiler.gen.CyclicClassWriter.writeAnnotation;

public final class CyclicMethodWriter{
	
	public static void writeMethod(MethodVisitor mv, CyclicMethod method){
		boolean debug = Compiler.includeDebugInfo;
		Label first = null, last = null;
		if(debug){
			for(String paramName : method.parameterNames())
				mv.visitParameter(paramName, 0);
			first = new Label();
			last = new Label();
		}
		
		if(!(method.flags().isAbstract() || method.isNative())){
			mv.visitCode();
			if(debug)
				mv.visitLabel(first);
			method.body.simplify();
			method.body.write(mv);
			if(method.returns().fullyQualifiedName().equals("void"))
				mv.visitInsn(Opcodes.RETURN);
			if(debug)
				mv.visitLabel(last);
		}
		
		if(debug)
			for(Variable variable : method.methodScope.getIndexList())
				if(!variable.name().equals("this") && !variable.name().startsWith("~"))
					writeVarInfo(mv, variable, first, last);
		
		if(method.constantAnnotationComponentValue != null){
			AnnotationVisitor av = mv.visitAnnotationDefault();
			CyclicClassWriter.writeElement("", method.constantAnnotationComponentValue, av);
			av.visitEnd();
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
		boolean debug = Compiler.includeDebugInfo;
		Label first = null, last = null;
		if(debug){
			if(!ctor.isCanonRecordCtor || ctor.isGeneratedRecordCtor)
				for(String paramName : ctor.parameterNames())
					mv.visitParameter(paramName, paramName.startsWith("~") ? Opcodes.ACC_SYNTHETIC : 0);
			first = new Label();
			last = new Label();
		}
		
		mv.visitCode();
		if(ctor.body != null){
			if(debug)
				mv.visitLabel(first);
			ctor.body.simplify();
			ctor.body.write(mv);
			if(debug)
				mv.visitLabel(last);
		}
		
		if(debug)
			for(Variable variable : ctor.scope.getIndexList())
				if(!variable.name().equals("this") && !variable.name().startsWith("~"))
					writeVarInfo(mv, variable, first, last);
	}
	
	private static void writeVarInfo(MethodVisitor mv, Variable variable, Label first, Label last){
		mv.visitLocalVariable(
				variable.name(),
				variable.type().descriptor(),
				null,
				variable.start == null ? first : variable.start,
				variable.end == null ? last : variable.end,
				variable.getAdjIndex());
	}
}