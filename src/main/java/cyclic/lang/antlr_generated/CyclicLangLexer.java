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
		ASSERT=13, NEW=14, THROW=15, CLASS=16, INTERFACE=17, ENUM=18, RECORD=19, 
		SINGLE=20, ANNOTATION=21, IMPORT=22, PACKAGE=23, EXTENDS=24, IMPLEMENTS=25, 
		THIS=26, SUPER=27, IN=28, OUT=29, SEALED=30, PERMITS=31, NONSEALED=32, 
		DEFAULT=33, SWITCH=34, WHILE=35, YIELD=36, CASE=37, ELSE=38, FOR=39, DO=40, 
		IF=41, DECLIT=42, INTLIT=43, STRLIT=44, BOOLLIT=45, NULL=46, AND=47, OR=48, 
		PLUSPLUS=49, MINUSMINUS=50, BITAND=51, BITOR=52, UP=53, STAR=54, SLASH=55, 
		PLUS=56, MINUS=57, PERCENT=58, AT=59, LSHIFT=60, RSHIFT=61, ULSHIFT=62, 
		URSHIFT=63, EQUAL=64, INEQUAL=65, GREATEREQ=66, LESSEREQ=67, GREATER=68, 
		LESSER=69, ASSIGN=70, PASS=71, LBRACE=72, RBRACE=73, LPAREN=74, RPAREN=75, 
		LSQUAR=76, RSQUAR=77, COLON=78, SEMICOLON=79, QUOTE=80, DOT=81, COMMA=82, 
		EXCLAMATION=83, QUESTION=84, ELIPSES=85, DASHARROW=86, EQARROW=87, BOOL=88, 
		BYTE=89, SHORT=90, INT=91, LONG=92, FLOAT=93, DOUBLE=94, VOID=95, VAR=96, 
		VAL=97, TRUE=98, FALSE=99, ID=100, DIGIT=101, NONDIGIT=102, SING_COMMENT=103, 
		WS=104, UNMATCHED=105;
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
			"NEW", "THROW", "CLASS", "INTERFACE", "ENUM", "RECORD", "SINGLE", "ANNOTATION", 
			"IMPORT", "PACKAGE", "EXTENDS", "IMPLEMENTS", "THIS", "SUPER", "IN", 
			"OUT", "SEALED", "PERMITS", "NONSEALED", "DEFAULT", "SWITCH", "WHILE", 
			"YIELD", "CASE", "ELSE", "FOR", "DO", "IF", "DECLIT", "INTLIT", "STRLIT", 
			"BOOLLIT", "NULL", "AND", "OR", "PLUSPLUS", "MINUSMINUS", "BITAND", "BITOR", 
			"UP", "STAR", "SLASH", "PLUS", "MINUS", "PERCENT", "AT", "LSHIFT", "RSHIFT", 
			"ULSHIFT", "URSHIFT", "EQUAL", "INEQUAL", "GREATEREQ", "LESSEREQ", "GREATER", 
			"LESSER", "ASSIGN", "PASS", "LBRACE", "RBRACE", "LPAREN", "RPAREN", "LSQUAR", 
			"RSQUAR", "COLON", "SEMICOLON", "QUOTE", "DOT", "COMMA", "EXCLAMATION", 
			"QUESTION", "ELIPSES", "DASHARROW", "EQARROW", "BOOL", "BYTE", "SHORT", 
			"INT", "LONG", "FLOAT", "DOUBLE", "VOID", "VAR", "VAL", "TRUE", "FALSE", 
			"ID", "DIGIT", "NONDIGIT", "SING_COMMENT", "WS", "UNMATCHED"
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
			"'null'", "'&&'", "'||'", "'++'", "'--'", "'&'", "'|'", "'^'", "'*'", 
			"'/'", "'+'", "'-'", "'%'", "'@'", "'<<'", "'>>'", "'<<<'", "'>>>'", 
			"'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'='", "'|>'", "'{'", "'}'", 
			"'('", "')'", "'['", "']'", "':'", "';'", "'\"'", "'.'", "','", "'!'", 
			"'?'", "'...'", "'->'", "'=>'", "'boolean'", "'byte'", "'short'", "'int'", 
			"'long'", "'float'", "'double'", "'void'", "'var'", "'val'", "'true'", 
			"'false'"
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
			"BOOLLIT", "NULL", "AND", "OR", "PLUSPLUS", "MINUSMINUS", "BITAND", "BITOR", 
			"UP", "STAR", "SLASH", "PLUS", "MINUS", "PERCENT", "AT", "LSHIFT", "RSHIFT", 
			"ULSHIFT", "URSHIFT", "EQUAL", "INEQUAL", "GREATEREQ", "LESSEREQ", "GREATER", 
			"LESSER", "ASSIGN", "PASS", "LBRACE", "RBRACE", "LPAREN", "RPAREN", "LSQUAR", 
			"RSQUAR", "COLON", "SEMICOLON", "QUOTE", "DOT", "COMMA", "EXCLAMATION", 
			"QUESTION", "ELIPSES", "DASHARROW", "EQARROW", "BOOL", "BYTE", "SHORT", 
			"INT", "LONG", "FLOAT", "DOUBLE", "VOID", "VAR", "VAL", "TRUE", "FALSE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2k\u02ea\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3"+
		"\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\5+\u01fa\n+\3+\7+"+
		"\u01fd\n+\f+\16+\u0200\13+\3+\3+\6+\u0204\n+\r+\16+\u0205\3+\5+\u0209"+
		"\n+\3,\5,\u020c\n,\3,\6,\u020f\n,\r,\16,\u0210\3,\5,\u0214\n,\3-\3-\7"+
		"-\u0218\n-\f-\16-\u021b\13-\3-\3-\3.\3.\5.\u0221\n.\3/\3/\3/\3/\3/\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\65"+
		"\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3=\3>\3"+
		">\3>\3?\3?\3?\3?\3@\3@\3@\3@\3A\3A\3A\3B\3B\3B\3C\3C\3C\3D\3D\3D\3E\3"+
		"E\3F\3F\3G\3G\3H\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3"+
		"P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3V\3V\3W\3W\3W\3X\3X\3X\3Y\3Y\3"+
		"Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3[\3[\3\\\3\\\3\\\3\\\3]\3"+
		"]\3]\3]\3]\3^\3^\3^\3^\3^\3^\3_\3_\3_\3_\3_\3_\3_\3`\3`\3`\3`\3`\3a\3"+
		"a\3a\3a\3b\3b\3b\3b\3c\3c\3c\3c\3c\3d\3d\3d\3d\3d\3d\3e\3e\3e\7e\u02d1"+
		"\ne\fe\16e\u02d4\13e\3f\3f\3g\3g\3h\3h\3h\3h\7h\u02de\nh\fh\16h\u02e1"+
		"\13h\3h\3h\3i\3i\3i\3i\3j\3j\3\u0219\2k\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W"+
		"-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097"+
		"M\u0099N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9V\u00ab"+
		"W\u00adX\u00afY\u00b1Z\u00b3[\u00b5\\\u00b7]\u00b9^\u00bb_\u00bd`\u00bf"+
		"a\u00c1b\u00c3c\u00c5d\u00c7e\u00c9f\u00cbg\u00cdh\u00cfi\u00d1j\u00d3"+
		"k\3\2\t\4\2ffhh\5\2ffhhnn\3\2$$\3\2\62;\b\2%&C\\aac|\u00a5\u00a5\u00c4"+
		"\u00c4\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u02f5\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2"+
		"\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3"+
		"\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2"+
		"\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099"+
		"\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2"+
		"\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab"+
		"\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2"+
		"\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd"+
		"\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2"+
		"\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf"+
		"\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\3\u00d5\3\2\2\2\5\u00df\3\2\2"+
		"\2\7\u00e7\3\2\2\2\t\u00ee\3\2\2\2\13\u00fb\3\2\2\2\r\u0104\3\2\2\2\17"+
		"\u010b\3\2\2\2\21\u0112\3\2\2\2\23\u0118\3\2\2\2\25\u0121\3\2\2\2\27\u012a"+
		"\3\2\2\2\31\u0135\3\2\2\2\33\u013c\3\2\2\2\35\u0143\3\2\2\2\37\u0147\3"+
		"\2\2\2!\u014d\3\2\2\2#\u0153\3\2\2\2%\u015d\3\2\2\2\'\u0162\3\2\2\2)\u0169"+
		"\3\2\2\2+\u0170\3\2\2\2-\u017b\3\2\2\2/\u0182\3\2\2\2\61\u018a\3\2\2\2"+
		"\63\u0192\3\2\2\2\65\u019d\3\2\2\2\67\u01a2\3\2\2\29\u01a8\3\2\2\2;\u01ab"+
		"\3\2\2\2=\u01af\3\2\2\2?\u01b6\3\2\2\2A\u01be\3\2\2\2C\u01c9\3\2\2\2E"+
		"\u01d1\3\2\2\2G\u01d8\3\2\2\2I\u01de\3\2\2\2K\u01e4\3\2\2\2M\u01e9\3\2"+
		"\2\2O\u01ee\3\2\2\2Q\u01f2\3\2\2\2S\u01f5\3\2\2\2U\u01f9\3\2\2\2W\u020b"+
		"\3\2\2\2Y\u0215\3\2\2\2[\u0220\3\2\2\2]\u0222\3\2\2\2_\u0227\3\2\2\2a"+
		"\u022a\3\2\2\2c\u022d\3\2\2\2e\u0230\3\2\2\2g\u0233\3\2\2\2i\u0235\3\2"+
		"\2\2k\u0237\3\2\2\2m\u0239\3\2\2\2o\u023b\3\2\2\2q\u023d\3\2\2\2s\u023f"+
		"\3\2\2\2u\u0241\3\2\2\2w\u0243\3\2\2\2y\u0245\3\2\2\2{\u0248\3\2\2\2}"+
		"\u024b\3\2\2\2\177\u024f\3\2\2\2\u0081\u0253\3\2\2\2\u0083\u0256\3\2\2"+
		"\2\u0085\u0259\3\2\2\2\u0087\u025c\3\2\2\2\u0089\u025f\3\2\2\2\u008b\u0261"+
		"\3\2\2\2\u008d\u0263\3\2\2\2\u008f\u0265\3\2\2\2\u0091\u0268\3\2\2\2\u0093"+
		"\u026a\3\2\2\2\u0095\u026c\3\2\2\2\u0097\u026e\3\2\2\2\u0099\u0270\3\2"+
		"\2\2\u009b\u0272\3\2\2\2\u009d\u0274\3\2\2\2\u009f\u0276\3\2\2\2\u00a1"+
		"\u0278\3\2\2\2\u00a3\u027a\3\2\2\2\u00a5\u027c\3\2\2\2\u00a7\u027e\3\2"+
		"\2\2\u00a9\u0280\3\2\2\2\u00ab\u0282\3\2\2\2\u00ad\u0286\3\2\2\2\u00af"+
		"\u0289\3\2\2\2\u00b1\u028c\3\2\2\2\u00b3\u0294\3\2\2\2\u00b5\u0299\3\2"+
		"\2\2\u00b7\u029f\3\2\2\2\u00b9\u02a3\3\2\2\2\u00bb\u02a8\3\2\2\2\u00bd"+
		"\u02ae\3\2\2\2\u00bf\u02b5\3\2\2\2\u00c1\u02ba\3\2\2\2\u00c3\u02be\3\2"+
		"\2\2\u00c5\u02c2\3\2\2\2\u00c7\u02c7\3\2\2\2\u00c9\u02cd\3\2\2\2\u00cb"+
		"\u02d5\3\2\2\2\u00cd\u02d7\3\2\2\2\u00cf\u02d9\3\2\2\2\u00d1\u02e4\3\2"+
		"\2\2\u00d3\u02e8\3\2\2\2\u00d5\u00d6\7r\2\2\u00d6\u00d7\7t\2\2\u00d7\u00d8"+
		"\7q\2\2\u00d8\u00d9\7v\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7e\2\2\u00db"+
		"\u00dc\7v\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7f\2\2\u00de\4\3\2\2\2\u00df"+
		"\u00e0\7r\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3\7x\2\2"+
		"\u00e3\u00e4\7c\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7g\2\2\u00e6\6\3\2"+
		"\2\2\u00e7\u00e8\7r\2\2\u00e8\u00e9\7w\2\2\u00e9\u00ea\7d\2\2\u00ea\u00eb"+
		"\7n\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7e\2\2\u00ed\b\3\2\2\2\u00ee\u00ef"+
		"\7u\2\2\u00ef\u00f0\7{\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7e\2\2\u00f2"+
		"\u00f3\7j\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7q\2\2\u00f5\u00f6\7p\2\2"+
		"\u00f6\u00f7\7k\2\2\u00f7\u00f8\7u\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa"+
		"\7f\2\2\u00fa\n\3\2\2\2\u00fb\u00fc\7c\2\2\u00fc\u00fd\7d\2\2\u00fd\u00fe"+
		"\7u\2\2\u00fe\u00ff\7v\2\2\u00ff\u0100\7t\2\2\u0100\u0101\7c\2\2\u0101"+
		"\u0102\7e\2\2\u0102\u0103\7v\2\2\u0103\f\3\2\2\2\u0104\u0105\7p\2\2\u0105"+
		"\u0106\7c\2\2\u0106\u0107\7v\2\2\u0107\u0108\7k\2\2\u0108\u0109\7x\2\2"+
		"\u0109\u010a\7g\2\2\u010a\16\3\2\2\2\u010b\u010c\7u\2\2\u010c\u010d\7"+
		"v\2\2\u010d\u010e\7c\2\2\u010e\u010f\7v\2\2\u010f\u0110\7k\2\2\u0110\u0111"+
		"\7e\2\2\u0111\20\3\2\2\2\u0112\u0113\7h\2\2\u0113\u0114\7k\2\2\u0114\u0115"+
		"\7p\2\2\u0115\u0116\7c\2\2\u0116\u0117\7n\2\2\u0117\22\3\2\2\2\u0118\u0119"+
		"\7u\2\2\u0119\u011a\7v\2\2\u011a\u011b\7t\2\2\u011b\u011c\7k\2\2\u011c"+
		"\u011d\7e\2\2\u011d\u011e\7v\2\2\u011e\u011f\7h\2\2\u011f\u0120\7r\2\2"+
		"\u0120\24\3\2\2\2\u0121\u0122\7x\2\2\u0122\u0123\7q\2\2\u0123\u0124\7"+
		"n\2\2\u0124\u0125\7c\2\2\u0125\u0126\7v\2\2\u0126\u0127\7k\2\2\u0127\u0128"+
		"\7n\2\2\u0128\u0129\7g\2\2\u0129\26\3\2\2\2\u012a\u012b\7k\2\2\u012b\u012c"+
		"\7p\2\2\u012c\u012d\7u\2\2\u012d\u012e\7v\2\2\u012e\u012f\7c\2\2\u012f"+
		"\u0130\7p\2\2\u0130\u0131\7e\2\2\u0131\u0132\7g\2\2\u0132\u0133\7q\2\2"+
		"\u0133\u0134\7h\2\2\u0134\30\3\2\2\2\u0135\u0136\7t\2\2\u0136\u0137\7"+
		"g\2\2\u0137\u0138\7v\2\2\u0138\u0139\7w\2\2\u0139\u013a\7t\2\2\u013a\u013b"+
		"\7p\2\2\u013b\32\3\2\2\2\u013c\u013d\7c\2\2\u013d\u013e\7u\2\2\u013e\u013f"+
		"\7u\2\2\u013f\u0140\7g\2\2\u0140\u0141\7t\2\2\u0141\u0142\7v\2\2\u0142"+
		"\34\3\2\2\2\u0143\u0144\7p\2\2\u0144\u0145\7g\2\2\u0145\u0146\7y\2\2\u0146"+
		"\36\3\2\2\2\u0147\u0148\7v\2\2\u0148\u0149\7j\2\2\u0149\u014a\7t\2\2\u014a"+
		"\u014b\7q\2\2\u014b\u014c\7y\2\2\u014c \3\2\2\2\u014d\u014e\7e\2\2\u014e"+
		"\u014f\7n\2\2\u014f\u0150\7c\2\2\u0150\u0151\7u\2\2\u0151\u0152\7u\2\2"+
		"\u0152\"\3\2\2\2\u0153\u0154\7k\2\2\u0154\u0155\7p\2\2\u0155\u0156\7v"+
		"\2\2\u0156\u0157\7g\2\2\u0157\u0158\7t\2\2\u0158\u0159\7h\2\2\u0159\u015a"+
		"\7c\2\2\u015a\u015b\7e\2\2\u015b\u015c\7g\2\2\u015c$\3\2\2\2\u015d\u015e"+
		"\7g\2\2\u015e\u015f\7p\2\2\u015f\u0160\7w\2\2\u0160\u0161\7o\2\2\u0161"+
		"&\3\2\2\2\u0162\u0163\7t\2\2\u0163\u0164\7g\2\2\u0164\u0165\7e\2\2\u0165"+
		"\u0166\7q\2\2\u0166\u0167\7t\2\2\u0167\u0168\7f\2\2\u0168(\3\2\2\2\u0169"+
		"\u016a\7u\2\2\u016a\u016b\7k\2\2\u016b\u016c\7p\2\2\u016c\u016d\7i\2\2"+
		"\u016d\u016e\7n\2\2\u016e\u016f\7g\2\2\u016f*\3\2\2\2\u0170\u0171\7c\2"+
		"\2\u0171\u0172\7p\2\2\u0172\u0173\7p\2\2\u0173\u0174\7q\2\2\u0174\u0175"+
		"\7v\2\2\u0175\u0176\7c\2\2\u0176\u0177\7v\2\2\u0177\u0178\7k\2\2\u0178"+
		"\u0179\7q\2\2\u0179\u017a\7p\2\2\u017a,\3\2\2\2\u017b\u017c\7k\2\2\u017c"+
		"\u017d\7o\2\2\u017d\u017e\7r\2\2\u017e\u017f\7q\2\2\u017f\u0180\7t\2\2"+
		"\u0180\u0181\7v\2\2\u0181.\3\2\2\2\u0182\u0183\7r\2\2\u0183\u0184\7c\2"+
		"\2\u0184\u0185\7e\2\2\u0185\u0186\7m\2\2\u0186\u0187\7c\2\2\u0187\u0188"+
		"\7i\2\2\u0188\u0189\7g\2\2\u0189\60\3\2\2\2\u018a\u018b\7g\2\2\u018b\u018c"+
		"\7z\2\2\u018c\u018d\7v\2\2\u018d\u018e\7g\2\2\u018e\u018f\7p\2\2\u018f"+
		"\u0190\7f\2\2\u0190\u0191\7u\2\2\u0191\62\3\2\2\2\u0192\u0193\7k\2\2\u0193"+
		"\u0194\7o\2\2\u0194\u0195\7r\2\2\u0195\u0196\7n\2\2\u0196\u0197\7g\2\2"+
		"\u0197\u0198\7o\2\2\u0198\u0199\7g\2\2\u0199\u019a\7p\2\2\u019a\u019b"+
		"\7v\2\2\u019b\u019c\7u\2\2\u019c\64\3\2\2\2\u019d\u019e\7v\2\2\u019e\u019f"+
		"\7j\2\2\u019f\u01a0\7k\2\2\u01a0\u01a1\7u\2\2\u01a1\66\3\2\2\2\u01a2\u01a3"+
		"\7u\2\2\u01a3\u01a4\7w\2\2\u01a4\u01a5\7r\2\2\u01a5\u01a6\7g\2\2\u01a6"+
		"\u01a7\7t\2\2\u01a78\3\2\2\2\u01a8\u01a9\7k\2\2\u01a9\u01aa\7p\2\2\u01aa"+
		":\3\2\2\2\u01ab\u01ac\7q\2\2\u01ac\u01ad\7w\2\2\u01ad\u01ae\7v\2\2\u01ae"+
		"<\3\2\2\2\u01af\u01b0\7u\2\2\u01b0\u01b1\7g\2\2\u01b1\u01b2\7c\2\2\u01b2"+
		"\u01b3\7n\2\2\u01b3\u01b4\7g\2\2\u01b4\u01b5\7f\2\2\u01b5>\3\2\2\2\u01b6"+
		"\u01b7\7r\2\2\u01b7\u01b8\7g\2\2\u01b8\u01b9\7t\2\2\u01b9\u01ba\7o\2\2"+
		"\u01ba\u01bb\7k\2\2\u01bb\u01bc\7v\2\2\u01bc\u01bd\7u\2\2\u01bd@\3\2\2"+
		"\2\u01be\u01bf\7p\2\2\u01bf\u01c0\7q\2\2\u01c0\u01c1\7p\2\2\u01c1\u01c2"+
		"\7/\2\2\u01c2\u01c3\7u\2\2\u01c3\u01c4\7g\2\2\u01c4\u01c5\7c\2\2\u01c5"+
		"\u01c6\7n\2\2\u01c6\u01c7\7g\2\2\u01c7\u01c8\7f\2\2\u01c8B\3\2\2\2\u01c9"+
		"\u01ca\7f\2\2\u01ca\u01cb\7g\2\2\u01cb\u01cc\7h\2\2\u01cc\u01cd\7c\2\2"+
		"\u01cd\u01ce\7w\2\2\u01ce\u01cf\7n\2\2\u01cf\u01d0\7v\2\2\u01d0D\3\2\2"+
		"\2\u01d1\u01d2\7u\2\2\u01d2\u01d3\7y\2\2\u01d3\u01d4\7k\2\2\u01d4\u01d5"+
		"\7v\2\2\u01d5\u01d6\7e\2\2\u01d6\u01d7\7j\2\2\u01d7F\3\2\2\2\u01d8\u01d9"+
		"\7y\2\2\u01d9\u01da\7j\2\2\u01da\u01db\7k\2\2\u01db\u01dc\7n\2\2\u01dc"+
		"\u01dd\7g\2\2\u01ddH\3\2\2\2\u01de\u01df\7{\2\2\u01df\u01e0\7k\2\2\u01e0"+
		"\u01e1\7g\2\2\u01e1\u01e2\7n\2\2\u01e2\u01e3\7f\2\2\u01e3J\3\2\2\2\u01e4"+
		"\u01e5\7e\2\2\u01e5\u01e6\7c\2\2\u01e6\u01e7\7u\2\2\u01e7\u01e8\7g\2\2"+
		"\u01e8L\3\2\2\2\u01e9\u01ea\7g\2\2\u01ea\u01eb\7n\2\2\u01eb\u01ec\7u\2"+
		"\2\u01ec\u01ed\7g\2\2\u01edN\3\2\2\2\u01ee\u01ef\7h\2\2\u01ef\u01f0\7"+
		"q\2\2\u01f0\u01f1\7t\2\2\u01f1P\3\2\2\2\u01f2\u01f3\7f\2\2\u01f3\u01f4"+
		"\7q\2\2\u01f4R\3\2\2\2\u01f5\u01f6\7k\2\2\u01f6\u01f7\7h\2\2\u01f7T\3"+
		"\2\2\2\u01f8\u01fa\5s:\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa"+
		"\u01fe\3\2\2\2\u01fb\u01fd\5\u00cbf\2\u01fc\u01fb\3\2\2\2\u01fd\u0200"+
		"\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0201\3\2\2\2\u0200"+
		"\u01fe\3\2\2\2\u0201\u0203\5\u00a3R\2\u0202\u0204\5\u00cbf\2\u0203\u0202"+
		"\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206"+
		"\u0208\3\2\2\2\u0207\u0209\t\2\2\2\u0208\u0207\3\2\2\2\u0208\u0209\3\2"+
		"\2\2\u0209V\3\2\2\2\u020a\u020c\5s:\2\u020b\u020a\3\2\2\2\u020b\u020c"+
		"\3\2\2\2\u020c\u020e\3\2\2\2\u020d\u020f\5\u00cbf\2\u020e\u020d\3\2\2"+
		"\2\u020f\u0210\3\2\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0213"+
		"\3\2\2\2\u0212\u0214\t\3\2\2\u0213\u0212\3\2\2\2\u0213\u0214\3\2\2\2\u0214"+
		"X\3\2\2\2\u0215\u0219\5\u00a1Q\2\u0216\u0218\n\4\2\2\u0217\u0216\3\2\2"+
		"\2\u0218\u021b\3\2\2\2\u0219\u021a\3\2\2\2\u0219\u0217\3\2\2\2\u021a\u021c"+
		"\3\2\2\2\u021b\u0219\3\2\2\2\u021c\u021d\5\u00a1Q\2\u021dZ\3\2\2\2\u021e"+
		"\u0221\5\u00c5c\2\u021f\u0221\5\u00c7d\2\u0220\u021e\3\2\2\2\u0220\u021f"+
		"\3\2\2\2\u0221\\\3\2\2\2\u0222\u0223\7p\2\2\u0223\u0224\7w\2\2\u0224\u0225"+
		"\7n\2\2\u0225\u0226\7n\2\2\u0226^\3\2\2\2\u0227\u0228\7(\2\2\u0228\u0229"+
		"\7(\2\2\u0229`\3\2\2\2\u022a\u022b\7~\2\2\u022b\u022c\7~\2\2\u022cb\3"+
		"\2\2\2\u022d\u022e\7-\2\2\u022e\u022f\7-\2\2\u022fd\3\2\2\2\u0230\u0231"+
		"\7/\2\2\u0231\u0232\7/\2\2\u0232f\3\2\2\2\u0233\u0234\7(\2\2\u0234h\3"+
		"\2\2\2\u0235\u0236\7~\2\2\u0236j\3\2\2\2\u0237\u0238\7`\2\2\u0238l\3\2"+
		"\2\2\u0239\u023a\7,\2\2\u023an\3\2\2\2\u023b\u023c\7\61\2\2\u023cp\3\2"+
		"\2\2\u023d\u023e\7-\2\2\u023er\3\2\2\2\u023f\u0240\7/\2\2\u0240t\3\2\2"+
		"\2\u0241\u0242\7\'\2\2\u0242v\3\2\2\2\u0243\u0244\7B\2\2\u0244x\3\2\2"+
		"\2\u0245\u0246\7>\2\2\u0246\u0247\7>\2\2\u0247z\3\2\2\2\u0248\u0249\7"+
		"@\2\2\u0249\u024a\7@\2\2\u024a|\3\2\2\2\u024b\u024c\7>\2\2\u024c\u024d"+
		"\7>\2\2\u024d\u024e\7>\2\2\u024e~\3\2\2\2\u024f\u0250\7@\2\2\u0250\u0251"+
		"\7@\2\2\u0251\u0252\7@\2\2\u0252\u0080\3\2\2\2\u0253\u0254\7?\2\2\u0254"+
		"\u0255\7?\2\2\u0255\u0082\3\2\2\2\u0256\u0257\7#\2\2\u0257\u0258\7?\2"+
		"\2\u0258\u0084\3\2\2\2\u0259\u025a\7@\2\2\u025a\u025b\7?\2\2\u025b\u0086"+
		"\3\2\2\2\u025c\u025d\7>\2\2\u025d\u025e\7?\2\2\u025e\u0088\3\2\2\2\u025f"+
		"\u0260\7@\2\2\u0260\u008a\3\2\2\2\u0261\u0262\7>\2\2\u0262\u008c\3\2\2"+
		"\2\u0263\u0264\7?\2\2\u0264\u008e\3\2\2\2\u0265\u0266\7~\2\2\u0266\u0267"+
		"\7@\2\2\u0267\u0090\3\2\2\2\u0268\u0269\7}\2\2\u0269\u0092\3\2\2\2\u026a"+
		"\u026b\7\177\2\2\u026b\u0094\3\2\2\2\u026c\u026d\7*\2\2\u026d\u0096\3"+
		"\2\2\2\u026e\u026f\7+\2\2\u026f\u0098\3\2\2\2\u0270\u0271\7]\2\2\u0271"+
		"\u009a\3\2\2\2\u0272\u0273\7_\2\2\u0273\u009c\3\2\2\2\u0274\u0275\7<\2"+
		"\2\u0275\u009e\3\2\2\2\u0276\u0277\7=\2\2\u0277\u00a0\3\2\2\2\u0278\u0279"+
		"\7$\2\2\u0279\u00a2\3\2\2\2\u027a\u027b\7\60\2\2\u027b\u00a4\3\2\2\2\u027c"+
		"\u027d\7.\2\2\u027d\u00a6\3\2\2\2\u027e\u027f\7#\2\2\u027f\u00a8\3\2\2"+
		"\2\u0280\u0281\7A\2\2\u0281\u00aa\3\2\2\2\u0282\u0283\7\60\2\2\u0283\u0284"+
		"\7\60\2\2\u0284\u0285\7\60\2\2\u0285\u00ac\3\2\2\2\u0286\u0287\7/\2\2"+
		"\u0287\u0288\7@\2\2\u0288\u00ae\3\2\2\2\u0289\u028a\7?\2\2\u028a\u028b"+
		"\7@\2\2\u028b\u00b0\3\2\2\2\u028c\u028d\7d\2\2\u028d\u028e\7q\2\2\u028e"+
		"\u028f\7q\2\2\u028f\u0290\7n\2\2\u0290\u0291\7g\2\2\u0291\u0292\7c\2\2"+
		"\u0292\u0293\7p\2\2\u0293\u00b2\3\2\2\2\u0294\u0295\7d\2\2\u0295\u0296"+
		"\7{\2\2\u0296\u0297\7v\2\2\u0297\u0298\7g\2\2\u0298\u00b4\3\2\2\2\u0299"+
		"\u029a\7u\2\2\u029a\u029b\7j\2\2\u029b\u029c\7q\2\2\u029c\u029d\7t\2\2"+
		"\u029d\u029e\7v\2\2\u029e\u00b6\3\2\2\2\u029f\u02a0\7k\2\2\u02a0\u02a1"+
		"\7p\2\2\u02a1\u02a2\7v\2\2\u02a2\u00b8\3\2\2\2\u02a3\u02a4\7n\2\2\u02a4"+
		"\u02a5\7q\2\2\u02a5\u02a6\7p\2\2\u02a6\u02a7\7i\2\2\u02a7\u00ba\3\2\2"+
		"\2\u02a8\u02a9\7h\2\2\u02a9\u02aa\7n\2\2\u02aa\u02ab\7q\2\2\u02ab\u02ac"+
		"\7c\2\2\u02ac\u02ad\7v\2\2\u02ad\u00bc\3\2\2\2\u02ae\u02af\7f\2\2\u02af"+
		"\u02b0\7q\2\2\u02b0\u02b1\7w\2\2\u02b1\u02b2\7d\2\2\u02b2\u02b3\7n\2\2"+
		"\u02b3\u02b4\7g\2\2\u02b4\u00be\3\2\2\2\u02b5\u02b6\7x\2\2\u02b6\u02b7"+
		"\7q\2\2\u02b7\u02b8\7k\2\2\u02b8\u02b9\7f\2\2\u02b9\u00c0\3\2\2\2\u02ba"+
		"\u02bb\7x\2\2\u02bb\u02bc\7c\2\2\u02bc\u02bd\7t\2\2\u02bd\u00c2\3\2\2"+
		"\2\u02be\u02bf\7x\2\2\u02bf\u02c0\7c\2\2\u02c0\u02c1\7n\2\2\u02c1\u00c4"+
		"\3\2\2\2\u02c2\u02c3\7v\2\2\u02c3\u02c4\7t\2\2\u02c4\u02c5\7w\2\2\u02c5"+
		"\u02c6\7g\2\2\u02c6\u00c6\3\2\2\2\u02c7\u02c8\7h\2\2\u02c8\u02c9\7c\2"+
		"\2\u02c9\u02ca\7n\2\2\u02ca\u02cb\7u\2\2\u02cb\u02cc\7g\2\2\u02cc\u00c8"+
		"\3\2\2\2\u02cd\u02d2\5\u00cdg\2\u02ce\u02d1\5\u00cbf\2\u02cf\u02d1\5\u00cd"+
		"g\2\u02d0\u02ce\3\2\2\2\u02d0\u02cf\3\2\2\2\u02d1\u02d4\3\2\2\2\u02d2"+
		"\u02d0\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u00ca\3\2\2\2\u02d4\u02d2\3\2"+
		"\2\2\u02d5\u02d6\t\5\2\2\u02d6\u00cc\3\2\2\2\u02d7\u02d8\t\6\2\2\u02d8"+
		"\u00ce\3\2\2\2\u02d9\u02da\7\61\2\2\u02da\u02db\7\61\2\2\u02db\u02df\3"+
		"\2\2\2\u02dc\u02de\n\7\2\2\u02dd\u02dc\3\2\2\2\u02de\u02e1\3\2\2\2\u02df"+
		"\u02dd\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02e2\3\2\2\2\u02e1\u02df\3\2"+
		"\2\2\u02e2\u02e3\bh\2\2\u02e3\u00d0\3\2\2\2\u02e4\u02e5\t\b\2\2\u02e5"+
		"\u02e6\3\2\2\2\u02e6\u02e7\bi\2\2\u02e7\u00d2\3\2\2\2\u02e8\u02e9\13\2"+
		"\2\2\u02e9\u00d4\3\2\2\2\17\2\u01f9\u01fe\u0205\u0208\u020b\u0210\u0213"+
		"\u0219\u0220\u02d0\u02d2\u02df\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}