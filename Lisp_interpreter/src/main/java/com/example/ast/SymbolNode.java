package com.example.ast;

public class SymbolNode implements Node {
    private final String symbol;

    public SymbolNode(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }

    @Override
    public <T> T accept(Visitor<T> visitor){
        return visitor.visitSymbol(this);
    }

}
