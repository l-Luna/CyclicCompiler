package cyclic.lang.compiler.model.cyclic;

import cyclic.lang.compiler.model.RecordComponentReference;
import cyclic.lang.compiler.model.TypeReference;

public record CyclicRecordComponent
		(CyclicType in, String name, TypeReference type, CyclicField field, CyclicMethod accessor)
		implements RecordComponentReference{}