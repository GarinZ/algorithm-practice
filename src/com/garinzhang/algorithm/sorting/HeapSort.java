package com.garinzhang.algorithm.sorting;

import java.util.Arrays;

/**
 * @author Garin
 * @date 2020-10-31
 */
public class HeapSort {
    public static int[] heapSort(int[] array) {
        buildMaxHeap(array);
        int spliter = array.length - 1;
        for (int i = 0; i < array.length - 1; i ++) {
            swap(array, 0, spliter);
            spliter --;
            siftDown(array, 0, spliter);
        }
        return array;
    }

    public static void buildMaxHeap(int[] array) {
        int firstParentIdx = (array.length - 2) / 2;
        for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx --) {
            siftDown(array, currentIdx, array.length - 1);
        }
    }

    public static void siftDown(int[] heap, int currentIdx, int endIdx) {
        int leftIdx = currentIdx * 2 + 1;
        while (leftIdx <= endIdx) {
            int rightIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            int toSwap = leftIdx;
            if (rightIdx != -1 && heap[leftIdx] < heap[rightIdx]) {
                toSwap = rightIdx;
            }
            if (heap[currentIdx] > heap[toSwap]) {
                return;
            }
            swap(heap, currentIdx, toSwap);
            currentIdx = toSwap;
            leftIdx = currentIdx * 2 + 1;
        }
    }

    public static void swap(int[] array, int i, int j ) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        int[] result = heapSort(array);
        System.out.println(Arrays.toString(result));
    }
}
