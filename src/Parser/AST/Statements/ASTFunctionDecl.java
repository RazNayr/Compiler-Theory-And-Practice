package Parser.AST.Statements;

import Parser.AST.ASTStatementNode;
import Parser.AST.Expressions.ASTType;
import Parser.AST.Expressions.Factors.ASTIdentifier;
import Visitors.Visitor;

public class ASTFunctionDecl extends ASTStatementNode {
    public ASTIdentifier identifier;
    public ASTFormalParams formalParams;
    public ASTType type;
    public ASTBlock block;

    public ASTFunctionDecl(ASTIdentifier identifier, ASTFormalParams formalParams, ASTType type, ASTBlock block) {
        this.identifier = identifier;
        this.formalParams = formalParams;
        this.type = type;
        this.block = block;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
