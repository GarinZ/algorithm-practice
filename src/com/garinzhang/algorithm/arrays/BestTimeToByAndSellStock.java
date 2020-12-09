package com.garinzhang.algorithm.arrays;

/**
 * 121. 买卖股票的最佳时机
 */
public class BestTimeToByAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int p : prices) {
            if (p > minPrice) {
                maxProfit = Math.max(p - minPrice, maxProfit);
            } else {
                minPrice = p;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{5, 3, 4, 1, 3, 7}));
    }
}
