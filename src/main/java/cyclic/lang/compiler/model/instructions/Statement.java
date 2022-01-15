package cyclic.lang.compiler.model.instructions;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.Compiler;
import cyclic.lang.compiler.gen.Operations;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.resolve.PlatformDependency;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.antlr.v4.runtime.ParserRuleContext;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.stream.Collectors;

import static cyclic.lang.compiler.Constants.*;

public abstract class Statement{
	
	Scope in;
	public ParserRuleContext text;
	
	public Statement(Scope in){
		this.in = in;
	}
	
	public void write(MethodVisitor mv){
		// may be null for e.g. the generated while loop from a foreach
		if(Compiler.project.include_debug && text != null){
			Label currentLine = new Label();
			mv.visitLabel(currentLine);
			mv.visitLineNumber(text.start.getLine(), currentLine);
		}
	}
	
	public void simplify(){
		// simplify values, fit them to types, evaluate constants, check that expressions are valid
	}
	
	public static Statement fromAst(CyclicLangParser.StatementContext ctx, Scope in, CyclicType type, CallableReference callable){
		Statement result;
		CompileTimeException.pushContext(ctx);
		
		var imports = type.imports;
		if(ctx.block() != null){
			BlockStatement statement = new BlockStatement(in);
			statement.contains = ctx.block().statement().stream().map(k -> fromAst(k, statement.blockScope, type, callable)).collect(Collectors.toList());
			result = statement;
		}else if(ctx.varDecl() != null){
			boolean isFinal = ctx.varDecl().modifiers().modifier().stream().anyMatch(x -> x.getText().equals("final")) || ctx.varDecl().type().getText().equals("val");
			boolean infer = ctx.varDecl().type().getText().equals("var") || ctx.varDecl().type().getText().equals("val");
			Value initial = ctx.varDecl().value() != null ? Value.fromAst(ctx.varDecl().value(), in, type, callable) : null;
			if(infer && initial == null)
				throw new CompileTimeException("Can't infer the type of a variable without an initial value.");
			result = new VarStatement(in, ctx.varDecl().idPart().getText(), infer ? initial.type() : TypeResolver.resolve(ctx.varDecl().type(), imports, type.packageName()), initial, true, isFinal);
		}else if(ctx.varAssignment() != null){
			Value left = Value.fromAst(ctx.varAssignment().value(0), in, type, callable);
			Value right = Value.fromAst(ctx.varAssignment().value(1), in, type, callable);
			if(ctx.varAssignment().binaryop() != null)
				right = Operations.resolveBinary(ctx.varAssignment().binaryop().getText(), left, right);
			result = createAssignStatement(ctx.varAssignment().value(0), in, left, right);
		}else if(ctx.call() != null){
			Value on = ctx.value() != null ? Value.fromAst(ctx.value(), in, type, callable) : null;
			boolean isSuperCall = ctx.SUPER() != null;
			List<Value> args = ctx.call().arguments().value().stream().map(x -> Value.fromAst(x, in, type, callable)).toList();
			result = new CallStatement(in, on, Utils.resolveMethod(ctx.call().idPart().getText(), on, args, callable, isSuperCall), args, isSuperCall);
		}else if(ctx.ifStatement() != null){
			Value c = Value.fromAst(ctx.ifStatement().value(), in, type, callable);
			Value cond = c.fit(PlatformDependency.BOOLEAN);
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.ifStatement().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(ctx.ifStatement().statement(), in, type, callable);
			Statement fail = ctx.ifStatement().elseStatement() == null ? null : fromAst(ctx.ifStatement().elseStatement().statement(), in, type, callable);
			result = new IfStatement(in, success, fail, cond);
		}else if(ctx.whileStatement() != null){
			Value c = Value.fromAst(ctx.whileStatement().value(), in, type, callable);
			Value cond = c.fit(PlatformDependency.BOOLEAN);
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.whileStatement().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(ctx.whileStatement().statement(), in, type, callable);
			result = new WhileStatement(in, success, cond);
		}else if(ctx.forStatement() != null){
			var f = ctx.forStatement();
			Statement setup = f.start != null ? fromAst(f.start, in, type, callable) : new NoopStatement(in);
			Statement increment = f.end != null ? fromAst(f.end, in, type, callable) : new NoopStatement(in);
			Value c = Value.fromAst(f.cond, in, type, callable);
			Value cond = c.fit(PlatformDependency.BOOLEAN);
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.whileStatement().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(f.action, in, type, callable);
			// could just implement it as synthetic block statements
			result = new ForStatement(in, success, setup, increment, cond);
		}else if(ctx.doWhile() != null){
			Value c = Value.fromAst(ctx.doWhile().value(), in, type, callable);
			Value cond = c.fit(PlatformDependency.BOOLEAN);
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.doWhile().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(ctx.doWhile().statement(), in, type, callable);
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
			Value iterating = Value.fromAst(fe.value(), in, type, callable);
			TypeReference iteratorType = TypeResolver.resolveFq(ITERATOR);
			BlockStatement container = new BlockStatement(in);
			Variable iterator = new Variable("~", iteratorType, container.blockScope, null);
			Variable iterationVar = new Variable(fe.idPart().getText(), TypeResolver.resolve(fe.type(), type.imports, type.packageName()), container.blockScope, container);
			Statement action = fromAst(fe.statement(), container.blockScope, type, callable);
			// TODO: generics
			container.contains = List.of(
					new CallStatement(container.blockScope, null, Utils.resolveSingleMethod(OBJECTS, OBJECTS_REQUIRE_NONNULL, true, OBJECT, STRING), List.of(iterating, new Value.StringLiteralValue("Iteration variable was null."))),
					new VarStatement(container.blockScope, iterator, new Value.CallValue(iterating, List.of(), Utils.resolveSingleMethod(ITERABLE, ITERABLE_ITERATOR, false))),
					new WhileStatement(container.blockScope,
							List.of(new VarStatement(container.blockScope, iterationVar, new Value.CallValue(new Value.LocalVarValue(iterator), List.of(), Utils.resolveSingleMethod(ITERATOR, ITERATOR_NEXT, false))),
									action),
							new Value.CallValue(new Value.LocalVarValue(iterator), List.of(), Utils.resolveSingleMethod(ITERATOR, ITERATOR_HAS_NEXT, false)))
			);
			result = container;
		}else if(ctx.throwStatement() != null){
			Value toThrow = Value.fromAst(ctx.throwStatement().value(), in, type, callable);
			result = new ThrowStatement(toThrow, in);
		}else if(ctx.returnStatement() != null){
			var value = ctx.returnStatement().value();
			Value toReturn = value == null ? null : Value.fromAst(value, in, type, callable);
			TypeReference returnType = callable instanceof CyclicMethod method ? method.returns() : TypeResolver.resolveFq("void");
			if(returnType.fullyQualifiedName().equals("void")){
				if(value != null)
					throw new CompileTimeException("Return statement in void method cannot return a value");
			}else{
				if(value == null)
					throw new CompileTimeException("Return statement in non-void method must return a value");
				if(toReturn.fit(returnType) == null)
					throw new CompileTimeException("Cannot return value of type \"" + toReturn.type().fullyQualifiedName() + "\" from method with return type \"" + returnType.fullyQualifiedName() + "\"");
			}
			result = new ReturnStatement(toReturn, in, returnType);
		}else if(ctx.ctorCall() != null){
			if(callable instanceof MethodReference || callable == null)
				throw new CompileTimeException("super() and this() statements are only valid in constructors");
			List<Value> args = ctx.ctorCall().arguments().value().stream().map(x -> Value.fromAst(x, in, type, callable)).toList();
			boolean isSuperCall = ctx.ctorCall().SUPER() != null;
			var t = callable.in();
			result = new CtorCallStatement(in, Utils.resolveConstructor(isSuperCall ? t.superClass() : t, args), args);
		}else
			result = new NoopStatement(in);
		
		CompileTimeException.popContext();
		result.text = ctx;
		return result;
	}
	
