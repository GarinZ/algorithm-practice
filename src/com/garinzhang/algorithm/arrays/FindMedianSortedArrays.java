package com.garinzhang.algorithm.arrays;

/**
 * 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArrays {
    /** 
     * 1. 使用归并排序的思想将数组合并
     */
    public static double solutionI(int[] arr1, int[] arr2) {
        int pt1 = 0;
        int pt2 = 0;
        int[] mergedArray = new int[arr1.length + arr2.length];
        int index = 0;
        while (pt1 < arr1.length && pt2 < arr2.length) {
            if (arr1[pt1] < arr2[pt2]) {
                mergedArray[index ++] = arr1[pt1];
                pt1 ++;
            } else if (arr1[pt1] > arr2[pt2]) {
                mergedArray[index ++] = arr2[pt2];
                pt2 ++;
            } else {
                mergedArray[index ++] = arr2[pt2];
                mergedArray[index ++] = arr2[pt2];
                pt1 ++;
                pt2 ++;
            }
        }
        if (pt1 < arr1.length) {
            while (pt1 < arr1.length) {
                mergedArray[index ++] = arr1[pt1 ++];
            }
        } else if (pt2 < arr2.length) {
            while (pt2 < arr2.length) {
                mergedArray[index ++] = arr2[pt2 ++];
            }
        }
        boolean isEven = mergedArray.length % 2 == 0;
        int mid = mergedArray.length / 2;
        return isEven ? (mergedArray[mid] + mergedArray[mid - 1]) / 2.0 : mergedArray[mid];
    }

    public static void main(String[] args) {
        System.out.println(solutionI(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(solutionI(new int[]{}, new int[]{2, 3}));
    }
}
