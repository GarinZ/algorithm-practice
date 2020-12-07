package com.garinzhang.algorithm.arrays;

import java.util.*;

// 数组长度和数组排列组合的关系公式是什么？
public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
		Map<Integer, List<Integer[]>> cache = new HashMap<>();
		for (int i = 0; i < array.length - 1; i ++) {
			for (int j = i + 1; j < array.length; j ++) {
				int sum = array[i] + array[j];
				if (cache.containsKey(targetSum - sum)) {
					for (Integer[] pairs : cache.get(targetSum - sum)) {
						result.add(new Integer[]{pairs[0], pairs[1], array[i], array[j]});
					}
				}
			}
			for (int k = i - 1; k >= 0; k --) {
				int sum = array[i] + array[k];
				if (cache.containsKey(sum)) {
					cache.get(sum).add(new Integer[]{array[i], array[k]});
				} else {
					Integer[] pair = new Integer[]{array[i], array[k]};
					List<Integer[]> pairList = new ArrayList<>();
					pairList.add(pair);
					cache.put(sum, pairList);
				}
			}
		}
		return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 6, 4, -1, 1, 2};
        List<Integer[]> result = fourNumberSum(array, 16);
        List<Integer> arr = new ArrayList<>();
        System.out.println(result);
    }
}