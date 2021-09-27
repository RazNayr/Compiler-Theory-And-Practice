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

public class VisitorInterpreterExecution implements  Visitor {

    //Instance of a symbol table
    SymbolTable symbolTable;

    //Stores the data type of the most recent symbol visited
    Type currentSymbolDataType;

    //Stores whether a return statement was found or not for a function
    boolean hasReturnStatement = false;

    //Used to insert the called function's parameter details within the scope of the function's block
    HashMap<String, SymbolDetails> functionParams = new HashMap<>();

    //Store values related to their type
    ArrayList<Boolean> boolValues = new ArrayList<>();
    ArrayList<Integer> intValues = new ArrayList<>();
    ArrayList<Float> floatValues = new ArrayList<>();

    public VisitorInterpreterExecution(){
        symbolTable = new SymbolTable();
    }

    //Entry function to traverse the AST
    public void visitAST(ASTProgram astProgram){
        System.out.println("\nInterpreter Execution Pass:");
        astProgram.accept(this);
    }

    public void visit(ASTProgram astNode) {

        //Push global scope to symbol table
        symbolTable.push();

        //Visit global statements within program
        for (ASTNode statementNode : astNode.statementNodes) {
            statementNode.accept(this);
        }

        //Pop global scope from symbol table
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

        //Add value of boolean literal to global list of boolean values
        boolValues.add(astNode.booleanLiteral);

        //Update currentSymbolDataType since most recent symbol is of type bool
        currentSymbolDataType = Type.BOOL;

    }

    public void visit(ASTIntegerLiteral astNode) {

        //Add value of integer literal to global list of int values
        intValues.add(astNode.integerLiteral);

        //Update currentSymbolDataType since most recent symbol is of type int
        currentSymbolDataType = Type.INT;

    }

    public void visit(ASTFloatLiteral astNode) {

        //Add value of float literal to global list of float values
        floatValues.add(astNode.floatLiteral);

        //Update currentSymbolDataType since most recent symbol is of type float
        currentSymbolDataType = Type.FLOAT;

    }

