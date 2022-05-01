package com.garinzhang.algorithm.arrays;

public class FindThreeLargestNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] max = new int[]{Integer.MIN_VALUE, 0};
        int[] mid = new int[]{Integer.MIN_VALUE, 0};
        int[] min = new int[]{Integer.MIN_VALUE, 0};
        for (int i = 0; i < array.length; i ++) {
            boolean r = compareAndSet(max, array[i]) || compareAndSet(mid, array[i]) || compareAndSet(min, array[i]);
        }
        int[] result = new int[max[1] + mid[1] + max[1]];
        int nextPointer = 0;
        nextPointer = buildResult(result, min, nextPointer);
        nextPointer = buildResult(result, mid, nextPointer);
        buildResult(result, max, nextPointer);
        return result;
    }

    public static boolean compareAndSet(int[] source, int target) {
        if (source[0] < target) {
            source[0] = target;
            source[1] = 1;
            return true;
        } else if (source[0] == target) {
            source[1] = source[1] + 1;
            return true;
        }
        return false;
    }

    public static int buildResult(int[] result, int[] target, int pointer) {
        int i = pointer;
        while (i < target[1]) {
            result[i] = target[0];
            i ++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] array = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] result = findThreeLargestNumbers(array);
        StringBuilder sb = new StringBuilder();
        for (Integer item : result) {
            sb.append(item).append(",");
        }
        System.out.println(sb.toString());
    }
}
