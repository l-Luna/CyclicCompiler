package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.instructions.Scope;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.model.instructions.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CyclicMethod implements MethodReference, CyclicMember{
	
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
	
	public CyclicMethod(CyclicLangParser.FunctionContext ctx, CyclicType in, boolean abstractByDefault){
		name = ctx.idPart().getText();
		this.in = in;
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
		
		if(abstractByDefault && arrowStatement == null && arrowVal == null && blockStatement == null)
			flags = new AccessFlags(flags.visibility(), true, flags.isFinal());
		
		boolean isA = isN || flags.isAbstract();
		if(isA && flags.isFinal())
			throw new CompileTimeException(ctx, "Method \"" + name + "\" cannot be final and abstract or native");
		if(isA && isStatic())
			throw new CompileTimeException(ctx, "Method \"" + name + "\" cannot be static and abstract or native");
		if(isNative() && flags.isAbstract())
			throw new CompileTimeException(ctx, "Method \"" + name + "\" cannot be native and abstract");
		
		retType = ctx.type().getText();
		for(var p : ctx.parameters().parameter()){
			paramTypeNames.add(p.type().getText());
			paramNames.add(p.idPart().getText());
		}
		
		if(isA && (arrowStatement != null || arrowVal != null || blockStatement != null))
			throw new CompileTimeException(ctx, "Abstract or native method \"" + name + "\" cannot have a body");
	}
	
	public void resolve(){
		List<String> imports = in.imports;
		returns = TypeResolver.resolve(retType, imports, in.packageName());
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
	
	public Object defaultValueForAnnotation(){
		return null;
	}
}
