package com.garinzhang.algorithm.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 */
public class LongestSubstringWithoutDuplicate {
    public static int longestSubstring(String str) {
        if (str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 1;
        int longest = 1;
        map.put(str.charAt(start), start);
        while (end < str.length()) {
            if (map.containsKey(str.charAt(end))) {
                start = Math.max(start, map.get(str.charAt(end)) + 1);
            }
            map.put(str.charAt(end), end);
            longest = Math.max(end - start + 1, longest);
            end ++;
        }
        return longest;
    }

    public static void main(String[] args) {
        // System.out.println(longestSubstring("aabcddef"));
        System.out.println(longestSubstring(""));
        // map中包含a
        System.out.println(longestSubstring("abba"));
        System.out.println(longestSubstring("au"));
    }
}