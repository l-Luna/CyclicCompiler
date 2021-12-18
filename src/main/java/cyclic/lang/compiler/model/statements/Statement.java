package cyclic.lang.compiler.model.statements;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.MethodReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.TypeResolver;
import cyclic.lang.compiler.model.Utils;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Statement{
	
	Scope in;
	
	public Statement(Scope in){
		this.in = in;
	}
	
	public void write(MethodVisitor mv){}
	
	public static Statement fromAst(CyclicLangParser.StatementContext ctx, Scope in, CyclicType type, CyclicMethod method){
		var imports = type.imports;
		if(ctx.block() != null){
			BlockStatement statement = new BlockStatement(in);
			statement.contains = ctx.block().statement().stream().map(k -> fromAst(k, statement.blockScope, type, method)).collect(Collectors.toList());
			return statement;
		}else if(ctx.varDecl() != null){
			boolean isFinal = ctx.varDecl().modifiers().modifier().stream().anyMatch(x -> x.getText().equals("final")) || ctx.varDecl().type().getText().equals("val");
			boolean infer = ctx.varDecl().type().getText().equals("var") || ctx.varDecl().type().getText().equals("val");
			Value initial = ctx.varDecl().value() != null ? Value.fromAst(ctx.varDecl().value(), in, type, method) : null;
			if(infer && initial == null)
				throw new IllegalStateException("Can't infer the type of a variable without an initial value.");
			return new VarStatement(in, ctx.varDecl().id().getText(), infer ? initial.type() :  TypeResolver.resolve(ctx.varDecl().type().getText(), imports, type.packageName()), initial, true, isFinal);
		}else if(ctx.varAssignment() != null)
			return new VarStatement(in, ctx.varAssignment().id().getText(), null, Value.fromAst(ctx.varAssignment().value(), in, type, method), false, false);
		else if(ctx.call() != null){
			Value on = ctx.value() != null ? Value.fromAst(ctx.value(), in, type, method) : null;
			List<Value> args = ctx.call().arguments().value().stream().map(x -> Value.fromAst(x, in, type, method)).toList();
			return new CallStatement(in, on, Utils.resolveMethod(ctx.call().ID().getText(), on, args, method), args);
		}
		
		return new NoopStatement(in);
	}
	
	public static class NoopStatement extends Statement{
		public NoopStatement(Scope in){
			super(in);
		}
		
		public void write(MethodVisitor mv){
			// explicit no-op for debugging
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
			for(Statement s : contains)
				s.write(mv);
		}
	}
	
	public static class ReturnStatement extends Statement{
		Value returnValue;
		
		public ReturnStatement(Value returnValue, Scope in){
			super(in);
			this.returnValue = returnValue;
		}
		
		public void write(MethodVisitor mv){
			if(returnValue == null){
				mv.visitInsn(Opcodes.RETURN);
				return;
			}
			
			returnValue.write(mv);
			mv.visitInsn(returnValue.type().returnOpcode());
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
		
		public void write(MethodVisitor mv){
			if(v.isFinal && this != v.owner){
				throw new IllegalStateException("Can't assign the value of a final local variable outside of its declaration.");
			}
			if(value != null){
				var adjusted = value.fit(v.type);
				if(adjusted == null)
					throw new IllegalStateException("Value of type " + value.type().fullyQualifiedName() + " cannot be assigned to local variable of type " + v.type.fullyQualifiedName() + "!");
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
			if(on != null && !(on instanceof Value.TypeValue)) // TODO: consider singletons
				on.write(mv);
			// implicit this for instance method calls with no explicit value
			if(on == null && !target.isStatic())
				mv.visitVarInsn(Opcodes.ALOAD, 0);
			for(var v : args)
				v.write(mv);
			target.writeInvoke(mv);
		}
	}
}