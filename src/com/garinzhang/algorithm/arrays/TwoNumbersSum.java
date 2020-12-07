package com.garinzhang.algorithm.arrays;

import com.garinzhang.algorithm.TestUtils;

import java.util.Arrays;
import java.util.Map;

public class TwoNumbersSum {
    public static int[] twoNumbersSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == targetSum) {
                return new int[]{left, right};
            } else if (array[left] + array[right] < targetSum) {
                left ++;
            } else if (array[left] + array[right] > targetSum) {
                right --;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] result1 = twoNumbersSum(new int[]{-4, 0, 1, 2, 5, 8, 12}, 7);
        assert(result1.length == 2);
        assert(TestUtils.contains(result1, 2));
        assert(TestUtils.contains(result1, 5));
    }


}