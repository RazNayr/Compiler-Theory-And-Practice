package Visitors;

import Parser.AST.ASTProgram;
import Parser.AST.Expressions.*;
import Parser.AST.Expressions.Factors.*;
import Parser.AST.Expressions.Factors.Literals.ASTBooleanLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTCharLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTFloatLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTIntegerLiteral;
import Parser.AST.Statements.*;

public interface Visitor {

    //Expressions
    void visit(ASTType astNode);
    void visit(ASTBooleanLiteral astNode);
    void visit(ASTIntegerLiteral astNode);
    void visit(ASTFloatLiteral astNode);
    void visit(ASTIdentifier astNode);
    void visit(ASTMultiplicativeOp astNode);
    void visit(ASTAdditiveOp astNode);
    void visit(ASTRelationalOp astNode);
    void visit(ASTActualParams astNode);
    void visit(ASTFunctionCall astNode);
    void visit(ASTSubExpression astNode);
    void visit(ASTUnary astNode);
    void visit(ASTUnaryOp astNode);
    void visit(ASTTerm astNode);
    void visit(ASTSimpleExpression astNode);
    void visit(ASTExpression astNode);

    //Statements
    void visit(ASTVariableDecl astNode);
    void visit(ASTAssignment astNode);
    void visit(ASTPrintStatement astNode);
    void visit(ASTIfStatement astNode);
    void visit(ASTForStatement astNode);
    void visit(ASTWhileStatement astNode);
    void visit(ASTReturnStatement astNode);
    void visit(ASTFunctionDecl astNode);
    void visit(ASTBlock astNode);
    void visit(ASTFormalParam astNode);
    void visit(ASTFormalParams astNode);

    //Program Root Node
    void visit(ASTProgram astNode);

    //SmallLangV2 Nodes
    //Char node
    void visit(ASTCharLiteral astNode);
    //Array nodes
    void visit(ASTArrayAssignment astNode);
    void visit(ASTArrayDecl astNode);
    void visit(ASTArrayElements astNode);
    void visit(ASTArrayCall astNode);

}
