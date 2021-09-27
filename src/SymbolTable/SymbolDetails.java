package SymbolTable;

import Parser.EnumTypes.Type;
import Parser.AST.Statements.ASTBlock;

import java.util.ArrayList;

//Class to store details on each symbol within a scope in the symbol table
public class SymbolDetails {

    //Stores whether the symbol is a variable or a function
    public SymbolType symbolType;

    //Stores the symbol is of type BOOL, INT, FLOAT or AUTO
    public Type symbolDataType;

    //ArrayList storing the formal parameter types of the function signature, given that the symbol is a function
    public ArrayList<Type> paramTypes = null;

    //Stores the bool value of the symbol - used in Interpreter
    public boolean boolValue;

    //Stores the int value of the symbol - used in Interpreter
    public int intValue;

    //Stores the float value of the symbol - used in Interpreter
    public float floatValue;

    //Stores the formal parameter identifiers of the function to be used when calling the function- used in Interpreter
    public ArrayList<String> functionFormalParamIdentifiers;

    //Stores the Block to be run when calling the function - used in Interpreter
    public ASTBlock functionBlock;

    //Constructor used when symbol being inserted within the symbol table is a function with formal parameter types
    public SymbolDetails(SymbolType symbolType, Type symbolDataType, ArrayList<Type> paramTypes) {
        this.symbolType = symbolType;
        this.symbolDataType = symbolDataType;
        this.paramTypes = paramTypes;
    }

    //Constructor used when symbol being inserted within the symbol table is a variable
    public SymbolDetails(SymbolType symbolType, Type symbolDataType) {
        this.symbolType = symbolType;
        this.symbolDataType = symbolDataType;
    }
}
