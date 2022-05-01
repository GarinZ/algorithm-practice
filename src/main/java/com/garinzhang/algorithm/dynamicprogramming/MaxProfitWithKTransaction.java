package com.garinzhang.algorithm.dynamicprogramming;

public class MaxProfitWithKTransaction {
    public static int transactions(int[] prices, int k) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] maxProfits = new int[k + 1][prices.length];
        // for (int i = 0; i < k + 1; i ++) {
        //     for (int j = 0; j < ) {

        //     }
        // }

        return maxProfits[k][prices.length - 1];
    }
}
