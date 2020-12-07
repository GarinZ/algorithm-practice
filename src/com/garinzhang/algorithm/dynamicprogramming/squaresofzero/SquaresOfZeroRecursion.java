package com.garinzhang.algorithm.dynamicprogramming.squaresofzero;

import java.util.*;

/**
 * @author Garin
 * @date 2020-11-11
 */
public class SquaresOfZeroRecursion {
    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        Map<String, Boolean> cache = new HashMap<>();
        return hasSquareOfZeros(matrix, cache, 0, matrix.size() - 1, 0, matrix.size() - 1);
    }

    public static boolean hasSquareOfZeros(List<List<Integer>> matrix, Map<String, Boolean> cache, int sr, int er, int sc, int ec) {
        if (sr >= er && sc >= ec) {
            return false;
        }
        String key = String.valueOf(sr) + "-" + String.valueOf(er) + "-" + String.valueOf(sc) + "-" + String.valueOf(ec);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        boolean isValid = isSquareOfZero(matrix, sr, er, sc, ec)
                || hasSquareOfZeros(matrix, cache, sr + 1, er - 1, sc + 1, ec - 1)
                || hasSquareOfZeros(matrix, cache, sr + 1, er, sc + 1, ec)
                || hasSquareOfZeros(matrix, cache, sr, er - 1, sc + 1, ec)
                || hasSquareOfZeros(matrix, cache, sr + 1, er, sc, ec - 1)
                || hasSquareOfZeros(matrix, cache, sr, er - 1, sc, ec - 1);
        cache.put(key, isValid);
        return isValid;
    }

    public static boolean isSquareOfZero(List<List<Integer>> matrix, int sr, int er, int sc, int ec) {
        for (int row = sr; row <= er; row ++) {
            if (matrix.get(row).get(sc) == 1 || matrix.get(row).get(ec) == 1) {
                return false;
            }
        }
        for (int col = sc; col <= ec; col ++) {
            if (matrix.get(sr).get(col) == 1 || matrix.get(er).get(col) == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> square = new ArrayList<>();
        square.add(Arrays.asList(0, 0, 0));
        square.add(Arrays.asList(0, 1, 0));
        square.add(Arrays.asList(0, 1, 0));
        System.out.println(squareOfZeroes(square));
    }
}
