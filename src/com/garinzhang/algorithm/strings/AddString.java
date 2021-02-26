package com.garinzhang.algorithm.strings;

import java.util.Stack;

public class AddString {
    public static int ZERO_ASCII = (int) '0';

    public static String addString(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        
        boolean add = false;
        Stack<Integer> stack = new Stack<>();
        while (p1 >= 0 && p2 >= 0) {
            int decimal = getDecimal(num1.charAt(p1)) + getDecimal(num2.charAt(p2));
            decimal = add ? decimal + 1 : decimal;
            add = decimal / 10 > 0;
            stack.push(decimal % 10);
            p1 --;
            p2 --;
        }
        while (p1 >= 0) {
            int i = getDecimal(num1.charAt(p1));
            int num = add ? i + 1 : i;
            add = num / 10 > 0;
            stack.push(num % 10);
            p1 --;   
        }
        while (p2 >= 0) {
            int i = getDecimal(num2.charAt(p2));
            int num = add ? i + 1 : i;
            add = num / 10 > 0;
            stack.push(num % 10);
            p2 --;
        }
        if (add) {
            stack.push(1);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static int getDecimal(char c) {
        return (int) c - ZERO_ASCII;
    }

    public static void main(String[] args) {
        String r = addString("99231", "169");
        System.out.println(r);
    }
}