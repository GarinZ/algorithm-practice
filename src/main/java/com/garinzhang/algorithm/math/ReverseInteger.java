package com.garinzhang.algorithm.math;

public class ReverseInteger {
    public static int reverse(int num) {
        int reverseNum = 0;
        while (num != 0) {
            int pop = num % 10;
            num = num / 10;
            if (reverseNum > Integer.MAX_VALUE / 10 || (reverseNum == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (reverseNum < Integer.MIN_VALUE / 10 || (reverseNum == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            reverseNum = reverseNum * 10 + pop;
        }
        return reverseNum;
    }
}
