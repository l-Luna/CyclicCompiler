package cyclic.lang.compiler.model.external;

import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.objectweb.asm.ClassReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents a reference to a type loaded from a class file.
 * <p>Like Cyclic types, {@linkplain ClassfileTypeRef#resolveRefs()} and {@linkplain ClassfileTypeRef#resolveInheritance()}
 * should be called on all types from a given JAR file, after all other types have been first constructed, then resolved.
 */
public class ClassfileTypeRef implements TypeReference{
	
	protected Utils.PackageAndName name;
	protected TypeKind kind;
	protected AccessFlags flags;
	protected String superClassName;
	protected List<String> interfaceNames;
	
	protected List<ClassfileMember.Field> fields = new ArrayList<>();
	protected List<ClassfileMember.Method> methods = new ArrayList<>();
	protected List<ClassfileMember.Method> constructors = new ArrayList<>();
	protected Set<ClassfileAnnotationPrototype> annotationPtts = new HashSet<>();
	
	private TypeReference superClass;
	private List<TypeReference> interfaces;
	private Set<AnnotationTag> annotations = new HashSet<>();
	
	public ClassfileTypeRef(byte[] classfile){
		ClassReader reader = new ClassReader(classfile);
		reader.accept(new ClassfileVisitor(this), ClassReader.SKIP_CODE);
	}
	
	public String shortName(){
		return name.name();
	}
	
	public String packageName(){
		return name.pkg();
	}
	
	public TypeKind kind(){
		return kind;
	}
	
	public AccessFlags flags(){
		return flags;
	}
	
	public TypeReference outerClass(){
		return null;
	}
	
	public TypeReference superClass(){
		return superClass;
	}
	
	public List<? extends TypeReference> superInterfaces(){
		return interfaces;
	}
	
	public List<? extends TypeReference> innerClasses(){
		return List.of();
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
	
	public Set<AnnotationTag> annotations(){
		return annotations;
	}
	
	//
	
	public void resolveRefs(){
		if(superClassName != null) // interfaces and module-info don't have a superclass
			superClass = TypeResolver.resolveFq(superClassName.replace('/', '.'));
		interfaces = interfaceNames.stream()
				.map(x -> x.replace('/', '.'))
				.map(TypeResolver::resolveFq)
				.toList();
		annotations = annotationPtts.stream()
				.map(x -> x.resolve(this))
				.collect(Collectors.toSet());
		
		fields.forEach(ClassfileMember::resolveRefs);
		methods.forEach(ClassfileMember::resolveRefs);
		constructors.forEach(ClassfileMember::resolveRefs);
	}
	
	public boolean equals(Object o){
		return o instanceof TypeReference t && t.fullyQualifiedName().equals(fullyQualifiedName());
	}
	
	public int hashCode(){
		return fullyQualifiedName().hashCode();
	}
}