    public void visit(ASTIdentifier astNode) {

        String identifier = astNode.identifier;
        SymbolDetails identifierDetails = symbolTable.getVariableDetails(identifier);

        //Insert identifier's value to global list of the same data type
        if(identifierDetails.symbolDataType == Type.BOOL){
            boolValues.add(identifierDetails.boolValue);
            currentSymbolDataType = Type.BOOL;

        }else if(identifierDetails.symbolDataType == Type.INT){
            intValues.add(identifierDetails.intValue);
            currentSymbolDataType = Type.INT;

        }else if(identifierDetails.symbolDataType == Type.FLOAT){
            floatValues.add(identifierDetails.floatValue);
            currentSymbolDataType = Type.FLOAT;
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
        ArrayList<Type> actualParamTypes = new ArrayList<>();
        SymbolDetails functionDetails;

        //Fill actualParamTypes list with called function's parameter types, in order
        for(ASTExpressionNode actualParam: astNode.actualParams.actualParameters){
            actualParam.accept(this);
            actualParamTypes.add(currentSymbolDataType);
        }

        //Get details of function from symbol table
        functionDetails = symbolTable.getFunctionDetails(functionIdentifier, actualParamTypes);

        //Start looping from last so that values of each actual parameter can be correctly retrieved from the global
        //array lists storing values of primitive types. Details of each parameter are retrieved and stored within the
        //global functionParams hash map to be used within the function's block.
        for (int i = actualParamTypes.size() - 1; i >= 0 ; i--) {

            Type actualParamType = actualParamTypes.get(i);
            String formalParamIdentifier = functionDetails.functionFormalParamIdentifiers.get(i);
            SymbolDetails formalParamDetails = new SymbolDetails(SymbolType.VARIABLE, actualParamType);

            if(actualParamType == Type.BOOL){

                //Get last value from global value list
                formalParamDetails.boolValue = boolValues.get(boolValues.size() - 1);

                //Remove value since it is no longer needed
                boolValues.remove(boolValues.size() - 1);

            }else if(actualParamType == Type.INT){
                formalParamDetails.intValue = intValues.get(intValues.size() - 1);
                intValues.remove(intValues.size() - 1);

            }else if(actualParamType == Type.FLOAT){
                formalParamDetails.floatValue = floatValues.get(floatValues.size() - 1);
                floatValues.remove(floatValues.size() - 1);
            }

            //Add formal param details to global hash map to be inserted within new scope in function block
            functionParams.put(formalParamIdentifier, formalParamDetails);
        }

        //Visit block
        functionDetails.functionBlock.accept(this);

        //Reset global boolean for checking if return statement in function block was reached
        hasReturnStatement = false;

    }

    public void visit(ASTSubExpression astNode) {
        astNode.expression.accept(this);
    }

    public void visit(ASTUnary astNode) {

        UnaryType unaryOpType = astNode.unaryOp.unaryType;
        astNode.expression.accept(this);

        //Insert unary's value to global list of the same data type
        if(currentSymbolDataType == Type.BOOL){

            //Get last value from global value list
            boolean unaryValue = boolValues.get(boolValues.size()-1);

            //Remove value since it is no longer needed
            boolValues.remove(boolValues.size()-1);

            if(unaryOpType == UnaryType.NOT){
                boolValues.add(!unaryValue);
            }

        }else if(currentSymbolDataType == Type.INT){

            int unaryValue = intValues.get(intValues.size()-1);
            intValues.remove(intValues.size()-1);

            if(unaryOpType == UnaryType.MINUS){
                intValues.add(-unaryValue);
            }

        }else if(currentSymbolDataType == Type.FLOAT){

            float unaryValue = floatValues.get(floatValues.size()-1);
            floatValues.remove(floatValues.size()-1);

            if(unaryOpType == UnaryType.MINUS){
                floatValues.add(-unaryValue);
            }
        }

    }

    public void visit(ASTUnaryOp astNode) {

    }

    public void visit(ASTTerm astNode) {
        MultiplicativeType multiplicativeOpType = astNode.multiplicativeOp.multiplicativeType;
        astNode.leftFactor.accept(this);
        astNode.rightFactor.accept(this);

        if(currentSymbolDataType == Type.BOOL){

            //Get last value from global value list. In this case the right value is retrieved first since the right
            //expression was visited last
            boolean rightValue = boolValues.get(boolValues.size()-1);

            //Remove value since it is no longer needed
            boolValues.remove(boolValues.size()-1);

            boolean leftValue = boolValues.get(boolValues.size()-1);
            boolValues.remove(boolValues.size()-1);

            if(multiplicativeOpType == MultiplicativeType.AND){
                boolValues.add(leftValue && rightValue);
            }

        }else if(currentSymbolDataType == Type.INT){

            int rightValue = intValues.get(intValues.size()-1);
            intValues.remove(intValues.size()-1);

            int leftValue = intValues.get(intValues.size()-1);
            intValues.remove(intValues.size()-1);

            if(multiplicativeOpType == MultiplicativeType.MULTIPLICATION){
                intValues.add(leftValue * rightValue);
            }else if(multiplicativeOpType == MultiplicativeType.DIVISION) {
                intValues.add(leftValue / rightValue);
            }

        }else if(currentSymbolDataType == Type.FLOAT){

            float rightValue = floatValues.get(floatValues.size()-1);
            floatValues.remove(floatValues.size()-1);

            float leftValue = floatValues.get(floatValues.size()-1);
            floatValues.remove(floatValues.size()-1);

            if(multiplicativeOpType == MultiplicativeType.MULTIPLICATION){
                floatValues.add(leftValue * rightValue);
            }else if(multiplicativeOpType == MultiplicativeType.DIVISION) {
                floatValues.add(leftValue / rightValue);
            }
        }
    }

    public void visit(ASTSimpleExpression astNode) {

        AdditiveType additiveOpType = astNode.additiveOp.additiveType;
        astNode.leftTerm.accept(this);
        astNode.rightTerm.accept(this);

        if(currentSymbolDataType == Type.BOOL){

            //Get last value from global value list. In this case the right value is retrieved first since the right
            //expression was visited last
            boolean rightValue = boolValues.get(boolValues.size()-1);

            //Remove value since it is no longer needed
            boolValues.remove(boolValues.size()-1);

            boolean leftValue = boolValues.get(boolValues.size()-1);
            boolValues.remove(boolValues.size()-1);

            if(additiveOpType == AdditiveType.OR){
                boolValues.add(leftValue || rightValue);
            }

        }else if(currentSymbolDataType == Type.INT){

            int rightValue = intValues.get(intValues.size()-1);
            intValues.remove(intValues.size()-1);

            int leftValue = intValues.get(intValues.size()-1);
            intValues.remove(intValues.size()-1);

            if(additiveOpType == AdditiveType.PLUS){
                intValues.add(leftValue + rightValue);
            }else if(additiveOpType == AdditiveType.MINUS) {
                intValues.add(leftValue - rightValue);
            }

        }else if(currentSymbolDataType == Type.FLOAT){

            float rightValue = floatValues.get(floatValues.size()-1);
            floatValues.remove(floatValues.size()-1);

            float leftValue = floatValues.get(floatValues.size()-1);
            floatValues.remove(floatValues.size()-1);

            if(additiveOpType == AdditiveType.PLUS){
                floatValues.add(leftValue + rightValue);
            }else if(additiveOpType == AdditiveType.MINUS) {
                floatValues.add(leftValue - rightValue);
            }
        }
    }

    public void visit(ASTExpression astNode) {

        RelationalType relationalOpType = astNode.relationalOp.relationalType;
        astNode.leftSimpleExpression.accept(this);
        astNode.rightSimpleExpression.accept(this);

        if(currentSymbolDataType == Type.BOOL){

            //Get last value from global value list. In this case the right value is retrieved first since the right
            //expression was visited last
            boolean rightValue = boolValues.get(boolValues.size()-1);

            //Remove value since it is no longer needed
            boolValues.remove(boolValues.size()-1);

            boolean leftValue = boolValues.get(boolValues.size()-1);
            boolValues.remove(boolValues.size()-1);

            if(relationalOpType == RelationalType.EQUAL_TO){
                boolValues.add(leftValue == rightValue);

            }else if(astNode.relationalOp.relationalType == RelationalType.NOT_EQUAL_TO) {
                boolValues.add(leftValue != rightValue);
            }

        }else if(currentSymbolDataType == Type.INT){

            int rightValue = intValues.get(intValues.size()-1);
            intValues.remove(intValues.size()-1);

            int leftValue = intValues.get(intValues.size()-1);
            intValues.remove(intValues.size()-1);

            if(relationalOpType == RelationalType.SMALLER_THAN){
                boolValues.add(leftValue < rightValue);

            }else if(relationalOpType == RelationalType.GREATER_THAN){
                boolValues.add(leftValue > rightValue);

            }else if(relationalOpType == RelationalType.EQUAL_TO){
                boolValues.add(leftValue == rightValue);

            }else if(astNode.relationalOp.relationalType == RelationalType.NOT_EQUAL_TO){
                boolValues.add(leftValue != rightValue);

            }else if(relationalOpType == RelationalType.SMALLER_THAN_OR_EQUAL_TO){
                boolValues.add(leftValue <= rightValue);

            }else if(relationalOpType == RelationalType.GREATER_THAN_OR_EQUAL_TO){
                boolValues.add(leftValue >= rightValue);
            }

        }else if(currentSymbolDataType == Type.FLOAT){

            float rightValue = floatValues.get(floatValues.size()-1);
            floatValues.remove(floatValues.size()-1);

            float leftValue = floatValues.get(floatValues.size()-1);
            floatValues.remove(floatValues.size()-1);

            if(relationalOpType == RelationalType.SMALLER_THAN){
                boolValues.add(leftValue < rightValue);

            }else if(relationalOpType == RelationalType.GREATER_THAN){
                boolValues.add(leftValue > rightValue);

            }else if(relationalOpType == RelationalType.EQUAL_TO){
                boolValues.add(leftValue == rightValue);

            }else if(astNode.relationalOp.relationalType == RelationalType.NOT_EQUAL_TO){
                boolValues.add(leftValue != rightValue);

            }else if(relationalOpType == RelationalType.SMALLER_THAN_OR_EQUAL_TO){
                boolValues.add(leftValue <= rightValue);

            }else if(relationalOpType == RelationalType.GREATER_THAN_OR_EQUAL_TO){
                boolValues.add(leftValue >= rightValue);
            }

        }

        //Change current type since relational operators always return a boolean value
        currentSymbolDataType = Type.BOOL;
    }

    public void visit(ASTVariableDecl astNode) {

        String variableIdentifier = astNode.identifier.identifier;
        astNode.expression.accept(this);

        //Assign variableType to type of expression to override potential AUTO type specifier of the variable
        Type variableType = currentSymbolDataType;
        SymbolDetails variableDetails = new SymbolDetails(SymbolType.VARIABLE, variableType);

        if(currentSymbolDataType == Type.BOOL){
            variableDetails.boolValue = boolValues.get(boolValues.size()-1);
            boolValues.remove(boolValues.size()-1);

        }else if(currentSymbolDataType == Type.INT){
            variableDetails.intValue = intValues.get(intValues.size()-1);
            intValues.remove(intValues.size()-1);

        }else if(currentSymbolDataType == Type.FLOAT){
            variableDetails.floatValue = floatValues.get(floatValues.size()-1);
            floatValues.remove(floatValues.size()-1);

        }

        //Insert declared variable within current scope on the symbol table
        symbolTable.insert(variableIdentifier, variableDetails);
    }

    public void visit(ASTAssignment astNode) {

        String identifier = astNode.identifier.identifier;
        astNode.expression.accept(this);

        if(currentSymbolDataType == Type.BOOL){
            boolean newValue = boolValues.get(boolValues.size()-1);
            boolValues.remove(boolValues.size()-1);

            //Set existing variable's value to the newly assigned one
            symbolTable.setVariableBoolValue(identifier, newValue);

        }else if(currentSymbolDataType == Type.INT){
            int newValue = intValues.get(intValues.size()-1);
            intValues.remove(intValues.size()-1);

            symbolTable.setVariableIntValue(identifier, newValue);

        }else if(currentSymbolDataType == Type.FLOAT){
            float newValue = floatValues.get(floatValues.size()-1);
            floatValues.remove(floatValues.size()-1);

            symbolTable.setVariableFloatValue(identifier, newValue);

        }
    }

    public void visit(ASTPrintStatement astNode) {
        astNode.expression.accept(this);

        if(currentSymbolDataType == Type.BOOL){

            //Print the value of the visited expression
            System.out.println(boolValues.get(boolValues.size()-1));

            //Remove value since no longer needed
            boolValues.remove(boolValues.size()-1);

        }else if(currentSymbolDataType == Type.INT){
            System.out.println(intValues.get(intValues.size()-1));
            intValues.remove(intValues.size()-1);

        }else if(currentSymbolDataType == Type.FLOAT){
            System.out.println(floatValues.get(floatValues.size()-1));
            floatValues.remove(floatValues.size()-1);
        }

    }

    public void visit(ASTIfStatement astNode) {

        astNode.expression.accept(this);

        //Get boolean value of expression within if condition
        boolean satisfiedCondition = boolValues.get(boolValues.size()-1);
        boolValues.remove(boolValues.size()-1);

        //If condition is satisfied by expression visit if block, otherwise visit else block
        if(satisfiedCondition){
            astNode.ifBlock.accept(this);
        }else{
            astNode.elseBlock.accept(this);
        }
    }

    public void visit(ASTForStatement astNode) {

        boolean satisfiedCondition;
        String declaredVarIdentifier = null;

        //If variable declaration exists within statement, visit it
        if(astNode.variableDecl != null){
            declaredVarIdentifier = astNode.variableDecl.identifier.identifier;
            astNode.variableDecl.accept(this);
        }

        //Loop for statement until condition is unsatisfied
        do {
            astNode.expression.accept(this);

            satisfiedCondition = boolValues.get(boolValues.size() - 1);
            boolValues.remove(boolValues.size() - 1);

            //If loop condition is satisfied by expression visit block and then execute assignment if exists
            if (satisfiedCondition) {
                astNode.block.accept(this);

                if(astNode.assignment != null){
                    astNode.assignment.accept(this);
                }
            }

        }while(satisfiedCondition);

        //If variable was declared, remove it from scope since this could only be used in the for statement
        if(astNode.variableDecl != null){
            symbolTable.popVariable(declaredVarIdentifier);
        }

    }

    public void visit(ASTWhileStatement astNode) {

        boolean satisfiedCondition;

        //Loop while statement until condition is unsatisfied
        do {
            astNode.expression.accept(this);

            satisfiedCondition = boolValues.get(boolValues.size() - 1);
            boolValues.remove(boolValues.size() - 1);

            //If for condition is satisfied, run block
            if (satisfiedCondition) {
                astNode.block.accept(this);
            }

        }while(satisfiedCondition);
    }

    public void visit(ASTReturnStatement astNode) {
        astNode.expression.accept(this);

        //If ASTReturnStatement is visited, set global boolean to true to indicate that a function returned a value
        hasReturnStatement = true;
    }

    public void visit(ASTFunctionDecl astNode) {

        String functionIdentifier = astNode.identifier.identifier;
        ArrayList<ASTFormalParam> formalParams = astNode.formalParams.formalParams;
        ArrayList<Type> formalParamTypes = new ArrayList<>();
        ArrayList<String> formalParamIdentifiers = new ArrayList<>();
        Type functionType = astNode.type.type;

        for(ASTFormalParam formalParam: formalParams){
            Type paramType = formalParam.type.type;
            String paramId = formalParam.identifier.identifier;

            formalParamTypes.add(paramType);
            formalParamIdentifiers.add(paramId);
        }

        SymbolDetails functionDetails = new SymbolDetails(SymbolType.FUNCTION, functionType, formalParamTypes);

        //Add function formal param identifiers to be used when function is called
        functionDetails.functionFormalParamIdentifiers = formalParamIdentifiers;

        //Add function block to be run when function is called
        functionDetails.functionBlock = astNode.block;

        //Insert function declaration within current scope
        symbolTable.insert(functionIdentifier, functionDetails);
    }

    public void visit(ASTBlock astNode) {

        //Push new scope to symbol table stack
        symbolTable.push();

        //Insert function params within new scope if they exist
        if(!functionParams.isEmpty()){
            for(String paramIdentifier : functionParams.keySet()){
                SymbolDetails symbolDetails = functionParams.get(paramIdentifier);
                symbolTable.insert(paramIdentifier, symbolDetails);
            }

            //Clear global map of function params since all params were inserted in scope
            functionParams.clear();
        }

        for (ASTStatementNode statementNode: astNode.statements) {
            statementNode.accept(this);

            //If a return statement was reached, break from loop since it is unnecessary to continue processing block
            if (hasReturnStatement) {
                break;
            }
        }

        //Pop current scope from symbol table, once AST block is completely traversed or a return statement was reached
        symbolTable.pop();

    }

    public void visit(ASTFormalParam astNode) {

    }

    public void visit(ASTFormalParams astNode) {

    }
}
