package cyclic.lang.compiler.model.generic;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WildcardTypeRef implements TypeReference{
	
	private static final WildcardTypeRef ANY = new WildcardTypeRef(null, null);
	
	private TypeReference upper, lower; // at most one may be non-null
	
	private WildcardTypeRef(TypeReference upper, TypeReference lower){
		this.upper = upper;
		this.lower = lower;
		if(upper != null && lower != null)
			throw new IllegalArgumentException();
	}
	
	public static WildcardTypeRef wildcard(){
		return ANY;
	}
	
	public static WildcardTypeRef anyExtends(TypeReference superclass){
		return new WildcardTypeRef(superclass, null);
	}
	
	public static WildcardTypeRef anySuper(TypeReference subclass){
		return new WildcardTypeRef(null, subclass);
	}
	
	public String shortName(){
		return upper == null && lower == null ? "?" : upper != null ? "? extends " + upper.shortName() : "? super " + lower.shortName();
	}
	
	public String packageName(){
		return "";
	}
	
	public TypeKind kind(){
		return TypeKind.CONSTRUCTED;
	}
	
	public AccessFlags flags(){
		return new AccessFlags(Visibility.PUBLIC, false, false);
	}
	
	public TypeReference outerClass(){
		return null;
	}
	
	public @Nullable("null -> Object or primitives") TypeReference superClass(){
		return upper != null ? upper : TypeResolver.resolveFq(Constants.OBJECT);
	}
	
	public List<? extends TypeReference> superInterfaces(){
		return upper != null ? upper.superInterfaces() : List.of();
	}
	
	public List<? extends TypeReference> innerClasses(){
		return List.of();
	}
	
	public List<? extends MethodReference> methods(){
		return upper != null ? upper.methods() : List.of();
	}
	
	public List<? extends FieldReference> fields(){
		return upper != null ? upper.fields() : List.of();
	}
	
	public List<? extends ConstructorReference> constructors(){
		return List.of();
	}
}