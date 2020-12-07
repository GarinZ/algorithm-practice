package com.garinzhang.algorithm.arrays;

/**
 * @author Garin
 * @date 2020-08-13
 */
import java.util.*;

class MinRewards {
    public static int minRewards(int[] scores) {
        int totalReward = 0;
        int p = 0;
        int prevPeak = -1;
        while (p < scores.length) {
            if (!isValley(p, scores)) {
                p ++;
                continue;
            }
            totalReward = totalReward + 1;
            int currentCounter = 1;
            int leftPoint = p - 1;
            while (leftPoint >= 0 && scores[leftPoint] > scores[leftPoint + 1] && (prevPeak < 0 || leftPoint > prevPeak)) {
                currentCounter ++;
                totalReward = totalReward + currentCounter;
                leftPoint --;
            }
            currentCounter = 1;
            int rightPoint = p + 1;
            while (rightPoint < scores.length && scores[rightPoint] > scores[rightPoint - 1]) {
                currentCounter ++;
                totalReward = totalReward + currentCounter;
                rightPoint ++;
            }
            prevPeak = rightPoint - 1;
            p = rightPoint;
        }
        return totalReward;
    }

    public static boolean isValley(int index, int[] array) {
        if (index == 0 && index == array.length - 1) {
            return true;
        } else if (index == array.length - 1) {
            return array[index] < array[index - 1];
        } else if (index == 0) {
            return array[index] < array[index + 1];
        } else {
            return array[index] < array[index + 1] && array[index] < array[index - 1];
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{0, 4, 2, 1, 3};
        int result = minRewards(input);
        System.out.println(result);
    }
}

