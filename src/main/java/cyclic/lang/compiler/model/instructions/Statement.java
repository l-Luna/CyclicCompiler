package cyclic.lang.compiler.model.instructions;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.Compiler;
import cyclic.lang.compiler.gen.Operations;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import org.antlr.v4.runtime.ParserRuleContext;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static cyclic.lang.compiler.Constants.*;

public abstract class Statement{
	
	Scope in;
	protected ParserRuleContext text;
	
	public Statement(Scope in){
		this.in = in;
	}
	
	public void write(MethodVisitor mv){
		// may be null for e.g. the generated while loop from a foreach
		if(Compiler.includeDebugInfo && text != null){
			Label currentLine = new Label();
			mv.visitLabel(currentLine);
			mv.visitLineNumber(text.start.getLine(), currentLine);
		}
	}
	
	public static Statement fromAst(CyclicLangParser.StatementContext ctx, Scope in, CyclicType type, CallableReference method){
		Statement result;
		CompileTimeException.pushContext(ctx);
		
		var imports = type.imports;
		if(ctx.block() != null){
			BlockStatement statement = new BlockStatement(in);
			statement.contains = ctx.block().statement().stream().map(k -> fromAst(k, statement.blockScope, type, method)).collect(Collectors.toList());
			result = statement;
		}else if(ctx.varDecl() != null){
			boolean isFinal = ctx.varDecl().modifiers().modifier().stream().anyMatch(x -> x.getText().equals("final")) || ctx.varDecl().type().getText().equals("val");
			boolean infer = ctx.varDecl().type().getText().equals("var") || ctx.varDecl().type().getText().equals("val");
			Value initial = ctx.varDecl().value() != null ? Value.fromAst(ctx.varDecl().value(), in, type, method) : null;
			if(infer && initial == null)
				throw new CompileTimeException("Can't infer the type of a variable without an initial value.");
			result = new VarStatement(in, ctx.varDecl().ID().getText(), infer ? initial.type() : TypeResolver.resolve(ctx.varDecl().type().getText(), imports, type.packageName()), initial, true, isFinal);
		}else if(ctx.varAssignment() != null){
			Value left = Value.fromAst(ctx.varAssignment().value(0), in, type, method);
			Value right = Value.fromAst(ctx.varAssignment().value(1), in, type, method);
			if(ctx.varAssignment().binaryop() != null)
				right = Operations.resolveBinary(ctx.varAssignment().binaryop().getText(), left, right);
			result = createAssignStatement(ctx.varAssignment().value(0), in, left, right);
		}else if(ctx.call() != null){
			Value on = ctx.value() != null ? Value.fromAst(ctx.value(), in, type, method) : null;
			List<Value> args = ctx.call().arguments().value().stream().map(x -> Value.fromAst(x, in, type, method)).toList();
			result = new CallStatement(in, on, Utils.resolveMethod(ctx.call().ID().getText(), on, args, method), args);
		}else if(ctx.ifStatement() != null){
			Value c = Value.fromAst(ctx.ifStatement().value(), in, type, method);
			Value cond = c.fit(TypeResolver.resolve("boolean"));
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.ifStatement().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(ctx.ifStatement().statement(), in, type, method);
			Statement fail = ctx.ifStatement().elseStatement() == null ? null : fromAst(ctx.ifStatement().elseStatement().statement(), in, type, method);
			result = new IfStatement(in, success, fail, cond);
		}else if(ctx.whileStatement() != null){
			Value c = Value.fromAst(ctx.whileStatement().value(), in, type, method);
			Value cond = c.fit(TypeResolver.resolve("boolean"));
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.whileStatement().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(ctx.whileStatement().statement(), in, type, method);
			result = new WhileStatement(in, success, cond);
		}else if(ctx.forStatement() != null){
			var f = ctx.forStatement();
			Statement setup = f.start != null ? fromAst(f.start, in, type, method) : new NoopStatement(in);
			Statement increment = f.end != null ? fromAst(f.end, in, type, method) : new NoopStatement(in);
			Value c = Value.fromAst(f.cond, in, type, method);
			Value cond = c.fit(TypeResolver.resolve("boolean"));
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.whileStatement().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(f.action, in, type, method);
			// could just implement it as synthetic block statements
			result = new ForStatement(in, success, setup, increment, cond);
		}else if(ctx.doWhile() != null){
			Value c = Value.fromAst(ctx.doWhile().value(), in, type, method);
			Value cond = c.fit(TypeResolver.resolve("boolean"));
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.doWhile().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(ctx.doWhile().statement(), in, type, method);
			result = new DoWhileStatement(in, success, cond);
		}else if(ctx.foreachStatement() != null){
			var fe = ctx.foreachStatement();
			
			/*    for(T t : x)
			 *         act;
			 *  becomes
			 *     Objects.requireNonNull(x);
			 *     Iterator iter = x.iterator();
			 *     while(iter.hasNext())
			 *         T t = iter.next();
			 *         act;
			 */
			Value iterating = Value.fromAst(fe.value(), in, type, method);
			TypeReference iteratorType = TypeResolver.resolve(ITERATOR);
			BlockStatement container = new BlockStatement(in);
			Variable iterator = new Variable("~", iteratorType, container.blockScope, null);
			Variable iterationVar = new Variable(fe.ID().getText(), TypeResolver.resolve(fe.type().getText(), type.imports, type.packageName()), container.blockScope, container);
			Statement action = fromAst(fe.statement(), container.blockScope, type, method);
			// TODO: generics
			container.contains = List.of(
					new CallStatement(container.blockScope, null, Utils.resolveSingleMethod(OBJECTS, OBJECTS_REQUIRE_NONNULL, true, OBJECT), Collections.singletonList(iterating)),
					new VarStatement(container.blockScope, iterator, new Value.CallValue(iterating, List.of(), Utils.resolveSingleMethod(ITERABLE, ITERABLE_ITERATOR, false))),
					new WhileStatement(container.blockScope,
							List.of(new VarStatement(container.blockScope, iterationVar, new Value.CallValue(new Value.LocalVarValue(iterator), List.of(), Utils.resolveSingleMethod(ITERATOR, ITERATOR_NEXT, false))),
									action),
							new Value.CallValue(new Value.LocalVarValue(iterator), List.of(), Utils.resolveSingleMethod(ITERATOR, ITERATOR_HAS_NEXT, false)))
			);
			result = container;
		}else{
			result = new NoopStatement(in);
		}
		
		CompileTimeException.popContext();
		result.text = ctx;
		return result;
	}
	
