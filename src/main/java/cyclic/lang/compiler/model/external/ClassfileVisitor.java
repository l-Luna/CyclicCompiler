package cyclic.lang.compiler.model.external;

import cyclic.lang.compiler.lib.CyclicClassVisitor;
import cyclic.lang.compiler.lib.CyclicModifiersAttribute;
import cyclic.lang.compiler.model.TypeKind;
import cyclic.lang.compiler.model.Utils;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import java.util.ArrayList;
import java.util.Arrays;

import static org.objectweb.asm.Opcodes.*;

/*package-private*/ class ClassfileVisitor extends CyclicClassVisitor{
	
	private ClassfileTypeRef fill;
	
	public ClassfileVisitor(ClassfileTypeRef fill){
		super(ASM9);
		this.fill = fill;
	}
	
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces){
		super.visit(version, access, name, signature, superName, interfaces);
		fill.name = Utils.PackageAndName.fromInternal(name);
		fill.kind = TypeKind.fromFlags(access);
		fill.flags = Utils.fromBitfield(access);
		fill.superClassName = superName;
		fill.interfaceNames = Arrays.asList(interfaces);
	}
	
	public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value){
		ClassfileMember.Field f = new ClassfileMember.Field();
		f.name = name;
		f.in = fill;
		f.typeName = Utils.nameFromDescriptor(descriptor);
		f.flags = Utils.fromBitfield(access);
		f.isStatic = Utils.isBitSet(access, ACC_STATIC);
		f.isVolatile = Utils.isBitSet(access, ACC_VOLATILE);
		f.isEnumConst = Utils.isBitSet(access, ACC_ENUM);
		fill.fields.add(f);
		// we don't really care about annotations or extra attributes yet
		return null;
	}
	
	public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions){
		if(name.equals("<clinit>")) // not interested in parsing class init blocks
			return null;
		var parts = Utils.methodDescriptorParts(descriptor);
		ClassfileMember.Method m = new ClassfileMember.Method();
		m.name = name;
		m.in = fill;
		m.flags = Utils.fromBitfield(access);
		m.isStatic = Utils.isBitSet(access, ACC_STATIC);
		m.isNative = Utils.isBitSet(access, ACC_NATIVE);
		m.isSynchronized = Utils.isBitSet(access, ACC_SYNCHRONIZED);
		m.isVarargs = Utils.isBitSet(access, ACC_VARARGS);
		m.returnsName = parts.get(parts.size() - 1);
		for(int i = 0; i < parts.size() - 1; i++)
			m.paramTypeNames.add(parts.get(i));
		if(name.equals("<init>"))
			fill.constructors.add(m);
		else
			fill.methods.add(m);
		// we don't really care about annotations or extra attributes yet
		// method bodies are already disabled
		return null;
	}
	
	public AnnotationVisitor visitAnnotation(String descriptor, boolean visible){
		var ptt = new ClassfileAnnotationPrototype(desc2qualified(descriptor));
		fill.annotationPtts.add(ptt);
		return new ClassfileAnnotationVisitor(ptt);
	}
	
	public void visitCyclicModifiers(int modifiers){
		if(Utils.isBitSet(modifiers, CyclicModifiersAttribute.MOD_SINGLE))
			fill.kind = TypeKind.SINGLE;
	}
	
	static class ClassfileAnnotationVisitor extends AnnotationVisitor{
		
		ClassfileAnnotationPrototype ptt;
		
		public ClassfileAnnotationVisitor(ClassfileAnnotationPrototype ptt){
			super(ASM9);
			this.ptt = ptt;
		}
		
		public AnnotationVisitor visitAnnotation(String name, String descriptor){
			var nestedPtt = new ClassfileAnnotationPrototype(desc2qualified(descriptor));
			ptt.values().put(name, nestedPtt);
			return new ClassfileAnnotationVisitor(nestedPtt);
		}
		
		public void visit(String name, Object value){
			if(value instanceof Type tVal)
				ptt.values().put(name, "type:" + tVal.getInternalName().replace('/', '.'));
			else if(value instanceof String)
				ptt.values().put(name, "str:" + value);
			else
				ptt.values().put(name, value);
		}
		
		public void visitEnum(String name, String descriptor, String value){
			ptt.values().put(name, "enum:" + desc2qualified(descriptor) + "#" + value);
		}
		
		public AnnotationVisitor visitArray(String name){
			ClassfileAnnotationPrototype tPtt = new ClassfileAnnotationPrototype(name); // dummy name
			var oPtt = ptt;
			final int[] count = {0};
			return new ClassfileAnnotationVisitor(tPtt){
				public AnnotationVisitor visitAnnotation(String name, String descriptor){
					return super.visitAnnotation(String.valueOf(count[0]++), descriptor);
				}
				public void visitEnum(String name, String descriptor, String value){
					super.visitEnum(String.valueOf(count[0]++), descriptor, value);
				}
				public AnnotationVisitor visitArray(String name){
					return super.visitArray(String.valueOf(count[0]++));
				}
				public void visit(String name, Object value){
					super.visit(String.valueOf(count[0]++), value);
				}
				public void visitEnd(){
					oPtt.values().put(name, new ArrayList<>(tPtt.values().values()).toArray());
				}
			};
		}
	}
	
	@NotNull
	private static String desc2qualified(String descriptor){
		return descriptor.substring(1, descriptor.length() - 1).replace('/', '.');
	}
}