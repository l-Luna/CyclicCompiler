package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.antlr_generated.CyclicLangBaseVisitor;
import cyclic.lang.antlr_generated.CyclicLangLexer;
import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.problems.CompileTimeException;
import cyclic.lang.compiler.problems.SyntaxException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class CyclicTypeBuilder{
	
	public static List<CyclicType> fromFile(@NotNull String file, @Nullable Path from){
		SyntaxException.curFile.set(from != null ? from.toString() : "<unnamed file>");
		return fromParsedFile(parser(file).file(), from);
	}
	
	public static List<CyclicType> fromParsedFile(@NotNull CyclicLangParser.FileContext file, @Nullable Path from){
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
					String parentName = ((CyclicLangParser.ClassDeclContext)m.getParent()).idPart().getText();
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
					throw new CompileTimeException(prototype.nameToken(), "Top-level class declares fully-qualified name " + prototype.fullyQualifiedName() + ", but must have name " + expected + " according to file structure");
				}
			}
		}
		
		return ret;
	}
	
	public static CyclicLangParser parser(@NotNull String text){
		CyclicLangParser parser = new CyclicLangParser(new CommonTokenStream(new CyclicLangLexer(CharStreams.fromString(text))));
		parser.getErrorListeners().clear();
		parser.addErrorListener(new SyntaxException.SyntaxErrorListener());
		return parser;
	}
	
	/**
	 * Recursively visit every file in a file tree, running the passed visitor on every file, but not on directories or other entries.
	 * @param root The directory to visit the children of.
	 * @param visitor The visitor to be given every file.
	 */
	public static void visitFiles(File root, Consumer<File> visitor){
		File[] files = root.listFiles();
		if(files != null)
			for(File item : files)
				if(item.isFile())
					visitor.accept(item);
				else if(item.isDirectory())
					visitFiles(item, visitor);
	}
}