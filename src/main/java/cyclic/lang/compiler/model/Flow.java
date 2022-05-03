package cyclic.lang.compiler.model;

import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Statement.TryCatchStatement.CatchStatement;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.model.instructions.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static cyclic.lang.compiler.model.instructions.Statement.*;
import static cyclic.lang.compiler.model.instructions.Value.*;

/**
 * Contains utility methods for checking constant conditions of code.
 */
public final class Flow{
	
	/**
	 * An object used to represent <code>null</code> in {@linkplain Optional} values.
	 */
	public static final Object NULL_MARKER = new Object();
	
	public static final Predicate<Statement> WILL_EXIT = x -> x instanceof ReturnStatement || x instanceof ThrowStatement;
	
	/**
	 * Returns the compile-time constant value represented by the given value, or {@linkplain Optional#empty()} if it is not a
	 * compile-time constant.
	 * <p>Constant <code>null</code> values return an Optional containing {@linkplain Flow#NULL_MARKER}.
	 * Enum values are represented by an {@linkplain EnumConstant} value, class values are represented by a {@linkplain TypeReference},
	 * and arrays of constants are represented as an array of constant descriptors.
	 * Primitive and {@linkplain String} values are represented by themselves.
	 *
	 * @param v
	 * 		The value that might be a constant.
	 * @return An {@linkplain Optional} containing the constant value of the given value if it is constant.
	 */
	public static Optional<?> constantValue(Value v){
		return switch(v){
			case null, default -> Optional.empty();
			case NullLiteralValue ignored -> Optional.of(NULL_MARKER);
			case FloatLiteralValue f -> Optional.of(f.value);
			case DoubleLiteralValue d -> Optional.of(d.value);
			case IntLiteralValue i -> i.isBool ? Optional.of(i.value == 1) : Optional.of(i.value);
			case LongLiteralValue l -> Optional.of(l.value);
			case StringLiteralValue str -> Optional.of(str.value);
			case Value.ClassValue l -> Optional.of(l.of);
			case FieldValue f -> f.ref.isEnumDefinition() ? Optional.of(new EnumConstant(f.ref)) : Optional.empty();
			case NewListedArrayValue n -> {
				var opts = n.entries.stream().map(Flow::constantValue).toList();
				if(opts.stream().anyMatch(Optional::isEmpty))
					yield Optional.empty();
				//noinspection OptionalGetWithoutIsPresent
				yield Optional.of(opts.stream().map(Optional::get).toArray());
			}
		};
	}
	
	/**
	 * Returns the first statement contained within the given statement (including the given statement) that matches the
	 * given condition, or an empty optional if none exist.
	 * <p>This includes conditional branches that are not guaranteed to be executed, such as a statement in the <code>else</code> branch
	 * of an <code>if</code> statement, or the body of a <code>while</code> loop.
	 *
	 * @param body
	 * 		The statement to look for matching statements in.
	 * @param condition
	 * 		The condition that a statement must pass to be returned.
	 * @return The first child statement that matches the given predicate.
	 */
	public static Optional<Statement> firstMatching(Statement body, Predicate<Statement> condition){
		// TODO: consider "do{ ...; yield ...; }" values
		if(condition.test(body))
			return Optional.of(body);
		return switch(body){
			case null, default -> Optional.empty();
			case WhileStatement s -> firstMatching(s.success, condition);
			case DoWhileStatement s -> firstMatching(s.success, condition);
			case BlockStatement s -> s.contains.stream()
					.map(k -> firstMatching(k, condition))
					.filter(Optional::isPresent)
					.map(Optional::get)
					.findFirst();
			case IfStatement s -> firstMatching(s.success, condition)
					.or(() -> firstMatching(s.fail, condition));
			case ForStatement s -> firstMatching(s.start, condition)
					.or(() -> firstMatching(s.success, condition))
					.or(() -> firstMatching(s.increment, condition));
			case TryCatchStatement s -> firstMatching(s.tryStatement, condition)
					.or(() -> s.catchStatements.stream()
							.map(k -> firstMatching(k.onCatch(), condition))
							.filter(Optional::isPresent)
							.map(Optional::get)
							.findFirst())
					.or(() -> s.finallyStatement != null ? firstMatching(s.finallyStatement, condition) : Optional.empty());
		};
	}
	
	/**
	 * Checks if every code path in the given statement is guaranteed to execute at least one statement that matches
	 * the given condition.
	 *
	 * @param body
	 * 		The statement to look for matching statements in.
	 * @param condition
	 * 		The condition that a statement must pass to be returned.
	 * @return Whether a child of the given statement will always match the given condition.
	 */
	@SuppressWarnings("DuplicateBranchesInSwitch") // can't merge type pattern cases
	public static boolean guaranteedToRun(Statement body, Predicate<Statement> condition){
		return switch(body){
			case default -> condition.test(body);
			case null -> false;
			case BlockStatement s -> s.contains.stream().anyMatch(k -> guaranteedToRun(k, condition));
			case WhileStatement ignored -> false; // a while/for body is never guaranteed to run
			case ForStatement ignored -> false;
			case DoWhileStatement s -> guaranteedToRun(s.success, condition); // guaranteed to run at least once
			// only guaranteed if guaranteed on both branches
			case IfStatement s -> guaranteedToRun(s.success, condition) && guaranteedToRun(s.fail, condition);
			// only guaranteed if guaranteed in try block and all catch blocks OR in finally block
			case TryCatchStatement s -> (guaranteedToRun(s.tryStatement, condition) && s.catchStatements.stream()
					.allMatch(k -> guaranteedToRun(k.onCatch(), condition)))
			                            || (s.finallyStatement != null && guaranteedToRun(s.finallyStatement, condition));
		};
	}
	
