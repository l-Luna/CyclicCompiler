package cyclic.lang.compiler.model.instructions;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.configuration.dependencies.PlatformDependency;
import cyclic.lang.compiler.model.TypeKind;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import cyclic.lang.compiler.model.cyclic.CyclicCallable;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.problems.CompileTimeException;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.function.Function;

import static cyclic.lang.compiler.Constants.*;
import static cyclic.lang.compiler.gen.Operations.BinaryOpValue;
import static cyclic.lang.compiler.gen.Operations.BranchBoolBinaryOpValue;
import static cyclic.lang.compiler.model.instructions.Statement.*;
import static cyclic.lang.compiler.model.instructions.Value.*;

public interface ForEachStyle{
	
	List<ForEachStyle> STYLES = List.of(new IteratorForEach(), new ArrayForEach(), new EnumForEach());
	
	default boolean appliesTo(Value value){
		return appliesTo(value.type());
	}
	
	boolean appliesTo(TypeReference iteratorType);
	
	// null varType = var/val
	Statement forEachStatement(Value iterating, String varName, TypeReference varType, boolean finalVar, Scope in, Function<Scope, Statement> body, CyclicCallable from, CyclicLangParser.ForeachStatementContext text);
	
	class IteratorForEach implements ForEachStyle{
		
		public boolean appliesTo(TypeReference iteratorType){
			return iteratorType.isAssignableTo(TypeResolver.resolveFq(ITERABLE));
		}
		
		public Statement forEachStatement(Value iterating, String varName, TypeReference varType, boolean finalVar, Scope in, Function<Scope, Statement> body, CyclicCallable c, CyclicLangParser.ForeachStatementContext text){
			// TODO: check T against the iterator's generic type
			if(varType != null && !varType.fullyQualifiedName().equals(OBJECT))
				throw new CompileTimeException(text.typeOrInferred(), "Variable type of an iterator for-each loop must be Object or var");
			return forEachStatementWithType(iterating, varName, varType, finalVar, in, body, c);
		}
		
		@NotNull
		protected static BlockStatement forEachStatementWithType(Value iterating, String varName, TypeReference varType, boolean finalVar, Scope in, Function<Scope, Statement> body, CyclicCallable c){
			/*    for(T t : x)
			 *         act;
			 *  becomes
			 *     Objects.requireNonNull(x);
			 *     Iterator iter = x.iterator();
			 *     while(iter.hasNext())
			 *         T t = iter.next();
			 *         act;
			 */
			BlockStatement container = new BlockStatement(in, c);
			var iteratorType = TypeResolver.resolveFq(ITERATOR);
			Variable iterator = new Variable("~iterator", iteratorType, container.blockScope, null);
			TypeReference iterVarType = varType != null ? varType : TypeResolver.resolveFq(OBJECT);
			Variable iterationVar = new Variable(varName, iterVarType, container.blockScope, container);
			iterationVar.isFinal = finalVar;
			Statement action = body.apply(container.blockScope);
			container.contains = List.of(
					new CallStatement(container.blockScope, null, Utils.resolveSingleMethod(OBJECTS, OBJECTS_REQUIRE_NONNULL, true, OBJECT, STRING), List.of(iterating, new StringLiteralValue("Iteration variable was null.")), c),
					new VarStatement(container.blockScope, iterator, new CallValue(iterating, List.of(), Utils.resolveSingleMethod(ITERABLE, ITERABLE_ITERATOR, false)), c),
					new WhileStatement(container.blockScope,
							List.of(new VarStatement(container.blockScope, iterationVar, true, new ClassCastValue(new CallValue(new LocalVarValue(iterator), List.of(), Utils.resolveSingleMethod(ITERATOR, ITERATOR_NEXT, false)), iterVarType), c),
									action),
							new CallValue(new LocalVarValue(iterator), List.of(), Utils.resolveSingleMethod(ITERATOR, ITERATOR_HAS_NEXT, false)), c)
			);
			return container;
		}
	}
	
	class ArrayForEach implements ForEachStyle{
		
