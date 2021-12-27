package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangBaseVisitor;
import cyclic.lang.antlr_generated.CyclicLangLexer;
import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class CyclicTypeBuilder{
	
	public static List<CyclicType> fromFile(String file, Path from){
		return fromParsedFile(parser(file).file(), from);
	}
	
	public static List<CyclicType> fromParsedFile(CyclicLangParser.FileContext file, Path from){
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
		
		if(ret.size() > 0){
			CyclicType prototype = ret.get(0);
			// from is the relative path from the input folder, which must match the package name + class name
			if(from != null){
				String expected = from.toString().replace(File.separatorChar, '.').substring(0, from.toString().length() - 4);
				boolean matchesFileName = expected.equals(prototype.fullyQualifiedName());
				if(!matchesFileName){
					CompileTimeException.setFile(from.toString());
					throw new CompileTimeException(null, "Top-level class declares fully-qualified name " + prototype.fullyQualifiedName() + ", but must have name " + expected + " according to file structure");
				}
			}
		}
		
		return ret;
	}
	
	public static CyclicLangParser parser(String text){
		return new CyclicLangParser(new CommonTokenStream(new CyclicLangLexer(CharStreams.fromString(text))));
	}
}