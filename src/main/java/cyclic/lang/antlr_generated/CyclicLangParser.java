package cyclic.lang.antlr_generated;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CyclicLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROTECTED=1, PRIVATE=2, PUBLIC=3, SYNCHRONISED=4, ABSTRACT=5, NATIVE=6, 
		STATIC=7, FINAL=8, STRICTFP=9, VOLATILE=10, INSTANCEOF=11, RETURN=12, 
		ASSERT=13, NEW=14, THROW=15, CLASS=16, INTERFACE=17, ENUM=18, RECORD=19, 
		SINGLE=20, ANNOTATION=21, IMPORT=22, PACKAGE=23, EXTENDS=24, IMPLEMENTS=25, 
		THIS=26, SUPER=27, IN=28, OUT=29, SEALED=30, PERMITS=31, NONSEALED=32, 
		DEFAULT=33, SWITCH=34, WHILE=35, YIELD=36, CASE=37, ELSE=38, FOR=39, DO=40, 
		IF=41, DECLIT=42, INTLIT=43, STRLIT=44, BOOLLIT=45, NULL=46, BITAND=47, 
		BITOR=48, AND=49, OR=50, UP=51, STAR=52, SLASH=53, PLUS=54, MINUS=55, 
		PERCENT=56, AT=57, LSHIFT=58, RSHIFT=59, ULSHIFT=60, URSHIFT=61, EQUAL=62, 
		INEQUAL=63, GREATEREQ=64, LESSEREQ=65, GREATER=66, LESSER=67, ASSIGN=68, 
		PASS=69, LBRACE=70, RBRACE=71, LPAREN=72, RPAREN=73, LSQUAR=74, RSQUAR=75, 
		COLON=76, SEMICOLON=77, QUOTE=78, DOT=79, COMMA=80, EXCLAMATION=81, QUESTION=82, 
		ELIPSES=83, DASHARROW=84, EQARROW=85, BOOL=86, BYTE=87, SHORT=88, INT=89, 
		LONG=90, FLOAT=91, DOUBLE=92, VOID=93, VAR=94, VAL=95, TRUE=96, FALSE=97, 
		ID=98, DIGIT=99, NONDIGIT=100, SING_COMMENT=101, WS=102, UNMATCHED=103;
	public static final int
		RULE_file = 0, RULE_packageDecl = 1, RULE_imports = 2, RULE_importDecl = 3, 
		RULE_classDecl = 4, RULE_objectExtends = 5, RULE_objectImplements = 6, 
		RULE_objectPermits = 7, RULE_genericTypeDefs = 8, RULE_genericTypeDef = 9, 
		RULE_objectType = 10, RULE_recordComponents = 11, RULE_member = 12, RULE_constructor = 13, 
		RULE_init = 14, RULE_function = 15, RULE_functionBlock = 16, RULE_functionArrow = 17, 
		RULE_varDecl = 18, RULE_parameter = 19, RULE_parameters = 20, RULE_block = 21, 
		RULE_statement = 22, RULE_annotation = 23, RULE_annotationArg = 24, RULE_type = 25, 
		RULE_genericTypeUses = 26, RULE_genericTypeUse = 27, RULE_rawType = 28, 
		RULE_primitiveType = 29, RULE_inferType = 30, RULE_modifiers = 31, RULE_value = 32, 
		RULE_initialisation = 33, RULE_cast = 34, RULE_varAssignment = 35, RULE_call = 36, 
		RULE_ctorCall = 37, RULE_newArray = 38, RULE_newListedArray = 39, RULE_arguments = 40, 
		RULE_returnStatement = 41, RULE_assertStatement = 42, RULE_throwStatement = 43, 
		RULE_ifStatement = 44, RULE_elseStatement = 45, RULE_whileStatement = 46, 
		RULE_forStatement = 47, RULE_foreachStatement = 48, RULE_doWhile = 49, 
		RULE_switchStatement = 50, RULE_caseClause = 51, RULE_defaultClause = 52, 
		RULE_yieldStatement = 53, RULE_binaryop = 54, RULE_unaryop = 55, RULE_id = 56, 
		RULE_idPart = 57, RULE_modifier = 58;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "packageDecl", "imports", "importDecl", "classDecl", "objectExtends", 
			"objectImplements", "objectPermits", "genericTypeDefs", "genericTypeDef", 
			"objectType", "recordComponents", "member", "constructor", "init", "function", 
			"functionBlock", "functionArrow", "varDecl", "parameter", "parameters", 
			"block", "statement", "annotation", "annotationArg", "type", "genericTypeUses", 
			"genericTypeUse", "rawType", "primitiveType", "inferType", "modifiers", 
			"value", "initialisation", "cast", "varAssignment", "call", "ctorCall", 
			"newArray", "newListedArray", "arguments", "returnStatement", "assertStatement", 
			"throwStatement", "ifStatement", "elseStatement", "whileStatement", "forStatement", 
			"foreachStatement", "doWhile", "switchStatement", "caseClause", "defaultClause", 
			"yieldStatement", "binaryop", "unaryop", "id", "idPart", "modifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'protected'", "'private'", "'public'", "'synchronised'", "'abstract'", 
			"'native'", "'static'", "'final'", "'strictfp'", "'volatile'", "'instanceof'", 
			"'return'", "'assert'", "'new'", "'throw'", "'class'", "'interface'", 
			"'enum'", "'record'", "'single'", "'annotation'", "'import'", "'package'", 
			"'extends'", "'implements'", "'this'", "'super'", "'in'", "'out'", "'sealed'", 
			"'permits'", "'non-sealed'", "'default'", "'switch'", "'while'", "'yield'", 
			"'case'", "'else'", "'for'", "'do'", "'if'", null, null, null, null, 
			"'null'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'*'", "'/'", "'+'", "'-'", 
			"'%'", "'@'", "'<<'", "'>>'", "'<<<'", "'>>>'", "'=='", "'!='", "'>='", 
			"'<='", "'>'", "'<'", "'='", "'|>'", "'{'", "'}'", "'('", "')'", "'['", 
			"']'", "':'", "';'", "'\"'", "'.'", "','", "'!'", "'?'", "'...'", "'->'", 
			"'=>'", "'boolean'", "'byte'", "'short'", "'int'", "'long'", "'float'", 
			"'double'", "'void'", "'var'", "'val'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROTECTED", "PRIVATE", "PUBLIC", "SYNCHRONISED", "ABSTRACT", "NATIVE", 
			"STATIC", "FINAL", "STRICTFP", "VOLATILE", "INSTANCEOF", "RETURN", "ASSERT", 
			"NEW", "THROW", "CLASS", "INTERFACE", "ENUM", "RECORD", "SINGLE", "ANNOTATION", 
			"IMPORT", "PACKAGE", "EXTENDS", "IMPLEMENTS", "THIS", "SUPER", "IN", 
			"OUT", "SEALED", "PERMITS", "NONSEALED", "DEFAULT", "SWITCH", "WHILE", 
			"YIELD", "CASE", "ELSE", "FOR", "DO", "IF", "DECLIT", "INTLIT", "STRLIT", 
			"BOOLLIT", "NULL", "BITAND", "BITOR", "AND", "OR", "UP", "STAR", "SLASH", 
			"PLUS", "MINUS", "PERCENT", "AT", "LSHIFT", "RSHIFT", "ULSHIFT", "URSHIFT", 
			"EQUAL", "INEQUAL", "GREATEREQ", "LESSEREQ", "GREATER", "LESSER", "ASSIGN", 
			"PASS", "LBRACE", "RBRACE", "LPAREN", "RPAREN", "LSQUAR", "RSQUAR", "COLON", 
			"SEMICOLON", "QUOTE", "DOT", "COMMA", "EXCLAMATION", "QUESTION", "ELIPSES", 
			"DASHARROW", "EQARROW", "BOOL", "BYTE", "SHORT", "INT", "LONG", "FLOAT", 
			"DOUBLE", "VOID", "VAR", "VAL", "TRUE", "FALSE", "ID", "DIGIT", "NONDIGIT", 
			"SING_COMMENT", "WS", "UNMATCHED"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CyclicLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CyclicLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CyclicLangParser.EOF, 0); }
		public PackageDeclContext packageDecl() {
			return getRuleContext(PackageDeclContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(118);
				packageDecl();
				}
			}

			setState(121);
			imports();
			setState(122);
			classDecl();
			setState(123);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageDeclContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(CyclicLangParser.PACKAGE, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public PackageDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitPackageDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageDeclContext packageDecl() throws RecognitionException {
		PackageDeclContext _localctx = new PackageDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(PACKAGE);
			setState(126);
			id();
			setState(127);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportsContext extends ParserRuleContext {
		public List<ImportDeclContext> importDecl() {
			return getRuleContexts(ImportDeclContext.class);
		}
		public ImportDeclContext importDecl(int i) {
			return getRuleContext(ImportDeclContext.class,i);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_imports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(129);
				importDecl();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(CyclicLangParser.IMPORT, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public TerminalNode STATIC() { return getToken(CyclicLangParser.STATIC, 0); }
		public TerminalNode DOT() { return getToken(CyclicLangParser.DOT, 0); }
		public TerminalNode STAR() { return getToken(CyclicLangParser.STAR, 0); }
		public ImportDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitImportDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclContext importDecl() throws RecognitionException {
		ImportDeclContext _localctx = new ImportDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(IMPORT);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(136);
				match(STATIC);
				}
			}

			setState(139);
			id();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(140);
				match(DOT);
				setState(141);
				match(STAR);
				}
			}

			setState(144);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public ObjectTypeContext objectType() {
			return getRuleContext(ObjectTypeContext.class,0);
		}
		public IdPartContext idPart() {
			return getRuleContext(IdPartContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(CyclicLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CyclicLangParser.RBRACE, 0); }
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public GenericTypeDefsContext genericTypeDefs() {
			return getRuleContext(GenericTypeDefsContext.class,0);
		}
		public RecordComponentsContext recordComponents() {
			return getRuleContext(RecordComponentsContext.class,0);
		}
		public ObjectExtendsContext objectExtends() {
			return getRuleContext(ObjectExtendsContext.class,0);
		}
		public ObjectImplementsContext objectImplements() {
			return getRuleContext(ObjectImplementsContext.class,0);
		}
		public ObjectPermitsContext objectPermits() {
			return getRuleContext(ObjectPermitsContext.class,0);
		}
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(146);
					annotation();
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(152);
			modifiers();
			setState(153);
			objectType();
			setState(154);
			idPart();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESSER) {
				{
				setState(155);
				genericTypeDefs();
				}
			}

			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(158);
				recordComponents();
				}
			}

			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(161);
				objectExtends();
				}
			}

			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(164);
				objectImplements();
				}
			}

			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERMITS) {
				{
				setState(167);
				objectPermits();
				}
			}

			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(170);
				match(LBRACE);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << CLASS) | (1L << INTERFACE) | (1L << ENUM) | (1L << RECORD) | (1L << SINGLE) | (1L << ANNOTATION) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << AT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (LESSER - 67)) | (1L << (LBRACE - 67)) | (1L << (SEMICOLON - 67)) | (1L << (BOOL - 67)) | (1L << (BYTE - 67)) | (1L << (SHORT - 67)) | (1L << (INT - 67)) | (1L << (LONG - 67)) | (1L << (FLOAT - 67)) | (1L << (DOUBLE - 67)) | (1L << (VOID - 67)) | (1L << (VAR - 67)) | (1L << (VAL - 67)) | (1L << (ID - 67)))) != 0)) {
					{
					{
					setState(171);
					member();
					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(177);
				match(RBRACE);
				}
				break;
			case SEMICOLON:
				{
				setState(178);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectExtendsContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(CyclicLangParser.EXTENDS, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CyclicLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CyclicLangParser.COMMA, i);
		}
		public ObjectExtendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectExtends; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitObjectExtends(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectExtendsContext objectExtends() throws RecognitionException {
		ObjectExtendsContext _localctx = new ObjectExtendsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_objectExtends);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(EXTENDS);
			setState(182);
			type(0);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(183);
				match(COMMA);
				setState(184);
				type(0);
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectImplementsContext extends ParserRuleContext {
		public TerminalNode IMPLEMENTS() { return getToken(CyclicLangParser.IMPLEMENTS, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CyclicLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CyclicLangParser.COMMA, i);
		}
		public ObjectImplementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectImplements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitObjectImplements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectImplementsContext objectImplements() throws RecognitionException {
		ObjectImplementsContext _localctx = new ObjectImplementsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_objectImplements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(IMPLEMENTS);
			setState(191);
			type(0);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(192);
				match(COMMA);
				setState(193);
				type(0);
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectPermitsContext extends ParserRuleContext {
		public TerminalNode PERMITS() { return getToken(CyclicLangParser.PERMITS, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CyclicLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CyclicLangParser.COMMA, i);
		}
		public ObjectPermitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectPermits; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitObjectPermits(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectPermitsContext objectPermits() throws RecognitionException {
		ObjectPermitsContext _localctx = new ObjectPermitsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_objectPermits);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(PERMITS);
			setState(200);
			type(0);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(201);
				match(COMMA);
				setState(202);
				type(0);
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericTypeDefsContext extends ParserRuleContext {
		public TerminalNode LESSER() { return getToken(CyclicLangParser.LESSER, 0); }
		public List<GenericTypeDefContext> genericTypeDef() {
			return getRuleContexts(GenericTypeDefContext.class);
		}
		public GenericTypeDefContext genericTypeDef(int i) {
			return getRuleContext(GenericTypeDefContext.class,i);
		}
		public TerminalNode GREATER() { return getToken(CyclicLangParser.GREATER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CyclicLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CyclicLangParser.COMMA, i);
		}
		public GenericTypeDefsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericTypeDefs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitGenericTypeDefs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericTypeDefsContext genericTypeDefs() throws RecognitionException {
		GenericTypeDefsContext _localctx = new GenericTypeDefsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_genericTypeDefs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(LESSER);
			setState(209);
			genericTypeDef();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(210);
				match(COMMA);
				setState(211);
				genericTypeDef();
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(217);
			match(GREATER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericTypeDefContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode CLASS() { return getToken(CyclicLangParser.CLASS, 0); }
		public TerminalNode EXTENDS() { return getToken(CyclicLangParser.EXTENDS, 0); }
		public TerminalNode IN() { return getToken(CyclicLangParser.IN, 0); }
		public TerminalNode OUT() { return getToken(CyclicLangParser.OUT, 0); }
		public GenericTypeDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericTypeDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitGenericTypeDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericTypeDefContext genericTypeDef() throws RecognitionException {
		GenericTypeDefContext _localctx = new GenericTypeDefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_genericTypeDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(219);
				_la = _input.LA(1);
				if ( !(_la==IN || _la==OUT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLASS) {
				{
				setState(222);
				match(CLASS);
				}
			}

			setState(225);
			type(0);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(226);
				match(EXTENDS);
				setState(227);
				type(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectTypeContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(CyclicLangParser.CLASS, 0); }
		public TerminalNode INTERFACE() { return getToken(CyclicLangParser.INTERFACE, 0); }
		public TerminalNode ENUM() { return getToken(CyclicLangParser.ENUM, 0); }
		public TerminalNode AT() { return getToken(CyclicLangParser.AT, 0); }
		public TerminalNode ANNOTATION() { return getToken(CyclicLangParser.ANNOTATION, 0); }
		public TerminalNode RECORD() { return getToken(CyclicLangParser.RECORD, 0); }
		public TerminalNode SINGLE() { return getToken(CyclicLangParser.SINGLE, 0); }
		public ObjectTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitObjectType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectTypeContext objectType() throws RecognitionException {
		ObjectTypeContext _localctx = new ObjectTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_objectType);
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(CLASS);
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				match(INTERFACE);
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				match(ENUM);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				match(AT);
				setState(234);
				match(INTERFACE);
				}
				break;
			case ANNOTATION:
				enterOuterAlt(_localctx, 5);
				{
				setState(235);
				match(ANNOTATION);
				}
				break;
			case RECORD:
				enterOuterAlt(_localctx, 6);
				{
				setState(236);
				match(RECORD);
				}
				break;
			case SINGLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(237);
				match(SINGLE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordComponentsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CyclicLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CyclicLangParser.COMMA, i);
		}
		public RecordComponentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordComponents; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitRecordComponents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordComponentsContext recordComponents() throws RecognitionException {
		RecordComponentsContext _localctx = new RecordComponentsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_recordComponents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(LPAREN);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << ANNOTATION) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << AT))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (BOOL - 86)) | (1L << (BYTE - 86)) | (1L << (SHORT - 86)) | (1L << (INT - 86)) | (1L << (LONG - 86)) | (1L << (FLOAT - 86)) | (1L << (DOUBLE - 86)) | (1L << (VOID - 86)) | (1L << (VAR - 86)) | (1L << (VAL - 86)) | (1L << (ID - 86)))) != 0)) {
				{
				setState(241);
				parameter();
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(242);
					match(COMMA);
					setState(243);
					parameter();
					}
					}
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(251);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public MemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_member);
		try {
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				function();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				constructor();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				varDecl();
				setState(256);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(258);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(259);
				init();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(260);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorContext extends ParserRuleContext {
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public TerminalNode DASHARROW() { return getToken(CyclicLangParser.DASHARROW, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constructor);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(263);
					annotation();
					}
					} 
				}
				setState(268);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(269);
			modifiers();
			setState(270);
			type(0);
			setState(271);
			match(LPAREN);
			setState(272);
			parameters();
			setState(273);
			match(RPAREN);
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(274);
				block();
				}
				break;
			case SEMICOLON:
				{
				setState(275);
				match(SEMICOLON);
				}
				break;
			case DASHARROW:
				{
				setState(276);
				match(DASHARROW);
				setState(277);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(CyclicLangParser.STATIC, 0); }
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(280);
				match(STATIC);
				}
			}

			setState(283);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdPartContext idPart() {
			return getRuleContext(IdPartContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public FunctionBlockContext functionBlock() {
			return getRuleContext(FunctionBlockContext.class,0);
		}
		public FunctionArrowContext functionArrow() {
			return getRuleContext(FunctionArrowContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public GenericTypeDefsContext genericTypeDefs() {
			return getRuleContext(GenericTypeDefsContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_function);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(285);
					annotation();
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(291);
			modifiers();
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESSER) {
				{
				setState(292);
				genericTypeDefs();
				}
			}

			setState(295);
			type(0);
			setState(296);
			idPart();
			setState(297);
			match(LPAREN);
			setState(298);
			parameters();
			setState(299);
			match(RPAREN);
			setState(302);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
			case SEMICOLON:
				{
				setState(300);
				functionBlock();
				}
				break;
			case DASHARROW:
				{
				setState(301);
				functionArrow();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionBlockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public FunctionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitFunctionBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBlockContext functionBlock() throws RecognitionException {
		FunctionBlockContext _localctx = new FunctionBlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(304);
				block();
				}
				break;
			case SEMICOLON:
				{
				setState(305);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArrowContext extends ParserRuleContext {
		public TerminalNode DASHARROW() { return getToken(CyclicLangParser.DASHARROW, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public FunctionArrowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArrow; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitFunctionArrow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArrowContext functionArrow() throws RecognitionException {
		FunctionArrowContext _localctx = new FunctionArrowContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionArrow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(DASHARROW);
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(309);
				value(0);
				setState(310);
				match(SEMICOLON);
				}
				break;
			case 2:
				{
				setState(312);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdPartContext idPart() {
			return getRuleContext(IdPartContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(CyclicLangParser.ASSIGN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varDecl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(315);
					annotation();
					}
					} 
				}
				setState(320);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(321);
			modifiers();
			setState(322);
			type(0);
			setState(323);
			idPart();
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(324);
				match(ASSIGN);
				setState(325);
				value(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdPartContext idPart() {
			return getRuleContext(IdPartContext.class,0);
		}
		public TerminalNode FINAL() { return getToken(CyclicLangParser.FINAL, 0); }
		public TerminalNode ELIPSES() { return getToken(CyclicLangParser.ELIPSES, 0); }
		public TerminalNode ASSIGN() { return getToken(CyclicLangParser.ASSIGN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINAL) {
				{
				setState(328);
				match(FINAL);
				}
			}

			setState(331);
			type(0);
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELIPSES) {
				{
				setState(332);
				match(ELIPSES);
				}
			}

			setState(335);
			idPart();
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(336);
				match(ASSIGN);
				setState(337);
				value(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CyclicLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CyclicLangParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << ANNOTATION) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << AT))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (BOOL - 86)) | (1L << (BYTE - 86)) | (1L << (SHORT - 86)) | (1L << (INT - 86)) | (1L << (LONG - 86)) | (1L << (FLOAT - 86)) | (1L << (DOUBLE - 86)) | (1L << (VOID - 86)) | (1L << (VAR - 86)) | (1L << (VAL - 86)) | (1L << (ID - 86)))) != 0)) {
				{
				setState(340);
				parameter();
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(341);
					match(COMMA);
					setState(342);
					parameter();
					}
					}
					setState(347);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(CyclicLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CyclicLangParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(LBRACE);
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << RETURN) | (1L << ASSERT) | (1L << NEW) | (1L << THROW) | (1L << ANNOTATION) | (1L << THIS) | (1L << SUPER) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << WHILE) | (1L << YIELD) | (1L << FOR) | (1L << DO) | (1L << IF) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LBRACE - 70)) | (1L << (LPAREN - 70)) | (1L << (SEMICOLON - 70)) | (1L << (EXCLAMATION - 70)) | (1L << (BOOL - 70)) | (1L << (BYTE - 70)) | (1L << (SHORT - 70)) | (1L << (INT - 70)) | (1L << (LONG - 70)) | (1L << (FLOAT - 70)) | (1L << (DOUBLE - 70)) | (1L << (VOID - 70)) | (1L << (VAR - 70)) | (1L << (VAL - 70)) | (1L << (ID - 70)))) != 0)) {
				{
				{
				setState(351);
				statement();
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(357);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public AssertStatementContext assertStatement() {
			return getRuleContext(AssertStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public VarAssignmentContext varAssignment() {
			return getRuleContext(VarAssignmentContext.class,0);
		}
		public InitialisationContext initialisation() {
			return getRuleContext(InitialisationContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ForeachStatementContext foreachStatement() {
			return getRuleContext(ForeachStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public DoWhileContext doWhile() {
			return getRuleContext(DoWhileContext.class,0);
		}
		public YieldStatementContext yieldStatement() {
			return getRuleContext(YieldStatementContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode DOT() { return getToken(CyclicLangParser.DOT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(CyclicLangParser.SUPER, 0); }
		public CtorCallContext ctorCall() {
			return getRuleContext(CtorCallContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_statement);
		try {
			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(360);
				returnStatement();
				setState(361);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(363);
				assertStatement();
				setState(364);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(366);
				throwStatement();
				setState(367);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(369);
				varDecl();
				setState(370);
				match(SEMICOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(372);
				varAssignment();
				setState(373);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(375);
				initialisation();
				setState(376);
				match(SEMICOLON);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(378);
				ifStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(379);
				whileStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(380);
				forStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(381);
				foreachStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(382);
				switchStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(383);
				doWhile();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(384);
				yieldStatement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(390);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(387);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						setState(385);
						value(0);
						}
						break;
					case 2:
						{
						setState(386);
						match(SUPER);
						}
						break;
					}
					setState(389);
					match(DOT);
					}
					break;
				}
				setState(392);
				call();
				setState(393);
				match(SEMICOLON);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(395);
				ctorCall();
				setState(396);
				match(SEMICOLON);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(398);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(CyclicLangParser.AT, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public List<AnnotationArgContext> annotationArg() {
			return getRuleContexts(AnnotationArgContext.class);
		}
		public AnnotationArgContext annotationArg(int i) {
			return getRuleContext(AnnotationArgContext.class,i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CyclicLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CyclicLangParser.COMMA, i);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(AT);
			setState(402);
			id();
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(403);
				match(LPAREN);
				setState(413);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(404);
					annotationArg();
					setState(409);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(405);
						match(COMMA);
						setState(406);
						annotationArg();
						}
						}
						setState(411);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(412);
					value(0);
					}
					break;
				}
				setState(415);
				match(RPAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationArgContext extends ParserRuleContext {
		public IdPartContext idPart() {
			return getRuleContext(IdPartContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CyclicLangParser.ASSIGN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AnnotationArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationArg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitAnnotationArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationArgContext annotationArg() throws RecognitionException {
		AnnotationArgContext _localctx = new AnnotationArgContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_annotationArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			idPart();
			setState(419);
			match(ASSIGN);
			setState(420);
			value(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public RawTypeContext rawType() {
			return getRuleContext(RawTypeContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public GenericTypeUsesContext genericTypeUses() {
			return getRuleContext(GenericTypeUsesContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LSQUAR() { return getToken(CyclicLangParser.LSQUAR, 0); }
		public TerminalNode RSQUAR() { return getToken(CyclicLangParser.RSQUAR, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(423);
				annotation();
				}
				}
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(429);
			rawType();
			setState(431);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(430);
				genericTypeUses();
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(444);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(433);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(437);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AT) {
						{
						{
						setState(434);
						annotation();
						}
						}
						setState(439);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(440);
					match(LSQUAR);
					setState(441);
					match(RSQUAR);
					}
					} 
				}
				setState(446);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GenericTypeUsesContext extends ParserRuleContext {
		public TerminalNode LESSER() { return getToken(CyclicLangParser.LESSER, 0); }
		public List<GenericTypeUseContext> genericTypeUse() {
			return getRuleContexts(GenericTypeUseContext.class);
		}
		public GenericTypeUseContext genericTypeUse(int i) {
			return getRuleContext(GenericTypeUseContext.class,i);
		}
		public TerminalNode GREATER() { return getToken(CyclicLangParser.GREATER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CyclicLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CyclicLangParser.COMMA, i);
		}
		public GenericTypeUsesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericTypeUses; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitGenericTypeUses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericTypeUsesContext genericTypeUses() throws RecognitionException {
		GenericTypeUsesContext _localctx = new GenericTypeUsesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_genericTypeUses);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			match(LESSER);
			setState(448);
			genericTypeUse();
			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(449);
				match(COMMA);
				setState(450);
				genericTypeUse();
				}
				}
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(456);
			match(GREATER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericTypeUseContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(CyclicLangParser.QUESTION, 0); }
		public TerminalNode EXTENDS() { return getToken(CyclicLangParser.EXTENDS, 0); }
		public TerminalNode SUPER() { return getToken(CyclicLangParser.SUPER, 0); }
		public GenericTypeUseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericTypeUse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitGenericTypeUse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericTypeUseContext genericTypeUse() throws RecognitionException {
		GenericTypeUseContext _localctx = new GenericTypeUseContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_genericTypeUse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(458);
				match(QUESTION);
				setState(459);
				_la = _input.LA(1);
				if ( !(_la==EXTENDS || _la==SUPER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(462);
			type(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RawTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public InferTypeContext inferType() {
			return getRuleContext(InferTypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public RawTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rawType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitRawType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RawTypeContext rawType() throws RecognitionException {
		RawTypeContext _localctx = new RawTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_rawType);
		try {
			setState(467);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case BYTE:
			case SHORT:
			case INT:
			case LONG:
			case FLOAT:
			case DOUBLE:
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(464);
				primitiveType();
				}
				break;
			case VAR:
			case VAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(465);
				inferType();
				}
				break;
			case ANNOTATION:
			case IN:
			case OUT:
			case SEALED:
			case PERMITS:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(466);
				id();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(CyclicLangParser.BOOL, 0); }
		public TerminalNode BYTE() { return getToken(CyclicLangParser.BYTE, 0); }
		public TerminalNode SHORT() { return getToken(CyclicLangParser.SHORT, 0); }
		public TerminalNode INT() { return getToken(CyclicLangParser.INT, 0); }
		public TerminalNode LONG() { return getToken(CyclicLangParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(CyclicLangParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(CyclicLangParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(CyclicLangParser.VOID, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			_la = _input.LA(1);
			if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (BOOL - 86)) | (1L << (BYTE - 86)) | (1L << (SHORT - 86)) | (1L << (INT - 86)) | (1L << (LONG - 86)) | (1L << (FLOAT - 86)) | (1L << (DOUBLE - 86)) | (1L << (VOID - 86)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InferTypeContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(CyclicLangParser.VAR, 0); }
		public TerminalNode VAL() { return getToken(CyclicLangParser.VAL, 0); }
		public InferTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inferType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInferType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InferTypeContext inferType() throws RecognitionException {
		InferTypeContext _localctx = new InferTypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_inferType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			_la = _input.LA(1);
			if ( !(_la==VAR || _la==VAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifiersContext extends ParserRuleContext {
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifiers; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_modifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(473);
					modifier();
					}
					} 
				}
				setState(478);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ThisValueContext extends ValueContext {
		public TerminalNode THIS() { return getToken(CyclicLangParser.THIS, 0); }
		public ThisValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitThisValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastValueContext extends ValueContext {
		public CastContext cast() {
			return getRuleContext(CastContext.class,0);
		}
		public CastValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitCastValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayIndexValueContext extends ValueContext {
		public ValueContext array;
		public ValueContext index;
		public TerminalNode LSQUAR() { return getToken(CyclicLangParser.LSQUAR, 0); }
		public TerminalNode RSQUAR() { return getToken(CyclicLangParser.RSQUAR, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ArrayIndexValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitArrayIndexValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoValueContext extends ValueContext {
		public TerminalNode DO() { return getToken(CyclicLangParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DoValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitDoValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryOpValueContext extends ValueContext {
		public UnaryopContext unaryop() {
			return getRuleContext(UnaryopContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public UnaryOpValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitUnaryOpValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLitContext extends ValueContext {
		public TerminalNode NULL() { return getToken(CyclicLangParser.NULL, 0); }
		public NullLitContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitNullLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InitialisationValueContext extends ValueContext {
		public InitialisationContext initialisation() {
			return getRuleContext(InitialisationContext.class,0);
		}
		public InitialisationValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInitialisationValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewListedArrayValueContext extends ValueContext {
		public NewListedArrayContext newListedArray() {
			return getRuleContext(NewListedArrayContext.class,0);
		}
		public NewListedArrayValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitNewListedArrayValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenValueContext extends ValueContext {
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public ParenValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitParenValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewArrayValueContext extends ValueContext {
		public NewArrayContext newArray() {
			return getRuleContext(NewArrayContext.class,0);
		}
		public NewArrayValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitNewArrayValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstanceCheckValueContext extends ValueContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode INSTANCEOF() { return getToken(CyclicLangParser.INSTANCEOF, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EXCLAMATION() { return getToken(CyclicLangParser.EXCLAMATION, 0); }
		public InstanceCheckValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInstanceCheckValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassValueContext extends ValueContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode DOT() { return getToken(CyclicLangParser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(CyclicLangParser.CLASS, 0); }
		public ClassValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitClassValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrLitContext extends ValueContext {
		public TerminalNode STRLIT() { return getToken(CyclicLangParser.STRLIT, 0); }
		public StrLitContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitStrLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarValueContext extends ValueContext {
		public IdPartContext idPart() {
			return getRuleContext(IdPartContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode DOT() { return getToken(CyclicLangParser.DOT, 0); }
		public VarValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitVarValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryOpValueContext extends ValueContext {
		public ValueContext left;
		public ValueContext right;
		public BinaryopContext binaryop() {
			return getRuleContext(BinaryopContext.class,0);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public BinaryOpValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitBinaryOpValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLitContext extends ValueContext {
		public TerminalNode BOOLLIT() { return getToken(CyclicLangParser.BOOLLIT, 0); }
		public BoolLitContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitBoolLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecLitContext extends ValueContext {
		public TerminalNode DECLIT() { return getToken(CyclicLangParser.DECLIT, 0); }
		public DecLitContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitDecLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLitContext extends ValueContext {
		public TerminalNode INTLIT() { return getToken(CyclicLangParser.INTLIT, 0); }
		public IntLitContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitIntLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionValueContext extends ValueContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(CyclicLangParser.SUPER, 0); }
		public TerminalNode DOT() { return getToken(CyclicLangParser.DOT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FunctionValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitFunctionValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SwitchValueContext extends ValueContext {
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public SwitchValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitSwitchValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InlineDeclerationContext extends ValueContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public InlineDeclerationContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInlineDecleration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimitiveClassValueContext extends ValueContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(CyclicLangParser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(CyclicLangParser.CLASS, 0); }
		public PrimitiveClassValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitPrimitiveClassValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		return value(0);
	}

	private ValueContext value(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueContext _localctx = new ValueContext(_ctx, _parentState);
		ValueContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_value, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				_localctx = new FunctionValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(480);
				call();
				}
				break;
			case 2:
				{
				_localctx = new FunctionValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(481);
				match(SUPER);
				setState(482);
				match(DOT);
				setState(483);
				call();
				}
				break;
			case 3:
				{
				_localctx = new DoValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(484);
				match(DO);
				setState(485);
				statement();
				}
				break;
			case 4:
				{
				_localctx = new InitialisationValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(486);
				initialisation();
				}
				break;
			case 5:
				{
				_localctx = new ParenValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(487);
				match(LPAREN);
				setState(488);
				value(0);
				setState(489);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new InlineDeclerationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(491);
				varDecl();
				}
				break;
			case 7:
				{
				_localctx = new SwitchValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(492);
				switchStatement();
				}
				break;
			case 8:
				{
				_localctx = new ClassValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(493);
				id();
				setState(494);
				match(DOT);
				setState(495);
				match(CLASS);
				}
				break;
			case 9:
				{
				_localctx = new PrimitiveClassValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(497);
				primitiveType();
				setState(498);
				match(DOT);
				setState(499);
				match(CLASS);
				}
				break;
			case 10:
				{
				_localctx = new CastValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(501);
				cast();
				}
				break;
			case 11:
				{
				_localctx = new UnaryOpValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(502);
				unaryop();
				setState(503);
				value(10);
				}
				break;
			case 12:
				{
				_localctx = new NewArrayValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(505);
				newArray();
				}
				break;
			case 13:
				{
				_localctx = new NewListedArrayValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(506);
				newListedArray();
				}
				break;
			case 14:
				{
				_localctx = new ThisValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(507);
				match(THIS);
				}
				break;
			case 15:
				{
				_localctx = new DecLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(508);
				match(DECLIT);
				}
				break;
			case 16:
				{
				_localctx = new IntLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(509);
				match(INTLIT);
				}
				break;
			case 17:
				{
				_localctx = new StrLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(510);
				match(STRLIT);
				}
				break;
			case 18:
				{
				_localctx = new BoolLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(511);
				match(BOOLLIT);
				}
				break;
			case 19:
				{
				_localctx = new NullLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(512);
				match(NULL);
				}
				break;
			case 20:
				{
				_localctx = new VarValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(513);
				idPart();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(539);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(537);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOpValueContext(new ValueContext(_parentctx, _parentState));
						((BinaryOpValueContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(516);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(517);
						binaryop();
						setState(518);
						((BinaryOpValueContext)_localctx).right = value(26);
						}
						break;
					case 2:
						{
						_localctx = new FunctionValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(520);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(521);
						match(DOT);
						setState(522);
						call();
						}
						break;
					case 3:
						{
						_localctx = new InstanceCheckValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(523);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(525);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==EXCLAMATION) {
							{
							setState(524);
							match(EXCLAMATION);
							}
						}

						setState(527);
						match(INSTANCEOF);
						setState(528);
						type(0);
						}
						break;
					case 4:
						{
						_localctx = new ArrayIndexValueContext(new ValueContext(_parentctx, _parentState));
						((ArrayIndexValueContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(529);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(530);
						match(LSQUAR);
						setState(531);
						((ArrayIndexValueContext)_localctx).index = value(0);
						setState(532);
						match(RSQUAR);
						}
						break;
					case 5:
						{
						_localctx = new VarValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(534);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(535);
						match(DOT);
						setState(536);
						idPart();
						}
						break;
					}
					} 
				}
				setState(541);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InitialisationContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(CyclicLangParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public InitialisationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialisation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInitialisation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialisationContext initialisation() throws RecognitionException {
		InitialisationContext _localctx = new InitialisationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_initialisation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			match(NEW);
			setState(543);
			type(0);
			setState(544);
			match(LPAREN);
			setState(545);
			arguments();
			setState(546);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public CastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitCast(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastContext cast() throws RecognitionException {
		CastContext _localctx = new CastContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_cast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			match(LPAREN);
			setState(549);
			type(0);
			setState(550);
			match(RPAREN);
			setState(551);
			value(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarAssignmentContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(CyclicLangParser.ASSIGN, 0); }
		public BinaryopContext binaryop() {
			return getRuleContext(BinaryopContext.class,0);
		}
		public VarAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitVarAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarAssignmentContext varAssignment() throws RecognitionException {
		VarAssignmentContext _localctx = new VarAssignmentContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_varAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			value(0);
			setState(555);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(554);
				binaryop();
				}
				break;
			}
			setState(557);
			match(ASSIGN);
			setState(558);
			value(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public IdPartContext idPart() {
			return getRuleContext(IdPartContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			idPart();
			setState(561);
			match(LPAREN);
			setState(562);
			arguments();
			setState(563);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtorCallContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public TerminalNode THIS() { return getToken(CyclicLangParser.THIS, 0); }
		public TerminalNode SUPER() { return getToken(CyclicLangParser.SUPER, 0); }
		public CtorCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctorCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitCtorCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtorCallContext ctorCall() throws RecognitionException {
		CtorCallContext _localctx = new CtorCallContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_ctorCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			_la = _input.LA(1);
			if ( !(_la==THIS || _la==SUPER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(566);
			match(LPAREN);
			setState(567);
			arguments();
			setState(568);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewArrayContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(CyclicLangParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LSQUAR() { return getToken(CyclicLangParser.LSQUAR, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RSQUAR() { return getToken(CyclicLangParser.RSQUAR, 0); }
		public NewArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newArray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitNewArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewArrayContext newArray() throws RecognitionException {
		NewArrayContext _localctx = new NewArrayContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_newArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(NEW);
			setState(571);
			type(0);
			setState(572);
			match(LSQUAR);
			setState(573);
			value(0);
			setState(574);
			match(RSQUAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewListedArrayContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(CyclicLangParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LSQUAR() { return getToken(CyclicLangParser.LSQUAR, 0); }
		public TerminalNode RSQUAR() { return getToken(CyclicLangParser.RSQUAR, 0); }
		public TerminalNode LBRACE() { return getToken(CyclicLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CyclicLangParser.RBRACE, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CyclicLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CyclicLangParser.COMMA, i);
		}
		public NewListedArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newListedArray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitNewListedArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewListedArrayContext newListedArray() throws RecognitionException {
		NewListedArrayContext _localctx = new NewListedArrayContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_newListedArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			match(NEW);
			setState(577);
			type(0);
			setState(578);
			match(LSQUAR);
			setState(579);
			match(RSQUAR);
			setState(580);
			match(LBRACE);
			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << ANNOTATION) | (1L << THIS) | (1L << SUPER) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (LPAREN - 72)) | (1L << (EXCLAMATION - 72)) | (1L << (BOOL - 72)) | (1L << (BYTE - 72)) | (1L << (SHORT - 72)) | (1L << (INT - 72)) | (1L << (LONG - 72)) | (1L << (FLOAT - 72)) | (1L << (DOUBLE - 72)) | (1L << (VOID - 72)) | (1L << (VAR - 72)) | (1L << (VAL - 72)) | (1L << (ID - 72)))) != 0)) {
				{
				setState(581);
				value(0);
				setState(586);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(582);
					match(COMMA);
					setState(583);
					value(0);
					}
					}
					setState(588);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(591);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CyclicLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CyclicLangParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << ANNOTATION) | (1L << THIS) | (1L << SUPER) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (LPAREN - 72)) | (1L << (EXCLAMATION - 72)) | (1L << (BOOL - 72)) | (1L << (BYTE - 72)) | (1L << (SHORT - 72)) | (1L << (INT - 72)) | (1L << (LONG - 72)) | (1L << (FLOAT - 72)) | (1L << (DOUBLE - 72)) | (1L << (VOID - 72)) | (1L << (VAR - 72)) | (1L << (VAL - 72)) | (1L << (ID - 72)))) != 0)) {
				{
				setState(593);
				value(0);
				setState(598);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(594);
					match(COMMA);
					setState(595);
					value(0);
					}
					}
					setState(600);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(CyclicLangParser.RETURN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(RETURN);
			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << ANNOTATION) | (1L << THIS) | (1L << SUPER) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (LPAREN - 72)) | (1L << (EXCLAMATION - 72)) | (1L << (BOOL - 72)) | (1L << (BYTE - 72)) | (1L << (SHORT - 72)) | (1L << (INT - 72)) | (1L << (LONG - 72)) | (1L << (FLOAT - 72)) | (1L << (DOUBLE - 72)) | (1L << (VOID - 72)) | (1L << (VAR - 72)) | (1L << (VAL - 72)) | (1L << (ID - 72)))) != 0)) {
				{
				setState(604);
				value(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssertStatementContext extends ParserRuleContext {
		public TerminalNode ASSERT() { return getToken(CyclicLangParser.ASSERT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CyclicLangParser.COLON, 0); }
		public TerminalNode STRLIT() { return getToken(CyclicLangParser.STRLIT, 0); }
		public AssertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitAssertStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertStatementContext assertStatement() throws RecognitionException {
		AssertStatementContext _localctx = new AssertStatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_assertStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			match(ASSERT);
			setState(608);
			value(0);
			setState(611);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(609);
				match(COLON);
				setState(610);
				match(STRLIT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThrowStatementContext extends ParserRuleContext {
		public TerminalNode THROW() { return getToken(CyclicLangParser.THROW, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitThrowStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			match(THROW);
			setState(614);
			value(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(CyclicLangParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			match(IF);
			setState(617);
			match(LPAREN);
			setState(618);
			value(0);
			setState(619);
			match(RPAREN);
			setState(620);
			statement();
			setState(622);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(621);
				elseStatement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(CyclicLangParser.ELSE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(ELSE);
			setState(625);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CyclicLangParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			match(WHILE);
			setState(628);
			match(LPAREN);
			setState(629);
			value(0);
			setState(630);
			match(RPAREN);
			setState(631);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public StatementContext start;
		public ValueContext cond;
		public StatementContext end;
		public StatementContext action;
		public TerminalNode FOR() { return getToken(CyclicLangParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			match(FOR);
			setState(634);
			match(LPAREN);
			setState(636);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(635);
				((ForStatementContext)_localctx).start = statement();
				}
				break;
			}
			setState(638);
			((ForStatementContext)_localctx).cond = value(0);
			setState(639);
			match(SEMICOLON);
			setState(641);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << RETURN) | (1L << ASSERT) | (1L << NEW) | (1L << THROW) | (1L << ANNOTATION) | (1L << THIS) | (1L << SUPER) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << WHILE) | (1L << YIELD) | (1L << FOR) | (1L << DO) | (1L << IF) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LBRACE - 70)) | (1L << (LPAREN - 70)) | (1L << (SEMICOLON - 70)) | (1L << (EXCLAMATION - 70)) | (1L << (BOOL - 70)) | (1L << (BYTE - 70)) | (1L << (SHORT - 70)) | (1L << (INT - 70)) | (1L << (LONG - 70)) | (1L << (FLOAT - 70)) | (1L << (DOUBLE - 70)) | (1L << (VOID - 70)) | (1L << (VAR - 70)) | (1L << (VAL - 70)) | (1L << (ID - 70)))) != 0)) {
				{
				setState(640);
				((ForStatementContext)_localctx).end = statement();
				}
			}

			setState(643);
			match(RPAREN);
			setState(644);
			((ForStatementContext)_localctx).action = statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForeachStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(CyclicLangParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdPartContext idPart() {
			return getRuleContext(IdPartContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CyclicLangParser.COLON, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode FINAL() { return getToken(CyclicLangParser.FINAL, 0); }
		public ForeachStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitForeachStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForeachStatementContext foreachStatement() throws RecognitionException {
		ForeachStatementContext _localctx = new ForeachStatementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_foreachStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			match(FOR);
			setState(647);
			match(LPAREN);
			setState(649);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINAL) {
				{
				setState(648);
				match(FINAL);
				}
			}

			setState(651);
			type(0);
			setState(652);
			idPart();
			setState(653);
			match(COLON);
			setState(654);
			value(0);
			setState(655);
			match(RPAREN);
			setState(656);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoWhileContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(CyclicLangParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(CyclicLangParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public DoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileContext doWhile() throws RecognitionException {
		DoWhileContext _localctx = new DoWhileContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_doWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			match(DO);
			setState(659);
			statement();
			setState(660);
			match(WHILE);
			setState(661);
			match(LPAREN);
			setState(662);
			value(0);
			setState(663);
			match(RPAREN);
			setState(664);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(CyclicLangParser.SWITCH, 0); }
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(CyclicLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CyclicLangParser.RBRACE, 0); }
		public List<CaseClauseContext> caseClause() {
			return getRuleContexts(CaseClauseContext.class);
		}
		public CaseClauseContext caseClause(int i) {
			return getRuleContext(CaseClauseContext.class,i);
		}
		public DefaultClauseContext defaultClause() {
			return getRuleContext(DefaultClauseContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			match(SWITCH);
			setState(667);
			match(LPAREN);
			setState(668);
			value(0);
			setState(669);
			match(RPAREN);
			setState(670);
			match(LBRACE);
			setState(674);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(671);
				caseClause();
				}
				}
				setState(676);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(678);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(677);
				defaultClause();
				}
			}

			setState(680);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaseClauseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(CyclicLangParser.CASE, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode DASHARROW() { return getToken(CyclicLangParser.DASHARROW, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public CaseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitCaseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseClauseContext caseClause() throws RecognitionException {
		CaseClauseContext _localctx = new CaseClauseContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_caseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			match(CASE);
			setState(683);
			value(0);
			setState(684);
			match(DASHARROW);
			setState(689);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(685);
				statement();
				}
				break;
			case 2:
				{
				setState(686);
				value(0);
				setState(687);
				match(SEMICOLON);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultClauseContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(CyclicLangParser.DEFAULT, 0); }
		public TerminalNode DASHARROW() { return getToken(CyclicLangParser.DASHARROW, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public DefaultClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitDefaultClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultClauseContext defaultClause() throws RecognitionException {
		DefaultClauseContext _localctx = new DefaultClauseContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_defaultClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(691);
			match(DEFAULT);
			setState(692);
			match(DASHARROW);
			setState(697);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(693);
				statement();
				}
				break;
			case 2:
				{
				setState(694);
				value(0);
				setState(695);
				match(SEMICOLON);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class YieldStatementContext extends ParserRuleContext {
		public TerminalNode YIELD() { return getToken(CyclicLangParser.YIELD, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public YieldStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yieldStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitYieldStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YieldStatementContext yieldStatement() throws RecognitionException {
		YieldStatementContext _localctx = new YieldStatementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_yieldStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			match(YIELD);
			setState(700);
			value(0);
			setState(701);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryopContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(CyclicLangParser.SLASH, 0); }
		public TerminalNode STAR() { return getToken(CyclicLangParser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(CyclicLangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CyclicLangParser.MINUS, 0); }
		public TerminalNode PERCENT() { return getToken(CyclicLangParser.PERCENT, 0); }
		public TerminalNode BITAND() { return getToken(CyclicLangParser.BITAND, 0); }
		public TerminalNode BITOR() { return getToken(CyclicLangParser.BITOR, 0); }
		public TerminalNode AND() { return getToken(CyclicLangParser.AND, 0); }
		public TerminalNode OR() { return getToken(CyclicLangParser.OR, 0); }
		public TerminalNode UP() { return getToken(CyclicLangParser.UP, 0); }
		public TerminalNode EQUAL() { return getToken(CyclicLangParser.EQUAL, 0); }
		public TerminalNode INEQUAL() { return getToken(CyclicLangParser.INEQUAL, 0); }
		public TerminalNode GREATEREQ() { return getToken(CyclicLangParser.GREATEREQ, 0); }
		public TerminalNode LESSEREQ() { return getToken(CyclicLangParser.LESSEREQ, 0); }
		public TerminalNode GREATER() { return getToken(CyclicLangParser.GREATER, 0); }
		public TerminalNode LESSER() { return getToken(CyclicLangParser.LESSER, 0); }
		public TerminalNode LSHIFT() { return getToken(CyclicLangParser.LSHIFT, 0); }
		public TerminalNode RSHIFT() { return getToken(CyclicLangParser.RSHIFT, 0); }
		public TerminalNode ULSHIFT() { return getToken(CyclicLangParser.ULSHIFT, 0); }
		public TerminalNode URSHIFT() { return getToken(CyclicLangParser.URSHIFT, 0); }
		public TerminalNode ASSIGN() { return getToken(CyclicLangParser.ASSIGN, 0); }
		public TerminalNode PASS() { return getToken(CyclicLangParser.PASS, 0); }
		public BinaryopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitBinaryop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryopContext binaryop() throws RecognitionException {
		BinaryopContext _localctx = new BinaryopContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_binaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(703);
			_la = _input.LA(1);
			if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & ((1L << (BITAND - 47)) | (1L << (BITOR - 47)) | (1L << (AND - 47)) | (1L << (OR - 47)) | (1L << (UP - 47)) | (1L << (STAR - 47)) | (1L << (SLASH - 47)) | (1L << (PLUS - 47)) | (1L << (MINUS - 47)) | (1L << (PERCENT - 47)) | (1L << (LSHIFT - 47)) | (1L << (RSHIFT - 47)) | (1L << (ULSHIFT - 47)) | (1L << (URSHIFT - 47)) | (1L << (EQUAL - 47)) | (1L << (INEQUAL - 47)) | (1L << (GREATEREQ - 47)) | (1L << (LESSEREQ - 47)) | (1L << (GREATER - 47)) | (1L << (LESSER - 47)) | (1L << (ASSIGN - 47)) | (1L << (PASS - 47)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryopContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(CyclicLangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CyclicLangParser.MINUS, 0); }
		public TerminalNode EXCLAMATION() { return getToken(CyclicLangParser.EXCLAMATION, 0); }
		public UnaryopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitUnaryop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryopContext unaryop() throws RecognitionException {
		UnaryopContext _localctx = new UnaryopContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_unaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			_la = _input.LA(1);
			if ( !(((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & ((1L << (PLUS - 54)) | (1L << (MINUS - 54)) | (1L << (EXCLAMATION - 54)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public List<IdPartContext> idPart() {
			return getRuleContexts(IdPartContext.class);
		}
		public IdPartContext idPart(int i) {
			return getRuleContext(IdPartContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(CyclicLangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(CyclicLangParser.DOT, i);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_id);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			idPart();
			setState(712);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(708);
					match(DOT);
					setState(709);
					idPart();
					}
					} 
				}
				setState(714);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdPartContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CyclicLangParser.ID, 0); }
		public TerminalNode ANNOTATION() { return getToken(CyclicLangParser.ANNOTATION, 0); }
		public TerminalNode IN() { return getToken(CyclicLangParser.IN, 0); }
		public TerminalNode OUT() { return getToken(CyclicLangParser.OUT, 0); }
		public TerminalNode SEALED() { return getToken(CyclicLangParser.SEALED, 0); }
		public TerminalNode PERMITS() { return getToken(CyclicLangParser.PERMITS, 0); }
		public IdPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idPart; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitIdPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdPartContext idPart() throws RecognitionException {
		IdPartContext _localctx = new IdPartContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_idPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANNOTATION) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS))) != 0) || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(CyclicLangParser.PUBLIC, 0); }
		public TerminalNode STATIC() { return getToken(CyclicLangParser.STATIC, 0); }
		public TerminalNode PROTECTED() { return getToken(CyclicLangParser.PROTECTED, 0); }
		public TerminalNode FINAL() { return getToken(CyclicLangParser.FINAL, 0); }
		public TerminalNode PRIVATE() { return getToken(CyclicLangParser.PRIVATE, 0); }
		public TerminalNode ABSTRACT() { return getToken(CyclicLangParser.ABSTRACT, 0); }
		public TerminalNode SYNCHRONISED() { return getToken(CyclicLangParser.SYNCHRONISED, 0); }
		public TerminalNode NATIVE() { return getToken(CyclicLangParser.NATIVE, 0); }
		public TerminalNode STRICTFP() { return getToken(CyclicLangParser.STRICTFP, 0); }
		public TerminalNode VOLATILE() { return getToken(CyclicLangParser.VOLATILE, 0); }
		public TerminalNode SEALED() { return getToken(CyclicLangParser.SEALED, 0); }
		public TerminalNode NONSEALED() { return getToken(CyclicLangParser.NONSEALED, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << SEALED) | (1L << NONSEALED))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 32:
			return value_sempred((ValueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean value_sempred(ValueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 25);
		case 2:
			return precpred(_ctx, 24);
		case 3:
			return precpred(_ctx, 21);
		case 4:
			return precpred(_ctx, 20);
		case 5:
			return precpred(_ctx, 19);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3i\u02d2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\5"+
		"\2z\n\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\7\4\u0085\n\4\f\4\16\4\u0088"+
		"\13\4\3\5\3\5\5\5\u008c\n\5\3\5\3\5\3\5\5\5\u0091\n\5\3\5\3\5\3\6\7\6"+
		"\u0096\n\6\f\6\16\6\u0099\13\6\3\6\3\6\3\6\3\6\5\6\u009f\n\6\3\6\5\6\u00a2"+
		"\n\6\3\6\5\6\u00a5\n\6\3\6\5\6\u00a8\n\6\3\6\5\6\u00ab\n\6\3\6\3\6\7\6"+
		"\u00af\n\6\f\6\16\6\u00b2\13\6\3\6\3\6\5\6\u00b6\n\6\3\7\3\7\3\7\3\7\7"+
		"\7\u00bc\n\7\f\7\16\7\u00bf\13\7\3\b\3\b\3\b\3\b\7\b\u00c5\n\b\f\b\16"+
		"\b\u00c8\13\b\3\t\3\t\3\t\3\t\7\t\u00ce\n\t\f\t\16\t\u00d1\13\t\3\n\3"+
		"\n\3\n\3\n\7\n\u00d7\n\n\f\n\16\n\u00da\13\n\3\n\3\n\3\13\5\13\u00df\n"+
		"\13\3\13\5\13\u00e2\n\13\3\13\3\13\3\13\5\13\u00e7\n\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u00f1\n\f\3\r\3\r\3\r\3\r\7\r\u00f7\n\r\f\r\16"+
		"\r\u00fa\13\r\5\r\u00fc\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u0108\n\16\3\17\7\17\u010b\n\17\f\17\16\17\u010e\13\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0119\n\17\3\20\5\20\u011c"+
		"\n\20\3\20\3\20\3\21\7\21\u0121\n\21\f\21\16\21\u0124\13\21\3\21\3\21"+
		"\5\21\u0128\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0131\n\21\3"+
		"\22\3\22\5\22\u0135\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u013c\n\23\3\24"+
		"\7\24\u013f\n\24\f\24\16\24\u0142\13\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u0149\n\24\3\25\5\25\u014c\n\25\3\25\3\25\5\25\u0150\n\25\3\25\3\25\3"+
		"\25\5\25\u0155\n\25\3\26\3\26\3\26\7\26\u015a\n\26\f\26\16\26\u015d\13"+
		"\26\5\26\u015f\n\26\3\27\3\27\7\27\u0163\n\27\f\27\16\27\u0166\13\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\5\30\u0186\n\30\3\30\5\30\u0189\n\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u0192\n\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u019a\n"+
		"\31\f\31\16\31\u019d\13\31\3\31\5\31\u01a0\n\31\3\31\5\31\u01a3\n\31\3"+
		"\32\3\32\3\32\3\32\3\33\3\33\7\33\u01ab\n\33\f\33\16\33\u01ae\13\33\3"+
		"\33\3\33\5\33\u01b2\n\33\3\33\3\33\7\33\u01b6\n\33\f\33\16\33\u01b9\13"+
		"\33\3\33\3\33\7\33\u01bd\n\33\f\33\16\33\u01c0\13\33\3\34\3\34\3\34\3"+
		"\34\7\34\u01c6\n\34\f\34\16\34\u01c9\13\34\3\34\3\34\3\35\3\35\5\35\u01cf"+
		"\n\35\3\35\3\35\3\36\3\36\3\36\5\36\u01d6\n\36\3\37\3\37\3 \3 \3!\7!\u01dd"+
		"\n!\f!\16!\u01e0\13!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\5\"\u0205\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\5\"\u0210\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u021c\n\"\f"+
		"\"\16\"\u021f\13\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\5%\u022e\n%"+
		"\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3"+
		")\3)\3)\3)\3)\3)\7)\u024b\n)\f)\16)\u024e\13)\5)\u0250\n)\3)\3)\3*\3*"+
		"\3*\7*\u0257\n*\f*\16*\u025a\13*\5*\u025c\n*\3+\3+\5+\u0260\n+\3,\3,\3"+
		",\3,\5,\u0266\n,\3-\3-\3-\3.\3.\3.\3.\3.\3.\5.\u0271\n.\3/\3/\3/\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\5\61\u027f\n\61\3\61\3\61\3\61"+
		"\5\61\u0284\n\61\3\61\3\61\3\61\3\62\3\62\3\62\5\62\u028c\n\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\7\64\u02a3\n\64\f\64\16\64\u02a6\13\64\3"+
		"\64\5\64\u02a9\n\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65"+
		"\u02b4\n\65\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u02bc\n\66\3\67\3\67\3"+
		"\67\3\67\38\38\39\39\3:\3:\3:\7:\u02c9\n:\f:\16:\u02cc\13:\3;\3;\3<\3"+
		"<\3<\2\4\64B=\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv\2\13\3\2\36\37\4\2\32\32\35\35\3"+
		"\2X_\3\2`a\3\2\34\35\4\2\61:<G\4\289SS\5\2\27\27\36!dd\5\2\3\f  \"\"\2"+
		"\u030f\2y\3\2\2\2\4\177\3\2\2\2\6\u0086\3\2\2\2\b\u0089\3\2\2\2\n\u0097"+
		"\3\2\2\2\f\u00b7\3\2\2\2\16\u00c0\3\2\2\2\20\u00c9\3\2\2\2\22\u00d2\3"+
		"\2\2\2\24\u00de\3\2\2\2\26\u00f0\3\2\2\2\30\u00f2\3\2\2\2\32\u0107\3\2"+
		"\2\2\34\u010c\3\2\2\2\36\u011b\3\2\2\2 \u0122\3\2\2\2\"\u0134\3\2\2\2"+
		"$\u0136\3\2\2\2&\u0140\3\2\2\2(\u014b\3\2\2\2*\u015e\3\2\2\2,\u0160\3"+
		"\2\2\2.\u0191\3\2\2\2\60\u0193\3\2\2\2\62\u01a4\3\2\2\2\64\u01a8\3\2\2"+
		"\2\66\u01c1\3\2\2\28\u01ce\3\2\2\2:\u01d5\3\2\2\2<\u01d7\3\2\2\2>\u01d9"+
		"\3\2\2\2@\u01de\3\2\2\2B\u0204\3\2\2\2D\u0220\3\2\2\2F\u0226\3\2\2\2H"+
		"\u022b\3\2\2\2J\u0232\3\2\2\2L\u0237\3\2\2\2N\u023c\3\2\2\2P\u0242\3\2"+
		"\2\2R\u025b\3\2\2\2T\u025d\3\2\2\2V\u0261\3\2\2\2X\u0267\3\2\2\2Z\u026a"+
		"\3\2\2\2\\\u0272\3\2\2\2^\u0275\3\2\2\2`\u027b\3\2\2\2b\u0288\3\2\2\2"+
		"d\u0294\3\2\2\2f\u029c\3\2\2\2h\u02ac\3\2\2\2j\u02b5\3\2\2\2l\u02bd\3"+
		"\2\2\2n\u02c1\3\2\2\2p\u02c3\3\2\2\2r\u02c5\3\2\2\2t\u02cd\3\2\2\2v\u02cf"+
		"\3\2\2\2xz\5\4\3\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\5\6\4\2|}\5\n\6\2}"+
		"~\7\2\2\3~\3\3\2\2\2\177\u0080\7\31\2\2\u0080\u0081\5r:\2\u0081\u0082"+
		"\7O\2\2\u0082\5\3\2\2\2\u0083\u0085\5\b\5\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\7\3\2\2\2"+
		"\u0088\u0086\3\2\2\2\u0089\u008b\7\30\2\2\u008a\u008c\7\t\2\2\u008b\u008a"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0090\5r:\2\u008e"+
		"\u008f\7Q\2\2\u008f\u0091\7\66\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7O\2\2\u0093\t\3\2\2\2\u0094\u0096"+
		"\5\60\31\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b"+
		"\5@!\2\u009b\u009c\5\26\f\2\u009c\u009e\5t;\2\u009d\u009f\5\22\n\2\u009e"+
		"\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u00a2\5\30"+
		"\r\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3"+
		"\u00a5\5\f\7\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2"+
		"\2\2\u00a6\u00a8\5\16\b\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00aa\3\2\2\2\u00a9\u00ab\5\20\t\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3"+
		"\2\2\2\u00ab\u00b5\3\2\2\2\u00ac\u00b0\7H\2\2\u00ad\u00af\5\32\16\2\u00ae"+
		"\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\7I\2\2\u00b4"+
		"\u00b6\7O\2\2\u00b5\u00ac\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\13\3\2\2\2"+
		"\u00b7\u00b8\7\32\2\2\u00b8\u00bd\5\64\33\2\u00b9\u00ba\7R\2\2\u00ba\u00bc"+
		"\5\64\33\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2"+
		"\u00bd\u00be\3\2\2\2\u00be\r\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\7"+
		"\33\2\2\u00c1\u00c6\5\64\33\2\u00c2\u00c3\7R\2\2\u00c3\u00c5\5\64\33\2"+
		"\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7"+
		"\3\2\2\2\u00c7\17\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\7!\2\2\u00ca"+
		"\u00cf\5\64\33\2\u00cb\u00cc\7R\2\2\u00cc\u00ce\5\64\33\2\u00cd\u00cb"+
		"\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\21\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7E\2\2\u00d3\u00d8\5\24\13"+
		"\2\u00d4\u00d5\7R\2\2\u00d5\u00d7\5\24\13\2\u00d6\u00d4\3\2\2\2\u00d7"+
		"\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2"+
		"\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7D\2\2\u00dc\23\3\2\2\2\u00dd\u00df"+
		"\t\2\2\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0"+
		"\u00e2\7\22\2\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3"+
		"\2\2\2\u00e3\u00e6\5\64\33\2\u00e4\u00e5\7\32\2\2\u00e5\u00e7\5\64\33"+
		"\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\25\3\2\2\2\u00e8\u00f1"+
		"\7\22\2\2\u00e9\u00f1\7\23\2\2\u00ea\u00f1\7\24\2\2\u00eb\u00ec\7;\2\2"+
		"\u00ec\u00f1\7\23\2\2\u00ed\u00f1\7\27\2\2\u00ee\u00f1\7\25\2\2\u00ef"+
		"\u00f1\7\26\2\2\u00f0\u00e8\3\2\2\2\u00f0\u00e9\3\2\2\2\u00f0\u00ea\3"+
		"\2\2\2\u00f0\u00eb\3\2\2\2\u00f0\u00ed\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0"+
		"\u00ef\3\2\2\2\u00f1\27\3\2\2\2\u00f2\u00fb\7J\2\2\u00f3\u00f8\5(\25\2"+
		"\u00f4\u00f5\7R\2\2\u00f5\u00f7\5(\25\2\u00f6\u00f4\3\2\2\2\u00f7\u00fa"+
		"\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fb\u00f3\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2"+
		"\2\2\u00fd\u00fe\7K\2\2\u00fe\31\3\2\2\2\u00ff\u0108\5 \21\2\u0100\u0108"+
		"\5\34\17\2\u0101\u0102\5&\24\2\u0102\u0103\7O\2\2\u0103\u0108\3\2\2\2"+
		"\u0104\u0108\5\n\6\2\u0105\u0108\5\36\20\2\u0106\u0108\7O\2\2\u0107\u00ff"+
		"\3\2\2\2\u0107\u0100\3\2\2\2\u0107\u0101\3\2\2\2\u0107\u0104\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108\33\3\2\2\2\u0109\u010b\5\60\31"+
		"\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0110\5@!\2\u0110"+
		"\u0111\5\64\33\2\u0111\u0112\7J\2\2\u0112\u0113\5*\26\2\u0113\u0118\7"+
		"K\2\2\u0114\u0119\5,\27\2\u0115\u0119\7O\2\2\u0116\u0117\7V\2\2\u0117"+
		"\u0119\5.\30\2\u0118\u0114\3\2\2\2\u0118\u0115\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0119\35\3\2\2\2\u011a\u011c\7\t\2\2\u011b\u011a\3\2\2\2\u011b\u011c"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\5,\27\2\u011e\37\3\2\2\2\u011f"+
		"\u0121\5\60\31\2\u0120\u011f\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3"+
		"\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125\3\2\2\2\u0124\u0122\3\2\2\2\u0125"+
		"\u0127\5@!\2\u0126\u0128\5\22\n\2\u0127\u0126\3\2\2\2\u0127\u0128\3\2"+
		"\2\2\u0128\u0129\3\2\2\2\u0129\u012a\5\64\33\2\u012a\u012b\5t;\2\u012b"+
		"\u012c\7J\2\2\u012c\u012d\5*\26\2\u012d\u0130\7K\2\2\u012e\u0131\5\"\22"+
		"\2\u012f\u0131\5$\23\2\u0130\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u0131!"+
		"\3\2\2\2\u0132\u0135\5,\27\2\u0133\u0135\7O\2\2\u0134\u0132\3\2\2\2\u0134"+
		"\u0133\3\2\2\2\u0135#\3\2\2\2\u0136\u013b\7V\2\2\u0137\u0138\5B\"\2\u0138"+
		"\u0139\7O\2\2\u0139\u013c\3\2\2\2\u013a\u013c\5.\30\2\u013b\u0137\3\2"+
		"\2\2\u013b\u013a\3\2\2\2\u013c%\3\2\2\2\u013d\u013f\5\60\31\2\u013e\u013d"+
		"\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0144\5@!\2\u0144\u0145\5\64"+
		"\33\2\u0145\u0148\5t;\2\u0146\u0147\7F\2\2\u0147\u0149\5B\"\2\u0148\u0146"+
		"\3\2\2\2\u0148\u0149\3\2\2\2\u0149\'\3\2\2\2\u014a\u014c\7\n\2\2\u014b"+
		"\u014a\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\5\64"+
		"\33\2\u014e\u0150\7U\2\2\u014f\u014e\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0151\3\2\2\2\u0151\u0154\5t;\2\u0152\u0153\7F\2\2\u0153\u0155\5B\"\2"+
		"\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155)\3\2\2\2\u0156\u015b\5"+
		"(\25\2\u0157\u0158\7R\2\2\u0158\u015a\5(\25\2\u0159\u0157\3\2\2\2\u015a"+
		"\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015f\3\2"+
		"\2\2\u015d\u015b\3\2\2\2\u015e\u0156\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"+\3\2\2\2\u0160\u0164\7H\2\2\u0161\u0163\5.\30\2\u0162\u0161\3\2\2\2\u0163"+
		"\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0167\3\2"+
		"\2\2\u0166\u0164\3\2\2\2\u0167\u0168\7I\2\2\u0168-\3\2\2\2\u0169\u0192"+
		"\5,\27\2\u016a\u016b\5T+\2\u016b\u016c\7O\2\2\u016c\u0192\3\2\2\2\u016d"+
		"\u016e\5V,\2\u016e\u016f\7O\2\2\u016f\u0192\3\2\2\2\u0170\u0171\5X-\2"+
		"\u0171\u0172\7O\2\2\u0172\u0192\3\2\2\2\u0173\u0174\5&\24\2\u0174\u0175"+
		"\7O\2\2\u0175\u0192\3\2\2\2\u0176\u0177\5H%\2\u0177\u0178\7O\2\2\u0178"+
		"\u0192\3\2\2\2\u0179\u017a\5D#\2\u017a\u017b\7O\2\2\u017b\u0192\3\2\2"+
		"\2\u017c\u0192\5Z.\2\u017d\u0192\5^\60\2\u017e\u0192\5`\61\2\u017f\u0192"+
		"\5b\62\2\u0180\u0192\5f\64\2\u0181\u0192\5d\63\2\u0182\u0192\5l\67\2\u0183"+
		"\u0186\5B\"\2\u0184\u0186\7\35\2\2\u0185\u0183\3\2\2\2\u0185\u0184\3\2"+
		"\2\2\u0186\u0187\3\2\2\2\u0187\u0189\7Q\2\2\u0188\u0185\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\5J&\2\u018b\u018c\7O\2"+
		"\2\u018c\u0192\3\2\2\2\u018d\u018e\5L\'\2\u018e\u018f\7O\2\2\u018f\u0192"+
		"\3\2\2\2\u0190\u0192\7O\2\2\u0191\u0169\3\2\2\2\u0191\u016a\3\2\2\2\u0191"+
		"\u016d\3\2\2\2\u0191\u0170\3\2\2\2\u0191\u0173\3\2\2\2\u0191\u0176\3\2"+
		"\2\2\u0191\u0179\3\2\2\2\u0191\u017c\3\2\2\2\u0191\u017d\3\2\2\2\u0191"+
		"\u017e\3\2\2\2\u0191\u017f\3\2\2\2\u0191\u0180\3\2\2\2\u0191\u0181\3\2"+
		"\2\2\u0191\u0182\3\2\2\2\u0191\u0188\3\2\2\2\u0191\u018d\3\2\2\2\u0191"+
		"\u0190\3\2\2\2\u0192/\3\2\2\2\u0193\u0194\7;\2\2\u0194\u01a2\5r:\2\u0195"+
		"\u019f\7J\2\2\u0196\u019b\5\62\32\2\u0197\u0198\7R\2\2\u0198\u019a\5\62"+
		"\32\2\u0199\u0197\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u01a0\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u01a0\5B"+
		"\"\2\u019f\u0196\3\2\2\2\u019f\u019e\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a1\3\2\2\2\u01a1\u01a3\7K\2\2\u01a2\u0195\3\2\2\2\u01a2\u01a3\3\2"+
		"\2\2\u01a3\61\3\2\2\2\u01a4\u01a5\5t;\2\u01a5\u01a6\7F\2\2\u01a6\u01a7"+
		"\5B\"\2\u01a7\63\3\2\2\2\u01a8\u01ac\b\33\1\2\u01a9\u01ab\5\60\31\2\u01aa"+
		"\u01a9\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2"+
		"\2\2\u01ad\u01af\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b1\5:\36\2\u01b0"+
		"\u01b2\5\66\34\2\u01b1\u01b0\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01be\3"+
		"\2\2\2\u01b3\u01b7\f\3\2\2\u01b4\u01b6\5\60\31\2\u01b5\u01b4\3\2\2\2\u01b6"+
		"\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01ba\3\2"+
		"\2\2\u01b9\u01b7\3\2\2\2\u01ba\u01bb\7L\2\2\u01bb\u01bd\7M\2\2\u01bc\u01b3"+
		"\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf"+
		"\65\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c2\7E\2\2\u01c2\u01c7\58\35\2"+
		"\u01c3\u01c4\7R\2\2\u01c4\u01c6\58\35\2\u01c5\u01c3\3\2\2\2\u01c6\u01c9"+
		"\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9"+
		"\u01c7\3\2\2\2\u01ca\u01cb\7D\2\2\u01cb\67\3\2\2\2\u01cc\u01cd\7T\2\2"+
		"\u01cd\u01cf\t\3\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0"+
		"\3\2\2\2\u01d0\u01d1\5\64\33\2\u01d19\3\2\2\2\u01d2\u01d6\5<\37\2\u01d3"+
		"\u01d6\5> \2\u01d4\u01d6\5r:\2\u01d5\u01d2\3\2\2\2\u01d5\u01d3\3\2\2\2"+
		"\u01d5\u01d4\3\2\2\2\u01d6;\3\2\2\2\u01d7\u01d8\t\4\2\2\u01d8=\3\2\2\2"+
		"\u01d9\u01da\t\5\2\2\u01da?\3\2\2\2\u01db\u01dd\5v<\2\u01dc\u01db\3\2"+
		"\2\2\u01dd\u01e0\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df"+
		"A\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1\u01e2\b\"\1\2\u01e2\u0205\5J&\2\u01e3"+
		"\u01e4\7\35\2\2\u01e4\u01e5\7Q\2\2\u01e5\u0205\5J&\2\u01e6\u01e7\7*\2"+
		"\2\u01e7\u0205\5.\30\2\u01e8\u0205\5D#\2\u01e9\u01ea\7J\2\2\u01ea\u01eb"+
		"\5B\"\2\u01eb\u01ec\7K\2\2\u01ec\u0205\3\2\2\2\u01ed\u0205\5&\24\2\u01ee"+
		"\u0205\5f\64\2\u01ef\u01f0\5r:\2\u01f0\u01f1\7Q\2\2\u01f1\u01f2\7\22\2"+
		"\2\u01f2\u0205\3\2\2\2\u01f3\u01f4\5<\37\2\u01f4\u01f5\7Q\2\2\u01f5\u01f6"+
		"\7\22\2\2\u01f6\u0205\3\2\2\2\u01f7\u0205\5F$\2\u01f8\u01f9\5p9\2\u01f9"+
		"\u01fa\5B\"\f\u01fa\u0205\3\2\2\2\u01fb\u0205\5N(\2\u01fc\u0205\5P)\2"+
		"\u01fd\u0205\7\34\2\2\u01fe\u0205\7,\2\2\u01ff\u0205\7-\2\2\u0200\u0205"+
		"\7.\2\2\u0201\u0205\7/\2\2\u0202\u0205\7\60\2\2\u0203\u0205\5t;\2\u0204"+
		"\u01e1\3\2\2\2\u0204\u01e3\3\2\2\2\u0204\u01e6\3\2\2\2\u0204\u01e8\3\2"+
		"\2\2\u0204\u01e9\3\2\2\2\u0204\u01ed\3\2\2\2\u0204\u01ee\3\2\2\2\u0204"+
		"\u01ef\3\2\2\2\u0204\u01f3\3\2\2\2\u0204\u01f7\3\2\2\2\u0204\u01f8\3\2"+
		"\2\2\u0204\u01fb\3\2\2\2\u0204\u01fc\3\2\2\2\u0204\u01fd\3\2\2\2\u0204"+
		"\u01fe\3\2\2\2\u0204\u01ff\3\2\2\2\u0204\u0200\3\2\2\2\u0204\u0201\3\2"+
		"\2\2\u0204\u0202\3\2\2\2\u0204\u0203\3\2\2\2\u0205\u021d\3\2\2\2\u0206"+
		"\u0207\f\33\2\2\u0207\u0208\5n8\2\u0208\u0209\5B\"\34\u0209\u021c\3\2"+
		"\2\2\u020a\u020b\f\32\2\2\u020b\u020c\7Q\2\2\u020c\u021c\5J&\2\u020d\u020f"+
		"\f\27\2\2\u020e\u0210\7S\2\2\u020f\u020e\3\2\2\2\u020f\u0210\3\2\2\2\u0210"+
		"\u0211\3\2\2\2\u0211\u0212\7\r\2\2\u0212\u021c\5\64\33\2\u0213\u0214\f"+
		"\26\2\2\u0214\u0215\7L\2\2\u0215\u0216\5B\"\2\u0216\u0217\7M\2\2\u0217"+
		"\u021c\3\2\2\2\u0218\u0219\f\25\2\2\u0219\u021a\7Q\2\2\u021a\u021c\5t"+
		";\2\u021b\u0206\3\2\2\2\u021b\u020a\3\2\2\2\u021b\u020d\3\2\2\2\u021b"+
		"\u0213\3\2\2\2\u021b\u0218\3\2\2\2\u021c\u021f\3\2\2\2\u021d\u021b\3\2"+
		"\2\2\u021d\u021e\3\2\2\2\u021eC\3\2\2\2\u021f\u021d\3\2\2\2\u0220\u0221"+
		"\7\20\2\2\u0221\u0222\5\64\33\2\u0222\u0223\7J\2\2\u0223\u0224\5R*\2\u0224"+
		"\u0225\7K\2\2\u0225E\3\2\2\2\u0226\u0227\7J\2\2\u0227\u0228\5\64\33\2"+
		"\u0228\u0229\7K\2\2\u0229\u022a\5B\"\2\u022aG\3\2\2\2\u022b\u022d\5B\""+
		"\2\u022c\u022e\5n8\2\u022d\u022c\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f"+
		"\3\2\2\2\u022f\u0230\7F\2\2\u0230\u0231\5B\"\2\u0231I\3\2\2\2\u0232\u0233"+
		"\5t;\2\u0233\u0234\7J\2\2\u0234\u0235\5R*\2\u0235\u0236\7K\2\2\u0236K"+
		"\3\2\2\2\u0237\u0238\t\6\2\2\u0238\u0239\7J\2\2\u0239\u023a\5R*\2\u023a"+
		"\u023b\7K\2\2\u023bM\3\2\2\2\u023c\u023d\7\20\2\2\u023d\u023e\5\64\33"+
		"\2\u023e\u023f\7L\2\2\u023f\u0240\5B\"\2\u0240\u0241\7M\2\2\u0241O\3\2"+
		"\2\2\u0242\u0243\7\20\2\2\u0243\u0244\5\64\33\2\u0244\u0245\7L\2\2\u0245"+
		"\u0246\7M\2\2\u0246\u024f\7H\2\2\u0247\u024c\5B\"\2\u0248\u0249\7R\2\2"+
		"\u0249\u024b\5B\"\2\u024a\u0248\3\2\2\2\u024b\u024e\3\2\2\2\u024c\u024a"+
		"\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u0250\3\2\2\2\u024e\u024c\3\2\2\2\u024f"+
		"\u0247\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0252\7I"+
		"\2\2\u0252Q\3\2\2\2\u0253\u0258\5B\"\2\u0254\u0255\7R\2\2\u0255\u0257"+
		"\5B\"\2\u0256\u0254\3\2\2\2\u0257\u025a\3\2\2\2\u0258\u0256\3\2\2\2\u0258"+
		"\u0259\3\2\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025b\u0253\3\2"+
		"\2\2\u025b\u025c\3\2\2\2\u025cS\3\2\2\2\u025d\u025f\7\16\2\2\u025e\u0260"+
		"\5B\"\2\u025f\u025e\3\2\2\2\u025f\u0260\3\2\2\2\u0260U\3\2\2\2\u0261\u0262"+
		"\7\17\2\2\u0262\u0265\5B\"\2\u0263\u0264\7N\2\2\u0264\u0266\7.\2\2\u0265"+
		"\u0263\3\2\2\2\u0265\u0266\3\2\2\2\u0266W\3\2\2\2\u0267\u0268\7\21\2\2"+
		"\u0268\u0269\5B\"\2\u0269Y\3\2\2\2\u026a\u026b\7+\2\2\u026b\u026c\7J\2"+
		"\2\u026c\u026d\5B\"\2\u026d\u026e\7K\2\2\u026e\u0270\5.\30\2\u026f\u0271"+
		"\5\\/\2\u0270\u026f\3\2\2\2\u0270\u0271\3\2\2\2\u0271[\3\2\2\2\u0272\u0273"+
		"\7(\2\2\u0273\u0274\5.\30\2\u0274]\3\2\2\2\u0275\u0276\7%\2\2\u0276\u0277"+
		"\7J\2\2\u0277\u0278\5B\"\2\u0278\u0279\7K\2\2\u0279\u027a\5.\30\2\u027a"+
		"_\3\2\2\2\u027b\u027c\7)\2\2\u027c\u027e\7J\2\2\u027d\u027f\5.\30\2\u027e"+
		"\u027d\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0281\5B"+
		"\"\2\u0281\u0283\7O\2\2\u0282\u0284\5.\30\2\u0283\u0282\3\2\2\2\u0283"+
		"\u0284\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0286\7K\2\2\u0286\u0287\5.\30"+
		"\2\u0287a\3\2\2\2\u0288\u0289\7)\2\2\u0289\u028b\7J\2\2\u028a\u028c\7"+
		"\n\2\2\u028b\u028a\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u028d\3\2\2\2\u028d"+
		"\u028e\5\64\33\2\u028e\u028f\5t;\2\u028f\u0290\7N\2\2\u0290\u0291\5B\""+
		"\2\u0291\u0292\7K\2\2\u0292\u0293\5.\30\2\u0293c\3\2\2\2\u0294\u0295\7"+
		"*\2\2\u0295\u0296\5.\30\2\u0296\u0297\7%\2\2\u0297\u0298\7J\2\2\u0298"+
		"\u0299\5B\"\2\u0299\u029a\7K\2\2\u029a\u029b\7O\2\2\u029be\3\2\2\2\u029c"+
		"\u029d\7$\2\2\u029d\u029e\7J\2\2\u029e\u029f\5B\"\2\u029f\u02a0\7K\2\2"+
		"\u02a0\u02a4\7H\2\2\u02a1\u02a3\5h\65\2\u02a2\u02a1\3\2\2\2\u02a3\u02a6"+
		"\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a8\3\2\2\2\u02a6"+
		"\u02a4\3\2\2\2\u02a7\u02a9\5j\66\2\u02a8\u02a7\3\2\2\2\u02a8\u02a9\3\2"+
		"\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02ab\7I\2\2\u02abg\3\2\2\2\u02ac\u02ad"+
		"\7\'\2\2\u02ad\u02ae\5B\"\2\u02ae\u02b3\7V\2\2\u02af\u02b4\5.\30\2\u02b0"+
		"\u02b1\5B\"\2\u02b1\u02b2\7O\2\2\u02b2\u02b4\3\2\2\2\u02b3\u02af\3\2\2"+
		"\2\u02b3\u02b0\3\2\2\2\u02b4i\3\2\2\2\u02b5\u02b6\7#\2\2\u02b6\u02bb\7"+
		"V\2\2\u02b7\u02bc\5.\30\2\u02b8\u02b9\5B\"\2\u02b9\u02ba\7O\2\2\u02ba"+
		"\u02bc\3\2\2\2\u02bb\u02b7\3\2\2\2\u02bb\u02b8\3\2\2\2\u02bck\3\2\2\2"+
		"\u02bd\u02be\7&\2\2\u02be\u02bf\5B\"\2\u02bf\u02c0\7O\2\2\u02c0m\3\2\2"+
		"\2\u02c1\u02c2\t\7\2\2\u02c2o\3\2\2\2\u02c3\u02c4\t\b\2\2\u02c4q\3\2\2"+
		"\2\u02c5\u02ca\5t;\2\u02c6\u02c7\7Q\2\2\u02c7\u02c9\5t;\2\u02c8\u02c6"+
		"\3\2\2\2\u02c9\u02cc\3\2\2\2\u02ca\u02c8\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb"+
		"s\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cd\u02ce\t\t\2\2\u02ceu\3\2\2\2\u02cf"+
		"\u02d0\t\n\2\2\u02d0w\3\2\2\2Ky\u0086\u008b\u0090\u0097\u009e\u00a1\u00a4"+
		"\u00a7\u00aa\u00b0\u00b5\u00bd\u00c6\u00cf\u00d8\u00de\u00e1\u00e6\u00f0"+
		"\u00f8\u00fb\u0107\u010c\u0118\u011b\u0122\u0127\u0130\u0134\u013b\u0140"+
		"\u0148\u014b\u014f\u0154\u015b\u015e\u0164\u0185\u0188\u0191\u019b\u019f"+
		"\u01a2\u01ac\u01b1\u01b7\u01be\u01c7\u01ce\u01d5\u01de\u0204\u020f\u021b"+
		"\u021d\u022d\u024c\u024f\u0258\u025b\u025f\u0265\u0270\u027e\u0283\u028b"+
		"\u02a4\u02a8\u02b3\u02bb\u02ca";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}