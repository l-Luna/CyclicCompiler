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
		this.name = ast.ID().getText();
		this.packageName = packageName;
		this.imports = imports;
		// TODO: interface multiple inheritance
		superTypeName = ast.objectExtends() != null ? ast.objectExtends().type(0).getText() : "java.lang.Object";
		interfaceNames = ast.objectImplements() != null ? ast.objectImplements().type().stream().map(RuleContext::getText).collect(Collectors.toList()) : Collections.emptyList();
		
		String typeText = ast.objectType().getText().toLowerCase(Locale.ROOT).replaceAll(" +", "");
		kind = switch(typeText){
			case "class" -> TypeKind.CLASS;
			case "interface" -> TypeKind.INTERFACE;
			case "enum" -> TypeKind.ENUM;
			case "@interface" -> TypeKind.ANNOTATION;
			case "record" -> TypeKind.RECORD; // not implemented yet
			case "single" -> TypeKind.SINGLE;
			default -> throw new IllegalStateException("Unexpected type kind: " + typeText + " in type " + fullyQualifiedName());
		};
		
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
		
		checkDuplicates(fields.stream().map(CyclicField::name).toList(), "field name");
		checkDuplicates(methods.stream().map(CyclicMethod::nameAndDescriptor).toList(), "method");
		checkDuplicates(constructors.stream().map(CyclicConstructor::descriptor).toList(), "constructor with descriptor");
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