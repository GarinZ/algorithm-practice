package com.garinzhang.algorithm.sorting;

import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (array[left] > array[pivot] && array[right] < array[pivot]) {
                swap(array, left, right);
                left ++;
                right --;
            }
            if (array[left] <= array[pivot]) {
                left ++;
            }
            if (array[right] >= array[pivot]) {
                right --;
            }
        }
        swap(array, right, pivot);
        quickSort(array, start, right - 1);
        quickSort(array, right + 1, end);
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] res = quickSort(new int[]{5, 3, 1, 2, 6, 10, 7, 3});
        System.out.println(Arrays.toString(res));
    }
}
