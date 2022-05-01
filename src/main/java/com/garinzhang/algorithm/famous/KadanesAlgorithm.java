package com.garinzhang.algorithm.famous;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class KadanesAlgorithm {
    public static int findMaxSum(int[] array) {
        int maxSubarraySum = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i ++) {
            maxSubarraySum = Math.max(array[i], maxSubarraySum + array[i]);
            max = Math.max(max, maxSubarraySum);
        }
        return max;
    }

    public static void main(String[] args) {
        KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm();
    }
}