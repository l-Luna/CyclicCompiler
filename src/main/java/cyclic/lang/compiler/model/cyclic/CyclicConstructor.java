package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.instructions.Scope;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Variable;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.resolve.PlatformDependency;
import cyclic.lang.compiler.resolve.TypeResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CyclicConstructor implements CyclicCallable{
	
	CyclicType in;
	AccessFlags flags;
	List<String> paramNames = new ArrayList<>();
	boolean isS = false, isVargs = false;
	
	List<CyclicLangParser.TypeContext> paramTypeNames = new ArrayList<>();
	CyclicLangParser.ConstructorContext text;
	CyclicLangParser.BlockContext blockStatement;
	CyclicLangParser.StatementContext arrowStatement;
	
	List<TypeReference> parameters = new ArrayList<>();
	public Statement body = null;
	public Scope scope = new Scope();
	
	public boolean isGeneratedRecordCtor = false;
	public boolean isCanonRecordCtor = false;
	public boolean isInitBlock = false;
	
	// for explicit constructors
	public CyclicConstructor(CyclicLangParser.ConstructorContext ctx, CyclicType in){
		this.in = in;
		text = ctx;
		flags = Utils.fromModifiers(ctx.modifiers());
		flags = new AccessFlags(flags.visibility(), false, false); // no final or abstract constructors
		if(!ctx.idPart().getText().equals(in.shortName()))
			throw new CompileTimeException(ctx.idPart(), "Return type required for method");
		
		for(var p : ctx.parameters().parameter()){
			paramTypeNames.add(p.type());
			paramNames.add(p.idPart().getText());
			isVargs = p.ELIPSES() != null; // only the last assignment stays
		}
		
		Utils.checkDuplicates(parameterNames(), "parameter name in constructor");
		
		for(int i = 0; i < ctx.parameters().parameter().size() - 1; i++){
			var param = ctx.parameters().parameter(i);
			if(param.ELIPSES() != null)
				throw new CompileTimeException(param, "Var-args parameter must be last");
		}
		
		if(ctx.statement() != null)
			arrowStatement = ctx.statement();
		else if(ctx.block() != null)
			blockStatement = ctx.block();
	}
	
	// for init blocks, including explicit static ctors
	public CyclicConstructor(CyclicLangParser.InitContext ctx, CyclicType in){
		this.in = in;
		flags = new AccessFlags(Visibility.PACKAGE_PRIVATE, false, false);
		blockStatement = ctx.block();
		isS = ctx.STATIC() != null;
		isInitBlock = true;
	}
	
	// for implicit ctors, including static ones for static field setup
	public CyclicConstructor(boolean isStatic, CyclicType in){
		this.in = in;
		flags = new AccessFlags(Visibility.PACKAGE_PRIVATE, false, false);
		body = null;
		isS = isStatic;
	}
	
	// for record canonical ctor
	public CyclicConstructor(CyclicType in, List<TypeReference> parameters, List<String> paramNames){
		this.in = in;
		this.parameters = parameters;
		this.paramNames = paramNames;
		flags = new AccessFlags(Visibility.PUBLIC, false, false);
		isGeneratedRecordCtor = true;
	}
	
	public void resolve(){
		if(!isStatic() && in().kind() == TypeKind.ENUM){
			parameters.add(0, Utils.forAnyClass(String.class));
			paramNames.add(0, "~enumName");
			parameters.add(1, PlatformDependency.INT);
			paramNames.add(1, "~enumOrdinal");
		}
		
		parameters.addAll(paramTypeNames.stream()
				.map(x -> TypeResolver.resolve(x, in.imports, in.packageName()))
				.toList());
		
		if(isVarargs())
			parameters.set(parameters.size() - 1, new ArrayTypeRef(parameters.get(parameters.size() - 1)));
	}
	
	public TypeReference in(){
		return in;
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
	
	public boolean isStatic(){
		return isS; // only ever true for init blocks
	}
	
	public boolean isVarargs(){
		return isVargs;
	}
	
	public void resolveBody(){
		if(body == null){
			addParamVars();
			body = (blockStatement != null) ? new Statement.BlockStatement(blockStatement.statement().stream().map(ctx -> Statement.fromAst(ctx, scope, in, this)).collect(Collectors.toList()), scope, this) :
				   (arrowStatement != null) ? Statement.fromAst(arrowStatement, scope, in, this) :
				    null; // a semicolon just returns - no implicit return in case of init blocks
			
			if(body != null)
				body.from = this;
		}
		
		if(in().kind() == TypeKind.RECORD){
			String canon = in.recordComponents().stream()
					.map(RecordComponentReference::type)
					.map(TypeReference::descriptor)
					.collect(Collectors.joining("", "(", ")")) + "V";
			if(descriptor().equals(canon))
				isCanonRecordCtor = true;
		}
		
		Optional<Statement> cCallOpt = explicitCtorCall();
		if(cCallOpt.isPresent()){
			var cCallText = cCallOpt.get().text;
			if(isStatic())
				throw new CompileTimeException(cCallText, "Constructor call not allowed in static block");
			
			// check that the body is either of those statements, or starts with either, and contains no other references to either
			// TODO: relax restrictions on pre-super-constructor instructions?
			Statement.CtorCallStatement ctorCall = (Statement.CtorCallStatement)cCallOpt.get();
			// simplify should be idempotent, make sure it's a valid call
			ctorCall.simplify();
			if(!(body instanceof Statement.CtorCallStatement))
				if(!(body instanceof Statement.BlockStatement block && block.contains.get(0) instanceof Statement.CtorCallStatement))
					throw new CompileTimeException(cCallText, "Must have an explicit constructor call first");
			if(in.kind() == TypeKind.RECORD){
				if(isCanonRecordCtor)
					throw new CompileTimeException(cCallText, "Canonical record constructors must not have an explicit constructor call");
				else if(!ctorCall.target.in().fullyQualifiedName().equals(in.fullyQualifiedName()))
					// no super()s in records
					throw new CompileTimeException(cCallText, "Record constructors cannot call a super-constructor");
			}
			if(in.kind() == TypeKind.ENUM){
				if(!ctorCall.target.in().fullyQualifiedName().equals(in.fullyQualifiedName()))
					// no super()s in enums
					throw new CompileTimeException(cCallText, "Enum constructors cannot call a super-constructor");
			}
		}else{
			if(!isCanonRecordCtor
					&& in.kind() != TypeKind.ENUM
					&& in.superClass().constructors().stream().noneMatch(x -> x.parameters().size() == 0)){
				System.out.println(in.superClass().constructors());
				in.superClass().constructors().forEach(x -> System.out.println(x.parameters().size()));
				throw new CompileTimeException(null, "Missing explicit constructor call (superclass has no 0-arg constructors)");
			}
			if(in.kind() == TypeKind.RECORD && !(isGeneratedRecordCtor || isCanonRecordCtor || isInitBlock))
				throw new CompileTimeException(null, "Non-canonical constructor call must defer to canonical constructor");
		}
	}
	
	public void addParamVars(){
		if(!isStatic())
			new Variable("this", in(), scope, null);
		for(int i = 0; i < parameters.size(); i++)
			new Variable(paramNames.get(i), parameters.get(i), scope, null);
	}
	
	public Optional<Statement> explicitCtorCall(){
		return Flow.firstMatching(body, Statement.CtorCallStatement.class::isInstance);
	}
	
	public Statement getBody(){
		return body;
	}
}