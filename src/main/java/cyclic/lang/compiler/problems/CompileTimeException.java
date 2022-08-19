package cyclic.lang.compiler.problems;

import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Stack;

/**
 * Thrown when the Cyclic compiler encounters invalid code that is not a syntax error.
 */
public class CompileTimeException extends RuntimeException{
	
	private static final ThreadLocal<String> curFile = new ThreadLocal<>();
	private static final ThreadLocal<Stack<@NotNull Context>> curText = ThreadLocal.withInitial(Stack::new);
	private final @NotNull Context ctx;
	private final String @Nullable [] notes;
	
	public CompileTimeException(ParserRuleContext context, String message, String @Nullable ... notes){
		super(message);
		pushContext(context);
		ctx = curText.get().peek();
		popContext();
		this.notes = notes;
	}
	
	public CompileTimeException(String message){
		super(message);
		ctx = curText.get().peek();
		notes = null;
	}
	
	public static void setFile(String filename){
		curFile.set(filename);
	}
	
	public static String getCurrentFile(){
		return curFile.get();
	}
	
	public static void pushContext(ParserRuleContext context){
		curText.get().push(context == null ?
				/* still need to show correct file */
				new Context(null, getCurrentFile(), -1, -1) :
				new Context(context, getCurrentFile(), context.start.getLine(), context.start.getCharPositionInLine()));
	}
	
	public static void popContext(){
		curText.get().pop();
	}
	
	public String getMessage(){
		Context c = ctx;
		var message = "Error in class \"" + c.filename + "\"";
		if(c.line > -1)
			message += ", at " + c;
		String details = super.getMessage();
		if(details != null && !details.isBlank())
			message += "\n     " + Formatter.COLOR_YELLOW + details;
		if(notes != null)
			for(String note : notes)
				message += "\n     " + Formatter.COLOR_YELLOW + note;
		return message + Formatter.COLOR_RESET;
	}
	
	public String getErrorMessage(){
		return super.getMessage();
	}
	
	@NotNull
	public Context getCtx(){
		return ctx;
	}
	
	public record Context(ParserRuleContext text, String filename, int line, int start){
		
		public String toString(){
			return "[%d:%d]\n%s".formatted(line(), start(), Formatter.renderHighlight(text()));
		}
	}
}