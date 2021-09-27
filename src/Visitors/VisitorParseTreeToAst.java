package Visitors;


import ANTLR.SmallLangBaseVisitor;
import ANTLR.SmallLangParser;
import ANTLR.SmallLangVisitor;
import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTNode;
import Parser.AST.ASTProgram;
import Parser.AST.ASTStatementNode;
import Parser.AST.Expressions.*;
import Parser.AST.Expressions.Factors.*;
import Parser.AST.Expressions.Factors.Literals.ASTBooleanLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTFloatLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTIntegerLiteral;
import Parser.AST.Statements.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class VisitorParseTreeToAst implements SmallLangVisitor<ASTNode> {

    @Override public ASTExpressionNode visitLiteral(SmallLangParser.LiteralContext ctx) {

        if(ctx.BOOLEANLITERAL() != null){
            boolean value = Boolean.parseBoolean(ctx.BOOLEANLITERAL().getText());
            return new ASTBooleanLiteral(value);
        }else if(ctx.INTEGERLITERAL() != null){
            int value = Integer.parseInt(ctx.INTEGERLITERAL().getText());
            return new ASTIntegerLiteral(value);
        }else if(ctx.FLOATLITERAL() != null){
            float value = Float.parseFloat(ctx.FLOATLITERAL().getText());
            return new ASTFloatLiteral(value);
        }else{
            return null;
        }
    }

    @Override public ASTActualParams visitActualparams(SmallLangParser.ActualparamsContext ctx) {

        ArrayList<ASTExpressionNode> actualParameters = new ArrayList<>();

        //Check if actual parameters exist
        if(ctx != null){
            for(SmallLangParser.ExpressionContext actualParamContext : ctx.expression() ){
                actualParameters.add(visitExpression(actualParamContext));
            }
        }

        return new ASTActualParams(actualParameters);
    }

    @Override public ASTFunctionCall visitFunctioncall(SmallLangParser.FunctioncallContext ctx) {

        ASTIdentifier identifier = new ASTIdentifier(ctx.IDENTIFIER().getText());
        ASTActualParams actualParams = visitActualparams(ctx.actualparams());

        return new ASTFunctionCall(identifier, actualParams);

    }

    @Override public ASTSubExpression visitSubexpression(SmallLangParser.SubexpressionContext ctx) {

        ASTExpressionNode expression = visitExpression(ctx.expression());
        return new ASTSubExpression(expression);
    }

    @Override public ASTUnary visitUnary(SmallLangParser.UnaryContext ctx) {

        ASTUnaryOp unaryOp = new ASTUnaryOp(ctx.UNARYOP().getText());
        ASTExpressionNode expression = visitExpression(ctx.expression());

        return new ASTUnary(unaryOp, expression);
    }

    @Override public ASTExpressionNode visitFactor(SmallLangParser.FactorContext ctx) {

        if(ctx.literal() != null){
            return visitLiteral(ctx.literal());
        }else if(ctx.IDENTIFIER() != null){
            return new ASTIdentifier(ctx.IDENTIFIER().getText());
        }else if(ctx.functioncall() != null){
            return visitFunctioncall(ctx.functioncall());
        }else if(ctx.subexpression() != null){
            return visitSubexpression(ctx.subexpression());
        }else if(ctx.unary() != null){
            return visitUnary(ctx.unary());
        }else{
            return null;
        }
    }

    @Override public ASTExpressionNode visitTerm(SmallLangParser.TermContext ctx) {

        ASTExpressionNode leftFactor = visitFactor(ctx.factor(0));

        if(ctx.MULTIPLICATIVEOP() != null){

            ASTMultiplicativeOp multiplicativeOp;
            ASTExpressionNode rightFactor;

            //Check if right-recurred expression exists
            if(ctx.term() != null){
                multiplicativeOp = new ASTMultiplicativeOp(ctx.MULTIPLICATIVEOP().getText());
                rightFactor = visitTerm(ctx.term());

                //Else right-factor exists
            }else{
                multiplicativeOp = new ASTMultiplicativeOp(ctx.MULTIPLICATIVEOP().getText());
                rightFactor = visitFactor(ctx.factor(1));
            }

            return new ASTTerm(leftFactor, multiplicativeOp, rightFactor);
        }

        return leftFactor;
    }

    @Override public ASTExpressionNode visitSimpleexpression(SmallLangParser.SimpleexpressionContext ctx) {

        ASTExpressionNode leftTerm = visitTerm(ctx.term(0));

        if(ctx.ADDITIVEOP() != null){

            ASTAdditiveOp additiveOp;
            ASTExpressionNode rightTerm;

                //Check if right-recurred expression exists
            if(ctx.simpleexpression() != null){
                additiveOp = new ASTAdditiveOp(ctx.ADDITIVEOP().getText());
                rightTerm = visitSimpleexpression(ctx.simpleexpression());

                //Else right-term exists
            }else{
                additiveOp = new ASTAdditiveOp(ctx.ADDITIVEOP().getText());
                rightTerm = visitTerm(ctx.term(1));
            }

            return new ASTSimpleExpression(leftTerm, additiveOp, rightTerm);
        }

        return leftTerm;
    }

    @Override public ASTExpressionNode visitExpression(SmallLangParser.ExpressionContext ctx) {

//        ASTExpressionNode leftexpression = visitSimpleexpression(ctx.simpleexpression(0));
//
//        if(ctx.RELATIONALOP().size() != 0){
//
//            ASTRelationalOp relationalOp;
//            ASTExpressionNode rightExpression;
//
//            if(ctx.RELATIONALOP().size() > 1){
//
//                //Initialise with number of child expressions in list
//                int numOfExprs = ctx.simpleexpression().size();
//
//                //Initialise with list of all child expressions
//                List<SmallLangParser.SimpleexpressionContext> expressionList = ctx.simpleexpression();
//
//                //Variable to store the most recent ASTExpression equivalent for the iterative implementation
//                ASTExpression recurredExpression = null;
//
//                for(int i = ctx.RELATIONALOP().size()-1; i > 0; i--){
//
//                    if(recurredExpression == null){
//                        relationalOp = new ASTRelationalOp(ctx.RELATIONALOP(i).getText());
//
//                        ASTExpressionNode rightExpressionRight = visitSimpleexpression(expressionList.get(numOfExprs-1));
//                        numOfExprs--;
//
//                        ASTExpressionNode rightExpressionLeft = visitSimpleexpression(expressionList.get(numOfExprs-1));
//                        numOfExprs--;
//
//                        recurredExpression = new ASTExpression(rightExpressionLeft, relationalOp, rightExpressionRight);
//
//                    }else{
//                        relationalOp= new ASTRelationalOp(ctx.RELATIONALOP(i).getText());
//
//                        ASTExpressionNode rightExpressionLeft = visitSimpleexpression(expressionList.get(numOfExprs-1));
//                        numOfExprs--;
//
//                        recurredExpression = new ASTExpression(rightExpressionLeft, relationalOp, recurredExpression);
//                    }
//                }
//
//                relationalOp = new ASTRelationalOp(ctx.RELATIONALOP(0).getText());
//                rightExpression = recurredExpression;
//
//            }else{
//                relationalOp= new ASTRelationalOp(ctx.RELATIONALOP(0).getText());
//                rightExpression = visitSimpleexpression(ctx.simpleexpression(1));
//            }
//
//            return new ASTExpression(leftexpression, relationalOp, rightExpression);
//        }
//        return leftexpression;

        ASTExpressionNode leftexpression = visitSimpleexpression(ctx.simpleexpression(0));

        if(ctx.RELATIONALOP() != null){

            ASTRelationalOp relationalOp;
            ASTExpressionNode rightExpression;

                //Check if right-recurred expression exists
            if(ctx.expression() != null){
                relationalOp = new ASTRelationalOp(ctx.RELATIONALOP().getText());
                rightExpression = visitExpression(ctx.expression());

                //Else right-simple expression exists
            }else{
                relationalOp = new ASTRelationalOp(ctx.RELATIONALOP().getText());
                rightExpression = visitSimpleexpression(ctx.simpleexpression(1));
            }

            return new ASTExpression(leftexpression, relationalOp, rightExpression);
        }

        return leftexpression;
    }

    @Override public ASTAssignment visitAssignment(SmallLangParser.AssignmentContext ctx) {

        ASTIdentifier identifier = new ASTIdentifier(ctx.IDENTIFIER().getText());
        ASTExpressionNode expression = visitExpression(ctx.expression());

        return new ASTAssignment(identifier, expression);
    }

    @Override public ASTVariableDecl visitVariabledecl(SmallLangParser.VariabledeclContext ctx) {

        ASTIdentifier identifier = new ASTIdentifier(ctx.IDENTIFIER().getText());
        ASTType type = null;
        ASTExpressionNode expression = visitExpression(ctx.expression());

        //Assign type depending whether it is a normal type of an auto type
        if(ctx.TYPE() != null){
            type = new ASTType(ctx.TYPE().getText());
        }else if(ctx.AUTO() != null){
            type = new ASTType(ctx.AUTO().getText());
        }

        return new ASTVariableDecl(identifier, type, expression);
    }

    @Override public ASTPrintStatement visitPrintstatement(SmallLangParser.PrintstatementContext ctx) {
        ASTExpressionNode expression = visitExpression(ctx.expression());
        return new ASTPrintStatement(expression);
    }

    @Override public ASTReturnStatement visitRtrnstatement(SmallLangParser.RtrnstatementContext ctx) {
        ASTExpressionNode expression = visitExpression(ctx.expression());
        return new ASTReturnStatement(expression);
    }

    @Override public ASTIfStatement visitIfstatement(SmallLangParser.IfstatementContext ctx) {
        ASTExpressionNode expression = visitExpression(ctx.expression());
        ASTBlock ifBlock = visitBlock(ctx.block(0));
        ASTBlock elseBlock = new ASTBlock(new ArrayList<>());

        if(ctx.block().size() > 1){
            elseBlock = visitBlock(ctx.block(1));
        }

        return new ASTIfStatement(expression, ifBlock, elseBlock);
    }

    @Override public ASTForStatement visitForstatement(SmallLangParser.ForstatementContext ctx) {

        ASTVariableDecl variableDecl = null;
        ASTExpressionNode expression;
        ASTAssignment assignment = null;
        ASTBlock block;

        if(ctx.variabledecl() != null){
            variableDecl = visitVariabledecl(ctx.variabledecl());
        }

        expression = visitExpression(ctx.expression());

        if(ctx.assignment() != null){
            assignment = visitAssignment(ctx.assignment());
        }

        block = visitBlock(ctx.block());

        return new ASTForStatement(variableDecl, expression, assignment, block);
    }

    @Override public ASTWhileStatement visitWhilestatement(SmallLangParser.WhilestatementContext ctx) {

        ASTExpressionNode expression;
        ASTBlock block;

        expression = visitExpression(ctx.expression());
        block = visitBlock(ctx.block());

        return new ASTWhileStatement(expression, block);
    }

    @Override public ASTFormalParam visitFormalparam(SmallLangParser.FormalparamContext ctx) {

        ASTIdentifier identifier;
        ASTType type;

        identifier = new ASTIdentifier(ctx.IDENTIFIER().getText());
        type = new ASTType(ctx.TYPE().getText());

        return new ASTFormalParam(identifier, type);
    }

    @Override public ASTFormalParams visitFormalparams(SmallLangParser.FormalparamsContext ctx) {

        ArrayList<ASTFormalParam> formalParamsList = new ArrayList<>();

        //Check if formal parameters exist
        if(ctx != null){
            for(SmallLangParser.FormalparamContext formalParamContext : ctx.formalparam() ){
                formalParamsList.add(visitFormalparam(formalParamContext));
            }
        }

        return new ASTFormalParams(formalParamsList);
    }

    @Override public ASTFunctionDecl visitFunctiondecl(SmallLangParser.FunctiondeclContext ctx) {

        ASTIdentifier identifier;
        ASTFormalParams formalParams;
        ASTType type = null;
        ASTBlock block;

        identifier = new ASTIdentifier(ctx.IDENTIFIER().getText());
        formalParams = visitFormalparams(ctx.formalparams());

        //Assign type depending whether it is a normal type of an auto type
        if(ctx.TYPE() != null){
            type = new ASTType(ctx.TYPE().getText());
        }else if(ctx.AUTO() != null){
            type = new ASTType(ctx.AUTO().getText());
        }

        block = visitBlock(ctx.block());

        return new ASTFunctionDecl(identifier, formalParams, type, block);
    }

    @Override public ASTStatementNode visitStatement(SmallLangParser.StatementContext ctx) {

        if(ctx.variabledecl() != null){
            return visitVariabledecl(ctx.variabledecl());
        }else if(ctx.assignment() != null){
            return visitAssignment(ctx.assignment());
        }else if(ctx.printstatement() != null){
            return visitPrintstatement(ctx.printstatement());
        }else if(ctx.ifstatement() != null){
            return visitIfstatement(ctx.ifstatement());
        }else if(ctx.forstatement() != null){
            return visitForstatement(ctx.forstatement());
        }else if(ctx.whilestatement() != null){
            return visitWhilestatement(ctx.whilestatement());
        }else if(ctx.rtrnstatement() != null){
            return visitRtrnstatement(ctx.rtrnstatement());
        }else if(ctx.functiondecl() != null){
            return visitFunctiondecl(ctx.functiondecl());
        }else if(ctx.block() != null){
            return visitBlock(ctx.block());
        }else{
            return null;
        }
    }

    @Override public ASTBlock visitBlock(SmallLangParser.BlockContext ctx) {

        ArrayList<ASTStatementNode> blockStatements = new ArrayList<>();

        for(SmallLangParser.StatementContext statementContext : ctx.statement() ){
            blockStatements.add(visitStatement(statementContext));
        }

        return new ASTBlock(blockStatements);
    }

    @Override public ASTProgram visitProgram(SmallLangParser.ProgramContext ctx) {

        ArrayList<ASTStatementNode> statementNodes = new ArrayList<>();

        for(SmallLangParser.StatementContext statementContext : ctx.statement() ){
            statementNodes.add(visitStatement(statementContext));
        }

        return new ASTProgram(statementNodes);
    }

    public ASTNode visit(ParseTree parseTree) {
        return null;
    }

    public ASTNode visitChildren(RuleNode ruleNode) {
        return null;
    }

    public ASTNode visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    public ASTNode visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
