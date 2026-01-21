package com.example.eval;

import com.example.ast.*;
import java.util.List;

public class ConditionalOps {

    public int compute(List<Node> children, EvaluationVisitor visitor) {
        if (children.size() != 3) {
            throw new RuntimeException("if expects exactly 3 arguments");
        }

        int condition = children.get(0).accept(visitor);

        if (condition != 0) {
            return children.get(1).accept(visitor);
        } else {
            return children.get(2).accept(visitor);
        }
    }
}
