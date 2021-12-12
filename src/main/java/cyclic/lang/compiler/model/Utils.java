package cyclic.lang.compiler.model;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.external.SystemTypeRef;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import org.antlr.v4.runtime.RuleContext;
import org.objectweb.asm.Opcodes;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

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
	
	// may be a primitive type
	public static TypeReference forAnyClass(Class<?> type){
		if(byte.class.equals(type))
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
		else
			return new SystemTypeRef(type);
	}
}