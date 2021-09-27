package Visitors;

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

public class VisitorAstToXml implements Visitor {

    //Used to store the indentation to be displayed before an XML output
    StringBuilder indentation = new StringBuilder();

    //Used to add a tabulation to the indentation StringBuilder
    private void indent(){
        indentation.append("\t");
    }

    //Used to remove a tabulation from the indentation StringBuilder
    private void outdent(){
        indentation.deleteCharAt(indentation.length()-1);
    }

    //Function to display the spacing denoted by the indentation StringBuilder
    private String tab(){
        return indentation.toString();
    }

    //Entry function to traverse the AST
    public void visitAST(ASTProgram astRootNode){
        System.out.println("\nAST XML Generation Pass:");
        astRootNode.accept(this);
    }

    public void visit(ASTProgram astNode) {

        System.out.println("<Program>");
        indent();

        for (ASTNode statementNode : astNode.statementNodes) {
            statementNode.accept(this);
        }

        outdent();
        System.out.println("</Program>");
    }

    public void visit(ASTCharLiteral astNode) {

    }

    public void visit(ASTArrayAssignment astNode) {

    }

    public void visit(ASTArrayDecl astNode) {

    }

    public void visit(ASTArrayElements astNode) {

    }

    public void visit(ASTArrayCall astNode) {

    }

    public void visit(ASTType astNode) {
        System.out.print(tab()+"<Type>");
        System.out.print(astNode.showType());
        System.out.println("</Type>");
    }

    public void visit(ASTBooleanLiteral astNode) {
        System.out.print(tab()+"<BooleanLiteral>");
        System.out.print(astNode.booleanLiteral);
        System.out.println("</BooleanLiteral>");
    }

    public void visit(ASTIntegerLiteral astNode) {
        System.out.print(tab()+"<IntegerLiteral>");
        System.out.print(astNode.integerLiteral);
        System.out.println("</IntegerLiteral>");
    }

    public void visit(ASTFloatLiteral astNode) {
        System.out.print(tab()+"<FloatLiteral>");
        System.out.print(astNode.floatLiteral);
        System.out.println("</FloatLiteral>");
    }

    public void visit(ASTIdentifier astNode) {
        System.out.print(tab()+"<Identifier>");
        System.out.print(astNode.identifier);
        System.out.println("</Identifier>");
    }

    public void visit(ASTMultiplicativeOp astNode) {
        System.out.print(tab()+"<MultiplicativeOp>'");
        System.out.print(astNode.showType());
        System.out.println("'</MultiplicativeOp>");
    }

    public void visit(ASTAdditiveOp astNode) {
        System.out.print(tab()+"<AdditiveOp>'");
        System.out.print(astNode.showType());
        System.out.println("'</AdditiveOp>");
    }

    public void visit(ASTRelationalOp astNode) {
        System.out.print(tab()+"<RelationalOp>'");
        System.out.print(astNode.showType());
        System.out.println("'</RelationalOp>");
    }

    public void visit(ASTActualParams astNode) {
        System.out.println(tab()+"<ActualParams>");
        indent();

        for (ASTNode actualParam : astNode.actualParameters) {
            actualParam.accept(this);
        }

        outdent();
        System.out.println(tab()+"</ActualParams>");
    }

    public void visit(ASTFunctionCall astNode) {
        System.out.println(tab()+"<FunctionCall>");
        indent();

        astNode.identifier.accept(this);
        astNode.actualParams.accept(this);

        outdent();
        System.out.println(tab()+"</FunctionCall>");
    }

    public void visit(ASTSubExpression astNode) {
        System.out.println(tab()+"<SubExpression>");
        indent();

        astNode.expression.accept(this);

        outdent();
        System.out.println(tab()+"</SubExpression>");
    }

    public void visit(ASTUnary astNode) {
        System.out.println(tab()+"<Unary>");
        indent();

        astNode.unaryOp.accept(this);
        astNode.expression.accept(this);

        outdent();
        System.out.println(tab()+"</Unary>");
    }

    public void visit(ASTUnaryOp astNode) {
        System.out.print(tab()+"<UnaryOp>'");
        System.out.print(astNode.showType());
        System.out.println("'</UnaryOp>");
    }

    public void visit(ASTTerm astNode) {
        System.out.println(tab()+"<Term>");
        indent();

        astNode.multiplicativeOp.accept(this);
        astNode.leftFactor.accept(this);
        astNode.rightFactor.accept(this);

        outdent();
        System.out.println(tab()+"</Term>");
    }

