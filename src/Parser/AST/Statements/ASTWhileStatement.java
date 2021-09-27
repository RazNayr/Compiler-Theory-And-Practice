package Parser.AST.Statements;

import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTStatementNode;
import Visitors.Visitor;

public class ASTWhileStatement extends ASTStatementNode {

    public ASTExpressionNode expression;
    public ASTBlock block;

    public ASTWhileStatement(ASTExpressionNode expression, ASTBlock block) {
        this.expression = expression;
        this.block = block;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
