// Generated from C:/Users/Owner/IdeaProjects/SmallLangV2-Compiler-part2/src/Grammars\SmallLangV2.g4 by ANTLR 4.8
package ANTLRV2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmallLangV2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, TYPE=19, AUTO=20, BOOLEANLITERAL=21, INTEGERLITERAL=22, FLOATLITERAL=23, 
		CHARLITERAL=24, MULTIPLICATIVEOP=25, ADDITIVEOP=26, RELATIONALOP=27, UNARYOP=28, 
		IDENTIFIER=29, MINUS=30, NEWLINE=31, WHITESPACE=32, MULTICOMMENT=33, COMMENT=34;
	public static final int
		RULE_literal = 0, RULE_actualparams = 1, RULE_functioncall = 2, RULE_subexpression = 3, 
		RULE_unary = 4, RULE_arraycall = 5, RULE_factor = 6, RULE_term = 7, RULE_simpleexpression = 8, 
		RULE_expression = 9, RULE_assignment = 10, RULE_variabledecl = 11, RULE_printstatement = 12, 
		RULE_rtrnstatement = 13, RULE_ifstatement = 14, RULE_forstatement = 15, 
		RULE_whilestatement = 16, RULE_formalparam = 17, RULE_formalparams = 18, 
		RULE_functiondecl = 19, RULE_arraydecl = 20, RULE_arrayelements = 21, 
		RULE_arrayassignment = 22, RULE_statement = 23, RULE_block = 24, RULE_program = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"literal", "actualparams", "functioncall", "subexpression", "unary", 
			"arraycall", "factor", "term", "simpleexpression", "expression", "assignment", 
			"variabledecl", "printstatement", "rtrnstatement", "ifstatement", "forstatement", 
			"whilestatement", "formalparam", "formalparams", "functiondecl", "arraydecl", 
			"arrayelements", "arrayassignment", "statement", "block", "program"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'('", "')'", "'['", "']'", "'='", "'let'", "':'", "'print'", 
			"'return'", "'if'", "'else'", "'for'", "';'", "'while'", "'ff'", "'{'", 
			"'}'", null, "'auto'", null, null, null, null, null, null, null, null, 
			null, "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "TYPE", "AUTO", "BOOLEANLITERAL", 
			"INTEGERLITERAL", "FLOATLITERAL", "CHARLITERAL", "MULTIPLICATIVEOP", 
			"ADDITIVEOP", "RELATIONALOP", "UNARYOP", "IDENTIFIER", "MINUS", "NEWLINE", 
			"WHITESPACE", "MULTICOMMENT", "COMMENT"
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
	public String getGrammarFileName() { return "SmallLangV2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SmallLangV2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode BOOLEANLITERAL() { return getToken(SmallLangV2Parser.BOOLEANLITERAL, 0); }
		public TerminalNode INTEGERLITERAL() { return getToken(SmallLangV2Parser.INTEGERLITERAL, 0); }
		public TerminalNode FLOATLITERAL() { return getToken(SmallLangV2Parser.FLOATLITERAL, 0); }
		public TerminalNode CHARLITERAL() { return getToken(SmallLangV2Parser.CHARLITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEANLITERAL) | (1L << INTEGERLITERAL) | (1L << FLOATLITERAL) | (1L << CHARLITERAL))) != 0)) ) {
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

	public static class ActualparamsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ActualparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterActualparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitActualparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitActualparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualparamsContext actualparams() throws RecognitionException {
		ActualparamsContext _localctx = new ActualparamsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_actualparams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			expression();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(55);
				match(T__0);
				setState(56);
				expression();
				}
				}
				setState(61);
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

	public static class FunctioncallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SmallLangV2Parser.IDENTIFIER, 0); }
		public ActualparamsContext actualparams() {
			return getRuleContext(ActualparamsContext.class,0);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterFunctioncall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitFunctioncall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitFunctioncall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functioncall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(IDENTIFIER);
			setState(63);
			match(T__1);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << BOOLEANLITERAL) | (1L << INTEGERLITERAL) | (1L << FLOATLITERAL) | (1L << CHARLITERAL) | (1L << UNARYOP) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(64);
				actualparams();
				}
			}

			setState(67);
			match(T__2);
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

	public static class SubexpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SubexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterSubexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitSubexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitSubexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubexpressionContext subexpression() throws RecognitionException {
		SubexpressionContext _localctx = new SubexpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_subexpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__1);
			setState(70);
			expression();
			setState(71);
			match(T__2);
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

	public static class UnaryContext extends ParserRuleContext {
		public TerminalNode UNARYOP() { return getToken(SmallLangV2Parser.UNARYOP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(UNARYOP);
			setState(74);
			expression();
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

	public static class ArraycallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SmallLangV2Parser.IDENTIFIER, 0); }
		public TerminalNode INTEGERLITERAL() { return getToken(SmallLangV2Parser.INTEGERLITERAL, 0); }
		public ArraycallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraycall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterArraycall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitArraycall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitArraycall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraycallContext arraycall() throws RecognitionException {
		ArraycallContext _localctx = new ArraycallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arraycall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(IDENTIFIER);
			setState(77);
			match(T__3);
			setState(78);
			match(INTEGERLITERAL);
			setState(79);
			match(T__4);
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

	public static class FactorContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SmallLangV2Parser.IDENTIFIER, 0); }
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public ArraycallContext arraycall() {
			return getRuleContext(ArraycallContext.class,0);
		}
		public SubexpressionContext subexpression() {
			return getRuleContext(SubexpressionContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_factor);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				functioncall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				arraycall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				subexpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(86);
				unary();
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

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TerminalNode MULTIPLICATIVEOP() { return getToken(SmallLangV2Parser.MULTIPLICATIVEOP, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_term);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				factor();
				setState(90);
				match(MULTIPLICATIVEOP);
				setState(91);
				factor();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				factor();
				setState(94);
				match(MULTIPLICATIVEOP);
				setState(95);
				term();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				factor();
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

	public static class SimpleexpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode ADDITIVEOP() { return getToken(SmallLangV2Parser.ADDITIVEOP, 0); }
		public SimpleexpressionContext simpleexpression() {
			return getRuleContext(SimpleexpressionContext.class,0);
		}
		public SimpleexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterSimpleexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitSimpleexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitSimpleexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleexpressionContext simpleexpression() throws RecognitionException {
		SimpleexpressionContext _localctx = new SimpleexpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_simpleexpression);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				term();
				setState(101);
				match(ADDITIVEOP);
				setState(102);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				term();
				setState(105);
				match(ADDITIVEOP);
				setState(106);
				simpleexpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				term();
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<SimpleexpressionContext> simpleexpression() {
			return getRuleContexts(SimpleexpressionContext.class);
		}
		public SimpleexpressionContext simpleexpression(int i) {
			return getRuleContext(SimpleexpressionContext.class,i);
		}
		public TerminalNode RELATIONALOP() { return getToken(SmallLangV2Parser.RELATIONALOP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				simpleexpression();
				setState(112);
				match(RELATIONALOP);
				setState(113);
				simpleexpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				simpleexpression();
				setState(116);
				match(RELATIONALOP);
				setState(117);
				expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				simpleexpression();
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SmallLangV2Parser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(IDENTIFIER);
			setState(123);
			match(T__5);
			setState(124);
			expression();
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

	public static class VariabledeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SmallLangV2Parser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(SmallLangV2Parser.TYPE, 0); }
		public TerminalNode AUTO() { return getToken(SmallLangV2Parser.AUTO, 0); }
		public VariabledeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variabledecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterVariabledecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitVariabledecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitVariabledecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariabledeclContext variabledecl() throws RecognitionException {
		VariabledeclContext _localctx = new VariabledeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variabledecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__6);
			setState(127);
			match(IDENTIFIER);
			setState(128);
			match(T__7);
			setState(129);
			_la = _input.LA(1);
			if ( !(_la==TYPE || _la==AUTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(130);
			match(T__5);
			setState(131);
			expression();
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

	public static class PrintstatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterPrintstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitPrintstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitPrintstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintstatementContext printstatement() throws RecognitionException {
		PrintstatementContext _localctx = new PrintstatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_printstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__8);
			setState(134);
			expression();
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

	public static class RtrnstatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RtrnstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rtrnstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterRtrnstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitRtrnstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitRtrnstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RtrnstatementContext rtrnstatement() throws RecognitionException {
		RtrnstatementContext _localctx = new RtrnstatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_rtrnstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__9);
			setState(137);
			expression();
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

	public static class IfstatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterIfstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitIfstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitIfstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstatementContext ifstatement() throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__10);
			setState(140);
			match(T__1);
			setState(141);
			expression();
			setState(142);
			match(T__2);
			setState(143);
			block();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(144);
				match(T__11);
				setState(145);
				block();
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

	public static class ForstatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariabledeclContext variabledecl() {
			return getRuleContext(VariabledeclContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ForstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterForstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitForstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitForstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForstatementContext forstatement() throws RecognitionException {
		ForstatementContext _localctx = new ForstatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__12);
			setState(149);
			match(T__1);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(150);
				variabledecl();
				}
			}

			setState(153);
			match(T__13);
			setState(154);
			expression();
			setState(155);
			match(T__13);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(156);
				assignment();
				}
			}

			setState(159);
			match(T__2);
			setState(160);
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

	public static class WhilestatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhilestatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterWhilestatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitWhilestatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitWhilestatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestatementContext whilestatement() throws RecognitionException {
		WhilestatementContext _localctx = new WhilestatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whilestatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__14);
			setState(163);
			match(T__1);
			setState(164);
			expression();
			setState(165);
			match(T__2);
			setState(166);
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

	public static class FormalparamContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SmallLangV2Parser.IDENTIFIER, 0); }
		public TerminalNode TYPE() { return getToken(SmallLangV2Parser.TYPE, 0); }
		public FormalparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterFormalparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitFormalparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitFormalparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalparamContext formalparam() throws RecognitionException {
		FormalparamContext _localctx = new FormalparamContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_formalparam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(IDENTIFIER);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(169);
				match(T__3);
				setState(170);
				match(T__4);
				}
			}

			setState(173);
			match(T__7);
			setState(174);
			match(TYPE);
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

	public static class FormalparamsContext extends ParserRuleContext {
		public List<FormalparamContext> formalparam() {
			return getRuleContexts(FormalparamContext.class);
		}
		public FormalparamContext formalparam(int i) {
			return getRuleContext(FormalparamContext.class,i);
		}
		public FormalparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterFormalparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitFormalparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitFormalparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalparamsContext formalparams() throws RecognitionException {
		FormalparamsContext _localctx = new FormalparamsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_formalparams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			formalparam();
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(177);
				match(T__0);
				setState(178);
				formalparam();
				}
				}
				setState(183);
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

	public static class FunctiondeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SmallLangV2Parser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(SmallLangV2Parser.TYPE, 0); }
		public TerminalNode AUTO() { return getToken(SmallLangV2Parser.AUTO, 0); }
		public FormalparamsContext formalparams() {
			return getRuleContext(FormalparamsContext.class,0);
		}
		public FunctiondeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiondecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterFunctiondecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitFunctiondecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitFunctiondecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctiondeclContext functiondecl() throws RecognitionException {
		FunctiondeclContext _localctx = new FunctiondeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functiondecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(T__15);
			setState(185);
			match(IDENTIFIER);
			setState(186);
			match(T__1);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(187);
				formalparams();
				}
			}

			setState(190);
			match(T__2);
			setState(191);
			match(T__7);
			setState(192);
			_la = _input.LA(1);
			if ( !(_la==TYPE || _la==AUTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ArraydeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SmallLangV2Parser.IDENTIFIER, 0); }
		public TerminalNode INTEGERLITERAL() { return getToken(SmallLangV2Parser.INTEGERLITERAL, 0); }
		public TerminalNode TYPE() { return getToken(SmallLangV2Parser.TYPE, 0); }
		public TerminalNode AUTO() { return getToken(SmallLangV2Parser.AUTO, 0); }
		public ArrayelementsContext arrayelements() {
			return getRuleContext(ArrayelementsContext.class,0);
		}
		public ArraydeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraydecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterArraydecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitArraydecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitArraydecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraydeclContext arraydecl() throws RecognitionException {
		ArraydeclContext _localctx = new ArraydeclContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_arraydecl);
		int _la;
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				match(T__6);
				setState(196);
				match(IDENTIFIER);
				setState(197);
				match(T__3);
				setState(198);
				match(INTEGERLITERAL);
				setState(199);
				match(T__4);
				setState(200);
				match(T__7);
				setState(201);
				_la = _input.LA(1);
				if ( !(_la==TYPE || _la==AUTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(202);
					match(T__5);
					setState(203);
					arrayelements();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(T__6);
				setState(207);
				match(IDENTIFIER);
				setState(208);
				match(T__3);
				setState(209);
				match(T__4);
				setState(210);
				match(T__7);
				setState(211);
				_la = _input.LA(1);
				if ( !(_la==TYPE || _la==AUTO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(212);
				match(T__5);
				setState(213);
				arrayelements();
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

	public static class ArrayelementsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayelementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayelements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterArrayelements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitArrayelements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitArrayelements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayelementsContext arrayelements() throws RecognitionException {
		ArrayelementsContext _localctx = new ArrayelementsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_arrayelements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__16);
			{
			setState(217);
			expression();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(218);
				match(T__0);
				setState(219);
				expression();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(225);
			match(T__17);
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

	public static class ArrayassignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SmallLangV2Parser.IDENTIFIER, 0); }
		public TerminalNode INTEGERLITERAL() { return getToken(SmallLangV2Parser.INTEGERLITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayassignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayassignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterArrayassignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitArrayassignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitArrayassignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayassignmentContext arrayassignment() throws RecognitionException {
		ArrayassignmentContext _localctx = new ArrayassignmentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arrayassignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(IDENTIFIER);
			setState(228);
			match(T__3);
			setState(229);
			match(INTEGERLITERAL);
			setState(230);
			match(T__4);
			setState(231);
			match(T__5);
			setState(232);
			expression();
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
		public VariabledeclContext variabledecl() {
			return getRuleContext(VariabledeclContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintstatementContext printstatement() {
			return getRuleContext(PrintstatementContext.class,0);
		}
		public IfstatementContext ifstatement() {
			return getRuleContext(IfstatementContext.class,0);
		}
		public ForstatementContext forstatement() {
			return getRuleContext(ForstatementContext.class,0);
		}
		public WhilestatementContext whilestatement() {
			return getRuleContext(WhilestatementContext.class,0);
		}
		public RtrnstatementContext rtrnstatement() {
			return getRuleContext(RtrnstatementContext.class,0);
		}
		public FunctiondeclContext functiondecl() {
			return getRuleContext(FunctiondeclContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ArraydeclContext arraydecl() {
			return getRuleContext(ArraydeclContext.class,0);
		}
		public ArrayassignmentContext arrayassignment() {
			return getRuleContext(ArrayassignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_statement);
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				variabledecl();
				setState(235);
				match(T__13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				assignment();
				setState(238);
				match(T__13);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				printstatement();
				setState(241);
				match(T__13);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(243);
				ifstatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(244);
				forstatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(245);
				whilestatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(246);
				rtrnstatement();
				setState(247);
				match(T__13);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(249);
				functiondecl();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(250);
				block();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(251);
				arraydecl();
				setState(252);
				match(T__13);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(254);
				arrayassignment();
				setState(255);
				match(T__13);
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

	public static class BlockContext extends ParserRuleContext {
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
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(T__16);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(260);
				statement();
				}
				}
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(266);
			match(T__17);
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

	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangV2Listener ) ((SmallLangV2Listener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangV2Visitor ) return ((SmallLangV2Visitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(268);
				statement();
				}
				}
				setState(273);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u0115\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\3\7\3<\n\3\f\3\16\3?\13\3\3\4\3"+
		"\4\3\4\5\4D\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bZ\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\te\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\np\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13{\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u0095\n\20\3\21\3\21\3\21\5\21\u009a\n\21\3\21\3\21\3"+
		"\21\3\21\5\21\u00a0\n\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\5\23\u00ae\n\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u00b6"+
		"\n\24\f\24\16\24\u00b9\13\24\3\25\3\25\3\25\3\25\5\25\u00bf\n\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u00cf\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00d9\n\26\3"+
		"\27\3\27\3\27\3\27\7\27\u00df\n\27\f\27\16\27\u00e2\13\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\5\31\u0104\n\31\3\32\3\32\7\32\u0108\n\32\f\32\16\32\u010b\13"+
		"\32\3\32\3\32\3\33\7\33\u0110\n\33\f\33\16\33\u0113\13\33\3\33\2\2\34"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\4\3\2\27\32"+
		"\3\2\25\26\2\u011c\2\66\3\2\2\2\48\3\2\2\2\6@\3\2\2\2\bG\3\2\2\2\nK\3"+
		"\2\2\2\fN\3\2\2\2\16Y\3\2\2\2\20d\3\2\2\2\22o\3\2\2\2\24z\3\2\2\2\26|"+
		"\3\2\2\2\30\u0080\3\2\2\2\32\u0087\3\2\2\2\34\u008a\3\2\2\2\36\u008d\3"+
		"\2\2\2 \u0096\3\2\2\2\"\u00a4\3\2\2\2$\u00aa\3\2\2\2&\u00b2\3\2\2\2(\u00ba"+
		"\3\2\2\2*\u00d8\3\2\2\2,\u00da\3\2\2\2.\u00e5\3\2\2\2\60\u0103\3\2\2\2"+
		"\62\u0105\3\2\2\2\64\u0111\3\2\2\2\66\67\t\2\2\2\67\3\3\2\2\28=\5\24\13"+
		"\29:\7\3\2\2:<\5\24\13\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\5\3"+
		"\2\2\2?=\3\2\2\2@A\7\37\2\2AC\7\4\2\2BD\5\4\3\2CB\3\2\2\2CD\3\2\2\2DE"+
		"\3\2\2\2EF\7\5\2\2F\7\3\2\2\2GH\7\4\2\2HI\5\24\13\2IJ\7\5\2\2J\t\3\2\2"+
		"\2KL\7\36\2\2LM\5\24\13\2M\13\3\2\2\2NO\7\37\2\2OP\7\6\2\2PQ\7\30\2\2"+
		"QR\7\7\2\2R\r\3\2\2\2SZ\5\2\2\2TZ\7\37\2\2UZ\5\6\4\2VZ\5\f\7\2WZ\5\b\5"+
		"\2XZ\5\n\6\2YS\3\2\2\2YT\3\2\2\2YU\3\2\2\2YV\3\2\2\2YW\3\2\2\2YX\3\2\2"+
		"\2Z\17\3\2\2\2[\\\5\16\b\2\\]\7\33\2\2]^\5\16\b\2^e\3\2\2\2_`\5\16\b\2"+
		"`a\7\33\2\2ab\5\20\t\2be\3\2\2\2ce\5\16\b\2d[\3\2\2\2d_\3\2\2\2dc\3\2"+
		"\2\2e\21\3\2\2\2fg\5\20\t\2gh\7\34\2\2hi\5\20\t\2ip\3\2\2\2jk\5\20\t\2"+
		"kl\7\34\2\2lm\5\22\n\2mp\3\2\2\2np\5\20\t\2of\3\2\2\2oj\3\2\2\2on\3\2"+
		"\2\2p\23\3\2\2\2qr\5\22\n\2rs\7\35\2\2st\5\22\n\2t{\3\2\2\2uv\5\22\n\2"+
		"vw\7\35\2\2wx\5\24\13\2x{\3\2\2\2y{\5\22\n\2zq\3\2\2\2zu\3\2\2\2zy\3\2"+
		"\2\2{\25\3\2\2\2|}\7\37\2\2}~\7\b\2\2~\177\5\24\13\2\177\27\3\2\2\2\u0080"+
		"\u0081\7\t\2\2\u0081\u0082\7\37\2\2\u0082\u0083\7\n\2\2\u0083\u0084\t"+
		"\3\2\2\u0084\u0085\7\b\2\2\u0085\u0086\5\24\13\2\u0086\31\3\2\2\2\u0087"+
		"\u0088\7\13\2\2\u0088\u0089\5\24\13\2\u0089\33\3\2\2\2\u008a\u008b\7\f"+
		"\2\2\u008b\u008c\5\24\13\2\u008c\35\3\2\2\2\u008d\u008e\7\r\2\2\u008e"+
		"\u008f\7\4\2\2\u008f\u0090\5\24\13\2\u0090\u0091\7\5\2\2\u0091\u0094\5"+
		"\62\32\2\u0092\u0093\7\16\2\2\u0093\u0095\5\62\32\2\u0094\u0092\3\2\2"+
		"\2\u0094\u0095\3\2\2\2\u0095\37\3\2\2\2\u0096\u0097\7\17\2\2\u0097\u0099"+
		"\7\4\2\2\u0098\u009a\5\30\r\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2"+
		"\u009a\u009b\3\2\2\2\u009b\u009c\7\20\2\2\u009c\u009d\5\24\13\2\u009d"+
		"\u009f\7\20\2\2\u009e\u00a0\5\26\f\2\u009f\u009e\3\2\2\2\u009f\u00a0\3"+
		"\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\5\2\2\u00a2\u00a3\5\62\32\2\u00a3"+
		"!\3\2\2\2\u00a4\u00a5\7\21\2\2\u00a5\u00a6\7\4\2\2\u00a6\u00a7\5\24\13"+
		"\2\u00a7\u00a8\7\5\2\2\u00a8\u00a9\5\62\32\2\u00a9#\3\2\2\2\u00aa\u00ad"+
		"\7\37\2\2\u00ab\u00ac\7\6\2\2\u00ac\u00ae\7\7\2\2\u00ad\u00ab\3\2\2\2"+
		"\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\7\n\2\2\u00b0\u00b1"+
		"\7\25\2\2\u00b1%\3\2\2\2\u00b2\u00b7\5$\23\2\u00b3\u00b4\7\3\2\2\u00b4"+
		"\u00b6\5$\23\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\'\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb"+
		"\7\22\2\2\u00bb\u00bc\7\37\2\2\u00bc\u00be\7\4\2\2\u00bd\u00bf\5&\24\2"+
		"\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1"+
		"\7\5\2\2\u00c1\u00c2\7\n\2\2\u00c2\u00c3\t\3\2\2\u00c3\u00c4\5\62\32\2"+
		"\u00c4)\3\2\2\2\u00c5\u00c6\7\t\2\2\u00c6\u00c7\7\37\2\2\u00c7\u00c8\7"+
		"\6\2\2\u00c8\u00c9\7\30\2\2\u00c9\u00ca\7\7\2\2\u00ca\u00cb\7\n\2\2\u00cb"+
		"\u00ce\t\3\2\2\u00cc\u00cd\7\b\2\2\u00cd\u00cf\5,\27\2\u00ce\u00cc\3\2"+
		"\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d9\3\2\2\2\u00d0\u00d1\7\t\2\2\u00d1"+
		"\u00d2\7\37\2\2\u00d2\u00d3\7\6\2\2\u00d3\u00d4\7\7\2\2\u00d4\u00d5\7"+
		"\n\2\2\u00d5\u00d6\t\3\2\2\u00d6\u00d7\7\b\2\2\u00d7\u00d9\5,\27\2\u00d8"+
		"\u00c5\3\2\2\2\u00d8\u00d0\3\2\2\2\u00d9+\3\2\2\2\u00da\u00db\7\23\2\2"+
		"\u00db\u00e0\5\24\13\2\u00dc\u00dd\7\3\2\2\u00dd\u00df\5\24\13\2\u00de"+
		"\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\7\24\2\2\u00e4"+
		"-\3\2\2\2\u00e5\u00e6\7\37\2\2\u00e6\u00e7\7\6\2\2\u00e7\u00e8\7\30\2"+
		"\2\u00e8\u00e9\7\7\2\2\u00e9\u00ea\7\b\2\2\u00ea\u00eb\5\24\13\2\u00eb"+
		"/\3\2\2\2\u00ec\u00ed\5\30\r\2\u00ed\u00ee\7\20\2\2\u00ee\u0104\3\2\2"+
		"\2\u00ef\u00f0\5\26\f\2\u00f0\u00f1\7\20\2\2\u00f1\u0104\3\2\2\2\u00f2"+
		"\u00f3\5\32\16\2\u00f3\u00f4\7\20\2\2\u00f4\u0104\3\2\2\2\u00f5\u0104"+
		"\5\36\20\2\u00f6\u0104\5 \21\2\u00f7\u0104\5\"\22\2\u00f8\u00f9\5\34\17"+
		"\2\u00f9\u00fa\7\20\2\2\u00fa\u0104\3\2\2\2\u00fb\u0104\5(\25\2\u00fc"+
		"\u0104\5\62\32\2\u00fd\u00fe\5*\26\2\u00fe\u00ff\7\20\2\2\u00ff\u0104"+
		"\3\2\2\2\u0100\u0101\5.\30\2\u0101\u0102\7\20\2\2\u0102\u0104\3\2\2\2"+
		"\u0103\u00ec\3\2\2\2\u0103\u00ef\3\2\2\2\u0103\u00f2\3\2\2\2\u0103\u00f5"+
		"\3\2\2\2\u0103\u00f6\3\2\2\2\u0103\u00f7\3\2\2\2\u0103\u00f8\3\2\2\2\u0103"+
		"\u00fb\3\2\2\2\u0103\u00fc\3\2\2\2\u0103\u00fd\3\2\2\2\u0103\u0100\3\2"+
		"\2\2\u0104\61\3\2\2\2\u0105\u0109\7\23\2\2\u0106\u0108\5\60\31\2\u0107"+
		"\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010d\7\24\2\2\u010d"+
		"\63\3\2\2\2\u010e\u0110\5\60\31\2\u010f\u010e\3\2\2\2\u0110\u0113\3\2"+
		"\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\65\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\24=CYdoz\u0094\u0099\u009f\u00ad\u00b7\u00be\u00ce\u00d8\u00e0"+
		"\u0103\u0109\u0111";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}