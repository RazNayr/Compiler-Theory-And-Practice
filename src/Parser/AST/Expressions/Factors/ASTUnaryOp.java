package Parser.AST.Expressions.Factors;

import Parser.AST.ASTExpressionNode;
import Parser.EnumTypes.UnaryType;
import Visitors.Visitor;

public class ASTUnaryOp extends ASTExpressionNode {
    public UnaryType unaryType;

    public ASTUnaryOp(String lexeme){

        if(lexeme.equals("-")){
            this.unaryType = UnaryType.MINUS;
        }else if(lexeme.equals("not")){
            this.unaryType = UnaryType.NOT;
        }
    }

    public String showType(){
        if(unaryType ==  UnaryType.MINUS){
            return "-";
        }else if(unaryType == UnaryType.NOT){
            return "not";
        }else{
            return "";
        }
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
