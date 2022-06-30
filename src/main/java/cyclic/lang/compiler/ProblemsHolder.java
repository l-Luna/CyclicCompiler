package cyclic.lang.compiler;

import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.instructions.Statement;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.Nullable;

/**
 * Handles non-fatal issues in code.
 */
public class ProblemsHolder{
	
	// TODO: store warnings for later
	public static int numWarnings = 0;
	
	public static void warnFrom(String id, String warning, @Nullable Statement in, @Nullable ParserRuleContext location){
		if(in != null){
			if(in.from.suppressedWarnings().contains(id) || in.from.in() instanceof CyclicType cyc && cyc.suppressedWarnings().contains(id))
				return;
		}
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
		if(ref instanceof AnnotatableElement ae
				&& ae.annotations().stream().anyMatch(u -> u.annotationType().fullyQualifiedName().equals(Constants.DEPRECATED))){
			warnFrom(Constants.SUPPRESS_DEPRECTAED, "Use of deprecated member \"" + nameForWarning(ref) + "\"", in, location);
		}
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