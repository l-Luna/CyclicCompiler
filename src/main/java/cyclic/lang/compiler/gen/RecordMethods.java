package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicConstructor;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.resolve.PlatformDependency;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cyclic.lang.compiler.Constants.OBJECT;

public final class RecordMethods{
	
	private static final Handle OBJECT_METHODS_BSM =
			new Handle(
					Opcodes.H_INVOKESTATIC,
					Constants.OBJECT_METHODS_INT,
					Constants.OBJECT_METHODS_BOOTSTRAP,
					Constants.OBJECT_METHODS_DESC,
					false
			);
	
	private static CyclicMethod genMethod(CyclicType record, String name, String descriptor, TypeReference returns, List<TypeReference> params){
		CyclicMethod method = new CyclicMethod(record, name, new AccessFlags(Visibility.PUBLIC, false, false), returns, params);
		String adjustedDesc = "(" + record.descriptor() + descriptor.substring(1);
		DynamicCallValue call = new DynamicCallValue(
				returns,
				mapListWithIndex(params, (type, localIdx) -> new Value.LocalVarValue(type, localIdx + 1)),
				OBJECT_METHODS_BSM,
				name,
				adjustedDesc);
		List<Object> constArgs = new ArrayList<>();
		constArgs.add(Type.getType(record.descriptor()));
		constArgs.add(record.recordComponents().stream().map(RecordComponentReference::name).collect(Collectors.joining(";")));
		constArgs.addAll(record.recordComponents().stream().map(RecordMethods::asHandle).toList());
		call.constArgs = constArgs;
		method.body = new Statement.ReturnStatement(call, method.methodScope, returns, method);
		return method;
	}
	
	public static CyclicMethod genEquals(CyclicType record){
		return genMethod(record, "equals", Constants.EQUALS_DESC, PlatformDependency.BOOLEAN, List.of(TypeResolver.resolveFq(OBJECT)));
	}
	
	public static CyclicMethod genHashCode(CyclicType record){
		return genMethod(record, "hashCode", Constants.HASHCODE_DESC, PlatformDependency.INT, List.of());
	}
	
	public static CyclicMethod genToString(CyclicType record){
		return genMethod(record, "toString", Constants.TO_STRING_DESC, TypeResolver.resolveFq(Constants.STRING), List.of());
	}
	
	public static CyclicConstructor genCtor(CyclicType record){
		CyclicConstructor ctor = new CyclicConstructor(record, record.recordComponents().stream().map(RecordComponentReference::type).toList(), record.recordComponents().stream().map(RecordComponentReference::name).toList());
		ctor.addParamVars();
		Statement.BlockStatement body = new Statement.BlockStatement(ctor.scope, ctor);
		body.from = ctor;
		body.contains = mapListWithIndex(record.recordComponents(),
				(x, idx) -> new Statement.AssignFieldStatement(ctor.scope, x.field(), null, new Value.LocalVarValue(x.type(), Utils.adjustVarIndex(ctor.scope, idx + 1)), ctor));
		ctor.body = body;
		return ctor;
	}
	
	@NotNull
	private static Handle asHandle(@NotNull RecordComponentReference ref){
		return asHandle(ref.field());
	}
	
	@NotNull
	private static Handle asHandle(@NotNull FieldReference ref){
		return new Handle(
				Opcodes.H_GETFIELD,
				ref.in().internalName(),
				ref.name(),
				ref.type().descriptor(),
				false
		);
	}
	
	private static <X, Y> Stream<Y> mapWithIndex(@NotNull List<X> in, BiFunction<? super X, Integer, Y> mapper){
		AtomicInteger idx = new AtomicInteger(0);
		return in.stream().map(x -> mapper.apply(x, idx.getAndIncrement()));
	}
	
	private static <X, Y> List<Y> mapListWithIndex(@NotNull List<X> in, BiFunction<? super X, Integer, Y> mapper){
		return mapWithIndex(in, mapper).toList();
	}
}