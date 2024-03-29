package cyclic.lang.compiler.problems;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.BitSet;

public class SyntaxException extends RuntimeException{
	
	public static final ThreadLocal<String> curFile = new ThreadLocal<>();
	
	private final String file;
	private final Token error;
	private final String msg;
	
	public SyntaxException(String file, Token error, String msg){
		this.file = file;
		this.error = error;
		this.msg = msg;
	}
	
	public String getMessage(){
		return "Syntax error in %s at [%d:%d]: %s".formatted(file, error.getLine(), error.getStartIndex(), msg);
	}
	
	public static class SyntaxErrorListener implements ANTLRErrorListener{
		
		public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
			throw new SyntaxException(curFile.get(), (Token)offendingSymbol, msg);
		}
		
		public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs){}
		public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs){}
		public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs){}
	}
}