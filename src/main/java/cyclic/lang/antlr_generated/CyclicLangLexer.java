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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PROTECTED", "PRIVATE", "PUBLIC", "SYNCHRONISED", "ABSTRACT", "NATIVE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2S\u022b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \6 \u0179\n \r \16 \u017a\3"+
		" \3 \6 \u017f\n \r \16 \u0180\3!\6!\u0184\n!\r!\16!\u0185\3\"\3\"\7\""+
		"\u018a\n\"\f\"\16\"\u018d\13\"\3\"\3\"\3#\3#\5#\u0193\n#\3$\3$\3$\3$\3"+
		"$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3."+
		"\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3"+
		"\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3="+
		"\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3B\3C\3C\3C\3D\3D\3D\3D\3E\3E\3E\3E\3E"+
		"\3E\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3I\3I\3I\3I"+
		"\3J\3J\3J\3J\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3L\3M\3M\3M\7M\u0212\nM\fM"+
		"\16M\u0215\13M\3N\3N\3O\3O\3P\3P\3P\3P\7P\u021f\nP\fP\16P\u0222\13P\3"+
		"P\3P\3Q\3Q\3Q\3Q\3R\3R\4\u017a\u018b\2S\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W"+
		"-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097"+
		"M\u0099N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\3\2\7\3\2$$\3\2\62;\t\2%&"+
		"C\\aac|\u0080\u0080\u00a5\u00a5\u00c4\u00c4\4\2\f\f\17\17\5\2\13\f\17"+
		"\17\"\"\2\u0232\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3"+
		"\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2"+
		"\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083"+
		"\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2"+
		"\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095"+
		"\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2"+
		"\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\3\u00a5\3\2\2\2\5\u00af"+
		"\3\2\2\2\7\u00b7\3\2\2\2\t\u00be\3\2\2\2\13\u00cb\3\2\2\2\r\u00d4\3\2"+
		"\2\2\17\u00db\3\2\2\2\21\u00e2\3\2\2\2\23\u00e8\3\2\2\2\25\u00f3\3\2\2"+
		"\2\27\u00fa\3\2\2\2\31\u0101\3\2\2\2\33\u0105\3\2\2\2\35\u010f\3\2\2\2"+
		"\37\u0116\3\2\2\2!\u011c\3\2\2\2#\u0121\3\2\2\2%\u0128\3\2\2\2\'\u0130"+
		"\3\2\2\2)\u0138\3\2\2\2+\u0143\3\2\2\2-\u0148\3\2\2\2/\u0150\3\2\2\2\61"+
		"\u0157\3\2\2\2\63\u015d\3\2\2\2\65\u0163\3\2\2\2\67\u0168\3\2\2\29\u016d"+
		"\3\2\2\2;\u0171\3\2\2\2=\u0174\3\2\2\2?\u0178\3\2\2\2A\u0183\3\2\2\2C"+
		"\u0187\3\2\2\2E\u0192\3\2\2\2G\u0194\3\2\2\2I\u0199\3\2\2\2K\u019c\3\2"+
		"\2\2M\u019f\3\2\2\2O\u01a1\3\2\2\2Q\u01a3\3\2\2\2S\u01a5\3\2\2\2U\u01a7"+
		"\3\2\2\2W\u01a9\3\2\2\2Y\u01ab\3\2\2\2[\u01ad\3\2\2\2]\u01b0\3\2\2\2_"+
		"\u01b3\3\2\2\2a\u01b6\3\2\2\2c\u01b9\3\2\2\2e\u01bb\3\2\2\2g\u01bd\3\2"+
		"\2\2i\u01bf\3\2\2\2k\u01c1\3\2\2\2m\u01c3\3\2\2\2o\u01c5\3\2\2\2q\u01c7"+
		"\3\2\2\2s\u01c9\3\2\2\2u\u01cb\3\2\2\2w\u01cd\3\2\2\2y\u01cf\3\2\2\2{"+
		"\u01d1\3\2\2\2}\u01d3\3\2\2\2\177\u01d5\3\2\2\2\u0081\u01d7\3\2\2\2\u0083"+
		"\u01d9\3\2\2\2\u0085\u01dc\3\2\2\2\u0087\u01df\3\2\2\2\u0089\u01e3\3\2"+
		"\2\2\u008b\u01e9\3\2\2\2\u008d\u01ee\3\2\2\2\u008f\u01f6\3\2\2\2\u0091"+
		"\u01fb\3\2\2\2\u0093\u01ff\3\2\2\2\u0095\u0203\3\2\2\2\u0097\u0208\3\2"+
		"\2\2\u0099\u020e\3\2\2\2\u009b\u0216\3\2\2\2\u009d\u0218\3\2\2\2\u009f"+
		"\u021a\3\2\2\2\u00a1\u0225\3\2\2\2\u00a3\u0229\3\2\2\2\u00a5\u00a6\7r"+
		"\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa"+
		"\7g\2\2\u00aa\u00ab\7e\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7g\2\2\u00ad"+
		"\u00ae\7f\2\2\u00ae\4\3\2\2\2\u00af\u00b0\7r\2\2\u00b0\u00b1\7t\2\2\u00b1"+
		"\u00b2\7k\2\2\u00b2\u00b3\7x\2\2\u00b3\u00b4\7c\2\2\u00b4\u00b5\7v\2\2"+
		"\u00b5\u00b6\7g\2\2\u00b6\6\3\2\2\2\u00b7\u00b8\7r\2\2\u00b8\u00b9\7w"+
		"\2\2\u00b9\u00ba\7d\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd"+
		"\7e\2\2\u00bd\b\3\2\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7{\2\2\u00c0\u00c1"+
		"\7p\2\2\u00c1\u00c2\7e\2\2\u00c2\u00c3\7j\2\2\u00c3\u00c4\7t\2\2\u00c4"+
		"\u00c5\7q\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7k\2\2\u00c7\u00c8\7u\2\2"+
		"\u00c8\u00c9\7g\2\2\u00c9\u00ca\7f\2\2\u00ca\n\3\2\2\2\u00cb\u00cc\7c"+
		"\2\2\u00cc\u00cd\7d\2\2\u00cd\u00ce\7u\2\2\u00ce\u00cf\7v\2\2\u00cf\u00d0"+
		"\7t\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7e\2\2\u00d2\u00d3\7v\2\2\u00d3"+
		"\f\3\2\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7v\2\2\u00d7"+
		"\u00d8\7k\2\2\u00d8\u00d9\7x\2\2\u00d9\u00da\7g\2\2\u00da\16\3\2\2\2\u00db"+
		"\u00dc\7u\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7c\2\2\u00de\u00df\7v\2\2"+
		"\u00df\u00e0\7k\2\2\u00e0\u00e1\7e\2\2\u00e1\20\3\2\2\2\u00e2\u00e3\7"+
		"h\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7c\2\2\u00e6\u00e7"+
		"\7n\2\2\u00e7\22\3\2\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb"+
		"\7u\2\2\u00eb\u00ec\7v\2\2\u00ec\u00ed\7c\2\2\u00ed\u00ee\7p\2\2\u00ee"+
		"\u00ef\7e\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7q\2\2\u00f1\u00f2\7h\2\2"+
		"\u00f2\24\3\2\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7g\2\2\u00f5\u00f6\7"+
		"v\2\2\u00f6\u00f7\7w\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7p\2\2\u00f9\26"+
		"\3\2\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7u\2\2\u00fc\u00fd\7u\2\2\u00fd"+
		"\u00fe\7g\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100\7v\2\2\u0100\30\3\2\2\2\u0101"+
		"\u0102\7p\2\2\u0102\u0103\7g\2\2\u0103\u0104\7y\2\2\u0104\32\3\2\2\2\u0105"+
		"\u0106\7k\2\2\u0106\u0107\7p\2\2\u0107\u0108\7v\2\2\u0108\u0109\7g\2\2"+
		"\u0109\u010a\7t\2\2\u010a\u010b\7h\2\2\u010b\u010c\7c\2\2\u010c\u010d"+
		"\7e\2\2\u010d\u010e\7g\2\2\u010e\34\3\2\2\2\u010f\u0110\7u\2\2\u0110\u0111"+
		"\7k\2\2\u0111\u0112\7p\2\2\u0112\u0113\7i\2\2\u0113\u0114\7n\2\2\u0114"+
		"\u0115\7g\2\2\u0115\36\3\2\2\2\u0116\u0117\7e\2\2\u0117\u0118\7n\2\2\u0118"+
		"\u0119\7c\2\2\u0119\u011a\7u\2\2\u011a\u011b\7u\2\2\u011b \3\2\2\2\u011c"+
		"\u011d\7g\2\2\u011d\u011e\7p\2\2\u011e\u011f\7w\2\2\u011f\u0120\7o\2\2"+
		"\u0120\"\3\2\2\2\u0121\u0122\7k\2\2\u0122\u0123\7o\2\2\u0123\u0124\7r"+
		"\2\2\u0124\u0125\7q\2\2\u0125\u0126\7t\2\2\u0126\u0127\7v\2\2\u0127$\3"+
		"\2\2\2\u0128\u0129\7r\2\2\u0129\u012a\7c\2\2\u012a\u012b\7e\2\2\u012b"+
		"\u012c\7m\2\2\u012c\u012d\7c\2\2\u012d\u012e\7i\2\2\u012e\u012f\7g\2\2"+
		"\u012f&\3\2\2\2\u0130\u0131\7g\2\2\u0131\u0132\7z\2\2\u0132\u0133\7v\2"+
		"\2\u0133\u0134\7g\2\2\u0134\u0135\7p\2\2\u0135\u0136\7f\2\2\u0136\u0137"+
		"\7u\2\2\u0137(\3\2\2\2\u0138\u0139\7k\2\2\u0139\u013a\7o\2\2\u013a\u013b"+
		"\7r\2\2\u013b\u013c\7n\2\2\u013c\u013d\7g\2\2\u013d\u013e\7o\2\2\u013e"+
		"\u013f\7g\2\2\u013f\u0140\7p\2\2\u0140\u0141\7v\2\2\u0141\u0142\7u\2\2"+
		"\u0142*\3\2\2\2\u0143\u0144\7v\2\2\u0144\u0145\7j\2\2\u0145\u0146\7k\2"+
		"\2\u0146\u0147\7u\2\2\u0147,\3\2\2\2\u0148\u0149\7f\2\2\u0149\u014a\7"+
		"g\2\2\u014a\u014b\7h\2\2\u014b\u014c\7c\2\2\u014c\u014d\7w\2\2\u014d\u014e"+
		"\7n\2\2\u014e\u014f\7v\2\2\u014f.\3\2\2\2\u0150\u0151\7u\2\2\u0151\u0152"+
		"\7y\2\2\u0152\u0153\7k\2\2\u0153\u0154\7v\2\2\u0154\u0155\7e\2\2\u0155"+
		"\u0156\7j\2\2\u0156\60\3\2\2\2\u0157\u0158\7y\2\2\u0158\u0159\7j\2\2\u0159"+
		"\u015a\7k\2\2\u015a\u015b\7n\2\2\u015b\u015c\7g\2\2\u015c\62\3\2\2\2\u015d"+
		"\u015e\7{\2\2\u015e\u015f\7k\2\2\u015f\u0160\7g\2\2\u0160\u0161\7n\2\2"+
		"\u0161\u0162\7f\2\2\u0162\64\3\2\2\2\u0163\u0164\7e\2\2\u0164\u0165\7"+
		"c\2\2\u0165\u0166\7u\2\2\u0166\u0167\7g\2\2\u0167\66\3\2\2\2\u0168\u0169"+
		"\7g\2\2\u0169\u016a\7n\2\2\u016a\u016b\7u\2\2\u016b\u016c\7g\2\2\u016c"+
		"8\3\2\2\2\u016d\u016e\7h\2\2\u016e\u016f\7q\2\2\u016f\u0170\7t\2\2\u0170"+
		":\3\2\2\2\u0171\u0172\7f\2\2\u0172\u0173\7q\2\2\u0173<\3\2\2\2\u0174\u0175"+
		"\7k\2\2\u0175\u0176\7h\2\2\u0176>\3\2\2\2\u0177\u0179\5\u009bN\2\u0178"+
		"\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\3\2\2\2\u017a\u0178\3\2"+
		"\2\2\u017b\u017c\3\2\2\2\u017c\u017e\5{>\2\u017d\u017f\5\u009bN\2\u017e"+
		"\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2"+
		"\2\2\u0181@\3\2\2\2\u0182\u0184\5\u009bN\2\u0183\u0182\3\2\2\2\u0184\u0185"+
		"\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186B\3\2\2\2\u0187"+
		"\u018b\5y=\2\u0188\u018a\n\2\2\2\u0189\u0188\3\2\2\2\u018a\u018d\3\2\2"+
		"\2\u018b\u018c\3\2\2\2\u018b\u0189\3\2\2\2\u018c\u018e\3\2\2\2\u018d\u018b"+
		"\3\2\2\2\u018e\u018f\5y=\2\u018fD\3\2\2\2\u0190\u0193\5\u0095K\2\u0191"+
		"\u0193\5\u0097L\2\u0192\u0190\3\2\2\2\u0192\u0191\3\2\2\2\u0193F\3\2\2"+
		"\2\u0194\u0195\7p\2\2\u0195\u0196\7w\2\2\u0196\u0197\7n\2\2\u0197\u0198"+
		"\7n\2\2\u0198H\3\2\2\2\u0199\u019a\7(\2\2\u019a\u019b\7(\2\2\u019bJ\3"+
		"\2\2\2\u019c\u019d\7~\2\2\u019d\u019e\7~\2\2\u019eL\3\2\2\2\u019f\u01a0"+
		"\7`\2\2\u01a0N\3\2\2\2\u01a1\u01a2\7,\2\2\u01a2P\3\2\2\2\u01a3\u01a4\7"+
		"\61\2\2\u01a4R\3\2\2\2\u01a5\u01a6\7-\2\2\u01a6T\3\2\2\2\u01a7\u01a8\7"+
		"/\2\2\u01a8V\3\2\2\2\u01a9\u01aa\7\'\2\2\u01aaX\3\2\2\2\u01ab\u01ac\7"+
		"B\2\2\u01acZ\3\2\2\2\u01ad\u01ae\7?\2\2\u01ae\u01af\7?\2\2\u01af\\\3\2"+
		"\2\2\u01b0\u01b1\7#\2\2\u01b1\u01b2\7?\2\2\u01b2^\3\2\2\2\u01b3\u01b4"+
		"\7@\2\2\u01b4\u01b5\7?\2\2\u01b5`\3\2\2\2\u01b6\u01b7\7>\2\2\u01b7\u01b8"+
		"\7?\2\2\u01b8b\3\2\2\2\u01b9\u01ba\7@\2\2\u01bad\3\2\2\2\u01bb\u01bc\7"+
		">\2\2\u01bcf\3\2\2\2\u01bd\u01be\7?\2\2\u01beh\3\2\2\2\u01bf\u01c0\7}"+
		"\2\2\u01c0j\3\2\2\2\u01c1\u01c2\7\177\2\2\u01c2l\3\2\2\2\u01c3\u01c4\7"+
		"*\2\2\u01c4n\3\2\2\2\u01c5\u01c6\7+\2\2\u01c6p\3\2\2\2\u01c7\u01c8\7]"+
		"\2\2\u01c8r\3\2\2\2\u01c9\u01ca\7_\2\2\u01cat\3\2\2\2\u01cb\u01cc\7<\2"+
		"\2\u01ccv\3\2\2\2\u01cd\u01ce\7=\2\2\u01cex\3\2\2\2\u01cf\u01d0\7$\2\2"+
		"\u01d0z\3\2\2\2\u01d1\u01d2\7\60\2\2\u01d2|\3\2\2\2\u01d3\u01d4\7.\2\2"+
		"\u01d4~\3\2\2\2\u01d5\u01d6\7#\2\2\u01d6\u0080\3\2\2\2\u01d7\u01d8\7A"+
		"\2\2\u01d8\u0082\3\2\2\2\u01d9\u01da\7/\2\2\u01da\u01db\7@\2\2\u01db\u0084"+
		"\3\2\2\2\u01dc\u01dd\7?\2\2\u01dd\u01de\7@\2\2\u01de\u0086\3\2\2\2\u01df"+
		"\u01e0\7k\2\2\u01e0\u01e1\7p\2\2\u01e1\u01e2\7v\2\2\u01e2\u0088\3\2\2"+
		"\2\u01e3\u01e4\7h\2\2\u01e4\u01e5\7n\2\2\u01e5\u01e6\7q\2\2\u01e6\u01e7"+
		"\7c\2\2\u01e7\u01e8\7v\2\2\u01e8\u008a\3\2\2\2\u01e9\u01ea\7d\2\2\u01ea"+
		"\u01eb\7{\2\2\u01eb\u01ec\7v\2\2\u01ec\u01ed\7g\2\2\u01ed\u008c\3\2\2"+
		"\2\u01ee\u01ef\7d\2\2\u01ef\u01f0\7q\2\2\u01f0\u01f1\7q\2\2\u01f1\u01f2"+
		"\7n\2\2\u01f2\u01f3\7g\2\2\u01f3\u01f4\7c\2\2\u01f4\u01f5\7p\2\2\u01f5"+
		"\u008e\3\2\2\2\u01f6\u01f7\7x\2\2\u01f7\u01f8\7q\2\2\u01f8\u01f9\7k\2"+
		"\2\u01f9\u01fa\7f\2\2\u01fa\u0090\3\2\2\2\u01fb\u01fc\7x\2\2\u01fc\u01fd"+
		"\7c\2\2\u01fd\u01fe\7t\2\2\u01fe\u0092\3\2\2\2\u01ff\u0200\7x\2\2\u0200"+
		"\u0201\7c\2\2\u0201\u0202\7n\2\2\u0202\u0094\3\2\2\2\u0203\u0204\7v\2"+
		"\2\u0204\u0205\7t\2\2\u0205\u0206\7w\2\2\u0206\u0207\7g\2\2\u0207\u0096"+
		"\3\2\2\2\u0208\u0209\7h\2\2\u0209\u020a\7c\2\2\u020a\u020b\7n\2\2\u020b"+
		"\u020c\7u\2\2\u020c\u020d\7g\2\2\u020d\u0098\3\2\2\2\u020e\u0213\5\u009d"+
		"O\2\u020f\u0212\5\u009bN\2\u0210\u0212\5\u009dO\2\u0211\u020f\3\2\2\2"+
		"\u0211\u0210\3\2\2\2\u0212\u0215\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214"+
		"\3\2\2\2\u0214\u009a\3\2\2\2\u0215\u0213\3\2\2\2\u0216\u0217\t\3\2\2\u0217"+
		"\u009c\3\2\2\2\u0218\u0219\t\4\2\2\u0219\u009e\3\2\2\2\u021a\u021b\7\61"+
		"\2\2\u021b\u021c\7\61\2\2\u021c\u0220\3\2\2\2\u021d\u021f\n\5\2\2\u021e"+
		"\u021d\3\2\2\2\u021f\u0222\3\2\2\2\u0220\u021e\3\2\2\2\u0220\u0221\3\2"+
		"\2\2\u0221\u0223\3\2\2\2\u0222\u0220\3\2\2\2\u0223\u0224\bP\2\2\u0224"+
		"\u00a0\3\2\2\2\u0225\u0226\t\6\2\2\u0226\u0227\3\2\2\2\u0227\u0228\bQ"+
		"\2\2\u0228\u00a2\3\2\2\2\u0229\u022a\13\2\2\2\u022a\u00a4\3\2\2\2\13\2"+
		"\u017a\u0180\u0185\u018b\u0192\u0211\u0213\u0220\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}