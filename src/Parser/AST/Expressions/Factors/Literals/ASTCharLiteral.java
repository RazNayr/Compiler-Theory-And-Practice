package Parser.AST.Expressions.Factors.Literals;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

public class ASTCharLiteral extends ASTExpressionNode {
    public char charLiteral;

    public ASTCharLiteral(char charLiteral) {
        this.charLiteral = charLiteral;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
