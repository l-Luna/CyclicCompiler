package cyclic.lang.compiler.model;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.configuration.dependencies.PlatformDependency;
import cyclic.lang.compiler.model.instructions.Scope;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.model.instructions.Variable;
import cyclic.lang.compiler.model.jdk.JdkTypeRef;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import cyclic.lang.compiler.problems.CompileTimeException;
import cyclic.lang.compiler.resolve.MethodResolver;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Opcodes;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility methods used within the compiler for parsing ASTs, text, and bitfields.
 *
 * <p>Methods and types within this class are considered internal.
 */
public final class Utils{
	
	/**
	 * Represents a parsed fully qualified name, with a package name and short name part.
	 */
	public record PackageAndName(String pkg, String name){
		public static PackageAndName fromInternal(String internalName){
			String[] parts = internalName.split("/");
			if(parts.length == 1)
				return new PackageAndName("", parts[0]);
			return new PackageAndName(String.join(".", Arrays.stream(parts).limit(parts.length - 1).toArray(String[]::new)),
					parts[parts.length - 1]);
		}
	}
	
	public static <T> void checkDuplicates(List<T> in, String label, ParserRuleContext errorAt){
		checkDuplicates(in, label, Object::toString, Object::toString, errorAt);
	}
	
	public static <T> void checkDuplicates(List<T> in, String label, Function<T, String> namer, Function<T, String> prettier, ParserRuleContext errorAt){
		Set<String> checked = new HashSet<>(in.size());
		for(T t : in){
			var name = namer.apply(t);
			if(checked.contains(name))
				throw new CompileTimeException(errorAt, "Duplicate " + label + " \"" + prettier.apply(t) + "\"");
			checked.add(name);
		}
	}
	
	@Contract("_ -> new")
	public static @NotNull AccessFlags fromModifiers(CyclicLangParser.ModifiersContext ctx){
		return fromModifiers(ctx, x -> {});
	}
	
	@Contract("_, _ -> new")
	public static @NotNull AccessFlags fromModifiers(CyclicLangParser.ModifiersContext ctx, Consumer<String> also){
		if(ctx == null)
			return new AccessFlags(Visibility.PUBLIC, false, false);
		
		var visibility = Visibility.PACKAGE_PRIVATE;
		var isA = false;
		var isF = false;
		for(CyclicLangParser.ModifierContext context : ctx.modifier()){
			String modifier = context.getText();
			switch(modifier){
				case "private" -> visibility = Visibility.PRIVATE;
				case "public" -> visibility = Visibility.PUBLIC;
				case "protected" -> visibility = Visibility.PROTECTED;
				
				case "final" -> isF = true;
				case "abstract" -> isA = true;
			}
			also.accept(modifier);
		}
		return new AccessFlags(visibility, isA, isF);
	}
	
	@Contract("_ -> new")
	public static @NotNull AccessFlags fromBitfield(int access){
		boolean isPublic = isBitSet(access, Opcodes.ACC_PUBLIC);
		boolean isPrivate = isBitSet(access, Opcodes.ACC_PRIVATE);
		boolean isProtected = isBitSet(access, Opcodes.ACC_PROTECTED);
		
		boolean isFinal = isBitSet(access, Opcodes.ACC_FINAL);
		boolean isAbstract = isBitSet(access, Opcodes.ACC_ABSTRACT);
		
		return new AccessFlags(isPublic ? Visibility.PUBLIC : isPrivate ? Visibility.PRIVATE : isProtected ? Visibility.PROTECTED : Visibility.PACKAGE_PRIVATE,
				isAbstract, isFinal);
	}
	
	public static boolean isBitSet(int bitfield, int bit){
		return (bitfield & bit) == bit;
	}
	
