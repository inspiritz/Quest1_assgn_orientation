package com.example.eval;

import com.example.ast.*;
import java.util.*;

public class EvaluationVisitor implements Visitor<Integer> {

    private final ArithmeticOps arithmeticOps = new ArithmeticOps();
    private final LogicalOps logicalOps = new LogicalOps();
    private final DefineOps defineOps = new DefineOps();
    private final ConditionalOps conditionalOps = new ConditionalOps();
    private final Environment env = Environment.getInstance();

    @Override
    public Integer visitNumber(NumberNode number) {
        return number.getValue();
    }

    @Override
    public Integer visitSymbol(SymbolNode symbol) {
        String name = symbol.getSymbol();
        if(!env.contains(name)){
            throw new RuntimeException("Unresolved Symbol: " + symbol.getSymbol());
        }
        return env.get(name);
    }

    @Override
    public Integer visitList(ListNode list) {
        String operator = list.getOperator();
        List<Node> children = list.getChildren();


        if (operator.equals("define")) {
            return defineOps.compute(children, this);
        }


        if (operator.equals("if")) {
            return conditionalOps.compute(children, this);
        }

        List<Integer> values = new ArrayList<>();
        for (Node child : children) {
            values.add(child.accept(this));
        }


        if (isArithmetic(operator)) {
            return arithmeticOps.compute(operator, values);
        }

        if (isLogical(operator)) {
            return logicalOps.compute(operator, values);
        }

        throw new RuntimeException("Unknown operator: " + operator);
    }

    private boolean isArithmetic(String op) {
        return op.equals("+") || op.equals("-") ||
                op.equals("*") || op.equals("/");
    }

    private boolean isLogical(String op) {
        return op.equals(">") || op.equals(">=") ||
                op.equals("<") || op.equals("<=") ||
                op.equals("==") || op.equals("!=");
    }
}
