package com.garinzhang.algorithm.graph;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.garinzhang.utils.IOUtils;
import com.garinzhang.utils.TestUtils;

/**
 * @author Zhang Jialin
 * @date 2022-05-01
 */
class MinPathSumTest {

    @Test
    void minPathSum0() {
        MinPathSum solution = new MinPathSum();
        int[][] grid = new int[3][3];
        grid[0] = new int[]{1,3,1};
        grid[1] = new int[]{1,5,1};
        grid[2] = new int[]{4,2,1};
        int result = solution.minPathSum(grid);
        Assertions.assertEquals(7, result);
    }

    @Test
    void minPathSum1() {
        String testCase = "\n"
                + "[[7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5],[9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6],[8,2,9,1,3,1,9,7,2,5,"
                + "3,1,2,4,8,2,8,8],[6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4],[7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4],[9,5,"
                + "4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9],[1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4],[3,9,7,9,5,8,9,5,6,9,8,8,0,"
                + "1,4,2,8,2],[1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3],[5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7],[2,3,2,4,8,"
                + "5,1,7,2,9,5,2,4,2,9,2,8,7],[0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9]]";
        int[][] ints = TestUtils.convertTwoDimensionalJsonArray(testCase);
        MinPathSum solution = new MinPathSum();
        int result = solution.minPathSum(ints);
        Assertions.assertEquals(85, result);
    }

    @Test
    void minPathSum2() {
        String testCase = "[[7,1,3,2],[0,2,1,4]]";
        int[][] ints = TestUtils.convertTwoDimensionalJsonArray(testCase);
        MinPathSum solution = new MinPathSum();
        int result = solution.minPathSum(ints);
        Assertions.assertEquals(14, result);
    }

    @Test
    void minPathSum3() throws IOException {
        String testCase = IOUtils.getTestResourceFileContent("minPathSum_test_case.txt");
        int[][] ints = TestUtils.convertTwoDimensionalJsonArray(testCase);
        MinPathSum solution = new MinPathSum();
        int result = solution.minPathSum(ints);
        Assertions.assertEquals(823, result);
    }
}