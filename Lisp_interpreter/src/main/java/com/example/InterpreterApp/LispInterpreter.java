package com.example.InterpreterApp;

import com.example.parser.Parser;
import com.example.lexer.Lexer;
import com.example.lexer.Token;
import java.util.Scanner;
import java.util.List;
import com.example.eval.EvaluationVisitor;
import com.example.ast.*;

public class LispInterpreter {
    public static void main(String[] args){
        System.out.println("Lisp Interpreter opened");
        System.out.println("Query here. Type 'exit' to quit");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(">");
            String input = scanner.nextLine();
            if (input.equals("exit")){
                System.out.println("Interpreter closed");
                break;
            }

            try {
                Lexer lexer = new Lexer(input);
                List<Token> tokens = lexer.tokenize();

                Parser parser = new Parser(tokens);
                Node ast = parser.parseExpression();

                EvaluationVisitor evaluator = new EvaluationVisitor();
                int result = (int) ast.accept(evaluator);

                System.out.println(result);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
