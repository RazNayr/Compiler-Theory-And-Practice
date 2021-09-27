package Parser.AST.Statements;

import Parser.AST.ASTStatementNode;
import Parser.AST.Expressions.ASTType;
import Parser.AST.Expressions.Factors.ASTIdentifier;
import Visitors.Visitor;

public class ASTFormalParam extends ASTStatementNode {

    public ASTIdentifier identifier;
    public ASTType type;

    public ASTFormalParam(ASTIdentifier identifier, ASTType type) {
        this.identifier = identifier;
        this.type = type;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
