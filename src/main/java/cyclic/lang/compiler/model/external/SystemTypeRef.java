package cyclic.lang.compiler.model.external;

import cyclic.lang.compiler.model.*;

import java.util.Collections;
import java.util.List;

public class SystemTypeRef implements TypeReference{
	
	Class<?> underlying;
	
	public SystemTypeRef(Class<?> underlying){
		this.underlying = underlying;
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
	
	public List<? extends TypeReference> innerClasses(){
		return Collections.emptyList();
	}
	
	// TODO
	public List<? extends MethodReference> methods(){
		return null;
	}
	
	public List<? extends FieldReference> fields(){
		return null;
	}
	
	public List<? extends ConstructorReference> constructors(){
		return null;
	}
}
