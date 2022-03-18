package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;

import java.util.List;

import static cyclic.lang.compiler.model.instructions.Value.*;

public final class EnumMethods{
	
	// generate values(), valueOf(String), entries()
	
	public static CyclicMethod genValueOf(CyclicType of){
		TypeReference string = Utils.forAnyClass(String.class);
		CyclicMethod method = new CyclicMethod(
				of,
				"valueOf",
				new AccessFlags(Visibility.PUBLIC, false, false),
				of,
				List.of(string));
		method.parameterNames().set(0, "name");
		method.isSt = true;
		MethodReference valOf = Utils.
				resolveSingleMethod("java.lang.Enum", "valueOf", true, "java.lang.Class", "java.lang.String");
		var expr = new ClassCastValue(
				new CallValue(null, List.of(
						new Value.ClassValue(of), new LocalVarValue(string, 0)),
						valOf),
				of);
		method.body = new Statement.ReturnStatement(expr, method.methodScope, of, method);
		return method;
	}
}