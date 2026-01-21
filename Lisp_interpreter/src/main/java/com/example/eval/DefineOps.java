package com.example.eval;

import com.example.ast.*;
import java.util.List;

public class DefineOps {

    private final Environment env = Environment.getInstance();

    public int compute(List<Node> children, EvaluationVisitor visitor) {
        if (children.size() != 2) {
            throw new RuntimeException("define expects exactly 2 arguments");
        }

        Node nameNode = children.get(0);
        if (!(nameNode instanceof SymbolNode)) {
            throw new RuntimeException("First argument to define must be a symbol");
        }

        String name = ((SymbolNode) nameNode).getSymbol();
        int value = children.get(1).accept(visitor);

        env.set(name, value);
        return value;
    }
}
