// Generated from C:/ezz/Mods/CyclicCompiler/src/main/resources\CyclicLang.g4 by ANTLR 4.9.2
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
		STATIC=7, FINAL=8, INSTANCEOF=9, RETURN=10, ASSERT=11, NEW=12, INTERFACE=13, 
		SINGLE=14, CLASS=15, ENUM=16, IMPORT=17, PACKAGE=18, EXTENDS=19, IMPLEMENTS=20, 
		THIS=21, DEFAULT=22, SWITCH=23, WHILE=24, YIELD=25, CASE=26, ELSE=27, 
		FOR=28, DO=29, IF=30, DECLIT=31, INTLIT=32, STRLIT=33, BOOLLIT=34, NULL=35, 
		AND=36, OR=37, UP=38, STAR=39, SLASH=40, PLUS=41, MINUS=42, PERCENT=43, 
		AT=44, EQUAL=45, INEQUAL=46, GREATEREQ=47, LESSEREQ=48, GREATER=49, LESSER=50, 
		ASSIGN=51, LBRACE=52, RBRACE=53, LPAREN=54, RPAREN=55, LSQUAR=56, RSQUAR=57, 
		COLON=58, SEMICOLON=59, QUOTE=60, DOT=61, COMMA=62, EXCLAMATION=63, QUESTION=64, 
		DASHARROW=65, EQARROW=66, INT=67, DEC=68, BYTE=69, BOOL=70, VOID=71, VAR=72, 
		VAL=73, TRUE=74, FALSE=75, ID=76, DIGIT=77, NONDIGIT=78, SING_COMMENT=79, 
		WS=80, UNMATCHED=81;
	public static final int
		RULE_file = 0, RULE_packageDecl = 1, RULE_imports = 2, RULE_importDecl = 3, 
		RULE_classDecl = 4, RULE_objectExtends = 5, RULE_objectImplements = 6, 
		RULE_objectType = 7, RULE_member = 8, RULE_constructor = 9, RULE_init = 10, 
		RULE_function = 11, RULE_functionBlock = 12, RULE_functionArrow = 13, 
		RULE_varDecl = 14, RULE_parameters = 15, RULE_block = 16, RULE_statement = 17, 
		RULE_annotation = 18, RULE_type = 19, RULE_rawType = 20, RULE_id = 21, 
		RULE_modifiers = 22, RULE_value = 23, RULE_initialisation = 24, RULE_cast = 25, 
		RULE_invert = 26, RULE_varAssignment = 27, RULE_call = 28, RULE_newArray = 29, 
		RULE_newListedArray = 30, RULE_arguments = 31, RULE_returnStatement = 32, 
		RULE_assertStatement = 33, RULE_ifStatement = 34, RULE_elseStatement = 35, 
		RULE_whileStatement = 36, RULE_forStatement = 37, RULE_doWhile = 38, RULE_switchStatement = 39, 
		RULE_caseClause = 40, RULE_defaultClause = 41, RULE_yieldStatement = 42, 
		RULE_binaryop = 43, RULE_modifier = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "packageDecl", "imports", "importDecl", "classDecl", "objectExtends", 
			"objectImplements", "objectType", "member", "constructor", "init", "function", 
			"functionBlock", "functionArrow", "varDecl", "parameters", "block", "statement", 
			"annotation", "type", "rawType", "id", "modifiers", "value", "initialisation", 
			"cast", "invert", "varAssignment", "call", "newArray", "newListedArray", 
			"arguments", "returnStatement", "assertStatement", "ifStatement", "elseStatement", 
			"whileStatement", "forStatement", "doWhile", "switchStatement", "caseClause", 
			"defaultClause", "yieldStatement", "binaryop", "modifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'protected'", "'private'", "'public'", "'synchronised'", "'abstract'", 
			"'native'", "'static'", "'final'", "'instanceof'", "'return'", "'assert'", 
			"'new'", "'interface'", "'single'", "'class'", "'enum'", "'import'", 
			"'package'", "'extends'", "'implements'", "'this'", "'default'", "'switch'", 
			"'while'", "'yield'", "'case'", "'else'", "'for'", "'do'", "'if'", null, 
			null, null, null, "'null'", "'&&'", "'||'", "'^'", "'*'", "'/'", "'+'", 
			"'-'", "'%'", "'@'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'='", 
			"'{'", "'}'", "'('", "')'", "'['", "']'", "':'", "';'", "'\"'", "'.'", 
			"','", "'!'", "'?'", "'->'", "'=>'", "'int'", "'float'", "'byte'", "'boolean'", 
			"'void'", "'var'", "'val'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROTECTED", "PRIVATE", "PUBLIC", "SYNCHRONISED", "ABSTRACT", "NATIVE", 
			"STATIC", "FINAL", "INSTANCEOF", "RETURN", "ASSERT", "NEW", "INTERFACE", 
			"SINGLE", "CLASS", "ENUM", "IMPORT", "PACKAGE", "EXTENDS", "IMPLEMENTS", 
			"THIS", "DEFAULT", "SWITCH", "WHILE", "YIELD", "CASE", "ELSE", "FOR", 
			"DO", "IF", "DECLIT", "INTLIT", "STRLIT", "BOOLLIT", "NULL", "AND", "OR", 
			"UP", "STAR", "SLASH", "PLUS", "MINUS", "PERCENT", "AT", "EQUAL", "INEQUAL", 
			"GREATEREQ", "LESSEREQ", "GREATER", "LESSER", "ASSIGN", "LBRACE", "RBRACE", 
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
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(90);
				packageDecl();
				}
			}

			setState(93);
			imports();
			setState(94);
			classDecl();
			setState(95);
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
			setState(97);
			match(PACKAGE);
			setState(98);
			id();
			setState(99);
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
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(101);
				importDecl();
				}
				}
				setState(106);
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
			setState(107);
			match(IMPORT);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(108);
				match(STATIC);
				}
			}

			setState(111);
			id();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(112);
				match(DOT);
				setState(113);
				match(STAR);
				}
			}

			setState(116);
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
			setState(118);
			modifiers();
			setState(119);
			objectType();
			setState(120);
			match(ID);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(121);
				objectExtends();
				}
			}

			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(124);
				objectImplements();
				}
			}

			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(127);
				match(LBRACE);
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(128);
						annotation();
						}
						} 
					}
					setState(133);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << INTERFACE) | (1L << SINGLE) | (1L << CLASS) | (1L << ENUM) | (1L << AT) | (1L << LBRACE) | (1L << SEMICOLON))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (INT - 67)) | (1L << (DEC - 67)) | (1L << (BYTE - 67)) | (1L << (BOOL - 67)) | (1L << (VOID - 67)) | (1L << (VAR - 67)) | (1L << (VAL - 67)) | (1L << (ID - 67)))) != 0)) {
					{
					{
					setState(134);
					member();
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(140);
				match(RBRACE);
				}
				break;
			case SEMICOLON:
				{
				setState(141);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(EXTENDS);
			setState(145);
			type(0);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(146);
				match(COMMA);
				setState(147);
				type(0);
				}
				}
				setState(152);
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
			setState(153);
			match(IMPLEMENTS);
			setState(154);
			type(0);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(155);
				match(COMMA);
				setState(156);
				type(0);
				}
				}
				setState(161);
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
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(CLASS);
				}
				break;
			case INTERFACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(INTERFACE);
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				match(ENUM);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				match(AT);
				setState(166);
				match(INTERFACE);
				}
				break;
			case SINGLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(167);
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
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				function();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				constructor();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				varDecl();
				setState(173);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				classDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				init();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(177);
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
			setState(180);
			modifiers();
			setState(181);
			type(0);
			setState(182);
			match(LPAREN);
			setState(183);
			parameters();
			setState(184);
			match(RPAREN);
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(185);
				block();
				}
				break;
			case DASHARROW:
				{
				setState(186);
				match(DASHARROW);
				setState(187);
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
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(190);
				match(STATIC);
				}
			}

			setState(193);
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
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
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
			setState(195);
			modifiers();
			setState(196);
			type(0);
			setState(197);
			id();
			setState(198);
			match(LPAREN);
			setState(199);
			parameters();
			setState(200);
			match(RPAREN);
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
			case SEMICOLON:
				{
				setState(201);
				functionBlock();
				}
				break;
			case DASHARROW:
				{
				setState(202);
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
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(205);
				block();
				}
				break;
			case SEMICOLON:
				{
				setState(206);
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
			setState(209);
			match(DASHARROW);
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(210);
				value(0);
				setState(211);
				match(SEMICOLON);
				}
				break;
			case 2:
				{
				setState(213);
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
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
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
			setState(216);
			modifiers();
			setState(217);
			type(0);
			setState(218);
			id();
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(219);
				match(ASSIGN);
				setState(220);
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
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << AT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (INT - 67)) | (1L << (DEC - 67)) | (1L << (BYTE - 67)) | (1L << (BOOL - 67)) | (1L << (VOID - 67)) | (1L << (VAR - 67)) | (1L << (VAL - 67)) | (1L << (ID - 67)))) != 0)) {
				{
				setState(223);
				varDecl();
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(224);
					match(COMMA);
					setState(225);
					varDecl();
					}
					}
					setState(230);
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
			setState(233);
			match(LBRACE);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << RETURN) | (1L << ASSERT) | (1L << NEW) | (1L << THIS) | (1L << SWITCH) | (1L << WHILE) | (1L << YIELD) | (1L << FOR) | (1L << DO) | (1L << IF) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << AT) | (1L << LBRACE) | (1L << LPAREN) | (1L << SEMICOLON) | (1L << EXCLAMATION))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (INT - 67)) | (1L << (DEC - 67)) | (1L << (BYTE - 67)) | (1L << (BOOL - 67)) | (1L << (VOID - 67)) | (1L << (VAR - 67)) | (1L << (VAL - 67)) | (1L << (ID - 67)))) != 0)) {
				{
				{
				setState(234);
				statement();
				}
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(240);
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
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CyclicLangParser.SEMICOLON, 0); }
		public VarAssignmentContext varAssignment() {
			return getRuleContext(VarAssignmentContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public AssertStatementContext assertStatement() {
			return getRuleContext(AssertStatementContext.class,0);
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
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				varDecl();
				setState(244);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				varAssignment();
				setState(247);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				returnStatement();
				setState(250);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(252);
				assertStatement();
				setState(253);
				match(SEMICOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(255);
				initialisation();
				setState(256);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(258);
				ifStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(259);
				whileStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(260);
				forStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(261);
				switchStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(262);
				doWhile();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(263);
				yieldStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(267);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(264);
					value(0);
					setState(265);
					match(DOT);
					}
					break;
				}
				setState(269);
				call();
				setState(270);
				match(SEMICOLON);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(272);
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
			setState(275);
			match(AT);
			setState(276);
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
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(279);
				annotation();
				}
				}
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(285);
			rawType();
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(286);
				match(LESSER);
				setState(287);
				type(0);
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(288);
					match(COMMA);
					setState(289);
					type(0);
					}
					}
					setState(294);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(295);
				match(GREATER);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(304);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(299);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(300);
					match(LSQUAR);
					setState(301);
					match(RSQUAR);
					}
					} 
				}
				setState(306);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
			setState(315);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				match(INT);
				}
				break;
			case DEC:
				_localctx = new DecTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				match(DEC);
				}
				break;
			case BYTE:
				_localctx = new ByteTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				match(BYTE);
				}
				break;
			case BOOL:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(310);
				match(BOOL);
				}
				break;
			case VOID:
				_localctx = new VoidTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(311);
				match(VOID);
				}
				break;
			case VAR:
				_localctx = new InferTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(312);
				match(VAR);
				}
				break;
			case VAL:
				_localctx = new InferFinalTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(313);
				match(VAL);
				}
				break;
			case ID:
				_localctx = new IdTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(314);
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
			setState(317);
			match(ID);
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(318);
					match(DOT);
					setState(319);
					match(ID);
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL))) != 0)) {
				{
				{
				setState(325);
				modifier();
				}
				}
				setState(330);
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
	public static class IdValueContext extends ValueContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public IdValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterIdValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitIdValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitIdValue(this);
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
	public static class InverseValueContext extends ValueContext {
		public InvertContext invert() {
			return getRuleContext(InvertContext.class,0);
		}
		public InverseValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterInverseValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitInverseValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInverseValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InlineAssignmentContext extends ValueContext {
		public VarAssignmentContext varAssignment() {
			return getRuleContext(VarAssignmentContext.class,0);
		}
		public InlineAssignmentContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterInlineAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitInlineAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInlineAssignment(this);
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
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				_localctx = new FunctionValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(332);
				call();
				}
				break;
			case 2:
				{
				_localctx = new DoValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(333);
				match(DO);
				setState(334);
				statement();
				}
				break;
			case 3:
				{
				_localctx = new InitialisationValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(335);
				initialisation();
				}
				break;
			case 4:
				{
				_localctx = new ParenValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(336);
				match(LPAREN);
				setState(337);
				value(0);
				setState(338);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new InlineDeclerationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(340);
				varDecl();
				}
				break;
			case 6:
				{
				_localctx = new InlineAssignmentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(341);
				varAssignment();
				}
				break;
			case 7:
				{
				_localctx = new SwitchValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(342);
				switchStatement();
				}
				break;
			case 8:
				{
				_localctx = new ClassValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(343);
				id();
				setState(344);
				match(DOT);
				setState(345);
				match(CLASS);
				}
				break;
			case 9:
				{
				_localctx = new CastValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(347);
				cast();
				}
				break;
			case 10:
				{
				_localctx = new InverseValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(348);
				invert();
				}
				break;
			case 11:
				{
				_localctx = new NewArrayValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(349);
				newArray();
				}
				break;
			case 12:
				{
				_localctx = new NewListedArrayValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(350);
				newListedArray();
				}
				break;
			case 13:
				{
				_localctx = new ThisValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(351);
				match(THIS);
				}
				break;
			case 14:
				{
				_localctx = new DecLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(352);
				match(DECLIT);
				}
				break;
			case 15:
				{
				_localctx = new IntLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(353);
				match(INTLIT);
				}
				break;
			case 16:
				{
				_localctx = new StrLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(354);
				match(STRLIT);
				}
				break;
			case 17:
				{
				_localctx = new BoolLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(355);
				match(BOOLLIT);
				}
				break;
			case 18:
				{
				_localctx = new NullLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(356);
				match(NULL);
				}
				break;
			case 19:
				{
				_localctx = new IdValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(357);
				id();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(375);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(373);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
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
					}
					} 
				}
				setState(377);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
			setState(378);
			match(NEW);
			setState(379);
			type(0);
			setState(380);
			match(LPAREN);
			setState(381);
			arguments();
			setState(382);
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
			setState(384);
			match(LPAREN);
			setState(385);
			type(0);
			setState(386);
			match(RPAREN);
			setState(387);
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

	public static class InvertContext extends ParserRuleContext {
		public TerminalNode EXCLAMATION() { return getToken(CyclicLangParser.EXCLAMATION, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public InvertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).enterInvert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CyclicLangListener ) ((CyclicLangListener)listener).exitInvert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CyclicLangVisitor ) return ((CyclicLangVisitor<? extends T>)visitor).visitInvert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvertContext invert() throws RecognitionException {
		InvertContext _localctx = new InvertContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_invert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(EXCLAMATION);
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
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CyclicLangParser.ASSIGN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
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
		enterRule(_localctx, 54, RULE_varAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			id();
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
		enterRule(_localctx, 56, RULE_call);
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
		enterRule(_localctx, 58, RULE_newArray);
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
		enterRule(_localctx, 60, RULE_newListedArray);
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << NEW) | (1L << THIS) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << AT) | (1L << LPAREN) | (1L << EXCLAMATION))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (INT - 67)) | (1L << (DEC - 67)) | (1L << (BYTE - 67)) | (1L << (BOOL - 67)) | (1L << (VOID - 67)) | (1L << (VAR - 67)) | (1L << (VAL - 67)) | (1L << (ID - 67)))) != 0)) {
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
		enterRule(_localctx, 62, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << NEW) | (1L << THIS) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << AT) | (1L << LPAREN) | (1L << EXCLAMATION))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (INT - 67)) | (1L << (DEC - 67)) | (1L << (BYTE - 67)) | (1L << (BOOL - 67)) | (1L << (VOID - 67)) | (1L << (VAR - 67)) | (1L << (VAL - 67)) | (1L << (ID - 67)))) != 0)) {
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
		enterRule(_localctx, 64, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			match(RETURN);
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL) | (1L << NEW) | (1L << THIS) | (1L << SWITCH) | (1L << DO) | (1L << DECLIT) | (1L << INTLIT) | (1L << STRLIT) | (1L << BOOLLIT) | (1L << NULL) | (1L << AT) | (1L << LPAREN) | (1L << EXCLAMATION))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (INT - 67)) | (1L << (DEC - 67)) | (1L << (BYTE - 67)) | (1L << (BOOL - 67)) | (1L << (VOID - 67)) | (1L << (VAR - 67)) | (1L << (VAL - 67)) | (1L << (ID - 67)))) != 0)) {
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
		enterRule(_localctx, 66, RULE_assertStatement);
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
		enterRule(_localctx, 68, RULE_ifStatement);
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
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
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
		enterRule(_localctx, 70, RULE_elseStatement);
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
		enterRule(_localctx, 72, RULE_whileStatement);
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
		enterRule(_localctx, 74, RULE_forStatement);
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
			setState(471);
			match(DO);
			setState(472);
			block();
			setState(473);
			match(WHILE);
			setState(474);
			match(LPAREN);
			setState(475);
			value(0);
			setState(476);
			match(RPAREN);
			setState(477);
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
			setState(479);
			match(SWITCH);
			setState(480);
			match(LPAREN);
			setState(481);
			value(0);
			setState(482);
			match(RPAREN);
			setState(483);
			match(LBRACE);
			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(484);
				caseClause();
				}
				}
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(490);
				defaultClause();
				}
			}

			setState(493);
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
			setState(495);
			match(CASE);
			setState(496);
			value(0);
			setState(497);
			match(DASHARROW);
			setState(502);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(498);
				statement();
				}
				break;
			case 2:
				{
				setState(499);
				value(0);
				setState(500);
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
			setState(504);
			match(DEFAULT);
			setState(505);
			match(DASHARROW);
			setState(510);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(506);
				statement();
				}
				break;
			case 2:
				{
				setState(507);
				value(0);
				setState(508);
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
			setState(512);
			match(YIELD);
			setState(513);
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
			setState(515);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << UP) | (1L << STAR) | (1L << SLASH) | (1L << PLUS) | (1L << MINUS) | (1L << PERCENT) | (1L << EQUAL) | (1L << INEQUAL) | (1L << GREATEREQ) | (1L << LESSEREQ) | (1L << GREATER) | (1L << LESSER))) != 0)) ) {
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
		enterRule(_localctx, 88, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTECTED) | (1L << PRIVATE) | (1L << PUBLIC) | (1L << SYNCHRONISED) | (1L << ABSTRACT) | (1L << NATIVE) | (1L << STATIC) | (1L << FINAL))) != 0)) ) {
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3S\u020a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\5\2^\n\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\7\4"+
		"i\n\4\f\4\16\4l\13\4\3\5\3\5\5\5p\n\5\3\5\3\5\3\5\5\5u\n\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\5\6}\n\6\3\6\5\6\u0080\n\6\3\6\3\6\7\6\u0084\n\6\f\6\16\6"+
		"\u0087\13\6\3\6\7\6\u008a\n\6\f\6\16\6\u008d\13\6\3\6\3\6\5\6\u0091\n"+
		"\6\3\7\3\7\3\7\3\7\7\7\u0097\n\7\f\7\16\7\u009a\13\7\3\b\3\b\3\b\3\b\7"+
		"\b\u00a0\n\b\f\b\16\b\u00a3\13\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ab\n\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b5\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00bf\n\13\3\f\5\f\u00c2\n\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u00ce\n\r\3\16\3\16\5\16\u00d2\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00d9\n\17\3\20\3\20\3\20\3\20\3\20\5\20\u00e0\n"+
		"\20\3\21\3\21\3\21\7\21\u00e5\n\21\f\21\16\21\u00e8\13\21\5\21\u00ea\n"+
		"\21\3\22\3\22\7\22\u00ee\n\22\f\22\16\22\u00f1\13\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u010e\n\23\3\23"+
		"\3\23\3\23\3\23\5\23\u0114\n\23\3\24\3\24\3\24\3\25\3\25\7\25\u011b\n"+
		"\25\f\25\16\25\u011e\13\25\3\25\3\25\3\25\3\25\3\25\7\25\u0125\n\25\f"+
		"\25\16\25\u0128\13\25\3\25\3\25\5\25\u012c\n\25\3\25\3\25\3\25\7\25\u0131"+
		"\n\25\f\25\16\25\u0134\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5"+
		"\26\u013e\n\26\3\27\3\27\3\27\7\27\u0143\n\27\f\27\16\27\u0146\13\27\3"+
		"\30\7\30\u0149\n\30\f\30\16\30\u014c\13\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0169\n\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0174\n\31\3\31\3\31\7\31\u0178\n"+
		"\31\f\31\16\31\u017b\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \7 \u01a2\n \f "+
		"\16 \u01a5\13 \5 \u01a7\n \3 \3 \3!\3!\3!\7!\u01ae\n!\f!\16!\u01b1\13"+
		"!\5!\u01b3\n!\3\"\3\"\5\"\u01b7\n\"\3#\3#\3#\3#\5#\u01bd\n#\3$\3$\3$\3"+
		"$\3$\3$\5$\u01c5\n$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\7)\u01e8\n"+
		")\f)\16)\u01eb\13)\3)\5)\u01ee\n)\3)\3)\3*\3*\3*\3*\3*\3*\3*\5*\u01f9"+
		"\n*\3+\3+\3+\3+\3+\3+\5+\u0201\n+\3,\3,\3,\3-\3-\3.\3.\3.\2\4(\60/\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTVXZ\2\4\4\2&-/\64\3\2\3\n\2\u0235\2]\3\2\2\2\4c\3\2\2\2\6j\3\2\2\2\b"+
		"m\3\2\2\2\nx\3\2\2\2\f\u0092\3\2\2\2\16\u009b\3\2\2\2\20\u00aa\3\2\2\2"+
		"\22\u00b4\3\2\2\2\24\u00b6\3\2\2\2\26\u00c1\3\2\2\2\30\u00c5\3\2\2\2\32"+
		"\u00d1\3\2\2\2\34\u00d3\3\2\2\2\36\u00da\3\2\2\2 \u00e9\3\2\2\2\"\u00eb"+
		"\3\2\2\2$\u0113\3\2\2\2&\u0115\3\2\2\2(\u0118\3\2\2\2*\u013d\3\2\2\2,"+
		"\u013f\3\2\2\2.\u014a\3\2\2\2\60\u0168\3\2\2\2\62\u017c\3\2\2\2\64\u0182"+
		"\3\2\2\2\66\u0187\3\2\2\28\u018a\3\2\2\2:\u018e\3\2\2\2<\u0193\3\2\2\2"+
		">\u0199\3\2\2\2@\u01b2\3\2\2\2B\u01b4\3\2\2\2D\u01b8\3\2\2\2F\u01be\3"+
		"\2\2\2H\u01c6\3\2\2\2J\u01c9\3\2\2\2L\u01cf\3\2\2\2N\u01d9\3\2\2\2P\u01e1"+
		"\3\2\2\2R\u01f1\3\2\2\2T\u01fa\3\2\2\2V\u0202\3\2\2\2X\u0205\3\2\2\2Z"+
		"\u0207\3\2\2\2\\^\5\4\3\2]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\5\6\4\2`a\5"+
		"\n\6\2ab\7\2\2\3b\3\3\2\2\2cd\7\24\2\2de\5,\27\2ef\7=\2\2f\5\3\2\2\2g"+
		"i\5\b\5\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\7\3\2\2\2lj\3\2\2\2"+
		"mo\7\23\2\2np\7\t\2\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2qt\5,\27\2rs\7?\2\2"+
		"su\7)\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7=\2\2w\t\3\2\2\2xy\5.\30\2"+
		"yz\5\20\t\2z|\7N\2\2{}\5\f\7\2|{\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~\u0080"+
		"\5\16\b\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0090\3\2\2\2\u0081\u0085"+
		"\7\66\2\2\u0082\u0084\5&\24\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2"+
		"\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008b\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0088\u008a\5\22\n\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2"+
		"\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b"+
		"\3\2\2\2\u008e\u0091\7\67\2\2\u008f\u0091\7=\2\2\u0090\u0081\3\2\2\2\u0090"+
		"\u008f\3\2\2\2\u0091\13\3\2\2\2\u0092\u0093\7\25\2\2\u0093\u0098\5(\25"+
		"\2\u0094\u0095\7@\2\2\u0095\u0097\5(\25\2\u0096\u0094\3\2\2\2\u0097\u009a"+
		"\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\r\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009c\7\26\2\2\u009c\u00a1\5(\25\2\u009d\u009e\7"+
		"@\2\2\u009e\u00a0\5(\25\2\u009f\u009d\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\17\3\2\2\2\u00a3\u00a1\3\2\2"+
		"\2\u00a4\u00ab\7\21\2\2\u00a5\u00ab\7\17\2\2\u00a6\u00ab\7\22\2\2\u00a7"+
		"\u00a8\7.\2\2\u00a8\u00ab\7\17\2\2\u00a9\u00ab\7\20\2\2\u00aa\u00a4\3"+
		"\2\2\2\u00aa\u00a5\3\2\2\2\u00aa\u00a6\3\2\2\2\u00aa\u00a7\3\2\2\2\u00aa"+
		"\u00a9\3\2\2\2\u00ab\21\3\2\2\2\u00ac\u00b5\5\30\r\2\u00ad\u00b5\5\24"+
		"\13\2\u00ae\u00af\5\36\20\2\u00af\u00b0\7=\2\2\u00b0\u00b5\3\2\2\2\u00b1"+
		"\u00b5\5\n\6\2\u00b2\u00b5\5\26\f\2\u00b3\u00b5\7=\2\2\u00b4\u00ac\3\2"+
		"\2\2\u00b4\u00ad\3\2\2\2\u00b4\u00ae\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\23\3\2\2\2\u00b6\u00b7\5.\30"+
		"\2\u00b7\u00b8\5(\25\2\u00b8\u00b9\78\2\2\u00b9\u00ba\5 \21\2\u00ba\u00be"+
		"\79\2\2\u00bb\u00bf\5\"\22\2\u00bc\u00bd\7C\2\2\u00bd\u00bf\5$\23\2\u00be"+
		"\u00bb\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\25\3\2\2\2\u00c0\u00c2\7\t\2"+
		"\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4"+
		"\5\"\22\2\u00c4\27\3\2\2\2\u00c5\u00c6\5.\30\2\u00c6\u00c7\5(\25\2\u00c7"+
		"\u00c8\5,\27\2\u00c8\u00c9\78\2\2\u00c9\u00ca\5 \21\2\u00ca\u00cd\79\2"+
		"\2\u00cb\u00ce\5\32\16\2\u00cc\u00ce\5\34\17\2\u00cd\u00cb\3\2\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00ce\31\3\2\2\2\u00cf\u00d2\5\"\22\2\u00d0\u00d2\7=\2"+
		"\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\33\3\2\2\2\u00d3\u00d8"+
		"\7C\2\2\u00d4\u00d5\5\60\31\2\u00d5\u00d6\7=\2\2\u00d6\u00d9\3\2\2\2\u00d7"+
		"\u00d9\5$\23\2\u00d8\u00d4\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\35\3\2\2"+
		"\2\u00da\u00db\5.\30\2\u00db\u00dc\5(\25\2\u00dc\u00df\5,\27\2\u00dd\u00de"+
		"\7\65\2\2\u00de\u00e0\5\60\31\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2"+
		"\2\u00e0\37\3\2\2\2\u00e1\u00e6\5\36\20\2\u00e2\u00e3\7@\2\2\u00e3\u00e5"+
		"\5\36\20\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2"+
		"\u00e6\u00e7\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00e1"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea!\3\2\2\2\u00eb\u00ef\7\66\2\2\u00ec"+
		"\u00ee\5$\23\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2"+
		"\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2"+
		"\u00f3\7\67\2\2\u00f3#\3\2\2\2\u00f4\u0114\5\"\22\2\u00f5\u00f6\5\36\20"+
		"\2\u00f6\u00f7\7=\2\2\u00f7\u0114\3\2\2\2\u00f8\u00f9\58\35\2\u00f9\u00fa"+
		"\7=\2\2\u00fa\u0114\3\2\2\2\u00fb\u00fc\5B\"\2\u00fc\u00fd\7=\2\2\u00fd"+
		"\u0114\3\2\2\2\u00fe\u00ff\5D#\2\u00ff\u0100\7=\2\2\u0100\u0114\3\2\2"+
		"\2\u0101\u0102\5\62\32\2\u0102\u0103\7=\2\2\u0103\u0114\3\2\2\2\u0104"+
		"\u0114\5F$\2\u0105\u0114\5J&\2\u0106\u0114\5L\'\2\u0107\u0114\5P)\2\u0108"+
		"\u0114\5N(\2\u0109\u0114\5V,\2\u010a\u010b\5\60\31\2\u010b\u010c\7?\2"+
		"\2\u010c\u010e\3\2\2\2\u010d\u010a\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\u0110\5:\36\2\u0110\u0111\7=\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0114\7=\2\2\u0113\u00f4\3\2\2\2\u0113\u00f5\3\2\2\2\u0113\u00f8\3\2"+
		"\2\2\u0113\u00fb\3\2\2\2\u0113\u00fe\3\2\2\2\u0113\u0101\3\2\2\2\u0113"+
		"\u0104\3\2\2\2\u0113\u0105\3\2\2\2\u0113\u0106\3\2\2\2\u0113\u0107\3\2"+
		"\2\2\u0113\u0108\3\2\2\2\u0113\u0109\3\2\2\2\u0113\u010d\3\2\2\2\u0113"+
		"\u0112\3\2\2\2\u0114%\3\2\2\2\u0115\u0116\7.\2\2\u0116\u0117\5,\27\2\u0117"+
		"\'\3\2\2\2\u0118\u011c\b\25\1\2\u0119\u011b\5&\24\2\u011a\u0119\3\2\2"+
		"\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011f"+
		"\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u012b\5*\26\2\u0120\u0121\7\64\2\2"+
		"\u0121\u0126\5(\25\2\u0122\u0123\7@\2\2\u0123\u0125\5(\25\2\u0124\u0122"+
		"\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0129\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012a\7\63\2\2\u012a\u012c\3"+
		"\2\2\2\u012b\u0120\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u0132\3\2\2\2\u012d"+
		"\u012e\f\3\2\2\u012e\u012f\7:\2\2\u012f\u0131\7;\2\2\u0130\u012d\3\2\2"+
		"\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133)"+
		"\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u013e\7E\2\2\u0136\u013e\7F\2\2\u0137"+
		"\u013e\7G\2\2\u0138\u013e\7H\2\2\u0139\u013e\7I\2\2\u013a\u013e\7J\2\2"+
		"\u013b\u013e\7K\2\2\u013c\u013e\5,\27\2\u013d\u0135\3\2\2\2\u013d\u0136"+
		"\3\2\2\2\u013d\u0137\3\2\2\2\u013d\u0138\3\2\2\2\u013d\u0139\3\2\2\2\u013d"+
		"\u013a\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013c\3\2\2\2\u013e+\3\2\2\2"+
		"\u013f\u0144\7N\2\2\u0140\u0141\7?\2\2\u0141\u0143\7N\2\2\u0142\u0140"+
		"\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"-\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0149\5Z.\2\u0148\u0147\3\2\2\2\u0149"+
		"\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b/\3\2\2\2"+
		"\u014c\u014a\3\2\2\2\u014d\u014e\b\31\1\2\u014e\u0169\5:\36\2\u014f\u0150"+
		"\7\37\2\2\u0150\u0169\5$\23\2\u0151\u0169\5\62\32\2\u0152\u0153\78\2\2"+
		"\u0153\u0154\5\60\31\2\u0154\u0155\79\2\2\u0155\u0169\3\2\2\2\u0156\u0169"+
		"\5\36\20\2\u0157\u0169\58\35\2\u0158\u0169\5P)\2\u0159\u015a\5,\27\2\u015a"+
		"\u015b\7?\2\2\u015b\u015c\7\21\2\2\u015c\u0169\3\2\2\2\u015d\u0169\5\64"+
		"\33\2\u015e\u0169\5\66\34\2\u015f\u0169\5<\37\2\u0160\u0169\5> \2\u0161"+
		"\u0169\7\27\2\2\u0162\u0169\7!\2\2\u0163\u0169\7\"\2\2\u0164\u0169\7#"+
		"\2\2\u0165\u0169\7$\2\2\u0166\u0169\7%\2\2\u0167\u0169\5,\27\2\u0168\u014d"+
		"\3\2\2\2\u0168\u014f\3\2\2\2\u0168\u0151\3\2\2\2\u0168\u0152\3\2\2\2\u0168"+
		"\u0156\3\2\2\2\u0168\u0157\3\2\2\2\u0168\u0158\3\2\2\2\u0168\u0159\3\2"+
		"\2\2\u0168\u015d\3\2\2\2\u0168\u015e\3\2\2\2\u0168\u015f\3\2\2\2\u0168"+
		"\u0160\3\2\2\2\u0168\u0161\3\2\2\2\u0168\u0162\3\2\2\2\u0168\u0163\3\2"+
		"\2\2\u0168\u0164\3\2\2\2\u0168\u0165\3\2\2\2\u0168\u0166\3\2\2\2\u0168"+
		"\u0167\3\2\2\2\u0169\u0179\3\2\2\2\u016a\u016b\f\30\2\2\u016b\u016c\5"+
		"X-\2\u016c\u016d\5\60\31\31\u016d\u0178\3\2\2\2\u016e\u016f\f\27\2\2\u016f"+
		"\u0170\7?\2\2\u0170\u0178\5:\36\2\u0171\u0173\f\25\2\2\u0172\u0174\7A"+
		"\2\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\3\2\2\2\u0175"+
		"\u0176\7\13\2\2\u0176\u0178\5(\25\2\u0177\u016a\3\2\2\2\u0177\u016e\3"+
		"\2\2\2\u0177\u0171\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179"+
		"\u017a\3\2\2\2\u017a\61\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d\7\16\2"+
		"\2\u017d\u017e\5(\25\2\u017e\u017f\78\2\2\u017f\u0180\5@!\2\u0180\u0181"+
		"\79\2\2\u0181\63\3\2\2\2\u0182\u0183\78\2\2\u0183\u0184\5(\25\2\u0184"+
		"\u0185\79\2\2\u0185\u0186\5\60\31\2\u0186\65\3\2\2\2\u0187\u0188\7A\2"+
		"\2\u0188\u0189\5\60\31\2\u0189\67\3\2\2\2\u018a\u018b\5,\27\2\u018b\u018c"+
		"\7\65\2\2\u018c\u018d\5\60\31\2\u018d9\3\2\2\2\u018e\u018f\7N\2\2\u018f"+
		"\u0190\78\2\2\u0190\u0191\5@!\2\u0191\u0192\79\2\2\u0192;\3\2\2\2\u0193"+
		"\u0194\7\16\2\2\u0194\u0195\5(\25\2\u0195\u0196\7:\2\2\u0196\u0197\5\60"+
		"\31\2\u0197\u0198\7;\2\2\u0198=\3\2\2\2\u0199\u019a\7\16\2\2\u019a\u019b"+
		"\5(\25\2\u019b\u019c\7:\2\2\u019c\u019d\7;\2\2\u019d\u01a6\7\66\2\2\u019e"+
		"\u01a3\5\60\31\2\u019f\u01a0\7@\2\2\u01a0\u01a2\5\60\31\2\u01a1\u019f"+
		"\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u019e\3\2\2\2\u01a6\u01a7\3\2"+
		"\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\7\67\2\2\u01a9?\3\2\2\2\u01aa\u01af"+
		"\5\60\31\2\u01ab\u01ac\7@\2\2\u01ac\u01ae\5\60\31\2\u01ad\u01ab\3\2\2"+
		"\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b3"+
		"\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2\u01aa\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"A\3\2\2\2\u01b4\u01b6\7\f\2\2\u01b5\u01b7\5\60\31\2\u01b6\u01b5\3\2\2"+
		"\2\u01b6\u01b7\3\2\2\2\u01b7C\3\2\2\2\u01b8\u01b9\7\r\2\2\u01b9\u01bc"+
		"\5\60\31\2\u01ba\u01bb\7<\2\2\u01bb\u01bd\7#\2\2\u01bc\u01ba\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bdE\3\2\2\2\u01be\u01bf\7 \2\2\u01bf\u01c0\78\2\2\u01c0"+
		"\u01c1\5\60\31\2\u01c1\u01c2\79\2\2\u01c2\u01c4\5$\23\2\u01c3\u01c5\5"+
		"H%\2\u01c4\u01c3\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5G\3\2\2\2\u01c6\u01c7"+
		"\7\35\2\2\u01c7\u01c8\5$\23\2\u01c8I\3\2\2\2\u01c9\u01ca\7\32\2\2\u01ca"+
		"\u01cb\78\2\2\u01cb\u01cc\5\60\31\2\u01cc\u01cd\79\2\2\u01cd\u01ce\5$"+
		"\23\2\u01ceK\3\2\2\2\u01cf\u01d0\7\36\2\2\u01d0\u01d1\78\2\2\u01d1\u01d2"+
		"\5\36\20\2\u01d2\u01d3\7=\2\2\u01d3\u01d4\5\60\31\2\u01d4\u01d5\7=\2\2"+
		"\u01d5\u01d6\5\60\31\2\u01d6\u01d7\79\2\2\u01d7\u01d8\5$\23\2\u01d8M\3"+
		"\2\2\2\u01d9\u01da\7\37\2\2\u01da\u01db\5\"\22\2\u01db\u01dc\7\32\2\2"+
		"\u01dc\u01dd\78\2\2\u01dd\u01de\5\60\31\2\u01de\u01df\79\2\2\u01df\u01e0"+
		"\7=\2\2\u01e0O\3\2\2\2\u01e1\u01e2\7\31\2\2\u01e2\u01e3\78\2\2\u01e3\u01e4"+
		"\5\60\31\2\u01e4\u01e5\79\2\2\u01e5\u01e9\7\66\2\2\u01e6\u01e8\5R*\2\u01e7"+
		"\u01e6\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2"+
		"\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01ee\5T+\2\u01ed\u01ec"+
		"\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\7\67\2\2"+
		"\u01f0Q\3\2\2\2\u01f1\u01f2\7\34\2\2\u01f2\u01f3\5\60\31\2\u01f3\u01f8"+
		"\7C\2\2\u01f4\u01f9\5$\23\2\u01f5\u01f6\5\60\31\2\u01f6\u01f7\7=\2\2\u01f7"+
		"\u01f9\3\2\2\2\u01f8\u01f4\3\2\2\2\u01f8\u01f5\3\2\2\2\u01f9S\3\2\2\2"+
		"\u01fa\u01fb\7\30\2\2\u01fb\u0200\7C\2\2\u01fc\u0201\5$\23\2\u01fd\u01fe"+
		"\5\60\31\2\u01fe\u01ff\7=\2\2\u01ff\u0201\3\2\2\2\u0200\u01fc\3\2\2\2"+
		"\u0200\u01fd\3\2\2\2\u0201U\3\2\2\2\u0202\u0203\7\33\2\2\u0203\u0204\5"+
		"\60\31\2\u0204W\3\2\2\2\u0205\u0206\t\2\2\2\u0206Y\3\2\2\2\u0207\u0208"+
		"\t\3\2\2\u0208[\3\2\2\2\60]jot|\177\u0085\u008b\u0090\u0098\u00a1\u00aa"+
		"\u00b4\u00be\u00c1\u00cd\u00d1\u00d8\u00df\u00e6\u00e9\u00ef\u010d\u0113"+
		"\u011c\u0126\u012b\u0132\u013d\u0144\u014a\u0168\u0173\u0177\u0179\u01a3"+
		"\u01a6\u01af\u01b2\u01b6\u01bc\u01c4\u01e9\u01ed\u01f8\u0200";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}