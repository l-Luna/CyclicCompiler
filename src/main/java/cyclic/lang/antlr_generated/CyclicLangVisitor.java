package cyclic.lang.antlr_generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CyclicLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CyclicLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(CyclicLangParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#packageDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDecl(CyclicLangParser.PackageDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports(CyclicLangParser.ImportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#importDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDecl(CyclicLangParser.ImportDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(CyclicLangParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#objectExtends}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectExtends(CyclicLangParser.ObjectExtendsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#objectImplements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectImplements(CyclicLangParser.ObjectImplementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#objectPermits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectPermits(CyclicLangParser.ObjectPermitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#genericTypeDefs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericTypeDefs(CyclicLangParser.GenericTypeDefsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#genericTypeDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericTypeDef(CyclicLangParser.GenericTypeDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#objectType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectType(CyclicLangParser.ObjectTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#recordComponents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordComponents(CyclicLangParser.RecordComponentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(CyclicLangParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(CyclicLangParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(CyclicLangParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(CyclicLangParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#functionBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBlock(CyclicLangParser.FunctionBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#functionArrow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArrow(CyclicLangParser.FunctionArrowContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(CyclicLangParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(CyclicLangParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(CyclicLangParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CyclicLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CyclicLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(CyclicLangParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#annotationArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationArg(CyclicLangParser.AnnotationArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CyclicLangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#genericTypeUses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericTypeUses(CyclicLangParser.GenericTypeUsesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#genericTypeUse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericTypeUse(CyclicLangParser.GenericTypeUseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawType(CyclicLangParser.RawTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#modifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiers(CyclicLangParser.ModifiersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisValue(CyclicLangParser.ThisValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastValue(CyclicLangParser.CastValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayIndexValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayIndexValue(CyclicLangParser.ArrayIndexValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoValue(CyclicLangParser.DoValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryOpValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOpValue(CyclicLangParser.UnaryOpValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLit(CyclicLangParser.NullLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code initialisationValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialisationValue(CyclicLangParser.InitialisationValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newListedArrayValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewListedArrayValue(CyclicLangParser.NewListedArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenValue(CyclicLangParser.ParenValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArrayValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayValue(CyclicLangParser.NewArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instanceCheckValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceCheckValue(CyclicLangParser.InstanceCheckValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassValue(CyclicLangParser.ClassValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrLit(CyclicLangParser.StrLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarValue(CyclicLangParser.VarValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOpValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOpValue(CyclicLangParser.BinaryOpValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLit(CyclicLangParser.BoolLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecLit(CyclicLangParser.DecLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLit(CyclicLangParser.IntLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionValue(CyclicLangParser.FunctionValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code switchValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchValue(CyclicLangParser.SwitchValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inlineDecleration}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineDecleration(CyclicLangParser.InlineDeclerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#initialisation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialisation(CyclicLangParser.InitialisationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#cast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCast(CyclicLangParser.CastContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#varAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignment(CyclicLangParser.VarAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(CyclicLangParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#ctorCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtorCall(CyclicLangParser.CtorCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#newArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArray(CyclicLangParser.NewArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#newListedArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewListedArray(CyclicLangParser.NewListedArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(CyclicLangParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(CyclicLangParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(CyclicLangParser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(CyclicLangParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(CyclicLangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(CyclicLangParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(CyclicLangParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(CyclicLangParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#foreachStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeachStatement(CyclicLangParser.ForeachStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#doWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhile(CyclicLangParser.DoWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(CyclicLangParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#caseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseClause(CyclicLangParser.CaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(CyclicLangParser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#yieldStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(CyclicLangParser.YieldStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#binaryop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryop(CyclicLangParser.BinaryopContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#unaryop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryop(CyclicLangParser.UnaryopContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(CyclicLangParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#idPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdPart(CyclicLangParser.IdPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link CyclicLangParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(CyclicLangParser.ModifierContext ctx);
}