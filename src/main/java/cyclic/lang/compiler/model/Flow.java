package cyclic.lang.compiler.model;

import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Contains utility methods for checking constant conditions of code.
 */
public final class Flow{
	
	/**
	 * An object used to represent <code>null</code> in {@linkplain Optional} values.
	 */
	public static final Object NULL_MARKER = new Object();
	
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
			case Value.NullLiteralValue ignored -> Optional.of(NULL_MARKER);
			case Value.FloatLiteralValue f -> Optional.of(f.value);
			case Value.DoubleLiteralValue d -> Optional.of(d.value);
			case Value.IntLiteralValue i -> i.isBool ? Optional.of(i.value == 1) : Optional.of(i.value);
			case Value.LongLiteralValue l -> Optional.of(l.value);
			case Value.StringLiteralValue str -> Optional.of(str.value);
			case Value.ClassValue l -> Optional.of(l.of);
			case Value.FieldValue f -> f.ref.isEnumDefinition() ? Optional.of(new EnumConstant(f.ref)) : Optional.empty();
			case Value.NewListedArrayValue n -> {
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
			case Statement.WhileStatement s -> firstMatching(s.success, condition);
			case Statement.DoWhileStatement s -> firstMatching(s.success, condition);
			case Statement.BlockStatement s -> s.contains.stream()
					.map(k -> firstMatching(k, condition))
					.filter(Optional::isPresent)
					.map(Optional::get)
					.findFirst();
			case Statement.IfStatement s -> firstMatching(s.success, condition)
					.or(() -> firstMatching(s.fail, condition));
			case Statement.ForStatement s -> firstMatching(s.start, condition)
					.or(() -> firstMatching(s.success, condition))
					.or(() -> firstMatching(s.increment, condition));
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
			case Statement.BlockStatement s -> s.contains.stream()
					.map(k -> guaranteedToRun(k, condition))
					.reduce(false, (x, y) -> x || y);
			case Statement.WhileStatement ignored -> false; // a while/for body is never guaranteed to run
			case Statement.ForStatement ignored -> false;
			case Statement.DoWhileStatement s -> guaranteedToRun(s.success, condition); // guaranteed to run at least once
			// only guaranteed if guaranteed on both branches
			case Statement.IfStatement s -> guaranteedToRun(s.success, condition) && guaranteedToRun(s.fail, condition);
		};
	}
	
	public static int minOccurrencesBefore(Statement body, Statement before, Predicate<Statement> condition, boolean forceEnter){
		return switch(body){
			case default -> body != before && condition.test(body) ? 1 : 0;
			case null -> 0;
			case Statement.BlockStatement s -> {
				var cont = new AtomicBoolean(true);
				yield s.contains.stream()
						.takeWhile(x -> cont.get() && (firstMatching(x, y -> y == before).isEmpty() || cont.getAndSet(false)))
						.mapToInt(k -> minOccurrencesBefore(k, before, condition, !cont.get()))
						.sum();
			}
			case Statement.WhileStatement s -> forceEnter ? minOccurrencesBefore(s.success, before, condition, false) : 0;
			case Statement.ForStatement s -> minOccurrencesBefore(s.start, before, condition, false) + (forceEnter ? minOccurrencesBefore(s.success, before, condition, false) + minOccurrencesBefore(s.increment, before, condition, false) : 0);
			case Statement.DoWhileStatement s -> minOccurrencesBefore(s.success, before, condition, false); // guaranteed to run at least once
			case Statement.IfStatement s -> {
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
		return guaranteedToRun(body, x -> x instanceof Statement.ReturnStatement || x instanceof Statement.ThrowStatement);
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
			case null -> {}
			case Statement.WhileStatement s -> visitTerminals(s.success, visitor);
			case Statement.DoWhileStatement s -> visitTerminals(s.success, visitor);
			case Statement.BlockStatement s -> s.contains.forEach(k -> visitTerminals(k, visitor));
			case Statement.IfStatement s -> {
				visitTerminals(s.success, visitor);
				visitTerminals(s.fail, visitor);
			}
			case Statement.ForStatement s -> {
				visitTerminals(s.start, visitor);
				visitTerminals(s.success, visitor);
				visitTerminals(s.increment, visitor);
			}
		}
	}
}