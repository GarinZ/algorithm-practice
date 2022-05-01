package com.garinzhang.algorithm;

import java.util.*;

public class Fibonacci {
    class FibonacciSolutionI {
        public int getNthFib(int n) {
            if (n == 1) {
                return 0;
            } else if (n == 2) {
                return 1;
            }
            return getNthFib(n - 1) + getNthFib(n - 2);
        }
    }

    class FibonacciSolutionII {
    
        public int getNthFib(int n) {
			Map<Integer, Integer> cache = new HashMap<>(n);
			cache.put(1, 0);
			cache.put(2, 1);
			return getNthFib(n, cache);
	    }

        public int getNthFib(int n, Map<Integer, Integer> cache) {
            if (cache.containsKey(n)) {
                return cache.get(n);
            } else {
                cache.put(n, getNthFib(n - 1, cache) + getNthFib(n - 2, cache));
                return cache.get(n);
            }
        }
    }

    class FibonacciSolutionIII {
        public int getNthFib(int n) {
            if (n == 1) {
                return 0;
            } else if (n == 2) {
                return 1;
            }
            int[] array = new int[]{0, 1};
            int counter = 3;
            while (counter < n) {
                    int next = array[0] + array[1];
                    array[0] = array[1];
                    array[1] = next;
                    counter ++;
            }
            return array[0] + array[1];
        }
    }
}