	private static Map<Class<?>, TypeReference> classCache = new WeakHashMap<>();
	/**
	 * Creates a {@linkplain TypeReference} instance that represents the class passed in, handling
	 * primitive and array types correctly.
	 *
	 * @param type
	 * 		The class to create a reference to.
	 * @return A reference to the class passed in.
	 * @see TypeReference
	 * @see TypeResolver
	 */
	public static @NotNull TypeReference forAnyClass(@NotNull Class<?> type){
		if(classCache.containsKey(type))
			return classCache.get(type);
		TypeReference result;
		if(boolean.class.equals(type))
			result = PlatformDependency.BOOLEAN;
		else if(byte.class.equals(type))
			result = PlatformDependency.BYTE;
		else if(short.class.equals(type))
			result = PlatformDependency.SHORT;
		else if(int.class.equals(type))
			result = PlatformDependency.INT;
		else if(char.class.equals(type))
			result = PlatformDependency.CHAR;
		else if(long.class.equals(type))
			result = PlatformDependency.LONG;
		else if(float.class.equals(type))
			result = PlatformDependency.FLOAT;
		else if(double.class.equals(type))
			result = PlatformDependency.DOUBLE;
		else if(void.class.equals(type))
			result = PlatformDependency.VOID;
		else if(type.isArray())
			result = new ArrayTypeRef(forAnyClass(type.componentType()));
		else
			result = new JdkTypeRef(type);
		classCache.put(type, result);
		return result;
	}
	
	public static String nextDescriptor(@NotNull String desc){
		if(desc.startsWith("L"))
			return "L" + desc.substring(1, desc.indexOf(";")) + ";";
		if(desc.startsWith("["))
			return "[" + nextDescriptor(desc.substring(1));
		return switch(desc.charAt(0)){
			case 'Z' -> "Z";
			case 'B' -> "B";
			case 'S' -> "S";
			case 'I' -> "I";
			case 'C' -> "C";
			case 'J' -> "J";
			case 'F' -> "F";
			case 'D' -> "D";
			case 'V' -> "V";
			default -> throw new IllegalArgumentException("Descriptor " + desc + " is not a valid type descriptor");
		};
	}
	
	public static String nameFromDescriptor(@NotNull String desc){
		if(desc.startsWith("L"))
			return desc.substring(1, desc.indexOf(";"));
		if(desc.startsWith("["))
			return nameFromDescriptor(desc.substring(1)) + "[]";
		return switch(desc.charAt(0)){
			case 'Z' -> "boolean";
			case 'B' -> "byte";
			case 'S' -> "short";
			case 'I' -> "int";
			case 'C' -> "char";
			case 'J' -> "long";
			case 'F' -> "float";
			case 'D' -> "double";
			case 'V' -> "void";
			default -> throw new IllegalArgumentException("Descriptor " + desc + " is not a valid type descriptor");
		};
	}
	
	// e.g. (II[J[[Ljava/lang/String;)Ljava/lang/String;  -->  int, int, long[], java/lang/String[][], java/lang/String
	public static List<String> methodDescriptorParts(@NotNull String desc){
		// ignore brackets; the last element is always considered the end, every method has a return type
		desc = desc.replace("(", "");
		desc = desc.replace(")", "");
		List<String> out = new ArrayList<>();
		while(desc.length() > 0){
			String p = nextDescriptor(desc);
			desc = desc.substring(p.length());
			out.add(nameFromDescriptor(p));
		}
		return out;
	}
	
	public static MethodReference resolveMethod(String name, Value on, List<Value> args, CallableReference from, boolean superCall){
		// possible method references are:
		// - from the value being called on, if present, OR
		// - static members of the current type in a static method, OR
		// - static or instance methods of the current type in an instance method, with an implicit this added by CallStatement/CallValue
		List<MethodReference> candidates = new ArrayList<>();
		if(superCall && on != null)
			throw new IllegalArgumentException("Can't resolve a super method on a non-this object instance");
		if(superCall && from.isStatic())
			throw new IllegalArgumentException("Can't resolve a super method in a static context");
		
		if(on != null)
			candidates.addAll(on.type().methods());
		else{
			var type = from.in();
			if(superCall)
				type = type.superClass();
			if(type != null)
				candidates.addAll(from.isStatic()
						? type.methods().stream().filter(MethodReference::isStatic).toList()
						: type.methods());
		}
		
		List<MethodReference> filtered = new ArrayList<>(candidates.size());
		for(MethodReference x : candidates)
			if(x.name().equals(name) && Visibility.visibleFrom(x, from))
				filtered.add(x);
		candidates = filtered;
		
		return MethodResolver.best(candidates, args);
	}
	
	public static ConstructorReference resolveConstructor(TypeReference of, List<Value> args, MemberReference from){
		var candidates = of.constructors().stream()
				.filter(x -> Visibility.visibleFrom(x, from))
				.toList();
		
		return MethodResolver.best(candidates, args);
	}
	
