package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.model.Flow;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import cyclic.lang.compiler.model.instructions.Statement;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import cyclic.lang.compiler.problems.CompileTimeException;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.LongBinaryOperator;

import static cyclic.lang.compiler.configuration.dependencies.PlatformDependency.*;

public final class Operations{
	
	private static List<OperationHandler> handlers = new ArrayList<>();
	
	static{
		var OBJECT = TypeResolver.resolveFq(Constants.OBJECT);
		var STRING = TypeResolver.resolveFq(Constants.STRING);
		
		// constant expressions; 1 + 1
		handlers.add(new ConstantOpHandler());
		
		// pass expressions; "3" |> Integer.parseInt()
		handlers.add(new PassOpHandler());
		
		// add, subtract, multiply, divide
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.PLUS), Set.of(INT),
				(l, r) -> new BinaryOpValue(INT, Opcodes.IADD, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.PLUS), Set.of(LONG),
				(l, r) -> new BinaryOpValue(LONG, Opcodes.LADD, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.PLUS), Set.of(FLOAT),
				(l, r) -> new BinaryOpValue(FLOAT, Opcodes.FADD, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.PLUS), Set.of(DOUBLE),
				(l, r) -> new BinaryOpValue(DOUBLE, Opcodes.DADD, l, r)));
		handlers.add(new TypeBasedOpHandler(
				Set.of(Op.PLUS),
				(l, r) -> l.isAssignableTo(STRING) || r.isAssignableTo(STRING),
				StringConcatValue::new));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MINUS), Set.of(INT),
				(l, r) -> new BinaryOpValue(INT, Opcodes.ISUB, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MINUS), Set.of(LONG),
				(l, r) -> new BinaryOpValue(LONG, Opcodes.LSUB, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MINUS), Set.of(FLOAT),
				(l, r) -> new BinaryOpValue(FLOAT, Opcodes.FSUB, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MINUS), Set.of(DOUBLE),
				(l, r) -> new BinaryOpValue(DOUBLE, Opcodes.DSUB, l, r)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MULTIPLY), Set.of(INT),
				(l, r) -> new BinaryOpValue(INT, Opcodes.IMUL, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MULTIPLY), Set.of(LONG),
				(l, r) -> new BinaryOpValue(LONG, Opcodes.LMUL, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MULTIPLY), Set.of(FLOAT),
				(l, r) -> new BinaryOpValue(FLOAT, Opcodes.FMUL, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MULTIPLY), Set.of(DOUBLE),
				(l, r) -> new BinaryOpValue(DOUBLE, Opcodes.DMUL, l, r)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.DIVIDE), Set.of(INT),
				(l, r) -> new BinaryOpValue(INT, Opcodes.IDIV, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.DIVIDE), Set.of(LONG),
				(l, r) -> new BinaryOpValue(LONG, Opcodes.LDIV, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.DIVIDE), Set.of(FLOAT),
				(l, r) -> new BinaryOpValue(FLOAT, Opcodes.FDIV, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.DIVIDE), Set.of(DOUBLE),
				(l, r) -> new BinaryOpValue(DOUBLE, Opcodes.DDIV, l, r)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MOD), Set.of(INT),
				(l, r) -> new BinaryOpValue(INT, Opcodes.IREM, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MOD), Set.of(LONG),
				(l, r) -> new BinaryOpValue(LONG, Opcodes.LREM, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MOD), Set.of(FLOAT),
				(l, r) -> new BinaryOpValue(FLOAT, Opcodes.FREM, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.MOD), Set.of(DOUBLE),
				(l, r) -> new BinaryOpValue(DOUBLE, Opcodes.DREM, l, r)));
		
		// short-circuiting operations
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.AND), Set.of(BOOLEAN),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFNE, l, null, r, null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.OR), Set.of(BOOLEAN),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFNE, l, null, null, r)));
		
		// bitwise operations
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.BITAND), Set.of(INT),
				(l, r) -> new BinaryOpValue(INT, Opcodes.IAND, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.BITAND), Set.of(BOOLEAN),
				(l, r) -> new BinaryOpValue(BOOLEAN, Opcodes.IAND, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.BITAND), Set.of(LONG),
				(l, r) -> new BinaryOpValue(LONG, Opcodes.LAND, l, r)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.BITOR), Set.of(INT),
				(l, r) -> new BinaryOpValue(INT, Opcodes.IOR, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.BITOR), Set.of(BOOLEAN),
				(l, r) -> new BinaryOpValue(BOOLEAN, Opcodes.IOR, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.BITOR), Set.of(LONG),
				(l, r) -> new BinaryOpValue(LONG, Opcodes.LOR, l, r)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.XOR), Set.of(INT),
				(l, r) -> new BinaryOpValue(INT, Opcodes.IXOR, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.XOR), Set.of(BOOLEAN),
				(l, r) -> new BinaryOpValue(BOOLEAN, Opcodes.IXOR, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.XOR), Set.of(LONG),
				(l, r) -> new BinaryOpValue(LONG, Opcodes.LXOR, l, r)));
		
		// bitshifts
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LEFTSHIFT), Set.of(INT),
				(l, r) -> new BinaryOpValue(INT, Opcodes.ISHL, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LEFTSHIFT), Set.of(LONG),
				(l, r) -> new BinaryOpValue(LONG, Opcodes.LSHL, l, r)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.RIGHTSHIFT), Set.of(INT),
				(l, r) -> new BinaryOpValue(INT, Opcodes.ISHR, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.RIGHTSHIFT), Set.of(LONG),
				(l, r) -> new BinaryOpValue(LONG, Opcodes.LSHR, l, r)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.URSHIFT), Set.of(INT),
				(l, r) -> new BinaryOpValue(INT, Opcodes.IUSHR, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.URSHIFT), Set.of(LONG),
				(l, r) -> new BinaryOpValue(LONG, Opcodes.LUSHR, l, r)));
		
		// object equality
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.EQUALS), Set.of(INT, BOOLEAN),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IF_ICMPEQ, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.EQUALS), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFEQ, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.EQUALS), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFEQ, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.EQUALS), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFEQ, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.EQUALS), Set.of(OBJECT), // op handlers are checked in order, this should only happen with objects or primitives w/ objects
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IF_ACMPEQ, l, r)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.NOTEQUALS), Set.of(INT, BOOLEAN),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IF_ICMPNE, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.NOTEQUALS), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFNE, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.NOTEQUALS), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFNE, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.NOTEQUALS), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFNE, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.NOTEQUALS), Set.of(OBJECT),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IF_ACMPNE, l, r)));
		
		// greater/eq, lesser/eq
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GEQ), Set.of(INT),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IF_ICMPGE, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GEQ), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFGE, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GEQ), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFGE, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GEQ), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFGE, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LEQ), Set.of(INT),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IF_ICMPLE, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LEQ), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFLE, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LEQ), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFLE, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LEQ), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFLE, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
		
		// greater, lesser
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GREATER), Set.of(INT),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IF_ICMPGT, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GREATER), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFGT, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GREATER), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFGT, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GREATER), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFGT, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LESSER), Set.of(INT),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IF_ICMPLT, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LESSER), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFLT, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LESSER), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFLT, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LESSER), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(Opcodes.IFLT, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
	}
	
	public static Op forSymbol(String symbol){
		for(var op : Op.values())
			if(op.symbol.equals(symbol))
				return op;
		throw new CompileTimeException("Unknown operation: " + symbol);
	}
	
	public static Value resolveBinary(String symbol, Value left, Value right, @Nullable ParserRuleContext expr){
		symbol = symbol.trim().replace(" ", ""); // normalize >> and <<
		Op op = forSymbol(symbol);
		for(var handler : handlers)
			if(handler.handles().contains(op))
				if(handler.validFor(left, right)){
					Value ret = handler.getFor(op, left, right);
					if(ret == null)
						continue;
					if(ret instanceof BinaryOpValue v)
						v.operation = op;
					return ret;
				}
		throw new CompileTimeException(expr, "Found no handlers for operation " + symbol + " that can handle values of types " + left.typeName() + " and " + right.typeName());
	}
	
	public static Value resolvePrefix(String symbol, Value value){
		symbol = symbol.trim();
		if(symbol.equals("+") && value.type() instanceof PrimitiveTypeRef prim && prim.isNumber())
			return value; // no effect from +
		else if(symbol.equals("!") && value.type() instanceof PrimitiveTypeRef prim && prim.type == PrimitiveTypeRef.Primitive.BOOLEAN)
			return new BranchBoolBinaryOpValue(Opcodes.IFEQ, value, null);
		else if(symbol.equals("-") && value.type() instanceof PrimitiveTypeRef prim && prim.isNumber())
			return new UnaryOpValue(prim, value, switch(prim.type){
				case BYTE, SHORT, INT -> Opcodes.INEG;
				case LONG -> Opcodes.LNEG;
				case FLOAT -> Opcodes.FNEG;
				case DOUBLE -> Opcodes.DNEG;
				default -> throw new IllegalStateException();
			});
		else if(symbol.equals("++") || symbol.equals("--"))
			return Value.createInlineAssignValue(value, resolveBinary(symbol.substring(1), value, new Value.IntLiteralValue(1), null));
		throw new IllegalStateException("Unable to apply prefix operator " + symbol + " to value of type " + value.typeName() + "!");
	}
	
	public static Value resolvePostfix(String symbol, Value value){
		symbol = symbol.trim();
		if(symbol.equals("++") || symbol.equals("--")){
			var inlineAssign = Value.createInlineAssignValue(value, resolveBinary(symbol.substring(1), value, new Value.IntLiteralValue(1), null));
			inlineAssign.returnPreAssign = true;
			inlineAssign.target = value;
			return inlineAssign;
		}
		throw new IllegalStateException("Unable to apply postfix operator " + symbol + " to value of type " + value.typeName() + "!");
	}
	
	public enum Op{
		PLUS("+"),
		MINUS("-"),
		DIVIDE("/"),
		MULTIPLY("*"),
		MOD("%"),
		AND("&&"),
		OR("||"),
		BITAND("&"),
		BITOR("|"),
		XOR("^"),
		LEFTSHIFT("<<"),
		RIGHTSHIFT(">>"),
		URSHIFT(">>>"),
		EQUALS("=="),
		NOTEQUALS("!="),
		GEQ(">="),
		LEQ("<="),
		GREATER(">"),
		LESSER("<"),
		PASS("|>");
		
		public final String symbol;
		
		Op(String symbol){
			this.symbol = symbol;
		}
	}
	
	public interface OperationHandler{
		Set<Op> handles();
		boolean validFor(Value left, Value right);
		Value getFor(Op op, Value left, Value right);
	}
	
	public static class TypeBasedOpHandler implements OperationHandler{
		Set<Op> handles;
		BiPredicate<TypeReference, TypeReference> validFqs;
		BinaryOperator<Value> producer;
		
		public TypeBasedOpHandler(Set<Op> handles, BiPredicate<TypeReference, TypeReference> validFqs, BinaryOperator<Value> producer){
			this.handles = handles;
			this.validFqs = validFqs;
			this.producer = producer;
		}
		
		public Set<Op> handles(){
			return handles;
		}
		
		public boolean validFor(Value left, Value right){
			return validFqs.test(left.type(), right.type());
		}
		
		public Value getFor(Op op, Value left, Value right){
			return producer.apply(left, right);
		}
	}
	
	public static class TypeSetOpHandler implements OperationHandler{
		Set<Op> handles;
		Set<TypeReference> validTypes;
		BinaryOperator<Value> producer;
		
		public TypeSetOpHandler(Set<Op> handles, Set<TypeReference> validTypes, BinaryOperator<Value> producer){
			this.handles = handles;
			this.validTypes = validTypes;
			this.producer = producer;
		}
		
		public Set<Op> handles(){
			return handles;
		}
		
		public boolean validFor(Value left, Value right){
			for(var target : validTypes)
				if(left.fit(target) != null && right.fit(target) != null)
					return true;
			return false;
		}
		
		public Value getFor(Op op, Value left, Value right){
			Value leftFit = null, rightFit = null;
			for(var target : validTypes){
				if(left.fit(target) != null)
					leftFit = left.fit(target);
				if(right.fit(target) != null)
					rightFit = right.fit(target);
			}
			return producer.apply(leftFit, rightFit);
		}
	}
	
	public static class ConstantOpHandler implements OperationHandler{
		
		public Set<Op> handles(){
			return EnumSet.allOf(Op.class);
		}
		
		public boolean validFor(Value left, Value right){
			return Flow.constantValue(left).isPresent() && Flow.constantValue(right).isPresent();
		}
		
		@SuppressWarnings("OptionalGetWithoutIsPresent") // checked in validFor
		public Value getFor(Op op, Value left, Value right){
			Object cl = Flow.constantValue(left).get();
			Object cr = Flow.constantValue(right).get();
			
			// widen bytes/shorts/chars into ints, then narrow them after
			if(cl instanceof Byte b)
				cl = (int)b;
			if(cl instanceof Short s)
				cl = (int)s;
			if(cl instanceof Character c)
				cl = (int)c;
			if(cr instanceof Byte b)
				cr = (int)b;
			if(cr instanceof Short s)
				cr = (int)s;
			if(cr instanceof Character c)
				cr = (int)c;
			
			Value value = switch(op){
				case PLUS ->
						cl instanceof String sl && cr instanceof String sr ? new Value.StringLiteralValue(sl + sr) :
						applyToNumbers(cl, cr, Long::sum, Double::sum);
				case MINUS -> applyToNumbers(cl, cr, (x, y) -> x - y, (x, y) -> x - y);
				case DIVIDE -> applyToNumbers(cl, cr, (x, y) -> x / y, (x, y) -> x / y);
				case MULTIPLY -> applyToNumbers(cl, cr, (x, y) -> x * y, (x, y) -> x / y);
				case MOD -> applyToNumbers(cl, cr, (x, y) -> x % y, (x, y) -> x % y);
				case GREATER -> applyBoolToNumbers(cl, cr, (x, y) -> x > y, (x, y) -> x > y);
				case GEQ -> applyBoolToNumbers(cl, cr, (x, y) -> x >= y, (x, y) -> x >= y);
				case LESSER -> applyBoolToNumbers(cl, cr, (x, y) -> x < y, (x, y) -> x < y);
				case LEQ -> applyBoolToNumbers(cl, cr, (x, y) -> x >= y, (x, y) -> x >= y);
				case EQUALS -> Value.IntLiteralValue.ofBoolean(cl.equals(cr));
				case NOTEQUALS -> Value.IntLiteralValue.ofBoolean(!cl.equals(cr));
				case default -> null;
			};
			
			// narrow back if needed
			// shush IJ
			//noinspection ConstantConditions
			if(value != null && value.type().equals(INT))
				//noinspection ConstantConditions
				if(!left.type().equals(INT) && !right.type().equals(INT))
					if(left.type().equals(CHAR) || right.type().equals(CHAR))
						return new Value.PrimitiveCastValue(value, PrimitiveTypeRef.Primitive.CHAR);
					else if(left.type().equals(SHORT) || right.type().equals(SHORT))
						return new Value.PrimitiveCastValue(value, PrimitiveTypeRef.Primitive.SHORT);
					else if(left.type().equals(BYTE) || right.type().equals(BYTE))
						return new Value.PrimitiveCastValue(value, PrimitiveTypeRef.Primitive.BYTE);
			
			return value;
		}
		
		private Value applyToNumbers(Object left, Object right, LongBinaryOperator applyIntegral, DoubleBinaryOperator applyFloating){
			if(left instanceof Integer il && right instanceof Integer ir)
				return new Value.IntLiteralValue((int)applyIntegral.applyAsLong(il, ir));
			if(left instanceof Long ll && right instanceof Long lr)
				return new Value.LongLiteralValue(applyIntegral.applyAsLong(ll, lr));
			if(left instanceof Float fl && right instanceof Float fr)
				return new Value.FloatLiteralValue((float)applyFloating.applyAsDouble(fl, fr));
			if(left instanceof Double dl && right instanceof Double dr)
				return new Value.DoubleLiteralValue(applyFloating.applyAsDouble(dl, dr));
			return null;
		}
		
		private Value applyBoolToNumbers(Object left, Object right, BiPredicate<Long, Long> applyIntegral, BiPredicate<Double, Double> applyFloating){
			if(left instanceof Integer il && right instanceof Integer ir)
				return Value.IntLiteralValue.ofBoolean(applyIntegral.test((long)il, (long)ir));
			if(left instanceof Long ll && right instanceof Long lr)
				return Value.IntLiteralValue.ofBoolean(applyIntegral.test(ll, lr));
			if(left instanceof Float fl && right instanceof Float fr)
				return Value.IntLiteralValue.ofBoolean(applyFloating.test((double)fl, (double)fr));
			if(left instanceof Double dl && right instanceof Double dr)
				return Value.IntLiteralValue.ofBoolean(applyFloating.test(dl, dr));
			return null;
		}
	}
	
	public static class PassOpHandler implements OperationHandler{
		
		public Set<Op> handles(){
			return Set.of(Op.PASS);
		}
		
		public boolean validFor(Value left, Value right){
			return right instanceof Value.CallValue || right instanceof Value.InitializationValue;
		}
		
		public Value getFor(Op op, Value left, Value oRight){
			if(oRight instanceof Value.CallValue right){
				List<Value> newArgs = new ArrayList<>(right.args);
				newArgs.add(0, left);
				return new Value.CallValue(right.on, newArgs, Utils.resolveGenericMethod(right.name, right.on, newArgs, right.method, right.isSuperCall, right.typeArgs), right.isSuperCall, right.name, right.method, right.typeArgs);
			}
			if(oRight instanceof Value.InitializationValue right){
				List<Value> newArgs = new ArrayList<>(right.args);
				newArgs.add(0, left);
				return new Value.InitializationValue(newArgs, Utils.resolveConstructor(right.of, newArgs, right.from), right.of, right.from);
			}
			return null;
		}
	}
	
	public static class UnaryOpValue extends Value{
		TypeReference type;
		Value from;
		int opcode;
		
		public UnaryOpValue(TypeReference type, Value from, int opcode){
			this.type = type;
			this.from = from;
			this.opcode = opcode;
		}
		
		public void write(MethodVisitor mv){
			from.write(mv);
			mv.visitInsn(opcode);
		}
		
		public TypeReference type(){
			return type;
		}
	}
	
	public static class BinaryOpValue extends Value{
		Op operation; // set in resolve
		TypeReference type;
		int opcode;
		Value left, right;
		
		public BinaryOpValue(TypeReference type, int opcode, Value left, Value right){
			this.type = type;
			this.opcode = opcode;
			this.left = left;
			this.right = right;
		}
		
		public void write(MethodVisitor mv){
			if(left != null)
				left.write(mv);
			if(right != null)
				right.write(mv);
			mv.visitInsn(opcode);
		}
		
		public void simplify(Statement in){
			if(left != null)
				left.simplify(in);
			if(right != null)
				right.simplify(in);
		}
		
		public TypeReference type(){
			return type;
		}
		
		public String toString(){
			return operation != null ? left + " " + operation.symbol + " " + right : super.toString();
		}
	}
	
	public static class BranchBoolBinaryOpValue extends BinaryOpValue{
		
		private Value condTrue = IntLiteralValue.ofBoolean(true);
		private Value condFalse = IntLiteralValue.ofBoolean(false);
		
		public BranchBoolBinaryOpValue(int opcode, Value left, Value right){
			super(BOOLEAN, opcode, left, right);
		}
		
		public BranchBoolBinaryOpValue(int opcode, Value left, Value right, Value ifTrue, Value ifFalse){
			super(BOOLEAN, opcode, left, right);
			if(ifTrue != null)
				condTrue = ifTrue;
			if(ifFalse != null)
				condFalse = ifFalse;
		}
		
		public void write(MethodVisitor mv){
			Label preWrite = new Label(), postWrite = new Label();
			if(left != null)
				left.write(mv);
			if(right != null)
				right.write(mv);
			// opcode is instead a branch instruction
			mv.visitJumpInsn(opcode, preWrite);
			condFalse.write(mv); // branch failed, push false
			mv.visitJumpInsn(Opcodes.GOTO, postWrite); // skip pushing true
			mv.visitLabel(preWrite); // branch succeeded
			condTrue.write(mv); // push true
			mv.visitLabel(postWrite);
		}
		
		public void simplify(Statement in){
			condTrue.simplify(in);
			condFalse.simplify(in);
		}
	}
}