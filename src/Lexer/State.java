package Lexer;

//Class to represent a state within the Lexer DFSA
public class State {

    //Stores whether the state is final or not
    boolean isFinalState;

    //Stores the token type returned by the state
    TokenType stateToken;

    public void setFinalState(boolean isFinal){
        this.isFinalState = isFinal;
    }

    public void setToken(TokenType tokenType){
        this.stateToken = tokenType;
    }
}
