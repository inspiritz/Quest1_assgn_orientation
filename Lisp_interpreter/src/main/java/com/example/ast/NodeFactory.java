package com.example.ast;

import java.util.List;
public class NodeFactory {
    public Node createNumber(int value){
        return new NumberNode(value);
    }

    public Node createSymbol(String name) {
        return new SymbolNode(name);
    }

    public Node createList(String operator, List<Node> children) {
        return new ListNode(operator, children);
    }


}
