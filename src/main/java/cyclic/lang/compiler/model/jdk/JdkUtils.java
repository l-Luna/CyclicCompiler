package cyclic.lang.compiler.model.jdk;

import cyclic.lang.compiler.model.MemberReference;
import cyclic.lang.compiler.model.TypeParameterReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import cyclic.lang.compiler.model.generic.ParameterizedTypeRef;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;

import java.lang.reflect.*;
import java.util.HashMap;

public final class JdkUtils{
	
	public static TypeReference fromReflectType(Type type){
		// java.lang.reflect defines:
		// Class<T>, TypeVariable<T>, ParameterizedType, GenericArrayType, WildcardType
		// we don't handle them all yet
		return switch(type){
			case Class<?> c -> Utils.forAnyClass(c);
			case ParameterizedType pt -> {
				var typeArgs = new HashMap<TypeParameterReference, TypeReference>();
				for(int i = 0; i < pt.getActualTypeArguments().length; i++){
					var param = (TypeParameterReference)fromReflectType(((Class<?>)pt.getRawType()).getTypeParameters()[i]);
					TypeReference arg = fromReflectType(pt.getActualTypeArguments()[i]);
					typeArgs.put(param, arg);
				}
				yield new ParameterizedTypeRef(fromReflectType(pt.getRawType()), typeArgs);
			}
			case GenericArrayType gat -> new ArrayTypeRef(fromReflectType(gat.getGenericComponentType()));
			case TypeVariable<?> tv -> new JdkTypeParamRef(tv);
			default -> throw new IllegalStateException("Cannot convert type: " + type);
		};
	}
	
	public static TypeReference declaringType(Member member){
		return Utils.forAnyClass(member.getDeclaringClass());
	}
	
	// TODO: use cached values
	public static MemberReference fromReflectMember(Member member){
		return switch(member){
			case Method m -> new JdkMethodRef(m);
			case Constructor c -> new JdkCtorRef(c);
			case Field f -> new JdkFieldRef(f, Utils.forAnyClass(f.getDeclaringClass()));
			default -> throw new IllegalStateException("Cannot convert member: " + member);
		};
	}
}