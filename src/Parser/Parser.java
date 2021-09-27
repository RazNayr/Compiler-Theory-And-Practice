package Parser;

import Lexer.Lexer;
import Lexer.Token;
import Lexer.TokenType;
import Parser.AST.ASTExpressionNode;
import Parser.AST.ASTProgram;
import Parser.AST.ASTStatementNode;
import Parser.AST.Expressions.Factors.Literals.ASTCharLiteral;
import Parser.EnumTypes.AssignmentType;
import Parser.AST.Expressions.*;
import Parser.AST.Expressions.Factors.*;
import Parser.AST.Expressions.Factors.Literals.ASTBooleanLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTFloatLiteral;
import Parser.AST.Expressions.Factors.Literals.ASTIntegerLiteral;
import Parser.AST.Statements.*;

import java.util.ArrayList;

import static java.lang.System.exit;

public class Parser {

    //List of ASTNode to store each global statement node of the program
    ArrayList<ASTStatementNode> statementNodes;

    //Stores the most recent token received from the Lexer
    Token currentToken;

    public Parser(){
        statementNodes = new ArrayList<>();
    }

    //Used to return the AST root node after having parsed all statements
    public ASTProgram parseProgram(){
        //Go through each token until the EOF token is retrieved
        while(Lexer.lookAheadToken().getType() != TokenType.TOK_EOF){

            //Update currentToken with next token from Lexer
            currentToken = Lexer.getNextToken();

            //Retrieved the parsed AST statement after calling parseStatement()
            ASTStatementNode statementNode = parseStatement();

            //Add the statement returned to the global list of statement nodes
            statementNodes.add(statementNode);
        }

        //Return an ASTProgram node with the list of global AST statements.
        //This is the root node to the whole AST
        return new ASTProgram(statementNodes);
    }

