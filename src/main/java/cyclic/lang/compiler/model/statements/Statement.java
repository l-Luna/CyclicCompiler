package cyclic.lang.compiler.model.statements;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.model.MethodReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.TypeResolver;
import cyclic.lang.compiler.model.cyclic.CyclicMethod;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class Statement{
	
	Scope in;
	
	public Statement(Scope in){
		this.in = in;
	}
	
	public void write(MethodVisitor mv){}
	
	public static Statement fromAst(CyclicLangParser.StatementContext ctx, Scope in, List<String> imports, CyclicMethod method){
		if(ctx.block() != null)
			return new BlockStatement(ctx.block().statement().stream().map(k -> fromAst(k, in, imports, method)).collect(Collectors.toList()), in);
		else if(ctx.varDecl() != null)
			return new VarStatement(in, ctx.varDecl().id().getText(), TypeResolver.resolveOptional(ctx.varDecl().type().getText(), imports).orElseThrow(), ctx.varDecl().value() != null ? Value.fromAst(ctx.varDecl().value(), imports, method) : null, true);
		else if(ctx.varAssignment() != null)
			return new VarStatement(in, ctx.varAssignment().id().getText(), null, Value.fromAst(ctx.varAssignment().value(), imports, method), false);
		else if(ctx.call() != null){
			if(ctx.value() == null)
				throw new IllegalStateException("can't yet call static methods");
			Value on = Value.fromAst(ctx.value(), imports, method);
			List<Value> args = ctx.call().arguments().value().stream().map(x -> Value.fromAst(x, imports, method)).toList();
			Optional<MethodReference> found = Optional.empty();
			candidates:
			for(MethodReference x : on.type().methods())
				if(x.name().equals(ctx.call().ID().getText())){
					List<TypeReference> parameters = x.parameters();
					if(parameters.size() != args.size())
						continue;
					for(int i = 0; i < parameters.size(); i++)
						if(!args.get(i).type().isAssignableTo(parameters.get(i)))
							continue candidates;
					found = Optional.of(x);
					break;
				}
			return new CallStatement(in, on, found.orElseThrow(), args);
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
		Scope blockScope = new Scope();
		List<Statement> contains;
		
		public BlockStatement(List<Statement> contains, Scope in){
			super(in);
			this.contains = contains;
			for(Statement s : contains)
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
			
			returnValue.write(mv); // TODO: should I switch on variable type or value type?
			if(returnValue.type() instanceof PrimitiveTypeRef prim && prim.type != PrimitiveTypeRef.Primitive.NULL){
				mv.visitInsn(switch(prim.type){
					case BYTE, SHORT, INT, BOOLEAN, CHAR -> Opcodes.IRETURN;
					case LONG -> Opcodes.LRETURN;
					case FLOAT -> Opcodes.FRETURN;
					case DOUBLE -> Opcodes.DRETURN;
					case VOID, NULL -> throw new IllegalArgumentException("Tried to return a void value!");
				});
			}else
				mv.visitInsn(Opcodes.ARETURN);
		}
	}
	
	public static class VarStatement extends Statement{
		
		Variable v;
		Value value;
		
		public VarStatement(Scope in, String varName, TypeReference varType, Value value, boolean declare){
			super(in);
			if(declare)
				v = new Variable(varName, varType, in, this);
			else
				v = in.get(varName);
			this.value = value;
		}
		
		public void write(MethodVisitor mv){
			if(value != null){
				value.write(mv);
				if(v.type instanceof PrimitiveTypeRef prim && prim.type != PrimitiveTypeRef.Primitive.NULL)
					mv.visitVarInsn(switch(prim.type){
						case BYTE, SHORT, INT, BOOLEAN, CHAR -> Opcodes.ISTORE;
						case LONG -> Opcodes.LSTORE;
						case FLOAT -> Opcodes.FSTORE;
						case DOUBLE -> Opcodes.DSTORE;
						case VOID, NULL -> throw new IllegalArgumentException("Tried to store a void value in a local variable!");
					}, v.getVarIndex());
				else
					mv.visitVarInsn(Opcodes.ASTORE, v.getVarIndex());
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
			for(var v : args)
				v.write(mv);
			target.writeInvoke(mv);
		}
	}
}