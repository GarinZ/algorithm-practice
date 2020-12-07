package com.garinzhang;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static byte[] intToBytes( int value ) {
        byte[] src = new byte[4];
        src[3] =  (byte) ((value>>24));
        src[2] =  (byte) ((value>>16));
        src[1] =  (byte) ((value>>8));
        src[0] =  (byte) (value);
        return src;
    }

    public static int[] bubbleSort(int[] array) {
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i ++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                    isSorted = false;
                }
            }
            counter ++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[5];
        System.out.println(Arrays.toString(array));
    }
}
