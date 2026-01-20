package com.example.eval;

import java.util.List;
public class ArithmeticOps {
    public int compute(String operator, List<Integer> operands){
        if (operands.isEmpty()){
            throw new RuntimeException("No operands provided");
        }

        switch (operator){
            case "+":
                int sum = 0;
                for (int value: operands){
                    sum+= value;
                }
                return sum;


            case "*":
                int prod = 1;
                for (int value: operands){
                    prod *= value;
                }
                return prod;

            case "-":
                int diff = operands.get(0);
                for (int i=1; i<operands.size();i++){
                    diff -= operands.get(i);
                }
                return diff;
            case "/":
                int quo = operands.get(0);
                for (int i =1; i<operands.size(); i++){
                    quo/= operands.get(i);
                }
                return quo;
            default:
                throw new RuntimeException("Unknow Arithmetic Operator: "+ operator);
        }
    }
}
