package Parser.AST.Statements;

import Parser.AST.ASTStatementNode;
import Visitors.Visitor;

import java.util.ArrayList;

public class ASTFormalParams extends ASTStatementNode {
    public ArrayList<ASTFormalParam> formalParams;

    public ASTFormalParams(ArrayList<ASTFormalParam> formalParams) {
        this.formalParams = formalParams;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
