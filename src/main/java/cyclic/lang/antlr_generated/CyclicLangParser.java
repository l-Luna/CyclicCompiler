package cyclic.lang.antlr_generated;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
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
		IMPORT=20, PACKAGE=21, EXTENDS=22, IMPLEMENTS=23, THIS=24, DEFAULT=25, 
		SWITCH=26, WHILE=27, YIELD=28, CASE=29, ELSE=30, FOR=31, DO=32, IF=33, 
		DECLIT=34, INTLIT=35, STRLIT=36, BOOLLIT=37, NULL=38, AND=39, OR=40, UP=41, 
		STAR=42, SLASH=43, PLUS=44, MINUS=45, PERCENT=46, AT=47, LSHIFT=48, RSHIFT=49, 
		ULSHIFT=50, URSHIFT=51, EQUAL=52, INEQUAL=53, GREATEREQ=54, LESSEREQ=55, 
		GREATER=56, LESSER=57, ASSIGN=58, PASS=59, LBRACE=60, RBRACE=61, LPAREN=62, 
		RPAREN=63, LSQUAR=64, RSQUAR=65, COLON=66, SEMICOLON=67, QUOTE=68, DOT=69, 
		COMMA=70, EXCLAMATION=71, QUESTION=72, DASHARROW=73, EQARROW=74, INT=75, 
		DEC=76, BYTE=77, BOOL=78, VOID=79, VAR=80, VAL=81, TRUE=82, FALSE=83, 
		ID=84, DIGIT=85, NONDIGIT=86, SING_COMMENT=87, WS=88, UNMATCHED=89;
	public static final int
		RULE_file = 0, RULE_packageDecl = 1, RULE_imports = 2, RULE_importDecl = 3, 
		RULE_classDecl = 4, RULE_objectExtends = 5, RULE_objectImplements = 6, 
		RULE_objectType = 7, RULE_member = 8, RULE_constructor = 9, RULE_init = 10, 
		RULE_function = 11, RULE_functionBlock = 12, RULE_functionArrow = 13, 
		RULE_varDecl = 14, RULE_parameters = 15, RULE_block = 16, RULE_statement = 17, 
		RULE_annotation = 18, RULE_type = 19, RULE_rawType = 20, RULE_id = 21, 
		RULE_modifiers = 22, RULE_value = 23, RULE_initialisation = 24, RULE_cast = 25, 
		RULE_varAssignment = 26, RULE_call = 27, RULE_newArray = 28, RULE_newListedArray = 29, 
		RULE_arguments = 30, RULE_returnStatement = 31, RULE_assertStatement = 32, 
		RULE_ifStatement = 33, RULE_elseStatement = 34, RULE_whileStatement = 35, 
		RULE_forStatement = 36, RULE_foreachStatement = 37, RULE_doWhile = 38, 
		RULE_switchStatement = 39, RULE_caseClause = 40, RULE_defaultClause = 41, 
		RULE_yieldStatement = 42, RULE_binaryop = 43, RULE_unaryop = 44, RULE_modifier = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "packageDecl", "imports", "importDecl", "classDecl", "objectExtends", 
			"objectImplements", "objectType", "member", "constructor", "init", "function", 
			"functionBlock", "functionArrow", "varDecl", "parameters", "block", "statement", 
			"annotation", "type", "rawType", "id", "modifiers", "value", "initialisation", 
			"cast", "varAssignment", "call", "newArray", "newListedArray", "arguments", 
			"returnStatement", "assertStatement", "ifStatement", "elseStatement", 
			"whileStatement", "forStatement", "foreachStatement", "doWhile", "switchStatement", 
			"caseClause", "defaultClause", "yieldStatement", "binaryop", "unaryop", 
			"modifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'protected'", "'private'", "'public'", "'synchronised'", "'abstract'", 
			"'native'", "'static'", "'final'", "'strictfp'", "'volatile'", "'instanceof'", 
			"'return'", "'assert'", "'new'", "'class'", "'interface'", "'enum'", 
			"'record'", "'single'", "'import'", "'package'", "'extends'", "'implements'", 
			"'this'", "'default'", "'switch'", "'while'", "'yield'", "'case'", "'else'", 
			"'for'", "'do'", "'if'", null, null, null, null, "'null'", "'&&'", "'||'", 
			"'^'", "'*'", "'/'", "'+'", "'-'", "'%'", "'@'", "'<<'", "'>>'", "'<<<'", 
			"'>>>'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'='", "'|>'", 
			"'{'", "'}'", "'('", "')'", "'['", "']'", "':'", "';'", "'\"'", "'.'", 
			"','", "'!'", "'?'", "'->'", "'=>'", "'int'", "'float'", "'byte'", "'boolean'", 
			"'void'", "'var'", "'val'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROTECTED", "PRIVATE", "PUBLIC", "SYNCHRONISED", "ABSTRACT", "NATIVE", 
			"STATIC", "FINAL", "STRICTFP", "VOLATILE", "INSTANCEOF", "RETURN", "ASSERT", 
			"NEW", "CLASS", "INTERFACE", "ENUM", "RECORD", "SINGLE", "IMPORT", "PACKAGE", 
			"EXTENDS", "IMPLEMENTS", "THIS", "DEFAULT", "SWITCH", "WHILE", "YIELD", 
			"CASE", "ELSE", "FOR", "DO", "IF", "DECLIT", "INTLIT", "STRLIT", "BOOLLIT", 
			"NULL", "AND", "OR", "UP", "STAR", "SLASH", "PLUS", "MINUS", "PERCENT", 
			"AT", "LSHIFT", "RSHIFT", "ULSHIFT", "URSHIFT", "EQUAL", "INEQUAL", "GREATEREQ", 
			"LESSEREQ", "GREATER", "LESSER", "ASSIGN", "PASS", "LBRACE", "RBRACE", 
			"LPAREN", "RPAREN", "LSQUAR", "RSQUAR", "COLON", "SEMICOLON", "QUOTE", 
			"DOT", "COMMA", "EXCLAMATION", "QUESTION", "DASHARROW", "EQARROW", "INT", 
			"DEC", "BYTE", "BOOL", "VOID", "VAR", "VAL", "TRUE", "FALSE", "ID", "DIGIT", 
			"NONDIGIT", "SING_COMMENT", "WS", "UNMATCHED"
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitFile(this);
		}
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
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(92);
				packageDecl();
				}
			}

			setState(95);
			imports();
			setState(96);
			classDecl();
			setState(97);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterPackageDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitPackageDecl(this);
		}
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
			setState(99);
			match(PACKAGE);
			setState(100);
			id();
			setState(101);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitImports(this);
		}
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
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(103);
				importDecl();
				}
				}
				setState(108);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterImportDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitImportDecl(this);
		}
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
			setState(109);
			match(IMPORT);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(110);
				match(STATIC);
				}
			}

			setState(113);
			id();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(114);
				match(DOT);
				setState(115);
				match(STAR);
				}
			}

			setState(118);
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
		public TerminalNode ID() { return getToken(CyclicLangParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(CyclicLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CyclicLangParser.RBRACE, 0); }
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public ObjectExtendsContext objectExtends() {
			return getRuleContext(ObjectExtendsContext.class,0);
		}
		public ObjectImplementsContext objectImplements() {
			return getRuleContext(ObjectImplementsContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitClassDecl(this);
		}
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
			setState(120);
			modifiers();
			setState(121);
			objectType();
			setState(122);
			match(ID);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(123);
				objectExtends();
				}
			}

			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(126);
				objectImplements();
				}
			}

			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(129);
				match(LBRACE);
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(130);
						annotation();
						}
						} 
					}
					setState(135);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << CLASS) | (1L << INTERFACE) | (1L << ENUM) | (1L << RECORD) | (1L << SINGLE) | (1L << AT) | (1L << LBRACE))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (SEMICOLON - 67)) | (1L << (INT - 67)) | (1L << (DEC - 67)) | (1L << (BYTE - 67)) | (1L << (BOOL - 67)) | (1L << (VOID - 67)) | (1L << (VAR - 67)) | (1L << (VAL - 67)) | (1L << (ID - 67)))) != 0)) {
					{
					{
					setState(136);
					member();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(142);
				match(RBRACE);
				}
				break;
			case SEMICOLON:
				{
				setState(143);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ObjectExtendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectExtends; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterObjectExtends(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitObjectExtends(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitObjectExtends(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectExtendsContext objectExtends() throws RecognitionException {
		ObjectExtendsContext _localctx = new ObjectExtendsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_objectExtends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(EXTENDS);
			setState(147);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterObjectImplements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitObjectImplements(this);
		}
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
			setState(149);
			match(IMPLEMENTS);
			setState(150);
			type(0);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(151);
				match(COMMA);
				setState(152);
				type(0);
				}
				}
				setState(157);
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

	public static class ObjectTypeContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(CyclicLangParser.CLASS, 0); }
		public TerminalNode INTERFACE() { return getToken(CyclicLangParser.INTERFACE, 0); }
		public TerminalNode ENUM() { return getToken(CyclicLangParser.ENUM, 0); }
		public TerminalNode AT() { return getToken(CyclicLangParser.AT, 0); }
		public TerminalNode RECORD() { return getToken(CyclicLangParser.RECORD, 0); }
		public TerminalNode SINGLE() { return getToken(CyclicLangParser.SINGLE, 0); }
		public ObjectTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterObjectType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitObjectType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitObjectType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectTypeContext objectType() throws RecognitionException {
		ObjectTypeContext _localctx = new ObjectTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_objectType);
		try {
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(CLASS);
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(INTERFACE);
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				match(ENUM);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
				match(AT);
				setState(162);
				match(INTERFACE);
				}
				break;
			case RECORD:
				enterOuterAlt(_localctx, 5);
				{
				setState(163);
				match(RECORD);
				}
				break;
			case SINGLE:
				enterOuterAlt(_localctx, 6);
				{
				setState(164);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_member);
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				function();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				constructor();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				varDecl();
				setState(170);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				init();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(174);
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
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			modifiers();
			setState(178);
			type(0);
			setState(179);
			match(LPAREN);
			setState(180);
			parameters();
			setState(181);
			match(RPAREN);
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(182);
				block();
				}
				break;
			case SEMICOLON:
				{
				setState(183);
				match(SEMICOLON);
				}
				break;
			case DASHARROW:
				{
				setState(184);
				match(DASHARROW);
				setState(185);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(188);
				match(STATIC);
				}
			}

			setState(191);
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
		public TerminalNode ID() { return getToken(CyclicLangParser.ID, 0); }
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
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			modifiers();
			setState(194);
			type(0);
			setState(195);
			match(ID);
			setState(196);
			match(LPAREN);
			setState(197);
			parameters();
			setState(198);
			match(RPAREN);
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
			case SEMICOLON:
				{
				setState(199);
				functionBlock();
				}
				break;
			case DASHARROW:
				{
				setState(200);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterFunctionBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitFunctionBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitFunctionBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBlockContext functionBlock() throws RecognitionException {
		FunctionBlockContext _localctx = new FunctionBlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(203);
				block();
				}
				break;
			case SEMICOLON:
				{
				setState(204);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterFunctionArrow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitFunctionArrow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitFunctionArrow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArrowContext functionArrow() throws RecognitionException {
		FunctionArrowContext _localctx = new FunctionArrowContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functionArrow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(DASHARROW);
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(208);
				value(0);
				setState(209);
				match(SEMICOLON);
				}
				break;
			case 2:
				{
				setState(211);
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
		public TerminalNode ID() { return getToken(CyclicLangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CyclicLangParser.ASSIGN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			modifiers();
			setState(215);
			type(0);
			setState(216);
			match(ID);
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(217);
				match(ASSIGN);
				setState(218);
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

	public static class ParametersContext extends ParserRuleContext {
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << AT))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (INT - 75)) | (1L << (DEC - 75)) | (1L << (BYTE - 75)) | (1L << (BOOL - 75)) | (1L << (VOID - 75)) | (1L << (VAR - 75)) | (1L << (VAL - 75)) | (1L << (ID - 75)))) != 0)) {
				{
				setState(221);
				varDecl();
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(222);
					match(COMMA);
					setState(223);
					varDecl();
					}
					}
					setState(228);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(LBRACE);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << RETURN) | (1L << ASSERT) | (1L << NEW) | (1L << THIS) | (1L << SWITCH) | (1L << WHILE) | (1L << YIELD) | (1L << FOR) | (1L << DO) | (1L << IF) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT) | (1L << LBRACE) | (1L << LPAREN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (SEMICOLON - 67)) | (1L << (EXCLAMATION - 67)) | (1L << (INT - 67)) | (1L << (DEC - 67)) | (1L << (BYTE - 67)) | (1L << (BOOL - 67)) | (1L << (VOID - 67)) | (1L << (VAR - 67)) | (1L << (VAL - 67)) | (1L << (ID - 67)))) != 0)) {
				{
				{
				setState(232);
				statement();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(238);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statement);
		try {
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				returnStatement();
				setState(242);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(244);
				assertStatement();
				setState(245);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(247);
				varDecl();
				setState(248);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(250);
				varAssignment();
				setState(251);
				match(SEMICOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(253);
				initialisation();
				setState(254);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(256);
				ifStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(257);
				whileStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(258);
				forStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(259);
				foreachStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(260);
				switchStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(261);
				doWhile();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(262);
				yieldStatement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(266);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(263);
					value(0);
					setState(264);
					match(DOT);
					}
					break;
				}
				setState(268);
				call();
				setState(269);
				match(SEMICOLON);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(271);
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
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(AT);
			setState(275);
			id();
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
		public TerminalNode LESSER() { return getToken(CyclicLangParser.LESSER, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode GREATER() { return getToken(CyclicLangParser.GREATER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CyclicLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CyclicLangParser.COMMA, i);
		}
		public TerminalNode LSQUAR() { return getToken(CyclicLangParser.LSQUAR, 0); }
		public TerminalNode RSQUAR() { return getToken(CyclicLangParser.RSQUAR, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitType(this);
		}
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(278);
				annotation();
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(284);
			rawType();
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(285);
				match(LESSER);
				setState(286);
				type(0);
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(287);
					match(COMMA);
					setState(288);
					type(0);
					}
					}
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(294);
				match(GREATER);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(303);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(298);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(299);
					match(LSQUAR);
					setState(300);
					match(RSQUAR);
					}
					} 
				}
				setState(305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public static class RawTypeContext extends ParserRuleContext {
		public RawTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rawType; }
	 
		public RawTypeContext() { }
		public void copyFrom(RawTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdTypeContext extends RawTypeContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public IdTypeContext(RawTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterIdType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitIdType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitIdType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends RawTypeContext {
		public TerminalNode INT() { return getToken(CyclicLangParser.INT, 0); }
		public IntTypeContext(RawTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InferFinalTypeContext extends RawTypeContext {
		public TerminalNode VAL() { return getToken(CyclicLangParser.VAL, 0); }
		public InferFinalTypeContext(RawTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterInferFinalType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitInferFinalType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInferFinalType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VoidTypeContext extends RawTypeContext {
		public TerminalNode VOID() { return getToken(CyclicLangParser.VOID, 0); }
		public VoidTypeContext(RawTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitVoidType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitVoidType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ByteTypeContext extends RawTypeContext {
		public TerminalNode BYTE() { return getToken(CyclicLangParser.BYTE, 0); }
		public ByteTypeContext(RawTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterByteType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitByteType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitByteType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends RawTypeContext {
		public TerminalNode BOOL() { return getToken(CyclicLangParser.BOOL, 0); }
		public BoolTypeContext(RawTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InferTypeContext extends RawTypeContext {
		public TerminalNode VAR() { return getToken(CyclicLangParser.VAR, 0); }
		public InferTypeContext(RawTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterInferType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitInferType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInferType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecTypeContext extends RawTypeContext {
		public TerminalNode DEC() { return getToken(CyclicLangParser.DEC, 0); }
		public DecTypeContext(RawTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterDecType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitDecType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitDecType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RawTypeContext rawType() throws RecognitionException {
		RawTypeContext _localctx = new RawTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_rawType);
		try {
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				match(INT);
				}
				break;
			case DEC:
				_localctx = new DecTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				match(DEC);
				}
				break;
			case BYTE:
				_localctx = new ByteTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(308);
				match(BYTE);
				}
				break;
			case BOOL:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(309);
				match(BOOL);
				}
				break;
			case VOID:
				_localctx = new VoidTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(310);
				match(VOID);
				}
				break;
			case VAR:
				_localctx = new InferTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(311);
				match(VAR);
				}
				break;
			case VAL:
				_localctx = new InferFinalTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(312);
				match(VAL);
				}
				break;
			case ID:
				_localctx = new IdTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(313);
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

	public static class IdContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CyclicLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CyclicLangParser.ID, i);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_id);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(ID);
			setState(321);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(317);
					match(DOT);
					setState(318);
					match(ID);
					}
					} 
				}
				setState(323);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitModifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_modifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE))) != 0)) {
				{
				{
				setState(324);
				modifier();
				}
				}
				setState(329);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterThisValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitThisValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterCastValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitCastValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitCastValue(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterDoValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitDoValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterUnaryOpValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitUnaryOpValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterNullLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitNullLit(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterInitialisationValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitInitialisationValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterNewListedArrayValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitNewListedArrayValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterParenValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitParenValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterNewArrayValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitNewArrayValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterInstanceCheckValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitInstanceCheckValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterClassValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitClassValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterStrLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitStrLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitStrLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarValueContext extends ValueContext {
		public TerminalNode ID() { return getToken(CyclicLangParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode DOT() { return getToken(CyclicLangParser.DOT, 0); }
		public VarValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterVarValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitVarValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterBinaryOpValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitBinaryOpValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterBoolLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitBoolLit(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterDecLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitDecLit(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterIntLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitIntLit(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterFunctionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitFunctionValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterSwitchValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitSwitchValue(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterInlineDecleration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitInlineDecleration(this);
		}
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_value, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new FunctionValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(331);
				call();
				}
				break;
			case 2:
				{
				_localctx = new DoValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(332);
				match(DO);
				setState(333);
				statement();
				}
				break;
			case 3:
				{
				_localctx = new InitialisationValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(334);
				initialisation();
				}
				break;
			case 4:
				{
				_localctx = new ParenValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(335);
				match(LPAREN);
				setState(336);
				value(0);
				setState(337);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new InlineDeclerationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(339);
				varDecl();
				}
				break;
			case 6:
				{
				_localctx = new SwitchValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(340);
				switchStatement();
				}
				break;
			case 7:
				{
				_localctx = new ClassValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(341);
				id();
				setState(342);
				match(DOT);
				setState(343);
				match(CLASS);
				}
				break;
			case 8:
				{
				_localctx = new CastValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(345);
				cast();
				}
				break;
			case 9:
				{
				_localctx = new UnaryOpValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(346);
				unaryop();
				setState(347);
				value(10);
				}
				break;
			case 10:
				{
				_localctx = new NewArrayValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(349);
				newArray();
				}
				break;
			case 11:
				{
				_localctx = new NewListedArrayValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(350);
				newListedArray();
				}
				break;
			case 12:
				{
				_localctx = new ThisValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(351);
				match(THIS);
				}
				break;
			case 13:
				{
				_localctx = new DecLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(352);
				match(DECLIT);
				}
				break;
			case 14:
				{
				_localctx = new IntLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(353);
				match(INTLIT);
				}
				break;
			case 15:
				{
				_localctx = new StrLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(354);
				match(STRLIT);
				}
				break;
			case 16:
				{
				_localctx = new BoolLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(355);
				match(BOOLLIT);
				}
				break;
			case 17:
				{
				_localctx = new NullLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(356);
				match(NULL);
				}
				break;
			case 18:
				{
				_localctx = new VarValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(357);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(378);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(376);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOpValueContext(new ValueContext(_parentctx, _parentState));
						((BinaryOpValueContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(360);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(361);
						binaryop();
						setState(362);
						((BinaryOpValueContext)_localctx).right = value(23);
						}
						break;
					case 2:
						{
						_localctx = new FunctionValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(364);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(365);
						match(DOT);
						setState(366);
						call();
						}
						break;
					case 3:
						{
						_localctx = new InstanceCheckValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(367);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(369);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==EXCLAMATION) {
							{
							setState(368);
							match(EXCLAMATION);
							}
						}

						setState(371);
						match(INSTANCEOF);
						setState(372);
						type(0);
						}
						break;
					case 4:
						{
						_localctx = new VarValueContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(373);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(374);
						match(DOT);
						setState(375);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(380);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterInitialisation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitInitialisation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInitialisation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialisationContext initialisation() throws RecognitionException {
		InitialisationContext _localctx = new InitialisationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_initialisation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(NEW);
			setState(382);
			type(0);
			setState(383);
			match(LPAREN);
			setState(384);
			arguments();
			setState(385);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitCast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitCast(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastContext cast() throws RecognitionException {
		CastContext _localctx = new CastContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(LPAREN);
			setState(388);
			type(0);
			setState(389);
			match(RPAREN);
			setState(390);
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
		public VarAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterVarAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitVarAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitVarAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarAssignmentContext varAssignment() throws RecognitionException {
		VarAssignmentContext _localctx = new VarAssignmentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_varAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			value(0);
			setState(393);
			match(ASSIGN);
			setState(394);
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
		public TerminalNode ID() { return getToken(CyclicLangParser.ID, 0); }
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(ID);
			setState(397);
			match(LPAREN);
			setState(398);
			arguments();
			setState(399);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterNewArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitNewArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitNewArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewArrayContext newArray() throws RecognitionException {
		NewArrayContext _localctx = new NewArrayContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_newArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(NEW);
			setState(402);
			type(0);
			setState(403);
			match(LSQUAR);
			setState(404);
			value(0);
			setState(405);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterNewListedArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitNewListedArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitNewListedArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewListedArrayContext newListedArray() throws RecognitionException {
		NewListedArrayContext _localctx = new NewListedArrayContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_newListedArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			match(NEW);
			setState(408);
			type(0);
			setState(409);
			match(LSQUAR);
			setState(410);
			match(RSQUAR);
			setState(411);
			match(LBRACE);
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << THIS) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT) | (1L << LPAREN))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (EXCLAMATION - 71)) | (1L << (INT - 71)) | (1L << (DEC - 71)) | (1L << (BYTE - 71)) | (1L << (BOOL - 71)) | (1L << (VOID - 71)) | (1L << (VAR - 71)) | (1L << (VAL - 71)) | (1L << (ID - 71)))) != 0)) {
				{
				setState(412);
				value(0);
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(413);
					match(COMMA);
					setState(414);
					value(0);
					}
					}
					setState(419);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(422);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << THIS) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT) | (1L << LPAREN))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (EXCLAMATION - 71)) | (1L << (INT - 71)) | (1L << (DEC - 71)) | (1L << (BYTE - 71)) | (1L << (BOOL - 71)) | (1L << (VOID - 71)) | (1L << (VAR - 71)) | (1L << (VAL - 71)) | (1L << (ID - 71)))) != 0)) {
				{
				setState(424);
				value(0);
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(425);
					match(COMMA);
					setState(426);
					value(0);
					}
					}
					setState(431);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			match(RETURN);
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE) | (1L << NEW) | (1L << THIS) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << PLUS) | (1L << MINUS) | (1L << AT) | (1L << LPAREN))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (EXCLAMATION - 71)) | (1L << (INT - 71)) | (1L << (DEC - 71)) | (1L << (BYTE - 71)) | (1L << (BOOL - 71)) | (1L << (VOID - 71)) | (1L << (VAR - 71)) | (1L << (VAL - 71)) | (1L << (ID - 71)))) != 0)) {
				{
				setState(435);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterAssertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitAssertStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitAssertStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertStatementContext assertStatement() throws RecognitionException {
		AssertStatementContext _localctx = new AssertStatementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_assertStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(ASSERT);
			setState(439);
			value(0);
			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(440);
				match(COLON);
				setState(441);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(IF);
			setState(445);
			match(LPAREN);
			setState(446);
			value(0);
			setState(447);
			match(RPAREN);
			setState(448);
			statement();
			setState(450);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(449);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(ELSE);
			setState(453);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			match(WHILE);
			setState(456);
			match(LPAREN);
			setState(457);
			value(0);
			setState(458);
			match(RPAREN);
			setState(459);
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
		public TerminalNode FOR() { return getToken(CyclicLangParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CyclicLangParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CyclicLangParser.SEMICOLON, i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(CyclicLangParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			match(FOR);
			setState(462);
			match(LPAREN);
			setState(463);
			varDecl();
			setState(464);
			match(SEMICOLON);
			setState(465);
			value(0);
			setState(466);
			match(SEMICOLON);
			setState(467);
			value(0);
			setState(468);
			match(RPAREN);
			setState(469);
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

	public static class ForeachStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(CyclicLangParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(CyclicLangParser.LPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CyclicLangParser.ID, 0); }
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterForeachStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitForeachStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitForeachStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForeachStatementContext foreachStatement() throws RecognitionException {
		ForeachStatementContext _localctx = new ForeachStatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_foreachStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(FOR);
			setState(472);
			match(LPAREN);
			setState(473);
			type(0);
			setState(474);
			match(ID);
			setState(475);
			match(COLON);
			setState(476);
			value(0);
			setState(477);
			match(RPAREN);
			setState(478);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitDoWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileContext doWhile() throws RecognitionException {
		DoWhileContext _localctx = new DoWhileContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_doWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			match(DO);
			setState(481);
			block();
			setState(482);
			match(WHILE);
			setState(483);
			match(LPAREN);
			setState(484);
			value(0);
			setState(485);
			match(RPAREN);
			setState(486);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(SWITCH);
			setState(489);
			match(LPAREN);
			setState(490);
			value(0);
			setState(491);
			match(RPAREN);
			setState(492);
			match(LBRACE);
			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(493);
				caseClause();
				}
				}
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(499);
				defaultClause();
				}
			}

			setState(502);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterCaseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitCaseClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitCaseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseClauseContext caseClause() throws RecognitionException {
		CaseClauseContext _localctx = new CaseClauseContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_caseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			match(CASE);
			setState(505);
			value(0);
			setState(506);
			match(DASHARROW);
			setState(511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(507);
				statement();
				}
				break;
			case 2:
				{
				setState(508);
				value(0);
				setState(509);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterDefaultClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitDefaultClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitDefaultClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultClauseContext defaultClause() throws RecognitionException {
		DefaultClauseContext _localctx = new DefaultClauseContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_defaultClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(DEFAULT);
			setState(514);
			match(DASHARROW);
			setState(519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(515);
				statement();
				}
				break;
			case 2:
				{
				setState(516);
				value(0);
				setState(517);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterYieldStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitYieldStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitYieldStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YieldStatementContext yieldStatement() throws RecognitionException {
		YieldStatementContext _localctx = new YieldStatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_yieldStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			match(YIELD);
			setState(522);
			value(0);
			setState(523);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterBinaryop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitBinaryop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitBinaryop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryopContext binaryop() throws RecognitionException {
		BinaryopContext _localctx = new BinaryopContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_binaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << UP) | (1L << STAR) | (1L << SLASH) | (1L << PLUS) | (1L << MINUS) | (1L << PERCENT) | (1L << LSHIFT) | (1L << RSHIFT) | (1L << ULSHIFT) | (1L << URSHIFT) | (1L << EQUAL) | (1L << INEQUAL) | (1L << GREATEREQ) | (1L << LESSEREQ) | (1L << GREATER) | (1L << LESSER) | (1L << ASSIGN) | (1L << PASS))) != 0)) ) {
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterUnaryop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitUnaryop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitUnaryop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryopContext unaryop() throws RecognitionException {
		UnaryopContext _localctx = new UnaryopContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_unaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			_la = _input.LA(1);
			if ( !(((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (PLUS - 44)) | (1L << (MINUS - 44)) | (1L << (EXCLAMATION - 44)))) != 0)) ) {
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
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << STRICTFP) | (1L << VOLATILE))) != 0)) ) {
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
		case 19:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 23:
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
			return precpred(_ctx, 22);
		case 2:
			return precpred(_ctx, 21);
		case 3:
			return precpred(_ctx, 19);
		case 4:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3[\u0216\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\5\2`\n\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\4\7\4k\n\4\f\4\16\4n\13\4\3\5\3\5\5\5r\n\5\3\5\3\5\3\5\5\5w\n\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\5\6\177\n\6\3\6\5\6\u0082\n\6\3\6\3\6\7\6\u0086\n\6"+
		"\f\6\16\6\u0089\13\6\3\6\7\6\u008c\n\6\f\6\16\6\u008f\13\6\3\6\3\6\5\6"+
		"\u0093\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u009c\n\b\f\b\16\b\u009f\13"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a8\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u00b2\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00bd\n\13\3\f\5\f\u00c0\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00cc\n\r\3\16\3\16\5\16\u00d0\n\16\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00d7\n\17\3\20\3\20\3\20\3\20\3\20\5\20\u00de\n\20\3\21\3\21\3\21\7"+
		"\21\u00e3\n\21\f\21\16\21\u00e6\13\21\5\21\u00e8\n\21\3\22\3\22\7\22\u00ec"+
		"\n\22\f\22\16\22\u00ef\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\5\23\u010d\n\23\3\23\3\23\3\23\3\23\5\23"+
		"\u0113\n\23\3\24\3\24\3\24\3\25\3\25\7\25\u011a\n\25\f\25\16\25\u011d"+
		"\13\25\3\25\3\25\3\25\3\25\3\25\7\25\u0124\n\25\f\25\16\25\u0127\13\25"+
		"\3\25\3\25\5\25\u012b\n\25\3\25\3\25\3\25\7\25\u0130\n\25\f\25\16\25\u0133"+
		"\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u013d\n\26\3\27\3"+
		"\27\3\27\7\27\u0142\n\27\f\27\16\27\u0145\13\27\3\30\7\30\u0148\n\30\f"+
		"\30\16\30\u014b\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u0169\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\5\31\u0174\n\31\3\31\3\31\3\31\3\31\3\31\7\31\u017b\n\31\f"+
		"\31\16\31\u017e\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u01a2\n\37\f\37"+
		"\16\37\u01a5\13\37\5\37\u01a7\n\37\3\37\3\37\3 \3 \3 \7 \u01ae\n \f \16"+
		" \u01b1\13 \5 \u01b3\n \3!\3!\5!\u01b7\n!\3\"\3\"\3\"\3\"\5\"\u01bd\n"+
		"\"\3#\3#\3#\3#\3#\3#\5#\u01c5\n#\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3)\3)\3)\3)\3)\3)\7)\u01f1\n)\f)\16)\u01f4\13)\3)\5)\u01f7"+
		"\n)\3)\3)\3*\3*\3*\3*\3*\3*\3*\5*\u0202\n*\3+\3+\3+\3+\3+\3+\5+\u020a"+
		"\n+\3,\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\2\4(\60\60\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\\2\5\4\2)\60\62"+
		"=\4\2./II\3\2\3\f\2\u0242\2_\3\2\2\2\4e\3\2\2\2\6l\3\2\2\2\bo\3\2\2\2"+
		"\nz\3\2\2\2\f\u0094\3\2\2\2\16\u0097\3\2\2\2\20\u00a7\3\2\2\2\22\u00b1"+
		"\3\2\2\2\24\u00b3\3\2\2\2\26\u00bf\3\2\2\2\30\u00c3\3\2\2\2\32\u00cf\3"+
		"\2\2\2\34\u00d1\3\2\2\2\36\u00d8\3\2\2\2 \u00e7\3\2\2\2\"\u00e9\3\2\2"+
		"\2$\u0112\3\2\2\2&\u0114\3\2\2\2(\u0117\3\2\2\2*\u013c\3\2\2\2,\u013e"+
		"\3\2\2\2.\u0149\3\2\2\2\60\u0168\3\2\2\2\62\u017f\3\2\2\2\64\u0185\3\2"+
		"\2\2\66\u018a\3\2\2\28\u018e\3\2\2\2:\u0193\3\2\2\2<\u0199\3\2\2\2>\u01b2"+
		"\3\2\2\2@\u01b4\3\2\2\2B\u01b8\3\2\2\2D\u01be\3\2\2\2F\u01c6\3\2\2\2H"+
		"\u01c9\3\2\2\2J\u01cf\3\2\2\2L\u01d9\3\2\2\2N\u01e2\3\2\2\2P\u01ea\3\2"+
		"\2\2R\u01fa\3\2\2\2T\u0203\3\2\2\2V\u020b\3\2\2\2X\u020f\3\2\2\2Z\u0211"+
		"\3\2\2\2\\\u0213\3\2\2\2^`\5\4\3\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\5\6"+
		"\4\2bc\5\n\6\2cd\7\2\2\3d\3\3\2\2\2ef\7\27\2\2fg\5,\27\2gh\7E\2\2h\5\3"+
		"\2\2\2ik\5\b\5\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\7\3\2\2\2nl"+
		"\3\2\2\2oq\7\26\2\2pr\7\t\2\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2sv\5,\27\2"+
		"tu\7G\2\2uw\7,\2\2vt\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7E\2\2y\t\3\2\2\2z"+
		"{\5.\30\2{|\5\20\t\2|~\7V\2\2}\177\5\f\7\2~}\3\2\2\2~\177\3\2\2\2\177"+
		"\u0081\3\2\2\2\u0080\u0082\5\16\b\2\u0081\u0080\3\2\2\2\u0081\u0082\3"+
		"\2\2\2\u0082\u0092\3\2\2\2\u0083\u0087\7>\2\2\u0084\u0086\5&\24\2\u0085"+
		"\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u008d\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\5\22\n\2\u008b"+
		"\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0093\7?\2\2\u0091"+
		"\u0093\7E\2\2\u0092\u0083\3\2\2\2\u0092\u0091\3\2\2\2\u0093\13\3\2\2\2"+
		"\u0094\u0095\7\30\2\2\u0095\u0096\5(\25\2\u0096\r\3\2\2\2\u0097\u0098"+
		"\7\31\2\2\u0098\u009d\5(\25\2\u0099\u009a\7H\2\2\u009a\u009c\5(\25\2\u009b"+
		"\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009e\17\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a8\7\21\2\2\u00a1\u00a8"+
		"\7\22\2\2\u00a2\u00a8\7\23\2\2\u00a3\u00a4\7\61\2\2\u00a4\u00a8\7\22\2"+
		"\2\u00a5\u00a8\7\24\2\2\u00a6\u00a8\7\25\2\2\u00a7\u00a0\3\2\2\2\u00a7"+
		"\u00a1\3\2\2\2\u00a7\u00a2\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a5\3\2"+
		"\2\2\u00a7\u00a6\3\2\2\2\u00a8\21\3\2\2\2\u00a9\u00b2\5\30\r\2\u00aa\u00b2"+
		"\5\24\13\2\u00ab\u00ac\5\36\20\2\u00ac\u00ad\7E\2\2\u00ad\u00b2\3\2\2"+
		"\2\u00ae\u00b2\5\n\6\2\u00af\u00b2\5\26\f\2\u00b0\u00b2\7E\2\2\u00b1\u00a9"+
		"\3\2\2\2\u00b1\u00aa\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\23\3\2\2\2\u00b3\u00b4\5.\30"+
		"\2\u00b4\u00b5\5(\25\2\u00b5\u00b6\7@\2\2\u00b6\u00b7\5 \21\2\u00b7\u00bc"+
		"\7A\2\2\u00b8\u00bd\5\"\22\2\u00b9\u00bd\7E\2\2\u00ba\u00bb\7K\2\2\u00bb"+
		"\u00bd\5$\23\2\u00bc\u00b8\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bd\25\3\2\2\2\u00be\u00c0\7\t\2\2\u00bf\u00be\3\2\2\2\u00bf\u00c0"+
		"\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\5\"\22\2\u00c2\27\3\2\2\2\u00c3"+
		"\u00c4\5.\30\2\u00c4\u00c5\5(\25\2\u00c5\u00c6\7V\2\2\u00c6\u00c7\7@\2"+
		"\2\u00c7\u00c8\5 \21\2\u00c8\u00cb\7A\2\2\u00c9\u00cc\5\32\16\2\u00ca"+
		"\u00cc\5\34\17\2\u00cb\u00c9\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\31\3\2"+
		"\2\2\u00cd\u00d0\5\"\22\2\u00ce\u00d0\7E\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00ce\3\2\2\2\u00d0\33\3\2\2\2\u00d1\u00d6\7K\2\2\u00d2\u00d3\5\60\31"+
		"\2\u00d3\u00d4\7E\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d7\5$\23\2\u00d6\u00d2"+
		"\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\35\3\2\2\2\u00d8\u00d9\5.\30\2\u00d9"+
		"\u00da\5(\25\2\u00da\u00dd\7V\2\2\u00db\u00dc\7<\2\2\u00dc\u00de\5\60"+
		"\31\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\37\3\2\2\2\u00df\u00e4"+
		"\5\36\20\2\u00e0\u00e1\7H\2\2\u00e1\u00e3\5\36\20\2\u00e2\u00e0\3\2\2"+
		"\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e8"+
		"\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00df\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"!\3\2\2\2\u00e9\u00ed\7>\2\2\u00ea\u00ec\5$\23\2\u00eb\u00ea\3\2\2\2\u00ec"+
		"\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\3\2"+
		"\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\7?\2\2\u00f1#\3\2\2\2\u00f2\u0113"+
		"\5\"\22\2\u00f3\u00f4\5@!\2\u00f4\u00f5\7E\2\2\u00f5\u0113\3\2\2\2\u00f6"+
		"\u00f7\5B\"\2\u00f7\u00f8\7E\2\2\u00f8\u0113\3\2\2\2\u00f9\u00fa\5\36"+
		"\20\2\u00fa\u00fb\7E\2\2\u00fb\u0113\3\2\2\2\u00fc\u00fd\5\66\34\2\u00fd"+
		"\u00fe\7E\2\2\u00fe\u0113\3\2\2\2\u00ff\u0100\5\62\32\2\u0100\u0101\7"+
		"E\2\2\u0101\u0113\3\2\2\2\u0102\u0113\5D#\2\u0103\u0113\5H%\2\u0104\u0113"+
		"\5J&\2\u0105\u0113\5L\'\2\u0106\u0113\5P)\2\u0107\u0113\5N(\2\u0108\u0113"+
		"\5V,\2\u0109\u010a\5\60\31\2\u010a\u010b\7G\2\2\u010b\u010d\3\2\2\2\u010c"+
		"\u0109\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\58"+
		"\35\2\u010f\u0110\7E\2\2\u0110\u0113\3\2\2\2\u0111\u0113\7E\2\2\u0112"+
		"\u00f2\3\2\2\2\u0112\u00f3\3\2\2\2\u0112\u00f6\3\2\2\2\u0112\u00f9\3\2"+
		"\2\2\u0112\u00fc\3\2\2\2\u0112\u00ff\3\2\2\2\u0112\u0102\3\2\2\2\u0112"+
		"\u0103\3\2\2\2\u0112\u0104\3\2\2\2\u0112\u0105\3\2\2\2\u0112\u0106\3\2"+
		"\2\2\u0112\u0107\3\2\2\2\u0112\u0108\3\2\2\2\u0112\u010c\3\2\2\2\u0112"+
		"\u0111\3\2\2\2\u0113%\3\2\2\2\u0114\u0115\7\61\2\2\u0115\u0116\5,\27\2"+
		"\u0116\'\3\2\2\2\u0117\u011b\b\25\1\2\u0118\u011a\5&\24\2\u0119\u0118"+
		"\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\u011e\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u012a\5*\26\2\u011f\u0120\7;"+
		"\2\2\u0120\u0125\5(\25\2\u0121\u0122\7H\2\2\u0122\u0124\5(\25\2\u0123"+
		"\u0121\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129\7:\2\2\u0129"+
		"\u012b\3\2\2\2\u012a\u011f\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0131\3\2"+
		"\2\2\u012c\u012d\f\3\2\2\u012d\u012e\7B\2\2\u012e\u0130\7C\2\2\u012f\u012c"+
		"\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		")\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u013d\7M\2\2\u0135\u013d\7N\2\2\u0136"+
		"\u013d\7O\2\2\u0137\u013d\7P\2\2\u0138\u013d\7Q\2\2\u0139\u013d\7R\2\2"+
		"\u013a\u013d\7S\2\2\u013b\u013d\5,\27\2\u013c\u0134\3\2\2\2\u013c\u0135"+
		"\3\2\2\2\u013c\u0136\3\2\2\2\u013c\u0137\3\2\2\2\u013c\u0138\3\2\2\2\u013c"+
		"\u0139\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013b\3\2\2\2\u013d+\3\2\2\2"+
		"\u013e\u0143\7V\2\2\u013f\u0140\7G\2\2\u0140\u0142\7V\2\2\u0141\u013f"+
		"\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"-\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0148\5\\/\2\u0147\u0146\3\2\2\2\u0148"+
		"\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a/\3\2\2\2"+
		"\u014b\u0149\3\2\2\2\u014c\u014d\b\31\1\2\u014d\u0169\58\35\2\u014e\u014f"+
		"\7\"\2\2\u014f\u0169\5$\23\2\u0150\u0169\5\62\32\2\u0151\u0152\7@\2\2"+
		"\u0152\u0153\5\60\31\2\u0153\u0154\7A\2\2\u0154\u0169\3\2\2\2\u0155\u0169"+
		"\5\36\20\2\u0156\u0169\5P)\2\u0157\u0158\5,\27\2\u0158\u0159\7G\2\2\u0159"+
		"\u015a\7\21\2\2\u015a\u0169\3\2\2\2\u015b\u0169\5\64\33\2\u015c\u015d"+
		"\5Z.\2\u015d\u015e\5\60\31\f\u015e\u0169\3\2\2\2\u015f\u0169\5:\36\2\u0160"+
		"\u0169\5<\37\2\u0161\u0169\7\32\2\2\u0162\u0169\7$\2\2\u0163\u0169\7%"+
		"\2\2\u0164\u0169\7&\2\2\u0165\u0169\7\'\2\2\u0166\u0169\7(\2\2\u0167\u0169"+
		"\7V\2\2\u0168\u014c\3\2\2\2\u0168\u014e\3\2\2\2\u0168\u0150\3\2\2\2\u0168"+
		"\u0151\3\2\2\2\u0168\u0155\3\2\2\2\u0168\u0156\3\2\2\2\u0168\u0157\3\2"+
		"\2\2\u0168\u015b\3\2\2\2\u0168\u015c\3\2\2\2\u0168\u015f\3\2\2\2\u0168"+
		"\u0160\3\2\2\2\u0168\u0161\3\2\2\2\u0168\u0162\3\2\2\2\u0168\u0163\3\2"+
		"\2\2\u0168\u0164\3\2\2\2\u0168\u0165\3\2\2\2\u0168\u0166\3\2\2\2\u0168"+
		"\u0167\3\2\2\2\u0169\u017c\3\2\2\2\u016a\u016b\f\30\2\2\u016b\u016c\5"+
		"X-\2\u016c\u016d\5\60\31\31\u016d\u017b\3\2\2\2\u016e\u016f\f\27\2\2\u016f"+
		"\u0170\7G\2\2\u0170\u017b\58\35\2\u0171\u0173\f\25\2\2\u0172\u0174\7I"+
		"\2\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\3\2\2\2\u0175"+
		"\u0176\7\r\2\2\u0176\u017b\5(\25\2\u0177\u0178\f\24\2\2\u0178\u0179\7"+
		"G\2\2\u0179\u017b\7V\2\2\u017a\u016a\3\2\2\2\u017a\u016e\3\2\2\2\u017a"+
		"\u0171\3\2\2\2\u017a\u0177\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2"+
		"\2\2\u017c\u017d\3\2\2\2\u017d\61\3\2\2\2\u017e\u017c\3\2\2\2\u017f\u0180"+
		"\7\20\2\2\u0180\u0181\5(\25\2\u0181\u0182\7@\2\2\u0182\u0183\5> \2\u0183"+
		"\u0184\7A\2\2\u0184\63\3\2\2\2\u0185\u0186\7@\2\2\u0186\u0187\5(\25\2"+
		"\u0187\u0188\7A\2\2\u0188\u0189\5\60\31\2\u0189\65\3\2\2\2\u018a\u018b"+
		"\5\60\31\2\u018b\u018c\7<\2\2\u018c\u018d\5\60\31\2\u018d\67\3\2\2\2\u018e"+
		"\u018f\7V\2\2\u018f\u0190\7@\2\2\u0190\u0191\5> \2\u0191\u0192\7A\2\2"+
		"\u01929\3\2\2\2\u0193\u0194\7\20\2\2\u0194\u0195\5(\25\2\u0195\u0196\7"+
		"B\2\2\u0196\u0197\5\60\31\2\u0197\u0198\7C\2\2\u0198;\3\2\2\2\u0199\u019a"+
		"\7\20\2\2\u019a\u019b\5(\25\2\u019b\u019c\7B\2\2\u019c\u019d\7C\2\2\u019d"+
		"\u01a6\7>\2\2\u019e\u01a3\5\60\31\2\u019f\u01a0\7H\2\2\u01a0\u01a2\5\60"+
		"\31\2\u01a1\u019f\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u019e\3\2"+
		"\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\7?\2\2\u01a9"+
		"=\3\2\2\2\u01aa\u01af\5\60\31\2\u01ab\u01ac\7H\2\2\u01ac\u01ae\5\60\31"+
		"\2\u01ad\u01ab\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0"+
		"\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2\u01aa\3\2\2\2\u01b2"+
		"\u01b3\3\2\2\2\u01b3?\3\2\2\2\u01b4\u01b6\7\16\2\2\u01b5\u01b7\5\60\31"+
		"\2\u01b6\u01b5\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7A\3\2\2\2\u01b8\u01b9"+
		"\7\17\2\2\u01b9\u01bc\5\60\31\2\u01ba\u01bb\7D\2\2\u01bb\u01bd\7&\2\2"+
		"\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bdC\3\2\2\2\u01be\u01bf\7"+
		"#\2\2\u01bf\u01c0\7@\2\2\u01c0\u01c1\5\60\31\2\u01c1\u01c2\7A\2\2\u01c2"+
		"\u01c4\5$\23\2\u01c3\u01c5\5F$\2\u01c4\u01c3\3\2\2\2\u01c4\u01c5\3\2\2"+
		"\2\u01c5E\3\2\2\2\u01c6\u01c7\7 \2\2\u01c7\u01c8\5$\23\2\u01c8G\3\2\2"+
		"\2\u01c9\u01ca\7\35\2\2\u01ca\u01cb\7@\2\2\u01cb\u01cc\5\60\31\2\u01cc"+
		"\u01cd\7A\2\2\u01cd\u01ce\5$\23\2\u01ceI\3\2\2\2\u01cf\u01d0\7!\2\2\u01d0"+
		"\u01d1\7@\2\2\u01d1\u01d2\5\36\20\2\u01d2\u01d3\7E\2\2\u01d3\u01d4\5\60"+
		"\31\2\u01d4\u01d5\7E\2\2\u01d5\u01d6\5\60\31\2\u01d6\u01d7\7A\2\2\u01d7"+
		"\u01d8\5$\23\2\u01d8K\3\2\2\2\u01d9\u01da\7!\2\2\u01da\u01db\7@\2\2\u01db"+
		"\u01dc\5(\25\2\u01dc\u01dd\7V\2\2\u01dd\u01de\7D\2\2\u01de\u01df\5\60"+
		"\31\2\u01df\u01e0\7A\2\2\u01e0\u01e1\5$\23\2\u01e1M\3\2\2\2\u01e2\u01e3"+
		"\7\"\2\2\u01e3\u01e4\5\"\22\2\u01e4\u01e5\7\35\2\2\u01e5\u01e6\7@\2\2"+
		"\u01e6\u01e7\5\60\31\2\u01e7\u01e8\7A\2\2\u01e8\u01e9\7E\2\2\u01e9O\3"+
		"\2\2\2\u01ea\u01eb\7\34\2\2\u01eb\u01ec\7@\2\2\u01ec\u01ed\5\60\31\2\u01ed"+
		"\u01ee\7A\2\2\u01ee\u01f2\7>\2\2\u01ef\u01f1\5R*\2\u01f0\u01ef\3\2\2\2"+
		"\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f6"+
		"\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f7\5T+\2\u01f6\u01f5\3\2\2\2\u01f6"+
		"\u01f7\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\7?\2\2\u01f9Q\3\2\2\2\u01fa"+
		"\u01fb\7\37\2\2\u01fb\u01fc\5\60\31\2\u01fc\u0201\7K\2\2\u01fd\u0202\5"+
		"$\23\2\u01fe\u01ff\5\60\31\2\u01ff\u0200\7E\2\2\u0200\u0202\3\2\2\2\u0201"+
		"\u01fd\3\2\2\2\u0201\u01fe\3\2\2\2\u0202S\3\2\2\2\u0203\u0204\7\33\2\2"+
		"\u0204\u0209\7K\2\2\u0205\u020a\5$\23\2\u0206\u0207\5\60\31\2\u0207\u0208"+
		"\7E\2\2\u0208\u020a\3\2\2\2\u0209\u0205\3\2\2\2\u0209\u0206\3\2\2\2\u020a"+
		"U\3\2\2\2\u020b\u020c\7\36\2\2\u020c\u020d\5\60\31\2\u020d\u020e\7E\2"+
		"\2\u020eW\3\2\2\2\u020f\u0210\t\2\2\2\u0210Y\3\2\2\2\u0211\u0212\t\3\2"+
		"\2\u0212[\3\2\2\2\u0213\u0214\t\4\2\2\u0214]\3\2\2\2/_lqv~\u0081\u0087"+
		"\u008d\u0092\u009d\u00a7\u00b1\u00bc\u00bf\u00cb\u00cf\u00d6\u00dd\u00e4"+
		"\u00e7\u00ed\u010c\u0112\u011b\u0125\u012a\u0131\u013c\u0143\u0149\u0168"+
		"\u0173\u017a\u017c\u01a3\u01a6\u01af\u01b2\u01b6\u01bc\u01c4\u01f2\u01f6"+
		"\u0201\u0209";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}