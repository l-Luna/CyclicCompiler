package cyclic.lang.compiler.model.external;

import cyclic.lang.compiler.model.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SystemTypeRef implements TypeReference{
	
	Class<?> underlying;
	List<SystemFieldRef> fields;
	List<SystemMethodRef> methods;
	List<SystemCtorRef> ctors;
	
	public SystemTypeRef(Class<?> underlying){
		this.underlying = underlying;
		fields = Arrays.stream(underlying.getFields()).map(k -> new SystemFieldRef(k, this)).collect(Collectors.toList());
		methods = Arrays.stream(underlying.getMethods()).map(SystemMethodRef::new).collect(Collectors.toList());
		ctors = Arrays.stream(underlying.getConstructors()).map(SystemCtorRef::new).collect(Collectors.toList());
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
				TypeKind.CLASS; // A system type is never a single (yet)
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
}
