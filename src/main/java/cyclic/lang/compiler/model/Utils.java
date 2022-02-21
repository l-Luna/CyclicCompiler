package cyclic.lang.compiler.model;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.model.instructions.Scope;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.model.instructions.Variable;
import cyclic.lang.compiler.model.jdk.JdkTypeRef;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import cyclic.lang.compiler.resolve.PlatformDependency;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Opcodes;

import java.util.*;
import java.util.function.Consumer;

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
	
	public static <T> void checkDuplicates(List<T> in, String label){
		Set<T> checked = new HashSet<>(in.size());
		for(T t : in){
			if(checked.contains(t))
				throw new CompileTimeException(null, "Duplicate " + label + " \"" + t + "\"");
			checked.add(t);
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
	@Contract("_ -> new")
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
			String p;
			if(desc.startsWith("[") || desc.startsWith("L")){
				p = nameFromDescriptor(desc);
				out.add(p);
			}else{
				p = String.valueOf(desc.charAt(0));
				out.add(nameFromDescriptor(p));
			}
			desc = desc.substring(p.length() > 1 ? p.length() + 2 : 1);
		}
		return out;
	}
	
	public static MethodReference resolveMethod(String name, Value on, List<Value> args, CallableReference from, boolean superCall){
		// reach 0 -> no implicit conversions or varargs
		// reach 1 -> implicit conversions, no varargs
		// reach 2 -> varargs, no implicit conversions
		// reach 3 -> varargs, implicit conversions
		record Target(MethodReference ref, int reach){}
		
		// possible method references are:
		// - from the value being called on, if present, OR
		// - static members of the current type in a static method, OR
		// - static or instance methods of the current type in an instance method, with an implicit this added by CallStatement/CallValue
		List<MethodReference> candidates = new ArrayList<>();
		List<Target> targets = new ArrayList<>();
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
			candidates.addAll(from.isStatic()
					? type.methods().stream().filter(MethodReference::isStatic).toList()
					: type.methods());
		}
		candidates:
		for(MethodReference x : candidates){
			if(!visibleFrom(x, from))
				continue;
			if(x.name().equals(name)){
				List<TypeReference> parameters = x.parameters();
				int reach;
				varargs:
				if(x.isVarargs()){
					if(args.size() < parameters.size() - 1)
						break varargs;
					reach = 2;
					for(int i = 0; i < args.size(); i++){
						Value arg = args.get(i);
						TypeReference checking;
						if(i + 1 < parameters.size())
							checking = parameters.get(i);
						else{
							checking = parameters.get(parameters.size() - 1);
							if(checking instanceof ArrayTypeRef arr)
								checking = arr.getComponent();
							else
								break varargs; // invalid varargs method
						}
						if(arg.type().isAssignableTo(checking))
							continue;
						if(arg.fit(checking) != null){
							reach = 3;
							continue;
						}
						break varargs;
					}
					targets.add(new Target(x, reach));
				}
				if(x.parameters().size() != args.size())
					continue;
				reach = 0;
				for(int i = 0; i < parameters.size(); i++){
					TypeReference pTarget = parameters.get(i);
					Value arg = args.get(i);
					if(arg.type() != null && arg.type().isAssignableTo(pTarget))
						continue;
					if(arg.fit(pTarget) != null){
						reach = 1;
						continue;
					}
					continue candidates;
				}
				targets.add(new Target(x, reach));
			}
		}
		if(targets.size() == 0)
			return null;
		return targets.stream().min(Comparator.comparingInt(Target::reach)).get().ref();
	}
	
	public static CallableReference resolveConstructor(TypeReference of, List<Value> args, CallableReference from){
		CallableReference found = null;
		candidates:
		for(var x : of.constructors()){
			if(!visibleFrom(x, from))
				continue;
			if(x.parameters().size() != args.size())
				continue;
			for(int i = 0; i < x.parameters().size(); i++)
				if(args.get(i).fit(x.parameters().get(i)) == null)
					continue candidates;
			found = x;
			break;
		}
		return found;
	}
	
	public static MethodReference resolveSingleMethod(String from, String name, boolean isStatic, String... args){
		return resolveSingleMethod(TypeResolver.resolveFq(from), name, isStatic, Arrays.stream(args).map(TypeResolver::resolveFq).toArray(TypeReference[]::new));
	}
	
	public static MethodReference resolveSingleMethod(TypeReference from, String name, boolean isStatic, TypeReference... args){
		candidates:
		for(var c : from.methods()){
			if((c.isStatic() == isStatic) && c.name().equals(name) && c.parameters().size() == args.length){
				for(int i = 0; i < c.parameters().size(); i++){
					TypeReference p = c.parameters().get(i);
					if(!args[i].isAssignableTo(p))
						continue candidates;
				}
				return c;
			}
		}
		throw new IllegalStateException("Couldn't find " + (isStatic ? "static" : "non-static") + " method \"" + name + "\" in type " + from.fullyQualifiedName() + "!");
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
		return (int)(localVar + in.getIndexList().stream()
				.filter(x -> x.type() instanceof PrimitiveTypeRef p && (p.type == PrimitiveTypeRef.Primitive.DOUBLE || p.type == PrimitiveTypeRef.Primitive.LONG))
				.filter(x -> x.getVarIndex() < localVar)
				.count());
	}
	
	public static int adjustedIndex(Variable v){
		return adjustVarIndex(v.in(), v.getVarIndex());
	}
	
	public static String format(List<TerminalNode> tokens){
		var current = new StringBuilder();
		TerminalNode last = null;
		int curLine = tokens.size() > 0 ? tokens.get(0).getSymbol().getLine() : 0;
		for(TerminalNode token : tokens){
			if(last != null){
				int space = token.getSymbol().getStartIndex() - last.getSymbol().getStartIndex() - last.getText().length();
				if(token.getSymbol().getLine() > curLine)
					current.append("\n");
				if(space > 0)
					current.append(" ".repeat(space));
			}
			current.append(token);
			last = token;
			curLine = last.getSymbol().getLine();
		}
		return current.toString();
	}
	
	public static String format(ParserRuleContext ctx){
		return format(getAllTokens(ctx));
	}
	
	public static List<TerminalNode> getAllTokens(ParserRuleContext ctx){
		var ret = new ArrayList<TerminalNode>();
		if(ctx.children != null)
			for(var child : ctx.children)
				if(child instanceof TerminalNode t)
					ret.add(t);
				else if(child instanceof ParserRuleContext r)
					ret.addAll(getAllTokens(r));
		return ret;
	}
	
	public static boolean visibleFrom(MemberReference member, @NotNull MemberReference from){
		return switch(member.flags().visibility()){
			case PUBLIC -> true;
			case PACKAGE_PRIVATE -> member.in().packageName().equals(from.in().packageName());
			case PROTECTED -> member.in().packageName().equals(from.in().packageName()) || from.in().isAssignableTo(member.in());
			// TODO: some sort of nest system?
			case PRIVATE -> member.in().equals(from.in());
			case null -> false;
		};
	}
}