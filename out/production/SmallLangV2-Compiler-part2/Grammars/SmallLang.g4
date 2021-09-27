//Name of the grammar
grammar SmallLang;

//------------------------------------------------------Lexer Rules-----------------------------------------------------
fragment LETTER : [a-zA-Z];
fragment DIGIT  : [0-9];

TYPE            : 'float' | 'int' | 'bool';
AUTO            : 'auto';
BOOLEANLITERAL  : 'true' | 'false';
INTEGERLITERAL  : DIGIT+;
FLOATLITERAL    : DIGIT+'.'DIGIT+;
MULTIPLICATIVEOP: '*' | '/' | 'and';
ADDITIVEOP      : '+' | MINUS | 'or';
RELATIONALOP    : '<' | '>' | '==' | '<>' | '<=' | '>=';
UNARYOP         : MINUS | 'not';

//Put under all others since a term like 'and' would be identified as an identifier first instead of mult operator
IDENTIFIER      : ( '_' | LETTER ) ( '_' | LETTER | DIGIT )*;

//Extra-lexer Rules for above rules
//Done to eliminate risk of not detecting non-referenced elements
MINUS           : '-';

//Characters and comments to ignore
NEWLINE         : ('\r'? '\n' | '\r')+ -> skip;
WHITESPACE      : (' ' | '\t') -> skip;
MULTICOMMENT    : '/*' .*? '*/' -> skip;
COMMENT         : '//' ~( '\n' )* -> skip;


//-----------------------------------------------------Parser Rules-----------------------------------------------------
//Expressions
literal         : BOOLEANLITERAL
                | INTEGERLITERAL
                | FLOATLITERAL;

actualparams    : expression (',' expression)*;
functioncall    : IDENTIFIER '(' actualparams? ')';
subexpression   : '(' expression ')';
unary           : UNARYOP expression;

factor          : literal
                | IDENTIFIER
                | functioncall
                | subexpression
                | unary;

//Previous iterative implementation - WRONG
//term            : factor (MULTIPLICATIVEOP factor)*;
//
//simpleexpression: term (ADDITIVEOP term)*;
//
//expression      : simpleexpression (RELATIONALOP simpleexpression)*;

term            : factor MULTIPLICATIVEOP factor
                | factor MULTIPLICATIVEOP term
                | factor;

simpleexpression: term ADDITIVEOP term
                | term ADDITIVEOP simpleexpression
                | term;

expression      : simpleexpression RELATIONALOP simpleexpression
                | simpleexpression RELATIONALOP expression
                | simpleexpression;

//Statements
assignment      : IDENTIFIER '=' expression;

variabledecl    : 'let' IDENTIFIER ':' (TYPE | AUTO) '=' expression;

printstatement  : 'print' expression;

rtrnstatement   : 'return' expression;

ifstatement     : 'if' '(' expression ')' block ('else' block)?;

forstatement    : 'for' '(' (variabledecl)? ';' expression ';' (assignment)? ')' block;

whilestatement  : 'while' '(' expression ')' block;

formalparam     : IDENTIFIER ':' TYPE;

formalparams    : formalparam (',' formalparam)*;

functiondecl    : 'ff' IDENTIFIER '(' formalparams? ')' ':' (TYPE | AUTO) block;

statement       : variabledecl ';'
                | assignment ';'
                | printstatement ';'
                | ifstatement
                | forstatement
                | whilestatement
                | rtrnstatement ';'
                | functiondecl
                | block;

block           : '{' (statement)* '}';

program         : (statement)*;

//----------------------------------------------------------------------------------------------------------------------