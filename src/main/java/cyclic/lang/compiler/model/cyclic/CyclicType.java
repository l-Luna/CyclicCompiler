package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.gen.EnumMembers;
import cyclic.lang.compiler.gen.RecordMethods;
import cyclic.lang.compiler.gen.SingleMembers;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.model.jdk.JdkTypeRef;
import cyclic.lang.compiler.problems.CompileTimeException;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

import static cyclic.lang.compiler.Constants.*;

public class CyclicType implements TypeReference, CyclicMember{
	
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
	
	private CyclicLangParser.TypeContext superTypeName;
	private List<CyclicLangParser.TypeContext> interfaceNames;
	private TypeReference superType;
	private List<TypeReference> interfaces;
	
	private List<CyclicLangParser.AnnotationContext> unresolvedAnnotations;
	private Set<AnnotationTag> annotations = new HashSet<>();
	
	private List<CyclicLangParser.ParameterContext> unresolvedRecordComponents;
	private List<CyclicRecordComponent> recordComponents = new ArrayList<>();
	
	private CyclicLangParser.ClassDeclContext text;
	
	public CyclicType outer;
	public List<CyclicType> inners = new ArrayList<>();
	public List<String> imports;
	
	public int enumConstIdx = 0;
	private boolean isStaticSingle = false;
	
	public CyclicType(CyclicLangParser.ClassDeclContext ast, String packageName, List<String> imports){
		this.name = ast.idPart().getText();
		this.packageName = packageName;
		this.imports = imports;
		this.unresolvedAnnotations = ast.annotation();
		this.unresolvedRecordComponents = ast.recordComponents() != null ? ast.recordComponents().parameter() : new ArrayList<>();
		text = ast;
		
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
			superTypeName = null;
			interfaceNames = ast.objectExtends() != null ? ast.objectExtends().type() : Collections.emptyList();
			if(ast.objectImplements() != null && ast.objectImplements().type().size() > 0)
				throw new CompileTimeException(text.objectImplements(), "Interfaces cannot implement interfaces, but this declares " + ast.objectImplements().type().size() + " super-interface(s)", "Help: Use extends instead");
		}else{
			if(ast.objectExtends() != null && ast.objectExtends().type().size() > 1)
				throw new CompileTimeException(text.objectExtends(), "Non-interfaces cannot have multiple supertypes, but this declares " + ast.objectExtends().type().size() + " supertypes");
			superTypeName = ast.objectExtends() != null ? ast.objectExtends().type(0) : null;
			interfaceNames = ast.objectImplements() != null ? ast.objectImplements().type() : Collections.emptyList();
		}
		
		flags = Utils.fromModifiers(ast.modifiers(), mod -> {
			if(kind() == TypeKind.SINGLE && mod.equals("static"))
				isStaticSingle = true;
		});
		
		// static single types are always final
		if(isStaticSingle)
			flags = new AccessFlags(flags.visibility(), flags.isAbstract(), true);
		
		if(flags.isAbstract() && flags.isFinal())
			throw new CompileTimeException(text.modifiers(), "Type cannot be abstract and final");
		
		boolean isInterface = kind() == TypeKind.INTERFACE;
		for(var member : ast.member()){
			if(member.function() != null)
				methods.add(new CyclicMethod(member.function(), this, isInterface, isStaticSingle));
			else if(member.constructor() != null)
				constructors.add(new CyclicConstructor(member.constructor(), this));
			else if(member.init() != null)
				initBlocks.add(new CyclicConstructor(member.init(), this));
			else if(member.varDecl() != null)
				fields.add(new CyclicField(member.varDecl(), this, isInterface, isStaticSingle));
		}
		
		members.addAll(fields);
		members.addAll(constructors);
		members.addAll(initBlocks);
		members.addAll(methods);
		
		methodsAndInherited.addAll(methods);
		fieldsAndInherited.addAll(fields);
		
