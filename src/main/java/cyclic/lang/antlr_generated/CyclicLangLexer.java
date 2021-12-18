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
		ASSERT=13, NEW=14, INTERFACE=15, SINGLE=16, CLASS=17, ENUM=18, IMPORT=19, 
		PACKAGE=20, EXTENDS=21, IMPLEMENTS=22, THIS=23, DEFAULT=24, SWITCH=25, 
		WHILE=26, YIELD=27, CASE=28, ELSE=29, FOR=30, DO=31, IF=32, DECLIT=33, 
		INTLIT=34, STRLIT=35, BOOLLIT=36, NULL=37, AND=38, OR=39, UP=40, STAR=41, 
		SLASH=42, PLUS=43, MINUS=44, PERCENT=45, AT=46, EQUAL=47, INEQUAL=48, 
		GREATEREQ=49, LESSEREQ=50, GREATER=51, LESSER=52, ASSIGN=53, LBRACE=54, 
		RBRACE=55, LPAREN=56, RPAREN=57, LSQUAR=58, RSQUAR=59, COLON=60, SEMICOLON=61, 
		QUOTE=62, DOT=63, COMMA=64, EXCLAMATION=65, QUESTION=66, DASHARROW=67, 
		EQARROW=68, INT=69, DEC=70, BYTE=71, BOOL=72, VOID=73, VAR=74, VAL=75, 
		TRUE=76, FALSE=77, ID=78, DIGIT=79, NONDIGIT=80, SING_COMMENT=81, WS=82, 
		UNMATCHED=83;
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
			"NEW", "INTERFACE", "SINGLE", "CLASS", "ENUM", "IMPORT", "PACKAGE", "EXTENDS", 
			"IMPLEMENTS", "THIS", "DEFAULT", "SWITCH", "WHILE", "YIELD", "CASE", 
			"ELSE", "FOR", "DO", "IF", "DECLIT", "INTLIT", "STRLIT", "BOOLLIT", "NULL", 
			"AND", "OR", "UP", "STAR", "SLASH", "PLUS", "MINUS", "PERCENT", "AT", 
			"EQUAL", "INEQUAL", "GREATEREQ", "LESSEREQ", "GREATER", "LESSER", "ASSIGN", 
			"LBRACE", "RBRACE", "LPAREN", "RPAREN", "LSQUAR", "RSQUAR", "COLON", 
			"SEMICOLON", "QUOTE", "DOT", "COMMA", "EXCLAMATION", "QUESTION", "DASHARROW", 
			"EQARROW", "INT", "DEC", "BYTE", "BOOL", "VOID", "VAR", "VAL", "TRUE", 
			"FALSE", "ID", "DIGIT", "NONDIGIT", "SING_COMMENT", "WS", "UNMATCHED"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'protected'", "'private'", "'public'", "'synchronised'", "'abstract'", 
			"'native'", "'static'", "'final'", "'strictfp'", "'volatile'", "'instanceof'", 
			"'return'", "'assert'", "'new'", "'interface'", "'single'", "'class'", 
			"'enum'", "'import'", "'package'", "'extends'", "'implements'", "'this'", 
			"'default'", "'switch'", "'while'", "'yield'", "'case'", "'else'", "'for'", 
			"'do'", "'if'", null, null, null, null, "'null'", "'&&'", "'||'", "'^'", 
			"'*'", "'/'", "'+'", "'-'", "'%'", "'@'", "'=='", "'!='", "'>='", "'<='", 
			"'>'", "'<'", "'='", "'{'", "'}'", "'('", "')'", "'['", "']'", "':'", 
			"';'", "'\"'", "'.'", "','", "'!'", "'?'", "'->'", "'=>'", "'int'", "'float'", 
			"'byte'", "'boolean'", "'void'", "'var'", "'val'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROTECTED", "PRIVATE", "PUBLIC", "SYNCHRONISED", "ABSTRACT", "NATIVE", 
			"STATIC", "FINAL", "STRICTFP", "VOLATILE", "INSTANCEOF", "RETURN", "ASSERT", 
			"NEW", "INTERFACE", "SINGLE", "CLASS", "ENUM", "IMPORT", "PACKAGE", "EXTENDS", 
			"IMPLEMENTS", "THIS", "DEFAULT", "SWITCH", "WHILE", "YIELD", "CASE", 
			"ELSE", "FOR", "DO", "IF", "DECLIT", "INTLIT", "STRLIT", "BOOLLIT", "NULL", 
			"AND", "OR", "UP", "STAR", "SLASH", "PLUS", "MINUS", "PERCENT", "AT", 
			"EQUAL", "INEQUAL", "GREATEREQ", "LESSEREQ", "GREATER", "LESSER", "ASSIGN", 
			"LBRACE", "RBRACE", "LPAREN", "RPAREN", "LSQUAR", "RSQUAR", "COLON", 
			"SEMICOLON", "QUOTE", "DOT", "COMMA", "EXCLAMATION", "QUESTION", "DASHARROW", 
			"EQARROW", "INT", "DEC", "BYTE", "BOOL", "VOID", "VAR", "VAL", "TRUE", 
			"FALSE", "ID", "DIGIT", "NONDIGIT", "SING_COMMENT", "WS", "UNMATCHED"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2U\u024e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\5\"\u018f"+
		"\n\"\3\"\7\"\u0192\n\"\f\"\16\"\u0195\13\"\3\"\3\"\6\"\u0199\n\"\r\"\16"+
		"\"\u019a\3\"\5\"\u019e\n\"\3#\5#\u01a1\n#\3#\6#\u01a4\n#\r#\16#\u01a5"+
		"\3#\5#\u01a9\n#\3$\3$\7$\u01ad\n$\f$\16$\u01b0\13$\3$\3$\3%\3%\5%\u01b6"+
		"\n%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-"+
		"\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3"+
		"<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3D\3E\3E\3E\3F\3"+
		"F\3F\3F\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3I\3I\3J\3"+
		"J\3J\3J\3J\3K\3K\3K\3K\3L\3L\3L\3L\3M\3M\3M\3M\3M\3N\3N\3N\3N\3N\3N\3"+
		"O\3O\3O\7O\u0235\nO\fO\16O\u0238\13O\3P\3P\3Q\3Q\3R\3R\3R\3R\7R\u0242"+
		"\nR\fR\16R\u0245\13R\3R\3R\3S\3S\3S\3S\3T\3T\3\u01ae\2U\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{"+
		"?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091"+
		"J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5"+
		"T\u00a7U\3\2\b\4\2ffhh\3\2$$\3\2\62;\t\2%&C\\aac|\u0080\u0080\u00a5\u00a5"+
		"\u00c4\u00c4\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0259\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2"+
		"\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2"+
		"\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q"+
		"\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2"+
		"\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087"+
		"\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2"+
		"\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099"+
		"\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2"+
		"\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\3\u00a9\3\2\2\2\5\u00b3"+
		"\3\2\2\2\7\u00bb\3\2\2\2\t\u00c2\3\2\2\2\13\u00cf\3\2\2\2\r\u00d8\3\2"+
		"\2\2\17\u00df\3\2\2\2\21\u00e6\3\2\2\2\23\u00ec\3\2\2\2\25\u00f5\3\2\2"+
		"\2\27\u00fe\3\2\2\2\31\u0109\3\2\2\2\33\u0110\3\2\2\2\35\u0117\3\2\2\2"+
		"\37\u011b\3\2\2\2!\u0125\3\2\2\2#\u012c\3\2\2\2%\u0132\3\2\2\2\'\u0137"+
		"\3\2\2\2)\u013e\3\2\2\2+\u0146\3\2\2\2-\u014e\3\2\2\2/\u0159\3\2\2\2\61"+
		"\u015e\3\2\2\2\63\u0166\3\2\2\2\65\u016d\3\2\2\2\67\u0173\3\2\2\29\u0179"+
		"\3\2\2\2;\u017e\3\2\2\2=\u0183\3\2\2\2?\u0187\3\2\2\2A\u018a\3\2\2\2C"+
		"\u018e\3\2\2\2E\u01a0\3\2\2\2G\u01aa\3\2\2\2I\u01b5\3\2\2\2K\u01b7\3\2"+
		"\2\2M\u01bc\3\2\2\2O\u01bf\3\2\2\2Q\u01c2\3\2\2\2S\u01c4\3\2\2\2U\u01c6"+
		"\3\2\2\2W\u01c8\3\2\2\2Y\u01ca\3\2\2\2[\u01cc\3\2\2\2]\u01ce\3\2\2\2_"+
		"\u01d0\3\2\2\2a\u01d3\3\2\2\2c\u01d6\3\2\2\2e\u01d9\3\2\2\2g\u01dc\3\2"+
		"\2\2i\u01de\3\2\2\2k\u01e0\3\2\2\2m\u01e2\3\2\2\2o\u01e4\3\2\2\2q\u01e6"+
		"\3\2\2\2s\u01e8\3\2\2\2u\u01ea\3\2\2\2w\u01ec\3\2\2\2y\u01ee\3\2\2\2{"+
		"\u01f0\3\2\2\2}\u01f2\3\2\2\2\177\u01f4\3\2\2\2\u0081\u01f6\3\2\2\2\u0083"+
		"\u01f8\3\2\2\2\u0085\u01fa\3\2\2\2\u0087\u01fc\3\2\2\2\u0089\u01ff\3\2"+
		"\2\2\u008b\u0202\3\2\2\2\u008d\u0206\3\2\2\2\u008f\u020c\3\2\2\2\u0091"+
		"\u0211\3\2\2\2\u0093\u0219\3\2\2\2\u0095\u021e\3\2\2\2\u0097\u0222\3\2"+
		"\2\2\u0099\u0226\3\2\2\2\u009b\u022b\3\2\2\2\u009d\u0231\3\2\2\2\u009f"+
		"\u0239\3\2\2\2\u00a1\u023b\3\2\2\2\u00a3\u023d\3\2\2\2\u00a5\u0248\3\2"+
		"\2\2\u00a7\u024c\3\2\2\2\u00a9\u00aa\7r\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac"+
		"\7q\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7e\2\2\u00af"+
		"\u00b0\7v\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7f\2\2\u00b2\4\3\2\2\2\u00b3"+
		"\u00b4\7r\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7x\2\2"+
		"\u00b7\u00b8\7c\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7g\2\2\u00ba\6\3\2"+
		"\2\2\u00bb\u00bc\7r\2\2\u00bc\u00bd\7w\2\2\u00bd\u00be\7d\2\2\u00be\u00bf"+
		"\7n\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7e\2\2\u00c1\b\3\2\2\2\u00c2\u00c3"+
		"\7u\2\2\u00c3\u00c4\7{\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7e\2\2\u00c6"+
		"\u00c7\7j\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7p\2\2"+
		"\u00ca\u00cb\7k\2\2\u00cb\u00cc\7u\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce"+
		"\7f\2\2\u00ce\n\3\2\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7d\2\2\u00d1\u00d2"+
		"\7u\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7c\2\2\u00d5"+
		"\u00d6\7e\2\2\u00d6\u00d7\7v\2\2\u00d7\f\3\2\2\2\u00d8\u00d9\7p\2\2\u00d9"+
		"\u00da\7c\2\2\u00da\u00db\7v\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7x\2\2"+
		"\u00dd\u00de\7g\2\2\u00de\16\3\2\2\2\u00df\u00e0\7u\2\2\u00e0\u00e1\7"+
		"v\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5"+
		"\7e\2\2\u00e5\20\3\2\2\2\u00e6\u00e7\7h\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9"+
		"\7p\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb\7n\2\2\u00eb\22\3\2\2\2\u00ec\u00ed"+
		"\7u\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7t\2\2\u00ef\u00f0\7k\2\2\u00f0"+
		"\u00f1\7e\2\2\u00f1\u00f2\7v\2\2\u00f2\u00f3\7h\2\2\u00f3\u00f4\7r\2\2"+
		"\u00f4\24\3\2\2\2\u00f5\u00f6\7x\2\2\u00f6\u00f7\7q\2\2\u00f7\u00f8\7"+
		"n\2\2\u00f8\u00f9\7c\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb\7k\2\2\u00fb\u00fc"+
		"\7n\2\2\u00fc\u00fd\7g\2\2\u00fd\26\3\2\2\2\u00fe\u00ff\7k\2\2\u00ff\u0100"+
		"\7p\2\2\u0100\u0101\7u\2\2\u0101\u0102\7v\2\2\u0102\u0103\7c\2\2\u0103"+
		"\u0104\7p\2\2\u0104\u0105\7e\2\2\u0105\u0106\7g\2\2\u0106\u0107\7q\2\2"+
		"\u0107\u0108\7h\2\2\u0108\30\3\2\2\2\u0109\u010a\7t\2\2\u010a\u010b\7"+
		"g\2\2\u010b\u010c\7v\2\2\u010c\u010d\7w\2\2\u010d\u010e\7t\2\2\u010e\u010f"+
		"\7p\2\2\u010f\32\3\2\2\2\u0110\u0111\7c\2\2\u0111\u0112\7u\2\2\u0112\u0113"+
		"\7u\2\2\u0113\u0114\7g\2\2\u0114\u0115\7t\2\2\u0115\u0116\7v\2\2\u0116"+
		"\34\3\2\2\2\u0117\u0118\7p\2\2\u0118\u0119\7g\2\2\u0119\u011a\7y\2\2\u011a"+
		"\36\3\2\2\2\u011b\u011c\7k\2\2\u011c\u011d\7p\2\2\u011d\u011e\7v\2\2\u011e"+
		"\u011f\7g\2\2\u011f\u0120\7t\2\2\u0120\u0121\7h\2\2\u0121\u0122\7c\2\2"+
		"\u0122\u0123\7e\2\2\u0123\u0124\7g\2\2\u0124 \3\2\2\2\u0125\u0126\7u\2"+
		"\2\u0126\u0127\7k\2\2\u0127\u0128\7p\2\2\u0128\u0129\7i\2\2\u0129\u012a"+
		"\7n\2\2\u012a\u012b\7g\2\2\u012b\"\3\2\2\2\u012c\u012d\7e\2\2\u012d\u012e"+
		"\7n\2\2\u012e\u012f\7c\2\2\u012f\u0130\7u\2\2\u0130\u0131\7u\2\2\u0131"+
		"$\3\2\2\2\u0132\u0133\7g\2\2\u0133\u0134\7p\2\2\u0134\u0135\7w\2\2\u0135"+
		"\u0136\7o\2\2\u0136&\3\2\2\2\u0137\u0138\7k\2\2\u0138\u0139\7o\2\2\u0139"+
		"\u013a\7r\2\2\u013a\u013b\7q\2\2\u013b\u013c\7t\2\2\u013c\u013d\7v\2\2"+
		"\u013d(\3\2\2\2\u013e\u013f\7r\2\2\u013f\u0140\7c\2\2\u0140\u0141\7e\2"+
		"\2\u0141\u0142\7m\2\2\u0142\u0143\7c\2\2\u0143\u0144\7i\2\2\u0144\u0145"+
		"\7g\2\2\u0145*\3\2\2\2\u0146\u0147\7g\2\2\u0147\u0148\7z\2\2\u0148\u0149"+
		"\7v\2\2\u0149\u014a\7g\2\2\u014a\u014b\7p\2\2\u014b\u014c\7f\2\2\u014c"+
		"\u014d\7u\2\2\u014d,\3\2\2\2\u014e\u014f\7k\2\2\u014f\u0150\7o\2\2\u0150"+
		"\u0151\7r\2\2\u0151\u0152\7n\2\2\u0152\u0153\7g\2\2\u0153\u0154\7o\2\2"+
		"\u0154\u0155\7g\2\2\u0155\u0156\7p\2\2\u0156\u0157\7v\2\2\u0157\u0158"+
		"\7u\2\2\u0158.\3\2\2\2\u0159\u015a\7v\2\2\u015a\u015b\7j\2\2\u015b\u015c"+
		"\7k\2\2\u015c\u015d\7u\2\2\u015d\60\3\2\2\2\u015e\u015f\7f\2\2\u015f\u0160"+
		"\7g\2\2\u0160\u0161\7h\2\2\u0161\u0162\7c\2\2\u0162\u0163\7w\2\2\u0163"+
		"\u0164\7n\2\2\u0164\u0165\7v\2\2\u0165\62\3\2\2\2\u0166\u0167\7u\2\2\u0167"+
		"\u0168\7y\2\2\u0168\u0169\7k\2\2\u0169\u016a\7v\2\2\u016a\u016b\7e\2\2"+
		"\u016b\u016c\7j\2\2\u016c\64\3\2\2\2\u016d\u016e\7y\2\2\u016e\u016f\7"+
		"j\2\2\u016f\u0170\7k\2\2\u0170\u0171\7n\2\2\u0171\u0172\7g\2\2\u0172\66"+
		"\3\2\2\2\u0173\u0174\7{\2\2\u0174\u0175\7k\2\2\u0175\u0176\7g\2\2\u0176"+
		"\u0177\7n\2\2\u0177\u0178\7f\2\2\u01788\3\2\2\2\u0179\u017a\7e\2\2\u017a"+
		"\u017b\7c\2\2\u017b\u017c\7u\2\2\u017c\u017d\7g\2\2\u017d:\3\2\2\2\u017e"+
		"\u017f\7g\2\2\u017f\u0180\7n\2\2\u0180\u0181\7u\2\2\u0181\u0182\7g\2\2"+
		"\u0182<\3\2\2\2\u0183\u0184\7h\2\2\u0184\u0185\7q\2\2\u0185\u0186\7t\2"+
		"\2\u0186>\3\2\2\2\u0187\u0188\7f\2\2\u0188\u0189\7q\2\2\u0189@\3\2\2\2"+
		"\u018a\u018b\7k\2\2\u018b\u018c\7h\2\2\u018cB\3\2\2\2\u018d\u018f\5Y-"+
		"\2\u018e\u018d\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0193\3\2\2\2\u0190\u0192"+
		"\5\u009fP\2\u0191\u0190\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2"+
		"\2\u0193\u0194\3\2\2\2\u0194\u0196\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0198"+
		"\5\177@\2\u0197\u0199\5\u009fP\2\u0198\u0197\3\2\2\2\u0199\u019a\3\2\2"+
		"\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d\3\2\2\2\u019c\u019e"+
		"\t\2\2\2\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2\2\u019eD\3\2\2\2\u019f"+
		"\u01a1\5Y-\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a3\3\2\2"+
		"\2\u01a2\u01a4\5\u009fP\2\u01a3\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5"+
		"\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a9\t\2"+
		"\2\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9F\3\2\2\2\u01aa\u01ae"+
		"\5}?\2\u01ab\u01ad\n\3\2\2\u01ac\u01ab\3\2\2\2\u01ad\u01b0\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b1\3\2\2\2\u01b0\u01ae\3\2"+
		"\2\2\u01b1\u01b2\5}?\2\u01b2H\3\2\2\2\u01b3\u01b6\5\u0099M\2\u01b4\u01b6"+
		"\5\u009bN\2\u01b5\u01b3\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b6J\3\2\2\2\u01b7"+
		"\u01b8\7p\2\2\u01b8\u01b9\7w\2\2\u01b9\u01ba\7n\2\2\u01ba\u01bb\7n\2\2"+
		"\u01bbL\3\2\2\2\u01bc\u01bd\7(\2\2\u01bd\u01be\7(\2\2\u01beN\3\2\2\2\u01bf"+
		"\u01c0\7~\2\2\u01c0\u01c1\7~\2\2\u01c1P\3\2\2\2\u01c2\u01c3\7`\2\2\u01c3"+
		"R\3\2\2\2\u01c4\u01c5\7,\2\2\u01c5T\3\2\2\2\u01c6\u01c7\7\61\2\2\u01c7"+
		"V\3\2\2\2\u01c8\u01c9\7-\2\2\u01c9X\3\2\2\2\u01ca\u01cb\7/\2\2\u01cbZ"+
		"\3\2\2\2\u01cc\u01cd\7\'\2\2\u01cd\\\3\2\2\2\u01ce\u01cf\7B\2\2\u01cf"+
		"^\3\2\2\2\u01d0\u01d1\7?\2\2\u01d1\u01d2\7?\2\2\u01d2`\3\2\2\2\u01d3\u01d4"+
		"\7#\2\2\u01d4\u01d5\7?\2\2\u01d5b\3\2\2\2\u01d6\u01d7\7@\2\2\u01d7\u01d8"+
		"\7?\2\2\u01d8d\3\2\2\2\u01d9\u01da\7>\2\2\u01da\u01db\7?\2\2\u01dbf\3"+
		"\2\2\2\u01dc\u01dd\7@\2\2\u01ddh\3\2\2\2\u01de\u01df\7>\2\2\u01dfj\3\2"+
		"\2\2\u01e0\u01e1\7?\2\2\u01e1l\3\2\2\2\u01e2\u01e3\7}\2\2\u01e3n\3\2\2"+
		"\2\u01e4\u01e5\7\177\2\2\u01e5p\3\2\2\2\u01e6\u01e7\7*\2\2\u01e7r\3\2"+
		"\2\2\u01e8\u01e9\7+\2\2\u01e9t\3\2\2\2\u01ea\u01eb\7]\2\2\u01ebv\3\2\2"+
		"\2\u01ec\u01ed\7_\2\2\u01edx\3\2\2\2\u01ee\u01ef\7<\2\2\u01efz\3\2\2\2"+
		"\u01f0\u01f1\7=\2\2\u01f1|\3\2\2\2\u01f2\u01f3\7$\2\2\u01f3~\3\2\2\2\u01f4"+
		"\u01f5\7\60\2\2\u01f5\u0080\3\2\2\2\u01f6\u01f7\7.\2\2\u01f7\u0082\3\2"+
		"\2\2\u01f8\u01f9\7#\2\2\u01f9\u0084\3\2\2\2\u01fa\u01fb\7A\2\2\u01fb\u0086"+
		"\3\2\2\2\u01fc\u01fd\7/\2\2\u01fd\u01fe\7@\2\2\u01fe\u0088\3\2\2\2\u01ff"+
		"\u0200\7?\2\2\u0200\u0201\7@\2\2\u0201\u008a\3\2\2\2\u0202\u0203\7k\2"+
		"\2\u0203\u0204\7p\2\2\u0204\u0205\7v\2\2\u0205\u008c\3\2\2\2\u0206\u0207"+
		"\7h\2\2\u0207\u0208\7n\2\2\u0208\u0209\7q\2\2\u0209\u020a\7c\2\2\u020a"+
		"\u020b\7v\2\2\u020b\u008e\3\2\2\2\u020c\u020d\7d\2\2\u020d\u020e\7{\2"+
		"\2\u020e\u020f\7v\2\2\u020f\u0210\7g\2\2\u0210\u0090\3\2\2\2\u0211\u0212"+
		"\7d\2\2\u0212\u0213\7q\2\2\u0213\u0214\7q\2\2\u0214\u0215\7n\2\2\u0215"+
		"\u0216\7g\2\2\u0216\u0217\7c\2\2\u0217\u0218\7p\2\2\u0218\u0092\3\2\2"+
		"\2\u0219\u021a\7x\2\2\u021a\u021b\7q\2\2\u021b\u021c\7k\2\2\u021c\u021d"+
		"\7f\2\2\u021d\u0094\3\2\2\2\u021e\u021f\7x\2\2\u021f\u0220\7c\2\2\u0220"+
		"\u0221\7t\2\2\u0221\u0096\3\2\2\2\u0222\u0223\7x\2\2\u0223\u0224\7c\2"+
		"\2\u0224\u0225\7n\2\2\u0225\u0098\3\2\2\2\u0226\u0227\7v\2\2\u0227\u0228"+
		"\7t\2\2\u0228\u0229\7w\2\2\u0229\u022a\7g\2\2\u022a\u009a\3\2\2\2\u022b"+
		"\u022c\7h\2\2\u022c\u022d\7c\2\2\u022d\u022e\7n\2\2\u022e\u022f\7u\2\2"+
		"\u022f\u0230\7g\2\2\u0230\u009c\3\2\2\2\u0231\u0236\5\u00a1Q\2\u0232\u0235"+
		"\5\u009fP\2\u0233\u0235\5\u00a1Q\2\u0234\u0232\3\2\2\2\u0234\u0233\3\2"+
		"\2\2\u0235\u0238\3\2\2\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237"+
		"\u009e\3\2\2\2\u0238\u0236\3\2\2\2\u0239\u023a\t\4\2\2\u023a\u00a0\3\2"+
		"\2\2\u023b\u023c\t\5\2\2\u023c\u00a2\3\2\2\2\u023d\u023e\7\61\2\2\u023e"+
		"\u023f\7\61\2\2\u023f\u0243\3\2\2\2\u0240\u0242\n\6\2\2\u0241\u0240\3"+
		"\2\2\2\u0242\u0245\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244"+
		"\u0246\3\2\2\2\u0245\u0243\3\2\2\2\u0246\u0247\bR\2\2\u0247\u00a4\3\2"+
		"\2\2\u0248\u0249\t\7\2\2\u0249\u024a\3\2\2\2\u024a\u024b\bS\2\2\u024b"+
		"\u00a6\3\2\2\2\u024c\u024d\13\2\2\2\u024d\u00a8\3\2\2\2\17\2\u018e\u0193"+
		"\u019a\u019d\u01a0\u01a5\u01a8\u01ae\u01b5\u0234\u0236\u0243\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}