package com.garinzhang.algorithm.arrays;

/**
 * @author Garin
 * @date 2020-10-30
 */
public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                int current = grid[i][j];
                if (current != 1) {
                    continue;
                }
                int currentSum = 4;
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    currentSum --;
                }
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    currentSum --;
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    currentSum --;
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    currentSum --;
                }
                sum += currentSum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[]{0, 1}};
        int sum = islandPerimeter(grid);
        System.out.println(sum);
    }
}
