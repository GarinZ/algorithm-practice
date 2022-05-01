package com.garinzhang.algorithm.strings;

import java.util.ArrayList;
import java.util.List;

/**
 *  Z 字形变换
 */
public class ZigzagConversion {
    public static String convert(String str, int numRow) {
        if (numRow == 1) {
            return str;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRow; i ++) {
            rows.add(new StringBuilder());
        }
        int rowIndex = 0;
        boolean isUpward = false;
        for (int i = 0; i < str.length(); i ++) {
            rows.get(rowIndex).append(str.charAt(i));
            if (i != 0 && i % (numRow - 1) == 0) {
                isUpward = !isUpward;
            };
            rowIndex = isUpward ? rowIndex - 1 : rowIndex + 1;
        }
        return String.join("", rows);
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3).equals("LCIRETOESIIGEDHN"));
        System.out.println(convert("LEETCODEISHIRING", 4).equals("LDREOEIIECIHNTSG"));
        System.out.println(convert("ABC", 1).equals("ABC"));
        System.out.println(convert("ABC", 2).equals("ACB"));
    }
}
