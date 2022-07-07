package cyclic.lang.compiler;

import cyclic.lang.compiler.configuration.dependencies.PlatformDependency;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicMember;
import cyclic.lang.compiler.model.instructions.Statement;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

/**
 * Handles non-fatal issues.
 */
public class ProblemsHolder{
	
	// TODO: store warnings for later
	public static int numWarnings = 0;
	public static Set<String> suppressIds = new HashSet<>();
	
	public static void warnFrom(String id, String warning, @Nullable Object in, @Nullable ParserRuleContext location){
		if(in instanceof Statement st)
			in = st.from;
		if(in instanceof CyclicMember st
				&& (st.suppressedWarnings().contains(id)
				|| st.in() instanceof CyclicMember cyc && cyc.suppressedWarnings().contains(id)))
			return;
		suppressIds.add(id);
		warn(warning, location);
	}
	
	public static void warn(String warning, @Nullable ParserRuleContext location){
		String quote = location != null ? Utils.format(location) : null;
		var message = "Warning in class \"" + CompileTimeException.getFile() + "\"";
		if(location != null)
			message += ", at [%d:%d]\n%s".formatted(location.start.getLine(), location.start.getCharPositionInLine(), quote);
		if(warning != null && !warning.isBlank())
			message += "\n\t" + warning;
		
		System.err.println(message);
		numWarnings++;
	}
	
	public static void checkReference(MemberReference ref, @Nullable Statement in, @Nullable ParserRuleContext location){
		if(ref instanceof AnnotatableElement ae && ae.getAnnotationByName(Constants.DEPRECATED).isPresent())
			warnFrom(Constants.DEPRECATED_ID, "Use of deprecated member \"" + nameForWarning(ref) + "\"", in, location);
	}
	
	public static void checkMustUse(MethodReference ref, @Nullable Statement in, @Nullable ParserRuleContext location){
		if(!ref.returns().equals(PlatformDependency.VOID))
			ref.getAnnotationByName(Constants.MUST_USE).ifPresent(tag -> {
				String warning = "Ignored return value must be used";
				var value = tag.arguments().get("value");
				if(value instanceof String s && !s.isBlank())
					warning += ", because \"" + s + "\"";
				warnFrom(Constants.MUST_USE_ID, warning, in, location);
			});
	}
	
	public static void checkImpossibleMustUse(MethodReference ref){
		ref.getAnnotationByName(Constants.MUST_USE).ifPresent(tag -> {
			if(ref.returns().equals(PlatformDependency.VOID))
				warnFrom(Constants.IMPOSSIBLE_MUST_USE_ID, "@MustUse annotation cannot be fulfilled for void method \"" + nameForWarning(ref) + "\"", ref, null);
		});
	}
	
	public static void checkImpossibleCast(TypeReference obj, TypeReference target, @Nullable Statement in, @Nullable ParserRuleContext location){
		if(!obj.isAssignableTo(target) && !target.isAssignableTo(obj))
			warnFrom(Constants.IMPOSSIBLE_CAST_ID, "Values of type \"%s\" cannot be cast to \"%s\"".formatted(obj.fullyQualifiedName(), target.fullyQualifiedName()), in, location);
	}
	
	private static String nameForWarning(MemberReference ref){
		return switch(ref){
			case TypeReference tr -> tr.shortName();
			case CallableReference cr -> cr.summary();
			case FieldReference fr -> fr.name();
			case RecordComponentReference rcr -> rcr.name();
			default -> throw new IllegalStateException("Unexpected value: " + ref);
		};
	}
}