// Generated from C:/Users/Owner/IdeaProjects/SmallLangV2-Compiler-part2/src/Grammars\SmallLang.g4 by ANTLR 4.8
package ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SmallLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SmallLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SmallLangParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#actualparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualparams(SmallLangParser.ActualparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(SmallLangParser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#subexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubexpression(SmallLangParser.SubexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(SmallLangParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(SmallLangParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(SmallLangParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#simpleexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleexpression(SmallLangParser.SimpleexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SmallLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SmallLangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#variabledecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariabledecl(SmallLangParser.VariabledeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#printstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintstatement(SmallLangParser.PrintstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#rtrnstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtrnstatement(SmallLangParser.RtrnstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(SmallLangParser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#forstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstatement(SmallLangParser.ForstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#whilestatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestatement(SmallLangParser.WhilestatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#formalparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalparam(SmallLangParser.FormalparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#formalparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalparams(SmallLangParser.FormalparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#functiondecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiondecl(SmallLangParser.FunctiondeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SmallLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SmallLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmallLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SmallLangParser.ProgramContext ctx);
}