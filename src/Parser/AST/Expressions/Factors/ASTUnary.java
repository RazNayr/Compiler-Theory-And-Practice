package Parser.AST.Expressions.Factors;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

public class ASTUnary extends ASTExpressionNode {
    public ASTUnaryOp unaryOp;
    public ASTExpressionNode expression;

    public ASTUnary(ASTUnaryOp unaryOp, ASTExpressionNode expression){
        this.unaryOp = unaryOp;
        this.expression = expression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
