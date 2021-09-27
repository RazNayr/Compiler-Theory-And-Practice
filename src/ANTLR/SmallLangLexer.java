// Generated from C:/Users/Owner/IdeaProjects/SmallLangV2-Compiler-part2/src/Grammars\SmallLang.g4 by ANTLR 4.8
package ANTLR;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmallLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, TYPE=17, 
		AUTO=18, BOOLEANLITERAL=19, INTEGERLITERAL=20, FLOATLITERAL=21, MULTIPLICATIVEOP=22, 
		ADDITIVEOP=23, RELATIONALOP=24, UNARYOP=25, IDENTIFIER=26, MINUS=27, NEWLINE=28, 
		WHITESPACE=29, MULTICOMMENT=30, COMMENT=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "LETTER", 
			"DIGIT", "TYPE", "AUTO", "BOOLEANLITERAL", "INTEGERLITERAL", "FLOATLITERAL", 
			"MULTIPLICATIVEOP", "ADDITIVEOP", "RELATIONALOP", "UNARYOP", "IDENTIFIER", 
			"MINUS", "NEWLINE", "WHITESPACE", "MULTICOMMENT", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'('", "')'", "'='", "'let'", "':'", "'print'", "'return'", 
			"'if'", "'else'", "'for'", "';'", "'while'", "'ff'", "'{'", "'}'", null, 
			"'auto'", null, null, null, null, null, null, null, null, "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "TYPE", "AUTO", "BOOLEANLITERAL", "INTEGERLITERAL", 
			"FLOATLITERAL", "MULTIPLICATIVEOP", "ADDITIVEOP", "RELATIONALOP", "UNARYOP", 
			"IDENTIFIER", "MINUS", "NEWLINE", "WHITESPACE", "MULTICOMMENT", "COMMENT"
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


	public SmallLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SmallLang.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u0100\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u008c\n\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u009c\n\26\3\27\6\27\u009f\n\27\r\27\16\27\u00a0\3\30\6\30\u00a4\n\30"+
		"\r\30\16\30\u00a5\3\30\3\30\6\30\u00aa\n\30\r\30\16\30\u00ab\3\31\3\31"+
		"\3\31\3\31\5\31\u00b2\n\31\3\32\3\32\3\32\3\32\5\32\u00b8\n\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00c3\n\33\3\34\3\34\3\34"+
		"\3\34\5\34\u00c9\n\34\3\35\3\35\5\35\u00cd\n\35\3\35\3\35\3\35\7\35\u00d2"+
		"\n\35\f\35\16\35\u00d5\13\35\3\36\3\36\3\37\5\37\u00da\n\37\3\37\3\37"+
		"\6\37\u00de\n\37\r\37\16\37\u00df\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\7"+
		"!\u00ec\n!\f!\16!\u00ef\13!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\7\"\u00fa\n"+
		"\"\f\"\16\"\u00fd\13\"\3\"\3\"\3\u00ed\2#\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\2%\2\'\23)\24+\25"+
		"-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!\3\2\b\4\2C\\c|\3"+
		"\2\62;\4\2,,\61\61\4\2>>@@\4\2\13\13\"\"\3\2\f\f\2\u0114\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\3E\3\2\2\2\5G\3\2\2\2\7I\3\2\2\2\tK\3\2\2\2\13M\3\2\2\2"+
		"\rQ\3\2\2\2\17S\3\2\2\2\21Y\3\2\2\2\23`\3\2\2\2\25c\3\2\2\2\27h\3\2\2"+
		"\2\31l\3\2\2\2\33n\3\2\2\2\35t\3\2\2\2\37w\3\2\2\2!y\3\2\2\2#{\3\2\2\2"+
		"%}\3\2\2\2\'\u008b\3\2\2\2)\u008d\3\2\2\2+\u009b\3\2\2\2-\u009e\3\2\2"+
		"\2/\u00a3\3\2\2\2\61\u00b1\3\2\2\2\63\u00b7\3\2\2\2\65\u00c2\3\2\2\2\67"+
		"\u00c8\3\2\2\29\u00cc\3\2\2\2;\u00d6\3\2\2\2=\u00dd\3\2\2\2?\u00e3\3\2"+
		"\2\2A\u00e7\3\2\2\2C\u00f5\3\2\2\2EF\7.\2\2F\4\3\2\2\2GH\7*\2\2H\6\3\2"+
		"\2\2IJ\7+\2\2J\b\3\2\2\2KL\7?\2\2L\n\3\2\2\2MN\7n\2\2NO\7g\2\2OP\7v\2"+
		"\2P\f\3\2\2\2QR\7<\2\2R\16\3\2\2\2ST\7r\2\2TU\7t\2\2UV\7k\2\2VW\7p\2\2"+
		"WX\7v\2\2X\20\3\2\2\2YZ\7t\2\2Z[\7g\2\2[\\\7v\2\2\\]\7w\2\2]^\7t\2\2^"+
		"_\7p\2\2_\22\3\2\2\2`a\7k\2\2ab\7h\2\2b\24\3\2\2\2cd\7g\2\2de\7n\2\2e"+
		"f\7u\2\2fg\7g\2\2g\26\3\2\2\2hi\7h\2\2ij\7q\2\2jk\7t\2\2k\30\3\2\2\2l"+
		"m\7=\2\2m\32\3\2\2\2no\7y\2\2op\7j\2\2pq\7k\2\2qr\7n\2\2rs\7g\2\2s\34"+
		"\3\2\2\2tu\7h\2\2uv\7h\2\2v\36\3\2\2\2wx\7}\2\2x \3\2\2\2yz\7\177\2\2"+
		"z\"\3\2\2\2{|\t\2\2\2|$\3\2\2\2}~\t\3\2\2~&\3\2\2\2\177\u0080\7h\2\2\u0080"+
		"\u0081\7n\2\2\u0081\u0082\7q\2\2\u0082\u0083\7c\2\2\u0083\u008c\7v\2\2"+
		"\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u008c\7v\2\2\u0087\u0088"+
		"\7d\2\2\u0088\u0089\7q\2\2\u0089\u008a\7q\2\2\u008a\u008c\7n\2\2\u008b"+
		"\177\3\2\2\2\u008b\u0084\3\2\2\2\u008b\u0087\3\2\2\2\u008c(\3\2\2\2\u008d"+
		"\u008e\7c\2\2\u008e\u008f\7w\2\2\u008f\u0090\7v\2\2\u0090\u0091\7q\2\2"+
		"\u0091*\3\2\2\2\u0092\u0093\7v\2\2\u0093\u0094\7t\2\2\u0094\u0095\7w\2"+
		"\2\u0095\u009c\7g\2\2\u0096\u0097\7h\2\2\u0097\u0098\7c\2\2\u0098\u0099"+
		"\7n\2\2\u0099\u009a\7u\2\2\u009a\u009c\7g\2\2\u009b\u0092\3\2\2\2\u009b"+
		"\u0096\3\2\2\2\u009c,\3\2\2\2\u009d\u009f\5%\23\2\u009e\u009d\3\2\2\2"+
		"\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1.\3"+
		"\2\2\2\u00a2\u00a4\5%\23\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\7\60"+
		"\2\2\u00a8\u00aa\5%\23\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\60\3\2\2\2\u00ad\u00b2\t\4\2"+
		"\2\u00ae\u00af\7c\2\2\u00af\u00b0\7p\2\2\u00b0\u00b2\7f\2\2\u00b1\u00ad"+
		"\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b2\62\3\2\2\2\u00b3\u00b8\7-\2\2\u00b4"+
		"\u00b8\5;\36\2\u00b5\u00b6\7q\2\2\u00b6\u00b8\7t\2\2\u00b7\u00b3\3\2\2"+
		"\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\64\3\2\2\2\u00b9\u00c3"+
		"\t\5\2\2\u00ba\u00bb\7?\2\2\u00bb\u00c3\7?\2\2\u00bc\u00bd\7>\2\2\u00bd"+
		"\u00c3\7@\2\2\u00be\u00bf\7>\2\2\u00bf\u00c3\7?\2\2\u00c0\u00c1\7@\2\2"+
		"\u00c1\u00c3\7?\2\2\u00c2\u00b9\3\2\2\2\u00c2\u00ba\3\2\2\2\u00c2\u00bc"+
		"\3\2\2\2\u00c2\u00be\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\66\3\2\2\2\u00c4"+
		"\u00c9\5;\36\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7q\2\2\u00c7\u00c9\7v\2"+
		"\2\u00c8\u00c4\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c98\3\2\2\2\u00ca\u00cd"+
		"\7a\2\2\u00cb\u00cd\5#\22\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\u00d3\3\2\2\2\u00ce\u00d2\7a\2\2\u00cf\u00d2\5#\22\2\u00d0\u00d2\5%\23"+
		"\2\u00d1\u00ce\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5"+
		"\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4:\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6\u00d7\7/\2\2\u00d7<\3\2\2\2\u00d8\u00da\7\17\2\2"+
		"\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00de"+
		"\7\f\2\2\u00dc\u00de\7\17\2\2\u00dd\u00d9\3\2\2\2\u00dd\u00dc\3\2\2\2"+
		"\u00de\u00df\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00e2\b\37\2\2\u00e2>\3\2\2\2\u00e3\u00e4\t\6\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e6\b \2\2\u00e6@\3\2\2\2\u00e7\u00e8\7\61\2\2"+
		"\u00e8\u00e9\7,\2\2\u00e9\u00ed\3\2\2\2\u00ea\u00ec\13\2\2\2\u00eb\u00ea"+
		"\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee"+
		"\u00f0\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\7,\2\2\u00f1\u00f2\7\61"+
		"\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\b!\2\2\u00f4B\3\2\2\2\u00f5\u00f6"+
		"\7\61\2\2\u00f6\u00f7\7\61\2\2\u00f7\u00fb\3\2\2\2\u00f8\u00fa\n\7\2\2"+
		"\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc"+
		"\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\b\"\2\2\u00ff"+
		"D\3\2\2\2\24\2\u008b\u009b\u00a0\u00a5\u00ab\u00b1\u00b7\u00c2\u00c8\u00cc"+
		"\u00d1\u00d3\u00d9\u00dd\u00df\u00ed\u00fb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}