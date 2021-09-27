package Visitors;

import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTNode;
import Parser.AST.ASTProgram;
import Parser.AST.ASTStatementNode;
import Parser.AST.Expressions.Factors.Literals.ASTCharLiteral;
import Parser.EnumTypes.*;
import Parser.AST.Expressions.*;
import Parser.AST.Expressions.Factors.*;
import Parser.AST.Expressions.Factors.Literals.ASTBooleanLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTFloatLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTIntegerLiteral;
import Parser.AST.Statements.*;
import SymbolTable.SymbolDetails;
import SymbolTable.SymbolTable;
import SymbolTable.SymbolType;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.exit;

public class VisitorSemanticAnalysis implements Visitor{

    //Instance of a symbol table
    SymbolTable symbolTable;

    //Stores the data type of the most recent symbol visited
    Type currentSymbolDataType;

    //Stores the data type of the first return statement encountered within a function block
    Type functionReturnType;

    //Stores function identifiers for more accurate error messages within the ASTBlock visit
    ArrayList<String> functionIdentifiers = new ArrayList<>();

    //Hash map to store parameter identifiers as keys and their type as values
    //Used to check if parameters have the same identifiers
    //Used to insert the function parameters within the function's block scope
    HashMap<String, Type> functionParams = new HashMap<>();

    //Stores whether a return statement was found or not for a function
    boolean hasReturnStatement = false;

    public VisitorSemanticAnalysis(){
        symbolTable = new SymbolTable();
    }

    //Entry function to traverse the AST
    public void visitAST(ASTProgram astProgram){
        System.out.println("\nSemantic Analysis Pass:");
        astProgram.accept(this);
        System.out.println("Success");
    }

    public void visit(ASTProgram astNode) {

        //Push global scope to symbol table
        symbolTable.push();

        //Visit global statements within program
        for (ASTNode statementNode : astNode.statementNodes) {
            statementNode.accept(this);
        }

        symbolTable.pop();
    }

    public void visit(ASTCharLiteral astNode) {

    }

    public void visit(ASTArrayAssignment astNode) {

    }

    public void visit(ASTArrayDecl astNode) {

    }

    public void visit(ASTArrayElements astNode) {

    }

    public void visit(ASTArrayCall astNode) {

    }

    public void visit(ASTType astNode) {

    }

    public void visit(ASTBooleanLiteral astNode) {
        //Update currentSymbolDataType since most recent symbol is of type bool
        currentSymbolDataType = Type.BOOL;
    }

    public void visit(ASTIntegerLiteral astNode) {
        //Update currentSymbolDataType since most recent symbol is of type int
        currentSymbolDataType = Type.INT;
    }

    public void visit(ASTFloatLiteral astNode) {
        //Update currentSymbolDataType since most recent symbol is of type float
        currentSymbolDataType = Type.FLOAT;
    }

    public void visit(ASTIdentifier astNode) {
        //Get type of identifier from symbol table
        Type identifierType = symbolTable.getVariableType(astNode.identifier);

        //If identifier was found and its type returned, update currentSymbolDataType
        if(identifierType != null){
            currentSymbolDataType = identifierType;
        }else{
            System.out.println("Error: The identifier "+astNode.identifier+" has not been declared");
            exit(-1);
        }
    }

    public void visit(ASTMultiplicativeOp astNode) {

    }

    public void visit(ASTAdditiveOp astNode) {

    }

    public void visit(ASTRelationalOp astNode) {

    }

    public void visit(ASTActualParams astNode) {

    }

    public void visit(ASTFunctionCall astNode) {

        String functionIdentifier = astNode.identifier.identifier;

        //List to store the ordered function parameter types to be used when comparing to function signatures within
        //symbol table
        ArrayList<Type> functionTypes = new ArrayList<>();

        for(ASTExpressionNode actualParam: astNode.actualParams.actualParameters){
            actualParam.accept(this);
            functionTypes.add(currentSymbolDataType);
        }

        //Check if function identifier exists within symbol table
        if(!symbolTable.lookupFunctionIdentifier(functionIdentifier)){
            System.out.println("Error: Called function "+functionIdentifier+" which does not exist");
            exit(-1);
        }

        //Check if function signature exists within symbol table given that identifier was found to exist
        if(!symbolTable.lookupFunction(functionIdentifier, functionTypes)){
            System.out.println("Error: Called function "+functionIdentifier+" with wrong signature or parameter types");
            exit(-1);
        }

        //Update currentSymbolDataType to type of function called
        currentSymbolDataType = symbolTable.getFunctionType(functionIdentifier,functionTypes);

    }

    public void visit(ASTSubExpression astNode) {
        astNode.expression.accept(this);
    }

