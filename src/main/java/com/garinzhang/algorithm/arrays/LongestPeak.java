package com.garinzhang.algorithm.arrays;

public class LongestPeak {
    public static int longestPeak(int[] array) {
        if (array.length < 3) {
            return 0;
        }
        int longestPeak = 0;
        int prevDirection = array[1] - array[0];
        int currentPeak = prevDirection > 0 ? 1 : 0;
        boolean hasPeak = false;
        for (int current = 2; current < array.length; current ++) {
            int prev = current - 1;
            int currentDirection = array[current] - array[prev];
            if (prevDirection > 0 && currentDirection > 0) {
                // 上升
                currentPeak ++;
            } else if (prevDirection > 0 && currentDirection < 0) {
                // 拐点，设置peak的flag
                currentPeak ++;
                hasPeak = true;
            } else if (prevDirection < 0 && currentDirection >= 0 && hasPeak) {
                // peak结束，进行长度结算
                longestPeak = longestPeak < currentPeak ? currentPeak : longestPeak;
                currentPeak = 0;
                hasPeak = false;
            } else if (prevDirection > 0 && currentDirection == 0) {
                // 非peak，重置计数器
                currentPeak = 0;
            }
            prevDirection = currentDirection;
        }
        if (hasPeak) {
            longestPeak = longestPeak < currentPeak ? currentPeak : longestPeak;
        }
        return longestPeak + 1;
    }
}