	private static Statement createAssignStatement(CyclicLangParser.ValueContext ctx, Scope in, Value left, Value right){
		// if the LHS is a local variable value, reuse the variable
		// if the LHS is a field value, assign to the field
		// if the LHS is an array index value, assign to the array
		if(left instanceof Value.LocalVarValue local)
			return new VarStatement(in, local.local.name, null, right, false, false);
		else if(left instanceof Value.FieldValue field)
			return new AssignFieldStatement(in, field.ref, field.from, right);
		else if(left instanceof Value.ArrayIndexValue idx)
			return new AssignArrayStatement(in, idx.array, idx.index, right, idx.arrayType);
		else
			throw new CompileTimeException("Can't assign value to " + ctx.getText());
	}
	
	public static class NoopStatement extends Statement{
		public NoopStatement(Scope in){
			super(in);
		}
		
		public void write(MethodVisitor mv){
			// explicit no-op for debugging
			super.write(mv);
			mv.visitInsn(Opcodes.NOP);
		}
	}
	
	public static class BlockStatement extends Statement{
		Scope blockScope;
		List<Statement> contains;
		
		public BlockStatement(Scope in){
			super(in);
			blockScope = new Scope(in);
		}
		
		public BlockStatement(List<Statement> statements, Scope in){
			this(in);
			contains = statements;
			for(var s : statements)
				s.in = blockScope;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			for(Statement s : contains)
				s.write(mv);
		}
	}
	
	public static class ReturnStatement extends Statement{
		Value returnValue;
		private TypeReference toReturn;
		
		public ReturnStatement(Value returnValue, Scope in, TypeReference toReturn){
			super(in);
			this.returnValue = returnValue;
			this.toReturn = toReturn;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			if(returnValue == null){
				mv.visitInsn(Opcodes.RETURN);
				return;
			}
			
			var adjusted = returnValue.fit(toReturn);
			if(adjusted == null)
				throw new CompileTimeException(text, "Value of type " + returnValue.type().fullyQualifiedName() + " cannot be returned from method of type " + toReturn.fullyQualifiedName() + "!");
			
			adjusted.write(mv);
			mv.visitInsn(adjusted.type().returnOpcode());
		}
	}
	
	public static class VarStatement extends Statement{
		Variable v;
		Value value;
		
		public VarStatement(Scope in, String varName, TypeReference varType, Value value, boolean declare, boolean isFinal){
			super(in);
			if(declare)
				v = new Variable(varName, varType, in, this);
			else
				v = in.get(varName);
			v.isFinal |= isFinal;
			this.value = value;
		}
		
		public VarStatement(Scope in, Variable v, Value value){
			super(in);
			this.v = v;
			this.value = value;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			if(v.isFinal && this != v.owner)
				throw new CompileTimeException(text, "Can't assign the value of a final local variable outside of its declaration!");
			if(value != null){
				var adjusted = value.fit(v.type);
				if(adjusted == null)
					throw new CompileTimeException(text, "Value of type " + value.type().fullyQualifiedName() + " cannot be assigned to local variable of type " + v.type.fullyQualifiedName() + "!");
				adjusted.write(mv);
				mv.visitVarInsn(v.type.localStoreOpcode(), v.getVarIndex());
			}
		}
	}
	
