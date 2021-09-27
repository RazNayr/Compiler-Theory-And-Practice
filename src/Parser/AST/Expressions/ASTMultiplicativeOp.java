package Parser.AST.Expressions;

import Parser.AST.ASTExpressionNode;
import Parser.EnumTypes.MultiplicativeType;
import Visitors.Visitor;

public class ASTMultiplicativeOp extends ASTExpressionNode {

    public MultiplicativeType multiplicativeType;

    public ASTMultiplicativeOp(String lexeme){

        if(lexeme.equals("*")){
            this.multiplicativeType = MultiplicativeType.MULTIPLICATION;
        }else if(lexeme.equals("/")){
            this.multiplicativeType = MultiplicativeType.DIVISION;
        }else if(lexeme.equals("and")){
            this.multiplicativeType = MultiplicativeType.AND;
        }
    }

    public String showType(){
        if(multiplicativeType == MultiplicativeType.MULTIPLICATION){
            return "*";
        }else if(multiplicativeType == MultiplicativeType.DIVISION){
            return "/";
        }else if(multiplicativeType == MultiplicativeType.AND){
            return "and";
        }else{
            return "";
        }
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
