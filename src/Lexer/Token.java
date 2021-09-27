package Lexer;

//Class to represent a token
public class Token {

    //Stores the type of the token
    TokenType tokenType;

    //Stores the token's string value
    String lexeme;

    Token(TokenType _tokenType, String _lexeme){
        this.tokenType = _tokenType;
        this.lexeme = _lexeme;
    }

    public TokenType getType(){
        return tokenType;
    }

    public String getLexeme(){
        return lexeme;
    }
}