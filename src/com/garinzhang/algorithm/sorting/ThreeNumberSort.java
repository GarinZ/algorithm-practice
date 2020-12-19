package com.garinzhang.algorithm.sorting;

import java.util.Arrays;

public class ThreeNumberSort {
    /**
     * Main Idea:  Counting Sort
     */
    static class Solution1 {
        public static int[] threeNumberSort(int[] array, int[] order) {
            int[] bucket = new int[order.length];
            for (int i = 0; i < array.length; i++) {
                int orderIdx = find(order, array[i]);
                bucket[orderIdx] = bucket[orderIdx] + 1;
            }
    
            int offset = 0;
            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j < bucket[i]; j++) {
                    array[offset + j] = order[i];
                }
                offset += bucket[i];
            }
    
            return array;
        }
    
        public static int find(int[] array, int target) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == target) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * Main Idea: 
     * Finish sorting first and last num in the order,
     * and the second num will in the right place.
     */
    static class Solution2 {
        public static int[] threeNumberSort(int[] array, int[] order) {
            int firstNum = order[0];
            int lastNum = order[2];
            
            int toSwapIdx = 0;
            for (int i = 0; i < array.length; i ++) {
                if (array[i] == firstNum) {
                    swap(array, toSwapIdx, i);
                    toSwapIdx ++;
                }
            }

            toSwapIdx = array.length - 1;
            for (int i = array.length - 1; i >= 0; i --) {
                if (array[i] == lastNum) {
                    swap(array, toSwapIdx, i);
                    toSwapIdx --;
                }
            }
            return array;
        }

    }
    
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(Solution1.threeNumberSort(new int[] { 1, 0, 0, -1, -1, 0, 1, 1 }, new int[] { 0, 1, -1 })));
        System.out.println(Arrays.toString(Solution2.threeNumberSort(new int[] { 1, 0, 0, -1, -1, 0, 1, 1 }, new int[] { 0, 1, -1 })));
    }

}
