package cyclic.lang.compiler.model.generic;

import cyclic.lang.compiler.model.MethodReference;
import cyclic.lang.compiler.model.TypeParameterReference;
import cyclic.lang.compiler.model.TypeReference;

import java.util.List;
import java.util.stream.Collectors;

// TODO: this is a hack
//   can't erase a JdkTypeRef because the generic type *is* in the method signature
public class ErasedMethodRef extends ParameterizedMethodRef{
	
	public ErasedMethodRef(MethodReference base){
		super(base, base.typeParameters().stream().collect(Collectors.toMap(y -> y, TypeParameterReference::erasure)), null);
	}
	
	public List<TypeReference> parameters(){
		return super.parameters().stream().map(TypeReference::erasure).toList();
	}
	
	public TypeReference returns(){
		return super.returns().erasure();
	}
	
	public MethodReference erasure(){
		return this;
	}
}