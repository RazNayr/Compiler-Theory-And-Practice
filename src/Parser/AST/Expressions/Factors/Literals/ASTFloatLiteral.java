package Parser.AST.Expressions.Factors.Literals;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

public class ASTFloatLiteral extends ASTExpressionNode {
    public float floatLiteral;

    public ASTFloatLiteral(float value){
        this.floatLiteral = value;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
