package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicField;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.generic.ParameterizedMethodRef;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;

import java.util.List;
import java.util.Map;

import static cyclic.lang.compiler.model.instructions.Value.*;

public final class EnumMembers{
	
	// generate values(), valueOf(String), entries()
	
	public static CyclicField genValuesField(CyclicType of){
		var ret = new CyclicField(of,
				"~values",
				new AccessFlags(Visibility.PRIVATE, false, true),
				true,
				false,
				new ArrayTypeRef(of));
		ret.defaultVal = new NewListedArrayValue(of.fields()
				.stream()
				.filter(FieldReference::isEnumDefinition)
				.map(FieldValue::new)
				.map(Value.class::cast)
				.toList(),
				of);
		return ret;
	}
	
	public static CyclicMethod genValues(CyclicType of){
		ArrayTypeRef retType = new ArrayTypeRef(of);
		CyclicMethod method = new CyclicMethod(of,
				"values",
				new AccessFlags(Visibility.PUBLIC, false, false),
				retType,
				List.of());
		method.isSt = true;
		MethodReference clone = Utils.resolveSingleMethod("java.lang.Object", "clone", false);
		var expr = new ClassCastValue(
				new CallValue(
						new FieldValue(of.fields().stream().filter(x -> x.name().equals("~values")).findFirst().orElseThrow()),
						List.of(),
						clone),
				retType);
		method.body = new Statement.ReturnStatement(expr, method.methodScope, retType, method);
		return method;
	}
	
	public static CyclicMethod genValueOf(CyclicType of){
		TypeReference string = Utils.forAnyClass(String.class);
		CyclicMethod method = new CyclicMethod(of,
				"valueOf",
				new AccessFlags(Visibility.PUBLIC, false, false),
				of,
				List.of(string));
		method.parameterNames().set(0, "name");
		method.isSt = true;
		MethodReference valOf = Utils.
				resolveSingleMethod("java.lang.Enum", "valueOf", true, "java.lang.Class", "java.lang.String");
		// Enum.<T>valueOf(Class<T>, String)
		valOf = new ParameterizedMethodRef(valOf, Map.of(valOf.typeParameters().get(0), of), null);
		var expr = new ClassCastValue(
				new CallValue(null, List.of(
						new Value.ClassValue(of), new LocalVarValue(string, 0)),
						valOf),
				of);
		method.body = new Statement.ReturnStatement(expr, method.methodScope, of, method);
		return method;
	}
	
	public static CyclicField genEntriesField(CyclicType of){
		TypeReference listType = Utils.forAnyClass(List.class);
		// List ~entries = List.of(~values);
		var ret = new CyclicField(of,
				"~entries",
				new AccessFlags(Visibility.PRIVATE, false, true),
				true,
				false,
				listType);
		MethodReference asList = Utils.resolveSingleMethod("java.util.List", "of", true, "java.lang.Object[]");
		ret.defaultVal = new CallValue(
				null,
				List.of(new FieldValue(of.fields().stream().filter(x -> x.name().equals("~values")).findFirst().orElseThrow())),
				asList);
		return ret;
	}
	
	public static CyclicMethod genEntries(CyclicType of){
		TypeReference listType = Utils.forAnyClass(List.class);
		CyclicMethod method = new CyclicMethod(of,
				"entries",
				new AccessFlags(Visibility.PUBLIC, false, false),
				listType,
				List.of());
		method.isSt = true;
		var expr = new FieldValue(of.fields().stream().filter(x -> x.name().equals("~entries")).findFirst().orElseThrow());
		method.body = new Statement.ReturnStatement(expr, method.methodScope, listType, method);
		return method;
	}
}