    public void visit(ASTSimpleExpression astNode) {
        System.out.println(tab()+"<SimpleExpression>");
        indent();

        astNode.additiveOp.accept(this);
        astNode.leftTerm.accept(this);
        astNode.rightTerm.accept(this);

        outdent();
        System.out.println(tab()+"</SimpleExpression>");
    }

    public void visit(ASTExpression astNode) {
        System.out.println(tab()+"<Expression>");
        indent();

        astNode.relationalOp.accept(this);
        astNode.leftSimpleExpression.accept(this);
        astNode.rightSimpleExpression.accept(this);

        outdent();
        System.out.println(tab()+"</Expression>");
    }

    public void visit(ASTVariableDecl astNode) {

        System.out.println(tab()+"<VariableDecl>");
        indent();

        astNode.type.accept(this);
        astNode.identifier.accept(this);
        astNode.expression.accept(this);

        outdent();
        System.out.println(tab()+"</VariableDecl>");

    }

    public void visit(ASTAssignment astNode) {

        System.out.println(tab()+"<Assignment>");
        indent();

        astNode.identifier.accept(this);
        astNode.expression.accept(this);

        outdent();
        System.out.println(tab()+"</Assignment>");

    }

    public void visit(ASTPrintStatement astNode) {

        System.out.println(tab()+"<PrintStatement>");
        indent();

        astNode.expression.accept(this);

        outdent();
        System.out.println(tab()+"</PrintStatement>");
    }

    public void visit(ASTIfStatement astNode) {
        System.out.println(tab()+"<IfStatement>");
        indent();

        astNode.expression.accept(this);
        astNode.ifBlock.accept(this);

        if(!astNode.elseBlock.statements.isEmpty()){
            astNode.elseBlock.accept(this);
        }

        outdent();
        System.out.println(tab()+"</IfStatement>");
    }

    public void visit(ASTForStatement astNode) {

        System.out.println(tab()+"<ForStatement>");
        indent();

        if(astNode.variableDecl != null){
            astNode.variableDecl.accept(this);
        }else{
            System.out.print(tab()+"<VariableDecl>");
            System.out.print("null");
            System.out.println("</VariableDecl>");
        }

        astNode.expression.accept(this);

        if(astNode.assignment != null){
            astNode.assignment.accept(this);
        }else{
            System.out.print(tab()+"<Assignment>");
            System.out.print("null");
            System.out.println("</Assignment>");
        }

        astNode.block.accept(this);

        outdent();
        System.out.println(tab()+"</ForStatement>");

    }

    public void visit(ASTWhileStatement astNode) {
        System.out.println(tab()+"<WhileStatement>");
        indent();

        astNode.expression.accept(this);
        astNode.block.accept(this);

        outdent();
        System.out.println(tab()+"</WhileStatement>");
    }

    public void visit(ASTReturnStatement astNode) {
        System.out.println(tab()+"<ReturnStatement>");
        indent();

        astNode.expression.accept(this);

        outdent();
        System.out.println(tab()+"</ReturnStatement>");
    }

    public void visit(ASTFunctionDecl astNode) {
        System.out.println(tab()+"<FunctionDecl>");
        indent();

        astNode.type.accept(this);
        astNode.identifier.accept(this);
        astNode.formalParams.accept(this);
        astNode.block.accept(this);

        outdent();
        System.out.println(tab()+"</FunctionDecl>");
    }

    public void visit(ASTBlock astNode) {
        System.out.println(tab()+"<Block>");
        indent();

        for (ASTStatementNode statementNode: astNode.statements) {
            statementNode.accept(this);
        }

        outdent();
        System.out.println(tab()+"</Block>");
    }

    public void visit(ASTFormalParam astNode) {
        System.out.println(tab()+"<FormalParam>");
        indent();

        astNode.identifier.accept(this);
        astNode.type.accept(this);

        outdent();
        System.out.println(tab()+"</FormalParam>");
    }

    public void visit(ASTFormalParams astNode) {
        System.out.println(tab()+"<FormalParams>");
        indent();

        for (ASTFormalParam formalParam: astNode.formalParams) {
            formalParam.accept(this);
        }

        outdent();
        System.out.println(tab()+"</FormalParams>");
    }
}
