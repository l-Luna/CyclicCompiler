package cyclic.lang.antlr_generated;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CyclicLangLexer extends Lexer {
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
		DECLIT=34, INTLIT=35, STRLIT=36, BOOLLIT=37, NULL=38, BITAND=39, BITOR=40, 
		AND=41, OR=42, UP=43, STAR=44, SLASH=45, PLUS=46, MINUS=47, PERCENT=48, 
		AT=49, LSHIFT=50, RSHIFT=51, ULSHIFT=52, URSHIFT=53, EQUAL=54, INEQUAL=55, 
		GREATEREQ=56, LESSEREQ=57, GREATER=58, LESSER=59, ASSIGN=60, PASS=61, 
		LBRACE=62, RBRACE=63, LPAREN=64, RPAREN=65, LSQUAR=66, RSQUAR=67, COLON=68, 
		SEMICOLON=69, QUOTE=70, DOT=71, COMMA=72, EXCLAMATION=73, QUESTION=74, 
		ELIPSES=75, DASHARROW=76, EQARROW=77, INT=78, DEC=79, BYTE=80, BOOL=81, 
		VOID=82, VAR=83, VAL=84, TRUE=85, FALSE=86, ID=87, DIGIT=88, NONDIGIT=89, 
		SING_COMMENT=90, WS=91, UNMATCHED=92;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PROTECTED", "PRIVATE", "PUBLIC", "SYNCHRONISED", "ABSTRACT", "NATIVE", 
			"STATIC", "FINAL", "STRICTFP", "VOLATILE", "INSTANCEOF", "RETURN", "ASSERT", 
			"NEW", "CLASS", "INTERFACE", "ENUM", "RECORD", "SINGLE", "IMPORT", "PACKAGE", 
			"EXTENDS", "IMPLEMENTS", "THIS", "DEFAULT", "SWITCH", "WHILE", "YIELD", 
			"CASE", "ELSE", "FOR", "DO", "IF", "DECLIT", "INTLIT", "STRLIT", "BOOLLIT", 
			"NULL", "BITAND", "BITOR", "AND", "OR", "UP", "STAR", "SLASH", "PLUS", 
			"MINUS", "PERCENT", "AT", "LSHIFT", "RSHIFT", "ULSHIFT", "URSHIFT", "EQUAL", 
			"INEQUAL", "GREATEREQ", "LESSEREQ", "GREATER", "LESSER", "ASSIGN", "PASS", 
			"LBRACE", "RBRACE", "LPAREN", "RPAREN", "LSQUAR", "RSQUAR", "COLON", 
			"SEMICOLON", "QUOTE", "DOT", "COMMA", "EXCLAMATION", "QUESTION", "ELIPSES", 
			"DASHARROW", "EQARROW", "INT", "DEC", "BYTE", "BOOL", "VOID", "VAR", 
			"VAL", "TRUE", "FALSE", "ID", "DIGIT", "NONDIGIT", "SING_COMMENT", "WS", 
			"UNMATCHED"
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
			"'for'", "'do'", "'if'", null, null, null, null, "'null'", "'&'", "'|'", 
			"'&&'", "'||'", "'^'", "'*'", "'/'", "'+'", "'-'", "'%'", "'@'", "'<<'", 
			"'>>'", "'<<<'", "'>>>'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", 
			"'='", "'|>'", "'{'", "'}'", "'('", "')'", "'['", "']'", "':'", "';'", 
			"'\"'", "'.'", "','", "'!'", "'?'", "'...'", "'->'", "'=>'", "'int'", 
			"'float'", "'byte'", "'boolean'", "'void'", "'var'", "'val'", "'true'", 
			"'false'"
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
			"NULL", "BITAND", "BITOR", "AND", "OR", "UP", "STAR", "SLASH", "PLUS", 
			"MINUS", "PERCENT", "AT", "LSHIFT", "RSHIFT", "ULSHIFT", "URSHIFT", "EQUAL", 
			"INEQUAL", "GREATEREQ", "LESSEREQ", "GREATER", "LESSER", "ASSIGN", "PASS", 
			"LBRACE", "RBRACE", "LPAREN", "RPAREN", "LSQUAR", "RSQUAR", "COLON", 
			"SEMICOLON", "QUOTE", "DOT", "COMMA", "EXCLAMATION", "QUESTION", "ELIPSES", 
			"DASHARROW", "EQARROW", "INT", "DEC", "BYTE", "BOOL", "VOID", "VAR", 
			"VAL", "TRUE", "FALSE", "ID", "DIGIT", "NONDIGIT", "SING_COMMENT", "WS", 
			"UNMATCHED"
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


	public CyclicLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CyclicLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2^\u0280\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3"+
		"\"\3#\5#\u01a8\n#\3#\7#\u01ab\n#\f#\16#\u01ae\13#\3#\3#\6#\u01b2\n#\r"+
		"#\16#\u01b3\3#\5#\u01b7\n#\3$\5$\u01ba\n$\3$\6$\u01bd\n$\r$\16$\u01be"+
		"\3$\5$\u01c2\n$\3%\3%\7%\u01c6\n%\f%\16%\u01c9\13%\3%\3%\3&\3&\5&\u01cf"+
		"\n&\3\'\3\'\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3"+
		".\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3"+
		"\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\3"+
		"9\3:\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3"+
		"D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3L\3L\3M\3M\3M\3"+
		"N\3N\3N\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3"+
		"R\3R\3R\3S\3S\3S\3S\3S\3T\3T\3T\3T\3U\3U\3U\3U\3V\3V\3V\3V\3V\3W\3W\3"+
		"W\3W\3W\3W\3X\3X\3X\7X\u0267\nX\fX\16X\u026a\13X\3Y\3Y\3Z\3Z\3[\3[\3["+
		"\3[\7[\u0274\n[\f[\16[\u0277\13[\3[\3[\3\\\3\\\3\\\3\\\3]\3]\3\u01c7\2"+
		"^\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o"+
		"9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH"+
		"\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1"+
		"R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00adX\u00afY\u00b1Z\u00b3[\u00b5"+
		"\\\u00b7]\u00b9^\3\2\t\4\2ffhh\5\2ffhhnn\3\2$$\3\2\62;\t\2%&C\\aac|\u0080"+
		"\u0080\u00a5\u00a5\u00c4\u00c4\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u028b"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2"+
		"\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\3\u00bb"+
		"\3\2\2\2\5\u00c5\3\2\2\2\7\u00cd\3\2\2\2\t\u00d4\3\2\2\2\13\u00e1\3\2"+
		"\2\2\r\u00ea\3\2\2\2\17\u00f1\3\2\2\2\21\u00f8\3\2\2\2\23\u00fe\3\2\2"+
		"\2\25\u0107\3\2\2\2\27\u0110\3\2\2\2\31\u011b\3\2\2\2\33\u0122\3\2\2\2"+
		"\35\u0129\3\2\2\2\37\u012d\3\2\2\2!\u0133\3\2\2\2#\u013d\3\2\2\2%\u0142"+
		"\3\2\2\2\'\u0149\3\2\2\2)\u0150\3\2\2\2+\u0157\3\2\2\2-\u015f\3\2\2\2"+
		"/\u0167\3\2\2\2\61\u0172\3\2\2\2\63\u0177\3\2\2\2\65\u017f\3\2\2\2\67"+
		"\u0186\3\2\2\29\u018c\3\2\2\2;\u0192\3\2\2\2=\u0197\3\2\2\2?\u019c\3\2"+
		"\2\2A\u01a0\3\2\2\2C\u01a3\3\2\2\2E\u01a7\3\2\2\2G\u01b9\3\2\2\2I\u01c3"+
		"\3\2\2\2K\u01ce\3\2\2\2M\u01d0\3\2\2\2O\u01d5\3\2\2\2Q\u01d7\3\2\2\2S"+
		"\u01d9\3\2\2\2U\u01dc\3\2\2\2W\u01df\3\2\2\2Y\u01e1\3\2\2\2[\u01e3\3\2"+
		"\2\2]\u01e5\3\2\2\2_\u01e7\3\2\2\2a\u01e9\3\2\2\2c\u01eb\3\2\2\2e\u01ed"+
		"\3\2\2\2g\u01f0\3\2\2\2i\u01f3\3\2\2\2k\u01f7\3\2\2\2m\u01fb\3\2\2\2o"+
		"\u01fe\3\2\2\2q\u0201\3\2\2\2s\u0204\3\2\2\2u\u0207\3\2\2\2w\u0209\3\2"+
		"\2\2y\u020b\3\2\2\2{\u020d\3\2\2\2}\u0210\3\2\2\2\177\u0212\3\2\2\2\u0081"+
		"\u0214\3\2\2\2\u0083\u0216\3\2\2\2\u0085\u0218\3\2\2\2\u0087\u021a\3\2"+
		"\2\2\u0089\u021c\3\2\2\2\u008b\u021e\3\2\2\2\u008d\u0220\3\2\2\2\u008f"+
		"\u0222\3\2\2\2\u0091\u0224\3\2\2\2\u0093\u0226\3\2\2\2\u0095\u0228\3\2"+
		"\2\2\u0097\u022a\3\2\2\2\u0099\u022e\3\2\2\2\u009b\u0231\3\2\2\2\u009d"+
		"\u0234\3\2\2\2\u009f\u0238\3\2\2\2\u00a1\u023e\3\2\2\2\u00a3\u0243\3\2"+
		"\2\2\u00a5\u024b\3\2\2\2\u00a7\u0250\3\2\2\2\u00a9\u0254\3\2\2\2\u00ab"+
		"\u0258\3\2\2\2\u00ad\u025d\3\2\2\2\u00af\u0263\3\2\2\2\u00b1\u026b\3\2"+
		"\2\2\u00b3\u026d\3\2\2\2\u00b5\u026f\3\2\2\2\u00b7\u027a\3\2\2\2\u00b9"+
		"\u027e\3\2\2\2\u00bb\u00bc\7r\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7q\2"+
		"\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7e\2\2\u00c1\u00c2"+
		"\7v\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7f\2\2\u00c4\4\3\2\2\2\u00c5\u00c6"+
		"\7r\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7x\2\2\u00c9"+
		"\u00ca\7c\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7g\2\2\u00cc\6\3\2\2\2\u00cd"+
		"\u00ce\7r\2\2\u00ce\u00cf\7w\2\2\u00cf\u00d0\7d\2\2\u00d0\u00d1\7n\2\2"+
		"\u00d1\u00d2\7k\2\2\u00d2\u00d3\7e\2\2\u00d3\b\3\2\2\2\u00d4\u00d5\7u"+
		"\2\2\u00d5\u00d6\7{\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7e\2\2\u00d8\u00d9"+
		"\7j\2\2\u00d9\u00da\7t\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7p\2\2\u00dc"+
		"\u00dd\7k\2\2\u00dd\u00de\7u\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7f\2\2"+
		"\u00e0\n\3\2\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7d\2\2\u00e3\u00e4\7u"+
		"\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8"+
		"\7e\2\2\u00e8\u00e9\7v\2\2\u00e9\f\3\2\2\2\u00ea\u00eb\7p\2\2\u00eb\u00ec"+
		"\7c\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7x\2\2\u00ef"+
		"\u00f0\7g\2\2\u00f0\16\3\2\2\2\u00f1\u00f2\7u\2\2\u00f2\u00f3\7v\2\2\u00f3"+
		"\u00f4\7c\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6\7k\2\2\u00f6\u00f7\7e\2\2"+
		"\u00f7\20\3\2\2\2\u00f8\u00f9\7h\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7"+
		"p\2\2\u00fb\u00fc\7c\2\2\u00fc\u00fd\7n\2\2\u00fd\22\3\2\2\2\u00fe\u00ff"+
		"\7u\2\2\u00ff\u0100\7v\2\2\u0100\u0101\7t\2\2\u0101\u0102\7k\2\2\u0102"+
		"\u0103\7e\2\2\u0103\u0104\7v\2\2\u0104\u0105\7h\2\2\u0105\u0106\7r\2\2"+
		"\u0106\24\3\2\2\2\u0107\u0108\7x\2\2\u0108\u0109\7q\2\2\u0109\u010a\7"+
		"n\2\2\u010a\u010b\7c\2\2\u010b\u010c\7v\2\2\u010c\u010d\7k\2\2\u010d\u010e"+
		"\7n\2\2\u010e\u010f\7g\2\2\u010f\26\3\2\2\2\u0110\u0111\7k\2\2\u0111\u0112"+
		"\7p\2\2\u0112\u0113\7u\2\2\u0113\u0114\7v\2\2\u0114\u0115\7c\2\2\u0115"+
		"\u0116\7p\2\2\u0116\u0117\7e\2\2\u0117\u0118\7g\2\2\u0118\u0119\7q\2\2"+
		"\u0119\u011a\7h\2\2\u011a\30\3\2\2\2\u011b\u011c\7t\2\2\u011c\u011d\7"+
		"g\2\2\u011d\u011e\7v\2\2\u011e\u011f\7w\2\2\u011f\u0120\7t\2\2\u0120\u0121"+
		"\7p\2\2\u0121\32\3\2\2\2\u0122\u0123\7c\2\2\u0123\u0124\7u\2\2\u0124\u0125"+
		"\7u\2\2\u0125\u0126\7g\2\2\u0126\u0127\7t\2\2\u0127\u0128\7v\2\2\u0128"+
		"\34\3\2\2\2\u0129\u012a\7p\2\2\u012a\u012b\7g\2\2\u012b\u012c\7y\2\2\u012c"+
		"\36\3\2\2\2\u012d\u012e\7e\2\2\u012e\u012f\7n\2\2\u012f\u0130\7c\2\2\u0130"+
		"\u0131\7u\2\2\u0131\u0132\7u\2\2\u0132 \3\2\2\2\u0133\u0134\7k\2\2\u0134"+
		"\u0135\7p\2\2\u0135\u0136\7v\2\2\u0136\u0137\7g\2\2\u0137\u0138\7t\2\2"+
		"\u0138\u0139\7h\2\2\u0139\u013a\7c\2\2\u013a\u013b\7e\2\2\u013b\u013c"+
		"\7g\2\2\u013c\"\3\2\2\2\u013d\u013e\7g\2\2\u013e\u013f\7p\2\2\u013f\u0140"+
		"\7w\2\2\u0140\u0141\7o\2\2\u0141$\3\2\2\2\u0142\u0143\7t\2\2\u0143\u0144"+
		"\7g\2\2\u0144\u0145\7e\2\2\u0145\u0146\7q\2\2\u0146\u0147\7t\2\2\u0147"+
		"\u0148\7f\2\2\u0148&\3\2\2\2\u0149\u014a\7u\2\2\u014a\u014b\7k\2\2\u014b"+
		"\u014c\7p\2\2\u014c\u014d\7i\2\2\u014d\u014e\7n\2\2\u014e\u014f\7g\2\2"+
		"\u014f(\3\2\2\2\u0150\u0151\7k\2\2\u0151\u0152\7o\2\2\u0152\u0153\7r\2"+
		"\2\u0153\u0154\7q\2\2\u0154\u0155\7t\2\2\u0155\u0156\7v\2\2\u0156*\3\2"+
		"\2\2\u0157\u0158\7r\2\2\u0158\u0159\7c\2\2\u0159\u015a\7e\2\2\u015a\u015b"+
		"\7m\2\2\u015b\u015c\7c\2\2\u015c\u015d\7i\2\2\u015d\u015e\7g\2\2\u015e"+
		",\3\2\2\2\u015f\u0160\7g\2\2\u0160\u0161\7z\2\2\u0161\u0162\7v\2\2\u0162"+
		"\u0163\7g\2\2\u0163\u0164\7p\2\2\u0164\u0165\7f\2\2\u0165\u0166\7u\2\2"+
		"\u0166.\3\2\2\2\u0167\u0168\7k\2\2\u0168\u0169\7o\2\2\u0169\u016a\7r\2"+
		"\2\u016a\u016b\7n\2\2\u016b\u016c\7g\2\2\u016c\u016d\7o\2\2\u016d\u016e"+
		"\7g\2\2\u016e\u016f\7p\2\2\u016f\u0170\7v\2\2\u0170\u0171\7u\2\2\u0171"+
		"\60\3\2\2\2\u0172\u0173\7v\2\2\u0173\u0174\7j\2\2\u0174\u0175\7k\2\2\u0175"+
		"\u0176\7u\2\2\u0176\62\3\2\2\2\u0177\u0178\7f\2\2\u0178\u0179\7g\2\2\u0179"+
		"\u017a\7h\2\2\u017a\u017b\7c\2\2\u017b\u017c\7w\2\2\u017c\u017d\7n\2\2"+
		"\u017d\u017e\7v\2\2\u017e\64\3\2\2\2\u017f\u0180\7u\2\2\u0180\u0181\7"+
		"y\2\2\u0181\u0182\7k\2\2\u0182\u0183\7v\2\2\u0183\u0184\7e\2\2\u0184\u0185"+
		"\7j\2\2\u0185\66\3\2\2\2\u0186\u0187\7y\2\2\u0187\u0188\7j\2\2\u0188\u0189"+
		"\7k\2\2\u0189\u018a\7n\2\2\u018a\u018b\7g\2\2\u018b8\3\2\2\2\u018c\u018d"+
		"\7{\2\2\u018d\u018e\7k\2\2\u018e\u018f\7g\2\2\u018f\u0190\7n\2\2\u0190"+
		"\u0191\7f\2\2\u0191:\3\2\2\2\u0192\u0193\7e\2\2\u0193\u0194\7c\2\2\u0194"+
		"\u0195\7u\2\2\u0195\u0196\7g\2\2\u0196<\3\2\2\2\u0197\u0198\7g\2\2\u0198"+
		"\u0199\7n\2\2\u0199\u019a\7u\2\2\u019a\u019b\7g\2\2\u019b>\3\2\2\2\u019c"+
		"\u019d\7h\2\2\u019d\u019e\7q\2\2\u019e\u019f\7t\2\2\u019f@\3\2\2\2\u01a0"+
		"\u01a1\7f\2\2\u01a1\u01a2\7q\2\2\u01a2B\3\2\2\2\u01a3\u01a4\7k\2\2\u01a4"+
		"\u01a5\7h\2\2\u01a5D\3\2\2\2\u01a6\u01a8\5_\60\2\u01a7\u01a6\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u01ac\3\2\2\2\u01a9\u01ab\5\u00b1Y\2\u01aa\u01a9"+
		"\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"\u01af\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b1\5\u008fH\2\u01b0\u01b2"+
		"\5\u00b1Y\2\u01b1\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b1\3\2\2"+
		"\2\u01b3\u01b4\3\2\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b7\t\2\2\2\u01b6\u01b5"+
		"\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7F\3\2\2\2\u01b8\u01ba\5_\60\2\u01b9"+
		"\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bc\3\2\2\2\u01bb\u01bd\5\u00b1"+
		"Y\2\u01bc\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bc\3\2\2\2\u01be"+
		"\u01bf\3\2\2\2\u01bf\u01c1\3\2\2\2\u01c0\u01c2\t\3\2\2\u01c1\u01c0\3\2"+
		"\2\2\u01c1\u01c2\3\2\2\2\u01c2H\3\2\2\2\u01c3\u01c7\5\u008dG\2\u01c4\u01c6"+
		"\n\4\2\2\u01c5\u01c4\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c7"+
		"\u01c5\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01c7\3\2\2\2\u01ca\u01cb\5\u008d"+
		"G\2\u01cbJ\3\2\2\2\u01cc\u01cf\5\u00abV\2\u01cd\u01cf\5\u00adW\2\u01ce"+
		"\u01cc\3\2\2\2\u01ce\u01cd\3\2\2\2\u01cfL\3\2\2\2\u01d0\u01d1\7p\2\2\u01d1"+
		"\u01d2\7w\2\2\u01d2\u01d3\7n\2\2\u01d3\u01d4\7n\2\2\u01d4N\3\2\2\2\u01d5"+
		"\u01d6\7(\2\2\u01d6P\3\2\2\2\u01d7\u01d8\7~\2\2\u01d8R\3\2\2\2\u01d9\u01da"+
		"\7(\2\2\u01da\u01db\7(\2\2\u01dbT\3\2\2\2\u01dc\u01dd\7~\2\2\u01dd\u01de"+
		"\7~\2\2\u01deV\3\2\2\2\u01df\u01e0\7`\2\2\u01e0X\3\2\2\2\u01e1\u01e2\7"+
		",\2\2\u01e2Z\3\2\2\2\u01e3\u01e4\7\61\2\2\u01e4\\\3\2\2\2\u01e5\u01e6"+
		"\7-\2\2\u01e6^\3\2\2\2\u01e7\u01e8\7/\2\2\u01e8`\3\2\2\2\u01e9\u01ea\7"+
		"\'\2\2\u01eab\3\2\2\2\u01eb\u01ec\7B\2\2\u01ecd\3\2\2\2\u01ed\u01ee\7"+
		">\2\2\u01ee\u01ef\7>\2\2\u01eff\3\2\2\2\u01f0\u01f1\7@\2\2\u01f1\u01f2"+
		"\7@\2\2\u01f2h\3\2\2\2\u01f3\u01f4\7>\2\2\u01f4\u01f5\7>\2\2\u01f5\u01f6"+
		"\7>\2\2\u01f6j\3\2\2\2\u01f7\u01f8\7@\2\2\u01f8\u01f9\7@\2\2\u01f9\u01fa"+
		"\7@\2\2\u01fal\3\2\2\2\u01fb\u01fc\7?\2\2\u01fc\u01fd\7?\2\2\u01fdn\3"+
		"\2\2\2\u01fe\u01ff\7#\2\2\u01ff\u0200\7?\2\2\u0200p\3\2\2\2\u0201\u0202"+
		"\7@\2\2\u0202\u0203\7?\2\2\u0203r\3\2\2\2\u0204\u0205\7>\2\2\u0205\u0206"+
		"\7?\2\2\u0206t\3\2\2\2\u0207\u0208\7@\2\2\u0208v\3\2\2\2\u0209\u020a\7"+
		">\2\2\u020ax\3\2\2\2\u020b\u020c\7?\2\2\u020cz\3\2\2\2\u020d\u020e\7~"+
		"\2\2\u020e\u020f\7@\2\2\u020f|\3\2\2\2\u0210\u0211\7}\2\2\u0211~\3\2\2"+
		"\2\u0212\u0213\7\177\2\2\u0213\u0080\3\2\2\2\u0214\u0215\7*\2\2\u0215"+
		"\u0082\3\2\2\2\u0216\u0217\7+\2\2\u0217\u0084\3\2\2\2\u0218\u0219\7]\2"+
		"\2\u0219\u0086\3\2\2\2\u021a\u021b\7_\2\2\u021b\u0088\3\2\2\2\u021c\u021d"+
		"\7<\2\2\u021d\u008a\3\2\2\2\u021e\u021f\7=\2\2\u021f\u008c\3\2\2\2\u0220"+
		"\u0221\7$\2\2\u0221\u008e\3\2\2\2\u0222\u0223\7\60\2\2\u0223\u0090\3\2"+
		"\2\2\u0224\u0225\7.\2\2\u0225\u0092\3\2\2\2\u0226\u0227\7#\2\2\u0227\u0094"+
		"\3\2\2\2\u0228\u0229\7A\2\2\u0229\u0096\3\2\2\2\u022a\u022b\7\60\2\2\u022b"+
		"\u022c\7\60\2\2\u022c\u022d\7\60\2\2\u022d\u0098\3\2\2\2\u022e\u022f\7"+
		"/\2\2\u022f\u0230\7@\2\2\u0230\u009a\3\2\2\2\u0231\u0232\7?\2\2\u0232"+
		"\u0233\7@\2\2\u0233\u009c\3\2\2\2\u0234\u0235\7k\2\2\u0235\u0236\7p\2"+
		"\2\u0236\u0237\7v\2\2\u0237\u009e\3\2\2\2\u0238\u0239\7h\2\2\u0239\u023a"+
		"\7n\2\2\u023a\u023b\7q\2\2\u023b\u023c\7c\2\2\u023c\u023d\7v\2\2\u023d"+
		"\u00a0\3\2\2\2\u023e\u023f\7d\2\2\u023f\u0240\7{\2\2\u0240\u0241\7v\2"+
		"\2\u0241\u0242\7g\2\2\u0242\u00a2\3\2\2\2\u0243\u0244\7d\2\2\u0244\u0245"+
		"\7q\2\2\u0245\u0246\7q\2\2\u0246\u0247\7n\2\2\u0247\u0248\7g\2\2\u0248"+
		"\u0249\7c\2\2\u0249\u024a\7p\2\2\u024a\u00a4\3\2\2\2\u024b\u024c\7x\2"+
		"\2\u024c\u024d\7q\2\2\u024d\u024e\7k\2\2\u024e\u024f\7f\2\2\u024f\u00a6"+
		"\3\2\2\2\u0250\u0251\7x\2\2\u0251\u0252\7c\2\2\u0252\u0253\7t\2\2\u0253"+
		"\u00a8\3\2\2\2\u0254\u0255\7x\2\2\u0255\u0256\7c\2\2\u0256\u0257\7n\2"+
		"\2\u0257\u00aa\3\2\2\2\u0258\u0259\7v\2\2\u0259\u025a\7t\2\2\u025a\u025b"+
		"\7w\2\2\u025b\u025c\7g\2\2\u025c\u00ac\3\2\2\2\u025d\u025e\7h\2\2\u025e"+
		"\u025f\7c\2\2\u025f\u0260\7n\2\2\u0260\u0261\7u\2\2\u0261\u0262\7g\2\2"+
		"\u0262\u00ae\3\2\2\2\u0263\u0268\5\u00b3Z\2\u0264\u0267\5\u00b1Y\2\u0265"+
		"\u0267\5\u00b3Z\2\u0266\u0264\3\2\2\2\u0266\u0265\3\2\2\2\u0267\u026a"+
		"\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u00b0\3\2\2\2\u026a"+
		"\u0268\3\2\2\2\u026b\u026c\t\5\2\2\u026c\u00b2\3\2\2\2\u026d\u026e\t\6"+
		"\2\2\u026e\u00b4\3\2\2\2\u026f\u0270\7\61\2\2\u0270\u0271\7\61\2\2\u0271"+
		"\u0275\3\2\2\2\u0272\u0274\n\7\2\2\u0273\u0272\3\2\2\2\u0274\u0277\3\2"+
		"\2\2\u0275\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0278\3\2\2\2\u0277"+
		"\u0275\3\2\2\2\u0278\u0279\b[\2\2\u0279\u00b6\3\2\2\2\u027a\u027b\t\b"+
		"\2\2\u027b\u027c\3\2\2\2\u027c\u027d\b\\\2\2\u027d\u00b8\3\2\2\2\u027e"+
		"\u027f\13\2\2\2\u027f\u00ba\3\2\2\2\17\2\u01a7\u01ac\u01b3\u01b6\u01b9"+
		"\u01be\u01c1\u01c7\u01ce\u0266\u0268\u0275\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}