package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangBaseVisitor;
import cyclic.lang.antlr_generated.CyclicLangLexer;
import cyclic.lang.antlr_generated.CyclicLangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class CyclicTypeBuilder{
	
	public static List<CyclicType> fromFile(String file){
		return fromParsedFile(parser(file).file());
	}
	
	public static List<CyclicType> fromParsedFile(CyclicLangParser.FileContext file){
		String packageName = file.packageDecl() != null ? file.packageDecl().id().getText() : "";
		List<String> imports = file.imports().importDecl().stream()
				.map(k -> k.id().getText() + (k.STAR() != null ? ".*" : ""))
				.map(k -> k.replaceAll(" +", ""))
				.collect(Collectors.toList());
		
		List<CyclicType> ret = new ArrayList<>(1);
		
		file.accept(new CyclicLangBaseVisitor<>(){
			public Object visitClassDecl(CyclicLangParser.ClassDeclContext ctx){
				CyclicType type = new CyclicType(ctx, packageName, imports);
				if(ctx.getParent() instanceof CyclicLangParser.MemberContext m){
					// we're an inner class
					// our parent has already been visited
					String parentName = ((CyclicLangParser.ClassDeclContext)m.getParent()).ID().getText();
					for(var t : ret){
						if(t.shortName().equals(parentName)){
							t.inners.add(type);
							type.outer = t;
							break;
						}
					}
				}
				ret.add(type);
				return super.visitClassDecl(ctx);
			}
		});
		
		return ret;
	}
	
	public static CyclicLangParser parser(String text){
		return new CyclicLangParser(new CommonTokenStream(new CyclicLangLexer(CharStreams.fromString(text))));
	}
}