package Parser.AST.Statements;

import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTStatementNode;
import Parser.AST.Expressions.Factors.ASTIdentifier;
import Parser.AST.Expressions.Factors.Literals.ASTIntegerLiteral;
import Visitors.Visitor;

public class ASTArrayAssignment extends ASTStatementNode {

    ASTIdentifier identifier;
    ASTIntegerLiteral arrayIndex;
    ASTExpressionNode expression;

    public ASTArrayAssignment(ASTIdentifier identifier, ASTIntegerLiteral arrayIndex, ASTExpressionNode expression) {
        this.identifier = identifier;
        this.arrayIndex = arrayIndex;
        this.expression = expression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
