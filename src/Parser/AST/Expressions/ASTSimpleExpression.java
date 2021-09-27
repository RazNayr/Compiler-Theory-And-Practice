package Parser.AST.Expressions;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

public class ASTSimpleExpression extends ASTExpressionNode {
    public ASTExpressionNode leftTerm;
    public ASTAdditiveOp additiveOp;
    public ASTExpressionNode rightTerm;

    public ASTSimpleExpression(ASTExpressionNode leftTerm, ASTAdditiveOp additiveOp, ASTExpressionNode rightTerm){
        this.leftTerm = leftTerm;
        this.additiveOp = additiveOp;
        this.rightTerm = rightTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
