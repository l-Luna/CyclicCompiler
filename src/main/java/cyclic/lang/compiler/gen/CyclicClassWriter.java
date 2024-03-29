package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.lib.CyclicModifiersAttribute;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicConstructor;
import cyclic.lang.compiler.model.cyclic.CyclicField;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.problems.CompileTimeException;
import cyclic.lang.compiler.problems.ProblemsHolder;
import cyclic.lang.compiler.problems.WarningType;
import org.objectweb.asm.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

public final class CyclicClassWriter{
	
	public static final int outputClassfileVersion = Opcodes.V17;
	public static ThreadLocal<CallableReference> currentMethod = new ThreadLocal<>();
	
	public static void writeClass(ClassWriter writer, CyclicType type){
		CompileTimeException.setFile(type.fullyQualifiedName());
		writer.visit(outputClassfileVersion, getTypeAccessFlags(type), type.internalName(), null, type.superClass().internalName(), type.superInterfaces().stream().map(TypeReference::internalName).toArray(String[]::new));
		
		writer.visitAttribute(new CyclicModifiersAttribute(getCyclicModifiers(type)));
		
		// class init
		{
			MethodVisitor smv = writer.visitMethod(Opcodes.ACC_STATIC, "<clinit>", "()V", null, null);
			for(var init : type.initBlocks)
				if(init.isStatic()){
					currentMethod.set(init);
					CyclicMethodWriter.writeCtor(smv, init);
				}
			smv.visitInsn(Opcodes.RETURN);
			smv.visitMaxs(0, 0);
			smv.visitEnd();
		}
		
		for(var component : type.recordComponents())
			writer.visitRecordComponent(component.name(), component.type().descriptor(), null);
		
		for(var field : type.fields()){
			// default values are always handled through implicit init blocks
			FieldVisitor fv = writer.visitField(getFieldAccessFlags(field), field.name(), field.type().descriptor(), null, null);
			
			// TODO: type annotations
			for(AnnotationTag annotation : field.annotations()){
				var retention = annotation.retention();
				boolean methodApplicable = annotation.isApplicable(field);
				boolean typeApplicable = annotation.isApplicable(ElementType.TYPE_USE.name());
				if(retention != RetentionPolicy.SOURCE){
					if(methodApplicable)
						writeAnnotation(fv.visitAnnotation(annotation.annotationType().descriptor(), retention == RetentionPolicy.RUNTIME), annotation);
					if(typeApplicable)
						writeAnnotation(fv.visitTypeAnnotation(org.objectweb.asm.TypeReference.newTypeReference(org.objectweb.asm.TypeReference.METHOD_RETURN).getValue(), null, annotation.annotationType().descriptor(), retention == RetentionPolicy.RUNTIME), annotation);
				}
				if(!methodApplicable && !typeApplicable)
					ProblemsHolder.warnFrom(WarningType.INAPPLICABLE_ANNOTATION, "Annotation \"" + annotation.annotationType().fullyQualifiedName() + "\" is not applicable to this field or its type, and will be ignored", field, ((CyclicField)field).nameToken());
			}
			
			fv.visitEnd();
		}
		
		for(var ctor : type.constructors()){
			CyclicConstructor cyc = (CyclicConstructor)ctor;
			if(cyc.isCanonRecordCtor && !cyc.isGeneratedRecordCtor)
				continue; // generate with generated one, which is always present
			
			currentMethod.set(ctor);
			MethodVisitor mv = writer.visitMethod(getAccessFlags(ctor.flags()), "<init>", ctor.descriptor(), null, null);
			
			// implicit "super();" if not present in text
			if(cyc.explicitCtorCall().isEmpty()){
				boolean isEnum = type.kind() == TypeKind.ENUM;
				mv.visitVarInsn(Opcodes.ALOAD, 0);
				if(isEnum){
					mv.visitVarInsn(Opcodes.ALOAD, 1);
					mv.visitVarInsn(Opcodes.ILOAD, 2);
				}
				mv.visitMethodInsn(Opcodes.INVOKESPECIAL, type.superClass().internalName(), "<init>", isEnum ? "(Ljava/lang/String;I)V" : "()V", false);
			}
			
			for(var init : type.initBlocks) // init blocks go first so that field values can be setup for use
				if(!init.isStatic() && init.body != null){
					init.body.simplify();
					init.body.write(mv);
				}
			
			CyclicMethodWriter.writeCtor(mv, cyc);
			
			// if this is generated record one, also append the explicit ctor
			canonCtor:
			if(cyc.isGeneratedRecordCtor)
				for(CallableReference constructor : type.constructors())
					if(constructor instanceof CyclicConstructor cycc && cycc.isCanonRecordCtor && !cycc.isGeneratedRecordCtor){
						CyclicMethodWriter.writeCtor(mv, cycc);
						break canonCtor;
					}
			
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		for(var method : type.methods()){
			if(method instanceof CyclicMethod cyc
					&& cyc.in().fullyQualifiedName().equals(type.fullyQualifiedName())){
				currentMethod.set(cyc);
				MethodVisitor mv = writer.visitMethod(getMethodAccessFlags(method), method.name(), method.descriptor(), null, null);
				CyclicMethodWriter.writeMethod(mv, cyc);
				mv.visitMaxs(0, 0);
				mv.visitEnd();
			}
		}
		
		currentMethod.set(null);
		
		for(AnnotationTag annotation : type.annotations()){
			var retention = annotation.retention();
			if(retention != RetentionPolicy.SOURCE){
				if(annotation.isApplicable(type) || (type.kind() == TypeKind.ANNOTATION && annotation.isApplicable(ElementType.ANNOTATION_TYPE.name()))){
					var av = writer.visitAnnotation(annotation.annotationType().descriptor(), retention == RetentionPolicy.RUNTIME);
					writeAnnotation(av, annotation);
				}else // TODO: use annotation usage instead of type name
					ProblemsHolder.warnFrom(WarningType.INAPPLICABLE_ANNOTATION, "Annotation \"" + annotation.annotationType().fullyQualifiedName() + "\" is not applicable to types, and will be ignored", type, type.nameToken());
			}
		}
		
		writer.visitEnd();
	}
	
	static void writeAnnotation(AnnotationVisitor av, AnnotationTag annotation){
		annotation.arguments().forEach((name, value) -> writeElement(name, value, av));
		av.visitEnd();
	}
	
	static void writeElement(String name, Object value, AnnotationVisitor av){
		if(value instanceof EnumConstant e)
			av.visitEnum(name, e.enumType().descriptor(), e.name());
		else if(value instanceof TypeReference ref)
			av.visit(name, Type.getType(ref.descriptor()));
		else if(value.getClass().isArray()){
			if(value.getClass().getComponentType().isPrimitive())
				av.visit(name, value);
			else{
				var aav = av.visitArray(name);
				Object[] array = (Object[])value;
				for(Object o : array)
					writeElement("", o, aav);
				aav.visitEnd();
			}
		}else if(value instanceof AnnotationTag ann)
			writeAnnotation(av.visitAnnotation(name, ann.annotationType().descriptor()), ann);
		else
			av.visit(name, value);
	}
	
	public static int getAccessFlagsForKind(TypeKind kind){
		return switch(kind){
			case CLASS, SINGLE, CONSTRUCTED -> 0; // Singles are classes with sugar, constructed types should never be generated
			case INTERFACE -> Opcodes.ACC_INTERFACE;
			case ENUM -> Opcodes.ACC_ENUM;
			case ANNOTATION -> Opcodes.ACC_INTERFACE | Opcodes.ACC_ANNOTATION;
			case RECORD -> Opcodes.ACC_RECORD;
		};
	}
	
	public static int getTypeAccessFlags(TypeReference type){
		return getAccessFlags(type.flags()) | getAccessFlagsForKind(type.kind());
	}
	
	public static int getMethodAccessFlags(MethodReference method){
		return getAccessFlags(method.flags()) |
				(method.isNative() ? Opcodes.ACC_NATIVE : 0) |
				(method.isSynchronized() ? Opcodes.ACC_SYNCHRONIZED : 0) |
				(method.isStatic() ? Opcodes.ACC_STATIC : 0);
	}
	
	public static int getFieldAccessFlags(FieldReference field){
		return getAccessFlags(field.flags()) |
				(field.isVolatile() ? Opcodes.ACC_VOLATILE : 0) |
				(field.isStatic() ? Opcodes.ACC_STATIC : 0) |
				(field.isEnumDefinition() ? Opcodes.ACC_ENUM : 0) |
				(field.name().startsWith("~") ? Opcodes.ACC_SYNTHETIC : 0);
	}
	
	public static int getAccessFlags(AccessFlags flags){
		return flags.visibility().modifier |
				(flags.isAbstract() ? Opcodes.ACC_ABSTRACT : 0) |
				(flags.isFinal() ? Opcodes.ACC_FINAL : 0);
	}
	
	public static int getCyclicModifiers(TypeReference type){
		return type.kind() == TypeKind.SINGLE ? CyclicModifiersAttribute.MOD_SINGLE : 0;
	}
}