package cyclic.lang.compiler.benchmark;

import cyclic.lang.compiler.CompilerLauncher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Benchmark{
	
	private static Path target;
	
	public static void main(String[] args) throws IOException{
		target = Files.createTempDirectory(null);
		
		for(int i = 0; i < 2500; i++)
			addFile("cyclic/Bench%s.cyc".formatted(i), """
					import java.util.*;
					class Bench%s{
						static int i = 3 + 3;
						static String u = "3" + "3";
						int o = 4;
						
						public static void main(String... args){
							for(String o : args)
								System.out.println(o);
							var something = List.of("a", "b", "c");
							for(Object o : something)
								System.out.println(o);
							i++;
							i--;
							System.out.println(test(test((long)i)));
						}
						
						{ o = 3; }
						public static String test(int i) -> i + u;
						public static int test(long l) -> (int)l;
						public double compute(int i, long l, float f, Object obj, String s, double d, byte b){
							double d2;
							if(d < 0)
								throw new IllegalArgumentException("d > 0");
							else
								{ d2 = d; }
							do{
								d2 += f;
								d2 += i;
								d -= 0.1;
								if(b < 30)
									continue;
								if(d < Math.sqrt(Math.PI * d))
									break;
							}while(d > 0);
							if(s == obj)
								return d2;
							else
								return d2 - s.length();
						}
					}
					""".formatted(i));
		
		var projectPath = addFile("project.cyc.yaml", """
				source: "cyclic/"
				output: "out/"
				""");
		
		var now = System.currentTimeMillis();
		CompilerLauncher.main("-p", projectPath.toAbsolutePath().toString());
		System.out.println("Took " + (System.currentTimeMillis() - now) + "ms");
		
		recDelete(target);
	}
	
	private static Path addFile(String name, String content) throws IOException{
		Path file = target.resolve(name);
		var parentFolder = file.getParent().toFile();
		var succeeded = parentFolder.mkdirs();
		if(!succeeded && !parentFolder.exists())
			throw new IOException("Failed to create parent directories for benchmark file");
		Files.write(file, content.getBytes());
		return file;
	}
	
	private static void recDelete(Path path) throws IOException{
		try(var files = Files.list(path)){
			for(Path f : files.toList()){
				if(Files.isDirectory(f))
					recDelete(f);
				Files.delete(f);
			}
		}
	}
}