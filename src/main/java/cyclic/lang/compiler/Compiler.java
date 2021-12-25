package cyclic.lang.compiler;

import cyclic.lang.compiler.gen.CyclicClassWriter;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.cyclic.CyclicTypeBuilder;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public final class Compiler{
	
	public static final Map<String, CyclicType> toCompile = new HashMap<>();
	
	public static boolean includeDebugInfo = true; // line mappings, parameter names
	
	public static void main(String[] args){
		// go through all specified files and compile each
		var inputFolder = args[0];
		var outputFolder = args[1];
		
		for(var file : new File(inputFolder).listFiles()){
			try{
				var content = String.join("\n", Files.readAllLines(file.toPath()));
				var types = CyclicTypeBuilder.fromFile(content);
				for(var type : types)
					toCompile.put(type.fullyQualifiedName(), type);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		toCompile.values().forEach(CyclicType::resolveRefs);
		toCompile.values().forEach(CyclicType::resolveBodies);
		
		for(var type : toCompile.values()){
			CompileTimeException.setFile(type.fullyQualifiedName());
			ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
			CyclicClassWriter.writeClass(writer, type);
			try{
				Files.write(Path.of(outputFolder, type.shortName() + ".class"), writer.toByteArray());
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		// output and possibly zip
		
	}
}