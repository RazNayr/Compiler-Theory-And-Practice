package Lexer;

//Enum used to differentiate between different token types
public enum TokenType {
    TOK_MultiplicativeOp,
    TOK_AssignmentOp,
    TOK_AdditiveOp,
    TOK_RelationOp,
    TOK_Identifier,
    TOK_Keyword,
    TOK_Type,
    TOK_BooleanLit,
    TOK_IntegerLit,
    TOK_FloatLit,
    TOK_CharLit,
    TOK_Comment,
    TOK_Punctuation,
    TOK_EOF,
    TOK_Error,
}
