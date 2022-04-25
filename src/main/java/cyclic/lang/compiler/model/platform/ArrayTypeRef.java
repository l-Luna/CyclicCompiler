package cyclic.lang.compiler.model.platform;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.jetbrains.annotations.NotNull;

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
	
	public List<? extends MethodReference> declaredMethods(){
		return Collections.emptyList();
	}
	
	public List<? extends MethodReference> methods(){
		return declaredMethods();
	}
	
	public List<? extends FieldReference> fields(){
		return Collections.singletonList(new ArrayLengthField(this));
	}
	
	public List<? extends ConstructorReference> constructors(){
		return Collections.emptyList();
	}
	
	public String descriptor(){
		return "[" + getComponent().descriptor();
	}
	
	public TypeReference getComponent(){
		return underlying;
	}
	
	public @NotNull TypeReference erasure(){
		var erasedComp = getComponent().erasure();
		if(erasedComp != getComponent())
			return new ArrayTypeRef(erasedComp);
		return this;
	}
	
	public boolean isAssignableTo(TypeReference target){
		if(target == null)
			return false;
		if(target.fullyQualifiedName().equals(Constants.OBJECT))
			return true;
		
		return target instanceof ArrayTypeRef arrayTarget && getComponent().isAssignableTo(arrayTarget.getComponent());
	}
	
	public String toString(){
		return getComponent().toString() + "[]";
	}
	
	public boolean equals(Object o){
		return o instanceof TypeReference t && t.fullyQualifiedName().equals(fullyQualifiedName());
	}
	
	public int hashCode(){
		return fullyQualifiedName().hashCode();
	}
}