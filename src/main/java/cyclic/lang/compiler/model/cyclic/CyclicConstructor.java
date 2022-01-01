package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.instructions.Scope;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CyclicConstructor implements CallableReference, CyclicMember{
	
	CyclicType in;
	AccessFlags flags;
	List<String> paramNames = new ArrayList<>();
	boolean isS = false;
	
	List<CyclicLangParser.TypeContext> paramTypeNames = new ArrayList<>();
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
		
		for(var p : ctx.parameters().parameter()){
			paramTypeNames.add(p.type());
			paramNames.add(p.idPart().getText());
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
		parameters = new ArrayList<>();
	}
	
	// for implicit ctors, including static ones for static field setup
	public CyclicConstructor(boolean isStatic, CyclicType in){
		this.in = in;
		flags = new AccessFlags(Visibility.PACKAGE_PRIVATE, false, false);
		body = null;
		isS = isStatic;
		parameters = new ArrayList<>();
	}
	
	public void resolve(){
		List<String> imports = in.imports;
		parameters = paramTypeNames.stream()
				.map(x -> TypeResolver.resolve(x, imports, in.packageName()))
				.collect(Collectors.toList());
	}
	
	public void resolveBody(){
		if(!isStatic())
			new Variable("this", in(), methodScope, null);
		for(int i = 0; i < parameters.size(); i++)
			new Variable(paramNames.get(i), parameters.get(i), methodScope, null);
		
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