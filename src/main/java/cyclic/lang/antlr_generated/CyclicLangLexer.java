// Generated from C:/ezz/Mods/CyclicCompiler/src/main/resources\CyclicLang.g4 by ANTLR 4.9.2
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
		DECLIT=34, INTLIT=35, STRLIT=36, BOOLLIT=37, NULL=38, AND=39, OR=40, UP=41, 
		STAR=42, SLASH=43, PLUS=44, MINUS=45, PERCENT=46, AT=47, LSHIFT=48, RSHIFT=49, 
		ULSHIFT=50, URSHIFT=51, EQUAL=52, INEQUAL=53, GREATEREQ=54, LESSEREQ=55, 
		GREATER=56, LESSER=57, ASSIGN=58, PASS=59, LBRACE=60, RBRACE=61, LPAREN=62, 
		RPAREN=63, LSQUAR=64, RSQUAR=65, COLON=66, SEMICOLON=67, QUOTE=68, DOT=69, 
		COMMA=70, EXCLAMATION=71, QUESTION=72, ELIPSES=73, DASHARROW=74, EQARROW=75, 
		INT=76, DEC=77, BYTE=78, BOOL=79, VOID=80, VAR=81, VAL=82, TRUE=83, FALSE=84, 
		ID=85, DIGIT=86, NONDIGIT=87, SING_COMMENT=88, WS=89, UNMATCHED=90;
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
			"NULL", "AND", "OR", "UP", "STAR", "SLASH", "PLUS", "MINUS", "PERCENT", 
			"AT", "LSHIFT", "RSHIFT", "ULSHIFT", "URSHIFT", "EQUAL", "INEQUAL", "GREATEREQ", 
			"LESSEREQ", "GREATER", "LESSER", "ASSIGN", "PASS", "LBRACE", "RBRACE", 
			"LPAREN", "RPAREN", "LSQUAR", "RSQUAR", "COLON", "SEMICOLON", "QUOTE", 
			"DOT", "COMMA", "EXCLAMATION", "QUESTION", "ELIPSES", "DASHARROW", "EQARROW", 
			"INT", "DEC", "BYTE", "BOOL", "VOID", "VAR", "VAL", "TRUE", "FALSE", 
			"ID", "DIGIT", "NONDIGIT", "SING_COMMENT", "WS", "UNMATCHED"
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
			"','", "'!'", "'?'", "'...'", "'->'", "'=>'", "'int'", "'float'", "'byte'", 
			"'boolean'", "'void'", "'var'", "'val'", "'true'", "'false'"
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
			"DOT", "COMMA", "EXCLAMATION", "QUESTION", "ELIPSES", "DASHARROW", "EQARROW", 
			"INT", "DEC", "BYTE", "BOOL", "VOID", "VAR", "VAL", "TRUE", "FALSE", 
			"ID", "DIGIT", "NONDIGIT", "SING_COMMENT", "WS", "UNMATCHED"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\\\u0278\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\5#\u01a4\n"+
		"#\3#\7#\u01a7\n#\f#\16#\u01aa\13#\3#\3#\6#\u01ae\n#\r#\16#\u01af\3#\5"+
		"#\u01b3\n#\3$\5$\u01b6\n$\3$\6$\u01b9\n$\r$\16$\u01ba\3$\5$\u01be\n$\3"+
		"%\3%\7%\u01c2\n%\f%\16%\u01c5\13%\3%\3%\3&\3&\5&\u01cb\n&\3\'\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3"+
		"\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3"+
		"\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\3:\3:"+
		"\3;\3;\3<\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E"+
		"\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3J\3J\3K\3K\3K\3L\3L\3L\3M\3M\3M\3M\3N"+
		"\3N\3N\3N\3N\3N\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q"+
		"\3R\3R\3R\3R\3S\3S\3S\3S\3T\3T\3T\3T\3T\3U\3U\3U\3U\3U\3U\3V\3V\3V\7V"+
		"\u025f\nV\fV\16V\u0262\13V\3W\3W\3X\3X\3Y\3Y\3Y\3Y\7Y\u026c\nY\fY\16Y"+
		"\u026f\13Y\3Y\3Y\3Z\3Z\3Z\3Z\3[\3[\3\u01c3\2\\\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081"+
		"B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095"+
		"L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9"+
		"V\u00abW\u00adX\u00afY\u00b1Z\u00b3[\u00b5\\\3\2\b\4\2ffhh\3\2$$\3\2\62"+
		";\t\2%&C\\aac|\u0080\u0080\u00a5\u00a5\u00c4\u00c4\4\2\f\f\17\17\5\2\13"+
		"\f\17\17\"\"\2\u0283\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2"+
		"\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w"+
		"\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2"+
		"\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d"+
		"\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2"+
		"\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af"+
		"\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\3\u00b7\3\2\2"+
		"\2\5\u00c1\3\2\2\2\7\u00c9\3\2\2\2\t\u00d0\3\2\2\2\13\u00dd\3\2\2\2\r"+
		"\u00e6\3\2\2\2\17\u00ed\3\2\2\2\21\u00f4\3\2\2\2\23\u00fa\3\2\2\2\25\u0103"+
		"\3\2\2\2\27\u010c\3\2\2\2\31\u0117\3\2\2\2\33\u011e\3\2\2\2\35\u0125\3"+
		"\2\2\2\37\u0129\3\2\2\2!\u012f\3\2\2\2#\u0139\3\2\2\2%\u013e\3\2\2\2\'"+
		"\u0145\3\2\2\2)\u014c\3\2\2\2+\u0153\3\2\2\2-\u015b\3\2\2\2/\u0163\3\2"+
		"\2\2\61\u016e\3\2\2\2\63\u0173\3\2\2\2\65\u017b\3\2\2\2\67\u0182\3\2\2"+
		"\29\u0188\3\2\2\2;\u018e\3\2\2\2=\u0193\3\2\2\2?\u0198\3\2\2\2A\u019c"+
		"\3\2\2\2C\u019f\3\2\2\2E\u01a3\3\2\2\2G\u01b5\3\2\2\2I\u01bf\3\2\2\2K"+
		"\u01ca\3\2\2\2M\u01cc\3\2\2\2O\u01d1\3\2\2\2Q\u01d4\3\2\2\2S\u01d7\3\2"+
		"\2\2U\u01d9\3\2\2\2W\u01db\3\2\2\2Y\u01dd\3\2\2\2[\u01df\3\2\2\2]\u01e1"+
		"\3\2\2\2_\u01e3\3\2\2\2a\u01e5\3\2\2\2c\u01e8\3\2\2\2e\u01eb\3\2\2\2g"+
		"\u01ef\3\2\2\2i\u01f3\3\2\2\2k\u01f6\3\2\2\2m\u01f9\3\2\2\2o\u01fc\3\2"+
		"\2\2q\u01ff\3\2\2\2s\u0201\3\2\2\2u\u0203\3\2\2\2w\u0205\3\2\2\2y\u0208"+
		"\3\2\2\2{\u020a\3\2\2\2}\u020c\3\2\2\2\177\u020e\3\2\2\2\u0081\u0210\3"+
		"\2\2\2\u0083\u0212\3\2\2\2\u0085\u0214\3\2\2\2\u0087\u0216\3\2\2\2\u0089"+
		"\u0218\3\2\2\2\u008b\u021a\3\2\2\2\u008d\u021c\3\2\2\2\u008f\u021e\3\2"+
		"\2\2\u0091\u0220\3\2\2\2\u0093\u0222\3\2\2\2\u0095\u0226\3\2\2\2\u0097"+
		"\u0229\3\2\2\2\u0099\u022c\3\2\2\2\u009b\u0230\3\2\2\2\u009d\u0236\3\2"+
		"\2\2\u009f\u023b\3\2\2\2\u00a1\u0243\3\2\2\2\u00a3\u0248\3\2\2\2\u00a5"+
		"\u024c\3\2\2\2\u00a7\u0250\3\2\2\2\u00a9\u0255\3\2\2\2\u00ab\u025b\3\2"+
		"\2\2\u00ad\u0263\3\2\2\2\u00af\u0265\3\2\2\2\u00b1\u0267\3\2\2\2\u00b3"+
		"\u0272\3\2\2\2\u00b5\u0276\3\2\2\2\u00b7\u00b8\7r\2\2\u00b8\u00b9\7t\2"+
		"\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd"+
		"\7e\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7f\2\2\u00c0"+
		"\4\3\2\2\2\u00c1\u00c2\7r\2\2\u00c2\u00c3\7t\2\2\u00c3\u00c4\7k\2\2\u00c4"+
		"\u00c5\7x\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7g\2\2"+
		"\u00c8\6\3\2\2\2\u00c9\u00ca\7r\2\2\u00ca\u00cb\7w\2\2\u00cb\u00cc\7d"+
		"\2\2\u00cc\u00cd\7n\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7e\2\2\u00cf\b"+
		"\3\2\2\2\u00d0\u00d1\7u\2\2\u00d1\u00d2\7{\2\2\u00d2\u00d3\7p\2\2\u00d3"+
		"\u00d4\7e\2\2\u00d4\u00d5\7j\2\2\u00d5\u00d6\7t\2\2\u00d6\u00d7\7q\2\2"+
		"\u00d7\u00d8\7p\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7u\2\2\u00da\u00db"+
		"\7g\2\2\u00db\u00dc\7f\2\2\u00dc\n\3\2\2\2\u00dd\u00de\7c\2\2\u00de\u00df"+
		"\7d\2\2\u00df\u00e0\7u\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7t\2\2\u00e2"+
		"\u00e3\7c\2\2\u00e3\u00e4\7e\2\2\u00e4\u00e5\7v\2\2\u00e5\f\3\2\2\2\u00e6"+
		"\u00e7\7p\2\2\u00e7\u00e8\7c\2\2\u00e8\u00e9\7v\2\2\u00e9\u00ea\7k\2\2"+
		"\u00ea\u00eb\7x\2\2\u00eb\u00ec\7g\2\2\u00ec\16\3\2\2\2\u00ed\u00ee\7"+
		"u\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1\7v\2\2\u00f1\u00f2"+
		"\7k\2\2\u00f2\u00f3\7e\2\2\u00f3\20\3\2\2\2\u00f4\u00f5\7h\2\2\u00f5\u00f6"+
		"\7k\2\2\u00f6\u00f7\7p\2\2\u00f7\u00f8\7c\2\2\u00f8\u00f9\7n\2\2\u00f9"+
		"\22\3\2\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7t\2\2\u00fd"+
		"\u00fe\7k\2\2\u00fe\u00ff\7e\2\2\u00ff\u0100\7v\2\2\u0100\u0101\7h\2\2"+
		"\u0101\u0102\7r\2\2\u0102\24\3\2\2\2\u0103\u0104\7x\2\2\u0104\u0105\7"+
		"q\2\2\u0105\u0106\7n\2\2\u0106\u0107\7c\2\2\u0107\u0108\7v\2\2\u0108\u0109"+
		"\7k\2\2\u0109\u010a\7n\2\2\u010a\u010b\7g\2\2\u010b\26\3\2\2\2\u010c\u010d"+
		"\7k\2\2\u010d\u010e\7p\2\2\u010e\u010f\7u\2\2\u010f\u0110\7v\2\2\u0110"+
		"\u0111\7c\2\2\u0111\u0112\7p\2\2\u0112\u0113\7e\2\2\u0113\u0114\7g\2\2"+
		"\u0114\u0115\7q\2\2\u0115\u0116\7h\2\2\u0116\30\3\2\2\2\u0117\u0118\7"+
		"t\2\2\u0118\u0119\7g\2\2\u0119\u011a\7v\2\2\u011a\u011b\7w\2\2\u011b\u011c"+
		"\7t\2\2\u011c\u011d\7p\2\2\u011d\32\3\2\2\2\u011e\u011f\7c\2\2\u011f\u0120"+
		"\7u\2\2\u0120\u0121\7u\2\2\u0121\u0122\7g\2\2\u0122\u0123\7t\2\2\u0123"+
		"\u0124\7v\2\2\u0124\34\3\2\2\2\u0125\u0126\7p\2\2\u0126\u0127\7g\2\2\u0127"+
		"\u0128\7y\2\2\u0128\36\3\2\2\2\u0129\u012a\7e\2\2\u012a\u012b\7n\2\2\u012b"+
		"\u012c\7c\2\2\u012c\u012d\7u\2\2\u012d\u012e\7u\2\2\u012e \3\2\2\2\u012f"+
		"\u0130\7k\2\2\u0130\u0131\7p\2\2\u0131\u0132\7v\2\2\u0132\u0133\7g\2\2"+
		"\u0133\u0134\7t\2\2\u0134\u0135\7h\2\2\u0135\u0136\7c\2\2\u0136\u0137"+
		"\7e\2\2\u0137\u0138\7g\2\2\u0138\"\3\2\2\2\u0139\u013a\7g\2\2\u013a\u013b"+
		"\7p\2\2\u013b\u013c\7w\2\2\u013c\u013d\7o\2\2\u013d$\3\2\2\2\u013e\u013f"+
		"\7t\2\2\u013f\u0140\7g\2\2\u0140\u0141\7e\2\2\u0141\u0142\7q\2\2\u0142"+
		"\u0143\7t\2\2\u0143\u0144\7f\2\2\u0144&\3\2\2\2\u0145\u0146\7u\2\2\u0146"+
		"\u0147\7k\2\2\u0147\u0148\7p\2\2\u0148\u0149\7i\2\2\u0149\u014a\7n\2\2"+
		"\u014a\u014b\7g\2\2\u014b(\3\2\2\2\u014c\u014d\7k\2\2\u014d\u014e\7o\2"+
		"\2\u014e\u014f\7r\2\2\u014f\u0150\7q\2\2\u0150\u0151\7t\2\2\u0151\u0152"+
		"\7v\2\2\u0152*\3\2\2\2\u0153\u0154\7r\2\2\u0154\u0155\7c\2\2\u0155\u0156"+
		"\7e\2\2\u0156\u0157\7m\2\2\u0157\u0158\7c\2\2\u0158\u0159\7i\2\2\u0159"+
		"\u015a\7g\2\2\u015a,\3\2\2\2\u015b\u015c\7g\2\2\u015c\u015d\7z\2\2\u015d"+
		"\u015e\7v\2\2\u015e\u015f\7g\2\2\u015f\u0160\7p\2\2\u0160\u0161\7f\2\2"+
		"\u0161\u0162\7u\2\2\u0162.\3\2\2\2\u0163\u0164\7k\2\2\u0164\u0165\7o\2"+
		"\2\u0165\u0166\7r\2\2\u0166\u0167\7n\2\2\u0167\u0168\7g\2\2\u0168\u0169"+
		"\7o\2\2\u0169\u016a\7g\2\2\u016a\u016b\7p\2\2\u016b\u016c\7v\2\2\u016c"+
		"\u016d\7u\2\2\u016d\60\3\2\2\2\u016e\u016f\7v\2\2\u016f\u0170\7j\2\2\u0170"+
		"\u0171\7k\2\2\u0171\u0172\7u\2\2\u0172\62\3\2\2\2\u0173\u0174\7f\2\2\u0174"+
		"\u0175\7g\2\2\u0175\u0176\7h\2\2\u0176\u0177\7c\2\2\u0177\u0178\7w\2\2"+
		"\u0178\u0179\7n\2\2\u0179\u017a\7v\2\2\u017a\64\3\2\2\2\u017b\u017c\7"+
		"u\2\2\u017c\u017d\7y\2\2\u017d\u017e\7k\2\2\u017e\u017f\7v\2\2\u017f\u0180"+
		"\7e\2\2\u0180\u0181\7j\2\2\u0181\66\3\2\2\2\u0182\u0183\7y\2\2\u0183\u0184"+
		"\7j\2\2\u0184\u0185\7k\2\2\u0185\u0186\7n\2\2\u0186\u0187\7g\2\2\u0187"+
		"8\3\2\2\2\u0188\u0189\7{\2\2\u0189\u018a\7k\2\2\u018a\u018b\7g\2\2\u018b"+
		"\u018c\7n\2\2\u018c\u018d\7f\2\2\u018d:\3\2\2\2\u018e\u018f\7e\2\2\u018f"+
		"\u0190\7c\2\2\u0190\u0191\7u\2\2\u0191\u0192\7g\2\2\u0192<\3\2\2\2\u0193"+
		"\u0194\7g\2\2\u0194\u0195\7n\2\2\u0195\u0196\7u\2\2\u0196\u0197\7g\2\2"+
		"\u0197>\3\2\2\2\u0198\u0199\7h\2\2\u0199\u019a\7q\2\2\u019a\u019b\7t\2"+
		"\2\u019b@\3\2\2\2\u019c\u019d\7f\2\2\u019d\u019e\7q\2\2\u019eB\3\2\2\2"+
		"\u019f\u01a0\7k\2\2\u01a0\u01a1\7h\2\2\u01a1D\3\2\2\2\u01a2\u01a4\5[."+
		"\2\u01a3\u01a2\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a8\3\2\2\2\u01a5\u01a7"+
		"\5\u00adW\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2\2"+
		"\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ad"+
		"\5\u008bF\2\u01ac\u01ae\5\u00adW\2\u01ad\u01ac\3\2\2\2\u01ae\u01af\3\2"+
		"\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b2\3\2\2\2\u01b1"+
		"\u01b3\t\2\2\2\u01b2\u01b1\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3F\3\2\2\2"+
		"\u01b4\u01b6\5[.\2\u01b5\u01b4\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b8"+
		"\3\2\2\2\u01b7\u01b9\5\u00adW\2\u01b8\u01b7\3\2\2\2\u01b9\u01ba\3\2\2"+
		"\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd\3\2\2\2\u01bc\u01be"+
		"\t\2\2\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2\2\2\u01beH\3\2\2\2\u01bf"+
		"\u01c3\5\u0089E\2\u01c0\u01c2\n\3\2\2\u01c1\u01c0\3\2\2\2\u01c2\u01c5"+
		"\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5"+
		"\u01c3\3\2\2\2\u01c6\u01c7\5\u0089E\2\u01c7J\3\2\2\2\u01c8\u01cb\5\u00a7"+
		"T\2\u01c9\u01cb\5\u00a9U\2\u01ca\u01c8\3\2\2\2\u01ca\u01c9\3\2\2\2\u01cb"+
		"L\3\2\2\2\u01cc\u01cd\7p\2\2\u01cd\u01ce\7w\2\2\u01ce\u01cf\7n\2\2\u01cf"+
		"\u01d0\7n\2\2\u01d0N\3\2\2\2\u01d1\u01d2\7(\2\2\u01d2\u01d3\7(\2\2\u01d3"+
		"P\3\2\2\2\u01d4\u01d5\7~\2\2\u01d5\u01d6\7~\2\2\u01d6R\3\2\2\2\u01d7\u01d8"+
		"\7`\2\2\u01d8T\3\2\2\2\u01d9\u01da\7,\2\2\u01daV\3\2\2\2\u01db\u01dc\7"+
		"\61\2\2\u01dcX\3\2\2\2\u01dd\u01de\7-\2\2\u01deZ\3\2\2\2\u01df\u01e0\7"+
		"/\2\2\u01e0\\\3\2\2\2\u01e1\u01e2\7\'\2\2\u01e2^\3\2\2\2\u01e3\u01e4\7"+
		"B\2\2\u01e4`\3\2\2\2\u01e5\u01e6\7>\2\2\u01e6\u01e7\7>\2\2\u01e7b\3\2"+
		"\2\2\u01e8\u01e9\7@\2\2\u01e9\u01ea\7@\2\2\u01ead\3\2\2\2\u01eb\u01ec"+
		"\7>\2\2\u01ec\u01ed\7>\2\2\u01ed\u01ee\7>\2\2\u01eef\3\2\2\2\u01ef\u01f0"+
		"\7@\2\2\u01f0\u01f1\7@\2\2\u01f1\u01f2\7@\2\2\u01f2h\3\2\2\2\u01f3\u01f4"+
		"\7?\2\2\u01f4\u01f5\7?\2\2\u01f5j\3\2\2\2\u01f6\u01f7\7#\2\2\u01f7\u01f8"+
		"\7?\2\2\u01f8l\3\2\2\2\u01f9\u01fa\7@\2\2\u01fa\u01fb\7?\2\2\u01fbn\3"+
		"\2\2\2\u01fc\u01fd\7>\2\2\u01fd\u01fe\7?\2\2\u01fep\3\2\2\2\u01ff\u0200"+
		"\7@\2\2\u0200r\3\2\2\2\u0201\u0202\7>\2\2\u0202t\3\2\2\2\u0203\u0204\7"+
		"?\2\2\u0204v\3\2\2\2\u0205\u0206\7~\2\2\u0206\u0207\7@\2\2\u0207x\3\2"+
		"\2\2\u0208\u0209\7}\2\2\u0209z\3\2\2\2\u020a\u020b\7\177\2\2\u020b|\3"+
		"\2\2\2\u020c\u020d\7*\2\2\u020d~\3\2\2\2\u020e\u020f\7+\2\2\u020f\u0080"+
		"\3\2\2\2\u0210\u0211\7]\2\2\u0211\u0082\3\2\2\2\u0212\u0213\7_\2\2\u0213"+
		"\u0084\3\2\2\2\u0214\u0215\7<\2\2\u0215\u0086\3\2\2\2\u0216\u0217\7=\2"+
		"\2\u0217\u0088\3\2\2\2\u0218\u0219\7$\2\2\u0219\u008a\3\2\2\2\u021a\u021b"+
		"\7\60\2\2\u021b\u008c\3\2\2\2\u021c\u021d\7.\2\2\u021d\u008e\3\2\2\2\u021e"+
		"\u021f\7#\2\2\u021f\u0090\3\2\2\2\u0220\u0221\7A\2\2\u0221\u0092\3\2\2"+
		"\2\u0222\u0223\7\60\2\2\u0223\u0224\7\60\2\2\u0224\u0225\7\60\2\2\u0225"+
		"\u0094\3\2\2\2\u0226\u0227\7/\2\2\u0227\u0228\7@\2\2\u0228\u0096\3\2\2"+
		"\2\u0229\u022a\7?\2\2\u022a\u022b\7@\2\2\u022b\u0098\3\2\2\2\u022c\u022d"+
		"\7k\2\2\u022d\u022e\7p\2\2\u022e\u022f\7v\2\2\u022f\u009a\3\2\2\2\u0230"+
		"\u0231\7h\2\2\u0231\u0232\7n\2\2\u0232\u0233\7q\2\2\u0233\u0234\7c\2\2"+
		"\u0234\u0235\7v\2\2\u0235\u009c\3\2\2\2\u0236\u0237\7d\2\2\u0237\u0238"+
		"\7{\2\2\u0238\u0239\7v\2\2\u0239\u023a\7g\2\2\u023a\u009e\3\2\2\2\u023b"+
		"\u023c\7d\2\2\u023c\u023d\7q\2\2\u023d\u023e\7q\2\2\u023e\u023f\7n\2\2"+
		"\u023f\u0240\7g\2\2\u0240\u0241\7c\2\2\u0241\u0242\7p\2\2\u0242\u00a0"+
		"\3\2\2\2\u0243\u0244\7x\2\2\u0244\u0245\7q\2\2\u0245\u0246\7k\2\2\u0246"+
		"\u0247\7f\2\2\u0247\u00a2\3\2\2\2\u0248\u0249\7x\2\2\u0249\u024a\7c\2"+
		"\2\u024a\u024b\7t\2\2\u024b\u00a4\3\2\2\2\u024c\u024d\7x\2\2\u024d\u024e"+
		"\7c\2\2\u024e\u024f\7n\2\2\u024f\u00a6\3\2\2\2\u0250\u0251\7v\2\2\u0251"+
		"\u0252\7t\2\2\u0252\u0253\7w\2\2\u0253\u0254\7g\2\2\u0254\u00a8\3\2\2"+
		"\2\u0255\u0256\7h\2\2\u0256\u0257\7c\2\2\u0257\u0258\7n\2\2\u0258\u0259"+
		"\7u\2\2\u0259\u025a\7g\2\2\u025a\u00aa\3\2\2\2\u025b\u0260\5\u00afX\2"+
		"\u025c\u025f\5\u00adW\2\u025d\u025f\5\u00afX\2\u025e\u025c\3\2\2\2\u025e"+
		"\u025d\3\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2"+
		"\2\2\u0261\u00ac\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u0264\t\4\2\2\u0264"+
		"\u00ae\3\2\2\2\u0265\u0266\t\5\2\2\u0266\u00b0\3\2\2\2\u0267\u0268\7\61"+
		"\2\2\u0268\u0269\7\61\2\2\u0269\u026d\3\2\2\2\u026a\u026c\n\6\2\2\u026b"+
		"\u026a\3\2\2\2\u026c\u026f\3\2\2\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2"+
		"\2\2\u026e\u0270\3\2\2\2\u026f\u026d\3\2\2\2\u0270\u0271\bY\2\2\u0271"+
		"\u00b2\3\2\2\2\u0272\u0273\t\7\2\2\u0273\u0274\3\2\2\2\u0274\u0275\bZ"+
		"\2\2\u0275\u00b4\3\2\2\2\u0276\u0277\13\2\2\2\u0277\u00b6\3\2\2\2\17\2"+
		"\u01a3\u01a8\u01af\u01b2\u01b5\u01ba\u01bd\u01c3\u01ca\u025e\u0260\u026d"+
		"\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}