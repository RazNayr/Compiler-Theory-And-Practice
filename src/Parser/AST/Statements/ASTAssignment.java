package Parser.AST.Statements;

import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTStatementNode;
import Parser.AST.Expressions.Factors.ASTIdentifier;
import Visitors.Visitor;

public class ASTAssignment extends ASTStatementNode {
    public ASTIdentifier identifier;
    public ASTExpressionNode expression;

    public ASTAssignment (ASTIdentifier identifier, ASTExpressionNode expression){
        this.identifier = identifier;
        this.expression = expression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
