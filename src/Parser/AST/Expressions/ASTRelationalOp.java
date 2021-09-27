package Parser.AST.Expressions;

import Parser.AST.ASTExpressionNode;
import Parser.EnumTypes.RelationalType;
import Visitors.Visitor;

public class ASTRelationalOp extends ASTExpressionNode {

    public  RelationalType relationalType;

    public ASTRelationalOp(String lexeme){

        if(lexeme.equals("<")){
            this.relationalType = RelationalType.SMALLER_THAN;
        }else if(lexeme.equals(">")){
            this.relationalType = RelationalType.GREATER_THAN;
        }else if(lexeme.equals("==")){
            this.relationalType = RelationalType.EQUAL_TO;
        }else if(lexeme.equals("<>")){
            this.relationalType = RelationalType.NOT_EQUAL_TO;
        }else if(lexeme.equals("<=")){
            this.relationalType = RelationalType.SMALLER_THAN_OR_EQUAL_TO;
        }else if(lexeme.equals(">=")){
            this.relationalType = RelationalType.GREATER_THAN_OR_EQUAL_TO;
        }

    }

    public String showType(){
        if(relationalType == RelationalType.SMALLER_THAN){
            return "<";
        }else if(relationalType == RelationalType.GREATER_THAN){
            return ">";
        }else if(relationalType == RelationalType.EQUAL_TO){
            return "==";
        }else if(relationalType == RelationalType.NOT_EQUAL_TO){
            return "<>";
        }else if(relationalType == RelationalType.SMALLER_THAN_OR_EQUAL_TO){
            return "<=";
        }else if(relationalType == RelationalType.GREATER_THAN_OR_EQUAL_TO){
            return ">=";
        }else{
            return "";
        }
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
