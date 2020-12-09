package com.garinzhang.algorithm.arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int largest = 0;
        while (left < right) {
            largest = height[left] <= height[right]
                ? Math.max(largest, (right - left) * height[left ++])
                : Math.max(largest, (right - left) * height[right --]);
        }
        return largest;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 1}) == 1);
    }

}
