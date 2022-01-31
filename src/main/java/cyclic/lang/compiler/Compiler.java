package cyclic.lang.compiler;

import cyclic.lang.compiler.gen.AsmCyclicCW;
import cyclic.lang.compiler.gen.CyclicClassWriter;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.cyclic.CyclicTypeBuilder;
import cyclic.lang.compiler.resolve.Dependency;
import cyclic.lang.compiler.resolve.JarDependency;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.ClassWriter;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.spi.ToolProvider;

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
	
	/** The project currently being compiled. */
	public static CyclicProject project;
	
	public static void main(String[] args){
		if(args.length < 2){
			System.out.println("""
					The Cyclic Compiler compiles files in the Cyclic language with the extension .cyc into JVM class files.
					Specify the input and output root folders as arguments, and optionally whether debug info (line mappings and parameter names) should be included (true/false, defaults to true).
					Alternatively, use the flag "-p" followed by a path to a Cyclic project file ("project.cyc.yaml") that contains the settings for building that project.
					""");
			return;
		}
		
		// setup cyclic project
		if(args[0].equals("-p")){
			var yaml = new Yaml();
			try{
				Path projectPath = Path.of(args[1]);
				var text = Files.readString(projectPath);
				project = yaml.loadAs(text, CyclicProject.class);
				project.updatePaths(projectPath.getParent());
			}catch(Exception e){
				System.err.println("Invalid project file: " + e);
				System.exit(1);
			}
		}else{
			project = new CyclicProject();
			project.sourcePath = Path.of(args[0]);
			project.outputPath = Path.of(args[1]);
			if(args.length >= 3)
				includeDebugInfo = Boolean.parseBoolean(args[2]);
		}
		
		project.validate();
		includeDebugInfo = project.include_debug;
		
		// load any dependencies
		// TODO: better dependency management: non-jar deps, check versions/names, download deps?
		for(CyclicPackage dependency : project.dependencies){
			if(dependency.type.equalsIgnoreCase("jar")){
				try{
					Path filePath = project.root.resolve(dependency.location).normalize();
					JarDependency e = new JarDependency(filePath.toFile());
					TypeResolver.dependencies.add(e);
					e.resolve();
				}catch(IOException e){
					e.printStackTrace();
				}
			}else
				System.err.println("Unknown dependency type \"" + dependency.type + "\", only \"jar\" is supported");
		}
		
		// go through all specified files and compile each
		var inputFolder = project.sourcePath;
		var outputFolder = project.outputPath;
		
		File inputFile = inputFolder.toFile();
		Set<File> todo = new HashSet<>();
		visitFiles(inputFile, file -> {
			if(file.getName().endsWith(".cyc"))
				todo.add(file);
		});
		
		var out = compileFileSet(todo, inputFolder);
		
		if(project.no_output){
			System.out.println("Skipping output and packaging (because the project has \"no_output\" set to true).");
			return;
		}
		
		AtomicInteger output = new AtomicInteger();
		out.forEach((name, bytes) -> {
			CompileTimeException.setFile(name);
			try{
				Path fileOut = Path.of(outputFolder.toString(), name.replace('.', File.separatorChar) + ".class");
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
		
		for(Dependency dependency : TypeResolver.dependencies)
			try{
				dependency.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		
		for(CyclicPackage cycPackage : project.packages){
			// TODO: handle resources for jars, and handle other formats (JMODs?)
			// probably want to move this all out elsewhere
			if(cycPackage.name == null || cycPackage.version == null)
				System.err.println("Unnamed package found, will be skipped");
			if(cycPackage.type == null)
				System.err.printf("Unspecified package type for package \"%s\" version %s, will be skipped%n", cycPackage.name, cycPackage.version);
			
			if(cycPackage.type.equalsIgnoreCase("jar")){
				Optional<ToolProvider> optionalJarTool = ToolProvider.findFirst("jar");
				if(optionalJarTool.isEmpty()){
					System.err.printf("Could not get jar tool for packaging jar project \"%s\", skipping packaging%n", cycPackage.name);
					continue;
				}
				ToolProvider jartool = optionalJarTool.get();
				Path filePath = project.outputPath.resolve(cycPackage.location).normalize();
				String targetPath = filePath.toAbsolutePath() + "/" + cycPackage.name + "-" + cycPackage.version + ".jar";
				//noinspection ResultOfMethodCallIgnored
				Path.of(targetPath).getParent().toFile().mkdirs();
				// jar -c --file <filePath name "-" version> -C <outputPath>
				int result = jartool.run(System.out, System.err, "-c", "--file", targetPath, "-C", project.outputPath.toAbsolutePath().toString(), ".");
				if(result == 1)
					System.err.printf("Failed to make jar file for package \"%s\" version %s%n", cycPackage.name, cycPackage.version);
			}else
				System.err.printf("Unknown package type \"%s\" for package \"%s\" version %s, will be skipped%n", cycPackage.type, cycPackage.name, cycPackage.version);
		}
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
			ClassWriter writer = new AsmCyclicCW(ClassWriter.COMPUTE_FRAMES);
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
		project = new CyclicProject();
		project.include_cyclic_lib_refs = false;
		toCompile.clear();
		
		var types = CyclicTypeBuilder.fromFile(text, null);
		for(var type : types)
			toCompile.put(type.fullyQualifiedName(), type);
		toCompile.values().forEach(CyclicType::resolveRefs);
		toCompile.values().forEach(CyclicType::resolveInheritance);
		toCompile.values().forEach(CyclicType::resolveBodies);
		
		Map<String, byte[]> ret = new HashMap<>(toCompile.size());
		
		for(var type : toCompile.values()){
			CompileTimeException.setFile(type.fullyQualifiedName());
			ClassWriter writer = new AsmCyclicCW(ClassWriter.COMPUTE_FRAMES);
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
	 * Follows the behaviour of {@linkplain Compiler#compileSingleClass(String)}.
	 * <p>The class must have the same declared package as the class associated with the lookup.
	 * <p>The returned class is a hidden class, which do not have names and are more eagerly garbage collected that regular classes.
	 *
	 * @param text A string containing a Cyclic class.
	 * @param defineWith A Lookup to define the class with.
	 * @return A class instance compiled from the string.
	 * @throws IllegalAccessException if the lookup does not have package access.
	 * @see MethodHandles.Lookup#defineHiddenClass(byte[], boolean, MethodHandles.Lookup.ClassOption...)
	 */
	@SuppressWarnings("unused")
	public static Class<?> compileClass(@NotNull String text, @NotNull MethodHandles.Lookup defineWith) throws IllegalAccessException{
		return defineWith.defineHiddenClass(compileSingleClass(text), true).lookupClass();
	}
	
	public static Method compileSingleMethod(@NotNull String text, @NotNull MethodHandles.Lookup defineWith) throws IllegalAccessException{
		var holder = compileClass(text, defineWith);
		return holder.getDeclaredMethods()[0];
	}
}