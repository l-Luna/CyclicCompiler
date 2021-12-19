package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.instructions.Scope;
import cyclic.lang.compiler.model.instructions.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CyclicConstructor implements CallableReference{
	
	CyclicType in;
	AccessFlags flags;
	List<String> paramNames = new ArrayList<>();
	boolean isS = false;
	
	List<String> paramTypeNames = new ArrayList<>();
	CyclicLangParser.BlockContext blockStatement;
	CyclicLangParser.StatementContext arrowStatement;
	
	List<TypeReference> parameters;
	public Statement body;
	Scope methodScope = new Scope();
	
	// for explicit constructors
	public CyclicConstructor(CyclicLangParser.ConstructorContext ctx, CyclicType in){
		this.in = in;
		flags = Utils.fromModifiers(ctx.modifiers());
		flags = new AccessFlags(flags.visibility(), false, false); // no final or abstract constructors
		
		for(var p : ctx.parameters().varDecl()){
			paramTypeNames.add(p.type().getText());
			paramNames.add(p.id().getText());
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
	}
	
	// for implicit ctors, including static ones for static field setup
	public CyclicConstructor(boolean isStatic, CyclicType in){
		this.in = in;
		flags = new AccessFlags(Visibility.PACKAGE_PRIVATE, false, false);
		body = null;
		isS = isStatic;
	}
	
	public void resolve(){
		List<String> imports = in.imports;
		parameters = paramTypeNames.stream()
				.map(x -> TypeResolver.resolve(x, imports, in.packageName()))
				.collect(Collectors.toList());
	}
	
	public void resolveBody(){
		body =  (blockStatement != null) ? new Statement.BlockStatement(blockStatement.statement().stream().map(ctx -> Statement.fromAst(ctx, methodScope, in, this)).collect(Collectors.toList()), methodScope) :
				(arrowStatement != null) ? Statement.fromAst(arrowStatement, methodScope, in, this) :
						null; // a semicolon just returns - no implicit return in case of init blocks
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
}