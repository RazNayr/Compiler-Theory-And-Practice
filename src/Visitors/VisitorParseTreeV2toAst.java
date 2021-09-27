package Visitors;

import ANTLRV2.SmallLangV2Parser;
import ANTLRV2.SmallLangV2Visitor;
import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTNode;
import Parser.AST.ASTProgram;
import Parser.AST.ASTStatementNode;
import Parser.AST.Expressions.*;
import Parser.AST.Expressions.Factors.*;
import Parser.AST.Expressions.Factors.Literals.ASTBooleanLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTCharLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTFloatLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTIntegerLiteral;
import Parser.AST.Statements.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class VisitorParseTreeV2toAst implements SmallLangV2Visitor<ASTNode> {

    @Override public ASTExpressionNode visitLiteral(SmallLangV2Parser.LiteralContext ctx) {

        if(ctx.BOOLEANLITERAL() != null){
            boolean value = Boolean.parseBoolean(ctx.BOOLEANLITERAL().getText());
            return new ASTBooleanLiteral(value);
        }else if(ctx.INTEGERLITERAL() != null){
            int value = Integer.parseInt(ctx.INTEGERLITERAL().getText());
            return new ASTIntegerLiteral(value);
        }else if(ctx.FLOATLITERAL() != null){
            float value = Float.parseFloat(ctx.FLOATLITERAL().getText());
            return new ASTFloatLiteral(value);
        }else if(ctx.CHARLITERAL() != null){
            String lexemeWithoutSingleQuotes = ctx.CHARLITERAL().getText().replaceAll("'","");
            char value = lexemeWithoutSingleQuotes.charAt(0);
            return new ASTCharLiteral(value);
        }else{
            return null;
        }
    }

    @Override public ASTActualParams visitActualparams(SmallLangV2Parser.ActualparamsContext ctx) {

        ArrayList<ASTExpressionNode> actualParameters = new ArrayList<>();

        //Check if actual parameters exist
        if(ctx != null){
            for(SmallLangV2Parser.ExpressionContext actualParamContext : ctx.expression() ){
                actualParameters.add(visitExpression(actualParamContext));
            }
        }

        return new ASTActualParams(actualParameters);
    }

    @Override public ASTFunctionCall visitFunctioncall(SmallLangV2Parser.FunctioncallContext ctx) {

        ASTIdentifier identifier = new ASTIdentifier(ctx.IDENTIFIER().getText());
        ASTActualParams actualParams = visitActualparams(ctx.actualparams());

        return new ASTFunctionCall(identifier, actualParams);

    }

    @Override public ASTSubExpression visitSubexpression(SmallLangV2Parser.SubexpressionContext ctx) {

        ASTExpressionNode expression = visitExpression(ctx.expression());
        return new ASTSubExpression(expression);
    }

    @Override public ASTUnary visitUnary(SmallLangV2Parser.UnaryContext ctx) {

        ASTUnaryOp unaryOp = new ASTUnaryOp(ctx.UNARYOP().getText());
        ASTExpressionNode expression = visitExpression(ctx.expression());

        return new ASTUnary(unaryOp, expression);
    }

    @Override
    public ASTArrayCall visitArraycall(SmallLangV2Parser.ArraycallContext ctx) {
        ASTIdentifier identifier = new ASTIdentifier(ctx.IDENTIFIER().getText());

        int value = Integer.parseInt(ctx.INTEGERLITERAL().getText());
        ASTIntegerLiteral arrayIndex = new ASTIntegerLiteral(value);

        return new ASTArrayCall(identifier, arrayIndex);
    }

    @Override public ASTExpressionNode visitFactor(SmallLangV2Parser.FactorContext ctx) {

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
        }else if(ctx.arraycall() != null){
            return visitArraycall(ctx.arraycall());
        }else{
            return null;
        }
    }

    @Override public ASTExpressionNode visitTerm(SmallLangV2Parser.TermContext ctx) {

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

    @Override public ASTExpressionNode visitSimpleexpression(SmallLangV2Parser.SimpleexpressionContext ctx) {

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

    @Override public ASTExpressionNode visitExpression(SmallLangV2Parser.ExpressionContext ctx) {

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

    @Override public ASTAssignment visitAssignment(SmallLangV2Parser.AssignmentContext ctx) {

        ASTIdentifier identifier = new ASTIdentifier(ctx.IDENTIFIER().getText());
        ASTExpressionNode expression = visitExpression(ctx.expression());

        return new ASTAssignment(identifier, expression);
    }

    @Override public ASTVariableDecl visitVariabledecl(SmallLangV2Parser.VariabledeclContext ctx) {

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

    @Override public ASTPrintStatement visitPrintstatement(SmallLangV2Parser.PrintstatementContext ctx) {
        ASTExpressionNode expression = visitExpression(ctx.expression());
        return new ASTPrintStatement(expression);
    }

    @Override public ASTReturnStatement visitRtrnstatement(SmallLangV2Parser.RtrnstatementContext ctx) {
        ASTExpressionNode expression = visitExpression(ctx.expression());
        return new ASTReturnStatement(expression);
    }

    @Override public ASTIfStatement visitIfstatement(SmallLangV2Parser.IfstatementContext ctx) {
        ASTExpressionNode expression = visitExpression(ctx.expression());
        ASTBlock ifBlock = visitBlock(ctx.block(0));
        ASTBlock elseBlock = new ASTBlock(new ArrayList<>());

        if(ctx.block().size() > 1){
            elseBlock = visitBlock(ctx.block(1));
        }

        return new ASTIfStatement(expression, ifBlock, elseBlock);
    }

    @Override public ASTForStatement visitForstatement(SmallLangV2Parser.ForstatementContext ctx) {

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

    @Override public ASTWhileStatement visitWhilestatement(SmallLangV2Parser.WhilestatementContext ctx) {

        ASTExpressionNode expression;
        ASTBlock block;

        expression = visitExpression(ctx.expression());
        block = visitBlock(ctx.block());

        return new ASTWhileStatement(expression, block);
    }

    @Override public ASTFormalParam visitFormalparam(SmallLangV2Parser.FormalparamContext ctx) {

        ASTIdentifier identifier;
        ASTType type;

        identifier = new ASTIdentifier(ctx.IDENTIFIER().getText());
        type = new ASTType(ctx.TYPE().getText());

        return new ASTFormalParam(identifier, type);
    }

    @Override public ASTFormalParams visitFormalparams(SmallLangV2Parser.FormalparamsContext ctx) {

        ArrayList<ASTFormalParam> formalParamsList = new ArrayList<>();

        //Check if formal parameters exist
        if(ctx != null){
            for(SmallLangV2Parser.FormalparamContext formalParamContext : ctx.formalparam() ){
                formalParamsList.add(visitFormalparam(formalParamContext));
            }
        }

        return new ASTFormalParams(formalParamsList);
    }

    @Override public ASTFunctionDecl visitFunctiondecl(SmallLangV2Parser.FunctiondeclContext ctx) {

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

    @Override
    public ASTArrayDecl visitArraydecl(SmallLangV2Parser.ArraydeclContext ctx) {

        ASTIdentifier identifier = new ASTIdentifier(ctx.IDENTIFIER().getText());
        ASTIntegerLiteral arraySize = null;
        ASTType type = null;
        ASTArrayElements arrayElements;

        if(ctx.INTEGERLITERAL() != null){
            int value = Integer.parseInt(ctx.INTEGERLITERAL().getText());
            arraySize = new ASTIntegerLiteral(value);
        }

        //Assign type depending whether it is a normal type of an auto type
        if(ctx.TYPE() != null){
            type = new ASTType(ctx.TYPE().getText());
        }else if(ctx.AUTO() != null){
            type = new ASTType(ctx.AUTO().getText());
        }

        arrayElements = visitArrayelements(ctx.arrayelements());

        if(arraySize == null){
            arraySize = new ASTIntegerLiteral(arrayElements.actualElements.size());
        }

        return new ASTArrayDecl(identifier, arraySize, type, arrayElements);
    }

    @Override
    public ASTArrayElements visitArrayelements(SmallLangV2Parser.ArrayelementsContext ctx) {

        ArrayList<ASTExpressionNode> actualElements = new ArrayList<>();

        //Check if actual array elements exist
        if(ctx != null){
            for(SmallLangV2Parser.ExpressionContext actualArrayElementContext : ctx.expression() ){
                actualElements.add(visitExpression(actualArrayElementContext));
            }
        }

        return new ASTArrayElements(actualElements);
    }

    @Override
    public ASTArrayAssignment visitArrayassignment(SmallLangV2Parser.ArrayassignmentContext ctx) {

        ASTIdentifier identifier = new ASTIdentifier(ctx.IDENTIFIER().getText());

        int value = Integer.parseInt(ctx.INTEGERLITERAL().getText());
        ASTIntegerLiteral arrayIndex = new ASTIntegerLiteral(value);

        ASTExpressionNode expression = visitExpression(ctx.expression());

        return new ASTArrayAssignment(identifier, arrayIndex, expression);
    }

    @Override public ASTStatementNode visitStatement(SmallLangV2Parser.StatementContext ctx) {

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
        }else if(ctx.arraydecl() != null){
            return visitArraydecl(ctx.arraydecl());
        }else if(ctx.arrayassignment() != null){
            return visitArrayassignment(ctx.arrayassignment());
        }else{
            return null;
        }
    }

    @Override public ASTBlock visitBlock(SmallLangV2Parser.BlockContext ctx) {

        ArrayList<ASTStatementNode> blockStatements = new ArrayList<>();

        for(SmallLangV2Parser.StatementContext statementContext : ctx.statement() ){
            blockStatements.add(visitStatement(statementContext));
        }

        return new ASTBlock(blockStatements);
    }

    @Override public ASTProgram visitProgram(SmallLangV2Parser.ProgramContext ctx) {

        ArrayList<ASTStatementNode> statementNodes = new ArrayList<>();

        for(SmallLangV2Parser.StatementContext statementContext : ctx.statement() ){
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
