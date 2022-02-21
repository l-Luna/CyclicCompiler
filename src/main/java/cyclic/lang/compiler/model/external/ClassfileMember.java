package cyclic.lang.compiler.model.external;

import cyclic.lang.compiler.model.AccessFlags;
import cyclic.lang.compiler.model.FieldReference;
import cyclic.lang.compiler.model.MethodReference;
import cyclic.lang.compiler.model.TypeReference;
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
}