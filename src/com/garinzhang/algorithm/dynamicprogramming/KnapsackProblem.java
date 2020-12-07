package com.garinzhang.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Garin
 * @date 2020-11-10
 */
public class KnapsackProblem {
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // 1. declare the value table
        int[][] values = new int[items.length + 1][capacity + 1];
        // 2. build value table, with formula
        for (int i = 1; i < items.length + 1; i ++) {
            for (int j = 1; j < capacity + 1; j ++) {
                int weight = items[i - 1][1];
                int value = items[i - 1][0];
                if (weight > j) {
                    values[i][j] = values[i - 1][j];
                } else {
                    values[i][j] = Math.max(values[i - 1][j], value + values[i - 1][j - weight]);
                }
            }
        }
        // 3. build knapsack items
        List<Integer> indices = new LinkedList<>();
        int row = items.length;
        int column = capacity;
        while (column >= 0 && row >= 0 && values[row][column] != 0) {
            if (values[row][column] != values[row - 1][column]) {
                indices.add(0, row - 1);
                column = column - items[row - 1][1];
            }
            row --;
        }
        // 4. build return
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(indices);
        result.get(0).add(values[items.length][capacity]);

        return result;
    }

    public static void main(String[] args) {
        int[][] items = new int[][]{{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        List<List<Integer>> lists = knapsackProblem(items, 10);
        System.out.println("totalValue: " + lists.get(0).get(0) + ", indices: " + Arrays.toString(lists.get(1).toArray()));
    }
}
