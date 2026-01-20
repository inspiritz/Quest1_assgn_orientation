package com.example.eval;

import com.example.ast.*;
import java.util.*;

public class EvaluationVisitor implements Visitor<Integer> {

    private final ArithmeticOps arithmeticOps = new ArithmeticOps();
    private final LogicalOps logicalOps = new LogicalOps();

    @Override
    public Integer visitNumber(NumberNode number) {
        return number.getValue();
    }

    @Override
    public Integer visitSymbol(SymbolNode symbol) {
        throw new RuntimeException("Unresolved Symbol: " + symbol.getSymbol());
    }

    @Override
    public Integer visitList(ListNode list) {

        String operator = list.getOperator();

        List<Integer> values = new ArrayList<>();
        for (Node child : list.getChildren()) {
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