	private static Statement createAssignStatement(CyclicLangParser.ValueContext ctx, Scope in, Value left, Value right){
		// if the LHS is a local variable value, reuse the variable
		// if the LHS is a field value, assign to the field
		// if the LHS is an array index value, assign to the array
		return switch(left){
			case Value.LocalVarValue local -> new VarStatement(in, local.localName, null, right, false, false);
			case Value.FieldValue field -> new AssignFieldStatement(in, field.ref, field.from, right);
			case Value.ArrayIndexValue idx -> new AssignArrayStatement(in, idx.array, idx.index, right, idx.arrayType);
			case null, default -> throw new CompileTimeException("Can't assign value to " + ctx.getText());
		};
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
		public List<Statement> contains;
		
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
		
		public void simplify(){
			contains.forEach(Statement::simplify);
		}
	}
	
	public static class ReturnStatement extends Statement{
		public Value returnValue;
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
				throw new CompileTimeException(text, "Value of type \"" + returnValue.type().fullyQualifiedName() + "\" cannot be returned from method of type \"" + toReturn.fullyQualifiedName() + "\"");
			
			adjusted.write(mv);
			mv.visitInsn(adjusted.type().returnOpcode());
		}
		
		public void simplify(){
			if(returnValue != null)
				returnValue.simplify();
		}
	}
	
	public static class ThrowStatement extends Statement{
		public Value exceptionValue;
		
		public ThrowStatement(Value exceptionValue, Scope in){
			super(in);
			this.exceptionValue = exceptionValue;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			
			var adjusted = exceptionValue.fit(TypeResolver.resolveFq(THROWABLE));
			if(adjusted == null)
				throw new CompileTimeException(text, "Value of type " + exceptionValue.type().fullyQualifiedName() + " cannot be thrown");
			
			adjusted.write(mv);
			mv.visitInsn(Opcodes.ATHROW);
		}
		
		public void simplify(){
			exceptionValue.simplify();
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
				mv.visitVarInsn(v.type.localStoreOpcode(), v.getAdjIndex());
			}
		}
		
		public void simplify(){
			value.simplify();
		}
	}
	
	public static class CallStatement extends Statement{
		Value on;
		List<Value> args;
		MethodReference target;
		boolean isSuperCall; // to use invokespecial instead
		
		public CallStatement(Scope in, Value on, MethodReference target, List<Value> args){
			super(in);
			this.on = on;
			this.target = target;
			this.args = args;
		}
		
		public CallStatement(Scope in, Value on, MethodReference target, List<Value> args, boolean isSuperCall){
			super(in);
			this.on = on;
			this.args = args;
			this.target = target;
			this.isSuperCall = isSuperCall;
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
			if(isSuperCall)
				target.writeInvokeSpecial(mv);
			else
				target.writeInvoke(mv);
			// need to pop if a value is returned
			if(!target.returns().fullyQualifiedName().equals("void"))
				mv.visitInsn(Opcodes.POP);
		}
		
		public void simplify(){
			if(on != null)
				on.simplify();
			args.forEach(Value::simplify);
		}
	}
	
	public static class CtorCallStatement extends Statement{
		List<Value> args;
		CallableReference target;
		
		public CtorCallStatement(Scope in, CallableReference target, List<Value> args){
			super(in);
			this.target = target;
			this.args = args;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			mv.visitVarInsn(Opcodes.ALOAD, 0);
			for(int i = 0; i < args.size(); i++){
				Value v = args.get(i);
				v.fit(target.parameters().get(i)).write(mv);
			}
			target.writeInvoke(mv);
		}
		
		public void simplify(){
			args.forEach(Value::simplify);
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
		
		public void simplify(){
			if(on != null)
				on.simplify();
			toSet.simplify();
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
		
		public void simplify(){
			on.simplify();
			index.simplify();
			val.simplify();
		}
	}
	
	public static class IfStatement extends Statement{
		public Statement success, fail;
		Value condition;
		
		public IfStatement(Scope in, Statement success, Statement fail, Value condition){
			super(in);
			this.success = success;
			this.fail = fail;
			this.condition = condition;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			Label postWrite = new Label(), postElse = new Label();
			condition.write(mv);
			mv.visitJumpInsn(Opcodes.IFEQ, postWrite); // if false, skip
			success.write(mv); // success block
			mv.visitJumpInsn(Opcodes.GOTO, postElse); // skip else block
			mv.visitLabel(postWrite);
			if(fail != null)
				fail.write(mv);
			mv.visitLabel(postElse);
		}
		
		public void simplify(){
			success.simplify();
			if(fail != null)
				fail.simplify();
			condition.simplify();
		}
	}
	
	public static class WhileStatement extends Statement{
		public Statement success;
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
			Label postWrite = new Label(), preCheck = new Label();
			mv.visitLabel(preCheck);
			condition.write(mv);
			mv.visitJumpInsn(Opcodes.IFEQ, postWrite); // if false, skip
			success.write(mv); // success block
			mv.visitJumpInsn(Opcodes.GOTO, preCheck); // check again
			mv.visitLabel(postWrite);
		}
		
		public void simplify(){
			success.simplify();
			condition.simplify();
		}
	}
	
	public static class ForStatement extends Statement{
		public Statement success, start, increment;
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
			Label postWrite = new Label(), preCheck = new Label();
			start.write(mv);
			mv.visitLabel(preCheck);
			condition.write(mv);
			mv.visitJumpInsn(Opcodes.IFEQ, postWrite); // if false, skip
			success.write(mv); // success block
			increment.write(mv);
			mv.visitJumpInsn(Opcodes.GOTO, preCheck); // check again
			mv.visitLabel(postWrite);
		}
		
		public void simplify(){
			success.simplify();
			start.simplify();
			increment.simplify();
			condition.simplify();
		}
	}
	
	public static class DoWhileStatement extends Statement{
		public Statement success;
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
		
		public void simplify(){
			success.simplify();
			condition.simplify();
		}
	}
}