package com.garinzhang.algorithm.sorting;

import java.util.Arrays;

public class SearchForRange {
    public static int[] searchForRange(int[] array, int target) {
        int[] finalIndex = new int[]{-1, -1};
        alteredBinarySearch(array, target, 0, array.length - 1, finalIndex, true);
        alteredBinarySearch(array, target, 0, array.length - 1, finalIndex, false);
        return finalIndex;
    }

    // TODO: 画出查找过程
    public static void alteredBinarySearch(int[] array, int target, int left, int right, int[] finalIndex, boolean goLeft) {
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        if (array[mid] > target) {
            alteredBinarySearch(array, target, left, mid - 1, finalIndex, goLeft);
        } else if (array[mid] < target) {
            alteredBinarySearch(array, target, mid + 1, right, finalIndex, goLeft);
        } else {
            // 相等时更新finalIndex
            if (goLeft) {
                if (mid == 0 || array[mid - 1] != target) {
                    finalIndex[0] = mid;
                } else {
                    alteredBinarySearch(array, target, left, mid - 1, finalIndex, goLeft);
                }
            } else{
                if (mid == 0 || array[mid + 1] != target) {
                    finalIndex[0] = mid;
                } else {
                    alteredBinarySearch(array, target, mid + 1, right, finalIndex, goLeft);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 9, 12, 12, 12, 16, 17, 19, 20, 39, 48};
        int[] finalIndex = searchForRange(array, 12);
        System.out.println(Arrays.toString(finalIndex));
    }
}
