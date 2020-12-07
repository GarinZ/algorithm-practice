package com.garinzhang.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtils {
    public static boolean contains(int[] array, int target) {
        for (int item : array) {
            if (item == target) {
                return true;
            }
        }
        Arrays.asList(new Integer[]{1, 2});
        return false;
    }

    public static void printList(List<?> list) {
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void printTwoDimensionList(List<Integer[]> list) {
        List<String> newList = new ArrayList<>();
        for (Integer[] item : list) {
            newList.add(Arrays.toString(item));
        }
        System.out.println(String.join(",", newList));
    }
}