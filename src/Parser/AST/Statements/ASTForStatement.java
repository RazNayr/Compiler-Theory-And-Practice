package Parser.AST.Statements;

import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTStatementNode;
import Visitors.Visitor;

public class ASTForStatement extends ASTStatementNode {

    public ASTVariableDecl variableDecl;
    public ASTExpressionNode expression;
    public ASTAssignment assignment;
    public ASTBlock block;

    public ASTForStatement(ASTVariableDecl variableDecl, ASTExpressionNode expression, ASTAssignment assignment, ASTBlock block) {
        this.variableDecl = variableDecl;
        this.expression = expression;
        this.assignment = assignment;
        this.block = block;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
