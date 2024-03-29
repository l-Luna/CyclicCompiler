package cyclic.lang.compiler.model.jdk;

import cyclic.lang.compiler.model.*;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JdkTypeRef implements TypeReference{
	
	Class<?> underlying;
	List<JdkFieldRef> fields;
	List<JdkMethodRef> methods;
	List<JdkMethodRef> declaredMethods;
	List<JdkCtorRef> ctors;
	List<JdkRecordComponentRef> components;
	
	TypeReference superclass = null;
	List<TypeReference> interfaces = null;
	
	public JdkTypeRef(Class<?> underlying){
		this.underlying = underlying;
		fields = Arrays.stream(underlying.getDeclaredFields()).map(k -> new JdkFieldRef(k, this)).toList();
		declaredMethods = Arrays.stream(underlying.getDeclaredMethods()).map(JdkMethodRef::new).toList();
		methods = Arrays.stream(underlying.getMethods()).map(JdkMethodRef::new).toList();
		ctors = Arrays.stream(underlying.getDeclaredConstructors()).map(JdkCtorRef::new).toList();
		if(underlying.isRecord())
			components = Arrays.stream(underlying.getRecordComponents()).map(JdkRecordComponentRef::new).toList();
		else components = List.of();
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
		return superclass != null ? superclass : (superclass = (underlying.getSuperclass() != null ? Utils.forAnyClass(underlying.getSuperclass()) : null));
	}
	
	public List<? extends TypeReference> superInterfaces(){
		return interfaces != null ? interfaces : (interfaces = Arrays.stream(underlying.getInterfaces()).map(Utils::forAnyClass).toList());
	}
	
	public List<? extends TypeReference> innerClasses(){
		return Collections.emptyList();
	}
	
	public List<? extends MethodReference> declaredMethods(){
		return declaredMethods;
	}
	
	public List<? extends MethodReference> methods(){
		return methods;
	}
	
	public List<? extends FieldReference> fields(){
		return fields;
	}
	
	public List<? extends ConstructorReference> constructors(){
		return ctors;
	}
	
	public List<? extends RecordComponentReference> recordComponents(){
		return components;
	}
	
	public List<? extends TypeParameterReference> typeParameters(){
		return Arrays.stream(underlying.getTypeParameters())
				.map(JdkTypeParamRef::new)
				.toList();
	}
	
	public Set<AnnotationTag> annotations(){
		return Arrays.stream(underlying.getAnnotations()).map(k -> AnnotationTag.fromAnnotation(k, this)).collect(Collectors.toSet());
	}
	
	@Nullable("null -> Object")
	public TypeReference genericSuperClass(){
		var clss = underlying.getGenericSuperclass();
		if(clss == null)
			return null;
		return JdkUtils.fromReflectType(clss);
	}
	
	public List<? extends TypeReference> genericSuperInterfaces(){
		return Arrays.stream(underlying.getGenericInterfaces()).map(JdkUtils::fromReflectType).toList();
	}
	
	public String toString(){
		return "JDK:" + fullyQualifiedName();
	}
	
	public boolean equals(Object o){
		return o instanceof TypeReference t && t.fullyQualifiedName().equals(fullyQualifiedName());
	}
	
	public int hashCode(){
		return fullyQualifiedName().hashCode();
	}
}
