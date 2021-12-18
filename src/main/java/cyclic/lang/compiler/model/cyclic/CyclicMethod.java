package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.instructions.Scope;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CyclicMethod implements MethodReference{
	
	String name;
	CyclicType in;
	AccessFlags flags;
	List<String> paramNames = new ArrayList<>();
	boolean isN = false, isSyn = false, isSt = false;
	
	String retType;
	List<String> paramTypeNames = new ArrayList<>();
	CyclicLangParser.BlockContext blockStatement;
	CyclicLangParser.ValueContext arrowVal;
	CyclicLangParser.StatementContext arrowStatement;
	
	TypeReference returns;
	List<TypeReference> parameters;
	
	public Statement body;
	Scope methodScope = new Scope();
	
	public CyclicMethod(CyclicLangParser.FunctionContext ctx, CyclicType in){
		name = ctx.id().getText();
		this.in = in;
		flags = Utils.fromModifiers(ctx.modifiers(), modifier -> {
			isN |= modifier.equals("native");
			isSyn |= modifier.equals("synchronised");
			isSt |= modifier.equals("static");
		});
		
		retType = ctx.type().getText();
		for(var p : ctx.parameters().varDecl()){
			paramTypeNames.add(p.type().getText());
			paramNames.add(p.id().getText());
		}
		
		if(ctx.functionArrow() != null){
			if(ctx.functionArrow().statement() != null)
				arrowStatement = ctx.functionArrow().statement();
			else
				arrowVal = ctx.functionArrow().value();
		}else
			blockStatement = ctx.functionBlock().block();
	}
	
	public void resolve(){
		List<String> imports = in.imports;
		returns = TypeResolver.resolve(retType, imports, in.packageName());
		parameters = paramTypeNames.stream()
				.map(x -> TypeResolver.resolve(x, imports, in.packageName()))
				.collect(Collectors.toList());
	}
	
	public void resolveBody(){
		body =  (blockStatement != null) ? new Statement.BlockStatement(blockStatement.statement().stream().map(ctx -> Statement.fromAst(ctx, methodScope, in, this)).collect(Collectors.toList()), methodScope) :
				(arrowStatement != null) ? Statement.fromAst(arrowStatement, methodScope, in, this) :
				new Statement.ReturnStatement(Value.fromAst(arrowVal, methodScope, in, this), methodScope, returns);
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
}
