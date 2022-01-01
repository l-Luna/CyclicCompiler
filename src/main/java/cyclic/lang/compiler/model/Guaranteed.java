package cyclic.lang.compiler.model;

import cyclic.lang.compiler.model.instructions.Value;

import java.util.Optional;

/**
 * Contains utility methods for checking constant conditions of code.
 */
public final class Guaranteed{
	
	/**
	 * An object used to represent <code>null</code> in {@linkplain Optional} values.
	 */
	public static final Object NULL_MARKER = new Object();
	
	/**
	 * Returns the compile-time constant value represented by the given value, or {@linkplain Optional#empty()} if it is not a
	 * compile-time constant.
	 * <p>Constant <code>null</code> values return an {@linkplain Optional} value containing {@linkplain Guaranteed#NULL_MARKER}.
	 * Enum values are represented by an {@linkplain EnumConstant} value. Primitive and {@linkplain String} values are represented
	 * by themselves.
	 *
	 * @param v
	 * 		The value that might be a constant.
	 * @return An {@linkplain Optional} containing the constant value of the given value if it is constant.
	 */
	public static Optional<?> constant(Value v){
		return switch(v){
			case Value.NullLiteralValue ignored -> Optional.of(NULL_MARKER);
			case Value.FloatLiteralValue f -> Optional.of(f.value);
			case Value.DoubleLiteralValue d -> Optional.of(d.value);
			case Value.IntLiteralValue i -> i.isBool ? Optional.of(i.value == 1) : Optional.of(i.value);
			case Value.LongLiteralValue l -> Optional.of(l.value);
			case Value.StringLiteralValue str -> Optional.of(str.value);
			case Value.ClassValue l -> Optional.of(l.of);
			case Value.FieldValue f -> f.ref.isEnumDefinition() ? Optional.of(new EnumConstant(f.ref)) : Optional.empty();
			case null, default -> Optional.empty();
		};
	}
}