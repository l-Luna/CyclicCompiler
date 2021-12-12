package cyclic.lang.compiler.model.platform;

import cyclic.lang.compiler.model.*;

import java.util.Collections;
import java.util.List;

public class ArrayTypeRef implements TypeReference{
	
	TypeReference underlying;
	
	public ArrayTypeRef(TypeReference underlying){
		this.underlying = underlying;
	}
	
	// Most of these fields aren't properly applicable to arrays, and are given values that are useful for debugging.
	public String shortName(){
		return underlying.shortName() + "[]";
	}
	
	public String packageName(){
		return underlying.packageName();
	}
	
	public String internalName(){
		return underlying.internalName() + "[]";
	}
	
	public TypeKind kind(){
		return TypeKind.CONSTRUCTED;
	}
	
	public AccessFlags flags(){
		return new AccessFlags(Visibility.PUBLIC, false, true);
	}
	
	public TypeReference outerClass(){
		return null;
	}
	
	public TypeReference superClass(){
		return TypeResolver.resolveOptional("java.lang.Object").orElseThrow();
	}
	
	public List<? extends TypeReference> superInterfaces(){
		return Collections.emptyList();
	}
	
	public List<? extends TypeReference> innerClasses(){
		return Collections.emptyList();
	}
	
	public List<? extends MethodReference> methods(){
		return Collections.emptyList();
	}
	
	public List<? extends FieldReference> fields(){
		return Collections.emptyList();
	}
	
	public List<? extends ConstructorReference> constructors(){
		return Collections.emptyList();
	}
	
	public String descriptor(){
		return "[" + underlying.descriptor();
	}
}