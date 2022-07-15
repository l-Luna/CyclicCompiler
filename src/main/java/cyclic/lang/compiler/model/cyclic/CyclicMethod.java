package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.configuration.dependencies.PlatformDependency;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.instructions.Scope;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.model.instructions.Variable;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.problems.CompileTimeException;
import cyclic.lang.compiler.problems.ProblemsHolder;
import cyclic.lang.compiler.resolve.TypeResolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CyclicMethod implements MethodReference, CyclicCallable{
	
	String name;
	CyclicType in;
	AccessFlags flags;
	List<String> paramNames = new ArrayList<>();
	public boolean isN = false, isSyn = false, isSt = false, isVarargs = false;
	
	CyclicLangParser.TypeContext retType;
	List<CyclicLangParser.TypeContext> paramTypeNames = new ArrayList<>();
	List<List<CyclicLangParser.AnnotationContext>> paramsAnnotationNames = new ArrayList<>();
	CyclicLangParser.BlockContext blockStatement;
	CyclicLangParser.ValueContext arrowVal;
	CyclicLangParser.StatementContext arrowStatement;
	CyclicLangParser.FunctionContext text;
	
	TypeReference returns;
	List<TypeReference> parameters;
	
	private List<CyclicLangParser.AnnotationContext> unresolvedAnnotations;
	private Set<AnnotationTag> annotations = new HashSet<>();
	private List<CyclicLangParser.AnnotationContext> unresolvedTypeAnnotations;
	private Set<AnnotationTag> typeAnnotations = new HashSet<>();
	private List<Set<AnnotationTag>> paramTypeAnnotations = new ArrayList<>();
	
	public Object constantAnnotationComponentValue = null;
	public Statement body;
	public Scope methodScope = new Scope();
	
	public CyclicMethod(CyclicLangParser.FunctionContext ctx, CyclicType in, boolean interfaceMethod, boolean staticByDefault){
		name = ctx.idPart().getText();
		text = ctx;
		this.in = in;
		this.unresolvedAnnotations = ctx.annotation();
		this.unresolvedTypeAnnotations = ctx.type().annotation();
		flags = Utils.fromModifiers(ctx.modifiers(), modifier -> {
			isN |= modifier.equals("native");
			isSyn |= modifier.equals("synchronised");
			isSt |= modifier.equals("static");
		});
		
		if(ctx.functionArrow() != null){
			if(ctx.functionArrow().statement() != null)
				arrowStatement = ctx.functionArrow().statement();
			else
				arrowVal = ctx.functionArrow().value();
		}else
			blockStatement = ctx.functionBlock().block();
		
		if(interfaceMethod && arrowStatement == null && arrowVal == null && blockStatement == null)
			flags = new AccessFlags(Visibility.PUBLIC, true, flags.isFinal());
		
		if(staticByDefault)
			isSt = true;
		
		boolean isA = isN || flags.isAbstract();
		if(isA && flags.isFinal())
			throw new CompileTimeException(ctx, "Method \"" + name + "\" cannot be final and abstract or native");
		if(isA && isStatic())
			throw new CompileTimeException(ctx, "Method \"" + name + "\" cannot be static and abstract or native");
		if(isNative() && flags.isAbstract())
			throw new CompileTimeException(ctx, "Method \"" + name + "\" cannot be native and abstract");
		
		retType = ctx.type();
		for(var p : ctx.parameters().parameter()){
			paramTypeNames.add(p.type());
			paramNames.add(p.idPart().getText());
			paramsAnnotationNames.add(Utils.getAnnotations(p.type()));
			isVarargs = p.ELIPSES() != null; // only the last assignment stays
			var pTypeName = TypeResolver.getBaseName(p.type());
			if(pTypeName.equals("var") || pTypeName.equals("val"))
				throw new CompileTimeException(p, "Parameter types may not be inferred");
		}
		
		Utils.checkDuplicates(parameterNames(), "parameter name in method " + name);
		
		for(int i = 0; i < ctx.parameters().parameter().size() - 1; i++){
			var param = ctx.parameters().parameter(i);
			if(param.ELIPSES() != null)
				throw new CompileTimeException(param, "Var-args parameter must be last");
		}
		
		if(isA && (arrowStatement != null || arrowVal != null || blockStatement != null))
			throw new CompileTimeException(ctx, "Abstract or native method \"" + name + "\" cannot have a body");
		
		var typeName = TypeResolver.getBaseName(ctx.type());
		if(typeName.equals("var") || typeName.equals("val"))
			throw new CompileTimeException("Method types may not be inferred");
	}
	
	public CyclicMethod(CyclicType in, String name, AccessFlags flags, TypeReference returns, List<TypeReference> parameters){
		this.name = name;
		this.in = in;
		this.flags = flags;
		this.returns = returns;
		this.parameters = parameters;
		paramNames = new ArrayList<>(parameters.size());
		for(int i = 0; i < parameters.size(); i++)
			paramNames.add("var" + i);
	}
	
	public void resolve(){
		List<String> imports = in.imports;
		returns = TypeResolver.resolve(retType, imports, in.packageName());
		parameters = paramTypeNames.stream()
				.map(x -> TypeResolver.resolve(x, imports, in.packageName()))
				.collect(Collectors.toList());
		
		if(!Visibility.visibleFrom(returns, this))
			throw new CompileTimeException(retType, "Field type not visible here");
		for(int i = 0; i < parameters.size(); i++){
			TypeReference param = parameters.get(i);
			if(!Visibility.visibleFrom(param, this))
				throw new CompileTimeException(paramTypeNames.get(i), "Method parameter type not visible here");
		}
		
		if(isVarargs())
			parameters.set(parameters.size() - 1, new ArrayTypeRef(parameters.get(parameters.size() - 1)));
		
		for(CyclicLangParser.AnnotationContext annotation : unresolvedAnnotations)
			annotations.add(AnnotationTag.fromAst(annotation, this, in));
		for(CyclicLangParser.AnnotationContext annotation : unresolvedTypeAnnotations)
			typeAnnotations.add(AnnotationTag.fromAst(annotation, this, in));
		for(List<CyclicLangParser.AnnotationContext> paramAnnotations : paramsAnnotationNames)
			paramTypeAnnotations.add(paramAnnotations.stream().map(x -> AnnotationTag.fromAst(x, this, in)).collect(Collectors.toSet()));
		
		ProblemsHolder.checkImpossibleMustUse(this);
	}
	
	public void resolveBody(){
		if(!isStatic()){
			Variable self = new Variable("this", in(), methodScope, null);
			self.fakeAssigned = true;
		}
		for(int i = 0; i < parameters.size(); i++){
			Variable param = new Variable(paramNames.get(i), parameters.get(i), methodScope, null);
			param.fakeAssigned = true;
		}
		
		if(body == null){
			if(blockStatement != null){
				body = new Statement.BlockStatement(blockStatement.statement().stream().map(ctx -> Statement.fromAst(ctx, methodScope, in, this)).collect(Collectors.toList()), methodScope, this);
				body.text = blockStatement;
			}else{
				if(arrowStatement != null)
					body = Statement.fromAst(arrowStatement, methodScope, in, this);
				else{
					body = new Statement.ReturnStatement(Value.fromAst(arrowVal, methodScope, in, this), methodScope, returns, this);
					body.text = arrowVal;
				}
			}
		}
		
		body.from = this;
		
		if(!flags().isAbstract() && !returns().isAssignableTo(PlatformDependency.VOID))
			if(!Flow.guaranteedToExit(body))
				throw new CompileTimeException(null, "Missing return or throw statement - non-void method \"" + summary() + "\" must return a value in all code paths");
	}
	
	public TypeReference in(){
		return in;
	}
	
	public String name(){
		return name;
	}
	
	public TypeReference returns(){
		return returns;
	}
	
	public List<TypeReference> parameters(){
		return parameters;
	}
	
	public List<String> parameterNames(){
		return paramNames;
	}
	
	public AccessFlags flags(){
		return flags;
	}
	
	public boolean isNative(){
		return isN;
	}
	
	public boolean isSynchronized(){
		return isSyn;
	}
	
	public boolean isStatic(){
		return isSt;
	}
	
	public boolean isVarargs(){
		return isVarargs;
	}
	
	public Object defaultValueForAnnotation(){
		return constantAnnotationComponentValue;
	}
	
	public Set<AnnotationTag> annotations(){
		return annotations;
	}
	
	public Set<AnnotationTag> returnTypeAnnotations(){
		return typeAnnotations;
	}
	
	public List<Set<AnnotationTag>> parameterAnnotations(){
		return paramTypeAnnotations;
	}
	
	public Statement getBody(){
		return body;
	}
	
	public String toString(){
		return "Cyclic: " + summary();
	}
	
	private Set<String> suppresses = null;
	public Set<String> suppressedWarnings(){
		if(suppresses != null)
			return suppresses;
		return suppresses = findSuppressedWarnings();
	}
}