    public void visit(ASTUnary astNode) {
        UnaryType unaryType = astNode.unaryOp.unaryType;
        astNode.expression.accept(this);

            //If UnaryOp is '-', make sure unary expression is not of type bool
        if(unaryType == UnaryType.MINUS){
            if(currentSymbolDataType == Type.BOOL){
                System.out.println("Error: Unary operator '-' cannot be performed on bool types");
                exit(-1);
            }

            //If UnaryOp is 'not', make sure unary expression is of type bool
        }else if(unaryType == UnaryType.NOT){
            if(currentSymbolDataType != Type.BOOL){
                System.out.println("Error: Unary operator 'not' cannot be performed on non-bool types");
                exit(-1);
            }
        }
    }

    public void visit(ASTUnaryOp astNode) {

    }

    public void visit(ASTTerm astNode) {
        Type leftFactorType;
        Type rightFactorType;

        astNode.leftFactor.accept(this);
        leftFactorType = currentSymbolDataType;

        astNode.rightFactor.accept(this);
        rightFactorType = currentSymbolDataType;

        //Check that operands have matching types
        if(leftFactorType == rightFactorType){

                //If MultiplicativeOp is '*', make sure operands are not of type bool
            if(astNode.multiplicativeOp.multiplicativeType == MultiplicativeType.MULTIPLICATION){
                if(leftFactorType != Type.BOOL){
                    currentSymbolDataType = leftFactorType;
                }else{
                    System.out.println("Error: Multiplicative operator '*' not allowed between bool types");
                    exit(-1);
                }

                //If MultiplicativeOp is '/', make sure operands are not of type bool
            }else if(astNode.multiplicativeOp.multiplicativeType == MultiplicativeType.DIVISION){
                if(leftFactorType != Type.BOOL){
                    currentSymbolDataType = leftFactorType;
                }else{
                    System.out.println("Error: Multiplicative operator '/' not allowed between bool types");
                    exit(-1);
                }

                //If MultiplicativeOp is 'and', make sure operands are of type bool
            }else if(astNode.multiplicativeOp.multiplicativeType == MultiplicativeType.AND){
                if(leftFactorType == Type.BOOL){
                    currentSymbolDataType = Type.BOOL;
                }else{
                    System.out.println("Error: Multiplicative operator 'and' not allowed between non-bool types");
                    exit(-1);
                }
            }

        }else{
            System.out.println("Error: Expression with '"+astNode.multiplicativeOp.showType()+"' operator must have factors of the same type");
            exit(-1);
        }
    }

    public void visit(ASTSimpleExpression astNode) {
        Type leftTermType;
        Type rightTermType;

        astNode.leftTerm.accept(this);
        leftTermType = currentSymbolDataType;

        astNode.rightTerm.accept(this);
        rightTermType = currentSymbolDataType;

        //Check that operands have matching types
        if(leftTermType == rightTermType){

                //If AdditiveOp is '+', make sure operands are not of type bool
            if(astNode.additiveOp.additiveType == AdditiveType.PLUS){
                if(leftTermType != Type.BOOL){
                    currentSymbolDataType = leftTermType;
                }else{
                    System.out.println("Error: Additive operator '+' not allowed between bool types");
                    exit(-1);
                }

                //If AdditiveOp is '-', make sure operands are not of type bool
            }else if(astNode.additiveOp.additiveType == AdditiveType.MINUS){
                if(leftTermType != Type.BOOL){
                    currentSymbolDataType = leftTermType;
                }else{
                    System.out.println("Error: Additive operator '-' not allowed between bool types");
                    exit(-1);
                }

                //If AdditiveOp is 'or', make sure operands are of type bool
            }else if(astNode.additiveOp.additiveType == AdditiveType.OR){
                if(leftTermType == Type.BOOL){
                    currentSymbolDataType = Type.BOOL;
                }else{
                    System.out.println("Error: Additive operator 'or' not allowed between non-bool types");
                    exit(-1);
                }
            }

        }else{
            System.out.println("Error: Expression with '"+astNode.additiveOp.showType()+"' operator must have terms of the same type");
            exit(-1);
        }
    }

