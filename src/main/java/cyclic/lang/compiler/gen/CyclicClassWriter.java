package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicConstructor;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public final class CyclicClassWriter{
	
	public static int outputClassfileVersion = Opcodes.V16;
	
	public static void writeClass(ClassWriter writer, CyclicType type){
		writer.visit(outputClassfileVersion, getTypeAccessFlags(type), type.internalName(), null, type.superClass().internalName(), type.superInterfaces().stream().map(TypeReference::internalName).toArray(String[]::new));
		
		// class init
		MethodVisitor smv = writer.visitMethod(Opcodes.ACC_STATIC, "<clinit>", "()V", null, null);
		for(var init : type.initBlocks)
			if(init.isStatic())
				CyclicMethodWriter.writeCtor(smv, init);
		smv.visitInsn(Opcodes.RETURN);
		smv.visitMaxs(0, 0);
		smv.visitEnd();
		
		for(var field : type.fields()){
			// default values are always handled through implicit init blocks
			FieldVisitor fv = writer.visitField(getFieldAccessFlags(field), field.name(), field.type().descriptor(), null, null);
			fv.visitEnd();
		}
		
		for(var ctor : type.constructors()){
			MethodVisitor mv = writer.visitMethod(getAccessFlags(ctor.flags()), "<init>", ctor.descriptor(), null, null);
			
			// implicit super(); TODO: constructor overloading and args super-constructors
			mv.visitVarInsn(Opcodes.ALOAD, 0);
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, type.superClass().internalName(), "<init>", "()V", false);
			
			for(var init : type.initBlocks) // init blocks go first so that field values can be setup for use
				if(!init.isStatic() && init.body != null)
					init.body.write(mv);
			// TODO: calling super-constructors
			CyclicMethodWriter.writeCtor(mv, (CyclicConstructor)ctor);
			
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		for(var method : type.methods()){
			if(method instanceof CyclicMethod cyc){ // inherited methods are not CyclicMethods
				MethodVisitor mv = writer.visitMethod(getMethodAccessFlags(method), method.name(), method.descriptor(), null, null);
				CyclicMethodWriter.writeMethod(mv, cyc);
				mv.visitMaxs(0, 0);
				mv.visitEnd();
			}
		}
		
		/*if(type.outerClass() != null)
			writer.visitOuterClass(type.outerClass().internalName(), null, null);
		
		for(var inner : type.innerClasses())
			writer.visitInnerClass(inner.internalName(), type.internalName(), inner.shortName(), getAccessFlags(inner));*/
		writer.visitEnd();
	}
	
	public static int getAccessFlagsForKind(TypeKind kind){
		return switch(kind){
			case CLASS, SINGLE, CONSTRUCTED -> 0; // Singles are classes with sugar, constructed types should never be generated
			case INTERFACE -> Opcodes.ACC_INTERFACE;
			case ENUM -> Opcodes.ACC_ENUM;
			case ANNOTATION -> Opcodes.ACC_ANNOTATION;
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
				(field.isStatic() ? Opcodes.ACC_STATIC : 0);
	}
	
	public static int getAccessFlags(AccessFlags flags){
		return flags.visibility().modifier |
				(flags.isAbstract() ? Opcodes.ACC_ABSTRACT : 0) |
				(flags.isFinal() ? Opcodes.ACC_FINAL : 0);
	}
}