		// implicit constructor if none is present, ensures that init blocks are written
		if(constructors.size() == 0 && kind() != TypeKind.INTERFACE && kind() != TypeKind.ANNOTATION && kind() != TypeKind.RECORD)
			addMember(new CyclicConstructor(false, this));
		
		// ensure static field inits are written
		if(initBlocks.stream().noneMatch(k -> k.isS)){
			CyclicConstructor st = new CyclicConstructor(true, this);
			st.isInitBlock = true;
			initBlocks.add(st);
			members.add(st);
		}
		
		if(kind() == TypeKind.ENUM)
			for(var constructor : constructors){
				if(constructor.flags.visibility() == Visibility.PUBLIC || constructor.flags.visibility() == Visibility.PROTECTED)
					throw new CompileTimeException(constructor.text, "Enum constructors must be declared private or package-private");
				constructor.flags = new AccessFlags(Visibility.PRIVATE, false, false);
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
		return methodsAndInherited;
	}
	
	public List<? extends FieldReference> fields(){
		return fieldsAndInherited;
	}
	
	public List<? extends ConstructorReference> constructors(){
		return constructors;
	}
	
	public List<? extends RecordComponentReference> recordComponents(){
		return recordComponents;
	}
	
	public TypeReference outerClass(){
		return outer;
	}
	
	@NotNull("Source classes always have superclasses")
	public TypeReference superClass(){
		return superType;
	}
	
	public List<? extends TypeReference> superInterfaces(){
		return interfaces;
	}
	
	public List<? extends TypeReference> innerClasses(){
		return inners;
	}
	
	public List<? extends MethodReference> declaredMethods(){
		return methods;
	}
	
	public Set<AnnotationTag> annotations(){
		return annotations;
	}
	
	public void resolveRefs(){
		CompileTimeException.setFile(fullyQualifiedName());
		
		superType = superTypeName != null
				? TypeResolver.resolve(superTypeName, imports, packageName())
				: TypeResolver.resolveFq(OBJECT);
		interfaces = interfaceNames.stream().map(x -> TypeResolver.resolve(x, imports, packageName())).collect(Collectors.toList());
		
		if(!Visibility.visibleFrom(superType, this))
			throw new CompileTimeException(text.objectExtends().type().get(0), "Type " + superType.fullyQualifiedName() + " is not visible here and cannot be extended");
		
		var inaccessible = interfaces.stream()
				.filter(x -> !Visibility.visibleFrom(x, this))
				.map(TypeReference::fullyQualifiedName)
				.collect(Collectors.joining(", ", "[", "]"));
		if(!inaccessible.equals("[]"))
			throw new CompileTimeException(null, "Types " + inaccessible + " are not visible here and cannot be implemented");
		
		if(kind == TypeKind.INTERFACE){
			if(flags.isFinal())
				throw new CompileTimeException(text.modifiers(), "Interfaces must not be final");
			flags = new AccessFlags(flags.visibility(), true, false);
			
		}else if(kind == TypeKind.ENUM){
			if(flags.isAbstract())
				throw new CompileTimeException(text.modifiers(), "Enums must not be abstract");
			if(!superType.fullyQualifiedName().equals(OBJECT) && !superType.fullyQualifiedName().equals(ENUM))
				throw new CompileTimeException(text.objectExtends(), "Enums can only declare java.lang.Object or java.lang.Enum as super type");
			flags = new AccessFlags(flags.visibility(), false, true);
			superType = TypeResolver.resolveFq(ENUM);
			
		}else if(kind == TypeKind.RECORD){
			if(flags.isAbstract())
				throw new CompileTimeException(text.modifiers(), "Records must not be abstract");
			if(!superType.fullyQualifiedName().equals(OBJECT) && !superType.fullyQualifiedName().equals(RECORD))
				throw new CompileTimeException(text.objectExtends(), "Records can only declare java.lang.Object or java.lang.Record as super type");
			flags = new AccessFlags(flags.visibility(), false, true);
			superType = TypeResolver.resolveFq(RECORD);
			
		}else if(kind == TypeKind.SINGLE)
			if(flags.isAbstract())
				throw new CompileTimeException(text.modifiers(), "Single types must not be abstract");
		
		members.forEach(CyclicMember::resolve);
		
		generateMembersForKind();
		
		for(CyclicLangParser.AnnotationContext annotation : unresolvedAnnotations)
			annotations.add(AnnotationTag.fromAst(annotation, this, this));
		
		validate();
	}
	
