package com.garinzhang.algorithm.arrays;

import java.util.*;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int target) {
        int lp = 0;
        int rp = array.size() - 1;
        while (lp < rp) {
            if (array.get(rp) == array.get(target)) {
                rp --;
                continue;
            }
            if (array.get(lp) == target) {
                int tmp = array.get(lp);
                array.set(lp, array.get(rp));
                array.set(rp, tmp);
            }
            lp ++;
        }
        return array;
    }
}