import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

import ANTLR.SmallLangLexer;
import ANTLR.SmallLangParser;
import ANTLRV2.SmallLangV2Lexer;
import ANTLRV2.SmallLangV2Parser;
import Parser.AST.ASTProgram;
import Visitors.*;
import org.antlr.v4.runtime.CharStream;

public class MainANTLR {
    public static void main(String[] args) {

        try{
            //Get file path for chosen SmallLang program
            String programPath = programChoice();
            int grammarChoice = grammarChoice();

                //Parse SmallLang grammar
            if(grammarChoice == 1){
                CharStream cs = fromFileName(programPath);
                SmallLangLexer lexer = new SmallLangLexer(cs);

                org.antlr.v4.runtime.CommonTokenStream tokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
                SmallLangParser parser = new SmallLangParser(tokens);

                SmallLangParser.ProgramContext rootContext = parser.program();

                VisitorParseTreeToAst visitorConverter = new VisitorParseTreeToAst();
                ASTProgram astRootNode = visitorConverter.visitProgram(rootContext);

                //New visitor to visit the AST and display its XML representation
                VisitorAstToXml visitorAstToXml = new VisitorAstToXml();
                visitorAstToXml.visitAST(astRootNode);

                //New visitor to visit the AST and carry out semantic analysis on it
                VisitorSemanticAnalysis semanticAnalyser = new VisitorSemanticAnalysis();
                semanticAnalyser.visitAST(astRootNode);

                //New visitor to visit the AST and carry out interpreter execution
                VisitorInterpreterExecution interpreter = new VisitorInterpreterExecution();
                interpreter.visitAST(astRootNode);

                //Parse SmallLangV2 grammar
            }else{
                CharStream cs = fromFileName(programPath);
                SmallLangV2Lexer lexer = new SmallLangV2Lexer(cs);

                org.antlr.v4.runtime.CommonTokenStream tokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
                SmallLangV2Parser parser = new SmallLangV2Parser(tokens);

                SmallLangV2Parser.ProgramContext rootContext = parser.program();

                VisitorParseTreeV2toAst visitorConverterV2 = new VisitorParseTreeV2toAst();
                ASTProgram astRootNode = visitorConverterV2.visitProgram(rootContext);

                //New visitor to visit the AST and display its XML representation
                VisitorAstToXml visitorAstToXml = new VisitorAstToXml();
                visitorAstToXml.visitAST(astRootNode);

                //New visitor to visit the AST and carry out semantic analysis on it
                VisitorSemanticAnalysis semanticAnalyser = new VisitorSemanticAnalysis();
                semanticAnalyser.visitAST(astRootNode);

                //New visitor to visit the AST and carry out interpreter execution
                VisitorInterpreterExecution interpreter = new VisitorInterpreterExecution();
                interpreter.visitAST(astRootNode);
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    //Used to show user all available programs to choose from.
    //Returns the path of the program the user chose.
    private static String programChoice(){

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

    private static int grammarChoice(){

        Scanner in = new Scanner(System.in);
        int userChoice;

        System.out.println("Available Grammars");
        System.out.println("1. SmallLang");
        System.out.println("2. SmallLangV2");
        System.out.print("\nInput grammar to parse: ");
        userChoice = in.nextInt();

        while (!(userChoice>0 && userChoice<=2)){
            System.out.print("\nInvalid Input\nPlease choose a valid grammar to parse: ");
            userChoice = in.nextInt();
        }

        return userChoice;
    }
}
