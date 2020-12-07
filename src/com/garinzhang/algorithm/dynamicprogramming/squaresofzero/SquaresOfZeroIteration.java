package com.garinzhang.algorithm.dynamicprogramming.squaresofzero;

import java.util.*;

/**
 * @author Garin
 * @date 2020-11-11
 */
public class SquaresOfZeroIteration {
    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        int endIdx = matrix.size() - 1;
        for (int sr = 0; sr < endIdx; sr ++) {
            for (int sc = 0; sc < endIdx; sc ++) {
                int squareLength = 1;
                while (sr + squareLength <= endIdx && sc + squareLength <= endIdx) {
                    if (isSquareOfZeros(matrix, sr, sr + squareLength, sc, sc + squareLength)) {
                        return true;
                    }
                    squareLength ++;
                }
            }
        }
        return false;
    }

    public static boolean isSquareOfZeros(List<List<Integer>> matrix, int sr, int er, int sc, int ec) {
        for (int row = sr; row <= er; row ++) {
            if (matrix.get(row).get(sc) == 1 || matrix.get(row).get(ec) == 1) {
                return false;
            }
        }
        for (int col = sc; col <= ec; col ++) {
            if (matrix.get(sc).get(col) == 1 || matrix.get(ec).get(col) == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> square = new ArrayList<>();
        square.add(Arrays.asList(0, 0, 0, 1));
        square.add(Arrays.asList(0, 1, 0, 0));
        square.add(Arrays.asList(0, 1, 0, 0));
        square.add(Arrays.asList(0, 1, 0, 1));
        System.out.println(squareOfZeroes(square));
    }
}
