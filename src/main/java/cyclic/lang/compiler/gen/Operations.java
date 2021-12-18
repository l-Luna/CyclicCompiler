package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.TypeResolver;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

import static cyclic.lang.compiler.model.platform.PrimitiveTypeRef.Primitive.BOOLEAN;
import static cyclic.lang.compiler.model.platform.PrimitiveTypeRef.Primitive.NULL;

public final class Operations{
	
	private static List<OperationHandler> handlers = new ArrayList<>();
	
	static{
		var INT = TypeResolver.resolve("int");
		var LONG = TypeResolver.resolve("long");
		var FLOAT = TypeResolver.resolve("float");
		var DOUBLE = TypeResolver.resolve("double");
		var BOOLEAN = TypeResolver.resolve("boolean");
		
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
		// TODO: short-circuiting
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.AND), Set.of(BOOLEAN),
				(l, r) -> new BinaryOpValue(BOOLEAN, Opcodes.IAND, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.OR), Set.of(BOOLEAN),
				(l, r) -> new BinaryOpValue(BOOLEAN, Opcodes.IOR, l, r)));
		
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
		
		// object equality
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.EQUALS), Set.of(INT, BOOLEAN),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IF_ICMPEQ, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.EQUALS), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFEQ, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.EQUALS), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFEQ, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.EQUALS), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFEQ, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
		handlers.add(new NamedTypeOpHandler(
				Set.of(Op.EQUALS), (l, r) -> (!(l instanceof PrimitiveTypeRef lr) || lr.type == NULL) && (!(r instanceof PrimitiveTypeRef rr) || rr.type == NULL),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IF_ACMPEQ, l, r)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.NOTEQUALS), Set.of(INT, BOOLEAN),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IF_ICMPNE, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.NOTEQUALS), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFNE, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.NOTEQUALS), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFNE, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.NOTEQUALS), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFNE, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
		handlers.add(new NamedTypeOpHandler(
				Set.of(Op.NOTEQUALS), (l, r) -> (!(l instanceof PrimitiveTypeRef lr) || lr.type == NULL) && (!(r instanceof PrimitiveTypeRef rr) || rr.type == NULL),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IF_ACMPNE, l, r)));
		
		// greater/eq, lesser/eq
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GEQ), Set.of(INT),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IF_ICMPGE, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GEQ), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFGE, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GEQ), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFGE, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GEQ), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFGE, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LEQ), Set.of(INT),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IF_ICMPLE, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LEQ), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFLE, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LEQ), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFLE, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LEQ), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFLE, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
		
		// greater, lesser
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GREATER), Set.of(INT),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IF_ICMPGT, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GREATER), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFGT, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GREATER), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFGT, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.GREATER), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFGT, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
		
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LESSER), Set.of(INT),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IF_ICMPLT, l, r)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LESSER), Set.of(LONG),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFLT, new BinaryOpValue(INT, Opcodes.LCMP, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LESSER), Set.of(FLOAT),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFLT, new BinaryOpValue(INT, Opcodes.FCMPG, l, r), null)));
		handlers.add(new TypeSetOpHandler(
				Set.of(Op.LESSER), Set.of(DOUBLE),
				(l, r) -> new BranchBoolBinaryOpValue(BOOLEAN, Opcodes.IFLT, new BinaryOpValue(INT, Opcodes.DCMPG, l, r), null)));
	}
	
	public static Op forSymbol(String symbol){
		for(var op : Op.values())
			if(op.symbol.equals(symbol))
				return op;
		throw new IllegalArgumentException("Unknown operation: " + symbol);
	}
	
	public static Value resolveBinary(String symbol, Value left, Value right){
		Op op = forSymbol(symbol);
		for(var handler : handlers)
			if(handler.handles().contains(op))
				if(handler.validFor(left, right)){
					Value ret = handler.getFor(op, left, right);
					if(ret instanceof BinaryOpValue v)
						v.operation = op;
					return ret;
				}
		throw new IllegalArgumentException("Found no handlers for operation " + symbol + " that can handle values of types " + left.type().fullyQualifiedName() + " and " + right.type().fullyQualifiedName() + "!");
	}
	
	// much simpler, no handlers
	// since 1 unary op is a no-op, 1 is applicable to one type only, and the other has simple logic
	public static Value resolveUnary(String symbol, Value value){
		symbol = symbol.trim();
		if(symbol.equals("+") && value.type() instanceof PrimitiveTypeRef prim && prim.isNumber())
			return value; // no effect from +
		else if(symbol.equals("!") && value.type() instanceof PrimitiveTypeRef prim && prim.type == BOOLEAN)
			return new BranchBoolBinaryOpValue(TypeResolver.resolve("boolean"), Opcodes.IFEQ, value, null);
		else if(symbol.equals("-") && value.type() instanceof PrimitiveTypeRef prim && prim.isNumber())
			return new UnaryOpValue(prim, value, switch(prim.type){
				case BYTE, SHORT, INT -> Opcodes.INEG;
				case LONG -> Opcodes.LNEG;
				case FLOAT -> Opcodes.FNEG;
				case DOUBLE -> Opcodes.DNEG;
				default -> throw new IllegalStateException();
			});
		throw new IllegalStateException("Unable to apply unary operator " + symbol + " to value of type " + value.type().fullyQualifiedName() + "!");
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
		EQUALS("=="),
		NOTEQUALS("!="),
		GEQ(">="),
		LEQ("<="),
		GREATER(">"),
		LESSER("<");
		
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
	
	public static class NamedTypeOpHandler implements OperationHandler{
		Set<Op> handles;
		BiPredicate<TypeReference, TypeReference> validFqs;
		BinaryOperator<Value> producer;
		
		public NamedTypeOpHandler(Set<Op> handles, BiPredicate<TypeReference, TypeReference> validFqs, BinaryOperator<Value> producer){
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
		
		public TypeReference type(){
			return type;
		}
	}
	
	public static class BranchBoolBinaryOpValue extends BinaryOpValue{
		
		public BranchBoolBinaryOpValue(TypeReference type, int opcode, Value left, Value right){
			super(type, opcode, left, right);
		}
		
		public void write(MethodVisitor mv){
			Label preWrite = new Label(), postWrite = new Label();
			if(left != null)
				left.write(mv);
			if(right != null)
				right.write(mv);
			// opcode is instead a branch instruction
			mv.visitJumpInsn(opcode, preWrite);
			mv.visitInsn(Opcodes.ICONST_0); // branch failed, push false
			mv.visitJumpInsn(Opcodes.GOTO, postWrite); // skip pushing true
			mv.visitLabel(preWrite); // branch succeeded
			mv.visitInsn(Opcodes.ICONST_1); // push true
			mv.visitLabel(postWrite);
		}
	}
}