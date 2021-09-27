package Parser.AST.Expressions;

import Parser.AST.ASTExpressionNode;
import Parser.EnumTypes.AdditiveType;
import Visitors.Visitor;

public class ASTAdditiveOp extends ASTExpressionNode {

    public AdditiveType additiveType;

    public ASTAdditiveOp(String lexeme){

        if(lexeme.equals("+")){
            this.additiveType = AdditiveType.PLUS;
        }else if(lexeme.equals("-")){
            this.additiveType = AdditiveType.MINUS;
        }else if(lexeme.equals("or")){
            this.additiveType = AdditiveType.OR;
        }
    }

    public String showType(){
        if(additiveType == AdditiveType.PLUS){
            return "+";
        }else if(additiveType == AdditiveType.MINUS){
            return "-";
        }else if(additiveType == AdditiveType.OR){
            return "or";
        }else{
            return "";
        }
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
