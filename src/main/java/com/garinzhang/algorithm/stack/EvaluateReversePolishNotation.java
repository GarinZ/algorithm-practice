package com.garinzhang.algorithm.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    private static final Set<String> operatorSet = new HashSet<>();
    static {
        operatorSet.add("+");
        operatorSet.add("-");
        operatorSet.add("*");
        operatorSet.add("/");
    }

    public static int evaluateRPN(String[] tokens) {
        Stack<Integer> operationalStack = new Stack<>();
        for (int i = 0; i < tokens.length; i ++) {
            if (operatorSet.contains(tokens[i])) {
                int b = operationalStack.pop();
                int a = operationalStack.pop();
                operationalStack.push(applyOperator(tokens[i], a, b));
            } else {
                operationalStack.push(Integer.valueOf(tokens[i]));
            }
            
        }
        return operationalStack.pop();
    }

    public static int applyOperator(String operator, int a, int b) {
        int res = 0;
        switch(operator) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
            res = a * b;
                break;
            case "/":
            default:
                res = a / b;
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("12"));
    }
}