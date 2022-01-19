package cyclic.lang.compiler.model.instructions;

import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.Utils;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.resolve.PlatformDependency;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.function.Function;

import static cyclic.lang.compiler.Constants.*;
import static cyclic.lang.compiler.gen.Operations.BinaryOpValue;
import static cyclic.lang.compiler.gen.Operations.BranchBoolBinaryOpValue;
import static cyclic.lang.compiler.model.instructions.Statement.*;
import static cyclic.lang.compiler.model.instructions.Value.*;

public interface ForEachStyle{
	
	List<ForEachStyle> STYLES = List.of(new IteratorForEach(), new ArrayForEach());
	
	boolean appliesTo(TypeReference iteratorType);
	
	// null varType = var/val
	Statement forEachStatement(Value iterating, String varName, TypeReference varType, boolean finalVar, Scope in, Function<Scope, Statement> body);
	
	class IteratorForEach implements ForEachStyle{
		
		public boolean appliesTo(TypeReference iteratorType){
			return iteratorType.isAssignableTo(TypeResolver.resolveFq(ITERABLE));
		}
		
		public Statement forEachStatement(Value iterating, String varName, TypeReference varType, boolean finalVar, Scope in, Function<Scope, Statement> body){
			// TODO: check T against the iterator's generic type
			if(varType != null && !varType.fullyQualifiedName().equals(OBJECT))
				throw new CompileTimeException("Variable type of an iterator for-each loop must be Object or var");
			/*    for(T t : x)
			 *         act;
			 *  becomes
			 *     Objects.requireNonNull(x);
			 *     Iterator iter = x.iterator();
			 *     while(iter.hasNext())
			 *         T t = iter.next();
			 *         act;
			 */
			BlockStatement container = new BlockStatement(in);
			var iteratorType = TypeResolver.resolveFq(ITERATOR);
			Variable iterator = new Variable("~", iteratorType, container.blockScope, null);
			Variable iterationVar = new Variable(varName, varType != null ? varType : TypeResolver.resolveFq(OBJECT), container.blockScope, container);
			iterationVar.isFinal = finalVar;
			Statement action = body.apply(container.blockScope);
			container.contains = List.of(
					new CallStatement(container.blockScope, null, Utils.resolveSingleMethod(OBJECTS, OBJECTS_REQUIRE_NONNULL, true, OBJECT, STRING), List.of(iterating, new StringLiteralValue("Iteration variable was null."))),
					new VarStatement(container.blockScope, iterator, new CallValue(iterating, List.of(), Utils.resolveSingleMethod(ITERABLE, ITERABLE_ITERATOR, false))),
					new WhileStatement(container.blockScope,
							List.of(new VarStatement(container.blockScope, iterationVar, new CallValue(new LocalVarValue(iterator), List.of(), Utils.resolveSingleMethod(ITERATOR, ITERATOR_NEXT, false))),
									action),
							new CallValue(new LocalVarValue(iterator), List.of(), Utils.resolveSingleMethod(ITERATOR, ITERATOR_HAS_NEXT, false)))
			);
			return container;
		}
	}
	
	class ArrayForEach implements ForEachStyle{
		
		public boolean appliesTo(TypeReference iteratorType){
			return iteratorType instanceof ArrayTypeRef;
		}
		
		public Statement forEachStatement(Value iterating, String varName, TypeReference varType, boolean finalVar, Scope in, Function<Scope, Statement> body){
			/*    for(T t : x)
			 *         act;
			 *  becomes
			 *     for(int i = 0; i < x.length; i += 1;)
			 *         T t = x[i];
			 *         act;
			 */
			var component = ((ArrayTypeRef)iterating.type()).getComponent();
			if(varType != null && !component.isAssignableTo(varType))
				throw new CompileTimeException("Variable type of an array for-each loop must be a subtype of the array type");
			BlockStatement container = new BlockStatement(in);
			Variable array = new Variable("~", iterating.type(), container.blockScope, null);
			Variable index = new Variable("~", PlatformDependency.INT, container.blockScope, null);
			Variable iterationVar = new Variable(varName, varType != null ? varType : component, container.blockScope, container);
			iterationVar.isFinal = finalVar;
			Statement action = body.apply(container.blockScope);
			container.contains = List.of(
					new VarStatement(container.blockScope, array, iterating),
					new ForStatement(container.blockScope,
							new BlockStatement(scope -> List.of(new VarStatement(scope, iterationVar, new ArrayIndexValue(new LocalVarValue(array), new LocalVarValue(index))), action), container.blockScope),
							new VarStatement(container.blockScope, index, new IntLiteralValue(0)),
							new VarStatement(container.blockScope, index, new BinaryOpValue(PlatformDependency.INT, Opcodes.IADD, new LocalVarValue(index), new IntLiteralValue(1))),
							new BranchBoolBinaryOpValue(PlatformDependency.BOOLEAN, Opcodes.IF_ICMPLT, new LocalVarValue(index), new FieldValue(Utils.getField(iterating.type(), "length"), new LocalVarValue(array))))
			);
			return container;
		}
	}
}