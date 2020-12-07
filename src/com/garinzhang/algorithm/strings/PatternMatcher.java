package com.garinzhang.algorithm.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Garin
 * @date 2020-10-25
 */
public class PatternMatcher {
    public static String[] patternMatcher(String pattern, String str) {
        if (pattern.length() > str.length()) {
            return new String[]{};
        }
        if (pattern.length() == 1) {
            return new String[]{str, ""};
        }

        Map<String, Integer> counter = new HashMap<>();
        String[] patternArray = getPatterArray(pattern, counter);
        boolean isSwitch = !String.valueOf(pattern.charAt(0)).equals(patternArray[0]);
        int firstYIdx = getFirstYIndex(patternArray);
        if (counter.containsKey("y")) {
            for (int xLen = 1; xLen < str.length(); xLen ++) {
                int yLen = (str.length() - xLen * counter.get("x"))
                        / counter.get("y");
                // 对这里我需要举出一个例子，现在我是背下来的
                if (yLen <= 0) {
                    continue;
                }
                int yStartIdx = firstYIdx * xLen;
                String x = str.substring(0, xLen);
                String y = str.substring(yStartIdx, yStartIdx + yLen);
                StringBuffer sb = new StringBuffer();
                for (String s : patternArray) {
                    if (s.equals("x")) {
                        sb.append(x);
                    } else {
                        sb.append(y);
                    }
                }
                if (str.equals(sb.toString())) {
                    return isSwitch ? new String[]{y, x} : new String[]{x, y};
                }
            }
        } else {
            int xLen = str.length() / counter.get("x");
            String x = str.substring(0, xLen);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < counter.get("x"); i ++) {
                sb.append(x);
            }
            if (str.equals(sb.toString())) {
                return isSwitch ? new String[]{"", x} : new String[]{x, ""};
            }
        }
        return new String[] {};
    }

    /**
     * 1. convert patternString to patternArray
     * 2. make up counter
     */
    public static String[] getPatterArray(String pattern, Map<String, Integer> counter) {
        String[] newStrArr = new String[pattern.length()];
        boolean needSwitch = pattern.charAt(0) == 'y';
        for (int i = 0; i < pattern.length(); i ++) {
            String s = "";
            if (needSwitch) {
                s = pattern.charAt(i) == 'x' ? "y" : "x";
            } else {
                s = String.valueOf(pattern.charAt(i));
            }
            newStrArr[i] = s;
            if (counter.containsKey(s)) {
                counter.put(s, counter.get(s) + 1);
            } else {
                counter.put(s, 1);
            }
        }
        return newStrArr;
    }

    public static int getFirstYIndex(String[] patternArray) {
        for (int i = 0; i < patternArray.length; i ++) {
            if (patternArray[i].equals("y")) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] result = patternMatcher("xxyxyy", "testtestwrongtestwrongtest");
        System.out.println(Arrays.toString(result));
    }
}
