package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.*;
import org.antlr.v4.runtime.RuleContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

// A type that will be compiled this run.
public class CyclicType implements TypeReference{
	
	private String name, packageName;
	private TypeKind kind;
	private AccessFlags flags;
	
	private List<CyclicMethod> methods = new ArrayList<>();
	private List<CyclicConstructor> constructors = new ArrayList<>();
	public List<CyclicConstructor> initBlocks = new ArrayList<>();
	
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
		superTypeName = ast.objectExtends() != null ? ast.objectExtends().type().getText() : "java.lang.Object";
		interfaceNames = ast.objectImplements() != null ? ast.objectImplements().type().stream().map(RuleContext::getText).collect(Collectors.toList()) : Collections.emptyList();
		
		String typeText = ast.objectType().getText().toLowerCase(Locale.ROOT).replaceAll(" +", "");
		kind = switch(typeText){
			case "class" -> TypeKind.CLASS;
			case "interface" -> TypeKind.INTERFACE;
			case "enum" -> TypeKind.ENUM;
			case "@interface" -> TypeKind.ANNOTATION;
			case "record" -> TypeKind.RECORD; // not implemented yet
			case "single" -> TypeKind.SINGLE;
			default -> throw new IllegalStateException("Unexpected type kind: " + typeText);
		};
		
		flags = Utils.fromModifiers(ast.modifiers());
		
		for(var member : ast.member()){
			if(member.function() != null)
				methods.add(new CyclicMethod(member.function(), this));
			else if(member.constructor() != null)
				constructors.add(new CyclicConstructor(member.constructor(), this));
			else if(member.init() != null)
				initBlocks.add(new CyclicConstructor(member.init(), this));
		}
		
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
		return Collections.emptyList();
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
		methods.forEach(CyclicMethod::resolve);
		constructors.forEach(CyclicConstructor::resolve);
		initBlocks.forEach(CyclicConstructor::resolve);
		superType = TypeResolver.resolve(superTypeName, imports, packageName());
		interfaces = interfaceNames.stream().map(x -> TypeResolver.resolve(x, imports, packageName())).collect(Collectors.toList());
	}
	
	public void resolveMethodBodies(){
		methods.forEach(CyclicMethod::resolveBody);
		constructors.forEach(CyclicConstructor::resolveBody);
		initBlocks.forEach(CyclicConstructor::resolveBody);
	}
}