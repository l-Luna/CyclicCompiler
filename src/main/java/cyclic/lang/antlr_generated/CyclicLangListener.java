package cyclic.lang.antlr_generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CyclicLangParser}.
 */
public interface CyclicLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(CyclicLangParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(CyclicLangParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void enterPackageDecl(CyclicLangParser.PackageDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void exitPackageDecl(CyclicLangParser.PackageDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(CyclicLangParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(CyclicLangParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void enterImportDecl(CyclicLangParser.ImportDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void exitImportDecl(CyclicLangParser.ImportDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(CyclicLangParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(CyclicLangParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#objectExtends}.
	 * @param ctx the parse tree
	 */
	void enterObjectExtends(CyclicLangParser.ObjectExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#objectExtends}.
	 * @param ctx the parse tree
	 */
	void exitObjectExtends(CyclicLangParser.ObjectExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#objectImplements}.
	 * @param ctx the parse tree
	 */
	void enterObjectImplements(CyclicLangParser.ObjectImplementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#objectImplements}.
	 * @param ctx the parse tree
	 */
	void exitObjectImplements(CyclicLangParser.ObjectImplementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#objectType}.
	 * @param ctx the parse tree
	 */
	void enterObjectType(CyclicLangParser.ObjectTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#objectType}.
	 * @param ctx the parse tree
	 */
	void exitObjectType(CyclicLangParser.ObjectTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#member}.
	 * @param ctx the parse tree
	 */
	void enterMember(CyclicLangParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#member}.
	 * @param ctx the parse tree
	 */
	void exitMember(CyclicLangParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(CyclicLangParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(CyclicLangParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(CyclicLangParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(CyclicLangParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(CyclicLangParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(CyclicLangParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#functionBlock}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBlock(CyclicLangParser.FunctionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#functionBlock}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBlock(CyclicLangParser.FunctionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#functionArrow}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArrow(CyclicLangParser.FunctionArrowContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#functionArrow}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArrow(CyclicLangParser.FunctionArrowContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(CyclicLangParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(CyclicLangParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(CyclicLangParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(CyclicLangParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CyclicLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CyclicLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CyclicLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CyclicLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(CyclicLangParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(CyclicLangParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CyclicLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CyclicLangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(CyclicLangParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(CyclicLangParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void enterDecType(CyclicLangParser.DecTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void exitDecType(CyclicLangParser.DecTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code byteType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void enterByteType(CyclicLangParser.ByteTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code byteType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void exitByteType(CyclicLangParser.ByteTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(CyclicLangParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(CyclicLangParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(CyclicLangParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(CyclicLangParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inferType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void enterInferType(CyclicLangParser.InferTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inferType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void exitInferType(CyclicLangParser.InferTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inferFinalType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void enterInferFinalType(CyclicLangParser.InferFinalTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inferFinalType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void exitInferFinalType(CyclicLangParser.InferFinalTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void enterIdType(CyclicLangParser.IdTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idType}
	 * labeled alternative in {@link CyclicLangParser#rawType}.
	 * @param ctx the parse tree
	 */
	void exitIdType(CyclicLangParser.IdTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(CyclicLangParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(CyclicLangParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#modifiers}.
	 * @param ctx the parse tree
	 */
	void enterModifiers(CyclicLangParser.ModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#modifiers}.
	 * @param ctx the parse tree
	 */
	void exitModifiers(CyclicLangParser.ModifiersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterThisValue(CyclicLangParser.ThisValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitThisValue(CyclicLangParser.ThisValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code castValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterCastValue(CyclicLangParser.CastValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code castValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitCastValue(CyclicLangParser.CastValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterDoValue(CyclicLangParser.DoValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitDoValue(CyclicLangParser.DoValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryOpValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOpValue(CyclicLangParser.UnaryOpValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryOpValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOpValue(CyclicLangParser.UnaryOpValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNullLit(CyclicLangParser.NullLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNullLit(CyclicLangParser.NullLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code initialisationValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterInitialisationValue(CyclicLangParser.InitialisationValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code initialisationValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitInitialisationValue(CyclicLangParser.InitialisationValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newListedArrayValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNewListedArrayValue(CyclicLangParser.NewListedArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newListedArrayValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNewListedArrayValue(CyclicLangParser.NewListedArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterParenValue(CyclicLangParser.ParenValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitParenValue(CyclicLangParser.ParenValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArrayValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayValue(CyclicLangParser.NewArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArrayValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayValue(CyclicLangParser.NewArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inlineAssignment}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterInlineAssignment(CyclicLangParser.InlineAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inlineAssignment}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitInlineAssignment(CyclicLangParser.InlineAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instanceCheckValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterInstanceCheckValue(CyclicLangParser.InstanceCheckValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instanceCheckValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitInstanceCheckValue(CyclicLangParser.InstanceCheckValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterClassValue(CyclicLangParser.ClassValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitClassValue(CyclicLangParser.ClassValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterStrLit(CyclicLangParser.StrLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitStrLit(CyclicLangParser.StrLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterVarValue(CyclicLangParser.VarValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitVarValue(CyclicLangParser.VarValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryOpValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOpValue(CyclicLangParser.BinaryOpValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryOpValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOpValue(CyclicLangParser.BinaryOpValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBoolLit(CyclicLangParser.BoolLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBoolLit(CyclicLangParser.BoolLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterDecLit(CyclicLangParser.DecLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitDecLit(CyclicLangParser.DecLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIntLit(CyclicLangParser.IntLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLit}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIntLit(CyclicLangParser.IntLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFunctionValue(CyclicLangParser.FunctionValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFunctionValue(CyclicLangParser.FunctionValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code switchValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterSwitchValue(CyclicLangParser.SwitchValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code switchValue}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitSwitchValue(CyclicLangParser.SwitchValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inlineDecleration}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterInlineDecleration(CyclicLangParser.InlineDeclerationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inlineDecleration}
	 * labeled alternative in {@link CyclicLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitInlineDecleration(CyclicLangParser.InlineDeclerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#initialisation}.
	 * @param ctx the parse tree
	 */
	void enterInitialisation(CyclicLangParser.InitialisationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#initialisation}.
	 * @param ctx the parse tree
	 */
	void exitInitialisation(CyclicLangParser.InitialisationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#cast}.
	 * @param ctx the parse tree
	 */
	void enterCast(CyclicLangParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#cast}.
	 * @param ctx the parse tree
	 */
	void exitCast(CyclicLangParser.CastContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#varAssignment}.
	 * @param ctx the parse tree
	 */
	void enterVarAssignment(CyclicLangParser.VarAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#varAssignment}.
	 * @param ctx the parse tree
	 */
	void exitVarAssignment(CyclicLangParser.VarAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(CyclicLangParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(CyclicLangParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#newArray}.
	 * @param ctx the parse tree
	 */
	void enterNewArray(CyclicLangParser.NewArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#newArray}.
	 * @param ctx the parse tree
	 */
	void exitNewArray(CyclicLangParser.NewArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#newListedArray}.
	 * @param ctx the parse tree
	 */
	void enterNewListedArray(CyclicLangParser.NewListedArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#newListedArray}.
	 * @param ctx the parse tree
	 */
	void exitNewListedArray(CyclicLangParser.NewListedArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(CyclicLangParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(CyclicLangParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(CyclicLangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(CyclicLangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(CyclicLangParser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(CyclicLangParser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(CyclicLangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(CyclicLangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(CyclicLangParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(CyclicLangParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(CyclicLangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(CyclicLangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(CyclicLangParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(CyclicLangParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#doWhile}.
	 * @param ctx the parse tree
	 */
	void enterDoWhile(CyclicLangParser.DoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#doWhile}.
	 * @param ctx the parse tree
	 */
	void exitDoWhile(CyclicLangParser.DoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(CyclicLangParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(CyclicLangParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void enterCaseClause(CyclicLangParser.CaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void exitCaseClause(CyclicLangParser.CaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void enterDefaultClause(CyclicLangParser.DefaultClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void exitDefaultClause(CyclicLangParser.DefaultClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void enterYieldStatement(CyclicLangParser.YieldStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void exitYieldStatement(CyclicLangParser.YieldStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#binaryop}.
	 * @param ctx the parse tree
	 */
	void enterBinaryop(CyclicLangParser.BinaryopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#binaryop}.
	 * @param ctx the parse tree
	 */
	void exitBinaryop(CyclicLangParser.BinaryopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#unaryop}.
	 * @param ctx the parse tree
	 */
	void enterUnaryop(CyclicLangParser.UnaryopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#unaryop}.
	 * @param ctx the parse tree
	 */
	void exitUnaryop(CyclicLangParser.UnaryopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CyclicLangParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(CyclicLangParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CyclicLangParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(CyclicLangParser.ModifierContext ctx);
}