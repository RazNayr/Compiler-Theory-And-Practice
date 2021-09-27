package Parser.AST.Expressions.Factors;

import Parser.AST.ASTExpressionNode;
import Visitors.Visitor;

import java.util.ArrayList;

public class ASTActualParams extends ASTExpressionNode {

    public ArrayList<ASTExpressionNode> actualParameters;

    public ASTActualParams(ArrayList<ASTExpressionNode> actualParameters){
        this.actualParameters = actualParameters;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
