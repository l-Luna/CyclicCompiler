package cyclic.lang.compiler.model.jdk;

import cyclic.lang.compiler.model.*;

import java.lang.reflect.RecordComponent;

public class JdkRecordComponentRef implements RecordComponentReference{
	private RecordComponent underlying;
	private FieldReference field;
	private MethodReference accessor;
	
	public JdkRecordComponentRef(RecordComponent underlying){
		this.underlying = underlying;
	}
	
	public TypeReference in(){
		return Utils.forAnyClass(underlying.getDeclaringRecord());
	}
	
	public String name(){
		return underlying.getName();
	}
	
	public TypeReference type(){
		return Utils.forAnyClass(underlying.getType());
	}
	
	public FieldReference field(){
		return field != null ? field : (field = type().fields().stream().filter(x -> x.name().equals(name())).findFirst().orElseThrow());
	}
	
	public MethodReference accessor(){
		// TODO: share with the JdkTypeRef?
		return accessor != null ? accessor : (accessor = new JdkMethodRef(underlying.getAccessor()));
	}
}