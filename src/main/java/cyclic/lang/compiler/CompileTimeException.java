package cyclic.lang.compiler;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Thrown when the Cyclic compiler encounters invalid code that is not a syntax error.
 */
public class CompileTimeException extends RuntimeException{
	
	private static String curFile;
	private static Stack<Context> curText = new Stack<>();
	
	public CompileTimeException(ParserRuleContext context, String message){
		super(message);
		pushContext(context);
	}
	
	public CompileTimeException(String message){
		super(message);
	}
	
	public static void setFile(String filename){
		curFile = filename;
	}
	
	public static void pushContext(ParserRuleContext context){
		curText.push(context == null ? null : new Context(getAllTokens(context).stream().map(ParseTree::getText).collect(Collectors.joining(" ")), context.start.getLine(), context.start.getCharPositionInLine()));
	}
	
	private static List<TerminalNode> getAllTokens(ParserRuleContext ctx){
		var ret = new ArrayList<TerminalNode>();
		if(ctx.children != null)
			for(var child : ctx.children)
				if(child instanceof TerminalNode t)
					ret.add(t);
				else if(child instanceof ParserRuleContext r)
					ret.addAll(getAllTokens(r));
		return ret;
	}
	
	public static void popContext(){
		curText.pop();
	}
	
	public String getMessage(){
		var message = "Error in class \"" + curFile + "\"";
		if(curText.peek() != null)
			message += ", at " + curText.peek();
		String details = super.getMessage();
		if(details != null && !details.isBlank())
			message += ": " + details;
		return message;
	}
	
	private record Context(String text, int line, int start){
		
		public String toString(){
			return "[%d:%d] \"%s\"".formatted(line(), start(), text());
		}
	}
}