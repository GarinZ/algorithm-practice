package com.garinzhang.algorithm.arrays;

public class MonotonicArray {
    public boolean monotonicArray(int[] array) {
        int direction = array[1] - array[0];
        for (int i = 2; i < array.length; i ++) {
//            if (isBreakDirection(prev, )) {
//                return false;
//            }
        }
        return true;
    }

    public boolean isBreakDirection(int prev, int current, int direction) {
        if (direction > 0) {
            return (current - prev) < 0;
        } else if (direction < 0) {
            return (current - prev) > 0;
        }
        return false;
    }
}