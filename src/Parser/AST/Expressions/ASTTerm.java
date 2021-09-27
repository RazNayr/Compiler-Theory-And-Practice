package Parser.AST.Expressions;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

public class ASTTerm extends ASTExpressionNode {
    public ASTExpressionNode leftFactor;
    public ASTMultiplicativeOp multiplicativeOp;
    public ASTExpressionNode rightFactor;

    public ASTTerm(ASTExpressionNode leftFactor, ASTMultiplicativeOp multiplicativeOp, ASTExpressionNode rightFactor){
        this.leftFactor = leftFactor;
        this.multiplicativeOp = multiplicativeOp;
        this.rightFactor = rightFactor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
