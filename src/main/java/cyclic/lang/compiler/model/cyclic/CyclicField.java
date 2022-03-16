package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.resolve.TypeResolver;

public class CyclicField implements FieldReference, CyclicMember{
	
	CyclicType in;
	String name;
	AccessFlags flags;
	boolean isS, isV;
	
	CyclicLangParser.TypeContext typeName;
	CyclicLangParser.ValueContext defaultVal;
	CyclicLangParser.TypeContext typeCtx;
	
	TypeReference type;
	
	public CyclicField(CyclicType in, String name, AccessFlags flags, TypeReference type){
		this(in, name, flags, false, false, type);
	}
	
	public CyclicField(CyclicType in, String name, AccessFlags flags, boolean isS, boolean isV, TypeReference type){
		this.in = in;
		this.name = name;
		this.flags = flags;
		this.isS = isS;
		this.isV = isV;
		this.type = type;
	}
	
	public CyclicField(CyclicLangParser.VarDeclContext ctx, CyclicType in, boolean isPublicStaticFinalRequired){
		name = ctx.idPart().getText();
		this.in = in;
		flags = Utils.fromModifiers(ctx.modifiers(), modifier -> {
			isS |= modifier.equals("static");
			isV |= modifier.equals("volatile");
		});
		
		if(isPublicStaticFinalRequired){
			isS = true;
			flags = new AccessFlags(Visibility.PUBLIC, false, true);
		}
		
		typeName = ctx.type();
		typeCtx = ctx.type();
		defaultVal = ctx.value();
	}
	
	public void resolve(){
		var typeText = TypeResolver.getBaseName(typeName).strip();
		if(typeText.equals("var") || typeText.equals("val"))
			throw new CompileTimeException(typeCtx, "Field types may not be inferred");
		if(typeText.equals("void"))
			throw new CompileTimeException(typeCtx, "Fields may not be void");
		
		type = TypeResolver.resolve(typeName, in.imports, in.packageName());
		
		if(!Visibility.visibleFrom(type, this))
			throw new CompileTimeException(typeCtx, "Field type not visible here");
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
		return false;
	}
	
	public CyclicConstructor assign(){
		if(defaultVal != null){
			CyclicConstructor ret = new CyclicConstructor(isStatic(), in);
			ret.body = new Statement.AssignFieldStatement(ret.scope, this, isStatic() ? null : new Value.ThisValue(in), Value.fromAst(defaultVal, ret.scope, in, ret), ret);
			return ret;
		}
		return null;
	}
}