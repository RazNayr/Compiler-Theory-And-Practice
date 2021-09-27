package Parser.AST.Expressions;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

import java.util.ArrayList;

public class ASTArrayElements extends ASTExpressionNode {

    public ArrayList<ASTExpressionNode> actualElements;

    public ASTArrayElements(ArrayList<ASTExpressionNode> actualElements) {
        this.actualElements = actualElements;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
