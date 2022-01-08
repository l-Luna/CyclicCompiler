package cyclic.lang.compiler.model.platform;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.resolve.TypeResolver;

import java.util.Collections;
import java.util.List;

public class ArrayTypeRef implements TypeReference{
	
	private TypeReference underlying;
	
	public ArrayTypeRef(TypeReference underlying){
		this.underlying = underlying;
	}
	
	// Most of these fields aren't properly applicable to arrays, and are given values that are useful for debugging.
	public String shortName(){
		return getComponent().shortName() + "[]";
	}
	
	public String packageName(){
		return getComponent().packageName();
	}
	
	// For an array type, internal names are different
	public String internalName(){
		return descriptor();
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
		return getComponent().superClass() != null ? new ArrayTypeRef(getComponent().superClass()) : TypeResolver.resolveFq(Constants.OBJECT);
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
		return Collections.singletonList(new ArrayLengthField(this));
	}
	
	public List<? extends CallableReference> constructors(){
		return Collections.emptyList();
	}
	
	public String descriptor(){
		return "[" + getComponent().descriptor();
	}
	
	public TypeReference getComponent(){
		return underlying;
	}
	
	public boolean isAssignableTo(TypeReference target){
		if(target.fullyQualifiedName().equals(Constants.OBJECT))
			return true;
		
		return target instanceof ArrayTypeRef arrayTarget && getComponent().isAssignableTo(arrayTarget.getComponent());
	}
	
	public String toString(){
		return getComponent().toString() + "[]";
	}
}