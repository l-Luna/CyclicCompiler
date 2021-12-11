package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// A type that will be compiled this run.
public class CyclicType implements TypeReference{
	
	private String name, packageName;
	private TypeKind kind;
	private AccessFlags flags;
	
	private List<CyclicMethod> methods = new ArrayList<>();
	
	public CyclicType outer;
	public List<CyclicType> inners = new ArrayList<>();
	public List<String> imports;
	
	public CyclicType(CyclicLangParser.ClassDeclContext ast, String packageName, List<String> imports){
		this.name = ast.ID().getText();
		this.packageName = packageName;
		this.imports = imports;
		
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
		}
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
		return null;
	}
	
	public List<? extends ConstructorReference> constructors(){
		return null;
	}
	
	public TypeReference outerClass(){
		return outer;
	}
	
	public List<? extends TypeReference> innerClasses(){
		return inners;
	}
	
	public void resolveRefs(){
		methods.forEach(CyclicMethod::resolve);
	}
}