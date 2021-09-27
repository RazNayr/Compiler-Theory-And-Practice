package Parser.AST.Statements;

import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTStatementNode;
import Visitors.Visitor;

public class ASTPrintStatement extends ASTStatementNode {
    public ASTExpressionNode expression;

    public ASTPrintStatement(ASTExpressionNode expression){
        this.expression = expression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
