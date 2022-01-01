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
		ASSERT=13, NEW=14, CLASS=15, INTERFACE=16, ENUM=17, RECORD=18, SINGLE=19, 
		ANNOTATION=20, IMPORT=21, PACKAGE=22, EXTENDS=23, IMPLEMENTS=24, THIS=25, 
		SUPER=26, IN=27, OUT=28, SEALED=29, PERMITS=30, NONSEALED=31, DEFAULT=32, 
		SWITCH=33, WHILE=34, YIELD=35, CASE=36, ELSE=37, FOR=38, DO=39, IF=40, 
		DECLIT=41, INTLIT=42, STRLIT=43, BOOLLIT=44, NULL=45, BITAND=46, BITOR=47, 
		AND=48, OR=49, UP=50, STAR=51, SLASH=52, PLUS=53, MINUS=54, PERCENT=55, 
		AT=56, LSHIFT=57, RSHIFT=58, ULSHIFT=59, URSHIFT=60, EQUAL=61, INEQUAL=62, 
		GREATEREQ=63, LESSEREQ=64, GREATER=65, LESSER=66, ASSIGN=67, PASS=68, 
		LBRACE=69, RBRACE=70, LPAREN=71, RPAREN=72, LSQUAR=73, RSQUAR=74, COLON=75, 
		SEMICOLON=76, QUOTE=77, DOT=78, COMMA=79, EXCLAMATION=80, QUESTION=81, 
		ELIPSES=82, DASHARROW=83, EQARROW=84, INT=85, DEC=86, DOUBLE=87, BYTE=88, 
		BOOL=89, VOID=90, VAR=91, VAL=92, TRUE=93, FALSE=94, ID=95, DIGIT=96, 
		NONDIGIT=97, SING_COMMENT=98, WS=99, UNMATCHED=100;
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
		RULE_varAssignment = 33, RULE_call = 34, RULE_newArray = 35, RULE_newListedArray = 36, 
		RULE_arguments = 37, RULE_returnStatement = 38, RULE_assertStatement = 39, 
		RULE_ifStatement = 40, RULE_elseStatement = 41, RULE_whileStatement = 42, 
		RULE_forStatement = 43, RULE_foreachStatement = 44, RULE_doWhile = 45, 
		RULE_switchStatement = 46, RULE_caseClause = 47, RULE_defaultClause = 48, 
		RULE_yieldStatement = 49, RULE_binaryop = 50, RULE_unaryop = 51, RULE_id = 52, 
		RULE_idPart = 53, RULE_modifier = 54;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "packageDecl", "imports", "importDecl", "classDecl", "objectExtends", 
			"objectImplements", "objectPermits", "genericTypeDefs", "genericTypeDef", 
			"objectType", "recordComponents", "member", "constructor", "init", "function", 
			"functionBlock", "functionArrow", "varDecl", "parameter", "parameters", 
			"block", "statement", "annotation", "annotationArg", "type", "genericTypeUses", 
			"genericTypeUse", "rawType", "modifiers", "value", "initialisation", 
			"cast", "varAssignment", "call", "newArray", "newListedArray", "arguments", 
			"returnStatement", "assertStatement", "ifStatement", "elseStatement", 
			"whileStatement", "forStatement", "foreachStatement", "doWhile", "switchStatement", 
			"caseClause", "defaultClause", "yieldStatement", "binaryop", "unaryop", 
			"id", "idPart", "modifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'protected'", "'private'", "'public'", "'synchronised'", "'abstract'", 
			"'native'", "'static'", "'final'", "'strictfp'", "'volatile'", "'instanceof'", 
			"'return'", "'assert'", "'new'", "'class'", "'interface'", "'enum'", 
			"'record'", "'single'", "'annotation'", "'import'", "'package'", "'extends'", 
			"'implements'", "'this'", "'super'", "'in'", "'out'", "'sealed'", "'permits'", 
			"'non-sealed'", "'default'", "'switch'", "'while'", "'yield'", "'case'", 
			"'else'", "'for'", "'do'", "'if'", null, null, null, null, "'null'", 
			"'&'", "'|'", "'&&'", "'||'", "'^'", "'*'", "'/'", "'+'", "'-'", "'%'", 
			"'@'", "'<<'", "'>>'", "'<<<'", "'>>>'", "'=='", "'!='", "'>='", "'<='", 
			"'>'", "'<'", "'='", "'|>'", "'{'", "'}'", "'('", "')'", "'['", "']'", 
			"':'", "';'", "'\"'", "'.'", "','", "'!'", "'?'", "'...'", "'->'", "'=>'", 
			"'int'", "'float'", "'double'", "'byte'", "'boolean'", "'void'", "'var'", 
			"'val'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROTECTED", "PRIVATE", "PUBLIC", "SYNCHRONISED", "ABSTRACT", "NATIVE", 
			"STATIC", "FINAL", "STRICTFP", "VOLATILE", "INSTANCEOF", "RETURN", "ASSERT", 
			"NEW", "CLASS", "INTERFACE", "ENUM", "RECORD", "SINGLE", "ANNOTATION", 
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
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(110);
				packageDecl();
				}
			}

			setState(113);
			imports();
			setState(114);
			classDecl();
			setState(115);
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
			setState(117);
			match(PACKAGE);
			setState(118);
			id();
			setState(119);
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
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(121);
				importDecl();
				}
				}
				setState(126);
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
			setState(127);
			match(IMPORT);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(128);
				match(STATIC);
				}
			}

			setState(131);
			id();
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(132);
				match(DOT);
				setState(133);
				match(STAR);
				}
			}

			setState(136);
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
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(138);
					annotation();
					}
					} 
				}
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(144);
			modifiers();
			setState(145);
			objectType();
			setState(146);
			idPart();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESSER) {
				{
				setState(147);
				genericTypeDefs();
				}
			}

			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(150);
				recordComponents();
				}
			}

			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(153);
				objectExtends();
				}
			}

			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(156);
				objectImplements();
				}
			}

			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERMITS) {
				{
				setState(159);
				objectPermits();
				}
			}

			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(162);
				match(LBRACE);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << CLASS) | (1L << INTERFACE) | (1L << ENUM) | (1L << RECORD) | (1L << SINGLE) | (1L << ANNOTATION) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << AT))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (LESSER - 66)) | (1L << (LBRACE - 66)) | (1L << (SEMICOLON - 66)) | (1L << (INT - 66)) | (1L << (DEC - 66)) | (1L << (DOUBLE - 66)) | (1L << (BYTE - 66)) | (1L << (BOOL - 66)) | (1L << (VOID - 66)) | (1L << (VAR - 66)) | (1L << (VAL - 66)) | (1L << (ID - 66)))) != 0)) {
					{
					{
					setState(163);
					member();
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(169);
				match(RBRACE);
				}
				break;
			case SEMICOLON:
				{
				setState(170);
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
			setState(173);
			match(EXTENDS);
			setState(174);
			type(0);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(175);
				match(COMMA);
				setState(176);
				type(0);
				}
				}
				setState(181);
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
			setState(182);
			match(IMPLEMENTS);
			setState(183);
			type(0);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(184);
				match(COMMA);
				setState(185);
				type(0);
				}
				}
				setState(190);
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
			setState(191);
			match(PERMITS);
			setState(192);
			type(0);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(193);
				match(COMMA);
				setState(194);
				type(0);
				}
				}
				setState(199);
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
			setState(200);
			match(LESSER);
			setState(201);
			genericTypeDef();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(202);
				match(COMMA);
				setState(203);
				genericTypeDef();
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209);
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
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(211);
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
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLASS) {
				{
				setState(214);
				match(CLASS);
				}
			}

			setState(217);
			type(0);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(218);
				match(EXTENDS);
				setState(219);
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
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(CLASS);
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(INTERFACE);
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(ENUM);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 4);
				{
				setState(225);
				match(AT);
				setState(226);
				match(INTERFACE);
				}
				break;
			case ANNOTATION:
				enterOuterAlt(_localctx, 5);
				{
				setState(227);
				match(ANNOTATION);
				}
				break;
			case RECORD:
				enterOuterAlt(_localctx, 6);
				{
				setState(228);
				match(RECORD);
				}
				break;
			case SINGLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(229);
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
			setState(232);
			match(LPAREN);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << ANNOTATION) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << AT))) != 0) || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (INT - 85)) | (1L << (DEC - 85)) | (1L << (DOUBLE - 85)) | (1L << (BYTE - 85)) | (1L << (BOOL - 85)) | (1L << (VOID - 85)) | (1L << (VAR - 85)) | (1L << (VAL - 85)) | (1L << (ID - 85)))) != 0)) {
				{
				setState(233);
				parameter();
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(234);
					match(COMMA);
					setState(235);
					parameter();
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(243);
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
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				function();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				constructor();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				varDecl();
				setState(248);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(251);
				init();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(252);
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
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(255);
					annotation();
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(261);
			modifiers();
			setState(262);
			type(0);
			setState(263);
			match(LPAREN);
			setState(264);
			parameters();
			setState(265);
			match(RPAREN);
			setState(270);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(266);
				block();
				}
				break;
			case SEMICOLON:
				{
				setState(267);
				match(SEMICOLON);
				}
				break;
			case DASHARROW:
				{
				setState(268);
				match(DASHARROW);
				setState(269);
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
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(272);
				match(STATIC);
				}
			}

			setState(275);
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
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(277);
					annotation();
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(283);
			modifiers();
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESSER) {
				{
				setState(284);
				genericTypeDefs();
				}
			}

			setState(287);
			type(0);
			setState(288);
			idPart();
			setState(289);
			match(LPAREN);
			setState(290);
			parameters();
			setState(291);
			match(RPAREN);
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
			case SEMICOLON:
				{
				setState(292);
				functionBlock();
				}
				break;
			case DASHARROW:
				{
				setState(293);
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
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(296);
				block();
				}
				break;
			case SEMICOLON:
				{
				setState(297);
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
			setState(300);
			match(DASHARROW);
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(301);
				value(0);
				setState(302);
				match(SEMICOLON);
				}
				break;
			case 2:
				{
				setState(304);
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
			setState(310);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(307);
					annotation();
					}
					} 
				}
				setState(312);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(313);
			modifiers();
			setState(314);
			type(0);
			setState(315);
			idPart();
			setState(318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(316);
				match(ASSIGN);
				setState(317);
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
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINAL) {
				{
				setState(320);
				match(FINAL);
				}
			}

			setState(323);
			type(0);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELIPSES) {
				{
				setState(324);
				match(ELIPSES);
				}
			}

			setState(327);
			idPart();
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(328);
				match(ASSIGN);
				setState(329);
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
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FINAL) | (1L << ANNOTATION) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << AT))) != 0) || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (INT - 85)) | (1L << (DEC - 85)) | (1L << (DOUBLE - 85)) | (1L << (BYTE - 85)) | (1L << (BOOL - 85)) | (1L << (VOID - 85)) | (1L << (VAR - 85)) | (1L << (VAL - 85)) | (1L << (ID - 85)))) != 0)) {
				{
				setState(332);
				parameter();
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(333);
					match(COMMA);
					setState(334);
					parameter();
					}
					}
					setState(339);
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
			setState(342);
			match(LBRACE);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << RETURN) | (1L << ASSERT) | (1L << NEW) | (1L << ANNOTATION) | (1L << THIS) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << WHILE) | (1L << YIELD) | (1L << FOR) | (1L << DO) | (1L << IF) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LBRACE - 69)) | (1L << (LPAREN - 69)) | (1L << (SEMICOLON - 69)) | (1L << (EXCLAMATION - 69)) | (1L << (INT - 69)) | (1L << (DEC - 69)) | (1L << (DOUBLE - 69)) | (1L << (BYTE - 69)) | (1L << (BOOL - 69)) | (1L << (VOID - 69)) | (1L << (VAR - 69)) | (1L << (VAL - 69)) | (1L << (ID - 69)))) != 0)) {
				{
				{
				setState(343);
				statement();
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(349);
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
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode DOT() { return getToken(CyclicLangParser.DOT, 0); }
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
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				returnStatement();
				setState(353);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(355);
				assertStatement();
				setState(356);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(358);
				varDecl();
				setState(359);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(361);
				varAssignment();
				setState(362);
				match(SEMICOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(364);
				initialisation();
				setState(365);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(367);
				ifStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(368);
				whileStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(369);
				forStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(370);
				foreachStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(371);
				switchStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(372);
				doWhile();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(373);
				yieldStatement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(377);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(374);
					value(0);
					setState(375);
					match(DOT);
					}
					break;
				}
				setState(379);
				call();
				setState(380);
				match(SEMICOLON);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(382);
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
			setState(385);
			match(AT);
			setState(386);
			id();
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(387);
				match(LPAREN);
				setState(397);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(388);
					annotationArg();
					setState(393);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(389);
						match(COMMA);
						setState(390);
						annotationArg();
						}
						}
						setState(395);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(396);
					value(0);
					}
					break;
				}
				setState(399);
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
			setState(402);
			idPart();
			setState(403);
			match(ASSIGN);
			setState(404);
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
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(407);
				annotation();
				}
				}
				setState(412);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(413);
			rawType();
			setState(415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(414);
				genericTypeUses();
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(428);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(417);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(421);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AT) {
						{
						{
						setState(418);
						annotation();
						}
						}
						setState(423);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(424);
					match(LSQUAR);
					setState(425);
					match(RSQUAR);
					}
					} 
				}
				setState(430);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
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
			setState(431);
			match(LESSER);
			setState(432);
			genericTypeUse();
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(433);
				match(COMMA);
				setState(434);
				genericTypeUse();
				}
				}
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(440);
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
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(442);
				match(QUESTION);
				setState(443);
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

			setState(446);
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
			setState(457);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(448);
				match(INT);
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				match(DEC);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(450);
				match(DOUBLE);
				}
				break;
			case BYTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(451);
				match(BYTE);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(452);
				match(BOOL);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 6);
				{
				setState(453);
				match(VOID);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 7);
				{
				setState(454);
				match(VAR);
				}
				break;
			case VAL:
				enterOuterAlt(_localctx, 8);
				{
				setState(455);
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
				setState(456);
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
			setState(462);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(459);
					modifier();
					}
					} 
				}
				setState(464);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode DOT() { return getToken(CyclicLangParser.DOT, 0); }
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
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				_localctx = new FunctionValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(466);
				call();
				}
				break;
			case 2:
				{
				_localctx = new DoValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(467);
				match(DO);
				setState(468);
				statement();
				}
				break;
			case 3:
				{
				_localctx = new InitialisationValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(469);
				initialisation();
				}
				break;
			case 4:
				{
				_localctx = new ParenValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(470);
				match(LPAREN);
				setState(471);
				value(0);
				setState(472);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new InlineDeclerationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(474);
				varDecl();
				}
				break;
			case 6:
				{
				_localctx = new SwitchValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(475);
				switchStatement();
				}
				break;
			case 7:
				{
				_localctx = new ClassValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(476);
				id();
				setState(477);
				match(DOT);
				setState(478);
				match(CLASS);
				}
				break;
			case 8:
				{
				_localctx = new CastValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(480);
				cast();
				}
				break;
			case 9:
				{
				_localctx = new UnaryOpValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(481);
				unaryop();
				setState(482);
				value(10);
				}
				break;
			case 10:
				{
				_localctx = new NewArrayValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(484);
				newArray();
				}
				break;
			case 11:
				{
				_localctx = new NewListedArrayValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(485);
				newListedArray();
				}
				break;
			case 12:
				{
				_localctx = new ThisValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(486);
				match(THIS);
				}
				break;
			case 13:
				{
				_localctx = new DecLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(487);
				match(DECLIT);
				}
				break;
			case 14:
				{
				_localctx = new IntLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(488);
				match(INTLIT);
				}
				break;
			case 15:
				{
				_localctx = new StrLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(489);
				match(STRLIT);
				}
				break;
			case 16:
				{
				_localctx = new BoolLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(490);
				match(BOOLLIT);
				}
				break;
			case 17:
				{
				_localctx = new NullLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(491);
				match(NULL);
				}
				break;
			case 18:
				{
				_localctx = new VarValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(492);
				idPart();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(518);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(516);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOpValueContext(new ValueContext(_parentctx, _parentState));
						((BinaryOpValueContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(495);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(496);
						binaryop();
						setState(497);
						((BinaryOpValueContext)_localctx).right = value(24);
						}
						break;
					case 2:
						{
						_localctx = new FunctionValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(499);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(500);
						match(DOT);
						setState(501);
						call();
						}
						break;
					case 3:
						{
						_localctx = new InstanceCheckValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(502);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(504);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==EXCLAMATION) {
							{
							setState(503);
							match(EXCLAMATION);
							}
						}

						setState(506);
						match(INSTANCEOF);
						setState(507);
						type(0);
						}
						break;
					case 4:
						{
						_localctx = new ArrayIndexValueContext(new ValueContext(_parentctx, _parentState));
						((ArrayIndexValueContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(508);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(509);
						match(LSQUAR);
						setState(510);
						((ArrayIndexValueContext)_localctx).index = value(0);
						setState(511);
						match(RSQUAR);
						}
						break;
					case 5:
						{
						_localctx = new VarValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(513);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(514);
						match(DOT);
						setState(515);
						idPart();
						}
						break;
					}
					} 
				}
				setState(520);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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
			setState(521);
			match(NEW);
			setState(522);
			type(0);
			setState(523);
			match(LPAREN);
			setState(524);
			arguments();
			setState(525);
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
			setState(527);
			match(LPAREN);
			setState(528);
			type(0);
			setState(529);
			match(RPAREN);
			setState(530);
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
			setState(532);
			value(0);
			setState(534);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(533);
				binaryop();
				}
				break;
			}
			setState(536);
			match(ASSIGN);
			setState(537);
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
			setState(539);
			idPart();
			setState(540);
			match(LPAREN);
			setState(541);
			arguments();
			setState(542);
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
		enterRule(_localctx, 70, RULE_newArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			match(NEW);
			setState(545);
			type(0);
			setState(546);
			match(LSQUAR);
			setState(547);
			value(0);
			setState(548);
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
		enterRule(_localctx, 72, RULE_newListedArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(NEW);
			setState(551);
			type(0);
			setState(552);
			match(LSQUAR);
			setState(553);
			match(RSQUAR);
			setState(554);
			match(LBRACE);
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << ANNOTATION) | (1L << THIS) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (LPAREN - 71)) | (1L << (EXCLAMATION - 71)) | (1L << (INT - 71)) | (1L << (DEC - 71)) | (1L << (DOUBLE - 71)) | (1L << (BYTE - 71)) | (1L << (BOOL - 71)) | (1L << (VOID - 71)) | (1L << (VAR - 71)) | (1L << (VAL - 71)) | (1L << (ID - 71)))) != 0)) {
				{
				setState(555);
				value(0);
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(556);
					match(COMMA);
					setState(557);
					value(0);
					}
					}
					setState(562);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(565);
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
		enterRule(_localctx, 74, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << ANNOTATION) | (1L << THIS) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (LPAREN - 71)) | (1L << (EXCLAMATION - 71)) | (1L << (INT - 71)) | (1L << (DEC - 71)) | (1L << (DOUBLE - 71)) | (1L << (BYTE - 71)) | (1L << (BOOL - 71)) | (1L << (VOID - 71)) | (1L << (VAR - 71)) | (1L << (VAL - 71)) | (1L << (ID - 71)))) != 0)) {
				{
				setState(567);
				value(0);
				setState(572);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(568);
					match(COMMA);
					setState(569);
					value(0);
					}
					}
					setState(574);
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
		enterRule(_localctx, 76, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			match(RETURN);
			setState(579);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << ANNOTATION) | (1L << THIS) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (LPAREN - 71)) | (1L << (EXCLAMATION - 71)) | (1L << (INT - 71)) | (1L << (DEC - 71)) | (1L << (DOUBLE - 71)) | (1L << (BYTE - 71)) | (1L << (BOOL - 71)) | (1L << (VOID - 71)) | (1L << (VAR - 71)) | (1L << (VAL - 71)) | (1L << (ID - 71)))) != 0)) {
				{
				setState(578);
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
		enterRule(_localctx, 78, RULE_assertStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			match(ASSERT);
			setState(582);
			value(0);
			setState(585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(583);
				match(COLON);
				setState(584);
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
		enterRule(_localctx, 80, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			match(IF);
			setState(588);
			match(LPAREN);
			setState(589);
			value(0);
			setState(590);
			match(RPAREN);
			setState(591);
			statement();
			setState(593);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(592);
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
		enterRule(_localctx, 82, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			match(ELSE);
			setState(596);
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
		enterRule(_localctx, 84, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(598);
			match(WHILE);
			setState(599);
			match(LPAREN);
			setState(600);
			value(0);
			setState(601);
			match(RPAREN);
			setState(602);
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
		enterRule(_localctx, 86, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			match(FOR);
			setState(605);
			match(LPAREN);
			setState(607);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(606);
				((ForStatementContext)_localctx).start = statement();
				}
				break;
			}
			setState(609);
			((ForStatementContext)_localctx).cond = value(0);
			setState(610);
			match(SEMICOLON);
			setState(612);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << RETURN) | (1L << ASSERT) | (1L << NEW) | (1L << ANNOTATION) | (1L << THIS) | (1L << IN) | (1L << OUT) | (1L << SEALED) | (1L << PERMITS) | (1L << NONSEALED) | (1L << SWITCH) | (1L << WHILE) | (1L << YIELD) | (1L << FOR) | (1L << DO) | (1L << IF) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LBRACE - 69)) | (1L << (LPAREN - 69)) | (1L << (SEMICOLON - 69)) | (1L << (EXCLAMATION - 69)) | (1L << (INT - 69)) | (1L << (DEC - 69)) | (1L << (DOUBLE - 69)) | (1L << (BYTE - 69)) | (1L << (BOOL - 69)) | (1L << (VOID - 69)) | (1L << (VAR - 69)) | (1L << (VAL - 69)) | (1L << (ID - 69)))) != 0)) {
				{
				setState(611);
				((ForStatementContext)_localctx).end = statement();
				}
			}

			setState(614);
			match(RPAREN);
			setState(615);
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
		enterRule(_localctx, 88, RULE_foreachStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(FOR);
			setState(618);
			match(LPAREN);
			setState(619);
			type(0);
			setState(620);
			idPart();
			setState(621);
			match(COLON);
			setState(622);
			value(0);
			setState(623);
			match(RPAREN);
			setState(624);
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
		enterRule(_localctx, 90, RULE_doWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			match(DO);
			setState(627);
			statement();
			setState(628);
			match(WHILE);
			setState(629);
			match(LPAREN);
			setState(630);
			value(0);
			setState(631);
			match(RPAREN);
			setState(632);
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
		enterRule(_localctx, 92, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			match(SWITCH);
			setState(635);
			match(LPAREN);
			setState(636);
			value(0);
			setState(637);
			match(RPAREN);
			setState(638);
			match(LBRACE);
			setState(642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(639);
				caseClause();
				}
				}
				setState(644);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(646);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(645);
				defaultClause();
				}
			}

			setState(648);
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
		enterRule(_localctx, 94, RULE_caseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			match(CASE);
			setState(651);
			value(0);
			setState(652);
			match(DASHARROW);
			setState(657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(653);
				statement();
				}
				break;
			case 2:
				{
				setState(654);
				value(0);
				setState(655);
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
		enterRule(_localctx, 96, RULE_defaultClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			match(DEFAULT);
			setState(660);
			match(DASHARROW);
			setState(665);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(661);
				statement();
				}
				break;
			case 2:
				{
				setState(662);
				value(0);
				setState(663);
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
		enterRule(_localctx, 98, RULE_yieldStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(667);
			match(YIELD);
			setState(668);
			value(0);
			setState(669);
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
		enterRule(_localctx, 100, RULE_binaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			_la = _input.LA(1);
			if ( !(((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (BITAND - 46)) | (1L << (BITOR - 46)) | (1L << (AND - 46)) | (1L << (OR - 46)) | (1L << (UP - 46)) | (1L << (STAR - 46)) | (1L << (SLASH - 46)) | (1L << (PLUS - 46)) | (1L << (MINUS - 46)) | (1L << (PERCENT - 46)) | (1L << (LSHIFT - 46)) | (1L << (RSHIFT - 46)) | (1L << (ULSHIFT - 46)) | (1L << (URSHIFT - 46)) | (1L << (EQUAL - 46)) | (1L << (INEQUAL - 46)) | (1L << (GREATEREQ - 46)) | (1L << (LESSEREQ - 46)) | (1L << (GREATER - 46)) | (1L << (LESSER - 46)) | (1L << (ASSIGN - 46)) | (1L << (PASS - 46)))) != 0)) ) {
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
		enterRule(_localctx, 102, RULE_unaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
			_la = _input.LA(1);
			if ( !(((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & ((1L << (PLUS - 53)) | (1L << (MINUS - 53)) | (1L << (EXCLAMATION - 53)))) != 0)) ) {
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
		enterRule(_localctx, 104, RULE_id);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			idPart();
			setState(680);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(676);
					match(DOT);
					setState(677);
					idPart();
					}
					} 
				}
				setState(682);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
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
		enterRule(_localctx, 106, RULE_idPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
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
		enterRule(_localctx, 108, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
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
			return precpred(_ctx, 23);
		case 2:
			return precpred(_ctx, 22);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3f\u02b2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\5\2r\n\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\4\7\4}\n\4\f\4\16\4\u0080\13\4\3\5\3\5\5\5\u0084\n\5"+
		"\3\5\3\5\3\5\5\5\u0089\n\5\3\5\3\5\3\6\7\6\u008e\n\6\f\6\16\6\u0091\13"+
		"\6\3\6\3\6\3\6\3\6\5\6\u0097\n\6\3\6\5\6\u009a\n\6\3\6\5\6\u009d\n\6\3"+
		"\6\5\6\u00a0\n\6\3\6\5\6\u00a3\n\6\3\6\3\6\7\6\u00a7\n\6\f\6\16\6\u00aa"+
		"\13\6\3\6\3\6\5\6\u00ae\n\6\3\7\3\7\3\7\3\7\7\7\u00b4\n\7\f\7\16\7\u00b7"+
		"\13\7\3\b\3\b\3\b\3\b\7\b\u00bd\n\b\f\b\16\b\u00c0\13\b\3\t\3\t\3\t\3"+
		"\t\7\t\u00c6\n\t\f\t\16\t\u00c9\13\t\3\n\3\n\3\n\3\n\7\n\u00cf\n\n\f\n"+
		"\16\n\u00d2\13\n\3\n\3\n\3\13\5\13\u00d7\n\13\3\13\5\13\u00da\n\13\3\13"+
		"\3\13\3\13\5\13\u00df\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e9\n"+
		"\f\3\r\3\r\3\r\3\r\7\r\u00ef\n\r\f\r\16\r\u00f2\13\r\5\r\u00f4\n\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0100\n\16\3\17\7\17"+
		"\u0103\n\17\f\17\16\17\u0106\13\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u0111\n\17\3\20\5\20\u0114\n\20\3\20\3\20\3\21\7\21\u0119"+
		"\n\21\f\21\16\21\u011c\13\21\3\21\3\21\5\21\u0120\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u0129\n\21\3\22\3\22\5\22\u012d\n\22\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u0134\n\23\3\24\7\24\u0137\n\24\f\24\16\24\u013a"+
		"\13\24\3\24\3\24\3\24\3\24\3\24\5\24\u0141\n\24\3\25\5\25\u0144\n\25\3"+
		"\25\3\25\5\25\u0148\n\25\3\25\3\25\3\25\5\25\u014d\n\25\3\26\3\26\3\26"+
		"\7\26\u0152\n\26\f\26\16\26\u0155\13\26\5\26\u0157\n\26\3\27\3\27\7\27"+
		"\u015b\n\27\f\27\16\27\u015e\13\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u017c\n\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0182\n\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u018a\n\31\f\31\16"+
		"\31\u018d\13\31\3\31\5\31\u0190\n\31\3\31\5\31\u0193\n\31\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\7\33\u019b\n\33\f\33\16\33\u019e\13\33\3\33\3\33\5"+
		"\33\u01a2\n\33\3\33\3\33\7\33\u01a6\n\33\f\33\16\33\u01a9\13\33\3\33\3"+
		"\33\7\33\u01ad\n\33\f\33\16\33\u01b0\13\33\3\34\3\34\3\34\3\34\7\34\u01b6"+
		"\n\34\f\34\16\34\u01b9\13\34\3\34\3\34\3\35\3\35\5\35\u01bf\n\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u01cc\n\36\3\37"+
		"\7\37\u01cf\n\37\f\37\16\37\u01d2\13\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u01f0\n \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \5 \u01fb\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 "+
		"\u0207\n \f \16 \u020a\13 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\5#\u0219\n#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\7&\u0231\n&\f&\16&\u0234\13&\5&\u0236\n&\3&\3&\3\'\3\'\3\'"+
		"\7\'\u023d\n\'\f\'\16\'\u0240\13\'\5\'\u0242\n\'\3(\3(\5(\u0246\n(\3)"+
		"\3)\3)\3)\5)\u024c\n)\3*\3*\3*\3*\3*\3*\5*\u0254\n*\3+\3+\3+\3,\3,\3,"+
		"\3,\3,\3,\3-\3-\3-\5-\u0262\n-\3-\3-\3-\5-\u0267\n-\3-\3-\3-\3.\3.\3."+
		"\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\7\60\u0283\n\60\f\60\16\60\u0286\13\60\3\60\5\60\u0289\n\60\3\60\3"+
		"\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u0294\n\61\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\5\62\u029c\n\62\3\63\3\63\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\66\3\66\3\66\7\66\u02a9\n\66\f\66\16\66\u02ac\13\66\3\67\3\67\38\3"+
		"8\38\2\4\64>9\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdfhjln\2\b\3\2\35\36\4\2\31\31\34\34\4\2\60"+
		"9;F\4\2\678RR\5\2\26\26\35 aa\5\2\3\f\37\37!!\2\u02f3\2q\3\2\2\2\4w\3"+
		"\2\2\2\6~\3\2\2\2\b\u0081\3\2\2\2\n\u008f\3\2\2\2\f\u00af\3\2\2\2\16\u00b8"+
		"\3\2\2\2\20\u00c1\3\2\2\2\22\u00ca\3\2\2\2\24\u00d6\3\2\2\2\26\u00e8\3"+
		"\2\2\2\30\u00ea\3\2\2\2\32\u00ff\3\2\2\2\34\u0104\3\2\2\2\36\u0113\3\2"+
		"\2\2 \u011a\3\2\2\2\"\u012c\3\2\2\2$\u012e\3\2\2\2&\u0138\3\2\2\2(\u0143"+
		"\3\2\2\2*\u0156\3\2\2\2,\u0158\3\2\2\2.\u0181\3\2\2\2\60\u0183\3\2\2\2"+
		"\62\u0194\3\2\2\2\64\u0198\3\2\2\2\66\u01b1\3\2\2\28\u01be\3\2\2\2:\u01cb"+
		"\3\2\2\2<\u01d0\3\2\2\2>\u01ef\3\2\2\2@\u020b\3\2\2\2B\u0211\3\2\2\2D"+
		"\u0216\3\2\2\2F\u021d\3\2\2\2H\u0222\3\2\2\2J\u0228\3\2\2\2L\u0241\3\2"+
		"\2\2N\u0243\3\2\2\2P\u0247\3\2\2\2R\u024d\3\2\2\2T\u0255\3\2\2\2V\u0258"+
		"\3\2\2\2X\u025e\3\2\2\2Z\u026b\3\2\2\2\\\u0274\3\2\2\2^\u027c\3\2\2\2"+
		"`\u028c\3\2\2\2b\u0295\3\2\2\2d\u029d\3\2\2\2f\u02a1\3\2\2\2h\u02a3\3"+
		"\2\2\2j\u02a5\3\2\2\2l\u02ad\3\2\2\2n\u02af\3\2\2\2pr\5\4\3\2qp\3\2\2"+
		"\2qr\3\2\2\2rs\3\2\2\2st\5\6\4\2tu\5\n\6\2uv\7\2\2\3v\3\3\2\2\2wx\7\30"+
		"\2\2xy\5j\66\2yz\7N\2\2z\5\3\2\2\2{}\5\b\5\2|{\3\2\2\2}\u0080\3\2\2\2"+
		"~|\3\2\2\2~\177\3\2\2\2\177\7\3\2\2\2\u0080~\3\2\2\2\u0081\u0083\7\27"+
		"\2\2\u0082\u0084\7\t\2\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0088\5j\66\2\u0086\u0087\7P\2\2\u0087\u0089\7\65"+
		"\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\7N\2\2\u008b\t\3\2\2\2\u008c\u008e\5\60\31\2\u008d\u008c\3\2\2"+
		"\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\5<\37\2\u0093\u0094\5\26\f\2"+
		"\u0094\u0096\5l\67\2\u0095\u0097\5\22\n\2\u0096\u0095\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u009a\5\30\r\2\u0099\u0098\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u009d\5\f\7\2\u009c\u009b"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u00a0\5\16\b\2"+
		"\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u00a3"+
		"\5\20\t\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00ad\3\2\2\2"+
		"\u00a4\u00a8\7G\2\2\u00a5\u00a7\5\32\16\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00ae\7H\2\2\u00ac\u00ae\7N\2\2\u00ad\u00a4\3\2\2"+
		"\2\u00ad\u00ac\3\2\2\2\u00ae\13\3\2\2\2\u00af\u00b0\7\31\2\2\u00b0\u00b5"+
		"\5\64\33\2\u00b1\u00b2\7Q\2\2\u00b2\u00b4\5\64\33\2\u00b3\u00b1\3\2\2"+
		"\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\r"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7\32\2\2\u00b9\u00be\5\64\33"+
		"\2\u00ba\u00bb\7Q\2\2\u00bb\u00bd\5\64\33\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\17\3\2\2"+
		"\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7 \2\2\u00c2\u00c7\5\64\33\2\u00c3"+
		"\u00c4\7Q\2\2\u00c4\u00c6\5\64\33\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3"+
		"\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\21\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00cb\7D\2\2\u00cb\u00d0\5\24\13\2\u00cc\u00cd\7"+
		"Q\2\2\u00cd\u00cf\5\24\13\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d3\u00d4\7C\2\2\u00d4\23\3\2\2\2\u00d5\u00d7\t\2\2\2\u00d6\u00d5"+
		"\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00da\7\21\2\2"+
		"\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00de"+
		"\5\64\33\2\u00dc\u00dd\7\31\2\2\u00dd\u00df\5\64\33\2\u00de\u00dc\3\2"+
		"\2\2\u00de\u00df\3\2\2\2\u00df\25\3\2\2\2\u00e0\u00e9\7\21\2\2\u00e1\u00e9"+
		"\7\22\2\2\u00e2\u00e9\7\23\2\2\u00e3\u00e4\7:\2\2\u00e4\u00e9\7\22\2\2"+
		"\u00e5\u00e9\7\26\2\2\u00e6\u00e9\7\24\2\2\u00e7\u00e9\7\25\2\2\u00e8"+
		"\u00e0\3\2\2\2\u00e8\u00e1\3\2\2\2\u00e8\u00e2\3\2\2\2\u00e8\u00e3\3\2"+
		"\2\2\u00e8\u00e5\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9"+
		"\27\3\2\2\2\u00ea\u00f3\7I\2\2\u00eb\u00f0\5(\25\2\u00ec\u00ed\7Q\2\2"+
		"\u00ed\u00ef\5(\25\2\u00ee\u00ec\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee"+
		"\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00eb\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\7J"+
		"\2\2\u00f6\31\3\2\2\2\u00f7\u0100\5 \21\2\u00f8\u0100\5\34\17\2\u00f9"+
		"\u00fa\5&\24\2\u00fa\u00fb\7N\2\2\u00fb\u0100\3\2\2\2\u00fc\u0100\5\n"+
		"\6\2\u00fd\u0100\5\36\20\2\u00fe\u0100\7N\2\2\u00ff\u00f7\3\2\2\2\u00ff"+
		"\u00f8\3\2\2\2\u00ff\u00f9\3\2\2\2\u00ff\u00fc\3\2\2\2\u00ff\u00fd\3\2"+
		"\2\2\u00ff\u00fe\3\2\2\2\u0100\33\3\2\2\2\u0101\u0103\5\60\31\2\u0102"+
		"\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\5<\37\2\u0108"+
		"\u0109\5\64\33\2\u0109\u010a\7I\2\2\u010a\u010b\5*\26\2\u010b\u0110\7"+
		"J\2\2\u010c\u0111\5,\27\2\u010d\u0111\7N\2\2\u010e\u010f\7U\2\2\u010f"+
		"\u0111\5.\30\2\u0110\u010c\3\2\2\2\u0110\u010d\3\2\2\2\u0110\u010e\3\2"+
		"\2\2\u0111\35\3\2\2\2\u0112\u0114\7\t\2\2\u0113\u0112\3\2\2\2\u0113\u0114"+
		"\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\5,\27\2\u0116\37\3\2\2\2\u0117"+
		"\u0119\5\60\31\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3"+
		"\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d"+
		"\u011f\5<\37\2\u011e\u0120\5\22\n\2\u011f\u011e\3\2\2\2\u011f\u0120\3"+
		"\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\5\64\33\2\u0122\u0123\5l\67\2\u0123"+
		"\u0124\7I\2\2\u0124\u0125\5*\26\2\u0125\u0128\7J\2\2\u0126\u0129\5\"\22"+
		"\2\u0127\u0129\5$\23\2\u0128\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129!"+
		"\3\2\2\2\u012a\u012d\5,\27\2\u012b\u012d\7N\2\2\u012c\u012a\3\2\2\2\u012c"+
		"\u012b\3\2\2\2\u012d#\3\2\2\2\u012e\u0133\7U\2\2\u012f\u0130\5> \2\u0130"+
		"\u0131\7N\2\2\u0131\u0134\3\2\2\2\u0132\u0134\5.\30\2\u0133\u012f\3\2"+
		"\2\2\u0133\u0132\3\2\2\2\u0134%\3\2\2\2\u0135\u0137\5\60\31\2\u0136\u0135"+
		"\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\5<\37\2\u013c\u013d\5\64"+
		"\33\2\u013d\u0140\5l\67\2\u013e\u013f\7E\2\2\u013f\u0141\5> \2\u0140\u013e"+
		"\3\2\2\2\u0140\u0141\3\2\2\2\u0141\'\3\2\2\2\u0142\u0144\7\n\2\2\u0143"+
		"\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\5\64"+
		"\33\2\u0146\u0148\7T\2\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u014c\5l\67\2\u014a\u014b\7E\2\2\u014b\u014d\5> "+
		"\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d)\3\2\2\2\u014e\u0153"+
		"\5(\25\2\u014f\u0150\7Q\2\2\u0150\u0152\5(\25\2\u0151\u014f\3\2\2\2\u0152"+
		"\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0157\3\2"+
		"\2\2\u0155\u0153\3\2\2\2\u0156\u014e\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"+\3\2\2\2\u0158\u015c\7G\2\2\u0159\u015b\5.\30\2\u015a\u0159\3\2\2\2\u015b"+
		"\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015f\3\2"+
		"\2\2\u015e\u015c\3\2\2\2\u015f\u0160\7H\2\2\u0160-\3\2\2\2\u0161\u0182"+
		"\5,\27\2\u0162\u0163\5N(\2\u0163\u0164\7N\2\2\u0164\u0182\3\2\2\2\u0165"+
		"\u0166\5P)\2\u0166\u0167\7N\2\2\u0167\u0182\3\2\2\2\u0168\u0169\5&\24"+
		"\2\u0169\u016a\7N\2\2\u016a\u0182\3\2\2\2\u016b\u016c\5D#\2\u016c\u016d"+
		"\7N\2\2\u016d\u0182\3\2\2\2\u016e\u016f\5@!\2\u016f\u0170\7N\2\2\u0170"+
		"\u0182\3\2\2\2\u0171\u0182\5R*\2\u0172\u0182\5V,\2\u0173\u0182\5X-\2\u0174"+
		"\u0182\5Z.\2\u0175\u0182\5^\60\2\u0176\u0182\5\\/\2\u0177\u0182\5d\63"+
		"\2\u0178\u0179\5> \2\u0179\u017a\7P\2\2\u017a\u017c\3\2\2\2\u017b\u0178"+
		"\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\5F$\2\u017e"+
		"\u017f\7N\2\2\u017f\u0182\3\2\2\2\u0180\u0182\7N\2\2\u0181\u0161\3\2\2"+
		"\2\u0181\u0162\3\2\2\2\u0181\u0165\3\2\2\2\u0181\u0168\3\2\2\2\u0181\u016b"+
		"\3\2\2\2\u0181\u016e\3\2\2\2\u0181\u0171\3\2\2\2\u0181\u0172\3\2\2\2\u0181"+
		"\u0173\3\2\2\2\u0181\u0174\3\2\2\2\u0181\u0175\3\2\2\2\u0181\u0176\3\2"+
		"\2\2\u0181\u0177\3\2\2\2\u0181\u017b\3\2\2\2\u0181\u0180\3\2\2\2\u0182"+
		"/\3\2\2\2\u0183\u0184\7:\2\2\u0184\u0192\5j\66\2\u0185\u018f\7I\2\2\u0186"+
		"\u018b\5\62\32\2\u0187\u0188\7Q\2\2\u0188\u018a\5\62\32\2\u0189\u0187"+
		"\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c"+
		"\u0190\3\2\2\2\u018d\u018b\3\2\2\2\u018e\u0190\5> \2\u018f\u0186\3\2\2"+
		"\2\u018f\u018e\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193"+
		"\7J\2\2\u0192\u0185\3\2\2\2\u0192\u0193\3\2\2\2\u0193\61\3\2\2\2\u0194"+
		"\u0195\5l\67\2\u0195\u0196\7E\2\2\u0196\u0197\5> \2\u0197\63\3\2\2\2\u0198"+
		"\u019c\b\33\1\2\u0199\u019b\5\60\31\2\u019a\u0199\3\2\2\2\u019b\u019e"+
		"\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e"+
		"\u019c\3\2\2\2\u019f\u01a1\5:\36\2\u01a0\u01a2\5\66\34\2\u01a1\u01a0\3"+
		"\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01ae\3\2\2\2\u01a3\u01a7\f\3\2\2\u01a4"+
		"\u01a6\5\60\31\2\u01a5\u01a4\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5\3"+
		"\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01aa\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa"+
		"\u01ab\7K\2\2\u01ab\u01ad\7L\2\2\u01ac\u01a3\3\2\2\2\u01ad\u01b0\3\2\2"+
		"\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\65\3\2\2\2\u01b0\u01ae"+
		"\3\2\2\2\u01b1\u01b2\7D\2\2\u01b2\u01b7\58\35\2\u01b3\u01b4\7Q\2\2\u01b4"+
		"\u01b6\58\35\2\u01b5\u01b3\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5\3\2"+
		"\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01ba\3\2\2\2\u01b9\u01b7\3\2\2\2\u01ba"+
		"\u01bb\7C\2\2\u01bb\67\3\2\2\2\u01bc\u01bd\7S\2\2\u01bd\u01bf\t\3\2\2"+
		"\u01be\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1"+
		"\5\64\33\2\u01c19\3\2\2\2\u01c2\u01cc\7W\2\2\u01c3\u01cc\7X\2\2\u01c4"+
		"\u01cc\7Y\2\2\u01c5\u01cc\7Z\2\2\u01c6\u01cc\7[\2\2\u01c7\u01cc\7\\\2"+
		"\2\u01c8\u01cc\7]\2\2\u01c9\u01cc\7^\2\2\u01ca\u01cc\5j\66\2\u01cb\u01c2"+
		"\3\2\2\2\u01cb\u01c3\3\2\2\2\u01cb\u01c4\3\2\2\2\u01cb\u01c5\3\2\2\2\u01cb"+
		"\u01c6\3\2\2\2\u01cb\u01c7\3\2\2\2\u01cb\u01c8\3\2\2\2\u01cb\u01c9\3\2"+
		"\2\2\u01cb\u01ca\3\2\2\2\u01cc;\3\2\2\2\u01cd\u01cf\5n8\2\u01ce\u01cd"+
		"\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1"+
		"=\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01d4\b \1\2\u01d4\u01f0\5F$\2\u01d5"+
		"\u01d6\7)\2\2\u01d6\u01f0\5.\30\2\u01d7\u01f0\5@!\2\u01d8\u01d9\7I\2\2"+
		"\u01d9\u01da\5> \2\u01da\u01db\7J\2\2\u01db\u01f0\3\2\2\2\u01dc\u01f0"+
		"\5&\24\2\u01dd\u01f0\5^\60\2\u01de\u01df\5j\66\2\u01df\u01e0\7P\2\2\u01e0"+
		"\u01e1\7\21\2\2\u01e1\u01f0\3\2\2\2\u01e2\u01f0\5B\"\2\u01e3\u01e4\5h"+
		"\65\2\u01e4\u01e5\5> \f\u01e5\u01f0\3\2\2\2\u01e6\u01f0\5H%\2\u01e7\u01f0"+
		"\5J&\2\u01e8\u01f0\7\33\2\2\u01e9\u01f0\7+\2\2\u01ea\u01f0\7,\2\2\u01eb"+
		"\u01f0\7-\2\2\u01ec\u01f0\7.\2\2\u01ed\u01f0\7/\2\2\u01ee\u01f0\5l\67"+
		"\2\u01ef\u01d3\3\2\2\2\u01ef\u01d5\3\2\2\2\u01ef\u01d7\3\2\2\2\u01ef\u01d8"+
		"\3\2\2\2\u01ef\u01dc\3\2\2\2\u01ef\u01dd\3\2\2\2\u01ef\u01de\3\2\2\2\u01ef"+
		"\u01e2\3\2\2\2\u01ef\u01e3\3\2\2\2\u01ef\u01e6\3\2\2\2\u01ef\u01e7\3\2"+
		"\2\2\u01ef\u01e8\3\2\2\2\u01ef\u01e9\3\2\2\2\u01ef\u01ea\3\2\2\2\u01ef"+
		"\u01eb\3\2\2\2\u01ef\u01ec\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01ee\3\2"+
		"\2\2\u01f0\u0208\3\2\2\2\u01f1\u01f2\f\31\2\2\u01f2\u01f3\5f\64\2\u01f3"+
		"\u01f4\5> \32\u01f4\u0207\3\2\2\2\u01f5\u01f6\f\30\2\2\u01f6\u01f7\7P"+
		"\2\2\u01f7\u0207\5F$\2\u01f8\u01fa\f\26\2\2\u01f9\u01fb\7R\2\2\u01fa\u01f9"+
		"\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\7\r\2\2\u01fd"+
		"\u0207\5\64\33\2\u01fe\u01ff\f\25\2\2\u01ff\u0200\7K\2\2\u0200\u0201\5"+
		"> \2\u0201\u0202\7L\2\2\u0202\u0207\3\2\2\2\u0203\u0204\f\24\2\2\u0204"+
		"\u0205\7P\2\2\u0205\u0207\5l\67\2\u0206\u01f1\3\2\2\2\u0206\u01f5\3\2"+
		"\2\2\u0206\u01f8\3\2\2\2\u0206\u01fe\3\2\2\2\u0206\u0203\3\2\2\2\u0207"+
		"\u020a\3\2\2\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209?\3\2\2\2"+
		"\u020a\u0208\3\2\2\2\u020b\u020c\7\20\2\2\u020c\u020d\5\64\33\2\u020d"+
		"\u020e\7I\2\2\u020e\u020f\5L\'\2\u020f\u0210\7J\2\2\u0210A\3\2\2\2\u0211"+
		"\u0212\7I\2\2\u0212\u0213\5\64\33\2\u0213\u0214\7J\2\2\u0214\u0215\5>"+
		" \2\u0215C\3\2\2\2\u0216\u0218\5> \2\u0217\u0219\5f\64\2\u0218\u0217\3"+
		"\2\2\2\u0218\u0219\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021b\7E\2\2\u021b"+
		"\u021c\5> \2\u021cE\3\2\2\2\u021d\u021e\5l\67\2\u021e\u021f\7I\2\2\u021f"+
		"\u0220\5L\'\2\u0220\u0221\7J\2\2\u0221G\3\2\2\2\u0222\u0223\7\20\2\2\u0223"+
		"\u0224\5\64\33\2\u0224\u0225\7K\2\2\u0225\u0226\5> \2\u0226\u0227\7L\2"+
		"\2\u0227I\3\2\2\2\u0228\u0229\7\20\2\2\u0229\u022a\5\64\33\2\u022a\u022b"+
		"\7K\2\2\u022b\u022c\7L\2\2\u022c\u0235\7G\2\2\u022d\u0232\5> \2\u022e"+
		"\u022f\7Q\2\2\u022f\u0231\5> \2\u0230\u022e\3\2\2\2\u0231\u0234\3\2\2"+
		"\2\u0232\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0236\3\2\2\2\u0234\u0232"+
		"\3\2\2\2\u0235\u022d\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0237\3\2\2\2\u0237"+
		"\u0238\7H\2\2\u0238K\3\2\2\2\u0239\u023e\5> \2\u023a\u023b\7Q\2\2\u023b"+
		"\u023d\5> \2\u023c\u023a\3\2\2\2\u023d\u0240\3\2\2\2\u023e\u023c\3\2\2"+
		"\2\u023e\u023f\3\2\2\2\u023f\u0242\3\2\2\2\u0240\u023e\3\2\2\2\u0241\u0239"+
		"\3\2\2\2\u0241\u0242\3\2\2\2\u0242M\3\2\2\2\u0243\u0245\7\16\2\2\u0244"+
		"\u0246\5> \2\u0245\u0244\3\2\2\2\u0245\u0246\3\2\2\2\u0246O\3\2\2\2\u0247"+
		"\u0248\7\17\2\2\u0248\u024b\5> \2\u0249\u024a\7M\2\2\u024a\u024c\7-\2"+
		"\2\u024b\u0249\3\2\2\2\u024b\u024c\3\2\2\2\u024cQ\3\2\2\2\u024d\u024e"+
		"\7*\2\2\u024e\u024f\7I\2\2\u024f\u0250\5> \2\u0250\u0251\7J\2\2\u0251"+
		"\u0253\5.\30\2\u0252\u0254\5T+\2\u0253\u0252\3\2\2\2\u0253\u0254\3\2\2"+
		"\2\u0254S\3\2\2\2\u0255\u0256\7\'\2\2\u0256\u0257\5.\30\2\u0257U\3\2\2"+
		"\2\u0258\u0259\7$\2\2\u0259\u025a\7I\2\2\u025a\u025b\5> \2\u025b\u025c"+
		"\7J\2\2\u025c\u025d\5.\30\2\u025dW\3\2\2\2\u025e\u025f\7(\2\2\u025f\u0261"+
		"\7I\2\2\u0260\u0262\5.\30\2\u0261\u0260\3\2\2\2\u0261\u0262\3\2\2\2\u0262"+
		"\u0263\3\2\2\2\u0263\u0264\5> \2\u0264\u0266\7N\2\2\u0265\u0267\5.\30"+
		"\2\u0266\u0265\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u0269"+
		"\7J\2\2\u0269\u026a\5.\30\2\u026aY\3\2\2\2\u026b\u026c\7(\2\2\u026c\u026d"+
		"\7I\2\2\u026d\u026e\5\64\33\2\u026e\u026f\5l\67\2\u026f\u0270\7M\2\2\u0270"+
		"\u0271\5> \2\u0271\u0272\7J\2\2\u0272\u0273\5.\30\2\u0273[\3\2\2\2\u0274"+
		"\u0275\7)\2\2\u0275\u0276\5.\30\2\u0276\u0277\7$\2\2\u0277\u0278\7I\2"+
		"\2\u0278\u0279\5> \2\u0279\u027a\7J\2\2\u027a\u027b\7N\2\2\u027b]\3\2"+
		"\2\2\u027c\u027d\7#\2\2\u027d\u027e\7I\2\2\u027e\u027f\5> \2\u027f\u0280"+
		"\7J\2\2\u0280\u0284\7G\2\2\u0281\u0283\5`\61\2\u0282\u0281\3\2\2\2\u0283"+
		"\u0286\3\2\2\2\u0284\u0282\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0288\3\2"+
		"\2\2\u0286\u0284\3\2\2\2\u0287\u0289\5b\62\2\u0288\u0287\3\2\2\2\u0288"+
		"\u0289\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028b\7H\2\2\u028b_\3\2\2\2\u028c"+
		"\u028d\7&\2\2\u028d\u028e\5> \2\u028e\u0293\7U\2\2\u028f\u0294\5.\30\2"+
		"\u0290\u0291\5> \2\u0291\u0292\7N\2\2\u0292\u0294\3\2\2\2\u0293\u028f"+
		"\3\2\2\2\u0293\u0290\3\2\2\2\u0294a\3\2\2\2\u0295\u0296\7\"\2\2\u0296"+
		"\u029b\7U\2\2\u0297\u029c\5.\30\2\u0298\u0299\5> \2\u0299\u029a\7N\2\2"+
		"\u029a\u029c\3\2\2\2\u029b\u0297\3\2\2\2\u029b\u0298\3\2\2\2\u029cc\3"+
		"\2\2\2\u029d\u029e\7%\2\2\u029e\u029f\5> \2\u029f\u02a0\7N\2\2\u02a0e"+
		"\3\2\2\2\u02a1\u02a2\t\4\2\2\u02a2g\3\2\2\2\u02a3\u02a4\t\5\2\2\u02a4"+
		"i\3\2\2\2\u02a5\u02aa\5l\67\2\u02a6\u02a7\7P\2\2\u02a7\u02a9\5l\67\2\u02a8"+
		"\u02a6\3\2\2\2\u02a9\u02ac\3\2\2\2\u02aa\u02a8\3\2\2\2\u02aa\u02ab\3\2"+
		"\2\2\u02abk\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ad\u02ae\t\6\2\2\u02aem\3\2"+
		"\2\2\u02af\u02b0\t\7\2\2\u02b0o\3\2\2\2Iq~\u0083\u0088\u008f\u0096\u0099"+
		"\u009c\u009f\u00a2\u00a8\u00ad\u00b5\u00be\u00c7\u00d0\u00d6\u00d9\u00de"+
		"\u00e8\u00f0\u00f3\u00ff\u0104\u0110\u0113\u011a\u011f\u0128\u012c\u0133"+
		"\u0138\u0140\u0143\u0147\u014c\u0153\u0156\u015c\u017b\u0181\u018b\u018f"+
		"\u0192\u019c\u01a1\u01a7\u01ae\u01b7\u01be\u01cb\u01d0\u01ef\u01fa\u0206"+
		"\u0208\u0218\u0232\u0235\u023e\u0241\u0245\u024b\u0253\u0261\u0266\u0284"+
		"\u0288\u0293\u029b\u02aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}