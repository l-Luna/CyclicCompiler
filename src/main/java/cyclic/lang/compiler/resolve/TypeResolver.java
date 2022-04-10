package cyclic.lang.compiler.resolve;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompilerLauncher;
import cyclic.lang.compiler.configuration.Dependency;
import cyclic.lang.compiler.configuration.dependencies.CyclicDependency;
import cyclic.lang.compiler.configuration.dependencies.JdkDependency;
import cyclic.lang.compiler.configuration.dependencies.PlatformDependency;
import cyclic.lang.compiler.model.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Allows resolving types by name by checking all registered dependencies in order.
 *
 * @see TypeReference
 * @see Dependency
 * @see TypeResolver#resolve(String, List, String)
 * @see TypeResolver#resolveFq(String)
 */
public final class TypeResolver{
	
	/**
	 * The default list of dependencies.
	 */
	public static final List<Dependency> INITIAL_DEPENDENCIES = List.of(
			new PlatformDependency(), new JdkDependency(), new CyclicDependency()
	);
	
	/**
	 * The list of dependencies from which types can be obtained, including primitives and platform types.
	 */
	public static List<Dependency> dependencies = new ArrayList<>(INITIAL_DEPENDENCIES);
	
	/**
	 * Returns a reference to a type with the given fully qualified name, throwing
	 * a {@linkplain TypeNotFoundException} if it could not be found.
	 *
	 * @param fqName
	 * 		The fully qualified name of the type to resolve.
	 * @return A reference to the specified type.
	 * @throws TypeNotFoundException
	 * 		If the specified type doesn't exist.
	 */
	public static TypeReference resolveFq(String fqName){
		return resolveFqOptional(fqName)
				.orElseThrow(() -> new TypeNotFoundException(fqName));
	}
	
	/**
	 * Returns a reference to a type with the given (<em>possibly</em> qualified) name,
	 * throwing a {@linkplain TypeNotFoundException} if it could not be found in the given
	 * imports, default imports, or package.
	 *
	 * @param name
	 * 		The possibly qualified name of the type to resolve.
	 * @param imports
	 * 		The types and wildcards (e.g. "java.util.*") that were imported.
	 * @param currentPackage
	 * 		The package of the type where this name occurred.
	 * @return A reference to the specified type.
	 * @throws TypeNotFoundException
	 * 		If the specified type doesn't exist within the searched packages.
	 */
	public static TypeReference resolve(String name, List<String> imports, String currentPackage){
		return resolveOptional(name, imports, currentPackage)
				.orElseThrow(() -> new TypeNotFoundException(name + " was not found in imports [" + String.join(", ", imports) + "] or package " + currentPackage));
	}
	
	/**
	 * Returns a reference to a type with the given (<em>possibly</em> qualified) type name tree,
	 * throwing a {@linkplain TypeNotFoundException} if it could not be found in the given
	 * imports, default imports, or package.
	 *
	 * @param name
	 * 		A possibly qualified type name tree of the type to resolve.
	 * @param imports
	 * 		The types and wildcards (e.g. "java.util.*") that were imported.
	 * @param currentPackage
	 * 		The package of the type where this name occurred.
	 * @return A reference to the specified type.
	 * @throws TypeNotFoundException
	 * 		If the specified type doesn't exist within the searched packages.
	 */
	public static TypeReference resolve(CyclicLangParser.TypeContext name, List<String> imports, String currentPackage){
		return resolveOptional(getBaseName(name), imports, currentPackage)
				.orElseThrow(() -> new TypeNotFoundException(name.getText() + " was not found in imports [" + String.join(", ", imports) + "] or package " + currentPackage));
	}
	
	/**
	 * Returns a reference to a type with the given fully qualified name, returning
	 * {@linkplain Optional#empty()} if it could not be found.
	 *
	 * @param fqName
	 * 		The fully qualified name of the type to resolve.
	 * @return A reference to the specified type.
	 */
	public static Optional<TypeReference> resolveFqOptional(String fqName){
		for(Dependency dependency : dependencies){
			var check = dependency.find(fqName);
			if(check.isPresent())
				return check;
		}
		return Optional.empty();
	}
	
	/**
	 * Returns a reference to a type with the given (<em>possibly</em> qualified) name, returning
	 * {@linkplain Optional#empty()} if it could not be found in the given imports, default imports,
	 * or package.
	 *
	 * @param name
	 * 		The possibly qualified name of the type to resolve.
	 * @param imports
	 * 		The types and wildcards (e.g. "java.util.*") that were imported.
	 * @param currentPackage
	 * 		The package of the type where this name occurred.
	 * @return A reference to the specified type.
	 */
	public static Optional<TypeReference> resolveOptional(String name, List<String> imports, String currentPackage){
		// collect a list of candidates
		// - the name as-is
		// - every wildcard import + the name
		// - every import ending in the name
		List<String> candidates = new ArrayList<>();
		candidates.add(name);
		
		imports = new ArrayList<>(imports);
		imports.add("java.lang.*");
		if(currentPackage != null && !currentPackage.isBlank())
			imports.add(currentPackage + ".*");
		
		imports.addAll(CompilerLauncher.project.default_imports);
		
		for(var im : imports){
			if(im.endsWith(".*"))
				candidates.add(im.substring(0, im.length() - 1) + name);
			else if(im.endsWith(name))
				candidates.add(im);
		}
		
		for(String candidate : candidates){
			var check = resolveFqOptional(candidate);
			if(check.isPresent())
				return check;
		}
		
		return Optional.empty();
	}
	
	// TODO: handle generics and better handle annotations
	/**
	 * Simplifies a type name tree, removing any generics, annotations, and extra spaces.
	 */
	public static String getBaseName(CyclicLangParser.TypeContext name){
		if(name.LSQUAR() != null)
			return getBaseName(name.type()) + "[]";
		return name.rawType().getText();
	}
	
	public static String getBaseName(CyclicLangParser.TypeOrInferredContext name){
		if(name.inferType() != null)
			return name.inferType().getText();
		return getBaseName(name.type());
	}
}