	// everything from here could do with rewriting
	
	public static Predicate<Statement> willAssignToIndex(int adjIndex){
		return x -> x instanceof VarStatement vs
				&& vs.value != null
				&& vs.v.getAdjIndex() == adjIndex;
	}
	
	public static Predicate<Statement> willAssignToVariable(Variable v){
		return x -> {
			return x instanceof VarStatement vs
					&& vs.value != null
					&& vs.v.equals(v);
		};
	}
	
	public static int minOccurrencesBefore(Statement body, Statement before, Predicate<Statement> condition, boolean forceEnter){
		return switch(body){
			case default -> body != before && condition.test(body) ? 1 : 0;
			case null -> 0;
			case BlockStatement s -> {
				// take all statements until the statement containing the `before` statement
				// forceEnter for the statement containing the `before` statement to narrow down checking within
				var cont = new AtomicBoolean(true);
				yield s.contains.stream()
						.takeWhile(x -> cont.get() && (firstMatching(x, y -> y == before).isEmpty() || cont.getAndSet(false)))
						.mapToInt(k -> minOccurrencesBefore(k, before, condition, !cont.get()))
						.sum();
			}
			case WhileStatement s -> forceEnter ? minOccurrencesBefore(s.success, before, condition, false) : 0;
			case ForStatement s -> minOccurrencesBefore(s.start, before, condition, false)
					+ (forceEnter ? minOccurrencesBefore(s.success, before, condition, false) + minOccurrencesBefore(s.increment, before, condition, false) : 0);
			case DoWhileStatement s -> minOccurrencesBefore(s.success, before, condition, false); // guaranteed to run at least once
			case IfStatement s -> {
				if(forceEnter){
					if(s.fail == null)
						yield minOccurrencesBefore(s.success, before, condition, false);
					// could be entering either branch
					if(firstMatching(s.success, y -> y == before).isPresent())
						yield minOccurrencesBefore(s.success, before, condition, false);
					else
						yield minOccurrencesBefore(s.fail, before, condition, false);
				}
				yield Math.min(minOccurrencesBefore(s.success, before, condition, false), minOccurrencesBefore(s.fail, before, condition, false));
			}
			case TryCatchStatement s -> {
				// forceEnter is meaningless here since there can be many catch blocks
				// same applies to switch statements, so we'll need a proper fix eventually
				// minimum of all branches, plus any from finally block, which runs alongside other occurrences
				List<Statement> branches = new ArrayList<>(s.catchStatements.size() + 1);
				branches.add(s.tryStatement);
				for(CatchStatement statement : s.catchStatements)
					branches.add(statement.onCatch());
				if(forceEnter){
					for(Statement branch : branches)
						if(firstMatching(branch, y -> y == before).isPresent())
							yield minOccurrencesBefore(branch, before, condition, false);
					if(s.finallyStatement != null && firstMatching(s.finallyStatement, y -> y == before).isPresent())
						yield minOccurrencesBefore(s.finallyStatement, before, condition, false);
					throw new IllegalStateException("Tried to force enter a try/catch statement with no matching branches");
				}else{
					int fromFinally = s.finallyStatement != null ? minOccurrencesBefore(s.finallyStatement, before, condition, false) : 0;
					yield branches.stream()
							.mapToInt(k -> minOccurrencesBefore(k, before, condition, false))
							.min()
							.orElse(0) + fromFinally;
				}
			}
		};
	}
	
