package Parser.AST.Expressions.Factors;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

public class ASTFunctionCall extends ASTExpressionNode {
    public ASTIdentifier identifier;
    public ASTActualParams actualParams;

    public ASTFunctionCall(ASTIdentifier identifier, ASTActualParams actualParams){
        this.identifier = identifier;
        this.actualParams = actualParams;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
