package SymbolTable;

import Parser.EnumTypes.Type;

import java.util.ArrayList;

public class SymbolTable {

    //List to act as a stack, storing scopes of the program
    //ArrayList was implemented instead of stack so that searching can be done in constant time.
    //No need for pops and re-pushing back to stack once done from search.
    ArrayList<Scope> scopeStack;

    //Stores the position of the current stack
    public int scopeStackPosition;

    public SymbolTable(){
        this.scopeStack = new ArrayList<>();

        //Set to -1 to account for global scope. When global scope is pushed, the stack position would then be 0
        this.scopeStackPosition = -1;
    }

    //Function to push a new scope to the stack
    public void push(){
        Scope newScope = new Scope();
        scopeStack.add(newScope);
        scopeStackPosition++;
    }

    //Function to insert an identifier and its details within the current scope
    public void insert(String symbol, SymbolDetails symbolDetails){
        scopeStack.get(scopeStackPosition).symbolMap.put(symbol, symbolDetails);
    }

    //Function to check whether the passed variable identifier exists within the current scope or any scope before it.
    //If exists, the function returns true, otherwise false
    public boolean lookupVariable(String symbol){

        int scopeLookupPosition = scopeStackPosition;

        while (scopeLookupPosition >= 0){
            Scope currentScope = scopeStack.get(scopeLookupPosition);

            if(currentScope.symbolMap.containsKey(symbol)) {
                for (SymbolDetails details : currentScope.symbolMap.get(symbol)) {
                    if (details.symbolType == SymbolType.VARIABLE) {
                        return true;
                    }
                }
            }

            scopeLookupPosition--;
        }

        return false;
    }

    //Function to return the Type of the variable if found, otherwise it returns null.
    public Type getVariableType(String symbol){

        int scopeLookupPosition = scopeStackPosition;

        while (scopeLookupPosition >= 0){
            Scope currentScope = scopeStack.get(scopeLookupPosition);

            if(currentScope.symbolMap.containsKey(symbol)){
                for(SymbolDetails details: currentScope.symbolMap.get(symbol)){
                    if(details.symbolType == SymbolType.VARIABLE){
                        return details.symbolDataType;
                    }
                }
            }

            scopeLookupPosition--;
        }

        return null;
    }

    //Function to check whether the passed function identifier exists within the current scope or any scope before it.
    //This is done by checking if the function identifier exists and by comparing ordered parameter types with those
    //found in scope.
    //If exists and signature is the same, returns true, otherwise return false
    public boolean lookupFunction(String symbol, ArrayList<Type> paramTypes){

        int scopeLookupPosition = scopeStackPosition;

        while (scopeLookupPosition >= 0){
            Scope currentScope = scopeStack.get(scopeLookupPosition);

            if(currentScope.symbolMap.containsKey(symbol)){
                for(SymbolDetails details: currentScope.symbolMap.get(symbol)){
                    if(details.symbolType == SymbolType.FUNCTION && details.paramTypes.equals(paramTypes)){
                        return true;
                    }
                }
            }

            scopeLookupPosition--;
        }

        return false;
    }

    //Function used to check if function identifier exists in current or previous scopes
    //If exists true is returned, otherwise false
    public boolean lookupFunctionIdentifier(String symbol){

        int scopeLookupPosition = scopeStackPosition;

        while (scopeLookupPosition >= 0){
            Scope currentScope = scopeStack.get(scopeLookupPosition);

            if(currentScope.symbolMap.containsKey(symbol)){
                for(SymbolDetails details: currentScope.symbolMap.get(symbol)){
                    if(details.symbolType == SymbolType.FUNCTION){
                        return true;
                    }
                }
            }

            scopeLookupPosition--;
        }

        return false;
    }

    //Function to return the Type of the function passed if found, otherwise it returns null.
    public Type getFunctionType(String symbol, ArrayList<Type> paramTypes){

        int scopeLookupPosition = scopeStackPosition;

        while (scopeLookupPosition >= 0){
            Scope currentScope = scopeStack.get(scopeLookupPosition);

            if(currentScope.symbolMap.containsKey(symbol)){
                for(SymbolDetails details: currentScope.symbolMap.get(symbol)){
                    if(details.symbolType == SymbolType.FUNCTION && details.paramTypes.equals(paramTypes)){
                        return details.symbolDataType;
                    }
                }
            }

            scopeLookupPosition--;
        }

        return null;
    }

