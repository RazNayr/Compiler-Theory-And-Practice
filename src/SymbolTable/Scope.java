package SymbolTable;

public class Scope {

    //MultiMap of identifiers as keys and SymbolDetails objects as values
    //Multimap was chosen since functions may have the same identifiers but different signatures
    public MultiMap<String, SymbolDetails> symbolMap;

    public Scope(){
        symbolMap = new MultiMap<String, SymbolDetails>();
    }

}
