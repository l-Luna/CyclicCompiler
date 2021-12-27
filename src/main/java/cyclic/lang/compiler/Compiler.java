package cyclic.lang.compiler;

import cyclic.lang.compiler.gen.CyclicClassWriter;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.cyclic.CyclicTypeBuilder;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public final class Compiler{
	
	public static final Map<String, CyclicType> toCompile = new HashMap<>();
	
	public static boolean includeDebugInfo = true; // line mappings, parameter names
	
	public static void main(String[] args){
		if(args.length < 2){
			System.out.println("""
					The Cyclic Compiler compiles files in the Cyclic language with the extension .cyc into JVM class files.
					Please specify the input and output root folders as arguments, and optionally whether debug info (line mappings and parameter names) should be included (true/false, defaults to true).""");
			return;
		}
		
		// go through all specified files and compile each
		var inputFolder = args[0];
		var outputFolder = args[1];
		
		if(args.length >= 3)
			includeDebugInfo = Boolean.parseBoolean(args[2]);
		
		File inputFile = new File(inputFolder);
		Set<File> todo = new HashSet<>();
		visitFiles(inputFile, file -> {
			if(file.getName().endsWith(".cyc"))
				todo.add(file);
		});
		
		var out = compileFileSet(todo, Path.of(inputFolder));
		AtomicInteger output = new AtomicInteger();
		out.forEach((name, bytes) -> {
			CompileTimeException.setFile(name);
			try{
				Path fileOut = Path.of(outputFolder, name.replace('.', File.separatorChar) + ".class");
				// can fail if the folders already exist
				//noinspection ResultOfMethodCallIgnored
				fileOut.getParent().toFile().mkdirs();
				Files.write(fileOut, bytes);
				output.getAndIncrement();
			}catch(IOException e){
				e.printStackTrace();
			}
		});
		
		System.out.println("Written " + output + " class files.");
	}
	
	private static void visitFiles(File root, Consumer<File> visitor){
		File[] files = root.listFiles();
		if(files != null)
			for(File item : files)
				if(item.isFile())
					visitor.accept(item);
				else if(item.isDirectory())
					visitFiles(item, visitor);
	}
	
	public static Map<String, byte[]> compileFileSet(Set<File> files, Path root){
		for(File file : files){
			Path relative = root == null ? null : root.relativize(file.toPath());
			if(file.getName().endsWith(".cyc")){
				try{
					var content = Files.readString(file.toPath());
					var types = CyclicTypeBuilder.fromFile(content, relative);
					for(var type : types)
						toCompile.put(type.fullyQualifiedName(), type);
				}catch(IOException e){
					e.printStackTrace();
				}
			}else{
				System.out.println("File \"" + (relative != null ? relative.toString() : file.getName()) + "\" was asked to be compiled, but does not have \".cyc\" extension and will be ignored.");
			}
		}
		
		toCompile.values().forEach(CyclicType::resolveRefs);
		toCompile.values().forEach(CyclicType::resolveBodies);
		
		Map<String, byte[]> ret = new HashMap<>(toCompile.size());
		
		for(var type : toCompile.values()){
			CompileTimeException.setFile(type.fullyQualifiedName());
			ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
			CyclicClassWriter.writeClass(writer, type);
			ret.put(type.fullyQualifiedName(), writer.toByteArray());
		}
		
		System.out.println("Compiled " + toCompile.size() + " classes.");
		
		toCompile.clear();
		return ret;
	}
	
	public static Map<String, byte[]> compileText(String text){
		var types = CyclicTypeBuilder.fromFile(text, null);
		for(var type : types)
			toCompile.put(type.fullyQualifiedName(), type);
		toCompile.values().forEach(CyclicType::resolveRefs);
		toCompile.values().forEach(CyclicType::resolveBodies);
		
		Map<String, byte[]> ret = new HashMap<>(toCompile.size());
		
		for(var type : toCompile.values()){
			CompileTimeException.setFile(type.fullyQualifiedName());
			ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
			CyclicClassWriter.writeClass(writer, type);
			ret.put(type.fullyQualifiedName(), writer.toByteArray());
		}
		
		toCompile.clear();
		return ret;
	}
	
	public static byte[] compileSingleClass(String text){
		return compileText(text).values().stream().findAny().orElseThrow(() -> new IllegalArgumentException("No classes were contained in the given text, but one was expected"));
	}
	
	@SuppressWarnings("unused")
	public static Class<?> compileClass(String text, MethodHandles.Lookup defineWith) throws IllegalAccessException{
		return defineWith.defineClass(compileSingleClass(text));
	}
}