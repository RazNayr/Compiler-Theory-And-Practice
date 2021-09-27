import Lexer.*;
import Parser.AST.ASTProgram;
import Parser.Parser;
import Visitors.VisitorAstToXml;
import Visitors.VisitorInterpreterExecution;
import Visitors.VisitorSemanticAnalysis;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Get file path for chosen SmallLang program
        String programPath = programChoice();

        if(programPath != null){

            //Read program file and initialise array of characters and states of automaton
            Lexer.readProgram(programPath);

            //New parser object to parse the program and return the AST's root node
            Parser parser = new Parser();
            ASTProgram rootNode = parser.parseProgram();

            //New visitor to visit the AST and display its XML representation
            VisitorAstToXml visitorAstToXml = new VisitorAstToXml();
            visitorAstToXml.visitAST(rootNode);

            //New visitor to visit the AST and carry out semantic analysis on it
            VisitorSemanticAnalysis semanticAnalyser = new VisitorSemanticAnalysis();
            semanticAnalyser.visitAST(rootNode);

            //New visitor to visit the AST and carry out interpreter execution
            VisitorInterpreterExecution interpreter = new VisitorInterpreterExecution();
            interpreter.visitAST(rootNode);
        }

    }

    //Used to show user all available programs to choose from.
    //Returns the path of the program the user chose.
    public static String programChoice(){

        String programPath = "SmallLangV2Programs/";
        File programDirectory = new File("SmallLangV2Programs");
        Scanner in = new Scanner(System.in);
        int fileCount = 0;

        System.out.println("SmallLang V2 Programs:");
        for (final File fileEntry : programDirectory.listFiles()) {
            fileCount++;
            System.out.println(fileCount+". "+fileEntry.getName());
        }

        if(fileCount > 0){
            System.out.print("\nPlease choose a program to run by file number: ");
            int userChoice = in.nextInt();

            while (!(userChoice>0 && userChoice<=fileCount)){
                System.out.print("\nInvalid Input\nPlease choose a program to run by file number: ");
                userChoice = in.nextInt();
            }

            for (final File fileEntry : programDirectory.listFiles()) {
                if(userChoice == 1){
                    programPath += fileEntry.getName();
                    break;
                }else{
                    userChoice--;
                }
            }

            return programPath;

        }else{
            System.out.println("No programs exist within SmallLangPrograms directory");
            return null;
        }
    }
}
