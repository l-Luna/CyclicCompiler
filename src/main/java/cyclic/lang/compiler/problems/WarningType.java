package cyclic.lang.compiler.problems;

public enum WarningType{
	DEPRECATION("deprecation"),
	
	MUST_USE("must_use"),
	IMPOSSIBLE_MUST_USE("impossible_must_use"),
	
	IMPOSSIBLE_CAST("impossible_cast"),
	IMPOSSIBLE_INSTANCEOF("impossible_instanceof"),
	GUARANTEED_INSTANCEOF("guaranteed_instanceof");
	
	public final String ID;
	
	WarningType(String id){
		ID = id;
	}
}
