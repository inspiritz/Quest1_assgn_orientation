package com.example.ast;

import com.example.eval.Visitor;

public class NumberNode implements Node {
    private final int value;

    public NumberNode(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor){
        return visitor.visitNumber(this);
    }
}
