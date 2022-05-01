package com.garinzhang.algorithm.dynamicprogramming;

/**
 * LevenshteinDistance
 * @author Garin
 * @date 2020-10-23
 */
public class LevenshteinDistance {
    public static int levenshteinDistance(String word1, String word2) {
        String bigger = word1.length() > word2.length() ? word1 : word2;
        String smaller = word1.length() <= word2.length() ? word1 : word2;
        int[] oddRow = new int[smaller.length() + 1];
        int[] evenRow = new int[smaller.length() + 1];
        for (int i = 0; i < evenRow.length; i ++) {
            evenRow[i] = i;
        }

        int[] currentRow = oddRow;
        int[] prevRow = evenRow;
        for (int i = 1; i < bigger.length() + 1; i ++) {
            if (i % 2 == 1) {
                currentRow = oddRow;
                prevRow = evenRow;
            } else {
                currentRow = evenRow;
                prevRow = oddRow;
            }
            currentRow[0] = i;
            for (int j = 1; j < smaller.length() + 1; j ++) {
                if (bigger.charAt(i - 1) == smaller.charAt(j - 1)) {
                    currentRow[j] =  prevRow[j - 1];
                } else {
                    currentRow[j] =  Math.min(Math.min(currentRow[j-1], prevRow[j]), prevRow[j - 1]) + 1;
                }
            }
        }
        return currentRow[smaller.length()];
    }

    public static void main(String[] args) {
        int a = levenshteinDistance("a", "");
        System.out.println(a);
    }
}
