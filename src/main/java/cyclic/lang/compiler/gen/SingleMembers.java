package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.model.AccessFlags;
import cyclic.lang.compiler.model.Utils;
import cyclic.lang.compiler.model.Visibility;
import cyclic.lang.compiler.model.cyclic.CyclicField;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.instructions.Value;

import java.util.List;

public class SingleMembers{
	
	// generate INSTANCE field
	// TODO: should we use an accessor method instead?
	
	public static CyclicField genInstanceField(CyclicType of){
		// public static final <type> INSTANCE
		var ret = new CyclicField(of,
				"INSTANCE",
				new AccessFlags(Visibility.PUBLIC, false, true),
				true,
				false,
				of);
		// = new <type>();
		ret.defaultVal = new Value.InitializationValue(List.of(),
				Utils.resolveConstructor(of, List.of(), of),
				of,
				of);
		return ret;
	}
}