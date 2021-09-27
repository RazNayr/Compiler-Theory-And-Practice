package Parser.AST.Statements;

import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTStatementNode;
import Parser.AST.Expressions.ASTType;
import Parser.AST.Expressions.Factors.ASTIdentifier;
import Visitors.Visitor;

public class ASTVariableDecl extends ASTStatementNode {
    public ASTIdentifier identifier;
    public ASTType type;
    public ASTExpressionNode expression;

    public ASTVariableDecl(ASTIdentifier identifier, ASTType type, ASTExpressionNode expression){
        this.identifier= identifier;
        this.type = type;
        this.expression = expression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
