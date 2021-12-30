package cyclic.lang.compiler;

import cyclic.lang.compiler.gen.CyclicClassWriter;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.cyclic.CyclicTypeBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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

/**
 * Entry point of the Cyclic Compiler. Contains the <code>main</code> method, alongside several other methods for compiling
 * Cyclic files and strings from other code.
 *
 * @see Compiler#main(String[])
 * @see Compiler#compileFileSet(Set, Path)
 */
public final class Compiler{
	
	/** The set of types that are currently being compiled, indexed by their fully qualified names. */
	public static final Map<String, CyclicType> toCompile = new HashMap<>();
	
	/** Whether line mappings and parameter names will be emitted in output class files in the next run. */
	public static boolean includeDebugInfo = true;
	
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
	
	/**
	 * Recursively visit every file in a file tree, running the passed visitor on every file, but not on directories or other entries.
	 * @param root The directory to visit the children of.
	 * @param visitor The visitor to be given every file.
	 */
	private static void visitFiles(File root, Consumer<File> visitor){
		File[] files = root.listFiles();
		if(files != null)
			for(File item : files)
				if(item.isFile())
					visitor.accept(item);
				else if(item.isDirectory())
					visitFiles(item, visitor);
	}
	
	/**
	 * Compiles a set of files into classes, returning every compiled class indexed by their fully-qualified names.
	 * May return more classes than files if one file contains inner classes.
	 * A root path may optionally be specified to enforce that fully-qualified names matches folder structure and file names.
	 * References in these files will only be resolved if they point to other files in the set, or to Java standard library types.
	 *
	 * @param files The set of files to compile.
	 * @param root The optional root directory for the files.
	 * @return A map containing the byte contents of compiled classes indexed by fully-qualified names.
	 */
	public static Map<String, byte[]> compileFileSet(@NotNull Set<File> files, @Nullable Path root){
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
		toCompile.values().forEach(CyclicType::resolveInheritance);
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
	
	/**
	 * Compiles a string that contains a Cyclic class into classes, indexed by fully-qualified names.
	 * A single string may contain multiple classes if inner classes are present.
	 *
	 * @param text A string containing a Cyclic class.
	 * @return A map containing the bytes of compiled classes indexed by fully-qualified names.
	 * @see Compiler#compileSingleClass(String)
	 */
	public static Map<String, byte[]> compileString(@NotNull String text){
		var types = CyclicTypeBuilder.fromFile(text, null);
		for(var type : types)
			toCompile.put(type.fullyQualifiedName(), type);
		toCompile.values().forEach(CyclicType::resolveRefs);
		toCompile.values().forEach(CyclicType::resolveInheritance);
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
	
	/**
	 * Compiles a string containing a Cyclic class into a class.
	 * If multiple classes (e.g. inner classes) are contained within the string, references between them will be resolved but only the first will be returned.
	 * If no classes are present, this throws an exception.
	 *
	 * @param text A string containing a Cyclic class.
	 * @return The bytes of the first compiled class found.
	 * @see Compiler#compileString(String)
	 */
	public static byte[] compileSingleClass(@NotNull String text){
		return compileString(text).values().stream().findFirst().orElseThrow(() -> new IllegalArgumentException("No classes were contained in the given text, but one was expected"));
	}
	
	/**
	 * Compiles a string containing a Cyclic class into a class, and loads it using the given Lookup into the Lookup's package.
	 * The package declaration in the class is ignored.
	 * Follows the behaviour of {@linkplain Compiler#compileSingleClass(String)}.
	 *
	 * @param text A string containing a Cyclic class.
	 * @param defineWith A Lookup to define the class with.
	 * @return A class instance compiled from the string.
	 * @throws IllegalAccessException if the lookup does not have package access.
	 */
	@SuppressWarnings("unused")
	public static Class<?> compileClass(@NotNull String text, @NotNull MethodHandles.Lookup defineWith) throws IllegalAccessException{
		return defineWith.defineClass(compileSingleClass(text));
	}
}