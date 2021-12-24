package cyclic.lang.compiler.model;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.external.SystemTypeRef;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import org.antlr.v4.runtime.RuleContext;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class Utils{
	
	public static AccessFlags fromModifiers(CyclicLangParser.ModifiersContext ctx){
		return fromModifiers(ctx, x -> {});
	}
	
	public static AccessFlags fromModifiers(CyclicLangParser.ModifiersContext ctx, Consumer<String> also){
		var visibility = new AtomicReference<>(Visibility.PACKAGE_PRIVATE);
		var isA = new AtomicBoolean(false);
		var isF = new AtomicBoolean(false);
		ctx.modifier().stream().map(RuleContext::getText).forEach(modifier -> {
			switch(modifier){
				case "private" -> visibility.set(Visibility.PRIVATE);
				case "public" -> visibility.set(Visibility.PUBLIC);
				case "protected" -> visibility.set(Visibility.PROTECTED);
				
				case "final" -> isF.set(true);
				case "abstract" -> isA.set(true);
			}
			also.accept(modifier);
		});
		return new AccessFlags(visibility.get(), isA.get(), isF.get());
	}
	
	public static AccessFlags fromBitfield(int access){
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
	
	// may be a primitive or array type too
	public static TypeReference forAnyClass(Class<?> type){
		if(boolean.class.equals(type))
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.BOOLEAN);
		else if(byte.class.equals(type))
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.BYTE);
		else if(short.class.equals(type))
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.SHORT);
		else if(int.class.equals(type))
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.INT);
		else if(char.class.equals(type))
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.CHAR);
		else if(long.class.equals(type))
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.LONG);
		else if(float.class.equals(type))
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.FLOAT);
		else if(double.class.equals(type))
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.DOUBLE);
		else if(void.class.equals(type))
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.VOID);
		else{
			if(type.isArray())
				return new ArrayTypeRef(forAnyClass(type.componentType()));
			return new SystemTypeRef(type);
		}
	}
	
	public static MethodReference resolveMethod(String name, Value on, List<Value> args, CallableReference from){
		// possible method references are:
		// - from the value being called on, if present, OR
		// - static members of the current type in a static method, OR
		// - static or instance methods of the current type in an instance method, with an implicit this added by CallStatement/CallValue
		List<MethodReference> candidates = new ArrayList<>();
		if(on != null)
			candidates.addAll(on.type().methods());
		else
			candidates.addAll(from.isStatic() ? from.in().methods().stream().filter(MethodReference::isStatic).toList() : from.in().methods());
		MethodReference found = null;
		candidates:
		for(MethodReference x : candidates)
			if(x.name().equals(name)){
				List<TypeReference> parameters = x.parameters();
				if(parameters.size() != args.size())
					continue;
				for(int i = 0; i < parameters.size(); i++)
					if(args.get(i).fit(parameters.get(i)) == null)
						continue candidates;
				found = x;
				break;
			}
		if(found == null) // TODO: return null and check in CallValue to allow for pass expressions
			throw new IllegalStateException("Could not find method " + name + " given candidates [" + candidates.stream().map(x -> x.name() + x.descriptor()).collect(Collectors.joining(", ")) + "] for args of type [" + args.stream().map(Value::type).map(TypeReference::fullyQualifiedName).collect(Collectors.joining(", ")) + "]");
		return found;
	}
	
	public static CallableReference resolveConstructor(TypeReference of, List<Value> args, CallableReference from){
		// TODO: constructor overloading (this(...), super(...))
		CallableReference found = null;
		candidates:
		for(var x : of.constructors()){
			if(x.parameters().size() != args.size())
				continue;
			for(int i = 0; i < x.parameters().size(); i++)
				if(args.get(i).fit(x.parameters().get(i)) == null)
					continue candidates;
			found = x;
			break;
		}
		if(found == null)  // TODO: return null and check in CallValue to allow for pass expressions
			throw new IllegalStateException("Could not find constructor for type " + of.fullyQualifiedName() + " given candidates [" + of.constructors().stream().map(CallableReference::descriptor).collect(Collectors.joining(", ")) + "] for args of type [" + args.stream().map(Value::type).map(TypeReference::fullyQualifiedName).collect(Collectors.joining(", ")) + "]");
		return found;
	}
	
	public static MethodReference resolveSingleMethod(String from, String name, boolean isStatic, String... args){
		return resolveSingleMethod(TypeResolver.resolve(from), name, isStatic, Arrays.stream(args).map(TypeResolver::resolve).toArray(TypeReference[]::new));
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
}