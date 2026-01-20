package com.example.eval;

import java.util.List;
public class LogicalOps {

    public int compute(String operator, List<Integer> operands){
        if (operands.size()!=2){
            throw new RuntimeException("Require exactly 2 operands");
        }
        int left = operands.get(0);
        int right = operands.get(1);
        switch(operator){
            case ">":
                return left>right? 1 : 0;
            case ">=":
                return left>=right? 1 : 0;

            case "<":
                return left<right? 1 : 0;
            case "<=":
                return left<=right? 1 : 0;
            case "==":
                return left==right? 1 : 0;
            case "!=":
                return left!=right? 1 : 0;
            default:
                throw new RuntimeException("Unknown Logical Operator: "+ operator);
        }




    }

}
