package cyclic.lang.compiler.model.jdk;

import cyclic.lang.compiler.model.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JdkTypeRef implements TypeReference{
	
	Class<?> underlying;
	List<JdkFieldRef> fields;
	List<JdkMethodRef> methods;
	List<JdkCtorRef> ctors;
	
	public JdkTypeRef(Class<?> underlying){
		this.underlying = underlying;
		fields = Arrays.stream(underlying.getFields()).map(k -> new JdkFieldRef(k, this)).collect(Collectors.toList());
		methods = Arrays.stream(underlying.getMethods()).map(JdkMethodRef::new).collect(Collectors.toList());
		ctors = Arrays.stream(underlying.getConstructors()).map(JdkCtorRef::new).collect(Collectors.toList());
	}
	
	public String shortName(){
		return underlying.getSimpleName();
	}
	
	public String packageName(){
		return underlying.getPackageName();
	}
	
	public TypeKind kind(){
		return underlying.isInterface() ? TypeKind.INTERFACE :
				underlying.isAnnotation() ? TypeKind.ANNOTATION :
				underlying.isRecord() ? TypeKind.RECORD :
				underlying.isEnum() ? TypeKind.ENUM :
				TypeKind.CLASS; // A system type is never a single
	}
	
	public AccessFlags flags(){
		return Utils.fromBitfield(underlying.getModifiers());
	}
	
	// inner/outer class info is not needed (?)
	public TypeReference outerClass(){
		return null;
	}
	
	public TypeReference superClass(){
		return underlying.getSuperclass() != null ? Utils.forAnyClass(underlying.getSuperclass()) : null;
	}
	
	public List<? extends TypeReference> superInterfaces(){
		return Arrays.stream(underlying.getInterfaces()).map(Utils::forAnyClass).collect(Collectors.toList());
	}
	
	public List<? extends TypeReference> innerClasses(){
		return Collections.emptyList();
	}
	
	public List<? extends MethodReference> methods(){
		return methods;
	}
	
	public List<? extends FieldReference> fields(){
		return fields;
	}
	
	public List<? extends CallableReference> constructors(){
		return ctors;
	}
	
	public Set<AnnotationTag> annotations(){
		return Arrays.stream(underlying.getAnnotations()).map(k -> AnnotationTag.fromAnnotation(k, this)).collect(Collectors.toSet());
	}
	
	public String toString(){
		return "System:" + fullyQualifiedName();
	}
}
