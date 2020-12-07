package com.garinzhang.algorithm.arrays;

import java.util.*;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        int sr = 0;
        int er = array.length - 1;
        int sc = 0;
        int ec = array[0].length - 1;
        List<Integer> result = new ArrayList<>();
        squareTraver(sr, er, sc, ec, result, array);
        return result;
    }

    public static void squareTraver(
        int sr,
        int er,
        int sc,
        int ec,
        List<Integer> result,
        int[][] array) {
        if (sr > er || sc > ec) {
            return;
        }
        for (int c = sc; c < ec + 1; c ++) {
            result.add(array[sr][c]);
        }
        for (int r = sr + 1; r < er + 1; r ++) {
            result.add(array[r][ec]);
        }
        for (int c = ec - 1;c > sc - 1; c --) {
            if (sr == er) {
                break;
            }
            result.add(array[er][c]);
        }
        for (int r = er - 1; r > sc; r --) {
            if (sc == ec) {
                break;
            }
            result.add(array[r][sc]);
        }
        squareTraver(sr + 1, er - 1, sc + 1, ec - 1, result, array);
    }

    public static void main(String[] args) {
        System.out.println("yes");
        int[][] array = {
            {1, 2, 3, 4},
            {10, 11, 12, 5},
            {9, 8, 7, 6}
        };
        List<Integer> result = spiralTraverse(array);
        System.out.println(result);
    }
}