    //Function used to change the data type of a specific function
    //This is used when the function is originally declared with an auto type
    public void changeFunctionType(String symbol, ArrayList<Type> paramTypes, Type newType){

        int scopeLookupPosition = scopeStackPosition;

        while (scopeLookupPosition >= 0){
            Scope currentScope = scopeStack.get(scopeLookupPosition);

            if(currentScope.symbolMap.containsKey(symbol)){
                for(SymbolDetails details: currentScope.symbolMap.get(symbol)){
                    if(details.symbolType == SymbolType.FUNCTION && details.paramTypes.equals(paramTypes)){
                        details.symbolDataType = newType;
                        break;
                    }
                }
            }

            scopeLookupPosition--;
        }
    }

    //Function to pop the current scope
    public void pop(){
        int lastScope = scopeStack.size()-1;
        scopeStack.remove(lastScope);
        scopeStackPosition--;
    }

    //Used within the ASTForStatement visit function to remove its declared variable from the scope
    //Initially if a variable is declared within the statement, this is added to the scope so that the expression
    //and assignment within the statement, can make use of such variable. This however can only be used within the
    //statement's block and within its conditions. Hence when its block is fully visited, the variable can be removed
    //from the current scope.
    public void popVariable(String symbol){

        Scope currentScope = scopeStack.get(scopeStackPosition);

        if(currentScope.symbolMap.containsKey(symbol)) {
            for (SymbolDetails details : currentScope.symbolMap.get(symbol)) {
                if (details.symbolType == SymbolType.VARIABLE) {
                    currentScope.symbolMap.remove(symbol, details);
                    break;
                }
            }
        }
    }

    //----------------------------------------------Interpreter Functions-----------------------------------------------

    //Function to set a new bool value to a specific variable
    public void setVariableBoolValue(String symbol, boolean value){

        int scopeLookupPosition = scopeStackPosition;

        while (scopeLookupPosition >= 0){
            Scope currentScope = scopeStack.get(scopeLookupPosition);

            if(currentScope.symbolMap.containsKey(symbol)) {

                for (SymbolDetails details : currentScope.symbolMap.get(symbol)) {
                    if (details.symbolType == SymbolType.VARIABLE) {
                        details.boolValue = value;
                        break;
                    }
                }

            }
            scopeLookupPosition--;
        }
    }

    //Function to set a new int value to a specific variable
    public void setVariableIntValue(String symbol, int value){

        int scopeLookupPosition = scopeStackPosition;

        while (scopeLookupPosition >= 0){
            Scope currentScope = scopeStack.get(scopeLookupPosition);

            if(currentScope.symbolMap.containsKey(symbol)) {

                for (SymbolDetails details : currentScope.symbolMap.get(symbol)) {
                    if (details.symbolType == SymbolType.VARIABLE) {
                        details.intValue = value;
                    }
                }

            }
            scopeLookupPosition--;
        }
    }

    //Function to set a new float value to a specific variable
    public void setVariableFloatValue(String symbol, float value){

        int scopeLookupPosition = scopeStackPosition;

        while (scopeLookupPosition >= 0){
            Scope currentScope = scopeStack.get(scopeLookupPosition);

            if(currentScope.symbolMap.containsKey(symbol)) {

                for (SymbolDetails details : currentScope.symbolMap.get(symbol)) {
                    if (details.symbolType == SymbolType.VARIABLE) {
                        details.floatValue = value;
                    }
                }

            }
            scopeLookupPosition--;
        }
    }

    //Used to return the variable's details to be used within the ASTIdentifier visit pass
    public SymbolDetails getVariableDetails(String symbol){

        int scopeLookupPosition = scopeStackPosition;

        while (scopeLookupPosition >= 0){
            Scope currentScope = scopeStack.get(scopeLookupPosition);

            if(currentScope.symbolMap.containsKey(symbol)){
                for(SymbolDetails details: currentScope.symbolMap.get(symbol)){
                    if(details.symbolType == SymbolType.VARIABLE){
                        return details;
                    }
                }
            }

            scopeLookupPosition--;
        }

        return null;
    }

    //Used to return the function's details to be used within the ASTFunctionCall visit pass
    public SymbolDetails getFunctionDetails(String symbol, ArrayList<Type> paramTypes){

        int scopeLookupPosition = scopeStackPosition;

        while (scopeLookupPosition >= 0){
            Scope currentScope = scopeStack.get(scopeLookupPosition);

            if(currentScope.symbolMap.containsKey(symbol)){
                for(SymbolDetails details: currentScope.symbolMap.get(symbol)){
                    if(details.symbolType == SymbolType.FUNCTION && details.paramTypes.equals(paramTypes)){
                        return details;
                    }
                }
            }

            scopeLookupPosition--;
        }

        return null;
    }

}
