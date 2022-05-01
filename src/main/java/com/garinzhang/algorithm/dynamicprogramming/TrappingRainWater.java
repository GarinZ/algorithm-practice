package com.garinzhang.algorithm.dynamicprogramming;

public class TrappingRainWater {
    public static int trappingRainWater(int[] array) {
        int[] maxLeftHeight = new int[array.length];
        // 获取每个位置左侧最高柱子的高度
        for (int i = 1; i < array.length; i++) {
            maxLeftHeight[i] = Math.max(maxLeftHeight[i - 1], array[i - 1]);
        }
        int sum = 0;
        int maxRightPillar = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            int waterHeight = Math.min(maxRightPillar, maxLeftHeight[i]) - array[i];
            sum += waterHeight <= 0  ? 0 : waterHeight;
            maxRightPillar = Math.max(array[i], maxRightPillar);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trappingRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) == 6);
    }
}