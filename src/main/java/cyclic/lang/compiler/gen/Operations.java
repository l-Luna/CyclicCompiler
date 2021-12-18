package cyclic.lang.compiler.gen;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import cyclic.lang.compiler.model.statements.Value;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

import static cyclic.lang.compiler.model.platform.PrimitiveTypeRef.Primitive.*;

public final class Operations{
	
	private static List<OperationHandler> handlers = new ArrayList<>();
	
	static{
		// add, subtract, multiply, divide
		handlers.add(new SimpleOpHandler(
				Set.of(Op.PLUS), Set.of("byte", "short", "int"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IADD, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.PLUS), Set.of("long"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(LONG), Opcodes.LADD, l, r)));
		
		handlers.add(new SimpleOpHandler(
				Set.of(Op.MINUS), Set.of("byte", "short", "int"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.ISUB, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.MINUS), Set.of("long"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(LONG), Opcodes.LSUB, l, r)));
		
		handlers.add(new SimpleOpHandler(
				Set.of(Op.MULTIPLY), Set.of("byte", "short", "int"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IMUL, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.MULTIPLY), Set.of("long"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(LONG), Opcodes.LMUL, l, r)));
		
		handlers.add(new SimpleOpHandler(
				Set.of(Op.DIVIDE), Set.of("byte", "short", "int"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IDIV, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.DIVIDE), Set.of("long"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(LONG), Opcodes.LDIV, l, r)));
		
		handlers.add(new SimpleOpHandler(
				Set.of(Op.MOD), Set.of("byte", "short", "int"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IREM, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.MOD), Set.of("long"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(LONG), Opcodes.LREM, l, r)));
		
		// short-circuiting operations
		// TODO: short-circuiting
		handlers.add(new SimpleOpHandler(
				Set.of(Op.AND), Set.of("boolean"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IAND, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.OR), Set.of("boolean"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IOR, l, r)));
		
		// bitwise operations
		handlers.add(new SimpleOpHandler(
				Set.of(Op.BITAND), Set.of("byte", "short", "int"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IAND, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.BITAND), Set.of("boolean"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IAND, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.BITAND), Set.of("long"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(LONG), Opcodes.LAND, l, r)));
		
		handlers.add(new SimpleOpHandler(
				Set.of(Op.BITOR), Set.of("byte", "short", "int"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IOR, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.BITOR), Set.of("boolean"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IOR, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.BITOR), Set.of("long"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(LONG), Opcodes.LOR, l, r)));
		
		handlers.add(new SimpleOpHandler(
				Set.of(Op.XOR), Set.of("byte", "short", "int"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IXOR, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.XOR), Set.of("boolean"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IXOR, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.XOR), Set.of("long"),
				(l, r) -> new BinaryOpValue(new PrimitiveTypeRef(LONG), Opcodes.LXOR, l, r)));
		
		// object equality
		handlers.add(new SimpleOpHandler(
				Set.of(Op.EQUALS), Set.of("byte", "short", "int"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IF_ICMPEQ, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.EQUALS), Set.of("boolean"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IF_ICMPEQ, l, r)));
		/*handlers.add(new SimpleOpHandler(
				Set.of(Op.EQUALS), Set.of("long"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(LONG), Opcodes.LCMP, l, r)));*/
		handlers.add(new SimpleOpHandler(
				Set.of(Op.EQUALS), (l, r) -> (!(l instanceof PrimitiveTypeRef lr) || lr.type == NULL) && (!(r instanceof PrimitiveTypeRef rr) || rr.type == NULL),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IF_ACMPEQ, l, r)));
		
		handlers.add(new SimpleOpHandler(
				Set.of(Op.NOTEQUALS), Set.of("byte", "short", "int"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IF_ICMPNE, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.NOTEQUALS), Set.of("boolean"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IF_ICMPNE, l, r)));
		/*handlers.add(new SimpleOpHandler(
				Set.of(Op.EQUALS), Set.of("long"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(LONG), Opcodes.LCMP, l, r)));*/
		handlers.add(new SimpleOpHandler(
				Set.of(Op.NOTEQUALS), (l, r) -> (!(l instanceof PrimitiveTypeRef lr) || lr.type == NULL) && (!(r instanceof PrimitiveTypeRef rr) || rr.type == NULL),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IF_ACMPNE, l, r)));
		
		// greater/eq, lesser/eq
		handlers.add(new SimpleOpHandler(
				Set.of(Op.GEQ), Set.of("byte", "short", "int"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IF_ICMPGE, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.GEQ), Set.of("boolean"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IF_ICMPGE, l, r)));
		
		handlers.add(new SimpleOpHandler(
				Set.of(Op.LEQ), Set.of("byte", "short", "int"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IF_ICMPLE, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.LEQ), Set.of("boolean"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IF_ICMPLE, l, r)));
		
		// greater, lesser
		handlers.add(new SimpleOpHandler(
				Set.of(Op.GREATER), Set.of("byte", "short", "int"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IF_ICMPGT, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.GREATER), Set.of("boolean"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IF_ICMPGT, l, r)));
		
		handlers.add(new SimpleOpHandler(
				Set.of(Op.LESSER), Set.of("byte", "short", "int"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(INT), Opcodes.IF_ICMPLT, l, r)));
		handlers.add(new SimpleOpHandler(
				Set.of(Op.LESSER), Set.of("boolean"),
				(l, r) -> new BranchBoolBinaryOpValue(new PrimitiveTypeRef(BOOLEAN), Opcodes.IF_ICMPLT, l, r)));
	}
	
	public static Op forSymbol(String symbol){
		for(var op : Op.values())
			if(op.symbol.equals(symbol))
				return op;
		throw new IllegalArgumentException("Unknown operation: " + symbol);
	}
	
	public static Value resolve(String symbol, Value left, Value right){
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
	
	public static class SimpleOpHandler implements OperationHandler{
		Set<Op> handles;
		BiPredicate<TypeReference, TypeReference> validFqs;
		BinaryOperator<Value> producer;
		
		public SimpleOpHandler(Set<Op> handles, BiPredicate<TypeReference, TypeReference> validFqs, BinaryOperator<Value> producer){
			this.handles = handles;
			this.validFqs = validFqs;
			this.producer = producer;
		}
		
		public SimpleOpHandler(Set<Op> handles, Set<String> validFqs, BinaryOperator<Value> producer){
			this.handles = handles;
			this.validFqs = (l, r) -> validFqs.contains(l.fullyQualifiedName()) && validFqs.contains(r.fullyQualifiedName());
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
			left.write(mv);
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
			left.write(mv);
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