	public static class CallStatement extends Statement{
		Value on;
		List<Value> args;
		MethodReference target;
		
		public CallStatement(Scope in, Value on, MethodReference target, List<Value> args){
			super(in);
			this.on = on;
			this.target = target;
			this.args = args;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			if(on != null && !(on instanceof Value.TypeValue)) // TODO: consider singletons
				on.write(mv);
			// implicit this for instance method calls with no explicit value
			if(on == null && !target.isStatic())
				mv.visitVarInsn(Opcodes.ALOAD, 0);
			for(int i = 0; i < args.size(); i++){
				Value v = args.get(i);
				v.fit(target.parameters().get(i)).write(mv);
			}
			target.writeInvoke(mv);
		}
	}
	
	public static class AssignFieldStatement extends Statement{
		FieldReference fieldRef;
		Value on;
		Value toSet;
		
		public AssignFieldStatement(Scope in, FieldReference fieldRef, Value on, Value toSet){
			super(in);
			this.fieldRef = fieldRef;
			this.on = on instanceof Value.TypeValue ? null : on;
			this.toSet = toSet;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			if(on != null)
				on.write(mv);
			else if(!fieldRef.isStatic())
				mv.visitVarInsn(Opcodes.ALOAD, 0);
			toSet.write(mv);
			fieldRef.writePut(mv);
		}
	}
	
	public static class AssignArrayStatement extends Statement{
		Value on, index, val;
		ArrayTypeRef arrayType;
		
		public AssignArrayStatement(Scope in, Value on, Value index, Value val, ArrayTypeRef arrayType){
			super(in);
			this.on = on;
			this.index = index;
			this.val = val;
			this.arrayType = arrayType;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			on.write(mv);
			index.write(mv);
			val.write(mv);
			mv.visitInsn(arrayType.getComponent().arrayStoreOpcode());
		}
	}
	
	public static class IfStatement extends Statement{
		Statement success, fail;
		Value condition;
		
		public IfStatement(Scope in, Statement success, Statement fail, Value condition){
			super(in);
			this.success = success;
			this.fail = fail;
			this.condition = condition;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			Label preWrite = new Label(), postWrite = new Label();
			condition.write(mv);
			mv.visitJumpInsn(Opcodes.IFNE, preWrite);
			if(fail != null)
				fail.write(mv);
			mv.visitJumpInsn(Opcodes.GOTO, postWrite); // skip success block
			mv.visitLabel(preWrite); // branch succeeded
			success.write(mv); // success block
			mv.visitLabel(postWrite);
		}
	}
	
	public static class WhileStatement extends Statement{
		Statement success;
		Value condition;
		
		public WhileStatement(Scope in, Statement success, Value condition){
			super(in);
			this.success = success;
			this.condition = condition;
		}
		
		public WhileStatement(Scope in, List<Statement> success, Value condition){
			super(in);
			this.condition = condition;
			BlockStatement block = new BlockStatement(in);
			for(var s : success)
				s.in = block.blockScope;
			block.contains = success;
			this.success = block;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			Label preWrite = new Label(), postWrite = new Label(), preCheck = new Label();
			mv.visitLabel(preCheck);
			condition.write(mv);
			mv.visitJumpInsn(Opcodes.IFNE, preWrite); // if true, go to success block
			// no fail block
			mv.visitJumpInsn(Opcodes.GOTO, postWrite); // skip success block
			mv.visitLabel(preWrite); // branch succeeded
			success.write(mv); // success block
			mv.visitJumpInsn(Opcodes.GOTO, preCheck); // check again
			mv.visitLabel(postWrite);
		}
	}
	
	public static class ForStatement extends Statement{
		Statement success;
		Statement start;
		Statement increment;
		Value condition;
		
		public ForStatement(Scope in, Statement success, Statement start, Statement increment, Value condition){
			super(in);
			this.success = success;
			this.start = start;
			this.increment = increment;
			this.condition = condition;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			Label preWrite = new Label(), postWrite = new Label(), preCheck = new Label();
			start.write(mv);
			mv.visitLabel(preCheck);
			condition.write(mv);
			mv.visitJumpInsn(Opcodes.IFNE, preWrite); // if true, go to success block
			// no fail block
			mv.visitJumpInsn(Opcodes.GOTO, postWrite); // skip success block
			mv.visitLabel(preWrite); // branch succeeded
			success.write(mv); // success block
			increment.write(mv);
			mv.visitJumpInsn(Opcodes.GOTO, preCheck); // check again
			mv.visitLabel(postWrite);
		}
	}
	
	public static class DoWhileStatement extends Statement{
		Statement success;
		Value condition;
		
		public DoWhileStatement(Scope in, Statement success, Value condition){
			super(in);
			this.success = success;
			this.condition = condition;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			Label preWrite = new Label();
			mv.visitLabel(preWrite);
			success.write(mv);
			condition.write(mv);
			mv.visitJumpInsn(Opcodes.IFNE, preWrite);
		}
	}
}