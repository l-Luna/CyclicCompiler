package cyclic.lang.compiler.model.generic;

import cyclic.lang.compiler.model.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * A reference to a parameterized type.
 */
public class ParameterizedTypeRef implements TypeReference{
	
	private TypeReference base;
	private List<TypeReference> typeArguments;
	
	public ParameterizedTypeRef(@NotNull TypeReference base, @NotNull List<TypeReference> typeArguments){
		this.base = base;
		this.typeArguments = typeArguments;
	}
	
	public TypeReference resolve(@NotNull TypeParameterReference param){
		return typeArguments.get(param.index());
	}
	
	public String shortName(){
		return base.shortName();
	}
	
	public String packageName(){
		return base.packageName();
	}
	
	public TypeKind kind(){
		return base.kind();
	}
	
	public AccessFlags flags(){
		return base.flags();
	}
	
	public TypeReference outerClass(){
		return base.outerClass();
	}
	
	public @Nullable TypeReference superClass(){
		return base.superClass();
	}
	
	public List<? extends TypeReference> superInterfaces(){
		return base.superInterfaces();
	}
	
	public List<? extends TypeReference> innerClasses(){
		return base.innerClasses();
	}
	
	// generify these
	
	public List<? extends MethodReference> methods(){
		return base.methods().stream()
				.map(x -> new ParameterizedMethodRef(x, typeArguments, this))
				.toList();
	}
	
	public List<? extends FieldReference> fields(){
		return base.fields();
	}
	
	public List<? extends CallableReference> constructors(){
		return base.constructors();
	}
	
	public @NotNull TypeReference erasure(){
		return base.erasure(); // type aliases might need multiple erasure steps
	}
}