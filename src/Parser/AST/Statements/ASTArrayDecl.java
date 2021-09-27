package Parser.AST.Statements;

import Parser.AST.ASTStatementNode;
import Parser.AST.Expressions.ASTArrayElements;
import Parser.AST.Expressions.ASTType;
import Parser.AST.Expressions.Factors.ASTIdentifier;
import Parser.AST.Expressions.Factors.Literals.ASTIntegerLiteral;
import Visitors.Visitor;

public class ASTArrayDecl extends ASTStatementNode {
    public ASTIdentifier identifier;
    public ASTIntegerLiteral arraySize;
    public ASTType type;
    public ASTArrayElements arrayElements;

    public ASTArrayDecl(ASTIdentifier identifier, ASTIntegerLiteral integerLiteral, ASTType type, ASTArrayElements arrayElements) {
        this.identifier = identifier;
        this.arraySize = integerLiteral;
        this.type = type;
        this.arrayElements = arrayElements;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
