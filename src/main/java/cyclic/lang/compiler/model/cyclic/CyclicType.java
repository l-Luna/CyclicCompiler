package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.instructions.Statement;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cyclic.lang.compiler.Constants.*;

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
	
	private List<FieldReference> fieldsAndInherited = new ArrayList<>();
	private List<MethodReference> methodsAndInherited = new ArrayList<>();
	
	private String superTypeName;
	private List<String> interfaceNames;
	private TypeReference superType;
	private List<TypeReference> interfaces;
	
	private List<CyclicLangParser.AnnotationContext> unresolvedAnnotations;
	private Set<AnnotationTag> annotations = new HashSet<>();
	
	public CyclicType outer;
	public List<CyclicType> inners = new ArrayList<>();
	public List<String> imports;
	
	public CyclicType(CyclicLangParser.ClassDeclContext ast, String packageName, List<String> imports){
		this.name = ast.idPart().getText();
		this.packageName = packageName;
		this.imports = imports;
		this.unresolvedAnnotations = ast.annotation();
		
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
			superTypeName = OBJECT;
			interfaceNames = ast.objectExtends() != null ? ast.objectExtends().type().stream().map(TypeResolver::getBaseName).collect(Collectors.toList()) : Collections.emptyList();
			if(ast.objectImplements() != null && ast.objectImplements().type().size() > 0)
				throw new CompileTimeException(null, "Interface has " + ast.objectImplements().type().size() + " declared implemented interfaces, but must have 0");
		}else{
			if(ast.objectExtends() != null && ast.objectExtends().type().size() > 1)
				throw new CompileTimeException(null, "Non-interface has " + ast.objectExtends().type().size() + " declared supertypes, but can only have 1");
			superTypeName = ast.objectExtends() != null ? TypeResolver.getBaseName(ast.objectExtends().type(0)) : OBJECT;
			interfaceNames = ast.objectImplements() != null ? ast.objectImplements().type().stream().map(TypeResolver::getBaseName).collect(Collectors.toList()) : Collections.emptyList();
		}
		
		flags = Utils.fromModifiers(ast.modifiers());
		
		if(flags.isAbstract() && flags.isFinal())
			throw new CompileTimeException(null, "Type cannot be abstract and final");
		
		boolean isInterface = kind() == TypeKind.INTERFACE;
		for(var member : ast.member()){
			if(member.function() != null)
				methods.add(new CyclicMethod(member.function(), this, isInterface));
			else if(member.constructor() != null)
				constructors.add(new CyclicConstructor(member.constructor(), this));
			else if(member.init() != null)
				initBlocks.add(new CyclicConstructor(member.init(), this));
			else if(member.varDecl() != null)
				fields.add(new CyclicField(member.varDecl(), this, isInterface));
		}
		
		members.addAll(fields);
		members.addAll(constructors);
		members.addAll(initBlocks);
		members.addAll(methods);
		
		methodsAndInherited.addAll(methods);
		fieldsAndInherited.addAll(fields);
		
		// implicit constructor if none is present - ensures that init blocks and static field inits are written
		if(constructors.size() == 0 && kind() != TypeKind.INTERFACE && kind() != TypeKind.ANNOTATION)
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
		return methodsAndInherited;
	}
	
	public List<? extends FieldReference> fields(){
		return fieldsAndInherited;
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
	
	public Set<AnnotationTag> annotations(){
		return annotations;
	}
	
	public void resolveRefs(){
		CompileTimeException.setFile(fullyQualifiedName());
		
		superType = TypeResolver.resolve(superTypeName, imports, packageName());
		interfaces = interfaceNames.stream().map(x -> TypeResolver.resolve(x, imports, packageName())).collect(Collectors.toList());
		
		if(kind == TypeKind.INTERFACE){
			if(flags.isFinal())
				throw new CompileTimeException(null, "Interfaces must not be final");
			flags = new AccessFlags(flags.visibility(), true, false);
			
		}else if(kind == TypeKind.ENUM){
			if(flags.isAbstract())
				throw new CompileTimeException(null, "Enums must not be abstract");
			if(!superType.fullyQualifiedName().equals(OBJECT) && !superType.fullyQualifiedName().equals(ENUM))
				throw new CompileTimeException(null, "Enums can only declare java.lang.Object or java.lang.Enum as super type");
			flags = new AccessFlags(flags.visibility(), false, true);
			superType = TypeResolver.resolve(ENUM);
			
		}else if(kind == TypeKind.RECORD){
			if(flags.isAbstract())
				throw new CompileTimeException(null, "Records must not be abstract");
			if(!superType.fullyQualifiedName().equals(OBJECT) && !superType.fullyQualifiedName().equals(RECORD))
				throw new CompileTimeException(null, "Records can only declare java.lang.Object or java.lang.Record as super type");
			flags = new AccessFlags(flags.visibility(), false, true);
			superType = TypeResolver.resolve(RECORD);
			
		}else if(kind == TypeKind.ANNOTATION){
			if(flags.isFinal())
				throw new CompileTimeException(null, "Annotations must not be marked as final");
			if(!superType.fullyQualifiedName().equals(OBJECT))
				throw new CompileTimeException(null, "Annotations can only declare java.lang.Object as super type");
			
			boolean markedAnnotation = false;
			for(TypeReference i : interfaces)
				// TODO: annotation interfaces for e.g. checkers
				// requires a Cyclic stdlib
				if(!i.fullyQualifiedName().equals(ANNOTATION))
					throw new CompileTimeException(null, "Annotations can only declare java.lang.annotation.Annotation as implemented interface");
				else markedAnnotation = true;
			
			flags = new AccessFlags(flags.visibility(), true, false);
			superType = TypeResolver.resolve(OBJECT);
			if(!markedAnnotation)
				interfaces.add(TypeResolver.resolve(ANNOTATION));
			
		}else if(kind == TypeKind.SINGLE)
			if(flags.isAbstract())
				throw new CompileTimeException(null, "Single types must not be abstract");
		
		members.forEach(CyclicMember::resolve);
		
		generateMembersForKind();
		
		for(CyclicLangParser.AnnotationContext annotation : unresolvedAnnotations)
			annotations.add(AnnotationTag.fromAst(annotation, this, this));
		
		validate();
	}
	
	private void generateMembersForKind(){
		// e.g. record members, single INSTANCE field, enum everything
	}
	
	private void validate(){
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
		
		for(CyclicMethod method : methods)
			if(method.flags().isAbstract() && !flags().isAbstract())
				throw new CompileTimeException(null, "Non-abstract type cannot have abstract method " + method.nameAndDescriptor());
		
		if(kind() == TypeKind.INTERFACE){
			if(constructors.size() > 0)
				throw new CompileTimeException(null, "Interfaces should have no constructors, but found " + constructors.size());
			if(fields.stream().anyMatch(x -> !x.isStatic()))
				throw new CompileTimeException(null, "Interfaces should have no instance fields, but found " + fields.stream().filter(x -> !x.isStatic()).count());
		}
	}
	
	public void resolveInheritance(){
		CompileTimeException.setFile(fullyQualifiedName());
		// don't inherit overridden methods
		for(MethodReference method : Stream.concat(superType.methods().stream(), interfaces.stream().flatMap(x -> x.methods().stream())).toList()){
			if(methods.stream().noneMatch(x -> x.nameAndDescriptor().equals(method.nameAndDescriptor()))){
				if(method.flags().isAbstract() && !flags.isAbstract())
					throw new CompileTimeException(null, "Abstract supertype method " + method.nameAndDescriptor() + " must be overridden in concrete subclass");
				methodsAndInherited.add(method);
			}else if(method.flags().isFinal() && !(method.flags().visibility() == Visibility.PRIVATE))
				throw new CompileTimeException(null, "Method " + method.nameAndDescriptor() + " cannot be overridden");
		}
		
		for(FieldReference field : superType.fields()){
			if(fields.stream().noneMatch(x -> x.name().equals(field.name())))
				fieldsAndInherited.add(field);
			else if(!(field.flags().visibility() == Visibility.PRIVATE))
				throw new CompileTimeException(null, "Field " + field.name() + " is defined in supertype and cannot be duplicated");
		}
	}
	
	public void resolveBodies(){
		CompileTimeException.setFile(fullyQualifiedName());
		
		members.forEach(CyclicMember::resolveBody);
		
		for(CyclicField field : fields){
			var assign = field.assign();
			if(assign != null)
				initBlocks.add(assign);
		}
		
		// validate annotation component methods
		// if a method is not inherited, it must either not have a body, or have a body consisting of one return statement
		if(kind() == TypeKind.ANNOTATION)
			for(CyclicMethod method : methods)
				if(method.body != null)
					if(method.body instanceof Statement.ReturnStatement ret){
						if(ret.returnValue != null)
							method.constantAnnotationComponentValue = Guaranteed.constant(ret.returnValue).orElseThrow(() -> new CompileTimeException(null, "Annotation component methods must have a constant return value"));
						if(method.constantAnnotationComponentValue == Guaranteed.NULL_MARKER)
							throw new CompileTimeException(null, "Method " + method.nameAndDescriptor() + " cannot have null default value");
						method.flags = new AccessFlags(Visibility.PUBLIC, true, false);
					}else if(superInterfaces().stream().flatMap(k -> k.methods().stream()).noneMatch(k -> k.nameAndDescriptor().equals(method.nameAndDescriptor())))
						throw new CompileTimeException(null, "An annotation method may only have a non-return-statement body if that method implements an interface method");
	}
	
	private static <T> void checkDuplicates(List<T> in, String label){
		Set<T> checked = new HashSet<>(in.size());
		for(T t : in){
			if(checked.contains(t))
				throw new CompileTimeException(null, "Duplicate " + label + " \"" + t + "\"");
			checked.add(t);
		}
	}
	
	public String toString(){
		return "Cyclic:" + fullyQualifiedName();
	}
}