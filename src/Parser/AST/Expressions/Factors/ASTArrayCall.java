package Parser.AST.Expressions.Factors;

import Parser.AST.ASTExpressionNode;
import Parser.AST.Expressions.Factors.Literals.ASTIntegerLiteral;
import Visitors.Visitor;

public class ASTArrayCall extends ASTExpressionNode {

    ASTIdentifier identifier;
    ASTIntegerLiteral arrayIndex;

    public ASTArrayCall(ASTIdentifier identifier, ASTIntegerLiteral arrayIndex) {
        this.identifier = identifier;
        this.arrayIndex = arrayIndex;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
