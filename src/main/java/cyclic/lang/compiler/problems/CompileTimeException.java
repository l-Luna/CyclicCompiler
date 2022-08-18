package cyclic.lang.compiler.problems;

import cyclic.lang.compiler.model.Utils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.NotNull;

import java.util.Stack;

/**
 * Thrown when the Cyclic compiler encounters invalid code that is not a syntax error.
 */
public class CompileTimeException extends RuntimeException{
	
	private static final ThreadLocal<String> curFile = new ThreadLocal<>();
	private static final ThreadLocal<Stack<@NotNull Context>> curText = ThreadLocal.withInitial(Stack::new);
	private @NotNull Context ctx;
	
	public CompileTimeException(ParserRuleContext context, String message){
		super(message);
		pushContext(context);
		ctx = curText.get().peek();
		popContext();
	}
	
	public CompileTimeException(String message){
		super(message);
		ctx = curText.get().peek();
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
			message += "\n\t" + details;
		return message;
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
			return "[%d:%d]\n%s".formatted(line(), start(), Utils.format(text()));
		}
	}
}