package com.garinzhang.algorithm.strings;

/**
 * 最长回文子串
 */
public class LongestPalindromeSubstring {
    public static String longestPalindromeSubstring(String str) {
        if (str.length() == 0) {
            return "";
        }
        int[] position = new int[]{0, 1};
        int pivot = 0;
        while (pivot < str.length() - 1) {
            int[] odd = findPalindromePosition(pivot - 1, pivot + 1, str);
            int[] even = findPalindromePosition(pivot, pivot + 1, str);
            int[] longer = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            position = position[1] - position[0] >= longer[1] - longer[0] ? position : longer;
            pivot ++;
        }
        return str.substring(position[0], position[1]);
    }

    public static int[] findPalindromePosition(int left, int right, String str) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left --;
            right ++;
        }
        return new int[]{left + 1, right};
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubstring("aaabcba"));
        System.out.println(longestPalindromeSubstring("abbabb"));
        System.out.println(longestPalindromeSubstring(""));
    }
}