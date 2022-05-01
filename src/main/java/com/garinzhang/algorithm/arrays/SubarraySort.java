package com.garinzhang.algorithm.arrays;

public class SubarraySort {
    public static int[] subarraySort(int[] array) {
        int start = -1;
        int end = -1;
        int pivot = -1;
        for (int i = 1; i < array.length; i ++) {
            if (array[i - 1] > array[i]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            return new int[]{start, end};
        }
        int rightPointer = pivot;
        int[] rightMin = {array[pivot], pivot};
        while (rightPointer < array.length) {
            if (array[rightPointer] <= array[pivot]) {
                end = rightPointer;
                if (rightMin[0] > array[rightPointer]) {
                    rightMin[0] = array[rightPointer];
                    rightMin[1] = rightPointer;
                }
            }
            rightPointer ++;
        }
        int leftPointer = pivot;
        int[] leftMax = {array[pivot], pivot};
        while (leftPointer >= 0) {
            if (array[leftPointer] >= array[pivot]) {
                start = leftPointer;
            }
            leftPointer --;
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
//        int[] sample = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] sample = new int[]{1, 2, 8, 4, 5};
        int[] ints = subarraySort(sample);
        StringBuilder sb = new StringBuilder();
        for (int item : ints) {
            sb.append(item).append(",");
        }
        System.out.println(sb.toString());
    }

}
