package com.garinzhang.algorithm.dynamicprogramming;

import javax.xml.stream.events.Characters;
import java.util.*;

/**
 * @author Garin
 * @date 2020-11-09
 */
public class LongestCommonSubsequence {
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Q1: 三维数组是不是这样声明的？
        int[][][] results = new int[str1.length() + 1][str2.length() + 1][];
        for (int i = 0; i < str1.length() + 1; i ++) {
            for (int j = 0; j < str2.length() + 1; j ++) {
                results[i][j] = new int[]{0, 0, 0, 0};
            }
        }

        for (int i = 1; i < str1.length() + 1; i ++) {
            for (int j = 1; j < str2.length() + 1; j ++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    results[i][j] = new int[]{(int) str1.charAt(i - 1), results[i - 1][j - 1][1] + 1, i - 1, j - 1};
                } else {
                    // Q2: 是否可以这样使用？
                    results[i][j] = results[i - 1][j][1] > results[i][j - 1][1] ? results[i - 1][j] : results[i][j - 1];
                }
            }
        }
        return buildSequence(results);
    }

    public static List<Character> buildSequence(int[][][] results) {
        int i = results.length - 1;
        int j = results[0].length - 1;
        List<Character> sequence = new ArrayList<>();
        while (results[i][j][1] != 0) {
            int[] currentEntry = results[i][j];
            sequence.add(0, (char) currentEntry[0]);
            i = currentEntry[2];
            j = currentEntry[3];
        }
        return sequence;
    }

    public static void main(String[] args) {
        String str1 = "ZXVVYZW";
        String str2 = "XKYKZPW";
        List<Character> characters = longestCommonSubsequence(str1, str2);
        System.out.println(Arrays.toString(characters.toArray()));
    }

}
