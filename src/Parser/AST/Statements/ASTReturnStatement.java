package Parser.AST.Statements;

import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTStatementNode;
import Visitors.Visitor;

public class ASTReturnStatement extends ASTStatementNode {

    public ASTExpressionNode expression;

    public ASTReturnStatement(ASTExpressionNode expression) {
        this.expression = expression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
