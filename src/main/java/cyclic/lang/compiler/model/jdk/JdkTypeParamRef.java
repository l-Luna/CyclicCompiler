package cyclic.lang.compiler.model.jdk;

import cyclic.lang.compiler.model.TypeParameterReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
	
	public @Nullable TypeReference from(){
		return underlying.getGenericDeclaration() instanceof Class<?> c ? Utils.forAnyClass(c) : null;
	}
	
	public @NotNull TypeReference in(){
		if(underlying.getGenericDeclaration() instanceof Class<?> c)
			return Utils.forAnyClass(c);
		else if(underlying.getGenericDeclaration() instanceof Member m)
			return JdkUtils.declaringType(m);
		throw new UnsupportedOperationException();
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
	
	public boolean equals(Object obj){
		return obj instanceof TypeParameterReference tps && from().equals(tps.from()) && index() == tps.index();
	}
	
	public String descriptor(){
		return superClass().descriptor();
	}
}