	public static Optional<Statement> possibleOccurranceBefore(Statement body, Statement before, Predicate<Statement> condition, boolean forceEnter){
		return switch(body){
			case default -> body != before && condition.test(body) ? Optional.of(body) : Optional.empty();
			case null -> Optional.empty();
			case BlockStatement s -> {
				// take all statements until the statement containing the `before` statement
				// forceEnter for the statement containing the `before` statement to narrow down checking within
				var cont = new AtomicBoolean(true);
				for(Statement contain : s.contains){
					System.out.println(contain + " " + possibleOccurranceBefore(contain, before, condition, forceEnter));
				}
				System.out.println();
				yield s.contains.stream()
						.takeWhile(x -> cont.get() && (firstMatching(x, y -> y == before).isEmpty() || cont.getAndSet(false)))
						.map(k -> possibleOccurranceBefore(k, before, condition, !cont.get()))
						.flatMap(x -> Stream.ofNullable(x.orElse(null)))
						.findFirst();
			}
			// unlike minOccurrencesBefore, we don't really care about forceEnter here
			// we don't need to check if its *guaranteed*, just if it could under any circumstances ever maybe
			// essentially firstMatching but more precise
			case WhileStatement ws -> possibleOccurranceBefore(ws.success, before, condition, forceEnter);
			case ForStatement s -> {
				if(forceEnter){
					if(firstMatching(s.success, y -> y == before).isPresent())
						yield possibleOccurranceBefore(s.success, before, condition, false);
					else if(firstMatching(s.start, y -> y == before).isPresent())
						yield possibleOccurranceBefore(s.start, before, condition, false);
					else if(firstMatching(s.increment, y -> y == before).isPresent())
						yield possibleOccurranceBefore(s.increment, before, condition, false);
					else throw new IllegalStateException("Tried to force enter a for statement with no matching branches");
				}
				yield possibleOccurranceBefore(s.success, before, condition, false)
						.or(() -> possibleOccurranceBefore(s.start, before, condition, false))
						.or(() -> possibleOccurranceBefore(s.increment, before, condition, false));
			}
			case DoWhileStatement s -> possibleOccurranceBefore(s.success, before, condition, forceEnter);
			case IfStatement s -> {
				if(forceEnter){
					if(s.fail == null)
						yield possibleOccurranceBefore(s.success, before, condition, false);
					// could be entering either branch
					if(firstMatching(s.success, y -> y == before).isPresent())
						yield possibleOccurranceBefore(s.success, before, condition, false);
					else
						yield possibleOccurranceBefore(s.fail, before, condition, false);
				}
				yield possibleOccurranceBefore(s.success, before, condition, false)
						.or(() -> possibleOccurranceBefore(s.fail, before, condition, false));
			}
			case TryCatchStatement s -> {
				List<Statement> branches = new ArrayList<>(s.catchStatements.size() + 1);
				branches.add(s.tryStatement);
				if(s.finallyStatement != null)
					branches.add(s.finallyStatement);
				for(CatchStatement statement : s.catchStatements)
					branches.add(statement.onCatch());
				if(forceEnter){
					for(Statement branch : branches)
						if(firstMatching(branch, y -> y == before).isPresent())
							yield possibleOccurranceBefore(branch, before, condition, false);
					if(s.finallyStatement != null && firstMatching(s.finallyStatement, y -> y == before).isPresent())
						yield possibleOccurranceBefore(s.finallyStatement, before, condition, false);
					throw new IllegalStateException("Tried to force enter a try/catch statement with no matching branches");
				}
				Optional<Statement> fromFinally = s.finallyStatement != null
						? possibleOccurranceBefore(s.finallyStatement, before, condition, false)
						: Optional.empty();
				yield fromFinally.or(() -> branches.stream()
						.map(k -> possibleOccurranceBefore(k, before, condition, false))
						.flatMap(x -> Stream.ofNullable(x.orElse(null)))
						.findFirst());
			}
		};
	}
	
	/**
	 * Checks if the given statement is guaranteed to explicitly exit, either by returning or throwing an exception.
	 *
	 * @param body
	 * 		The statement to check.
	 * @return Whether the statement will always explicitly exit.
	 */
	public static boolean guaranteedToExit(Statement body){
		return guaranteedToRun(body, WILL_EXIT);
	}
	
	/**
	 * Runs the given visitor on every terminal statement of the given statement in order.
	 * <p>Terminal statements do not contain other statements, like {@code return} and call statements.
	 * Non-terminal statements contain other statements, like {@code if} and {@code for} statements, as well as
	 * block statements.
	 * <p>The contained (possibly nested) terminal statements of a non-terminal statement will be visited. Generated
	 * statements, like in a {@code for(var x : list)}, will also be visited. If the given statement is a terminal statement,
	 * it will be visited.
	 *
	 * @param body
	 * 		The statement to visit.
	 * @param visitor
	 * 		The action to perform on every terminal statement.
	 */
	public static void visitTerminals(Statement body, Consumer<Statement> visitor){
		switch(body){
			case default -> visitor.accept(body);
			case null -> {
				// no-op
			}
			case WhileStatement s -> visitTerminals(s.success, visitor);
			case DoWhileStatement s -> visitTerminals(s.success, visitor);
			case BlockStatement s -> s.contains.forEach(k -> visitTerminals(k, visitor));
			case IfStatement s -> {
				visitTerminals(s.success, visitor);
				visitTerminals(s.fail, visitor);
			}
			case ForStatement s -> {
				visitTerminals(s.start, visitor);
				visitTerminals(s.success, visitor);
				visitTerminals(s.increment, visitor);
			}
			case TryCatchStatement s -> {
				visitTerminals(s.tryStatement, visitor);
				for(CatchStatement statement : s.catchStatements)
					visitTerminals(statement.onCatch(), visitor);
				if(s.finallyStatement != null)
					visitTerminals(s.finallyStatement, visitor);
			}
		}
	}
}