package cyclic.lang.compiler.problems;

public enum ProblemType{
	DEPRECATION("deprecation"),
	MUST_USE("must_use"),
	IMPOSSIBLE_MUST_USE("impossible_must_use"),
	IMPOSSIBLE_CAST("impossible_cast");
	
	public final String ID;
	
	ProblemType(String id){
		ID = id;
	}
}
