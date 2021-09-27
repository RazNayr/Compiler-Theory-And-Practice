package Lexer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Lexer {

    //Stores all separate characters found in program file
    private static ArrayList<Character> programChars = new ArrayList<>();

    //Stores all states of the DFA
    private static State [] states;

    //Points to the next character index within the programChars list
    private static int programCharIndex = 0;

    //Stores the line at which the current character is being retrieved. Used in the parser when displaying errors
    public static int programCurrentLine = 1;

    //Function used to read program file and split it into characters. These are appended in programChars list.
    //After all characters are appended, the states of the DFa are initialised
    public static void readProgram(String programPath){

        try{
            File programFile = new File(programPath);
            FileReader programReader = new FileReader(programFile);
            BufferedReader bufferedReader = new BufferedReader(programReader);

            String programLine;

            while( (programLine = bufferedReader.readLine()) != null){
                for (char character: programLine.toCharArray()) {
                    programChars.add(character);
                }
                programChars.add('\n');
            }

            //Ensure that any extra new lines in file, after code, are removed.
            int newLinesToRemove = 0;
            for(int i = programChars.size()-1; i >= 0; i--){
                if(programChars.get(i) == '\n'){
                    newLinesToRemove++;
                }else{
                    break;
                }
            }

            //Remove extra new line character at the end of file.
            while(newLinesToRemove != 0){
                programChars.remove(programChars.size()-1);
                newLinesToRemove--;
            }

            //Once characters are saved in list, initialise DFA states
            states = States.initialiseStates();

            bufferedReader.close();
            programReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: Program file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error: IO error when reading file.");
            e.printStackTrace();
        }
    }

    //Checks whether the passed lexeme is a keyword or not
    private static boolean isKeyword(String lexeme){

        String [] keywords = {
                //TOK_Type
                "float","int","bool","char","auto",
                //TOK_BooleanLit
                "true","false",
                //TOK_MultiplicativeOp
                "and",
                //TOK_AdditiveOp
                "or",
                //TOK_Keyword
                "not", "let", "print", "return",  "if", "else", "for", "while", "ff",
        };

        return Arrays.asList(keywords).contains(lexeme);
    }

    //Function to return the next token
    private static Token getToken(){

        //Stores the current state (Starts at the root state which is 0)
        int currentState = 0;

        //Stores the next state to transition to
        int nextState = 0;

        //Stores the current character being processed
        char currentChar;

        //Stores accumulated characters which make up the lexeme
        StringBuilder lexemeBuilder = new StringBuilder();

        //Stack to store ids of the visited states
        Stack<Integer> visitedStates = new Stack<>();

        //Push start state in visited states
        visitedStates.push(currentState);

        do{
            //Check if programCharIndex is the last element in the character list
            if(programCharIndex == (programChars.size())){
                //If last element, assign currentChar a MIN_VALUE
                currentChar = Character.MIN_VALUE;

            }else{
                //If not last element, assign currentChar to the character in the list at the programCharIndex
                currentChar = programChars.get(programCharIndex);

                //Increment to point to next character
                programCharIndex++;
            }

            //Check if character is a single space or tab
            if(currentChar == ' ' || currentChar == '\t'){

                //If the state is currently 1 (final state) and the accumulated lexeme is a keyword, return token
                if(currentState == 1 && isKeyword(lexemeBuilder.toString())) {
                    String lexeme = lexemeBuilder.toString();
                    TokenType tokenType;

                    if (lexeme.equals("float") || lexeme.equals("int") || lexeme.equals("bool")
                            || lexeme.equals("auto") || lexeme.equals("char")) {
                        tokenType = TokenType.TOK_Type;
                    } else if (lexeme.equals("true") || lexeme.equals("false")) {
                        tokenType = TokenType.TOK_BooleanLit;
                    } else if (lexeme.equals("and")) {
                        tokenType = TokenType.TOK_MultiplicativeOp;
                    } else if (lexeme.equals("or")) {
                        tokenType = TokenType.TOK_AdditiveOp;
                    } else {
                        tokenType = TokenType.TOK_Keyword;
                    }

                    return new Token(tokenType, lexeme);

                }else{
                    continue;
                }

                //Check if character is a new line character
            }else if(currentChar == '\n'){

                //Check if currentState is equal to 11 or 13
                if(!(currentState == 11 || currentState == 13)){

                    //Check if current state is 9 and if the lexeme is equal to { , } or ;
                    //If so, return punctuation token since new line was detected after it
                    //Done to ensure that the parser displays the correct line when an error is shown
                    if(currentState == 9 && (lexemeBuilder.toString().equals("{") || lexemeBuilder.toString().equals("}") || lexemeBuilder.toString().equals(";"))) {
                        String lexeme = lexemeBuilder.toString();
                        TokenType tokenType = TokenType.TOK_Punctuation;

                        //Decremented so that when next token is needed, the first character would be a new line and so,
                        //the programCurrentLine could be incremented to account for the new line
                        programCharIndex--;
                        return new Token(tokenType, lexeme);
                    }

                    //Increment programCurrentLine to account for the newline character
                    programCurrentLine++;

                    //Re-loop to get the next character and skip any following code
                    continue;

                }else{
                    //Increment programCurrentLine to account for the newline character
                    programCurrentLine++;
                }
            }

            //Update nextState with the new state ID after transitioning
            nextState = States.nextState(currentState, currentChar);

            //Check if the next state is -1 (No transition could be made from the current state when given currentChar)
            if(nextState != -1){

                //If nextState is a final state, clear visited states since no account of previous final states needs
                //to be saved
                if (states[nextState].isFinalState){
                    visitedStates.clear();
                }

                //Append currentChar which lead to a valid transition to the lexemeBuilder
                lexemeBuilder.append(currentChar);

                //Push nextState to the stack of visited states
                visitedStates.push(nextState);

                //Update current state to next state id to account for transition
                currentState = nextState;

            }else{
                //If nextState is invalid, decrement programCharIndex so that current character doesn't get consumed
                //and lost. By doing this, it is assured that when getting the next token, search starts from the
                //unconsumed character
                programCharIndex--;
            }

            //Loop again if nextState is valid and if end of character list not yet reached
        }while(nextState != -1 && programCharIndex < programChars.size());

        //Loop until current state is a final state or until stack of visited states is empty
        while( !states[currentState].isFinalState && !visitedStates.empty()){

            //Pop state from visited states since not a final state
            visitedStates.pop();

            if(!visitedStates.empty()){
                //Decrement character index to not lose any characters
                programCharIndex--;

                //Delete character from accumulated string builder
                lexemeBuilder.deleteCharAt(lexemeBuilder.length() - 1);

                //Update current state to be equal to the state id at the top of the visitedStates stack
                currentState = visitedStates.peek();
            }
        }

            //Check if current state is a final state
        if(states[currentState].isFinalState){

            //Return the necessary token
            if(currentState == 1 && isKeyword(lexemeBuilder.toString())) {
                String lexeme = lexemeBuilder.toString();
                TokenType tokenType;

                if (lexeme.equals("float") || lexeme.equals("int") || lexeme.equals("bool") || lexeme.equals("auto")
                        || lexeme.equals("char")) {
                    tokenType = TokenType.TOK_Type;
                } else if (lexeme.equals("true") || lexeme.equals("false")) {
                    tokenType = TokenType.TOK_BooleanLit;
                } else if (lexeme.equals("and")) {
                    tokenType = TokenType.TOK_MultiplicativeOp;
                } else if (lexeme.equals("or")) {
                    tokenType = TokenType.TOK_AdditiveOp;
                } else {
                    tokenType = TokenType.TOK_Keyword;
                }

                return new Token(tokenType, lexeme);
            }else{
                String lexeme = lexemeBuilder.toString();

                //Get token type from type defined by the final state
                TokenType tokenType = states[currentState].stateToken;

                return new Token(tokenType, lexeme);
            }

            //If not a final state, display error
        }else{
            System.out.println("Error: Lexical Error in line "+programCurrentLine);
            System.exit(-1);
            return null;
        }
    }

    //Function used by the parser to get the next valid token
    public static Token getNextToken(){
        Token nextToken = getToken();

        //Loop until token is not of type comment
        while (nextToken.tokenType == TokenType.TOK_Comment){
            nextToken = getToken();
        }

        return nextToken;
    }

    //Function used by the parser to peek the next token
    public static Token lookAheadToken(){
        int previousCharIndex = programCharIndex;
        int previousLine = programCurrentLine;

        Token lookAheadToken = getNextToken();

        programCharIndex = previousCharIndex;
        programCurrentLine = previousLine;

        return lookAheadToken;
    }
}