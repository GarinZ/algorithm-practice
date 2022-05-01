package com.garinzhang.algorithm.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Garin
 * @date 2020-11-13
 */
public class SmallestSubstringContaining {
    public static String smallestSubstringContaining(String bigString, String smallString) {
        // 1. buildTargetCharMap
        Map<Character, Integer> targetCharMap = buildTargeCharMap(smallString);
        // 2. getCharIndex
        int[] smallestIndex = getCharIndex(bigString, targetCharMap);
        // 3. buildSubstring
        if (smallestIndex[1] == -1) {
            return "";
        }
        return bigString.substring(smallestIndex[0], smallestIndex[1]);
    }

    public static int[] getCharIndex(String bigString, Map<Character, Integer> targetCharMap) {
        Map<Character, Integer> foundCharMap = new HashMap<>();
        int uniqueCharCount = targetCharMap.size();
        int foundCharCount = 0;
        int left = 0;
        int right = 0;
        int[] smallestIndex = new int[]{0, -1};

        while (right < bigString.length()) {
            char rightChar = bigString.charAt(right);
            if (!targetCharMap.containsKey(rightChar)) {
                right ++;
                continue;
            }
            increaseCount(foundCharMap, rightChar);
            if (foundCharMap.get(rightChar).equals(targetCharMap.get(rightChar))) {
                foundCharCount ++;
            }

            while (uniqueCharCount == foundCharCount && left <= right) {
                char leftChar = bigString.charAt(left);
                // update smallestIndex
                if (smallestIndex[1] == -1 || (smallestIndex[1] - smallestIndex[0]) > (right - left + 1)) {
                    smallestIndex = new int[]{left, right + 1};
                }

                if (!targetCharMap.containsKey(leftChar)) {
                    left ++;
                    continue;
                }
                if (foundCharMap.get(leftChar).equals(targetCharMap.get(leftChar))) {
                    foundCharCount --;
                }
                decreaseCount(foundCharMap, leftChar);
                left ++;
            }
            right ++;
        }
        return smallestIndex;
    }

    public static Map<Character, Integer> buildTargeCharMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i ++) {
            increaseCount(map, str.charAt(i));
        }
        return map;
    }

    public static void increaseCount(Map<Character, Integer> map, Character key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    public static void decreaseCount(Map<Character, Integer> map, Character key) {
        map.put(key, map.get(key) - 1);
    }

    public static void main(String[] args) {
        String s = smallestSubstringContaining("a$fuu+afff+affaffa+a$Affab+a+a+$a$", "a+$aaAaaaa$++");
        System.out.println(s);
    }
}
