// Generated from C:/Users/Owner/IdeaProjects/SmallLangV2-Compiler-part2/src/Grammars\SmallLangV2.g4 by ANTLR 4.8
package ANTLRV2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SmallLangV2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SmallLangV2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SmallLangV2Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#actualparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualparams(SmallLangV2Parser.ActualparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(SmallLangV2Parser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#subexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubexpression(SmallLangV2Parser.SubexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(SmallLangV2Parser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#arraycall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraycall(SmallLangV2Parser.ArraycallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(SmallLangV2Parser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(SmallLangV2Parser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#simpleexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleexpression(SmallLangV2Parser.SimpleexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SmallLangV2Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SmallLangV2Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#variabledecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariabledecl(SmallLangV2Parser.VariabledeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#printstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintstatement(SmallLangV2Parser.PrintstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#rtrnstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtrnstatement(SmallLangV2Parser.RtrnstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(SmallLangV2Parser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#forstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstatement(SmallLangV2Parser.ForstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#whilestatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestatement(SmallLangV2Parser.WhilestatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#formalparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalparam(SmallLangV2Parser.FormalparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#formalparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalparams(SmallLangV2Parser.FormalparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#functiondecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiondecl(SmallLangV2Parser.FunctiondeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#arraydecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraydecl(SmallLangV2Parser.ArraydeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#arrayelements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayelements(SmallLangV2Parser.ArrayelementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#arrayassignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayassignment(SmallLangV2Parser.ArrayassignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SmallLangV2Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SmallLangV2Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangV2Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SmallLangV2Parser.ProgramContext ctx);
}