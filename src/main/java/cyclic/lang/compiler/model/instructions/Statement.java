package cyclic.lang.compiler.model.instructions;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.Compiler;
import cyclic.lang.compiler.gen.Operations;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicCallable;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.resolve.PlatformDependency;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

import static cyclic.lang.compiler.Constants.THROWABLE;

public abstract class Statement{
	
	public Scope in;
	@Nullable
	public ParserRuleContext text;
	@NotNull
	public CyclicCallable from;
	
	public Statement(Scope in, @NotNull CyclicCallable from){
		this.in = in;
		this.from = from;
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
	
	public String toString(){
		return text != null ? Utils.format(text) : "<generated: " + getClass().getSimpleName() + ">";
	}
	
	public static Statement fromAst(CyclicLangParser.StatementContext ctx, Scope in, CyclicType type, CyclicCallable callable){
		Statement result;
		CompileTimeException.pushContext(ctx);
		
		var imports = type.imports;
		if(ctx.block() != null)
			result = fromBlockAst(ctx.block(), in, type, callable);
		else if(ctx.varDecl() != null){
			CyclicLangParser.VarDeclContext decl = ctx.varDecl();
			if(decl.arguments() != null)
				throw new CompileTimeException("Arguments not allowed here");
			String typeName = decl.typeOrInferred().getText();
			boolean isFinal = decl.modifiers().modifier().stream().anyMatch(x -> x.getText().equals("final")) || typeName.equals("val");
			boolean infer = typeName.equals("var") || typeName.equals("val");
			Value initial = decl.value() != null ? Value.fromAst(decl.value(), in, type, callable) : null;
			if(infer && initial == null)
				throw new CompileTimeException("Can't infer the type of a variable without an initial value.");
			TypeReference target = infer ? initial.type() : TypeResolver.resolve(decl.typeOrInferred().type(), imports, type.packageName());
			if(!Visibility.visibleFrom(target, callable))
				throw new CompileTimeException("Variable type not visible here");
			result = new VarStatement(in, decl.idPart().getText(), target, initial, true, isFinal, callable);
		}else if(ctx.varAssignment() != null){
			Value left = Value.fromAst(ctx.varAssignment().value(0), in, type, callable);
			Value right = Value.fromAst(ctx.varAssignment().value(1), in, type, callable);
			if(ctx.varAssignment().binaryop() != null)
				right = Operations.resolveBinary(ctx.varAssignment().binaryop().getText(), left, right, null);
			result = createAssignStatement(in, left, right, callable);
		}else if(ctx.call() != null){
			Value on = ctx.value() != null ? Value.fromAst(ctx.value(), in, type, callable) : null;
			boolean isSuperCall = ctx.SUPER() != null;
			List<Value> args = ctx.call().arguments().value().stream().map(x -> Value.fromAst(x, in, type, callable)).toList();
			String name = ctx.call().idPart().getText();
			result = new CallStatement(in, on, name, Utils.resolveMethod(name, on, args, callable, isSuperCall), args, isSuperCall, callable);
		}else if(ctx.ifStatement() != null){
			Value c = Value.fromAst(ctx.ifStatement().value(), in, type, callable);
			Value cond = c.fit(PlatformDependency.BOOLEAN);
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.ifStatement().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(ctx.ifStatement().statement(), in, type, callable);
			Statement fail = ctx.ifStatement().elseStatement() == null ? null : fromAst(ctx.ifStatement().elseStatement().statement(), in, type, callable);
			result = new IfStatement(in, success, fail, cond, callable);
		}else if(ctx.whileStatement() != null){
			Value c = Value.fromAst(ctx.whileStatement().value(), in, type, callable);
			Value cond = c.fit(PlatformDependency.BOOLEAN);
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.whileStatement().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(ctx.whileStatement().statement(), in, type, callable);
			result = new WhileStatement(in, success, cond, callable);
		}else if(ctx.forStatement() != null){
			var f = ctx.forStatement();
			Scope forScope = new Scope(in);
			Statement setup = f.start != null ? fromAst(f.start, forScope, type, callable) : new NoopStatement(in, callable);
			Statement increment = f.end != null ? fromAst(f.end, forScope, type, callable) : new NoopStatement(in, callable);
			Value c = Value.fromAst(f.cond, forScope, type, callable);
			Value cond = c.fit(PlatformDependency.BOOLEAN);
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.whileStatement().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(f.action, forScope, type, callable);
			// could just implement it as synthetic block statements
			result = new ForStatement(forScope, success, setup, increment, cond, callable, true);
		}else if(ctx.doWhileStatement() != null){
			Scope doScope = new Scope(in);
			Value c = Value.fromAst(ctx.doWhileStatement().value(), in, type, callable);
			Value cond = c.fit(PlatformDependency.BOOLEAN);
			if(cond == null)
				throw new CompileTimeException("Expression " + ctx.doWhileStatement().value().getText() + " cannot be converted to boolean - it is " + c.type().fullyQualifiedName());
			Statement success = fromAst(ctx.doWhileStatement().statement(), doScope, type, callable);
			result = new DoWhileStatement(doScope, success, cond, callable, true);
		}else if(ctx.foreachStatement() != null){
			var fe = ctx.foreachStatement();
			Value iterating = Value.fromAst(fe.value(), in, type, callable);
			String varName = fe.idPart().getText();
			String varTypeName = TypeResolver.getBaseName(fe.typeOrInferred());
			TypeReference varType = varTypeName.equals("var") || varTypeName.equals("val") ? null : TypeResolver.resolve(fe.typeOrInferred().type(), imports, type.packageName());
			boolean isFinal = varTypeName.equals("val") || fe.FINAL() != null;
			result = null;
			for(ForEachStyle style : ForEachStyle.STYLES)
				if(style.appliesTo(iterating)){
					result = style.forEachStatement(iterating, varName, varType, isFinal, in, scope -> Statement.fromAst(fe.statement(), scope, type, callable), callable);
					break;
				}
			if(result == null)
				throw new CompileTimeException("Value of type \"" + iterating.type().fullyQualifiedName() + "\" cannot be iterated on");
		}else if(ctx.throwStatement() != null){
			Value toThrow = Value.fromAst(ctx.throwStatement().value(), in, type, callable);
			result = new ThrowStatement(toThrow, in, callable);
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
			result = new ReturnStatement(toReturn, in, returnType, callable);
		}else if(ctx.ctorCall() != null){
			if(callable instanceof MethodReference || callable == null)
				throw new CompileTimeException("super() and this() statements are only valid in constructors");
			List<Value> args = ctx.ctorCall().arguments().value().stream().map(x -> Value.fromAst(x, in, type, callable)).toList();
			boolean isSuperCall = ctx.ctorCall().SUPER() != null;
			var t = callable.in();
			TypeReference of = isSuperCall ? t.superClass() : t;
			result = new CtorCallStatement(in, of, Utils.resolveConstructor(of, args, callable), args, callable);
		}else if(ctx.varIncrement() != null){
			Value toAssign = Value.fromAst(ctx.varIncrement().value(), in, type, callable);
			String symbol = ctx.varIncrement().PLUSPLUS() != null ? "++" : "--";
			result = new ValueStatement(in, callable, Operations.resolvePostfix(symbol, toAssign));
		}else if(ctx.tryStatement() != null){
			var ts = ctx.tryStatement();
			List<TryCatchStatement.CatchStatement> catches = ts.catchBlock().stream().map(aCatch -> {
				Scope catchScope = new Scope(in);
				TypeReference catchType = TypeResolver.resolve(aCatch.type(), imports, type.packageName());
				String varName = aCatch.idPart().getText();
				var catchVar = new Variable(varName, catchType, catchScope, null);
				Statement catchBody = fromBlockAst(aCatch.block(), catchScope, type, callable);
				catchVar.owner = catchBody;
				return new TryCatchStatement.CatchStatement(catchType, varName, catchBody, catchScope, catchVar);
			}).toList();
			
			Statement finallyBlock;
			if(ts.finallyBlock() == null)
				finallyBlock = null;
			else{
				Scope finallyScope = new Scope(in);
				finallyBlock = fromBlockAst(ts.finallyBlock().block(), finallyScope, type, callable);
			}
			
			Scope mainTryScope = new Scope(in);
			Statement tryBody = fromBlockAst(ts.block(), mainTryScope, type, callable);
			result = new TryCatchStatement(in, tryBody, catches, finallyBlock, callable);
		}else if(ctx.breakStatement() != null) // TODO: labelled statements & break/continue
			result = new BreakStatement(in, callable);
		else if(ctx.continueStatement() != null)
			result = new ContinueStatement(in, callable);
		else
			result = new NoopStatement(in, callable);
		
		CompileTimeException.popContext();
		result.text = ctx;
		result.from = callable;
		return result;
	}
	
	@NotNull
	private static Statement fromBlockAst(CyclicLangParser.BlockContext ctx, Scope in, CyclicType type, CyclicCallable callable){
		Statement result;
		BlockStatement statement = new BlockStatement(in, callable);
		statement.contains = ctx.statement().stream().map(k -> fromAst(k, statement.blockScope, type, callable)).collect(Collectors.toList());
		result = statement;
		return result;
	}
	
	public static Statement createAssignStatement(Scope in, Value left, Value right, CyclicCallable from){
		// if the LHS is a local variable value, reuse the variable
		// if the LHS is a field value, assign to the field
		// if the LHS is an array index value, assign to the array
		return switch(left){
			case Value.LocalVarValue local -> new VarStatement(in, local.localName, null, right, false, false, from);
			case Value.FieldValue field -> new AssignFieldStatement(in, field.ref, field.from, right, from);
			case Value.ArrayIndexValue idx -> new AssignArrayStatement(in, idx.array, idx.index, right, idx.arrayType, from);
			case null, default -> throw new CompileTimeException("Can't assign value to " + left);
		};
	}
	
	public static class NoopStatement extends Statement{
		public NoopStatement(Scope in, CyclicCallable from){
			super(in, from);
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
		
		public BlockStatement(Scope in, CyclicCallable from){
			super(in, from);
			blockScope = new Scope(in);
		}
		
		public BlockStatement(List<Statement> statements, Scope in, CyclicCallable from){
			this(in, from);
			contains = statements;
			for(var s : statements)
				s.in = blockScope;
		}
		
		public BlockStatement(Function<Scope, List<Statement>> statements, Scope in, CyclicCallable from){
			this(in, from);
			contains = statements.apply(blockScope);
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			for(Statement s : contains)
				s.write(mv);
			Label endLabel = new Label();
			blockScope.end = endLabel;
			mv.visitLabel(endLabel);
		}
		
		public void simplify(){
			contains.forEach(Statement::simplify);
		}
	}
	
	public static class ReturnStatement extends Statement{
		public Value returnValue;
		private TypeReference toReturn;
		
		public ReturnStatement(Value returnValue, Scope in, TypeReference toReturn, CyclicCallable from){
			super(in, from);
			this.returnValue = returnValue;
			this.toReturn = toReturn;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			
			if(returnValue != null){
				var adjusted = returnValue.fit(toReturn);
				if(adjusted == null)
					throw new CompileTimeException(text, "Value of type \"" + returnValue.type().fullyQualifiedName() + "\" cannot be returned from method \"" + from.summary() + "\"");
				adjusted.write(mv);
			}
			
			Scope.InterferingScope attr = in.getAttributeInHierarchy(Scope.InterferingScope.class);
			if(attr != null)
				attr.writeReturn();
			else if(returnValue == null)
				mv.visitInsn(Opcodes.RETURN);
			else
				mv.visitInsn(returnValue.type().returnOpcode());
		}
		
		public void simplify(){
			if(returnValue != null)
				returnValue.simplify(this);
		}
	}
	
	public static class ThrowStatement extends Statement{
		public Value exceptionValue;
		
		public ThrowStatement(Value exceptionValue, Scope in, CyclicCallable from){
			super(in, from);
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
			exceptionValue.simplify(this);
		}
	}
	
	public static class VarStatement extends Statement{
		public Variable v;
		public Value value;
		public boolean declare;
		
		public VarStatement(Scope in, String varName, TypeReference varType, Value value, boolean declare, boolean isFinal, CyclicCallable from){
			super(in, from);
			if(declare)
				v = new Variable(varName, varType, in, this);
			else
				v = in.get(varName);
			v.isFinal |= isFinal;
			this.value = value;
			this.declare = declare;
		}
		
		// used by ForEachStyle
		public VarStatement(Scope in, Variable v, Value value, CyclicCallable from){
			this(in, v, false, value, from);
		}
		
		// used by ForEachStyle
		public VarStatement(Scope in, Variable v, boolean declare, Value value, CyclicCallable from){
			super(in, from);
			this.v = v;
			this.value = value;
			this.declare = declare;
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
				if(Compiler.project.include_debug){
					Label label = new Label();
					mv.visitLabel(label);
					if(declare)
						v.start = v.end = label;
					else if(v.end == null || v.end.getOffset() < label.getOffset())
						v.end = label;
				}
				v.writeStore(mv);
			}
		}
		
		public void simplify(){
			if(value != null)
				value.simplify(this);
		}
	}
	
	public static class CallStatement extends Statement{
		Value on;
		List<Value> args;
		MethodReference target;
		boolean isSuperCall; // to use invokespecial instead
		String name;
		
		// used by ForEachStyle
		public CallStatement(Scope in, Value on, MethodReference target, List<Value> args, CyclicCallable from){
			super(in, from);
			this.on = on;
			this.target = target;
			this.args = args;
		}
		
		public CallStatement(Scope in, Value on, String name, MethodReference target, List<Value> args, boolean isSuperCall, CyclicCallable from){
			super(in, from);
			this.on = on;
			this.args = args;
			this.target = target;
			this.isSuperCall = isSuperCall;
			this.name = name;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			if(on != null && !(target.isStatic() || on instanceof Value.TypeValue t && t.target.kind() != TypeKind.SINGLE))
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
			if(target == null)
				throw new CompileTimeException(text, "Could not find method " + name + " for args of types " + args.stream().map(Value::type).map(TypeReference::fullyQualifiedName).collect(Collectors.joining(", ", "[", "]")));
			if(on != null)
				on.simplify(this);
			args.forEach(value -> value.simplify(this));
		}
	}
	
	public static class CtorCallStatement extends Statement{
		public CallableReference target;
		List<Value> args;
		TypeReference of;
		
		public CtorCallStatement(Scope in, TypeReference of, CallableReference target, List<Value> args, CyclicCallable from){
			super(in, from);
			this.target = target;
			this.args = args;
			this.of = of;
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
			if(target == null){
				String candidates = of.constructors().stream().map(CallableReference::descriptor).collect(Collectors.joining(", "));
				String types = args.stream().map(Value::type).map(TypeReference::fullyQualifiedName).collect(Collectors.joining(", "));
				throw new CompileTimeException(text, "Could not find constructor for type %s given candidates [%s] for args of types [%s]".formatted(of.fullyQualifiedName(), candidates, types));
			}
			args.forEach(value -> value.simplify(this));
		}
	}
	
	public static class AssignFieldStatement extends Statement{
		FieldReference fieldRef;
		Value on;
		Value toSet;
		
		public AssignFieldStatement(Scope in, FieldReference fieldRef, Value on, Value toSet, CyclicCallable from){
			super(in, from);
			this.fieldRef = fieldRef;
			this.on = (on instanceof Value.TypeValue t && t.target.kind() != TypeKind.SINGLE) ? null : on;
			this.toSet = toSet;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			if(!fieldRef.isStatic()){
				if(on != null)
					on.write(mv);
				else
					mv.visitVarInsn(Opcodes.ALOAD, 0);
			}
			toSet.write(mv);
			fieldRef.writePut(mv);
		}
		
		public void simplify(){
			if(on != null)
				on.simplify(this);
			toSet.simplify(this);
		}
	}
	
	public static class AssignArrayStatement extends Statement{
		Value on, index, val;
		ArrayTypeRef arrayType;
		
		public AssignArrayStatement(Scope in, Value on, Value index, Value val, ArrayTypeRef arrayType, CyclicCallable from){
			super(in, from);
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
			on.simplify(this);
			index.simplify(this);
			val.simplify(this);
		}
	}
	
	public static class IfStatement extends Statement{
		public Statement success, fail;
		Value condition;
		
		public IfStatement(Scope in, Statement success, Statement fail, Value condition, CyclicCallable from){
			super(in, from);
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
			condition.simplify(this);
		}
	}
	
	public static class WhileStatement extends Statement{
		public Statement success;
		Value condition;
		
		public WhileStatement(Scope in, Statement success, Value condition, CyclicCallable from){
			super(in, from);
			this.success = success;
			this.condition = condition;
		}
		
		public WhileStatement(Scope in, List<Statement> success, Value condition, CyclicCallable from){
			super(in, from);
			this.condition = condition;
			BlockStatement block = new BlockStatement(in, from);
			for(var s : success)
				s.in = block.blockScope;
			block.contains = success;
			this.success = block;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			Label postWrite = new Label(), preCheck = new Label();
			success.in.putAttribute(new Scope.BreakingScope(postWrite));
			success.in.putAttribute(new Scope.ContinuingScope(preCheck));
			mv.visitLabel(preCheck);
			condition.write(mv);
			mv.visitJumpInsn(Opcodes.IFEQ, postWrite); // if false, skip
			success.write(mv); // success block
			mv.visitJumpInsn(Opcodes.GOTO, preCheck); // check again
			mv.visitLabel(postWrite);
		}
		
		public void simplify(){
			success.simplify();
			condition.simplify(this);
		}
	}
	
	public static class ForStatement extends Statement{
		public Statement success, start, increment;
		Value condition;
		private boolean ownsScope;
		
		public ForStatement(Scope in, Statement success, Statement start, Statement increment, Value condition, CyclicCallable from, boolean ownsScope){
			super(in, from);
			this.success = success;
			this.start = start;
			this.increment = increment;
			this.condition = condition;
			this.ownsScope = ownsScope;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			Label postWrite = new Label(), preCheck = new Label(), continueLabel = new Label();
			success.in.putAttribute(new Scope.BreakingScope(postWrite));
			success.in.putAttribute(new Scope.ContinuingScope(continueLabel));
			start.write(mv);
			mv.visitLabel(preCheck);
			condition.write(mv);
			mv.visitJumpInsn(Opcodes.IFEQ, postWrite); // if false, skip
			success.write(mv); // success block
			mv.visitLabel(continueLabel); // we need to run the increment
			increment.write(mv);
			mv.visitJumpInsn(Opcodes.GOTO, preCheck); // check again
			mv.visitLabel(postWrite);
			if(ownsScope){
				Label endLabel = new Label();
				in.end = endLabel;
				mv.visitLabel(endLabel);
			}
		}
		
		public void simplify(){
			success.simplify();
			start.simplify();
			increment.simplify();
			condition.simplify(this);
		}
	}
	
	public static class DoWhileStatement extends Statement{
		public Statement success;
		Value condition;
		private boolean ownsScope;
		
		public DoWhileStatement(Scope in, Statement success, Value condition, CyclicCallable from, boolean ownsScope){
			super(in, from);
			this.success = success;
			this.condition = condition;
			this.ownsScope = ownsScope;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			Label preWrite = new Label(), preCheck = new Label(), postWrite = new Label();
			success.in.putAttribute(new Scope.BreakingScope(postWrite));
			success.in.putAttribute(new Scope.ContinuingScope(preCheck));
			mv.visitLabel(preWrite);
			success.write(mv);
			
			mv.visitLabel(preCheck);
			condition.write(mv);
			mv.visitJumpInsn(Opcodes.IFNE, preWrite);
			mv.visitLabel(postWrite);
			if(ownsScope){
				Label endLabel = new Label();
				in.end = endLabel;
				mv.visitLabel(endLabel);
			}
		}
		
		public void simplify(){
			success.simplify();
			condition.simplify(this);
		}
	}
	
	public static class ValueStatement extends Statement{
		// TODO: refactor CallStatement, VarStatement, Assign*Statement to use their Value counterparts
		Value value;
		
		public ValueStatement(Scope in, @NotNull CyclicCallable from, Value value){
			super(in, from);
			this.value = value;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			value.write(mv);
			mv.visitInsn(Opcodes.POP);
		}
		
		public void simplify(){
			value.simplify(this);
		}
	}
	
	public static class TryCatchStatement extends Statement{
		public record CatchStatement(TypeReference type, String name, Statement onCatch, Scope ownScope, Variable catchVariable){}
		
		public Statement tryStatement;
		public List<CatchStatement> catchStatements;
		public Statement finallyStatement;
		
		public TryCatchStatement(Scope in, Statement tryStatement, List<CatchStatement> catchStatements, Statement finallyStatement, CyclicCallable from){
			super(in, from);
			this.tryStatement = tryStatement;
			this.catchStatements = catchStatements;
			this.finallyStatement = finallyStatement;
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			Label blockStart = new Label(),
					blockEnd = new Label(),
					tryEnd = new Label(),
					rethrowingFinallyStart = new Label(),
					returningFinallyStart = new Label(),
					finallyEnd = new Label();
			Map<CatchStatement, Label> handlerStarts = catchStatements.stream()
					.collect(Collectors.toMap(x -> x, x -> new Label()));
			Map<CatchStatement, Label> handlerEnds = catchStatements.stream()
					.collect(Collectors.toMap(x -> x, x -> new Label()));
			
			AtomicBoolean hasInterferedReturn = new AtomicBoolean(false);
			
			for(var c : catchStatements)
				mv.visitTryCatchBlock(blockStart, blockEnd, handlerStarts.get(c), c.type().internalName());
			if(finallyStatement != null){
				mv.visitTryCatchBlock(blockStart, blockEnd, rethrowingFinallyStart, null);
				Scope.InterferingScope interferingScope = new Scope.InterferingScope(() -> {
					hasInterferedReturn.set(true);
					mv.visitJumpInsn(Opcodes.GOTO, returningFinallyStart);
				});
				tryStatement.in.putAttribute(interferingScope);
				for(var c : catchStatements){
					mv.visitTryCatchBlock(handlerStarts.get(c), handlerEnds.get(c), rethrowingFinallyStart, null);
					c.ownScope().putAttribute(interferingScope);
				}
			}
			
			mv.visitLabel(blockStart);
			tryStatement.write(mv);
			mv.visitLabel(blockEnd);
			mv.visitJumpInsn(Opcodes.GOTO, tryEnd);
			
			for(var c : catchStatements){
				Label start = handlerStarts.get(c);
				Label end = handlerEnds.get(c);
				mv.visitLabel(start);
				c.catchVariable().writeStore(mv);
				c.onCatch().write(mv);
				mv.visitLabel(end);
				mv.visitJumpInsn(Opcodes.GOTO, tryEnd);
				c.ownScope().end = end;
			}
			mv.visitLabel(tryEnd);
			
			if(finallyStatement != null){
				// non-rethrowing version
				finallyStatement.write(mv);
				mv.visitJumpInsn(Opcodes.GOTO, finallyEnd);
				
				// returning version
				if(hasInterferedReturn.get()){
					mv.visitLabel(returningFinallyStart);
					finallyStatement.write(mv);
					
					TypeReference returns = from instanceof MethodReference ? ((MethodReference)from).returns() : null;
					// consider nested interfering scopes
					var intrAttr = in.getAttributeInHierarchy(Scope.InterferingScope.class);
					if(intrAttr != null)
						intrAttr.writeReturn();
					else if(returns == null)
						mv.visitInsn(Opcodes.RETURN);
					else
						mv.visitInsn(returns.returnOpcode());
				}
				
				// rethrowing version
				mv.visitLabel(rethrowingFinallyStart);
				finallyStatement.write(mv);
				mv.visitInsn(Opcodes.ATHROW);
			}
			mv.visitLabel(finallyEnd);
		}
		
		public void simplify(){
			tryStatement.simplify();
			for(var c : catchStatements)
				c.onCatch().simplify();
			if(finallyStatement != null)
				finallyStatement.simplify();
		}
	}
	
	public static class BreakStatement extends Statement{
		public BreakStatement(Scope in, CyclicCallable from){
			super(in, from);
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			Scope.BreakingScope attr = in.getAttributeInHierarchy(Scope.BreakingScope.class);
			if(attr == null)
				throw new CompileTimeException(text, "Cannot break outside of a breaking scope (i.e. a loop)");
			mv.visitJumpInsn(Opcodes.GOTO, attr.endLabel());
		}
		
		public void simplify(){}
	}
	
	public static class ContinueStatement extends Statement{
		public ContinueStatement(Scope in, CyclicCallable from){
			super(in, from);
		}
		
		public void write(MethodVisitor mv){
			super.write(mv);
			Scope.ContinuingScope attr = in.getAttributeInHierarchy(Scope.ContinuingScope.class);
			if(attr == null)
				throw new CompileTimeException(text, "Cannot continue outside of a continuing scope (i.e. a loop)");
			mv.visitJumpInsn(Opcodes.GOTO, attr.restartLabel());
		}
		
		public void simplify(){}
	}
}