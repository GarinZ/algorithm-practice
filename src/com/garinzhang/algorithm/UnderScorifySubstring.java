package com.garinzhang.algorithm;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Garin
 * @date 2020-10-23
 */
public class UnderScorifySubstring {
    public static String underscorifySubstring(String str, String substring) {
        List<Integer[]> locations = collapse(getLocations(str, substring));
        return addUnderscorify(str, locations);
    }

    public static List<Integer[]> getLocations(String str, String substring) {
        List<Integer[]> locations = new ArrayList<>();
        int prevIndex = 0;
        // 这里的结束条件不太确定
        while (prevIndex < str.length()) {
            int currentIndex = str.indexOf(substring, prevIndex);
            if (currentIndex < 0) {
                break;
            }
            locations.add(new Integer[]{currentIndex, currentIndex + substring.length()});
            // 指针重置为匹配的字符串 + 1，case： str: "fffff", substring: "fff"
            prevIndex = currentIndex + 1;
        }
        return locations;
    }

    public static List<Integer[]> collapse(List<Integer[]> locations) {
        if (locations.size() == 0) {
            return locations;
        }
        List<Integer[]> newLocations = new ArrayList<>();
        newLocations.add(locations.get(0));
        Integer[] prev = newLocations.get(0);
        for (int i = 1; i < locations.size(); i ++) {
            Integer[] current = locations.get(i);
            // current是和newLocations里面的prev比较
            // case: string: "testestest" substring: "test" result: "_testestest_"
            if (prev[1] >= current[0]) {
                // 不确定这里是否正确
                prev[1] = current[1];
            } else {
                newLocations.add(current);
                prev = current;
            }
        }
        return newLocations;
    }

    public static String addUnderscorify(String string, List<Integer[]> locations) {
        StringBuffer sb = new StringBuffer();
        int strIndex = 0;
        int locationIndex = 0;
        int locationInnerIndex = 0;
        while (strIndex < string.length() && locationIndex < locations.size()) {
            if (strIndex == locations.get(locationIndex)[locationInnerIndex]) {
                sb.append("_");
                if (locationInnerIndex == 0) {
                    locationInnerIndex ++;
                } else {
                    locationIndex ++;
                    locationInnerIndex = 0;
                }
            }
            sb.append(string.charAt(strIndex));
            strIndex ++;
        }
        if (locationIndex < locations.size()) {
            // 字符串遍历完，但locations未遍历完的情况
            // string: "this is a test to see if it works and test"
            sb.append("_");
        } else if (strIndex < string.length()) {
            // location遍历完但字符串未遍历完的情况
            // string: "testthis is a testtest to see if testestest it works"
            sb.append(string.substring(strIndex));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "testthis is a testtest to see if testestest it works";
        String result = underscorifySubstring(str, "test");
        System.out.println(result);
    }
}
