package cyclic.lang.compiler;

import cyclic.lang.compiler.model.Utils;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Stack;

/**
 * Thrown when the Cyclic compiler encounters invalid code that is not a syntax error.
 */
public class CompileTimeException extends RuntimeException{
	
	private static String curFile;
	private static Stack<Context> curText = new Stack<>();
	private Context ctx;
	
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
	
	public static void pushContext(ParserRuleContext context){
		curText.push(context == null ? null : new Context(Utils.format(context), context.start.getLine(), context.start.getCharPositionInLine()));
	}
	
	public static void popContext(){
		curText.pop();
	}
	
	public String getMessage(){
		var message = "Error in class \"" + curFile + "\"";
		Context c = ctx;
		if(c == null && curText.size() > 0)
			c = curText.peek();
		if(c != null)
			message += ", at " + c;
		String details = super.getMessage();
		if(details != null && !details.isBlank())
			message += "\n\t" + details;
		return message;
	}
	
	public record Context(String text, int line, int start){
		
		public String toString(){
			return "[%d:%d]\n%s".formatted(line(), start(), text());
		}
	}
}