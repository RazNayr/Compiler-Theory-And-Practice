package Parser.AST;

import Visitors.Visitor;

public interface ASTNode {
    //accept function to be used by visitors
    void accept(Visitor visitor);
}
