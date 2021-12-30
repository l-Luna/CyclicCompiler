package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;

public class CyclicField implements FieldReference, CyclicMember{
	
	CyclicType in;
	String name;
	AccessFlags flags;
	boolean isS, isV;
	
	String typeName;
	CyclicLangParser.ValueContext defaultVal;
	
	TypeReference type;
	
	public CyclicField(CyclicType in, String name, AccessFlags flags, boolean isS, boolean isV, String typeName){
		this.in = in;
		this.name = name;
		this.flags = flags;
		this.isS = isS;
		this.isV = isV;
		this.typeName = typeName;
	}
	
	public CyclicField(CyclicLangParser.VarDeclContext ctx, CyclicType in){
		name = ctx.idPart().getText();
		this.in = in;
		flags = Utils.fromModifiers(ctx.modifiers(), modifier -> {
			isS |= modifier.equals("static");
			isV |= modifier.equals("volatile");
		});
		
		typeName = ctx.type().getText();
		defaultVal = ctx.value();
	}
	
	public void resolve(){
		type = TypeResolver.resolve(typeName, in.imports, in.packageName());
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
	
	public CyclicConstructor assign(){
		if(defaultVal != null){
			CyclicConstructor ret = new CyclicConstructor(isStatic(), in);
			ret.body = new Statement.AssignFieldStatement(ret.methodScope, this, isStatic() ? null : new Value.ThisValue(in), Value.fromAst(defaultVal, ret.methodScope, in, ret));
			return ret;
		}
		return null;
	}
}