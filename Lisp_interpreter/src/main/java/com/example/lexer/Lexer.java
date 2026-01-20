package com.example.lexer;

import java.util.ArrayList;
import java.util.List;
public class Lexer {

    private final String source;
    private final List<Token> Tokens;


    public Lexer(String source){
        this.source = source;
        this.Tokens = new ArrayList<>();
    }

    public List<Token> tokenize(){
        //to do
        for (int i=0; i< source.length();i++){
            char c = source.charAt(i);

            if (c == ' '|| c =='\t' || c == '\n'){
                continue;
            }

            if ( c == '(') {
                Tokens.add(new Token("LPAREN", "("));
            }else if (c == ')'){
                Tokens.add(new Token("RPAREN", ")"));
            }
            else if (Character.isDigit(c)){
                String number = ""+c;

                while (i+1 < source.length() && Character.isDigit(source.charAt(i+1))){
                    i++;
                    number += source.charAt(i);
                }

                Tokens.add(new Token("NUMBER",number));
            }
            else{
                String symbol = ""+c;
                while(i+1 < source.length() && source.charAt(i+1)!=' '&&source.charAt(i+1)!='('&& source.charAt(i+1)!=')' && !Character.isDigit(source.charAt(i+1))){
                    i++;
                    symbol += source.charAt(i);
                }
                Tokens.add(new Token("SYMBOL", symbol));
            }
        }
        return Tokens;
    }
}
