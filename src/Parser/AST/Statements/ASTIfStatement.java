package Parser.AST.Statements;

import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTStatementNode;
import Visitors.Visitor;

public class ASTIfStatement extends ASTStatementNode {

    public ASTExpressionNode expression;
    public ASTBlock ifBlock;
    public ASTBlock elseBlock;

    public ASTIfStatement(ASTExpressionNode expression, ASTBlock ifBlock, ASTBlock elseBlock) {
        this.expression = expression;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
