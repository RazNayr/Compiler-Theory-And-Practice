package Parser.AST.Expressions.Factors;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

public class ASTSubExpression extends ASTExpressionNode {
    public ASTExpressionNode expression;

    public ASTSubExpression(ASTExpressionNode expression){
        this.expression = expression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
