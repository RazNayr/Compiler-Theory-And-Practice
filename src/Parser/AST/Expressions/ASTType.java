package Parser.AST.Expressions;

import Parser.AST.ASTExpressionNode;
import Parser.EnumTypes.Type;
import Visitors.Visitor;

public class ASTType extends ASTExpressionNode {

    public Type type;

    public ASTType(String lexeme){

        if(lexeme.equals("float")){
            this.type = Type.FLOAT;
        }else if(lexeme.equals("int")){
            this.type = Type.INT;
        }else if(lexeme.equals("bool")){
            this.type = Type.BOOL;
        }else if(lexeme.equals("auto")){
            this.type = Type.AUTO;
        }else if(lexeme.equals("char")){
            this.type = Type.CHAR;
        }
    }

    public String showType(){
        if(type == Type.FLOAT){
            return "float";
        }else if(type == Type.INT){
            return "int";
        }else if(type == Type.BOOL){
            return "bool";
        }else if(type == Type.AUTO){
            return "auto";
        }else if(type == Type.CHAR){
            return "char";
        }else{
            return "";
        }
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