    //Used to determine what type of statement to parse and return its AST node
    private ASTStatementNode parseStatement(){

            //If currentToken is a keyword, parse the statement related to the specific keyword
        if(currentToken.getType() == TokenType.TOK_Keyword){
            if(currentToken.getLexeme().equals("let")){
                //Possible to declare either a variable or an array
                return parseDeclaration();
            }else if(currentToken.getLexeme().equals("print")){
                return parsePrintStatement();
            }else if(currentToken.getLexeme().equals("return")){
                return parseReturnStatement();
            }else if(currentToken.getLexeme().equals("if")){
                return parseIfStatement();
            }else if(currentToken.getLexeme().equals("for")){
                return parseForStatement();
            }else if(currentToken.getLexeme().equals("while")){
                return parseWhileStatement();
            }else if(currentToken.getLexeme().equals("ff")){
                return parseFunctionDeclaration();
            }

            //If currentToken is a '{' parse the block statement
        }else if(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("{")){
            return parseBlock();

            //If currentToken is an identifier, parse the assignment statement given an INLINE type
        }else if(currentToken.getType() == TokenType.TOK_Identifier){
            if(Lexer.lookAheadToken().getLexeme().equals("[")){
                return parseArrayAssignment();
            }else{
                return parseAssignment(AssignmentType.INLINE);
            }

        }else{
            System.out.println("Error: Statement expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }
        return null;
    }

    //Parses the variable declaration statement and returns its AST node equivalent
    private ASTVariableDecl parseVariableDeclaration(){

        //ASTVariableDecl requires a valid ASTIdentifier, ASTType and ASTExpressionNode
        ASTIdentifier identifier;
        ASTType type;
        ASTExpressionNode expression;

        currentToken = Lexer.getNextToken();
        identifier= parseIdentifier();

        currentToken = Lexer.getNextToken();
        //Check that identifier is followed by a colon
        if(currentToken.getType() != TokenType.TOK_Punctuation && currentToken.getLexeme().equals(":")){
            System.out.println("Error: colon (:) expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        type = parseType();

        currentToken = Lexer.getNextToken();
        //Check that type is followed by an assignment operator
        if(currentToken.getType() != TokenType.TOK_AssignmentOp){
            System.out.println("Error: Assignment operator (=) expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        expression = parseExpression();

        currentToken = Lexer.getNextToken();
        //Check that end of statement is present after expression
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(";"))){
            System.out.println("Error: End of statement ';' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        //Return ASTVariableDecl if no errors were found during parsing
        return new ASTVariableDecl(identifier, type, expression);
    }

    //Parses the print statement and returns its AST node equivalent
    private ASTPrintStatement parsePrintStatement(){

        //ASTPrintStatement requires a valid ASTExpressionNode
        ASTExpressionNode expression;

        currentToken = Lexer.getNextToken();
        expression = parseExpression();

        currentToken = Lexer.getNextToken();
        //Check that end of statement is present after expression
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(";"))){
            System.out.println("Error: End of statement ';' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        //Return ASTPrintStatement if no errors were found during parsing
        return new ASTPrintStatement(expression);
    }

    //Parses the return statement and returns its AST node equivalent
    private ASTReturnStatement parseReturnStatement(){

        //ASTReturnStatement requires a valid ASTExpressionNode
        ASTExpressionNode expression;

        currentToken = Lexer.getNextToken();
        expression = parseExpression();

        currentToken = Lexer.getNextToken();
        //Check that end of statement is present after expression
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(";"))){
            System.out.println("Error: End of statement ';' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        //Return ASTReturnStatement if no errors were found during parsing
        return new ASTReturnStatement(expression);
    }

    //Parses the if statement and returns its AST node equivalent
    private ASTIfStatement parseIfStatement(){

        //ASTIfStatement requires a valid ASTExpressionNode, an if ASTBlock and an else ASTBlock
        ASTExpressionNode expression;
        ASTBlock ifBlock;
        ASTBlock elseBlock = new ASTBlock(new ArrayList<>());

        currentToken = Lexer.getNextToken();
        //Check that the if keyword is followed by an open bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("("))){
            System.out.println("Error: Open bracket '(' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        expression = parseExpression();

        currentToken = Lexer.getNextToken();
        //Check that expression is followed by a closed bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(")"))){
            System.out.println("Error: Closed bracket ')' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        ifBlock = parseBlock();

        //Lookahead to check that if block is followed by an else keyword
        if(Lexer.lookAheadToken().getType() == TokenType.TOK_Keyword && Lexer.lookAheadToken().getLexeme().equals("else")){
            //Consume else
            currentToken = Lexer.getNextToken();

            currentToken = Lexer.getNextToken();
            elseBlock = parseBlock();

            //Return ASTIfStatement with a non-empty else block if no errors were found
            return new ASTIfStatement(expression, ifBlock, elseBlock);

        }else{
            //If else keyword doesn't exist, return ASTIfStatement with an empty else block if no errors were found
            //during parsing
            return new ASTIfStatement(expression, ifBlock, elseBlock);
        }
    }

    //Parses the for statement and returns its AST node equivalent
    private ASTForStatement parseForStatement(){

        //ASTForStatement requires a valid ASTExpressionNode and an ASTBlock
        //ASTVariableDecl and ASTAssignment are optional
        ASTVariableDecl variableDecl = null;
        ASTExpressionNode expression;
        ASTAssignment assignment = null;
        ASTBlock block;

        currentToken = Lexer.getNextToken();
        //Check that the for keyword is followed by an open bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("("))){
            System.out.println("Error: Open bracket '(' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();

        //Check if next token is a semicolon
        //If token is a semicolon, no variable declaration exists within for statement
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(";"))){

            //If token is not a semicolon, check for let keyword
            //If let keyword detected, parse variable declaration
            //Otherwise, display error
            if(currentToken.getType() == TokenType.TOK_Keyword && currentToken.getLexeme().equals("let")){
                variableDecl = parseVariableDeclaration();
            }else{
                System.out.println("Error: let keyword expected for variable declaration on line "+Lexer.programCurrentLine);
                exit(-1);
            }
        }

        currentToken = Lexer.getNextToken();
        expression = parseExpression();

        currentToken = Lexer.getNextToken();
        //Check that expression is followed by a semicolon
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(";"))){
            System.out.println("Error: Semicolon ';' expected after expression on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();

        //Check if next token is a semicolon
        //If token is a semicolon, no variable assignment exists within for statement
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(")"))){

            //If token is not a semicolon, check for identifier
            //If identifier detected, parse in for loop assignment statement
            //Otherwise, display error
            if(currentToken.getType() == TokenType.TOK_Identifier){
                assignment = parseAssignment(AssignmentType.INFORLOOP);
            }else{
                System.out.println("Error: identifier expected for assignment on line "+Lexer.programCurrentLine);
                exit(-1);
            }
        }

        currentToken = Lexer.getNextToken();
        block = parseBlock();

        //Return ASTForStatement if no errors were found
        return new ASTForStatement(variableDecl, expression, assignment, block);

    }

    //Parses the while statement and returns its AST node equivalent
    private ASTWhileStatement parseWhileStatement(){

        //ASTWhileStatement requires a valid ASTExpressionNode and ASTBlock
        ASTExpressionNode expression;
        ASTBlock block;

        currentToken = Lexer.getNextToken();
        //Check that the while keyword is followed by an open bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("("))){
            System.out.println("Error: Open bracket '(' expected for while statement on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        expression = parseExpression();

        currentToken = Lexer.getNextToken();
        //Check that expression is followed by a closed bracket bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(")"))){
            System.out.println("Error: Closed bracket ')' expected for while statement on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        block = parseBlock();

        //Return ASTWhileStatement if no errors were found
        return new ASTWhileStatement(expression, block);
    }

    //Parses the function declaration statement and returns its AST node equivalent
    private ASTFunctionDecl parseFunctionDeclaration(){

        //ASTFunctionDecl requires a valid ASTIdentifier, ASTFormalParams, ASTType and ASTBlock nodes
        ASTIdentifier identifier;
        ASTFormalParams formalParams;
        ASTType type;
        ASTBlock block;

        //Used to store a list of ASTFormalParam to be stored in ASTFormalParams
        ArrayList<ASTFormalParam> formalParamsList = new ArrayList<>();

        currentToken = Lexer.getNextToken();
        identifier = parseIdentifier();

        currentToken = Lexer.getNextToken();
        //Check that identifier is followed by an open bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("("))){
            System.out.println("Error: Open bracket '(' expected for function declaration on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        //Check if currentToken is a closed bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(")"))){

            //If not a closed bracket, populate formalParamsList by calling parseFormalParameters
            parseFormalParameters(formalParamsList);
            currentToken = Lexer.getNextToken();

            //Check that formal parameters are followed by a closed bracket
            if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(")"))){
                System.out.println("Error: Closed bracket ')' expected for function declaration on line "+Lexer.programCurrentLine);
                exit(-1);
            }
        }

        //Store formalParamsList in ASTFormalParams node object
        formalParams = new ASTFormalParams(formalParamsList);

        currentToken = Lexer.getNextToken();
        //Check that closed bracket is followed by a colon
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(":"))){
            System.out.println("Error: Colon ':' expected for function declaration on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        type = parseType();

        currentToken = Lexer.getNextToken();
        block = parseBlock();

        //Return ASTFunctionDecl if no errors were found
        return new ASTFunctionDecl(identifier, formalParams, type, block);
    }

    //Parses the formal parameters of a function
    private void parseFormalParameters(ArrayList<ASTFormalParam> formalParamsList){

        //Add ASTFormalParam to list of formal parameters
        formalParamsList.add(parseFormalParam());

        //Loop and check that every formal parameter is followed by a comma
        while (Lexer.lookAheadToken().getLexeme().equals(",")){
            //Consume comma
            currentToken = Lexer.getNextToken();

            //Check if comma is followed by a closed bracket
            if(Lexer.lookAheadToken().getLexeme().equals(")")){
                System.out.println("Error: Formal Parameter expected after comma ',' on line "+Lexer.programCurrentLine);
                exit(-1);
            }

            currentToken = Lexer.getNextToken();
            formalParamsList.add(parseFormalParam());
        }
    }

    //Parses the formal parameter of a function and returns its AST node equivalent
    private ASTFormalParam parseFormalParam(){

        //ASTFormalParam requires a valid ASTIdentifier and ASTType
        ASTIdentifier identifier;
        ASTType type;

        //Check that current token is an identifier
        if(currentToken.getType() == TokenType.TOK_Identifier){
            identifier = parseIdentifier();

            currentToken = Lexer.getNextToken();
            //Check if identifier is followed array brackets
            if(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("[")){

                //Get next token for closed bracket
                currentToken = Lexer.getNextToken();

                //Check that open square bracket is followed by closed bracket
                if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("]"))){
                    System.out.println("Error: Closed bracket ']' expected for formal array parameter on line "+Lexer.programCurrentLine);
                    exit(-1);
                }

                //Get next token following closed bracket
                currentToken = Lexer.getNextToken();
            }

            //Check that identifier is followed by a colon
            if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(":"))){
                System.out.println("Error: Semicolon ':' expected for formal parameter on line "+Lexer.programCurrentLine);
                exit(-1);
            }

            currentToken = Lexer.getNextToken();
            type = parseType();

            //Return ASTFormalParam if no errors were found
            return new ASTFormalParam(identifier, type);

        }else{
            System.out.println("Error: Identifier expected for formal parameter on line "+Lexer.programCurrentLine);
            exit(-1);
            return null;
        }
    }

