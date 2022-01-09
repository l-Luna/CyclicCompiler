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
		ELIPSES=83, DASHARROW=84, EQARROW=85, INT=86, DEC=87, DOUBLE=88, BYTE=89, 
		BOOL=90, VOID=91, VAR=92, VAL=93, TRUE=94, FALSE=95, ID=96, DIGIT=97, 
		NONDIGIT=98, SING_COMMENT=99, WS=100, UNMATCHED=101;
	public static final int
		RULE_file = 0, RULE_packageDecl = 1, RULE_imports = 2, RULE_importDecl = 3, 
		RULE_classDecl = 4, RULE_objectExtends = 5, RULE_objectImplements = 6, 
		RULE_objectPermits = 7, RULE_genericTypeDefs = 8, RULE_genericTypeDef = 9, 
		RULE_objectType = 10, RULE_recordComponents = 11, RULE_member = 12, RULE_constructor = 13, 
		RULE_init = 14, RULE_function = 15, RULE_functionBlock = 16, RULE_functionArrow = 17, 
		RULE_varDecl = 18, RULE_parameter = 19, RULE_parameters = 20, RULE_block = 21, 
		RULE_statement = 22, RULE_annotation = 23, RULE_annotationArg = 24, RULE_type = 25, 
		RULE_genericTypeUses = 26, RULE_genericTypeUse = 27, RULE_rawType = 28, 
		RULE_modifiers = 29, RULE_value = 30, RULE_initialisation = 31, RULE_cast = 32, 
		RULE_varAssignment = 33, RULE_call = 34, RULE_ctorCall = 35, RULE_newArray = 36, 
		RULE_newListedArray = 37, RULE_arguments = 38, RULE_returnStatement = 39, 
		RULE_assertStatement = 40, RULE_throwStatement = 41, RULE_ifStatement = 42, 
		RULE_elseStatement = 43, RULE_whileStatement = 44, RULE_forStatement = 45, 
		RULE_foreachStatement = 46, RULE_doWhile = 47, RULE_switchStatement = 48, 
		RULE_caseClause = 49, RULE_defaultClause = 50, RULE_yieldStatement = 51, 
		RULE_binaryop = 52, RULE_unaryop = 53, RULE_id = 54, RULE_idPart = 55, 
		RULE_modifier = 56;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "packageDecl", "imports", "importDecl", "classDecl", "objectExtends", 
			"objectImplements", "objectPermits", "genericTypeDefs", "genericTypeDef", 
			"objectType", "recordComponents", "member", "constructor", "init", "function", 
			"functionBlock", "functionArrow", "varDecl", "parameter", "parameters", 
			"block", "statement", "annotation", "annotationArg", "type", "genericTypeUses", 
			"genericTypeUse", "rawType", "modifiers", "value", "initialisation", 
			"cast", "varAssignment", "call", "ctorCall", "newArray", "newListedArray", 
			"arguments", "returnStatement", "assertStatement", "throwStatement", 
			"ifStatement", "elseStatement", "whileStatement", "forStatement", "foreachStatement", 
			"doWhile", "switchStatement", "caseClause", "defaultClause", "yieldStatement", 
			"binaryop", "unaryop", "id", "idPart", "modifier"
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
			"'=>'", "'int'", "'float'", "'double'", "'byte'", "'boolean'", "'void'", 
			"'var'", "'val'", "'true'", "'false'"
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
			"DASHARROW", "EQARROW", "INT", "DEC", "DOUBLE", "BYTE", "BOOL", "VOID", 
			"VAR", "VAL", "TRUE", "FALSE", "ID", "DIGIT", "NONDIGIT", "SING_COMMENT", 
			"WS", "UNMATCHED"
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
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(114);
				packageDecl();
				}
			}

			setState(117);
			imports();
			setState(118);
			classDecl();
			setState(119);
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
			setState(121);
			match(PACKAGE);
			setState(122);
			id();
			setState(123);
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
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(125);
				importDecl();
				}
				}
				setState(130);
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
			setState(131);
			match(IMPORT);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(132);
				match(STATIC);
				}
			}

			setState(135);
			id();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(136);
				match(DOT);
				setState(137);
				match(STAR);
				}
			}

			setState(140);
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
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(142);
					annotation();
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(148);
			modifiers();
			setState(149);
			objectType();
			setState(150);
			idPart();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESSER) {
				{
				setState(151);
				genericTypeDefs();
				}
			}

			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(154);
				recordComponents();
				}
			}

			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(157);
				objectExtends();
				}
			}

			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(160);
				objectImplements();
				}
			}

			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERMITS) {
				{
				setState(163);
				objectPermits();
				}
			}

			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(166);
				match(LBRACE);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << CLASS) | (1L << INTERFACE) | (1L << ENUM) | (1L << RECORD) | (1L << SINGLE) | (1L << ANNOTATION) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << AT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (LESSER - 67)) | (1L << (LBRACE - 67)) | (1L << (SEMICOLON - 67)) | (1L << (INT - 67)) | (1L << (DEC - 67)) | (1L << (DOUBLE - 67)) | (1L << (BYTE - 67)) | (1L << (BOOL - 67)) | (1L << (VOID - 67)) | (1L << (VAR - 67)) | (1L << (VAL - 67)) | (1L << (ID - 67)))) != 0)) {
					{
					{
					setState(167);
					member();
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				match(RBRACE);
				}
				break;
			case SEMICOLON:
				{
				setState(174);
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
			setState(177);
			match(EXTENDS);
			setState(178);
			type(0);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(179);
				match(COMMA);
				setState(180);
				type(0);
				}
				}
				setState(185);
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
			setState(186);
			match(IMPLEMENTS);
			setState(187);
			type(0);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(188);
				match(COMMA);
				setState(189);
				type(0);
				}
				}
				setState(194);
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
			setState(195);
			match(PERMITS);
			setState(196);
			type(0);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(197);
				match(COMMA);
				setState(198);
				type(0);
				}
				}
				setState(203);
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
			setState(204);
			match(LESSER);
			setState(205);
			genericTypeDef();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(206);
				match(COMMA);
				setState(207);
				genericTypeDef();
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213);
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
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(215);
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
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLASS) {
				{
				setState(218);
				match(CLASS);
				}
			}

			setState(221);
			type(0);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(222);
				match(EXTENDS);
				setState(223);
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
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				match(CLASS);
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				match(INTERFACE);
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
				match(ENUM);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 4);
				{
				setState(229);
				match(AT);
				setState(230);
				match(INTERFACE);
				}
				break;
			case ANNOTATION:
				enterOuterAlt(_localctx, 5);
				{
				setState(231);
				match(ANNOTATION);
				}
				break;
			case RECORD:
				enterOuterAlt(_localctx, 6);
				{
				setState(232);
				match(RECORD);
				}
				break;
			case SINGLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(233);
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
			setState(236);
			match(LPAREN);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << ANNOTATION) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << AT))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (INT - 86)) | (1L << (DEC - 86)) | (1L << (DOUBLE - 86)) | (1L << (BYTE - 86)) | (1L << (BOOL - 86)) | (1L << (VOID - 86)) | (1L << (VAR - 86)) | (1L << (VAL - 86)) | (1L << (ID - 86)))) != 0)) {
				{
				setState(237);
				parameter();
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(238);
					match(COMMA);
					setState(239);
					parameter();
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(247);
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
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				function();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				constructor();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(251);
				varDecl();
				setState(252);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(254);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(255);
				init();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(256);
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
			setState(262);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(259);
					annotation();
					}
					} 
				}
				setState(264);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(265);
			modifiers();
			setState(266);
			type(0);
			setState(267);
			match(LPAREN);
			setState(268);
			parameters();
			setState(269);
			match(RPAREN);
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(270);
				block();
				}
				break;
			case SEMICOLON:
				{
				setState(271);
				match(SEMICOLON);
				}
				break;
			case DASHARROW:
				{
				setState(272);
				match(DASHARROW);
				setState(273);
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
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(276);
				match(STATIC);
				}
			}

			setState(279);
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
			setState(284);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(281);
					annotation();
					}
					} 
				}
				setState(286);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(287);
			modifiers();
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESSER) {
				{
				setState(288);
				genericTypeDefs();
				}
			}

			setState(291);
			type(0);
			setState(292);
			idPart();
			setState(293);
			match(LPAREN);
			setState(294);
			parameters();
			setState(295);
			match(RPAREN);
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
			case SEMICOLON:
				{
				setState(296);
				functionBlock();
				}
				break;
			case DASHARROW:
				{
				setState(297);
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
			setState(302);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(300);
				block();
				}
				break;
			case SEMICOLON:
				{
				setState(301);
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
			setState(304);
			match(DASHARROW);
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(305);
				value(0);
				setState(306);
				match(SEMICOLON);
				}
				break;
			case 2:
				{
				setState(308);
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
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(311);
					annotation();
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(317);
			modifiers();
			setState(318);
			type(0);
			setState(319);
			idPart();
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(320);
				match(ASSIGN);
				setState(321);
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
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINAL) {
				{
				setState(324);
				match(FINAL);
				}
			}

			setState(327);
			type(0);
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELIPSES) {
				{
				setState(328);
				match(ELIPSES);
				}
			}

			setState(331);
			idPart();
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(332);
				match(ASSIGN);
				setState(333);
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
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << ANNOTATION) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << AT))) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (INT - 86)) | (1L << (DEC - 86)) | (1L << (DOUBLE - 86)) | (1L << (BYTE - 86)) | (1L << (BOOL - 86)) | (1L << (VOID - 86)) | (1L << (VAR - 86)) | (1L << (VAL - 86)) | (1L << (ID - 86)))) != 0)) {
				{
				setState(336);
				parameter();
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(337);
					match(COMMA);
					setState(338);
					parameter();
					}
					}
					setState(343);
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
			setState(346);
			match(LBRACE);
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << RETURN) | (1L << ASSERT) | (1L << NEW) | (1L << THROW) | (1L << ANNOTATION) | (1L << THIS) | (1L << SUPER) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << WHILE) | (1L << YIELD) | (1L << FOR) | (1L << DO) | (1L << IF) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LBRACE - 70)) | (1L << (LPAREN - 70)) | (1L << (SEMICOLON - 70)) | (1L << (EXCLAMATION - 70)) | (1L << (INT - 70)) | (1L << (DEC - 70)) | (1L << (DOUBLE - 70)) | (1L << (BYTE - 70)) | (1L << (BOOL - 70)) | (1L << (VOID - 70)) | (1L << (VAR - 70)) | (1L << (VAL - 70)) | (1L << (ID - 70)))) != 0)) {
				{
				{
				setState(347);
				statement();
				}
				}
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(353);
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
			setState(395);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				returnStatement();
				setState(357);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(359);
				assertStatement();
				setState(360);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(362);
				throwStatement();
				setState(363);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(365);
				varDecl();
				setState(366);
				match(SEMICOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(368);
				varAssignment();
				setState(369);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(371);
				initialisation();
				setState(372);
				match(SEMICOLON);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(374);
				ifStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(375);
				whileStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(376);
				forStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(377);
				foreachStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(378);
				switchStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(379);
				doWhile();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(380);
				yieldStatement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(386);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(383);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						setState(381);
						value(0);
						}
						break;
					case 2:
						{
						setState(382);
						match(SUPER);
						}
						break;
					}
					setState(385);
					match(DOT);
					}
					break;
				}
				setState(388);
				call();
				setState(389);
				match(SEMICOLON);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(391);
				ctorCall();
				setState(392);
				match(SEMICOLON);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(394);
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
			setState(397);
			match(AT);
			setState(398);
			id();
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(399);
				match(LPAREN);
				setState(409);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(400);
					annotationArg();
					setState(405);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(401);
						match(COMMA);
						setState(402);
						annotationArg();
						}
						}
						setState(407);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(408);
					value(0);
					}
					break;
				}
				setState(411);
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
			setState(414);
			idPart();
			setState(415);
			match(ASSIGN);
			setState(416);
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
			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(419);
				annotation();
				}
				}
				setState(424);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(425);
			rawType();
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(426);
				genericTypeUses();
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(440);
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
					setState(429);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(433);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AT) {
						{
						{
						setState(430);
						annotation();
						}
						}
						setState(435);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(436);
					match(LSQUAR);
					setState(437);
					match(RSQUAR);
					}
					} 
				}
				setState(442);
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
			setState(443);
			match(LESSER);
			setState(444);
			genericTypeUse();
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(445);
				match(COMMA);
				setState(446);
				genericTypeUse();
				}
				}
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(452);
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
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(454);
				match(QUESTION);
				setState(455);
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

			setState(458);
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
		public TerminalNode INT() { return getToken(CyclicLangParser.INT, 0); }
		public TerminalNode DEC() { return getToken(CyclicLangParser.DEC, 0); }
		public TerminalNode DOUBLE() { return getToken(CyclicLangParser.DOUBLE, 0); }
		public TerminalNode BYTE() { return getToken(CyclicLangParser.BYTE, 0); }
		public TerminalNode BOOL() { return getToken(CyclicLangParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(CyclicLangParser.VOID, 0); }
		public TerminalNode VAR() { return getToken(CyclicLangParser.VAR, 0); }
		public TerminalNode VAL() { return getToken(CyclicLangParser.VAL, 0); }
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
			setState(469);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(460);
				match(INT);
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(461);
				match(DEC);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(462);
				match(DOUBLE);
				}
				break;
			case BYTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(463);
				match(BYTE);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(464);
				match(BOOL);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 6);
				{
				setState(465);
				match(VOID);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 7);
				{
				setState(466);
				match(VAR);
				}
				break;
			case VAL:
				enterOuterAlt(_localctx, 8);
				{
				setState(467);
				match(VAL);
				}
				break;
			case ANNOTATION:
			case IN:
			case OUT:
			case SEALED:
			case PERMITS:
			case ID:
				enterOuterAlt(_localctx, 9);
				{
				setState(468);
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
		enterRule(_localctx, 58, RULE_modifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(471);
					modifier();
					}
					} 
				}
				setState(476);
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

	public final ValueContext value() throws RecognitionException {
		return value(0);
	}

	private ValueContext value(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueContext _localctx = new ValueContext(_ctx, _parentState);
		ValueContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_value, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				_localctx = new FunctionValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(478);
				call();
				}
				break;
			case 2:
				{
				_localctx = new FunctionValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(479);
				match(SUPER);
				setState(480);
				match(DOT);
				setState(481);
				call();
				}
				break;
			case 3:
				{
				_localctx = new DoValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(482);
				match(DO);
				setState(483);
				statement();
				}
				break;
			case 4:
				{
				_localctx = new InitialisationValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(484);
				initialisation();
				}
				break;
			case 5:
				{
				_localctx = new ParenValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(485);
				match(LPAREN);
				setState(486);
				value(0);
				setState(487);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new InlineDeclerationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(489);
				varDecl();
				}
				break;
			case 7:
				{
				_localctx = new SwitchValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(490);
				switchStatement();
				}
				break;
			case 8:
				{
				_localctx = new ClassValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(491);
				id();
				setState(492);
				match(DOT);
				setState(493);
				match(CLASS);
				}
				break;
			case 9:
				{
				_localctx = new CastValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(495);
				cast();
				}
				break;
			case 10:
				{
				_localctx = new UnaryOpValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(496);
				unaryop();
				setState(497);
				value(10);
				}
				break;
			case 11:
				{
				_localctx = new NewArrayValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(499);
				newArray();
				}
				break;
			case 12:
				{
				_localctx = new NewListedArrayValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(500);
				newListedArray();
				}
				break;
			case 13:
				{
				_localctx = new ThisValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(501);
				match(THIS);
				}
				break;
			case 14:
				{
				_localctx = new DecLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(502);
				match(DECLIT);
				}
				break;
			case 15:
				{
				_localctx = new IntLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(503);
				match(INTLIT);
				}
				break;
			case 16:
				{
				_localctx = new StrLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(504);
				match(STRLIT);
				}
				break;
			case 17:
				{
				_localctx = new BoolLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(505);
				match(BOOLLIT);
				}
				break;
			case 18:
				{
				_localctx = new NullLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(506);
				match(NULL);
				}
				break;
			case 19:
				{
				_localctx = new VarValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(507);
				idPart();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(533);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(531);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOpValueContext(new ValueContext(_parentctx, _parentState));
						((BinaryOpValueContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(510);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(511);
						binaryop();
						setState(512);
						((BinaryOpValueContext)_localctx).right = value(25);
						}
						break;
					case 2:
						{
						_localctx = new FunctionValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(514);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(515);
						match(DOT);
						setState(516);
						call();
						}
						break;
					case 3:
						{
						_localctx = new InstanceCheckValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(517);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(519);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==EXCLAMATION) {
							{
							setState(518);
							match(EXCLAMATION);
							}
						}

						setState(521);
						match(INSTANCEOF);
						setState(522);
						type(0);
						}
						break;
					case 4:
						{
						_localctx = new ArrayIndexValueContext(new ValueContext(_parentctx, _parentState));
						((ArrayIndexValueContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(523);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(524);
						match(LSQUAR);
						setState(525);
						((ArrayIndexValueContext)_localctx).index = value(0);
						setState(526);
						match(RSQUAR);
						}
						break;
					case 5:
						{
						_localctx = new VarValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(528);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(529);
						match(DOT);
						setState(530);
						idPart();
						}
						break;
					}
					} 
				}
				setState(535);
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
		enterRule(_localctx, 62, RULE_initialisation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			match(NEW);
			setState(537);
			type(0);
			setState(538);
			match(LPAREN);
			setState(539);
			arguments();
			setState(540);
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
		enterRule(_localctx, 64, RULE_cast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			match(LPAREN);
			setState(543);
			type(0);
			setState(544);
			match(RPAREN);
			setState(545);
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
		enterRule(_localctx, 66, RULE_varAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			value(0);
			setState(549);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(548);
				binaryop();
				}
				break;
			}
			setState(551);
			match(ASSIGN);
			setState(552);
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
		enterRule(_localctx, 68, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			idPart();
			setState(555);
			match(LPAREN);
			setState(556);
			arguments();
			setState(557);
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
		enterRule(_localctx, 70, RULE_ctorCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			_la = _input.LA(1);
			if ( !(_la==THIS || _la==SUPER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(560);
			match(LPAREN);
			setState(561);
			arguments();
			setState(562);
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
		enterRule(_localctx, 72, RULE_newArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			match(NEW);
			setState(565);
			type(0);
			setState(566);
			match(LSQUAR);
			setState(567);
			value(0);
			setState(568);
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
		enterRule(_localctx, 74, RULE_newListedArray);
		int _la;
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
			match(RSQUAR);
			setState(574);
			match(LBRACE);
			setState(583);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << ANNOTATION) | (1L << THIS) | (1L << SUPER) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (LPAREN - 72)) | (1L << (EXCLAMATION - 72)) | (1L << (INT - 72)) | (1L << (DEC - 72)) | (1L << (DOUBLE - 72)) | (1L << (BYTE - 72)) | (1L << (BOOL - 72)) | (1L << (VOID - 72)) | (1L << (VAR - 72)) | (1L << (VAL - 72)) | (1L << (ID - 72)))) != 0)) {
				{
				setState(575);
				value(0);
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(576);
					match(COMMA);
					setState(577);
					value(0);
					}
					}
					setState(582);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(585);
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
		enterRule(_localctx, 76, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << ANNOTATION) | (1L << THIS) | (1L << SUPER) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (LPAREN - 72)) | (1L << (EXCLAMATION - 72)) | (1L << (INT - 72)) | (1L << (DEC - 72)) | (1L << (DOUBLE - 72)) | (1L << (BYTE - 72)) | (1L << (BOOL - 72)) | (1L << (VOID - 72)) | (1L << (VAR - 72)) | (1L << (VAL - 72)) | (1L << (ID - 72)))) != 0)) {
				{
				setState(587);
				value(0);
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(588);
					match(COMMA);
					setState(589);
					value(0);
					}
					}
					setState(594);
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
		enterRule(_localctx, 78, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			match(RETURN);
			setState(599);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << ANNOTATION) | (1L << THIS) | (1L << SUPER) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (LPAREN - 72)) | (1L << (EXCLAMATION - 72)) | (1L << (INT - 72)) | (1L << (DEC - 72)) | (1L << (DOUBLE - 72)) | (1L << (BYTE - 72)) | (1L << (BOOL - 72)) | (1L << (VOID - 72)) | (1L << (VAR - 72)) | (1L << (VAL - 72)) | (1L << (ID - 72)))) != 0)) {
				{
				setState(598);
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
		enterRule(_localctx, 80, RULE_assertStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			match(ASSERT);
			setState(602);
			value(0);
			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(603);
				match(COLON);
				setState(604);
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
		enterRule(_localctx, 82, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			match(THROW);
			setState(608);
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
		enterRule(_localctx, 84, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			match(IF);
			setState(611);
			match(LPAREN);
			setState(612);
			value(0);
			setState(613);
			match(RPAREN);
			setState(614);
			statement();
			setState(616);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(615);
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
		enterRule(_localctx, 86, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618);
			match(ELSE);
			setState(619);
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
		enterRule(_localctx, 88, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			match(WHILE);
			setState(622);
			match(LPAREN);
			setState(623);
			value(0);
			setState(624);
			match(RPAREN);
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
		enterRule(_localctx, 90, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			match(FOR);
			setState(628);
			match(LPAREN);
			setState(630);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(629);
				((ForStatementContext)_localctx).start = statement();
				}
				break;
			}
			setState(632);
			((ForStatementContext)_localctx).cond = value(0);
			setState(633);
			match(SEMICOLON);
			setState(635);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << RETURN) | (1L << ASSERT) | (1L << NEW) | (1L << THROW) | (1L << ANNOTATION) | (1L << THIS) | (1L << SUPER) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << WHILE) | (1L << YIELD) | (1L << FOR) | (1L << DO) | (1L << IF) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LBRACE - 70)) | (1L << (LPAREN - 70)) | (1L << (SEMICOLON - 70)) | (1L << (EXCLAMATION - 70)) | (1L << (INT - 70)) | (1L << (DEC - 70)) | (1L << (DOUBLE - 70)) | (1L << (BYTE - 70)) | (1L << (BOOL - 70)) | (1L << (VOID - 70)) | (1L << (VAR - 70)) | (1L << (VAL - 70)) | (1L << (ID - 70)))) != 0)) {
				{
				setState(634);
				((ForStatementContext)_localctx).end = statement();
				}
			}

			setState(637);
			match(RPAREN);
			setState(638);
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
		enterRule(_localctx, 92, RULE_foreachStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			match(FOR);
			setState(641);
			match(LPAREN);
			setState(642);
			type(0);
			setState(643);
			idPart();
			setState(644);
			match(COLON);
			setState(645);
			value(0);
			setState(646);
			match(RPAREN);
			setState(647);
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
		enterRule(_localctx, 94, RULE_doWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			match(DO);
			setState(650);
			statement();
			setState(651);
			match(WHILE);
			setState(652);
			match(LPAREN);
			setState(653);
			value(0);
			setState(654);
			match(RPAREN);
			setState(655);
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
		enterRule(_localctx, 96, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			match(SWITCH);
			setState(658);
			match(LPAREN);
			setState(659);
			value(0);
			setState(660);
			match(RPAREN);
			setState(661);
			match(LBRACE);
			setState(665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(662);
				caseClause();
				}
				}
				setState(667);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(668);
				defaultClause();
				}
			}

			setState(671);
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
		enterRule(_localctx, 98, RULE_caseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
			match(CASE);
			setState(674);
			value(0);
			setState(675);
			match(DASHARROW);
			setState(680);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(676);
				statement();
				}
				break;
			case 2:
				{
				setState(677);
				value(0);
				setState(678);
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
		enterRule(_localctx, 100, RULE_defaultClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			match(DEFAULT);
			setState(683);
			match(DASHARROW);
			setState(688);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(684);
				statement();
				}
				break;
			case 2:
				{
				setState(685);
				value(0);
				setState(686);
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
		enterRule(_localctx, 102, RULE_yieldStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			match(YIELD);
			setState(691);
			value(0);
			setState(692);
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
		enterRule(_localctx, 104, RULE_binaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
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
		enterRule(_localctx, 106, RULE_unaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
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
		enterRule(_localctx, 108, RULE_id);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
			idPart();
			setState(703);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(699);
					match(DOT);
					setState(700);
					idPart();
					}
					} 
				}
				setState(705);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
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
		enterRule(_localctx, 110, RULE_idPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
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
		enterRule(_localctx, 112, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
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
		case 30:
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
			return precpred(_ctx, 24);
		case 2:
			return precpred(_ctx, 23);
		case 3:
			return precpred(_ctx, 20);
		case 4:
			return precpred(_ctx, 19);
		case 5:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3g\u02c9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\5\2v\n\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\7\4\u0081\n\4\f\4\16\4\u0084\13\4\3\5\3"+
		"\5\5\5\u0088\n\5\3\5\3\5\3\5\5\5\u008d\n\5\3\5\3\5\3\6\7\6\u0092\n\6\f"+
		"\6\16\6\u0095\13\6\3\6\3\6\3\6\3\6\5\6\u009b\n\6\3\6\5\6\u009e\n\6\3\6"+
		"\5\6\u00a1\n\6\3\6\5\6\u00a4\n\6\3\6\5\6\u00a7\n\6\3\6\3\6\7\6\u00ab\n"+
		"\6\f\6\16\6\u00ae\13\6\3\6\3\6\5\6\u00b2\n\6\3\7\3\7\3\7\3\7\7\7\u00b8"+
		"\n\7\f\7\16\7\u00bb\13\7\3\b\3\b\3\b\3\b\7\b\u00c1\n\b\f\b\16\b\u00c4"+
		"\13\b\3\t\3\t\3\t\3\t\7\t\u00ca\n\t\f\t\16\t\u00cd\13\t\3\n\3\n\3\n\3"+
		"\n\7\n\u00d3\n\n\f\n\16\n\u00d6\13\n\3\n\3\n\3\13\5\13\u00db\n\13\3\13"+
		"\5\13\u00de\n\13\3\13\3\13\3\13\5\13\u00e3\n\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u00ed\n\f\3\r\3\r\3\r\3\r\7\r\u00f3\n\r\f\r\16\r\u00f6"+
		"\13\r\5\r\u00f8\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u0104\n\16\3\17\7\17\u0107\n\17\f\17\16\17\u010a\13\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0115\n\17\3\20\5\20\u0118\n\20"+
		"\3\20\3\20\3\21\7\21\u011d\n\21\f\21\16\21\u0120\13\21\3\21\3\21\5\21"+
		"\u0124\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u012d\n\21\3\22\3"+
		"\22\5\22\u0131\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u0138\n\23\3\24\7\24"+
		"\u013b\n\24\f\24\16\24\u013e\13\24\3\24\3\24\3\24\3\24\3\24\5\24\u0145"+
		"\n\24\3\25\5\25\u0148\n\25\3\25\3\25\5\25\u014c\n\25\3\25\3\25\3\25\5"+
		"\25\u0151\n\25\3\26\3\26\3\26\7\26\u0156\n\26\f\26\16\26\u0159\13\26\5"+
		"\26\u015b\n\26\3\27\3\27\7\27\u015f\n\27\f\27\16\27\u0162\13\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u0182\n\30\3\30\5\30\u0185\n\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u018e\n\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0196\n\31\f"+
		"\31\16\31\u0199\13\31\3\31\5\31\u019c\n\31\3\31\5\31\u019f\n\31\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\7\33\u01a7\n\33\f\33\16\33\u01aa\13\33\3\33\3"+
		"\33\5\33\u01ae\n\33\3\33\3\33\7\33\u01b2\n\33\f\33\16\33\u01b5\13\33\3"+
		"\33\3\33\7\33\u01b9\n\33\f\33\16\33\u01bc\13\33\3\34\3\34\3\34\3\34\7"+
		"\34\u01c2\n\34\f\34\16\34\u01c5\13\34\3\34\3\34\3\35\3\35\5\35\u01cb\n"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u01d8"+
		"\n\36\3\37\7\37\u01db\n\37\f\37\16\37\u01de\13\37\3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \5 \u01ff\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u020a\n \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \7 \u0216\n \f \16 \u0219\13 \3!\3!\3!\3!\3!\3!\3\"\3"+
		"\"\3\"\3\"\3\"\3#\3#\5#\u0228\n#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3"+
		"%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0245\n\'\f\'"+
		"\16\'\u0248\13\'\5\'\u024a\n\'\3\'\3\'\3(\3(\3(\7(\u0251\n(\f(\16(\u0254"+
		"\13(\5(\u0256\n(\3)\3)\5)\u025a\n)\3*\3*\3*\3*\5*\u0260\n*\3+\3+\3+\3"+
		",\3,\3,\3,\3,\3,\5,\u026b\n,\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3/\5/\u0279"+
		"\n/\3/\3/\3/\5/\u027e\n/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\7\62\u029a\n\62\f\62\16\62\u029d\13\62\3\62\5\62\u02a0\n\62\3"+
		"\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u02ab\n\63\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\5\64\u02b3\n\64\3\65\3\65\3\65\3\65\3\66\3\66\3\67"+
		"\3\67\38\38\38\78\u02c0\n8\f8\168\u02c3\138\39\39\3:\3:\3:\2\4\64>;\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"+
		"NPRTVXZ\\^`bdfhjlnpr\2\t\3\2\36\37\4\2\32\32\35\35\3\2\34\35\4\2\61:<"+
		"G\4\289SS\5\2\27\27\36!bb\5\2\3\f  \"\"\2\u030c\2u\3\2\2\2\4{\3\2\2\2"+
		"\6\u0082\3\2\2\2\b\u0085\3\2\2\2\n\u0093\3\2\2\2\f\u00b3\3\2\2\2\16\u00bc"+
		"\3\2\2\2\20\u00c5\3\2\2\2\22\u00ce\3\2\2\2\24\u00da\3\2\2\2\26\u00ec\3"+
		"\2\2\2\30\u00ee\3\2\2\2\32\u0103\3\2\2\2\34\u0108\3\2\2\2\36\u0117\3\2"+
		"\2\2 \u011e\3\2\2\2\"\u0130\3\2\2\2$\u0132\3\2\2\2&\u013c\3\2\2\2(\u0147"+
		"\3\2\2\2*\u015a\3\2\2\2,\u015c\3\2\2\2.\u018d\3\2\2\2\60\u018f\3\2\2\2"+
		"\62\u01a0\3\2\2\2\64\u01a4\3\2\2\2\66\u01bd\3\2\2\28\u01ca\3\2\2\2:\u01d7"+
		"\3\2\2\2<\u01dc\3\2\2\2>\u01fe\3\2\2\2@\u021a\3\2\2\2B\u0220\3\2\2\2D"+
		"\u0225\3\2\2\2F\u022c\3\2\2\2H\u0231\3\2\2\2J\u0236\3\2\2\2L\u023c\3\2"+
		"\2\2N\u0255\3\2\2\2P\u0257\3\2\2\2R\u025b\3\2\2\2T\u0261\3\2\2\2V\u0264"+
		"\3\2\2\2X\u026c\3\2\2\2Z\u026f\3\2\2\2\\\u0275\3\2\2\2^\u0282\3\2\2\2"+
		"`\u028b\3\2\2\2b\u0293\3\2\2\2d\u02a3\3\2\2\2f\u02ac\3\2\2\2h\u02b4\3"+
		"\2\2\2j\u02b8\3\2\2\2l\u02ba\3\2\2\2n\u02bc\3\2\2\2p\u02c4\3\2\2\2r\u02c6"+
		"\3\2\2\2tv\5\4\3\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\5\6\4\2xy\5\n\6\2y"+
		"z\7\2\2\3z\3\3\2\2\2{|\7\31\2\2|}\5n8\2}~\7O\2\2~\5\3\2\2\2\177\u0081"+
		"\5\b\5\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\7\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0087\7\30\2"+
		"\2\u0086\u0088\7\t\2\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\u008c\5n8\2\u008a\u008b\7Q\2\2\u008b\u008d\7\66\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7O"+
		"\2\2\u008f\t\3\2\2\2\u0090\u0092\5\60\31\2\u0091\u0090\3\2\2\2\u0092\u0095"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0096\u0097\5<\37\2\u0097\u0098\5\26\f\2\u0098\u009a\5"+
		"p9\2\u0099\u009b\5\22\n\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009d\3\2\2\2\u009c\u009e\5\30\r\2\u009d\u009c\3\2\2\2\u009d\u009e\3"+
		"\2\2\2\u009e\u00a0\3\2\2\2\u009f\u00a1\5\f\7\2\u00a0\u009f\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a4\5\16\b\2\u00a3\u00a2\3"+
		"\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a7\5\20\t\2\u00a6"+
		"\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00b1\3\2\2\2\u00a8\u00ac\7H"+
		"\2\2\u00a9\u00ab\5\32\16\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00af\u00b2\7I\2\2\u00b0\u00b2\7O\2\2\u00b1\u00a8\3\2\2\2\u00b1\u00b0"+
		"\3\2\2\2\u00b2\13\3\2\2\2\u00b3\u00b4\7\32\2\2\u00b4\u00b9\5\64\33\2\u00b5"+
		"\u00b6\7R\2\2\u00b6\u00b8\5\64\33\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\3"+
		"\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\r\3\2\2\2\u00bb\u00b9"+
		"\3\2\2\2\u00bc\u00bd\7\33\2\2\u00bd\u00c2\5\64\33\2\u00be\u00bf\7R\2\2"+
		"\u00bf\u00c1\5\64\33\2\u00c0\u00be\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\17\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5"+
		"\u00c6\7!\2\2\u00c6\u00cb\5\64\33\2\u00c7\u00c8\7R\2\2\u00c8\u00ca\5\64"+
		"\33\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\21\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\7E\2\2"+
		"\u00cf\u00d4\5\24\13\2\u00d0\u00d1\7R\2\2\u00d1\u00d3\5\24\13\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7D\2\2\u00d8"+
		"\23\3\2\2\2\u00d9\u00db\t\2\2\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2"+
		"\2\u00db\u00dd\3\2\2\2\u00dc\u00de\7\22\2\2\u00dd\u00dc\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e2\5\64\33\2\u00e0\u00e1\7"+
		"\32\2\2\u00e1\u00e3\5\64\33\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2"+
		"\u00e3\25\3\2\2\2\u00e4\u00ed\7\22\2\2\u00e5\u00ed\7\23\2\2\u00e6\u00ed"+
		"\7\24\2\2\u00e7\u00e8\7;\2\2\u00e8\u00ed\7\23\2\2\u00e9\u00ed\7\27\2\2"+
		"\u00ea\u00ed\7\25\2\2\u00eb\u00ed\7\26\2\2\u00ec\u00e4\3\2\2\2\u00ec\u00e5"+
		"\3\2\2\2\u00ec\u00e6\3\2\2\2\u00ec\u00e7\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\27\3\2\2\2\u00ee\u00f7\7J\2\2"+
		"\u00ef\u00f4\5(\25\2\u00f0\u00f1\7R\2\2\u00f1\u00f3\5(\25\2\u00f2\u00f0"+
		"\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00ef\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\7K\2\2\u00fa\31\3\2\2\2\u00fb\u0104"+
		"\5 \21\2\u00fc\u0104\5\34\17\2\u00fd\u00fe\5&\24\2\u00fe\u00ff\7O\2\2"+
		"\u00ff\u0104\3\2\2\2\u0100\u0104\5\n\6\2\u0101\u0104\5\36\20\2\u0102\u0104"+
		"\7O\2\2\u0103\u00fb\3\2\2\2\u0103\u00fc\3\2\2\2\u0103\u00fd\3\2\2\2\u0103"+
		"\u0100\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104\33\3\2\2"+
		"\2\u0105\u0107\5\60\31\2\u0106\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010b\u010c\5<\37\2\u010c\u010d\5\64\33\2\u010d\u010e\7J\2\2\u010e"+
		"\u010f\5*\26\2\u010f\u0114\7K\2\2\u0110\u0115\5,\27\2\u0111\u0115\7O\2"+
		"\2\u0112\u0113\7V\2\2\u0113\u0115\5.\30\2\u0114\u0110\3\2\2\2\u0114\u0111"+
		"\3\2\2\2\u0114\u0112\3\2\2\2\u0115\35\3\2\2\2\u0116\u0118\7\t\2\2\u0117"+
		"\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\5,"+
		"\27\2\u011a\37\3\2\2\2\u011b\u011d\5\60\31\2\u011c\u011b\3\2\2\2\u011d"+
		"\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2"+
		"\2\2\u0120\u011e\3\2\2\2\u0121\u0123\5<\37\2\u0122\u0124\5\22\n\2\u0123"+
		"\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\5\64"+
		"\33\2\u0126\u0127\5p9\2\u0127\u0128\7J\2\2\u0128\u0129\5*\26\2\u0129\u012c"+
		"\7K\2\2\u012a\u012d\5\"\22\2\u012b\u012d\5$\23\2\u012c\u012a\3\2\2\2\u012c"+
		"\u012b\3\2\2\2\u012d!\3\2\2\2\u012e\u0131\5,\27\2\u012f\u0131\7O\2\2\u0130"+
		"\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u0131#\3\2\2\2\u0132\u0137\7V\2\2\u0133"+
		"\u0134\5> \2\u0134\u0135\7O\2\2\u0135\u0138\3\2\2\2\u0136\u0138\5.\30"+
		"\2\u0137\u0133\3\2\2\2\u0137\u0136\3\2\2\2\u0138%\3\2\2\2\u0139\u013b"+
		"\5\60\31\2\u013a\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2"+
		"\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140"+
		"\5<\37\2\u0140\u0141\5\64\33\2\u0141\u0144\5p9\2\u0142\u0143\7F\2\2\u0143"+
		"\u0145\5> \2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\'\3\2\2\2\u0146"+
		"\u0148\7\n\2\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2"+
		"\2\2\u0149\u014b\5\64\33\2\u014a\u014c\7U\2\2\u014b\u014a\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u0150\5p9\2\u014e\u014f\7F\2"+
		"\2\u014f\u0151\5> \2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151)\3"+
		"\2\2\2\u0152\u0157\5(\25\2\u0153\u0154\7R\2\2\u0154\u0156\5(\25\2\u0155"+
		"\u0153\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2"+
		"\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u0152\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b+\3\2\2\2\u015c\u0160\7H\2\2\u015d\u015f\5.\30\2\u015e"+
		"\u015d\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2"+
		"\2\2\u0161\u0163\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0164\7I\2\2\u0164"+
		"-\3\2\2\2\u0165\u018e\5,\27\2\u0166\u0167\5P)\2\u0167\u0168\7O\2\2\u0168"+
		"\u018e\3\2\2\2\u0169\u016a\5R*\2\u016a\u016b\7O\2\2\u016b\u018e\3\2\2"+
		"\2\u016c\u016d\5T+\2\u016d\u016e\7O\2\2\u016e\u018e\3\2\2\2\u016f\u0170"+
		"\5&\24\2\u0170\u0171\7O\2\2\u0171\u018e\3\2\2\2\u0172\u0173\5D#\2\u0173"+
		"\u0174\7O\2\2\u0174\u018e\3\2\2\2\u0175\u0176\5@!\2\u0176\u0177\7O\2\2"+
		"\u0177\u018e\3\2\2\2\u0178\u018e\5V,\2\u0179\u018e\5Z.\2\u017a\u018e\5"+
		"\\/\2\u017b\u018e\5^\60\2\u017c\u018e\5b\62\2\u017d\u018e\5`\61\2\u017e"+
		"\u018e\5h\65\2\u017f\u0182\5> \2\u0180\u0182\7\35\2\2\u0181\u017f\3\2"+
		"\2\2\u0181\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0185\7Q\2\2\u0184"+
		"\u0181\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\5F"+
		"$\2\u0187\u0188\7O\2\2\u0188\u018e\3\2\2\2\u0189\u018a\5H%\2\u018a\u018b"+
		"\7O\2\2\u018b\u018e\3\2\2\2\u018c\u018e\7O\2\2\u018d\u0165\3\2\2\2\u018d"+
		"\u0166\3\2\2\2\u018d\u0169\3\2\2\2\u018d\u016c\3\2\2\2\u018d\u016f\3\2"+
		"\2\2\u018d\u0172\3\2\2\2\u018d\u0175\3\2\2\2\u018d\u0178\3\2\2\2\u018d"+
		"\u0179\3\2\2\2\u018d\u017a\3\2\2\2\u018d\u017b\3\2\2\2\u018d\u017c\3\2"+
		"\2\2\u018d\u017d\3\2\2\2\u018d\u017e\3\2\2\2\u018d\u0184\3\2\2\2\u018d"+
		"\u0189\3\2\2\2\u018d\u018c\3\2\2\2\u018e/\3\2\2\2\u018f\u0190\7;\2\2\u0190"+
		"\u019e\5n8\2\u0191\u019b\7J\2\2\u0192\u0197\5\62\32\2\u0193\u0194\7R\2"+
		"\2\u0194\u0196\5\62\32\2\u0195\u0193\3\2\2\2\u0196\u0199\3\2\2\2\u0197"+
		"\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u019c\3\2\2\2\u0199\u0197\3\2"+
		"\2\2\u019a\u019c\5> \2\u019b\u0192\3\2\2\2\u019b\u019a\3\2\2\2\u019b\u019c"+
		"\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019f\7K\2\2\u019e\u0191\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019f\61\3\2\2\2\u01a0\u01a1\5p9\2\u01a1\u01a2\7F\2\2\u01a2"+
		"\u01a3\5> \2\u01a3\63\3\2\2\2\u01a4\u01a8\b\33\1\2\u01a5\u01a7\5\60\31"+
		"\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9"+
		"\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ad\5:\36\2\u01ac"+
		"\u01ae\5\66\34\2\u01ad\u01ac\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01ba\3"+
		"\2\2\2\u01af\u01b3\f\3\2\2\u01b0\u01b2\5\60\31\2\u01b1\u01b0\3\2\2\2\u01b2"+
		"\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b6\3\2"+
		"\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b7\7L\2\2\u01b7\u01b9\7M\2\2\u01b8\u01af"+
		"\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"\65\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01be\7E\2\2\u01be\u01c3\58\35\2"+
		"\u01bf\u01c0\7R\2\2\u01c0\u01c2\58\35\2\u01c1\u01bf\3\2\2\2\u01c2\u01c5"+
		"\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5"+
		"\u01c3\3\2\2\2\u01c6\u01c7\7D\2\2\u01c7\67\3\2\2\2\u01c8\u01c9\7T\2\2"+
		"\u01c9\u01cb\t\3\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cc"+
		"\3\2\2\2\u01cc\u01cd\5\64\33\2\u01cd9\3\2\2\2\u01ce\u01d8\7X\2\2\u01cf"+
		"\u01d8\7Y\2\2\u01d0\u01d8\7Z\2\2\u01d1\u01d8\7[\2\2\u01d2\u01d8\7\\\2"+
		"\2\u01d3\u01d8\7]\2\2\u01d4\u01d8\7^\2\2\u01d5\u01d8\7_\2\2\u01d6\u01d8"+
		"\5n8\2\u01d7\u01ce\3\2\2\2\u01d7\u01cf\3\2\2\2\u01d7\u01d0\3\2\2\2\u01d7"+
		"\u01d1\3\2\2\2\u01d7\u01d2\3\2\2\2\u01d7\u01d3\3\2\2\2\u01d7\u01d4\3\2"+
		"\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d6\3\2\2\2\u01d8;\3\2\2\2\u01d9\u01db"+
		"\5r:\2\u01da\u01d9\3\2\2\2\u01db\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc"+
		"\u01dd\3\2\2\2\u01dd=\3\2\2\2\u01de\u01dc\3\2\2\2\u01df\u01e0\b \1\2\u01e0"+
		"\u01ff\5F$\2\u01e1\u01e2\7\35\2\2\u01e2\u01e3\7Q\2\2\u01e3\u01ff\5F$\2"+
		"\u01e4\u01e5\7*\2\2\u01e5\u01ff\5.\30\2\u01e6\u01ff\5@!\2\u01e7\u01e8"+
		"\7J\2\2\u01e8\u01e9\5> \2\u01e9\u01ea\7K\2\2\u01ea\u01ff\3\2\2\2\u01eb"+
		"\u01ff\5&\24\2\u01ec\u01ff\5b\62\2\u01ed\u01ee\5n8\2\u01ee\u01ef\7Q\2"+
		"\2\u01ef\u01f0\7\22\2\2\u01f0\u01ff\3\2\2\2\u01f1\u01ff\5B\"\2\u01f2\u01f3"+
		"\5l\67\2\u01f3\u01f4\5> \f\u01f4\u01ff\3\2\2\2\u01f5\u01ff\5J&\2\u01f6"+
		"\u01ff\5L\'\2\u01f7\u01ff\7\34\2\2\u01f8\u01ff\7,\2\2\u01f9\u01ff\7-\2"+
		"\2\u01fa\u01ff\7.\2\2\u01fb\u01ff\7/\2\2\u01fc\u01ff\7\60\2\2\u01fd\u01ff"+
		"\5p9\2\u01fe\u01df\3\2\2\2\u01fe\u01e1\3\2\2\2\u01fe\u01e4\3\2\2\2\u01fe"+
		"\u01e6\3\2\2\2\u01fe\u01e7\3\2\2\2\u01fe\u01eb\3\2\2\2\u01fe\u01ec\3\2"+
		"\2\2\u01fe\u01ed\3\2\2\2\u01fe\u01f1\3\2\2\2\u01fe\u01f2\3\2\2\2\u01fe"+
		"\u01f5\3\2\2\2\u01fe\u01f6\3\2\2\2\u01fe\u01f7\3\2\2\2\u01fe\u01f8\3\2"+
		"\2\2\u01fe\u01f9\3\2\2\2\u01fe\u01fa\3\2\2\2\u01fe\u01fb\3\2\2\2\u01fe"+
		"\u01fc\3\2\2\2\u01fe\u01fd\3\2\2\2\u01ff\u0217\3\2\2\2\u0200\u0201\f\32"+
		"\2\2\u0201\u0202\5j\66\2\u0202\u0203\5> \33\u0203\u0216\3\2\2\2\u0204"+
		"\u0205\f\31\2\2\u0205\u0206\7Q\2\2\u0206\u0216\5F$\2\u0207\u0209\f\26"+
		"\2\2\u0208\u020a\7S\2\2\u0209\u0208\3\2\2\2\u0209\u020a\3\2\2\2\u020a"+
		"\u020b\3\2\2\2\u020b\u020c\7\r\2\2\u020c\u0216\5\64\33\2\u020d\u020e\f"+
		"\25\2\2\u020e\u020f\7L\2\2\u020f\u0210\5> \2\u0210\u0211\7M\2\2\u0211"+
		"\u0216\3\2\2\2\u0212\u0213\f\24\2\2\u0213\u0214\7Q\2\2\u0214\u0216\5p"+
		"9\2\u0215\u0200\3\2\2\2\u0215\u0204\3\2\2\2\u0215\u0207\3\2\2\2\u0215"+
		"\u020d\3\2\2\2\u0215\u0212\3\2\2\2\u0216\u0219\3\2\2\2\u0217\u0215\3\2"+
		"\2\2\u0217\u0218\3\2\2\2\u0218?\3\2\2\2\u0219\u0217\3\2\2\2\u021a\u021b"+
		"\7\20\2\2\u021b\u021c\5\64\33\2\u021c\u021d\7J\2\2\u021d\u021e\5N(\2\u021e"+
		"\u021f\7K\2\2\u021fA\3\2\2\2\u0220\u0221\7J\2\2\u0221\u0222\5\64\33\2"+
		"\u0222\u0223\7K\2\2\u0223\u0224\5> \2\u0224C\3\2\2\2\u0225\u0227\5> \2"+
		"\u0226\u0228\5j\66\2\u0227\u0226\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u0229"+
		"\3\2\2\2\u0229\u022a\7F\2\2\u022a\u022b\5> \2\u022bE\3\2\2\2\u022c\u022d"+
		"\5p9\2\u022d\u022e\7J\2\2\u022e\u022f\5N(\2\u022f\u0230\7K\2\2\u0230G"+
		"\3\2\2\2\u0231\u0232\t\4\2\2\u0232\u0233\7J\2\2\u0233\u0234\5N(\2\u0234"+
		"\u0235\7K\2\2\u0235I\3\2\2\2\u0236\u0237\7\20\2\2\u0237\u0238\5\64\33"+
		"\2\u0238\u0239\7L\2\2\u0239\u023a\5> \2\u023a\u023b\7M\2\2\u023bK\3\2"+
		"\2\2\u023c\u023d\7\20\2\2\u023d\u023e\5\64\33\2\u023e\u023f\7L\2\2\u023f"+
		"\u0240\7M\2\2\u0240\u0249\7H\2\2\u0241\u0246\5> \2\u0242\u0243\7R\2\2"+
		"\u0243\u0245\5> \2\u0244\u0242\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0244"+
		"\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0249"+
		"\u0241\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024c\7I"+
		"\2\2\u024cM\3\2\2\2\u024d\u0252\5> \2\u024e\u024f\7R\2\2\u024f\u0251\5"+
		"> \2\u0250\u024e\3\2\2\2\u0251\u0254\3\2\2\2\u0252\u0250\3\2\2\2\u0252"+
		"\u0253\3\2\2\2\u0253\u0256\3\2\2\2\u0254\u0252\3\2\2\2\u0255\u024d\3\2"+
		"\2\2\u0255\u0256\3\2\2\2\u0256O\3\2\2\2\u0257\u0259\7\16\2\2\u0258\u025a"+
		"\5> \2\u0259\u0258\3\2\2\2\u0259\u025a\3\2\2\2\u025aQ\3\2\2\2\u025b\u025c"+
		"\7\17\2\2\u025c\u025f\5> \2\u025d\u025e\7N\2\2\u025e\u0260\7.\2\2\u025f"+
		"\u025d\3\2\2\2\u025f\u0260\3\2\2\2\u0260S\3\2\2\2\u0261\u0262\7\21\2\2"+
		"\u0262\u0263\5> \2\u0263U\3\2\2\2\u0264\u0265\7+\2\2\u0265\u0266\7J\2"+
		"\2\u0266\u0267\5> \2\u0267\u0268\7K\2\2\u0268\u026a\5.\30\2\u0269\u026b"+
		"\5X-\2\u026a\u0269\3\2\2\2\u026a\u026b\3\2\2\2\u026bW\3\2\2\2\u026c\u026d"+
		"\7(\2\2\u026d\u026e\5.\30\2\u026eY\3\2\2\2\u026f\u0270\7%\2\2\u0270\u0271"+
		"\7J\2\2\u0271\u0272\5> \2\u0272\u0273\7K\2\2\u0273\u0274\5.\30\2\u0274"+
		"[\3\2\2\2\u0275\u0276\7)\2\2\u0276\u0278\7J\2\2\u0277\u0279\5.\30\2\u0278"+
		"\u0277\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027b\5>"+
		" \2\u027b\u027d\7O\2\2\u027c\u027e\5.\30\2\u027d\u027c\3\2\2\2\u027d\u027e"+
		"\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0280\7K\2\2\u0280\u0281\5.\30\2\u0281"+
		"]\3\2\2\2\u0282\u0283\7)\2\2\u0283\u0284\7J\2\2\u0284\u0285\5\64\33\2"+
		"\u0285\u0286\5p9\2\u0286\u0287\7N\2\2\u0287\u0288\5> \2\u0288\u0289\7"+
		"K\2\2\u0289\u028a\5.\30\2\u028a_\3\2\2\2\u028b\u028c\7*\2\2\u028c\u028d"+
		"\5.\30\2\u028d\u028e\7%\2\2\u028e\u028f\7J\2\2\u028f\u0290\5> \2\u0290"+
		"\u0291\7K\2\2\u0291\u0292\7O\2\2\u0292a\3\2\2\2\u0293\u0294\7$\2\2\u0294"+
		"\u0295\7J\2\2\u0295\u0296\5> \2\u0296\u0297\7K\2\2\u0297\u029b\7H\2\2"+
		"\u0298\u029a\5d\63\2\u0299\u0298\3\2\2\2\u029a\u029d\3\2\2\2\u029b\u0299"+
		"\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029f\3\2\2\2\u029d\u029b\3\2\2\2\u029e"+
		"\u02a0\5f\64\2\u029f\u029e\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\u02a1\3\2"+
		"\2\2\u02a1\u02a2\7I\2\2\u02a2c\3\2\2\2\u02a3\u02a4\7\'\2\2\u02a4\u02a5"+
		"\5> \2\u02a5\u02aa\7V\2\2\u02a6\u02ab\5.\30\2\u02a7\u02a8\5> \2\u02a8"+
		"\u02a9\7O\2\2\u02a9\u02ab\3\2\2\2\u02aa\u02a6\3\2\2\2\u02aa\u02a7\3\2"+
		"\2\2\u02abe\3\2\2\2\u02ac\u02ad\7#\2\2\u02ad\u02b2\7V\2\2\u02ae\u02b3"+
		"\5.\30\2\u02af\u02b0\5> \2\u02b0\u02b1\7O\2\2\u02b1\u02b3\3\2\2\2\u02b2"+
		"\u02ae\3\2\2\2\u02b2\u02af\3\2\2\2\u02b3g\3\2\2\2\u02b4\u02b5\7&\2\2\u02b5"+
		"\u02b6\5> \2\u02b6\u02b7\7O\2\2\u02b7i\3\2\2\2\u02b8\u02b9\t\5\2\2\u02b9"+
		"k\3\2\2\2\u02ba\u02bb\t\6\2\2\u02bbm\3\2\2\2\u02bc\u02c1\5p9\2\u02bd\u02be"+
		"\7Q\2\2\u02be\u02c0\5p9\2\u02bf\u02bd\3\2\2\2\u02c0\u02c3\3\2\2\2\u02c1"+
		"\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2o\3\2\2\2\u02c3\u02c1\3\2\2\2"+
		"\u02c4\u02c5\t\7\2\2\u02c5q\3\2\2\2\u02c6\u02c7\t\b\2\2\u02c7s\3\2\2\2"+
		"Ju\u0082\u0087\u008c\u0093\u009a\u009d\u00a0\u00a3\u00a6\u00ac\u00b1\u00b9"+
		"\u00c2\u00cb\u00d4\u00da\u00dd\u00e2\u00ec\u00f4\u00f7\u0103\u0108\u0114"+
		"\u0117\u011e\u0123\u012c\u0130\u0137\u013c\u0144\u0147\u014b\u0150\u0157"+
		"\u015a\u0160\u0181\u0184\u018d\u0197\u019b\u019e\u01a8\u01ad\u01b3\u01ba"+
		"\u01c3\u01ca\u01d7\u01dc\u01fe\u0209\u0215\u0217\u0227\u0246\u0249\u0252"+
		"\u0255\u0259\u025f\u026a\u0278\u027d\u029b\u029f\u02aa\u02b2\u02c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}