	private void generateMembersForKind(){
		if(kind() == TypeKind.RECORD){
			Optional<CyclicField> first = fields.stream().filter(x -> !x.isStatic()).findFirst();
			if(first.isPresent())
				throw new CompileTimeException(first.get().text.idPart(), "Record types may not have non-static members");
			
			for(CyclicLangParser.ParameterContext component : unresolvedRecordComponents){
				TypeReference type = TypeResolver.resolve(component.type(), imports, packageName());
				String name = component.idPart().getText();
				
				CyclicField field = new CyclicField(this, name, new AccessFlags(Visibility.PRIVATE, false, true), type);
				members.add(field);
				fields.add(field);
				fieldsAndInherited.add(field);
				
				// check if there's already an override-equivalent method
				CyclicMethod accessor = new CyclicMethod(this, name, new AccessFlags(Visibility.PUBLIC, false, true), type, List.of());
				var explicitAccessor = methods.stream().filter(accessor::overrides).findFirst();
				if(explicitAccessor.isPresent())
					accessor = explicitAccessor.get();
				else{
					Optional<CyclicMethod> fake = methods.stream().filter(x -> x.name.equals(name) && x.parameters.size() == 0).findFirst();
					if(fake.isPresent())
						throw new CompileTimeException(fake.get().text, "Record accessor must have type " + type.fullyQualifiedName());
					accessor.body = new Statement.ReturnStatement(new Value.FieldValue(field), accessor.methodScope, type, accessor);
					members.add(accessor);
					methods.add(accessor);
					methodsAndInherited.add(accessor);
				}
				
				recordComponents.add(new CyclicRecordComponent(this, name, type, field, accessor));
			}
			
			addMember(RecordMethods.genEquals(this));
			addMember(RecordMethods.genToString(this));
			addMember(RecordMethods.genHashCode(this));
			addMember(RecordMethods.genCtor(this));
		}else if(kind() == TypeKind.ENUM){
			addMember(EnumMembers.genValuesField(this));
			addMember(EnumMembers.genValues(this));
			addMember(EnumMembers.genValueOf(this));
			addMember(EnumMembers.genEntriesField(this));
			addMember(EnumMembers.genEntries(this));
		}else if(kind() == TypeKind.SINGLE){
			addMember(SingleMembers.genInstanceField(this));
		}
	}
	
	private void addMember(CyclicMember m){
		members.add(m);
		if(m instanceof CyclicMethod method){
			methods.add(method);
			methodsAndInherited.add(method);
		}
		if(m instanceof CyclicField field){
			fields.add(field);
			fieldsAndInherited.add(field);
		}
		if(m instanceof CyclicConstructor ctor)
			constructors.add(ctor);
	}
	
