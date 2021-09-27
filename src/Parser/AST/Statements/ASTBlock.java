package Parser.AST.Statements;

import Parser.AST.ASTStatementNode;
import Visitors.Visitor;

import java.util.ArrayList;

public class ASTBlock extends ASTStatementNode{
    public ArrayList<ASTStatementNode> statements;

    public ASTBlock(ArrayList<ASTStatementNode> statements) {
        this.statements = statements;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
