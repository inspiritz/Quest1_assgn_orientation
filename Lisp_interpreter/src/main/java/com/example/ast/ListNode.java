package com.example.ast;

import java.util.List;
public class ListNode implements Node {
    private final String operator;
    private final List<Node> children;

    public ListNode(String operator, List<Node> children){
        this.operator = operator;
        this.children = children;
    }

    public String getOperator(){
        return operator;
    }

    public List<Node> getChildren(){
        return children;
    }

    @Override
    public <T> T accept(Visitor<T> visitor){
        return visitor.visitList(this);
    }
}
