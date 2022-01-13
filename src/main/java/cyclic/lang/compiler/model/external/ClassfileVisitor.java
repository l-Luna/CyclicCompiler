package cyclic.lang.compiler.model.external;

import cyclic.lang.compiler.model.TypeKind;
import cyclic.lang.compiler.model.Utils;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.Arrays;

import static org.objectweb.asm.Opcodes.*;

/*package-private*/ class ClassfileVisitor extends ClassVisitor{
	
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
		fill.annotationSigs.add(descriptor);
		// TODO: get the values too
		return null;
	}
}