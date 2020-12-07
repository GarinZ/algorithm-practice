package com.garinzhang.algorithm.dynamicprogramming;

import java.util.ArrayList;

/**
 * @author Garin
 * @date 2020-11-11
 */
public class MinNumberOfJumps {
    public static int minNumberOfJumps(int[] array) {
        int start = 0;
        int counter = 0;
        while (start < array.length && (array[start] + start) < array.length - 1) {
            int end = array[start] + start;
            int maxIdx = start + 1;
            for (int i = start + 1; i <= end; i ++) {
                if (array[maxIdx] < array[i]) {
                    maxIdx = i;
                }
            }
            counter ++;
            start = maxIdx;
        }
        return (array[start] + start) == array.length - 1 ? counter : ++counter;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3, 2, 3, 2, 1, 1, 1, 1};
        int i = minNumberOfJumps(array);
        new ArrayList<Integer>().add(0, 1);
        System.out.println(i);
    }
}