		public boolean appliesTo(TypeReference iteratorType){
			return iteratorType instanceof ArrayTypeRef;
		}
		
		public Statement forEachStatement(Value iterating, String varName, TypeReference varType, boolean finalVar, Scope in, Function<Scope, Statement> body, CyclicCallable c, CyclicLangParser.ForeachStatementContext text){
			return forEachStatementInner(iterating, varName, varType, finalVar, in, body, c, text);
		}
		
		@NotNull
		protected static Statement forEachStatementInner(Value iterating, String varName, TypeReference varType, boolean finalVar, Scope in, Function<Scope, Statement> body, CyclicCallable c, CyclicLangParser.ForeachStatementContext text){
			/*    for(T t : x)
			 *         act;
			 *  becomes
			 *     for(int i = 0; i < x.length; i += 1;)
			 *         T t = x[i];
			 *         act;
			 */
			var component = ((ArrayTypeRef)iterating.type()).getComponent();
			if(varType != null && !component.isAssignableTo(varType))
				throw new CompileTimeException(text.typeOrInferred(), "Variable type of an array for-each loop must be a subtype of the array component type");
			BlockStatement container = new BlockStatement(in, c);
			Variable array = new Variable("~array", iterating.type(), container.blockScope, null);
			Variable index = new Variable("~idx", PlatformDependency.INT, container.blockScope, null);
			Variable iterationVar = new Variable(varName, varType != null ? varType : component, container.blockScope, container);
			iterationVar.isFinal = finalVar;
			Statement action = body.apply(container.blockScope);
			container.contains = List.of(
					new VarStatement(container.blockScope, array, iterating, c),
					new ForStatement(container.blockScope,
							new BlockStatement(scope -> List.of(new VarStatement(scope, iterationVar, true, new ArrayIndexValue(new LocalVarValue(array), new LocalVarValue(index)), c), action), container.blockScope, c),
							new VarStatement(container.blockScope, index, new IntLiteralValue(0), c),
							new VarStatement(container.blockScope, index, new BinaryOpValue(PlatformDependency.INT, Opcodes.IADD, new LocalVarValue(index), new IntLiteralValue(1)), c),
							new BranchBoolBinaryOpValue(Opcodes.IF_ICMPLT, new LocalVarValue(index), new FieldValue(Utils.getField(iterating.type(), "length"), new LocalVarValue(array))),
							c, false)
			);
			return container;
		}
	}
	
	class EnumForEach implements ForEachStyle{
		
		public boolean appliesTo(TypeReference iteratorType){
			return iteratorType.isAssignableTo(Utils.forAnyClass(Enum.class));
		}
		
		public boolean appliesTo(Value value){
			return ForEachStyle.super.appliesTo(value) && value instanceof TypeValue t && t.target.kind() == TypeKind.ENUM;
		}
		
		public Statement forEachStatement(Value iterating, String varName, TypeReference varType, boolean finalVar, Scope in, Function<Scope, Statement> body, CyclicCallable from, CyclicLangParser.ForeachStatementContext text){
			/*
			*     for(T t : T)
			*         act;
			*  becomes
			*     for(T t : T.entries())
			*         act;
			*  where T extends Enum and entries() exists
			*  otherwise fall back to T.values()
			*/
			TypeReference type = iterating.type();
			if(varType != null && !type.isAssignableTo(varType))
				throw new CompileTimeException(text.typeOrInferred(), "Variable type of an enum for-each loop must be the enum type");
			var entries = Utils.resolveSingleOptionalMethod(type, "entries", true);
			if(entries.isPresent()){
				var entriesExpr = new CallValue(null, List.of(), entries.get());
				return IteratorForEach.forEachStatementWithType(entriesExpr, varName, type, finalVar, in, body, from);
			}else{
				var values = Utils.resolveSingleMethod(type, "values", true);
				var valuesExpr = new CallValue(null, List.of(), values);
				return ArrayForEach.forEachStatementInner(valuesExpr, varName, varType, finalVar, in, body, from, text);
			}
		}
	}
}