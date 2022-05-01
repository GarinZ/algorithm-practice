package com.garinzhang.algorithm.heap;

import java.util.Arrays;

/**
 * 面试题 17.14. 最小K个数
 * https://leetcode-cn.com/problems/smallest-k-lcci/submissions/
 */
public class SmallestK {
    public static int[] smallestK(int[] arr, int k) {
        if (arr.length < k) {
            k = arr.length;
        }
        buildHeap(k - 1, arr);
        for (int i = k; i < arr.length; i ++) {
            if (arr[i] > arr[0]) {
                continue;
            }
            swap(0, i, arr);
            siftDown(0, k - 1, arr);
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void buildHeap(int end, int[] array) {
        int firstParentIdx = (end - 1) / 2;
        for (int i = firstParentIdx; i >= 0; i--) {
            siftDown(i, end, array);
        }
    }

    public static void siftDown(int start, int end, int[] array) {
        int leftIdx = 2 * start + 1;
        while (leftIdx <= end) {
            int rightIdx = leftIdx + 1 <= end ? leftIdx + 1 : -1;
            int bigger = leftIdx;
            if (rightIdx != -1 && array[rightIdx] > array[leftIdx]) {
                bigger = rightIdx;
            }
            if (array[start] > array[bigger]) {
                return;
            }
            swap(start, bigger, array);
            start = bigger;
            leftIdx = start * 2 + 1;
        }
    }

    public static void swap(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestK(new int[] { 3, 5, 2, 1, 4, 7, 6 }, 3)));
        System.out.println(Arrays.toString(smallestK(new int[] { 0, 1, 2 }, 3)));
        System.out.println(Arrays.toString(smallestK(new int[] { 1, 3, 5, 7, 2, 4, 6, 8 }, 4)));
    }
}
