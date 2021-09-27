package Parser.AST.Expressions;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

public class ASTExpression extends ASTExpressionNode {

    public ASTExpressionNode leftSimpleExpression;
    public ASTRelationalOp relationalOp;
    public ASTExpressionNode rightSimpleExpression;

    public ASTExpression(ASTExpressionNode leftSimpleExpression, ASTRelationalOp relationalOp, ASTExpressionNode rightSimpleExpression){
        this.leftSimpleExpression = leftSimpleExpression;
        this.relationalOp = relationalOp;
        this.rightSimpleExpression = rightSimpleExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
