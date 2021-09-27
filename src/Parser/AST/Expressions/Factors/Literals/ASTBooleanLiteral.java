package Parser.AST.Expressions.Factors.Literals;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

public class ASTBooleanLiteral extends ASTExpressionNode {
    public boolean booleanLiteral;

    public ASTBooleanLiteral(boolean value){
        this.booleanLiteral = value;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
