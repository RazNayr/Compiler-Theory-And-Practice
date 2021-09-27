package Parser.AST.Expressions.Factors.Literals;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

public class ASTIntegerLiteral extends ASTExpressionNode {
    public int integerLiteral;

    public ASTIntegerLiteral(int value){
        this.integerLiteral = value;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
