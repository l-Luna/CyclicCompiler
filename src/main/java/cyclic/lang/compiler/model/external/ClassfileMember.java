package cyclic.lang.compiler.model.external;

import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.resolve.TypeResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*package-private*/ sealed interface ClassfileMember{
	
	void resolveRefs();
	
	final class Field implements FieldReference, ClassfileMember{
		
		String typeName, name;
		TypeReference in, type;
		AccessFlags flags;
		boolean isStatic, isVolatile, isEnumConst;
		
		public TypeReference in(){
			return in;
		}
		
		public String name(){
			return name;
		}
		
		public TypeReference type(){
			return type;
		}
		
		public AccessFlags flags(){
			return flags;
		}
		
		public boolean isStatic(){
			return isStatic;
		}
		
		public boolean isVolatile(){
			return isVolatile;
		}
		
		public boolean isEnumDefinition(){
			return isEnumConst;
		}
		
		public void resolveRefs(){
			type = TypeResolver.resolveFq(typeName.replace('/', '.'));
		}
	}
	
	final class Method implements MethodReference, ClassfileMember{
		
		TypeReference in, returns;
		String name, returnsName;
		List<String> paramTypeNames = new ArrayList<>();
		List<TypeReference> paramTypes;
		boolean isStatic, isNative, isSynchronized, isVarargs;
		AccessFlags flags;
		
		public String name(){
			return name;
		}
		
		public TypeReference in(){
			return in;
		}
		
		public List<TypeReference> parameters(){
			return paramTypes;
		}
		
		public List<String> parameterNames(){
			return List.of(); // TODO: use an annotation to mark these in class files, don't rely on debug info
		}
		
		public TypeReference returns(){
			return returns;
		}
		
		public AccessFlags flags(){
			return flags;
		}
		
		public boolean isStatic(){
			return isStatic;
		}
		
		public boolean isVarargs(){
			return isVarargs;
		}
		
		public boolean isNative(){
			return isNative;
		}
		
		public boolean isSynchronized(){
			return isSynchronized;
		}
		
		public void resolveRefs(){
			returns = TypeResolver.resolveFq(returnsName.replace('/', '.'));
			paramTypes = paramTypeNames.stream()
					.map(x -> x.replace('/', '.'))
					.map(TypeResolver::resolveFq)
					.collect(Collectors.toList());
		}
	}
	
	final class Constructor implements ConstructorReference, ClassfileMember{
		
		TypeReference in;
		List<String> paramTypeNames = new ArrayList<>();
		List<TypeReference> paramTypes;
		boolean isVarargs;
		AccessFlags flags;
		
		static Constructor fromMethod(Method m){
			Constructor c = new Constructor();
			c.in = m.in;
			c.paramTypeNames = m.paramTypeNames;
			c.flags = m.flags;
			c.isVarargs = m.isVarargs;
			return c;
		}
		
		public List<TypeReference> parameters(){
			return paramTypes;
		}
		
		public List<String> parameterNames(){
			return List.of();
		}
		
		public boolean isStatic(){
			return false; // we don't track external static ctors, they're an implementation detail
		}
		
		public boolean isVarargs(){
			return isVarargs;
		}
		
		public TypeReference in(){
			return in;
		}
		
		public AccessFlags flags(){
			return flags;
		}
		
		public void resolveRefs(){
			paramTypes = paramTypeNames.stream()
					.map(x -> x.replace('/', '.'))
					.map(TypeResolver::resolveFq)
					.collect(Collectors.toList());
		}
	}
}