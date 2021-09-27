package Lexer;

import java.util.Arrays;

//Class used to initialise the lexer dfa and provide the dfa transition function
public class States {

    //DFA Transition function
    //_|[A-Z]|[a-z], [0-9], ., +|-, *, /, =, >, <, {|}|(|)|,|;|:|[|], \n, EOF, \'
    static int [][] dfaTransitionFunction = {
            {1, 2, -1, 16, 17, 10, 7, 6, 5, 9, 0, 18, 19},  //S0
            {1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S1
            {-1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S2
            {-1 ,4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S3
            {-1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S4
            {-1, -1, -1, -1, -1, -1, 8, 8, -1, -1, -1, -1, -1},  //S5
            {-1, -1, -1, -1, -1, -1, 8, -1, -1, -1, -1, -1, -1}, //S6
            {-1, -1, -1, -1, -1, -1, 8, -1, -1, -1, -1, -1, -1}, //S7
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S8
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S9
            {-1, -1, -1, -1, 13, 11, -1, -1, -1, -1, -1, -1, -1},  //S10
            {11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, -1, 11},  //S11
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S12
            {13, 13, 13, 13, 14, 13, 13, 13, 13, 13, 13, -1, 13},  //S13
            {-1, -1, -1, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1},  //S14
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S15
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S16
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S17
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S18

            {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, -1, -1, -1},  //S19
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21},  //S20
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},  //S21
    };

    //Function to initialise the all DFA states
    public static State [] initialiseStates(){

        //Stores the total number of states
        int numStates = 22;

        //Array of states
        State [] states = new State[numStates];

        //Array of all states that are final
        int [] finalStateIds = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 18,21};

        //Create state objects
        states[0] = new State();
        states[1] = new State();
        states[2] = new State();
        states[3] = new State();
        states[4] = new State();
        states[5] = new State();
        states[6] = new State();
        states[7] = new State();
        states[8] = new State();
        states[9] = new State();
        states[10] = new State();
        states[11] = new State();
        states[12] = new State();
        states[13] = new State();
        states[14] = new State();
        states[15] = new State();
        states[16] = new State();
        states[17] = new State();
        states[18] = new State();

        //SmallLangV2 states for Char Literal
        states[19] = new State();
        states[20] = new State();
        states[21] = new State();

        //Assign all final states
        for (int i = 0; i < numStates; i++) {
            int finalI = i;
            states[i].setFinalState(Arrays.stream(finalStateIds).anyMatch(id -> id == finalI));
        }

        //Set token type of each state to be returned
        states[0].setToken(TokenType.TOK_Error);
        states[1].setToken(TokenType.TOK_Identifier); // Can also return TOK_Keyword if lexeme is a keyword
        states[2].setToken(TokenType.TOK_IntegerLit);
        states[3].setToken(TokenType.TOK_Error);
        states[4].setToken(TokenType.TOK_FloatLit);
        states[5].setToken(TokenType.TOK_RelationOp);
        states[6].setToken(TokenType.TOK_RelationOp);
        states[7].setToken(TokenType.TOK_AssignmentOp);
        states[8].setToken(TokenType.TOK_RelationOp);
        states[9].setToken(TokenType.TOK_Punctuation);
        states[10].setToken(TokenType.TOK_MultiplicativeOp);
        states[11].setToken(TokenType.TOK_Comment);
        states[12].setToken(TokenType.TOK_Comment);
        states[13].setToken(TokenType.TOK_Error);
        states[14].setToken(TokenType.TOK_Error);
        states[15].setToken(TokenType.TOK_Comment);
        states[16].setToken(TokenType.TOK_AdditiveOp);
        states[17].setToken(TokenType.TOK_MultiplicativeOp);
        states[18].setToken(TokenType.TOK_EOF);

        states[19].setToken(TokenType.TOK_Error);
        states[20].setToken(TokenType.TOK_Error);
        states[21].setToken(TokenType.TOK_CharLit);

        return states;
    }

    //Function to return the column index of the passed character within the transition function
    private static int alphabetIndex(char currentChar){
        if( currentChar == '_' || Character.isLetter(currentChar)){
            return 0;
        }else if(Character.isDigit(currentChar)){
            return 1;
        }else if(currentChar == '.'){
            return 2;
        }else if(currentChar == '+' || currentChar == '-'){
            return 3;
        }else if(currentChar == '*'){
            return 4;
        }else if(currentChar == '/'){
            return 5;
        }else if(currentChar == '='){
            return 6;
        }else if(currentChar == '>'){
            return 7;
        }else if(currentChar == '<'){
            return 8;
        }else if(currentChar == '{' || currentChar == '}' || currentChar == '(' || currentChar == ')' || currentChar == ','
                || currentChar == ';' || currentChar == ':' || currentChar == '[' || currentChar == ']'){
            return 9;
        }else if(currentChar == '\n') {
            return 10;
        }else if(currentChar == '\'') {
                return 12;
        }else{
            //If EOF reached
            return 11;
        }
    }

    //Function to return the next state id given the current state and character used for transition
    public static int nextState(int currentState, char currentChar){
        return dfaTransitionFunction[currentState][alphabetIndex(currentChar)];
    }

}
