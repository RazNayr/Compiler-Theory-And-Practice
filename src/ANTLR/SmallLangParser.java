// Generated from C:/Users/Owner/IdeaProjects/SmallLangV2-Compiler-part2/src/Grammars\SmallLang.g4 by ANTLR 4.8
package ANTLR;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmallLangParser extends Parser {
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
	public static final int
		RULE_literal = 0, RULE_actualparams = 1, RULE_functioncall = 2, RULE_subexpression = 3, 
		RULE_unary = 4, RULE_factor = 5, RULE_term = 6, RULE_simpleexpression = 7, 
		RULE_expression = 8, RULE_assignment = 9, RULE_variabledecl = 10, RULE_printstatement = 11, 
		RULE_rtrnstatement = 12, RULE_ifstatement = 13, RULE_forstatement = 14, 
		RULE_whilestatement = 15, RULE_formalparam = 16, RULE_formalparams = 17, 
		RULE_functiondecl = 18, RULE_statement = 19, RULE_block = 20, RULE_program = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"literal", "actualparams", "functioncall", "subexpression", "unary", 
			"factor", "term", "simpleexpression", "expression", "assignment", "variabledecl", 
			"printstatement", "rtrnstatement", "ifstatement", "forstatement", "whilestatement", 
			"formalparam", "formalparams", "functiondecl", "statement", "block", 
			"program"
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

	@Override
	public String getGrammarFileName() { return "SmallLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SmallLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode BOOLEANLITERAL() { return getToken(SmallLangParser.BOOLEANLITERAL, 0); }
		public TerminalNode INTEGERLITERAL() { return getToken(SmallLangParser.INTEGERLITERAL, 0); }
		public TerminalNode FLOATLITERAL() { return getToken(SmallLangParser.FLOATLITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitLiteral(this);
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
			setState(44);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEANLITERAL) | (1L << INTEGERLITERAL) | (1L << FLOATLITERAL))) != 0)) ) {
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
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterActualparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitActualparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitActualparams(this);
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
			setState(46);
			expression();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(47);
				match(T__0);
				setState(48);
				expression();
				}
				}
				setState(53);
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
		public TerminalNode IDENTIFIER() { return getToken(SmallLangParser.IDENTIFIER, 0); }
		public ActualparamsContext actualparams() {
			return getRuleContext(ActualparamsContext.class,0);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterFunctioncall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitFunctioncall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitFunctioncall(this);
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
			setState(54);
			match(IDENTIFIER);
			setState(55);
			match(T__1);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << BOOLEANLITERAL) | (1L << INTEGERLITERAL) | (1L << FLOATLITERAL) | (1L << UNARYOP) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(56);
				actualparams();
				}
			}

			setState(59);
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
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterSubexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitSubexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitSubexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubexpressionContext subexpression() throws RecognitionException {
		SubexpressionContext _localctx = new SubexpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_subexpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__1);
			setState(62);
			expression();
			setState(63);
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
		public TerminalNode UNARYOP() { return getToken(SmallLangParser.UNARYOP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(UNARYOP);
			setState(66);
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

	public static class FactorContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SmallLangParser.IDENTIFIER, 0); }
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
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
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_factor);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				functioncall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				subexpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
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
		public TerminalNode MULTIPLICATIVEOP() { return getToken(SmallLangParser.MULTIPLICATIVEOP, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_term);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				factor();
				setState(76);
				match(MULTIPLICATIVEOP);
				setState(77);
				factor();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				factor();
				setState(80);
				match(MULTIPLICATIVEOP);
				setState(81);
				term();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
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
		public TerminalNode ADDITIVEOP() { return getToken(SmallLangParser.ADDITIVEOP, 0); }
		public SimpleexpressionContext simpleexpression() {
			return getRuleContext(SimpleexpressionContext.class,0);
		}
		public SimpleexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterSimpleexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitSimpleexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitSimpleexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleexpressionContext simpleexpression() throws RecognitionException {
		SimpleexpressionContext _localctx = new SimpleexpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_simpleexpression);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				term();
				setState(87);
				match(ADDITIVEOP);
				setState(88);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				term();
				setState(91);
				match(ADDITIVEOP);
				setState(92);
				simpleexpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
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
		public TerminalNode RELATIONALOP() { return getToken(SmallLangParser.RELATIONALOP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				simpleexpression();
				setState(98);
				match(RELATIONALOP);
				setState(99);
				simpleexpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				simpleexpression();
				setState(102);
				match(RELATIONALOP);
				setState(103);
				expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
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
		public TerminalNode IDENTIFIER() { return getToken(SmallLangParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(IDENTIFIER);
			setState(109);
			match(T__3);
			setState(110);
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
		public TerminalNode IDENTIFIER() { return getToken(SmallLangParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(SmallLangParser.TYPE, 0); }
		public TerminalNode AUTO() { return getToken(SmallLangParser.AUTO, 0); }
		public VariabledeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variabledecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterVariabledecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitVariabledecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitVariabledecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariabledeclContext variabledecl() throws RecognitionException {
		VariabledeclContext _localctx = new VariabledeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variabledecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__4);
			setState(113);
			match(IDENTIFIER);
			setState(114);
			match(T__5);
			setState(115);
			_la = _input.LA(1);
			if ( !(_la==TYPE || _la==AUTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(116);
			match(T__3);
			setState(117);
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
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterPrintstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitPrintstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitPrintstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintstatementContext printstatement() throws RecognitionException {
		PrintstatementContext _localctx = new PrintstatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_printstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__6);
			setState(120);
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
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterRtrnstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitRtrnstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitRtrnstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RtrnstatementContext rtrnstatement() throws RecognitionException {
		RtrnstatementContext _localctx = new RtrnstatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rtrnstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__7);
			setState(123);
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
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterIfstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitIfstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitIfstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstatementContext ifstatement() throws RecognitionException {
		IfstatementContext _localctx = new IfstatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__8);
			setState(126);
			match(T__1);
			setState(127);
			expression();
			setState(128);
			match(T__2);
			setState(129);
			block();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(130);
				match(T__9);
				setState(131);
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
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterForstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitForstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitForstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForstatementContext forstatement() throws RecognitionException {
		ForstatementContext _localctx = new ForstatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__10);
			setState(135);
			match(T__1);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(136);
				variabledecl();
				}
			}

			setState(139);
			match(T__11);
			setState(140);
			expression();
			setState(141);
			match(T__11);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(142);
				assignment();
				}
			}

			setState(145);
			match(T__2);
			setState(146);
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
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterWhilestatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitWhilestatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitWhilestatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestatementContext whilestatement() throws RecognitionException {
		WhilestatementContext _localctx = new WhilestatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_whilestatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__12);
			setState(149);
			match(T__1);
			setState(150);
			expression();
			setState(151);
			match(T__2);
			setState(152);
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
		public TerminalNode IDENTIFIER() { return getToken(SmallLangParser.IDENTIFIER, 0); }
		public TerminalNode TYPE() { return getToken(SmallLangParser.TYPE, 0); }
		public FormalparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterFormalparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitFormalparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitFormalparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalparamContext formalparam() throws RecognitionException {
		FormalparamContext _localctx = new FormalparamContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_formalparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(IDENTIFIER);
			setState(155);
			match(T__5);
			setState(156);
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
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterFormalparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitFormalparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitFormalparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalparamsContext formalparams() throws RecognitionException {
		FormalparamsContext _localctx = new FormalparamsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_formalparams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			formalparam();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(159);
				match(T__0);
				setState(160);
				formalparam();
				}
				}
				setState(165);
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
		public TerminalNode IDENTIFIER() { return getToken(SmallLangParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(SmallLangParser.TYPE, 0); }
		public TerminalNode AUTO() { return getToken(SmallLangParser.AUTO, 0); }
		public FormalparamsContext formalparams() {
			return getRuleContext(FormalparamsContext.class,0);
		}
		public FunctiondeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiondecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterFunctiondecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitFunctiondecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitFunctiondecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctiondeclContext functiondecl() throws RecognitionException {
		FunctiondeclContext _localctx = new FunctiondeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functiondecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__13);
			setState(167);
			match(IDENTIFIER);
			setState(168);
			match(T__1);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(169);
				formalparams();
				}
			}

			setState(172);
			match(T__2);
			setState(173);
			match(T__5);
			setState(174);
			_la = _input.LA(1);
			if ( !(_la==TYPE || _la==AUTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(175);
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
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statement);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				variabledecl();
				setState(178);
				match(T__11);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				assignment();
				setState(181);
				match(T__11);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				printstatement();
				setState(184);
				match(T__11);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(186);
				ifstatement();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(187);
				forstatement();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				whilestatement();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 7);
				{
				setState(189);
				rtrnstatement();
				setState(190);
				match(T__11);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 8);
				{
				setState(192);
				functiondecl();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 9);
				{
				setState(193);
				block();
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
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__14);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(197);
				statement();
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(203);
			match(T__15);
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
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmallLangListener ) ((SmallLangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmallLangVisitor ) return ((SmallLangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(205);
				statement();
				}
				}
				setState(210);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3\3\3\3"+
		"\7\3\64\n\3\f\3\16\3\67\13\3\3\4\3\4\3\4\5\4<\n\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7L\n\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\bW\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tb\n\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nm\n\n\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\5\17\u0087\n\17\3\20\3\20\3\20\5\20\u008c\n\20\3\20\3\20"+
		"\3\20\3\20\5\20\u0092\n\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u00a4\n\23\f\23\16\23\u00a7\13"+
		"\23\3\24\3\24\3\24\3\24\5\24\u00ad\n\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u00c5\n\25\3\26\3\26\7\26\u00c9\n\26\f\26\16\26\u00cc"+
		"\13\26\3\26\3\26\3\27\7\27\u00d1\n\27\f\27\16\27\u00d4\13\27\3\27\2\2"+
		"\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\4\3\2\25\27\3\2\23"+
		"\24\2\u00da\2.\3\2\2\2\4\60\3\2\2\2\68\3\2\2\2\b?\3\2\2\2\nC\3\2\2\2\f"+
		"K\3\2\2\2\16V\3\2\2\2\20a\3\2\2\2\22l\3\2\2\2\24n\3\2\2\2\26r\3\2\2\2"+
		"\30y\3\2\2\2\32|\3\2\2\2\34\177\3\2\2\2\36\u0088\3\2\2\2 \u0096\3\2\2"+
		"\2\"\u009c\3\2\2\2$\u00a0\3\2\2\2&\u00a8\3\2\2\2(\u00c4\3\2\2\2*\u00c6"+
		"\3\2\2\2,\u00d2\3\2\2\2./\t\2\2\2/\3\3\2\2\2\60\65\5\22\n\2\61\62\7\3"+
		"\2\2\62\64\5\22\n\2\63\61\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3"+
		"\2\2\2\66\5\3\2\2\2\67\65\3\2\2\289\7\34\2\29;\7\4\2\2:<\5\4\3\2;:\3\2"+
		"\2\2;<\3\2\2\2<=\3\2\2\2=>\7\5\2\2>\7\3\2\2\2?@\7\4\2\2@A\5\22\n\2AB\7"+
		"\5\2\2B\t\3\2\2\2CD\7\33\2\2DE\5\22\n\2E\13\3\2\2\2FL\5\2\2\2GL\7\34\2"+
		"\2HL\5\6\4\2IL\5\b\5\2JL\5\n\6\2KF\3\2\2\2KG\3\2\2\2KH\3\2\2\2KI\3\2\2"+
		"\2KJ\3\2\2\2L\r\3\2\2\2MN\5\f\7\2NO\7\30\2\2OP\5\f\7\2PW\3\2\2\2QR\5\f"+
		"\7\2RS\7\30\2\2ST\5\16\b\2TW\3\2\2\2UW\5\f\7\2VM\3\2\2\2VQ\3\2\2\2VU\3"+
		"\2\2\2W\17\3\2\2\2XY\5\16\b\2YZ\7\31\2\2Z[\5\16\b\2[b\3\2\2\2\\]\5\16"+
		"\b\2]^\7\31\2\2^_\5\20\t\2_b\3\2\2\2`b\5\16\b\2aX\3\2\2\2a\\\3\2\2\2a"+
		"`\3\2\2\2b\21\3\2\2\2cd\5\20\t\2de\7\32\2\2ef\5\20\t\2fm\3\2\2\2gh\5\20"+
		"\t\2hi\7\32\2\2ij\5\22\n\2jm\3\2\2\2km\5\20\t\2lc\3\2\2\2lg\3\2\2\2lk"+
		"\3\2\2\2m\23\3\2\2\2no\7\34\2\2op\7\6\2\2pq\5\22\n\2q\25\3\2\2\2rs\7\7"+
		"\2\2st\7\34\2\2tu\7\b\2\2uv\t\3\2\2vw\7\6\2\2wx\5\22\n\2x\27\3\2\2\2y"+
		"z\7\t\2\2z{\5\22\n\2{\31\3\2\2\2|}\7\n\2\2}~\5\22\n\2~\33\3\2\2\2\177"+
		"\u0080\7\13\2\2\u0080\u0081\7\4\2\2\u0081\u0082\5\22\n\2\u0082\u0083\7"+
		"\5\2\2\u0083\u0086\5*\26\2\u0084\u0085\7\f\2\2\u0085\u0087\5*\26\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\35\3\2\2\2\u0088\u0089\7\r\2"+
		"\2\u0089\u008b\7\4\2\2\u008a\u008c\5\26\f\2\u008b\u008a\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\16\2\2\u008e\u008f\5"+
		"\22\n\2\u008f\u0091\7\16\2\2\u0090\u0092\5\24\13\2\u0091\u0090\3\2\2\2"+
		"\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7\5\2\2\u0094\u0095"+
		"\5*\26\2\u0095\37\3\2\2\2\u0096\u0097\7\17\2\2\u0097\u0098\7\4\2\2\u0098"+
		"\u0099\5\22\n\2\u0099\u009a\7\5\2\2\u009a\u009b\5*\26\2\u009b!\3\2\2\2"+
		"\u009c\u009d\7\34\2\2\u009d\u009e\7\b\2\2\u009e\u009f\7\23\2\2\u009f#"+
		"\3\2\2\2\u00a0\u00a5\5\"\22\2\u00a1\u00a2\7\3\2\2\u00a2\u00a4\5\"\22\2"+
		"\u00a3\u00a1\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6%\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7\20\2\2\u00a9"+
		"\u00aa\7\34\2\2\u00aa\u00ac\7\4\2\2\u00ab\u00ad\5$\23\2\u00ac\u00ab\3"+
		"\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\5\2\2\u00af"+
		"\u00b0\7\b\2\2\u00b0\u00b1\t\3\2\2\u00b1\u00b2\5*\26\2\u00b2\'\3\2\2\2"+
		"\u00b3\u00b4\5\26\f\2\u00b4\u00b5\7\16\2\2\u00b5\u00c5\3\2\2\2\u00b6\u00b7"+
		"\5\24\13\2\u00b7\u00b8\7\16\2\2\u00b8\u00c5\3\2\2\2\u00b9\u00ba\5\30\r"+
		"\2\u00ba\u00bb\7\16\2\2\u00bb\u00c5\3\2\2\2\u00bc\u00c5\5\34\17\2\u00bd"+
		"\u00c5\5\36\20\2\u00be\u00c5\5 \21\2\u00bf\u00c0\5\32\16\2\u00c0\u00c1"+
		"\7\16\2\2\u00c1\u00c5\3\2\2\2\u00c2\u00c5\5&\24\2\u00c3\u00c5\5*\26\2"+
		"\u00c4\u00b3\3\2\2\2\u00c4\u00b6\3\2\2\2\u00c4\u00b9\3\2\2\2\u00c4\u00bc"+
		"\3\2\2\2\u00c4\u00bd\3\2\2\2\u00c4\u00be\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5)\3\2\2\2\u00c6\u00ca\7\21\2\2"+
		"\u00c7\u00c9\5(\25\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd"+
		"\u00ce\7\22\2\2\u00ce+\3\2\2\2\u00cf\u00d1\5(\25\2\u00d0\u00cf\3\2\2\2"+
		"\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3-\3"+
		"\2\2\2\u00d4\u00d2\3\2\2\2\20\65;KVal\u0086\u008b\u0091\u00a5\u00ac\u00c4"+
		"\u00ca\u00d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}