	private void validate(){
		if(superType.kind() == TypeKind.INTERFACE)
			throw new CompileTimeException(text.objectExtends(), "Classes cannot extend the interface type " + superType.fullyQualifiedName(), "Help: Use implements instead");
		if(superType.flags().isFinal())
			throw new CompileTimeException(text.objectExtends(), "Cannot extend the final type " + superType.fullyQualifiedName());
		
		for(TypeReference i : superInterfaces())
			if(i.kind() != TypeKind.INTERFACE)
				if(kind() == TypeKind.INTERFACE)
					throw new CompileTimeException(text.objectExtends(), "Interfaces cannot extend non-interface type " + i.fullyQualifiedName());
				else
					throw new CompileTimeException(text.objectImplements(), "Cannot implement non-interface type " + i.fullyQualifiedName(), "Help: Use extends instead");
		
		// don't include generated record ctors, since those are prepended to the explicit method if present
		Utils.checkDuplicates(constructors.stream().filter(x -> !x.isGeneratedRecordCtor).toList(), "constructor", CallableReference::descriptor, CallableReference::summary, nameToken());
		Utils.checkDuplicates(interfaces.stream().map(TypeReference::internalName).toList(), "implemented interface", nameToken());
		Utils.checkDuplicates(fields.stream().map(CyclicField::name).toList(), "field name", nameToken());
		Utils.checkDuplicates(methods, "method", MethodReference::nameAndDescriptor, MethodReference::summary, nameToken());
		
		for(CyclicMethod method : methods)
			if(method.flags().isAbstract() && !flags().isAbstract())
				throw new CompileTimeException(null, "Non-abstract type cannot have abstract method " + method.nameAndDescriptor());
		
		if(kind() == TypeKind.INTERFACE){
			if(constructors.size() > 0)
				throw new CompileTimeException(constructors.get(0).nameToken(), "Interfaces should have no constructors, but found " + constructors.size());
			if(fields.stream().anyMatch(x -> !x.isStatic()))
				throw new CompileTimeException(null, "Interfaces should have no instance fields, but found " + fields.stream().filter(x -> !x.isStatic()).count());
		}
		
		if(kind() != TypeKind.RECORD && unresolvedRecordComponents.size() > 0)
			throw new CompileTimeException(text.recordComponents(), "Non-records should have no record components");
		
		if(kind() == TypeKind.SINGLE)
			if(constructors.stream().noneMatch(x -> x.parameters().size() == 0))
				throw new CompileTimeException(nameToken(), "Single-types must have a no-arg constructor");
	}
	
	public void resolveInheritance(){
		CompileTimeException.setFile(fullyQualifiedName());
		
		// we do annotation inheritance checking here to make sure that the annotations of interfaces we implement have been resolved
		if(kind == TypeKind.ANNOTATION){
			if(flags.isFinal())
				throw new CompileTimeException(null, "Annotations must not be marked as final");
			if(!superType.fullyQualifiedName().equals(OBJECT))
				throw new CompileTimeException(null, "Annotations can only declare java.lang.Object as super type");
			
			boolean markedAnnotation = false;
			for(TypeReference i : interfaces)
				if(!i.fullyQualifiedName().equals(ANNOTATION) && i.annotations().stream().noneMatch(k -> k.annotationType().fullyQualifiedName().equals(CYCLIC_ANNOTATION_CAN_IMPLEMENT)))
					throw new CompileTimeException(null, "Annotations can only declare Annotation or an annotation-implementable interface as implemented interface");
				else
					markedAnnotation = true;
			
			flags = new AccessFlags(flags.visibility(), true, false);
			superType = TypeResolver.resolveFq(OBJECT);
			if(!markedAnnotation)
				interfaces.add(TypeResolver.resolveFq(ANNOTATION));
		}
		
		// inherit methods that aren't hidden
		// FIXME: CAN'T DO THIS, inheritedMethods() -> methods() -> methodsAndInherited -> inheritedMethods() ...
		for(MethodReference method : inheritedMethodsOf(this, false))
			if(method.flags().visibility() != Visibility.PRIVATE){
				CyclicMethod overrides = null;
				for(CyclicMethod x : methods)
					if(x.overrides(method)){
						overrides = x;
						break;
					}else if(x.name().equals(method.name()) && x.parameters().equals(method.parameters()))
						throw new CompileTimeException(x.text.type(),
								"Method \"" + x.summary() + "\" clashes with inherited method \"" + method.summary() + "\"",
								"Note: Methods clash because they are override-compatible except for return type",
								"Help: Change return type to match if an override was intended, or change the method's name or parameters");
				if(overrides == null){
					if(method.flags().isAbstract() && !flags.isAbstract())
						throw new CompileTimeException(nameToken(), "Abstract supertype method " + method.summary() + " must be overridden in concrete subclass");
					methodsAndInherited.add(method);
				}else{
					if(method.flags().isFinal())
						throw new CompileTimeException(overrides.nameToken(), "Method " + method.summary() + " cannot be overridden");
					if(overrides.flags().visibility().ordinal() < method.flags().visibility().ordinal())
						throw new CompileTimeException(overrides.nameToken(), "Method " + method.summary() + " cannot have its visibility narrowed");
				}
			}
		
		// get rid of duplicates of the same method from the same class (inherited from multiple interfaces inheriting from the same type)
		methodsAndInherited = Utils.distinctListByEq(methodsAndInherited, x -> x.nameAndDescriptor() + x.in().fullyQualifiedName());
		
		// if we didn't error earlier, its due to inheritance
		Utils.checkDuplicates(methodsAndInherited, "inherited method", method -> method.name() + method.parameterDescriptor(), MethodReference::summary, nameToken());
		
		for(FieldReference field : superType.fields())
			if(field.flags().visibility() != Visibility.PRIVATE){
				if(fields.stream().noneMatch(x -> x.name().equals(field.name())))
					fieldsAndInherited.add(field);
				else
					throw new CompileTimeException(null, "Field " + field.name() + " is defined in supertype and cannot be duplicated");
			}
	}
	
