package com.garinzhang.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;



public class MergeSortedArrays {
    public static List<Integer> mergeSoretedArrays(List<List<Integer>> arrays) {
        List<Integer> result = new ArrayList<>();
        MinHeap heap = new MinHeap();
        for (List<Integer> array : arrays) {
            for (Integer item : array) {
                heap.insert(item);
            }
        }

        while (heap.size() != 0) {
            result.add(heap.removeTop());
        }

        return result;
    }

    static class MinHeap {
        List<Integer> heap;
        
        MinHeap() {
            this.heap = new ArrayList<>();
        }

        public void insert(Integer value) {
            heap.add(value);
            siftUp(heap.size());
        }

        public Integer removeTop() {
            swap(0, heap.size() - 1);
            Integer smallest = heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1);
            return smallest;
        }

        public void siftUp(int start) {
            int nextParent = (start - 1) / 2;
            while (start > 0 && heap.get(start) < heap.get(nextParent)) {
                swap(nextParent, start);
                start = nextParent;
                nextParent = (start - 1) / 2;
            }
        }

        public void siftDown(int start, int end) {
            int leftIdx = 2 * start + 1;
            while (leftIdx <= end) {
                int rightIdx = leftIdx + 1 <= end ? leftIdx + 1 : -1;
                int smaller = leftIdx;
                if (heap.get(rightIdx) < heap.get(leftIdx)) {
                    smaller = rightIdx;
                }
                if (heap.get(smaller) >= heap.get(start)) {
                    return;
                }
                swap(smaller, start);
                start = smaller;
                leftIdx = 2 * start + 1;
            }
        }

        public void swap(int i, int j) {
            Integer tmp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, tmp);
        }

        public int size() {
            return heap.size();
        }
    }
}
