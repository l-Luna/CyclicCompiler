package cyclic.lang.compiler.problems;

import cyclic.lang.compiler.model.Utils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.NotNull;

import java.util.Stack;

/**
 * Thrown when the Cyclic compiler encounters invalid code that is not a syntax error.
 */
public class CompileTimeException extends RuntimeException{
	
	private static String curFile;
	private static Stack<@NotNull Context> curText = new Stack<>();
	private @NotNull Context ctx;
	
	public CompileTimeException(ParserRuleContext context, String message){
		super(message);
		pushContext(context);
		ctx = curText.peek();
		popContext();
	}
	
	public CompileTimeException(String message){
		this(null, message);
	}
	
	public static void setFile(String filename){
		curFile = filename;
	}
	
	public static String getFile(){
		return curFile;
	}
	
	public static void pushContext(ParserRuleContext context){
		curText.push(context == null ?
				/* still need to show correct file */
				new Context(null, curFile, -1, -1) :
				new Context(context, curFile, context.start.getLine(), context.start.getCharPositionInLine()));
	}
	
	public static void popContext(){
		curText.pop();
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
	
	public record Context(ParserRuleContext text, String filename, int line, int start){
		
		public String toString(){
			return "[%d:%d]\n%s".formatted(line(), start(), Utils.format(text()));
		}
	}
}