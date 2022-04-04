package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.resolve.TypeResolver;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CyclicField implements FieldReference, CyclicMember{
	
	CyclicType in;
	String name;
	AccessFlags flags;
	boolean isS, isV;
	
	CyclicLangParser.TypeOrInferredContext typeName;
	CyclicLangParser.ValueContext defaultValText;
	CyclicLangParser.VarDeclContext text;
	CyclicLangParser.ArgumentsContext enumConstantArgs;
	
	TypeReference type;
	
	boolean isEnumConstant = false;
	
	public Value defaultVal;
	
	// used by record components
	public CyclicField(CyclicType in, String name, AccessFlags flags, TypeReference type){
		this(in, name, flags, false, false, type);
	}
	
	// used by any generated field
	public CyclicField(CyclicType in, String name, AccessFlags flags, boolean isS, boolean isV, TypeReference type){
		this.in = in;
		this.name = name;
		this.flags = flags;
		this.isS = isS;
		this.isV = isV;
		this.type = type;
	}
	
	public CyclicField(CyclicLangParser.VarDeclContext ctx, CyclicType in, boolean isPsfRequired, boolean staticByDefault){
		name = ctx.idPart().getText();
		this.in = in;
		text = ctx;
		flags = Utils.fromModifiers(ctx.modifiers(), modifier -> {
			isS |= modifier.equals("static");
			isV |= modifier.equals("volatile");
		});
		
		if(isPsfRequired){
			isS = true;
			flags = new AccessFlags(Visibility.PUBLIC, false, true);
		}
		if(staticByDefault)
			isS = true;
		
		typeName = ctx.typeOrInferred();
		defaultValText = ctx.value();
		enumConstantArgs = ctx.arguments();
	}
	
	public void resolve(){
		var typeText = TypeResolver.getBaseName(typeName).strip();
		if(typeText.equals("val") && in().kind() == TypeKind.ENUM){
			type = in();
			isEnumConstant = true;
			isS = true;
			if(flags().visibility() != Visibility.PUBLIC && flags().visibility() != Visibility.PACKAGE_PRIVATE)
				throw new CompileTimeException(text, "Enum constants must be public or have no modifier");
			flags = new AccessFlags(Visibility.PUBLIC, false, true);
		}else if(typeText.equals("var") || typeText.equals("val"))
			throw new CompileTimeException(typeName, "Field types may not be inferred");
		else if(typeText.equals("void"))
			throw new CompileTimeException(typeName, "Fields may not be void");
		else
			type = TypeResolver.resolve(typeName.type(), in.imports, in.packageName());
		
		if(!Visibility.visibleFrom(type, this))
			throw new CompileTimeException(typeName, "Field type not visible here");
		
		if(in.kind() != TypeKind.ENUM && enumConstantArgs != null)
			throw new CompileTimeException(enumConstantArgs, "Enum constant arguments not allowed here");
		if(enumConstantArgs != null && defaultValText != null)
			throw new CompileTimeException(text, "Cannot have constant arguments and a field initializer");
	}
	
	public TypeReference in(){
		return in;
	}
	
	public String name(){
		return name;
	}
	
	public TypeReference type(){
		return type;
	}
	
	public AccessFlags flags(){
		return flags;
	}
	
	public boolean isStatic(){
		return isS;
	}
	
	public boolean isVolatile(){
		return isV;
	}
	
	public boolean isEnumDefinition(){
		return isEnumConstant;
	}
	
	public CyclicConstructor assign(){
		if(defaultValText != null || defaultVal != null){
			CyclicConstructor ret = new CyclicConstructor(isStatic(), in);
			ret.body = new Statement.AssignFieldStatement(
					ret.scope,
					this,
					isStatic() ? null : new Value.ThisValue(in),
					defaultVal != null ? defaultVal : Value.fromAst(defaultValText, ret.scope, in, ret),
					ret);
			return ret;
		}
		if(isEnumConstant){
			CyclicConstructor ret = new CyclicConstructor(isStatic(), in);
			ArrayList<Value> args = enumConstantArgs != null ? enumConstantArgs.value().stream()
					.map(x -> Value.fromAst(x, ret.scope, in, ret))
					.collect(Collectors.toCollection(ArrayList::new)) : new ArrayList<>();
			args.add(0, new Value.StringLiteralValue(name()));
			args.add(1, new Value.IntLiteralValue(in.enumConstIdx));
			ret.body = new Statement.AssignFieldStatement(
					ret.scope,
					this,
					isStatic() ? null : new Value.ThisValue(in),
					new Value.InitializationValue(args, Utils.resolveConstructor(in(), args, ret), in(), ret),
					ret);
			in.enumConstIdx++;
			return ret;
		}
		return null;
	}
}