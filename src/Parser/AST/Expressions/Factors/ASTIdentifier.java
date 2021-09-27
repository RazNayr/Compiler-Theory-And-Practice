package Parser.AST.Expressions.Factors;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

public class ASTIdentifier extends ASTExpressionNode {

    public String identifier;

    public ASTIdentifier(String lexeme){
        this.identifier = lexeme;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
