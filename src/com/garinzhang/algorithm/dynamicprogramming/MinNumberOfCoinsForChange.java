package com.garinzhang.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Garin
 * @date 2020-10-26
 */
public class MinNumberOfCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        //1. define DP Table
        int[] amountsArray = new int[n + 1];
        Arrays.fill(amountsArray, Integer.MAX_VALUE);
        // 2. set base
        amountsArray[0] = 0;
        // 3. for state1
        for (int i = 1; i < amountsArray.length; i ++) {
            // 4. for state2
            for (int coin : denoms) {
                if (i < coin) {
                    continue;
                }
                // 5. do choice
                amountsArray[i] = Math.min(amountsArray[i], amountsArray[i - coin] + 1);
            }
        }
        return amountsArray[n];
    }

    public static void main(String[] args) {
        int amount = 10;
        int[] coins = new int[]{1, 2, 5};
        int min = minNumberOfCoinsForChange(amount, coins);
        System.out.println(min);
    }
}