    public void visit(ASTExpression astNode) {

        Type leftSimpleExpressionType;
        Type rightSimpleExpressionType;

        astNode.leftSimpleExpression.accept(this);
        leftSimpleExpressionType = currentSymbolDataType;

        astNode.rightSimpleExpression.accept(this);
        rightSimpleExpressionType = currentSymbolDataType;

        //Check that operands have matching types
        if(leftSimpleExpressionType == rightSimpleExpressionType){

                //If RelationalOp is '<', make sure operands are not of type bool
            if(astNode.relationalOp.relationalType == RelationalType.SMALLER_THAN){
                if(leftSimpleExpressionType == Type.BOOL){
                    System.out.println("Error: Relational operator '<' not allowed between bool types");
                    exit(-1);
                }

                //If RelationalOp is '>', make sure operands are not of type bool
            }else if(astNode.relationalOp.relationalType == RelationalType.GREATER_THAN){
                if(leftSimpleExpressionType == Type.BOOL){
                    System.out.println("Error: Relational operator '>' not allowed between bool types");
                    exit(-1);
                }

                //If RelationalOp is '==', any type can be accepted
            }else if(astNode.relationalOp.relationalType == RelationalType.EQUAL_TO){
                currentSymbolDataType = Type.BOOL;

                //If RelationalOp is '<>', any type can be accepted
            }else if(astNode.relationalOp.relationalType == RelationalType.NOT_EQUAL_TO){
                currentSymbolDataType = Type.BOOL;

                //If RelationalOp is '<=', make sure operands are not of type bool
            }else if(astNode.relationalOp.relationalType == RelationalType.SMALLER_THAN_OR_EQUAL_TO){
                if(leftSimpleExpressionType == Type.BOOL){
                    System.out.println("Error: Relational operator '<=' not allowed between bool types");
                    exit(-1);
                }

                //If RelationalOp is '>=', make sure operands are not of type bool
            }else if(astNode.relationalOp.relationalType == RelationalType.GREATER_THAN_OR_EQUAL_TO){
                if(leftSimpleExpressionType == Type.BOOL){
                    System.out.println("Error: Relational operator '>=' not allowed between bool types");
                    exit(-1);
                }
            }

            //Update currentSymbolDataType to type boolean since the return time from any relational operator is always
            //boolean
            currentSymbolDataType = Type.BOOL;

        }else{
            System.out.println("Error: Expression with '"+astNode.relationalOp.showType()+"' operator must have simple expressions of the same type");
            exit(-1);
        }
    }

    public void visit(ASTAssignment astNode) {

        String identifier = astNode.identifier.identifier;
        Type identifierType;

        astNode.identifier.accept(this);
        identifierType = currentSymbolDataType;

        astNode.expression.accept(this);

        //Check that identifier and expression have the same type
        if(currentSymbolDataType != identifierType){
            System.out.println("Error: The type of variable "+identifier+" must match the expression type");
            exit(-1);
        }

    }

    public void visit(ASTVariableDecl astNode) {

        String variableIdentifier = astNode.identifier.identifier;
        Type variableType = astNode.type.type;

        //Check that variable identifier hasn't already been declared
        if(symbolTable.lookupVariable(variableIdentifier)){
            System.out.println("Error: The variable "+variableIdentifier+" has already been declared");
            exit(-1);
        }

        astNode.expression.accept(this);

        //Check if declared variable's type is auto
        if(variableType != Type.AUTO){

            //Check if declared variable's type matches that of the expression
            if(variableType == currentSymbolDataType){

                //Insert variable in scope
                SymbolDetails symbolDetails = new SymbolDetails(SymbolType.VARIABLE, currentSymbolDataType);
                symbolTable.insert(variableIdentifier, symbolDetails);

            }else{
                System.out.println("Error: The type of variable "+variableIdentifier+" must match the expression type");
                exit(-1);
            }
        }else{
            //Override AUTO type, with type returned by expression
            SymbolDetails symbolDetails = new SymbolDetails(SymbolType.VARIABLE, currentSymbolDataType);
            symbolTable.insert(variableIdentifier, symbolDetails);
        }
    }

    public void visit(ASTPrintStatement astNode) {
        astNode.expression.accept(this);
    }

    public void visit(ASTIfStatement astNode) {
        astNode.expression.accept(this);

        //Check that expression has a boolean return type
        if(currentSymbolDataType != Type.BOOL){
            System.out.println("Error: Expression inside if statement must be of type bool");
            exit(-1);
        }

        astNode.ifBlock.accept(this);
        astNode.elseBlock.accept(this);
    }

    public void visit(ASTForStatement astNode) {

        String declaredVarIdentifier = null;

        //If variable declaration node exists, visit it
        if(astNode.variableDecl != null){
            declaredVarIdentifier = astNode.variableDecl.identifier.identifier;
            astNode.variableDecl.accept(this);
        }

        astNode.expression.accept(this);

        //Check that expression has a boolean return type
        if(currentSymbolDataType != Type.BOOL){
            System.out.println("Error: Expression inside for statement must be of type bool");
            exit(-1);
        }

        //If assignment node exists, visit it
        if(astNode.assignment != null){
            astNode.assignment.accept(this);
        }

        astNode.block.accept(this);

        //If a variable was declared, pop the variable from current scope
        //Done since this variable is only used within the statement itself and its block
        if(astNode.variableDecl != null){
            symbolTable.popVariable(declaredVarIdentifier);
        }
    }

