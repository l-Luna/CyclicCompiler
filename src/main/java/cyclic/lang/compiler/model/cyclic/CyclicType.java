package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.model.*;
import org.antlr.v4.runtime.RuleContext;

import java.util.*;
import java.util.stream.Collectors;

// A type that will be compiled this run.
public class CyclicType implements TypeReference{
	
	private String name, packageName;
	private TypeKind kind;
	private AccessFlags flags;
	
	private List<CyclicMember> members = new ArrayList<>();
	
	public List<CyclicConstructor> initBlocks = new ArrayList<>();
	
	private List<CyclicField> fields = new ArrayList<>();
	private List<CyclicConstructor> constructors = new ArrayList<>();
	private List<CyclicMethod> methods = new ArrayList<>();
	
	private String superTypeName;
	private List<String> interfaceNames;
	private TypeReference superType;
	private List<TypeReference> interfaces;
	
	public CyclicType outer;
	public List<CyclicType> inners = new ArrayList<>();
	public List<String> imports;
	
	public CyclicType(CyclicLangParser.ClassDeclContext ast, String packageName, List<String> imports){
		this.name = ast.idPart().getText();
		this.packageName = packageName;
		this.imports = imports;
		
		String typeText = ast.objectType().getText().toLowerCase(Locale.ROOT).replaceAll(" +", "");
		kind = switch(typeText){
			case "class" -> TypeKind.CLASS;
			case "interface" -> TypeKind.INTERFACE;
			case "enum" -> TypeKind.ENUM;
			case "@interface", "annotation" -> TypeKind.ANNOTATION;
			case "record" -> TypeKind.RECORD;
			case "single" -> TypeKind.SINGLE;
			default -> throw new IllegalStateException("Unexpected type kind: " + typeText + " in type " + fullyQualifiedName());
		};
		
		CompileTimeException.setFile(fullyQualifiedName());
		
		if(kind == TypeKind.INTERFACE){
			superTypeName = "java.lang.Object";
			interfaceNames = ast.objectExtends() != null ? ast.objectExtends().type().stream().map(RuleContext::getText).collect(Collectors.toList()) : Collections.emptyList();
			if(ast.objectImplements() != null && ast.objectImplements().type().size() > 0)
				throw new CompileTimeException(null, "Interface has " + ast.objectImplements().type().size() + " declared implemented interfaces, but must have 0");
		}else{
			if(ast.objectExtends() != null && ast.objectExtends().type().size() > 1)
				throw new CompileTimeException(null, "Non-interface has " + ast.objectExtends().type().size() + " declared supertypes, but can only have 1");
			superTypeName = ast.objectExtends() != null ? ast.objectExtends().type(0).getText() : "java.lang.Object";
			interfaceNames = ast.objectImplements() != null ? ast.objectImplements().type().stream().map(RuleContext::getText).collect(Collectors.toList()) : Collections.emptyList();
		}
		
		flags = Utils.fromModifiers(ast.modifiers());
		
		for(var member : ast.member()){
			if(member.function() != null)
				methods.add(new CyclicMethod(member.function(), this));
			else if(member.constructor() != null)
				constructors.add(new CyclicConstructor(member.constructor(), this));
			else if(member.init() != null)
				initBlocks.add(new CyclicConstructor(member.init(), this));
			else if(member.varDecl() != null)
				fields.add(new CyclicField(member.varDecl(), this));
		}
		
		members.addAll(fields);
		members.addAll(constructors);
		members.addAll(initBlocks);
		members.addAll(methods);
		
		// implicit constructor if none is present - ensures that init blocks and static field inits are written
		if(constructors.size() == 0)
			constructors.add(new CyclicConstructor(false, this));
		if(initBlocks.stream().noneMatch(k -> k.isS))
			initBlocks.add(new CyclicConstructor(true, this));
	}
	
	public String shortName(){
		return name;
	}
	
	public String packageName(){
		return packageName;
	}
	
	public TypeKind kind(){
		return kind;
	}
	
	public AccessFlags flags(){
		return flags;
	}
	
	public List<? extends MethodReference> methods(){
		return methods;
	}
	
	public List<? extends FieldReference> fields(){
		return fields;
	}
	
	public List<? extends CallableReference> constructors(){
		return constructors;
	}
	
	public TypeReference outerClass(){
		return outer;
	}
	
	public TypeReference superClass(){
		return superType;
	}
	
	public List<? extends TypeReference> superInterfaces(){
		return interfaces;
	}
	
	public List<? extends TypeReference> innerClasses(){
		return inners;
	}
	
	public void resolveRefs(){
		CompileTimeException.setFile(fullyQualifiedName());
		
		members.forEach(CyclicMember::resolve);
		
		superType = TypeResolver.resolve(superTypeName, imports, packageName());
		interfaces = interfaceNames.stream().map(x -> TypeResolver.resolve(x, imports, packageName())).collect(Collectors.toList());
		
		if(superType.kind() == TypeKind.INTERFACE)
			throw new CompileTimeException(null, "Cannot extend the interface type " + superType.fullyQualifiedName());
		if(superType.flags().isFinal())
			throw new CompileTimeException(null, "Cannot extend the final type " + superType.fullyQualifiedName());
		
		for(TypeReference i : superInterfaces())
			if(i.kind() != TypeKind.INTERFACE)
				throw new CompileTimeException(null, "Cannot implement non-interface type " + i.fullyQualifiedName());
		
		checkDuplicates(constructors.stream().map(CyclicConstructor::descriptor).toList(), "constructor with descriptor");
		checkDuplicates(interfaces.stream().map(TypeReference::internalName).toList(), "implemented interface");
		checkDuplicates(fields.stream().map(CyclicField::name).toList(), "field name");
		checkDuplicates(methods.stream().map(CyclicMethod::nameAndDescriptor).toList(), "method");
	}
	
	public void resolveBodies(){
		CompileTimeException.setFile(fullyQualifiedName());
		
		members.forEach(CyclicMember::resolveBody);
		
		for(CyclicField field : fields){
			var assign = field.assign();
			if(assign != null)
				initBlocks.add(assign);
		}
	}
	
	private static <T> void checkDuplicates(List<T> in, String label){
		Set<T> checked = new HashSet<>(in.size());
		for(T t : in){
			if(checked.contains(t))
				throw new CompileTimeException(null, "Duplicate " + label + " \"" + t + "\"");
			checked.add(t);
		}
	}
}