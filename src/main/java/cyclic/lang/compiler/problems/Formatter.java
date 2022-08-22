package cyclic.lang.compiler.problems;

import cyclic.lang.compiler.CompilerLauncher;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.jetbrains.annotations.NotNull;

public final class Formatter{
	
	public static final String COLOR_RESET = ifEnabled("\u001B[0m");
	public static final String COLOR_ORANGE = ifEnabled("\u001B[38:5:208m");
	public static final String COLOR_YELLOW = ifEnabled("\u001B[33m");
	public static final String COLOR_CYAN = ifEnabled("\u001B[36m");
	public static final String COLOR_WHITE = ifEnabled("\u001B[0;97m");
	
	public static String renderHighlight(@NotNull ParserRuleContext ctx){
		// assuming the highlight is one line...
		CharStream stream = ctx.start.getInputStream();
		int startIdx = ctx.start.getStartIndex(), endIdx = ctx.stop.getStopIndex();
		int sdiff = 0;
		
		while(startIdx > 0 && !stream.getText(new Interval(startIdx, startIdx)).equals("\n")){
			startIdx--;
			sdiff++;
		}
		while(endIdx < (stream.size() - 1) && !stream.getText(new Interval(endIdx, endIdx)).equals("\n"))
			endIdx++;
		
		String line = stream.getText(new Interval(startIdx + 1, endIdx - 1)).replace("\t", " ");
		String highlight = " ".repeat(sdiff - 1) + COLOR_CYAN + "^".repeat(ctx.stop.getStopIndex() - ctx.start.getStartIndex() + 1);
		return COLOR_CYAN + pad(ctx.getStart().getLine()) + "| " + COLOR_WHITE + (line + "\n     " + highlight).stripIndent().stripTrailing();
	}
	
	private static String pad(int n){
		var s = String.valueOf(n);
		return s + " ".repeat(3 - s.length());
	}
	
	private static String ifEnabled(String code){
		return CompilerLauncher.colouredOutput ? code : "";
	}
}