    //Parses the assignment statement and returns its AST node equivalent
    private ASTAssignment parseAssignment(AssignmentType type){

        //ASTAssignment requires a valid ASTIdentifier and ASTExpressionNode
        ASTIdentifier identifier;
        ASTExpressionNode expression;

        identifier = parseIdentifier();

        currentToken = Lexer.getNextToken();
        //Check that identifier is followed by an assignment operator
        if(currentToken.getType() != TokenType.TOK_AssignmentOp){
            System.out.println("Error: assignment operator '=' in assignment on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        expression = parseExpression();

        currentToken = Lexer.getNextToken();
        if (type == AssignmentType.INLINE){

            //Check that expression is followed by an end of statement if assignment is in line
            if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(";"))){
                System.out.println("Error: Semicolon ';' expected on line "+Lexer.programCurrentLine);
                exit(-1);
            }

        }else if(type == AssignmentType.INFORLOOP){

            //Check that expression is followed by a closed bracket if assignment is in for loop
            if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(")"))){
                System.out.println("Error: Closed bracket ')' expected after assignment in for loop, on line "+Lexer.programCurrentLine);
                exit(-1);
            }
        }

        //Return ASTAssignment if no errors were found
        return new ASTAssignment(identifier, expression);
    }

    //Parses the block statement and returns its AST node equivalent
    private ASTBlock parseBlock(){

        //ASTBlock requires an array list of ASTStatementNode nodes. This list may be empty
        ArrayList<ASTStatementNode> blockStatements = new ArrayList<>();

        //Store block statement's beginning line
        int statementLine = Lexer.programCurrentLine;

        //Check if block starts with open curly bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("{"))){
            System.out.println("Error: Curly bracket '{' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        //Parse each statement within block until closed curly bracket is found or until EOF is reached
        while(!Lexer.lookAheadToken().getLexeme().equals("}")){
            currentToken = Lexer.getNextToken();

            if(currentToken.getType() != TokenType.TOK_EOF){
                blockStatements.add(parseStatement());
            }else{
                System.out.println("Error: Missing '}' for statement on line "+statementLine);
                exit(-1);
            }
        }

        //consume } bracket
        currentToken = Lexer.getNextToken();

        //Return ASTBlock if no errors were found
        return new ASTBlock(blockStatements);
    }

    //Parses identifier and returns its AST node equivalent
    private ASTIdentifier parseIdentifier(){

        //Check if current token is an identifier
        if(currentToken.getType() == TokenType.TOK_Identifier){

            //Return ASTIdentifier if token is identifier
            return new ASTIdentifier(currentToken.getLexeme());

        }else{
            System.out.println("Error: Identifier expected on line "+Lexer.programCurrentLine);
            exit(-1);
            return null;
        }
    }

    //Parses type and returns its AST node equivalent
    private ASTType parseType(){

        //Check if current token is a type token
        if(currentToken.getType() == TokenType.TOK_Type){

            //Return ASTType if token is a type token
            return new ASTType(currentToken.getLexeme());

        }else{
            System.out.println("Error: variable type expected on line "+Lexer.programCurrentLine);
            exit(-1);
            return null;
        }
    }

    //Parses expression and returns its AST node equivalent
    private ASTExpressionNode parseExpression(){
        ASTExpressionNode leftSimpleExpression;
        leftSimpleExpression = parseSimpleExpression();

        //Lookahead for operator
        if(Lexer.lookAheadToken().getType() == TokenType.TOK_RelationOp){

            //If operator found, store operator and parse right expression by recurring the parseExpression() function
            currentToken = Lexer.getNextToken();
            ASTRelationalOp relationalOp = new ASTRelationalOp(currentToken.getLexeme());
            currentToken = Lexer.getNextToken();
            ASTExpressionNode rightSimpleExpression = parseExpression();

            //Return ASTExpression with two operands and an operator
            return new ASTExpression(leftSimpleExpression, relationalOp, rightSimpleExpression);
        }else{

            //If operator not found, return single expression
            return leftSimpleExpression;
        }
    }

    //Parses simple expression and returns its AST node equivalent
    private ASTExpressionNode parseSimpleExpression(){
        ASTExpressionNode leftTerm;
        leftTerm = parseTerm();

        //Lookahead for operator
        if(Lexer.lookAheadToken().getType() == TokenType.TOK_AdditiveOp){

            //If operator found, store operator and parse right term by recurring the parseSimpleExpression()
            //function
            currentToken = Lexer.getNextToken();
            ASTAdditiveOp additiveOp = new ASTAdditiveOp(currentToken.getLexeme());

            currentToken = Lexer.getNextToken();
            ASTExpressionNode rightTerm = parseSimpleExpression();

            //Return ASTSimpleExpression with two operands and an operator
            return new ASTSimpleExpression(leftTerm, additiveOp, rightTerm);
        }else{
            //If operator not found, return single term
            return leftTerm;
        }
    }

    //Parses term and returns its AST node equivalent
    private ASTExpressionNode parseTerm(){
        ASTExpressionNode leftFactor;
        leftFactor = parseFactor();

        //Lookahead for operator
        if(Lexer.lookAheadToken().getType() == TokenType.TOK_MultiplicativeOp){

            //If operator found, store operator and parse right factor by recurring the parseTerm() function
            currentToken = Lexer.getNextToken();
            ASTMultiplicativeOp multiplicativeOp = new ASTMultiplicativeOp(currentToken.getLexeme());

            currentToken = Lexer.getNextToken();
            ASTExpressionNode rightFactor = parseTerm();

            //Return ASTTerm with two operands and an operator
            return new ASTTerm(leftFactor, multiplicativeOp, rightFactor);
        }else{
            //If operator not found, return single factor
            return leftFactor;
        }
    }

    //Parses factor and returns its AST node equivalent
    private ASTExpressionNode parseFactor(){
            //parseBooleanLit
        if(currentToken.getType() == TokenType.TOK_BooleanLit){
            boolean value = Boolean.parseBoolean(currentToken.getLexeme());
            return new ASTBooleanLiteral(value);

            //parseIntLit
        }else if(currentToken.getType() == TokenType.TOK_IntegerLit){
            int value = Integer.parseInt(currentToken.getLexeme());
            return new ASTIntegerLiteral(value);

            //parseFloatLit
        }else if(currentToken.getType() == TokenType.TOK_FloatLit){
            float value = Float.parseFloat(currentToken.getLexeme());
            return new ASTFloatLiteral(value);

            //parseCharLit
        }else if(currentToken.getType() == TokenType.TOK_CharLit){
            String lexemeWithoutSingleQuotes = currentToken.getLexeme().replaceAll("'","");
            char value = lexemeWithoutSingleQuotes.charAt(0);
            return new ASTCharLiteral(value);

            //parseIdentifier or FunctionalCall or ArrayCall
        }else if(currentToken.getType() == TokenType.TOK_Identifier){
            if(Lexer.lookAheadToken().getLexeme().equals("(")) {
                return parseFunctionCall();
            }else if(Lexer.lookAheadToken().getLexeme().equals("[")){
                return parseArrayCall();
            }else{
                return new ASTIdentifier(currentToken.getLexeme());
            }

            //parseSubExpression
        }else if(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("(")){
            return parseSubExpression();

            //parseUnary
        }else if (currentToken.getType() == TokenType.TOK_Keyword && currentToken.getLexeme().equals("not") ||
                currentToken.getType() == TokenType.TOK_AdditiveOp && currentToken.getLexeme().equals("-")){
            return parseUnary();

        }else{
            System.out.println("Error: factor expected on line "+Lexer.programCurrentLine);
            exit(-1);
            return null;
        }
    }

    //Parses function call and returns its AST node equivalent
    private ASTExpressionNode parseFunctionCall(){

        //ASTFunctionCall requires a valid ASTIdentifier and valid ASTActualParams
        ASTIdentifier identifier;
        ASTActualParams actualParams;

        //List to store ASTExpressionNode nodes for the actual parameters within the function call
        ArrayList<ASTExpressionNode> expressionParams = new ArrayList<>();

        identifier = new ASTIdentifier(currentToken.getLexeme());

        currentToken = Lexer.getNextToken();
        //Check that identifier is followed by open bracket
        if(currentToken.getType() != TokenType.TOK_Punctuation && currentToken.getLexeme().equals("(")){
            System.out.println("Error: Open bracket ( expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        //Check if open bracket is followed by closed bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(")"))){

            //If no closed bracket was detected, parseActualParams() is called to populate expressionParams
            parseActualParams(expressionParams);

            currentToken = Lexer.getNextToken();
            //Check that actual parameters is followed by closed bracket
            if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(")"))){
                System.out.println("Error: Closed bracket ) expected on line "+Lexer.programCurrentLine);
                exit(-1);
            }
        }

        //Create ASTActualParams node using expressionParams list
        actualParams = new ASTActualParams(expressionParams);

        //Return ASTFunctionCall if no errors were found
        return new ASTFunctionCall(identifier, actualParams);
    }

    //Parses actual parameters of a function
    private void parseActualParams(ArrayList<ASTExpressionNode> expressionParams){

        //Add actual parameter to list of actual parameters
        expressionParams.add(parseExpression());

        //Check if actual parameter is followed by a comma
        if(Lexer.lookAheadToken().getLexeme().equals(",")){
            currentToken = Lexer.getNextToken();

            //If followed by comma, check that the next token isn't a closed bracket
            if(Lexer.lookAheadToken().getLexeme().equals(")")){
                System.out.println("Error: actual parameter expected after comma (,) on line "+Lexer.programCurrentLine);
                exit(-1);
            }

            currentToken = Lexer.getNextToken();
            //Recurse function to add more actual parameters to the expressionParams list
            parseActualParams(expressionParams);
        }
    }

    //Parses sub expression and returns its AST node equivalent
    private ASTExpressionNode parseSubExpression(){

        //ASTSubExpression requires a valid expression
        ASTExpressionNode expression;

        currentToken = Lexer.getNextToken();
        expression = parseExpression();

        currentToken = Lexer.getNextToken();
        //Check that expression is followed by a closed bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(")"))){
            System.out.println("Error: Closed bracket ) expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        //Return ASTSubExpression is no errors were found
        return new ASTSubExpression(expression);
    }

    //Parses unary expression and returns its AST node equivalent
    private ASTExpressionNode parseUnary(){

        //ASTUnary requires a valid ASTUnaryOp and ASTExpressionNode
        ASTUnaryOp unaryOp;
        ASTExpressionNode expression;

        unaryOp = new ASTUnaryOp(currentToken.getLexeme());

        currentToken = Lexer.getNextToken();
        expression = parseExpression();

        //Return ASTUnary is no errors were found
        return new ASTUnary(unaryOp, expression);
    }

    //---------------------------------------------SmallLang V2 Functions-----------------------------------------------
    //Determines whether the declaration is a variable declaration or an array declaration
    private ASTStatementNode parseDeclaration(){

        ASTIdentifier identifier;
        Token lookAhead;

        currentToken = Lexer.getNextToken();
        identifier= parseIdentifier();

        lookAhead = Lexer.lookAheadToken();
        if(lookAhead.getLexeme().equals(":")){
            return parseVariableDeclaration(identifier);
        }else if(lookAhead.getLexeme().equals("[")){
            return parseArrayDeclaration(identifier);
        }else{
            System.out.println("Error: invalid declaration made on line "+Lexer.programCurrentLine);
            exit(-1);
            return null;
        }
    }

    //Parses the variable declaration statement and returns its AST node equivalent
    private ASTVariableDecl parseVariableDeclaration(ASTIdentifier identifier){

        //ASTVariableDecl requires a valid ASTIdentifier, ASTType and ASTExpressionNode
        ASTType type;
        ASTExpressionNode expression;

        currentToken = Lexer.getNextToken();
        //Check that identifier is followed by a colon
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(":"))){
            System.out.println("Error: colon (:) expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        type = parseType();

        currentToken = Lexer.getNextToken();
        //Check that type is followed by an assignment operator
        if(currentToken.getType() != TokenType.TOK_AssignmentOp){
            System.out.println("Error: Assignment operator (=) expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        expression = parseExpression();

        currentToken = Lexer.getNextToken();
        //Check that end of statement is present after expression
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(";"))){
            System.out.println("Error: End of statement ';' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        //Return ASTVariableDecl if no errors were found during parsing
        return new ASTVariableDecl(identifier, type, expression);
    }

    //Parses the array declaration statement and returns its AST node equivalent
    private ASTArrayDecl parseArrayDeclaration(ASTIdentifier identifier){

        //ASTArrayDecl requires a valid ASTIdentifier, ASTIntegerLiteral, and ASTType. ASTArrayElements is optional
        ASTIntegerLiteral arraySize = null;
        ASTType type;
        ASTArrayElements arrayElements = null;

        //boolean to make sure that if arraySize wasn't initialised, it is initialised from size of array elements list.
        boolean arraySizeInitialised = false;

        currentToken = Lexer.getNextToken();
        //Check that identifier is followed by an open bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("["))){
            System.out.println("Error: open bracket '[' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        //Get closed bracket token or integer literal token (array size)
        currentToken = Lexer.getNextToken();
            //If token is an integer literal, initialise size of array
        if(currentToken.getType() == TokenType.TOK_IntegerLit){
            int value = Integer.parseInt(currentToken.getLexeme());
            arraySize = new ASTIntegerLiteral(value);
            arraySizeInitialised = true;
            //Otherwise check that token is the array's closed bracket
        }else{
            if(!currentToken.getLexeme().equals("]")){
                System.out.println("Error: Proper array declaration [] syntax expected on line "+Lexer.programCurrentLine);
                exit(-1);
            }
        }

        //Check if array size was followed by a closed bracket
        if(arraySizeInitialised){
            currentToken = Lexer.getNextToken();
            if(!currentToken.getLexeme().equals("]")){
                System.out.println("Error: closed bracket ']' expected on line "+Lexer.programCurrentLine);
                exit(-1);
            }
        }

        currentToken = Lexer.getNextToken();
        //Check that closed bracket is followed by a colon
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(":"))){
            System.out.println("Error: colon ':' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        type = parseType();

            //Check if array is assigned to an element list
        if(Lexer.lookAheadToken().getType() == TokenType.TOK_AssignmentOp){

            //Consume assignment operator
            currentToken = Lexer.getNextToken();

            currentToken = Lexer.getNextToken();
            arrayElements = parseArrayElements();

            //If array size was not initialised, initialise it to size of elements list
            if(!arraySizeInitialised){
                int value = arrayElements.actualElements.size();
                arraySize = new ASTIntegerLiteral(value);
            }

            //If assignment not done, check that end of statement is present
        }else if(Lexer.lookAheadToken().getLexeme().equals(";")){

            //Consume end of statement
            currentToken = Lexer.getNextToken();

            //Check if array size was initialised before since no element list was assigned
            if(arraySizeInitialised){
                //Initialise arrays elements with an empty list
                ArrayList<ASTExpressionNode> actualElements = new ArrayList<>();
                arrayElements = new ASTArrayElements(actualElements);

                return new ASTArrayDecl(identifier, arraySize, type, arrayElements);
            }else{
                System.out.println("Error: Array size was not defined on line "+Lexer.programCurrentLine);
                exit(-1);
            }

        }else{
            System.out.println("Error: Assignment operator '=' or end of statement ';' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        //Check that end of statement is present after expression
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(";"))){
            System.out.println("Error: End of statement ';' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        return new ASTArrayDecl(identifier, arraySize, type, arrayElements);
    }

    private ASTArrayElements parseArrayElements(){

        ArrayList<ASTExpressionNode> actualElements = new ArrayList<>();

        //Check that array assignment operator is followed by open curly bracket of list
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("{"))){
            System.out.println("Error: Beginning of list of elements '{' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        //Add array element to list of array elements
        actualElements.add(parseExpression());

        //Loop until no more elements remain in list
        while (Lexer.lookAheadToken().getLexeme().equals(",")){
            //Consume comma
            currentToken = Lexer.getNextToken();

            //Check if comma is followed by a closed curly bracket
            if(Lexer.lookAheadToken().getLexeme().equals("}")){
                System.out.println("Error: Array element expected after comma ',' on line "+Lexer.programCurrentLine);
                exit(-1);
            }

            currentToken = Lexer.getNextToken();
            actualElements.add(parseExpression());
        }

        currentToken = Lexer.getNextToken();
        //Check that element list is followed by closed curly bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("}"))){
            System.out.println("Error: End of elements list '}' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        return new ASTArrayElements(actualElements);
    }

    private ASTArrayAssignment parseArrayAssignment(){

        //ASTArrayDecl requires a valid ASTIdentifier, ASTIntegerLiteral, and ASTExpressionNode
        ASTIdentifier identifier;
        ASTIntegerLiteral arrayIndex;
        ASTExpressionNode expression;

        identifier = parseIdentifier();

        currentToken = Lexer.getNextToken();
        //Check that identifier is followed by open square bracket
        if(currentToken.getLexeme().equals("[")){
            System.out.println("Error: '[' expected in array assignment on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        //Check that array index was inputted
        if(currentToken.getType() != TokenType.TOK_IntegerLit){
            System.out.println("Error: array index expected in array assignment on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        int index = Integer.parseInt(currentToken.getLexeme());
        arrayIndex = new ASTIntegerLiteral(index);

        currentToken = Lexer.getNextToken();
        //Check that array index is followed by closed square bracket
        if(currentToken.getLexeme().equals("]")){
            System.out.println("Error: ']' expected in array assignment on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        //Check that assignment operator exists
        if(currentToken.getType() != TokenType.TOK_AssignmentOp){
            System.out.println("Error: assignment operator '=' missing in array assignment on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        expression = parseExpression();

        currentToken = Lexer.getNextToken();
        //Check that end of statement is present after expression
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals(";"))){
            System.out.println("Error: End of statement ';' expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        return new ASTArrayAssignment(identifier, arrayIndex, expression);
    }

    private ASTArrayCall parseArrayCall(){

        //ASTArrayDecl requires a valid ASTIdentifier and ASTIntegerLiteral
        ASTIdentifier identifier;
        ASTIntegerLiteral arrayIndex;

        identifier = parseIdentifier();

        currentToken = Lexer.getNextToken();
        //Check that identifier is followed by open square bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("["))){
            System.out.println("Error: '[' of array call expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        currentToken = Lexer.getNextToken();
        //Check that array index was inputted
        if(currentToken.getType() != TokenType.TOK_IntegerLit){
            System.out.println("Error: array index expected in array call on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        int index = Integer.parseInt(currentToken.getLexeme());
        arrayIndex = new ASTIntegerLiteral(index);

        currentToken = Lexer.getNextToken();
        //Check that array index is followed by closed square bracket
        if(!(currentToken.getType() == TokenType.TOK_Punctuation && currentToken.getLexeme().equals("]"))){
            System.out.println("Error: ']' of array call expected on line "+Lexer.programCurrentLine);
            exit(-1);
        }

        return new ASTArrayCall(identifier, arrayIndex);
    }
}
