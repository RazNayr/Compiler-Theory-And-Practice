// Generated from C:/Users/Owner/IdeaProjects/SmallLangV2-Compiler-part2/src/Grammars\SmallLang.g4 by ANTLR 4.8
package ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SmallLangParser}.
 */
public interface SmallLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SmallLangParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SmallLangParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#actualparams}.
	 * @param ctx the parse tree
	 */
	void enterActualparams(SmallLangParser.ActualparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#actualparams}.
	 * @param ctx the parse tree
	 */
	void exitActualparams(SmallLangParser.ActualparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(SmallLangParser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(SmallLangParser.FunctioncallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#subexpression}.
	 * @param ctx the parse tree
	 */
	void enterSubexpression(SmallLangParser.SubexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#subexpression}.
	 * @param ctx the parse tree
	 */
	void exitSubexpression(SmallLangParser.SubexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(SmallLangParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(SmallLangParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(SmallLangParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(SmallLangParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(SmallLangParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(SmallLangParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#simpleexpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleexpression(SmallLangParser.SimpleexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#simpleexpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleexpression(SmallLangParser.SimpleexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SmallLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SmallLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SmallLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SmallLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#variabledecl}.
	 * @param ctx the parse tree
	 */
	void enterVariabledecl(SmallLangParser.VariabledeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#variabledecl}.
	 * @param ctx the parse tree
	 */
	void exitVariabledecl(SmallLangParser.VariabledeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#printstatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintstatement(SmallLangParser.PrintstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#printstatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintstatement(SmallLangParser.PrintstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#rtrnstatement}.
	 * @param ctx the parse tree
	 */
	void enterRtrnstatement(SmallLangParser.RtrnstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#rtrnstatement}.
	 * @param ctx the parse tree
	 */
	void exitRtrnstatement(SmallLangParser.RtrnstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(SmallLangParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(SmallLangParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#forstatement}.
	 * @param ctx the parse tree
	 */
	void enterForstatement(SmallLangParser.ForstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#forstatement}.
	 * @param ctx the parse tree
	 */
	void exitForstatement(SmallLangParser.ForstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void enterWhilestatement(SmallLangParser.WhilestatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#whilestatement}.
	 * @param ctx the parse tree
	 */
	void exitWhilestatement(SmallLangParser.WhilestatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#formalparam}.
	 * @param ctx the parse tree
	 */
	void enterFormalparam(SmallLangParser.FormalparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#formalparam}.
	 * @param ctx the parse tree
	 */
	void exitFormalparam(SmallLangParser.FormalparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#formalparams}.
	 * @param ctx the parse tree
	 */
	void enterFormalparams(SmallLangParser.FormalparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#formalparams}.
	 * @param ctx the parse tree
	 */
	void exitFormalparams(SmallLangParser.FormalparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#functiondecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctiondecl(SmallLangParser.FunctiondeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#functiondecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctiondecl(SmallLangParser.FunctiondeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SmallLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SmallLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SmallLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SmallLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SmallLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SmallLangParser.ProgramContext ctx);
}