package com.garinzhang.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode：200. 岛屿数量
 */
public class RiverSize {
    public static List<Integer> riverSize(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    traverse(i, j, matrix, result, visited);
                }
            }
        }
        return result;
    }

    public static void traverse(int i, int j, int[][] matrix, List<Integer> result, boolean[][] visited) {
        int sum = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{i, j});
        while (queue.size() != 0) {
            Integer[] position = queue.poll();
            if (visited[position[0]][position[1]]) {
                continue;
            }
            visited[position[0]][position[1]] = true;
            sum ++;
            addBreadthToQueue(position[0], position[1], matrix, queue, visited);
        }
        result.add(sum);
    }

    public static void addBreadthToQueue(int i, int j, int[][]matrix, Queue<Integer[]> queue, boolean[][] visited) {
        // go top
        if (i - 1 >= 0 && matrix[i - 1][j] == 1 && !visited[i - 1][j]) {
            queue.add(new Integer[]{i - 1, j});
        }
        // go bottom
        if (i + 1 < matrix.length && matrix[i + 1][j] == 1 && !visited[i + 1][j]) {
            queue.add(new Integer[]{i + 1, j});
        }
        // go left
        if (j - 1 >= 0 && matrix[i][j - 1] == 1 && !visited[i][j - 1]) {
            queue.add(new Integer[]{i, j - 1});
        }
        // go right
        if (j + 1 < matrix[0].length && matrix[i][j + 1] == 1 && !visited[i][j + 1]) {
            queue.add(new Integer[]{i, j + 1});
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 0, 0, 1, 0},
            {1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0}
        };
        System.out.println(Arrays.toString(riverSize(matrix).toArray()));
        int[][] matrix1 = new int[][] {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(riverSize(matrix1).toArray()));
    }
}