	public void resolveBodies(){
		CompileTimeException.setFile(fullyQualifiedName());
		
		members.forEach(CyclicMember::resolveBody);
		
		// check assignment to final fields
		for(CyclicField field : fields)
			if(field.flags().isFinal() && field.defaultVal == null && field.defaultValText == null && !field.isEnumDefinition()){
				boolean foundDefinite = false;
				if(field.isStatic()){
					// a static final must have a guaranteed assignment in exactly one static block,
					// and no possible ones in any
					for(CyclicConstructor block : initBlocks)
						if(block.isStatic())
							if(Flow.guaranteedToRun(block.getBody(), Flow.willAssignOrThrow(field))){
								if(foundDefinite)
									throw new CompileTimeException(null, "Static final field " + field.name() + " can only be assigned in one static block");
								foundDefinite = true;
							}else if(Flow.firstMatching(block.getBody(), Flow.willAssignToField(field)).isPresent())
								throw new CompileTimeException(null, "Static final field " + field.name() + " must either be definitely assigned or definitely unassigned after static block");
					if(!foundDefinite)
						throw new CompileTimeException(null, "Static final field " + field.name() + " must have a default value, or assignment in static block");
				}else{
					// an instance final must be assigned in one init block (following static final rules)
					// OR be definitely assigned in every constructor that does not call this()
					for(CyclicConstructor block : initBlocks)
						if(!block.isStatic())
							if(Flow.guaranteedToRun(block.getBody(), Flow.willAssignOrThrow(field))){
								if(foundDefinite)
									throw new CompileTimeException(null, "Final field " + field.name() + " can only be assigned in one init block");
								foundDefinite = true;
							}else if(Flow.firstMatching(block.getBody(), Flow.willAssignToField(field)).isPresent())
								throw new CompileTimeException(null, "Final field " + field.name() + " must either be definitely assigned or definitely unassigned after an init block");
					
					for(CyclicConstructor constructor : constructors)
						if(!constructor.isStatic())
							if(Flow.guaranteedToRun(constructor.getBody(), Flow.willAssignToField(field))){
								if(foundDefinite)
									throw new CompileTimeException(null, "Final field " + field.name() + " has already been assigned in init block and cannot be assigned in constructor");
								else{
									constructor.explicitCtorCall().ifPresent(call -> {
										if(call instanceof Statement.CtorCallStatement ccs && ccs.target.in().equals(this))
											throw new CompileTimeException(null, "Final field " + field.name() + " cannot be assigned in constructor that already defers to a constructor that assigns it");
									});
								}
							}else if(Flow.firstMatching(constructor.getBody(), Flow.willAssignToField(field)).isPresent()){
								throw new CompileTimeException(null, "Final field " + field.name() + " must either be definitely assigned or definitely unassigned after a constructor");
							}else if(!foundDefinite){
								Optional<Statement> cc = constructor.explicitCtorCall();
								if(cc.isEmpty() || (cc.get() instanceof Statement.CtorCallStatement ccs && !ccs.target.in().equals(this)))
									throw new CompileTimeException(null, "Constructors must assign to final field " + field.name() + ", or defer to other constructor");
							}
					
					if(!foundDefinite && constructors.size() == 0)
						throw new CompileTimeException(null, "Final field " + field.name() + " must be given a default value or assigned in a constructor or init block");
				}
			}
		
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
							method.constantAnnotationComponentValue = Flow.constantValue(ret.returnValue).orElseThrow(() -> new CompileTimeException(null, "Annotation component methods must have a constant return value"));
						if(method.constantAnnotationComponentValue == Flow.NULL_MARKER)
							throw new CompileTimeException(null, "Method " + method.nameAndDescriptor() + " cannot have null default value");
						method.flags = new AccessFlags(Visibility.PUBLIC, true, false);
					}else if(superInterfaces().stream().flatMap(k -> k.methods().stream()).noneMatch(k -> k.nameAndDescriptor().equals(method.nameAndDescriptor())))
						throw new CompileTimeException(null, "An annotation method may only have a non-return-statement body if that method implements an interface method");
		
