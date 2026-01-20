package com.example.parser;

import com.example.ast.Node;
import com.example.ast.*;
import com.example.lexer.Token;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private List<Token> tokens;
    private int current;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.current = 0;
    }


    public Node parseExpression() {
        if (current >= tokens.size()) return null;

        Token token = tokens.get(current);
        if (token.getType().equals("NUMBER")) {
            current++;
            return new NumberNode(Integer.parseInt(token.getToken()));
        }

        if (token.getType().equals("SYMBOL")) {
            current++;
            return new SymbolNode(token.getToken());
        }

        if (token.getType().equals("LPAREN")) {
            current++;

            Token op = tokens.get(current);
            if (!op.getType().equals("SYMBOL")) {
                throw new RuntimeException("Excepted operator after '('. ");
            }

            String operator = op.getToken();
            current++;

            List<Node> children = new ArrayList<>();

            while (!tokens.get(current).getType().equals("RPAREN")) {
                children.add(parseExpression());
            }

            current++;
            return new ListNode(operator, children);
        }
        throw new RuntimeException("Unexpected token: "+ token.getToken());
    }

}
