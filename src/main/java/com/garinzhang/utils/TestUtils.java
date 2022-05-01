package com.garinzhang.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson2.JSON;

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

    public static int[][] convertTwoDimensionalJsonArray(String json2dArray) {
        Integer[][] int2dArr = JSON.parseObject(json2dArray, Integer[][].class);
        int[][] result = new int[int2dArr.length][int2dArr[0].length];
        for (int i = 0; i < int2dArr.length; i++) {
            result[i] = Arrays.stream(int2dArr[i]).mapToInt(Integer::intValue).toArray();
        }
        return result;
    }
}