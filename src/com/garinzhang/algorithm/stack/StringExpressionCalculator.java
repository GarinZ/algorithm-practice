package com.garinzhang.algorithm.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器II
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 */
public class StringExpressionCalculator {
    public static int calculate(String s) {
        Deque<Integer> numDeque = new LinkedList<>();
        char prevSignal = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch(prevSignal) {
                    case '+':
                        numDeque.offer(num);
                        break;
                    case '-':
                        numDeque.offer(-num);
                        break;
                    case '*':
                        // TODO: numDequeue为空的处理？
                        numDeque.offer(numDeque.pollLast() * num);
                        break;
                    case '/':
                        numDeque.offer(numDeque.pollLast() / num);
                        break;
                }
                num = 0;
                prevSignal = c;
            }
        }

        int res = 0;
        while (!numDeque.isEmpty()) {
            res += numDeque.pollLast();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("2*3+5*6") == 36);
    }
    
}
