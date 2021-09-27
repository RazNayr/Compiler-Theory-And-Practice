package Parser.AST;

import Visitors.Visitor;

import java.util.ArrayList;

//Class acting as the root node to the AST
public class ASTProgram implements ASTNode {

    //List storing all global ASTNode statements
    public ArrayList<ASTStatementNode> statementNodes;

    public ASTProgram(ArrayList<ASTStatementNode> _statementNodes){
        this.statementNodes = _statementNodes;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