	public static MethodReference resolveSingleMethod(String from, String name, boolean isStatic, String... args){
		return resolveSingleMethod(TypeResolver.resolveFq(from), name, isStatic, Arrays.stream(args).map(TypeResolver::resolveFq).toArray(TypeReference[]::new));
	}
	
	public static MethodReference resolveSingleMethod(TypeReference from, String name, boolean isStatic, TypeReference... args){
		return resolveSingleOptionalMethod(from, name, isStatic, args).orElseThrow(() ->
				new IllegalStateException("Couldn't find " + (isStatic ? "static" : "non-static") + " method \"" + name + "\" in type " + from.fullyQualifiedName() + "!"));
	}
	
	public static Optional<MethodReference> resolveSingleOptionalMethod(TypeReference from, String name, boolean isStatic, TypeReference... args){
		candidates:
		for(var c : from.declaredMethods()){
			if((c.isStatic() == isStatic) && c.name().equals(name) && c.parameters().size() == args.length){
				for(int i = 0; i < c.parameters().size(); i++){
					TypeReference p = c.parameters().get(i);
					if(!args[i].isAssignableTo(p))
						continue candidates;
				}
				return Optional.of(c);
			}
		}
		return Optional.empty();
	}
	
	public static FieldReference getField(TypeReference from, String name){
		for(FieldReference field : from.fields())
			if(field.name().equals(name))
				return field;
		throw new IllegalStateException("Couldn't find field \"" + name + "\" on type \"" + from.shortName() + "\"!");
	}
	
	public static List<CyclicLangParser.AnnotationContext> getAnnotations(CyclicLangParser.TypeContext name){
		var ret = new ArrayList<>(name.annotation());
		if(name.type() != null)
			ret.addAll(getAnnotations(name.type()));
		return ret;
	}
	
	// add 1 for every long or double var before it
	public static int adjustVarIndex(Scope in, int localVar){
		int count = 0;
		for(Variable x : in.getIndexList())
			if(x.getVarIndex() < localVar)
				if(x.type() instanceof PrimitiveTypeRef p && (p.type == PrimitiveTypeRef.Primitive.DOUBLE || p.type == PrimitiveTypeRef.Primitive.LONG))
					count++;
		return localVar + count;
	}
	
	public static int adjustedIndex(Variable v){
		return adjustVarIndex(v.in(), v.getVarIndex());
	}
	
	public static String format(@Nullable ParserRuleContext ctx){
		if(ctx == null)
			return "";
		CharStream stream = ctx.start.getInputStream();
		return stream.getText(new Interval(ctx.start.getStartIndex(), ctx.stop.getStopIndex()));
	}
	
	public static String position(ParserRuleContext ctx){
		return "[%d:%d]".formatted(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
	}
	
	public static int maxMethodParameterLocalIndex(CallableReference method){
		return method.parameters().stream()
				.mapToInt(x -> x.equals(PlatformDependency.LONG) || x.equals(PlatformDependency.DOUBLE) ? 2 : 1)
				.sum() + (method.isStatic() ? 0 : 1);
	}
	
	public static <T, Eq> Stream<T> distinctStreamByEq(Stream<T> in, Function<T, Eq> eq){
		record Shell<T, Eq>(T t, Eq eq){
			public boolean equals(Object obj){ return obj instanceof Shell<?,?> sh && sh.eq().equals(eq()); }
			public int hashCode(){ return eq().hashCode(); }
		}
		
		return in.map(it -> new Shell<>(it, eq.apply(it)))
				.distinct()
				.map(Shell::t);
	}
	
	public static <T, Eq> List<T> distinctListByEq(List<T> in, Function<T, Eq> eq){
		return distinctStreamByEq(in.stream(), eq).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public static boolean isBoxType(TypeReference type){
		return Arrays.stream(PrimitiveTypeRef.Primitive.values()).anyMatch(x -> PrimitiveTypeRef.boxedTypeName(x).equals(type.fullyQualifiedName()));
	}
	
	public static PrimitiveTypeRef.Primitive unbox(TypeReference type){
		return Arrays.stream(PrimitiveTypeRef.Primitive.values())
				.filter(x -> PrimitiveTypeRef.boxedTypeName(x).equals(type.fullyQualifiedName()))
				.findFirst()
				.orElse(null);
	}
}