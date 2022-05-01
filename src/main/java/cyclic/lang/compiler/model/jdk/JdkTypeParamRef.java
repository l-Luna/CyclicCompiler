package cyclic.lang.compiler.model.jdk;

import cyclic.lang.compiler.model.MemberReference;
import cyclic.lang.compiler.model.TypeParameterReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Member;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;

public class JdkTypeParamRef implements TypeParameterReference{
	
	TypeVariable<?> underlying;
	
	// TODO: remove Class<?> requirement
	public JdkTypeParamRef(TypeVariable<?> underlying){
		this.underlying = underlying;
	}
	
	@NotNull
	public MemberReference owner(){
		return switch(underlying.getGenericDeclaration()){
			case Class<?> c -> Utils.forAnyClass(c);
			case Member m -> JdkUtils.fromReflectMember(m);
			case null, default -> throw new IllegalStateException();
		};
	}
	
	public @NotNull TypeReference in(){
		return switch(underlying.getGenericDeclaration()){
			case Class<?> c -> Utils.forAnyClass(c);
			case Member m -> JdkUtils.declaringType(m);
			case null, default -> throw new UnsupportedOperationException();
		};
	}
	
	public int index(){
		return Arrays.asList(underlying.getGenericDeclaration().getTypeParameters()).indexOf(underlying);
	}
	
	public @NotNull List<TypeReference> bounds(){
		return Arrays.stream(underlying.getBounds())
				.map(JdkUtils::fromReflectType)
				.toList();
	}
	
	public @NotNull Variance variance(){
		return Variance.INVARIANT;
	}
	
	public boolean isReified(){
		return false;
	}
	
	public String shortName(){
		return underlying.getName();
	}
	
	public String descriptor(){
		return superClass().descriptor();
	}
	
	public boolean equals(Object o){
		return o instanceof TypeReference t && t.fullyQualifiedName().equals(fullyQualifiedName());
	}
	
	public int hashCode(){
		return fullyQualifiedName().hashCode();
	}
	
	public String toString(){
		return fullyQualifiedName();
	}
}