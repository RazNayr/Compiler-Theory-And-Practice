// Generated from C:/Users/Owner/IdeaProjects/SmallLangV2-Compiler-part2/src/Grammars\SmallLangV2.g4 by ANTLR 4.8
package ANTLRV2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SmallLangV2Parser}.
 */
public interface SmallLangV2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SmallLangV2Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SmallLangV2Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#actualparams}.
	 * @param ctx the parse tree
	 */
	void enterActualparams(SmallLangV2Parser.ActualparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#actualparams}.
	 * @param ctx the parse tree
	 */
	void exitActualparams(SmallLangV2Parser.ActualparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(SmallLangV2Parser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(SmallLangV2Parser.FunctioncallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#subexpression}.
	 * @param ctx the parse tree
	 */
	void enterSubexpression(SmallLangV2Parser.SubexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#subexpression}.
	 * @param ctx the parse tree
	 */
	void exitSubexpression(SmallLangV2Parser.SubexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(SmallLangV2Parser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(SmallLangV2Parser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#arraycall}.
	 * @param ctx the parse tree
	 */
	void enterArraycall(SmallLangV2Parser.ArraycallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#arraycall}.
	 * @param ctx the parse tree
	 */
	void exitArraycall(SmallLangV2Parser.ArraycallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(SmallLangV2Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(SmallLangV2Parser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(SmallLangV2Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(SmallLangV2Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#simpleexpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleexpression(SmallLangV2Parser.SimpleexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#simpleexpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleexpression(SmallLangV2Parser.SimpleexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SmallLangV2Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SmallLangV2Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SmallLangV2Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SmallLangV2Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#variabledecl}.
	 * @param ctx the parse tree
	 */
	void enterVariabledecl(SmallLangV2Parser.VariabledeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#variabledecl}.
	 * @param ctx the parse tree
	 */
	void exitVariabledecl(SmallLangV2Parser.VariabledeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#printstatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintstatement(SmallLangV2Parser.PrintstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#printstatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintstatement(SmallLangV2Parser.PrintstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#rtrnstatement}.
	 * @param ctx the parse tree
	 */
	void enterRtrnstatement(SmallLangV2Parser.RtrnstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#rtrnstatement}.
	 * @param ctx the parse tree
	 */
	void exitRtrnstatement(SmallLangV2Parser.RtrnstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(SmallLangV2Parser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(SmallLangV2Parser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#forstatement}.
	 * @param ctx the parse tree
	 */
	void enterForstatement(SmallLangV2Parser.ForstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#forstatement}.
	 * @param ctx the parse tree
	 */
	void exitForstatement(SmallLangV2Parser.ForstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void enterWhilestatement(SmallLangV2Parser.WhilestatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void exitWhilestatement(SmallLangV2Parser.WhilestatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#formalparam}.
	 * @param ctx the parse tree
	 */
	void enterFormalparam(SmallLangV2Parser.FormalparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#formalparam}.
	 * @param ctx the parse tree
	 */
	void exitFormalparam(SmallLangV2Parser.FormalparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#formalparams}.
	 * @param ctx the parse tree
	 */
	void enterFormalparams(SmallLangV2Parser.FormalparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#formalparams}.
	 * @param ctx the parse tree
	 */
	void exitFormalparams(SmallLangV2Parser.FormalparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#functiondecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctiondecl(SmallLangV2Parser.FunctiondeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#functiondecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctiondecl(SmallLangV2Parser.FunctiondeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#arraydecl}.
	 * @param ctx the parse tree
	 */
	void enterArraydecl(SmallLangV2Parser.ArraydeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#arraydecl}.
	 * @param ctx the parse tree
	 */
	void exitArraydecl(SmallLangV2Parser.ArraydeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#arrayelements}.
	 * @param ctx the parse tree
	 */
	void enterArrayelements(SmallLangV2Parser.ArrayelementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#arrayelements}.
	 * @param ctx the parse tree
	 */
	void exitArrayelements(SmallLangV2Parser.ArrayelementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#arrayassignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayassignment(SmallLangV2Parser.ArrayassignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#arrayassignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayassignment(SmallLangV2Parser.ArrayassignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SmallLangV2Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SmallLangV2Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SmallLangV2Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SmallLangV2Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV2Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SmallLangV2Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV2Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SmallLangV2Parser.ProgramContext ctx);
}