		// check @Override annotations
		for(CyclicMethod method : methods)
			if(method.annotations().stream().anyMatch(k -> k.annotationType().fullyQualifiedName().equals(OVERRIDE)))
				if(inheritedMethodsOf(this, false).stream().noneMatch(method::overrides))
					throw new CompileTimeException(null, "Method \"" + method.summary() + "\" has @Override annotation but does not override any members");
	}
	
	public String toString(){
		return "Cyclic:" + fullyQualifiedName();
	}
	
	public boolean equals(Object o){
		return o instanceof TypeReference t && t.fullyQualifiedName().equals(fullyQualifiedName());
	}
	
	public int hashCode(){
		return fullyQualifiedName().hashCode();
	}
	
	private static List<? extends MethodReference> inheritedMethodsOf(TypeReference tr, boolean includeDeclared){
		if(tr instanceof JdkTypeRef)
			return tr.methods(); // already resolved
		
		List<MethodReference> interfaceMethods = tr.superInterfaces().stream()
				.flatMap(x -> inheritedMethodsOf(x, true).stream())
				.filter(k -> k.flags().visibility() != Visibility.PRIVATE)
				.collect(Collectors.toCollection(ArrayList::new));
		// superclass methods "override" interface methods
		if(tr.superClass() != null)
			for(MethodReference method : inheritedMethodsOf(tr.superClass(), true)){
				interfaceMethods.removeIf(method::overrides);
				interfaceMethods.add(method);
			}
		// declared methods override all others
		if(includeDeclared)
			for(MethodReference method : tr.declaredMethods()){
				// invalid CyclicType overrides get picked up when validating that class
				interfaceMethods.removeIf(method::overrides);
				interfaceMethods.add(method);
			}
		return interfaceMethods;
	}
	
	public @Nullable ParserRuleContext nameToken(){
		return text != null ? text.idPart() : null;
	}
	
	private Set<String> suppresses = null;
	public Set<String> suppressedWarnings(){
		if(suppresses != null)
			return suppresses;
		return suppresses = findSuppressedWarnings();
	}
}