    public void visit(ASTWhileStatement astNode) {

        astNode.expression.accept(this);

        //Check that expression has a boolean return type
        if(currentSymbolDataType != Type.BOOL){
            System.out.println("Error: Expression inside while statement must be of type bool");
            exit(-1);
        }

        astNode.block.accept(this);

    }

    public void visit(ASTReturnStatement astNode) {
        astNode.expression.accept(this);
    }

    public void visit(ASTFunctionDecl astNode) {

        String identifier = astNode.identifier.identifier;
        ArrayList<ASTFormalParam> formalParams = astNode.formalParams.formalParams;
        ArrayList<Type> formalParamTypes = new ArrayList<>();
        Type functionType = astNode.type.type;

        //Loop through each function's formal parameters
        //Append parameter type to formalParamTypes to lookup function in symbol table
        //Append parameter type and identifier to functionParams to be used within the function's block
        for(ASTFormalParam formalParam: formalParams){
            String paramIdentifier = formalParam.identifier.identifier;
            Type paramType = formalParam.type.type;

            //Check if function contains parameter with auto type specifier
            if(paramType == Type.AUTO){
                System.out.println("Error: The function "+identifier+" has parameters with auto type specifiers");
                exit(-1);
            }

            formalParamTypes.add(paramType);

            //If Map already contains formal param id, display error. Otherwise add to global map of function params
            if(!functionParams.containsKey(paramIdentifier)){
                functionParams.put(paramIdentifier, paramType);
            }else{
                System.out.println("Error: The function "+identifier+" has parameters with the same identifier");
                exit(-1);
            }

        }

        //Check if function already exists with the same signature
        if(!symbolTable.lookupFunction(identifier, formalParamTypes)){

            //Function is inserted before block for recursive purposes
            //Note that recursion is expected to work for all types apart from auto type functions
            SymbolDetails symbolDetails = new SymbolDetails(SymbolType.FUNCTION, functionType, formalParamTypes);
            symbolTable.insert(identifier, symbolDetails);

        }else{
            System.out.println("Error: The function "+identifier+" has already been declared with the same signature");
            exit(-1);
        }

        //Add function identifier to array list for more accurate error messages in ASTBlock visit
        functionIdentifiers.add(identifier);

        astNode.block.accept(this);

        //Remove function identifier from array list once block is traversed
        functionIdentifiers.remove(functionIdentifiers.size()-1);

        //Check if a return statement was found in the function block
        if(!hasReturnStatement){
            System.out.println("Error: Function "+identifier+" has no return statements");
            exit(-1);
        }else{
            hasReturnStatement = false;
        }

        //Check if function type is equal to that returned from the return statement if function type isn't auto
        if(functionType != Type.AUTO){
            if(functionType != functionReturnType){
                System.out.println("Error: "+astNode.type.showType()+" return type required by function "+identifier);
                exit(-1);
            }
        }else{
            //If function type is auto, override its type with that of the return statement
            symbolTable.changeFunctionType(identifier, formalParamTypes, functionReturnType);
        }

    }

    public void visit(ASTBlock astNode) {

        //Push new scope to symbol table stack
        symbolTable.push();

        //Insert function params within new scope if they exist
        if(!functionParams.isEmpty()){
            for(String paramIdentifier : functionParams.keySet()){
                SymbolDetails symbolDetails = new SymbolDetails(SymbolType.VARIABLE, functionParams.get(paramIdentifier));
                symbolTable.insert(paramIdentifier, symbolDetails);
            }

            //Clear global map of function params since params were inserted in scope
            functionParams.clear();
        }

        //Visit all statements within function block
        for (ASTStatementNode statementNode: astNode.statements) {
            statementNode.accept(this);

            //If statement in block is a return statement, set hasReturnStatement to true and functionReturnType to the
            //type of the return statement
            if(statementNode instanceof ASTReturnStatement && !hasReturnStatement){
                hasReturnStatement = true;
                functionReturnType = currentSymbolDataType;

                //If more than one return statement exists in function, this is checked for whether it has the same
                //return type as the one found first. If the types are different, an error is displayed
            }else if(statementNode instanceof ASTReturnStatement && currentSymbolDataType != functionReturnType){
                String functionIdentifier = functionIdentifiers.get(functionIdentifiers.size()-1);
                System.out.println("Error: Function "+functionIdentifier+" has return statements with different types");
                exit(-1);
            }
        }

        //Pop current scope from symbol table, once AST block is completely traversed
        symbolTable.pop();

    }

    public void visit(ASTFormalParam astNode) {

    }

    public void visit(ASTFormalParams astNode) {

    }
}
