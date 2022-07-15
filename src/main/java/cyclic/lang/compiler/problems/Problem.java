package cyclic.lang.compiler.problems;

import cyclic.lang.compiler.model.MemberReference;
import cyclic.lang.compiler.model.Utils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public sealed interface Problem{
	
	String description();
	
	Source from();
	
	record Error(String description, Source from) implements Problem{}
	
	record Warning(String description, @Nullable Source from, WarningType type) implements Problem{}
	
	record Source(Position start, @Nullable Position end, @Nullable String snippet, @Nullable MemberReference owner){
		
		public static Source fromCtx(@NotNull ParserRuleContext ctx){
			return new Source(
					Position.fromToken(ctx.start),
					Position.fromTokenEnd(ctx.stop),
					Utils.format(ctx),
					null
			);
		}
		
		public static Source fromCtxNullable(@Nullable ParserRuleContext ctx){
			return ctx != null ? fromCtx(ctx) : null;
		}
		
		public Source withOwner(@Nullable MemberReference newOwner){
			return new Source(start(), end(), snippet(), newOwner);
		}
	}
	
	record Position(int line, int column){
		
		public static Position fromToken(Token token){
			return new Position(token.getLine(), token.getCharPositionInLine());
		}
		
		public static Position fromTokenEnd(Token token){
			return new Position(token.getLine(), token.getCharPositionInLine() + (token.getStopIndex() - token.getStartIndex()));
		}
	}
}