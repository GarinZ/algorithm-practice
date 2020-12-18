package com.garinzhang.algorithm.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ContinousMedian {
    static class ContinuousMedianHandler {
        Heap low = new Heap(Heap::MAX_HEAP, new ArrayList<>());
        Heap high = new Heap(Heap::MIN_HEAP, new ArrayList<>());
        double median = 0;

        public void insert(int number) {
            if (low.size() == 0 || low.getTop() > number) {
                low.insert(number);
            } else {
                high.insert(number);
            }
            rebalance();
            updateMedian();
        }

        public double getMedian() {
            return median;
        }

        public void rebalance() {
            if (low.size() - high.size() == 2) {
                high.insert(low.remove());
            } else if (high.size() - low.size() == 2) {
                low.insert(high.remove());
            }
        }

        public void updateMedian() {
            if (low.size() == high.size()) {
                this.median = (low.getTop() + high.getTop()) / 2.0;
            } else if (low.size() > high.size()) {
                this.median = low.getTop();
            } else {
                this.median = high.getTop();
            }
        }
    }

    static class Heap {

        BiFunction<Integer, Integer, Boolean> compareFunction;

        List<Integer> heap;

        Heap(BiFunction<Integer, Integer, Boolean> compareFunction, List<Integer> array) {
            this.compareFunction = compareFunction;
            heap = buildHeap(array);
        }

        public static Boolean MAX_HEAP(Integer a, Integer b) {
            return a > b;
        }

        public static Boolean MIN_HEAP(Integer a, Integer b) {
            return a < b;
        }

        public static void swap(List<Integer> array, int i, int j) {
            Integer tmp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, tmp);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParent = (array.size() - 2) / 2;
            for (int i = firstParent; i >= 0; i --) {
                siftDown(i, array.size() - 1);
            }
            return array;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1);
        }

        public Integer remove() {
            swap(heap, 0, heap.size() - 1);
            int toRemove = heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1);
            return toRemove;
        }

        public void siftDown(int start, int end) {
            int leftIdx = 2 * start + 1;
            while (leftIdx <= end) {
                int rightIdx = leftIdx + 1 <= end ? leftIdx + 1 : -1;
                int toCompare = leftIdx;
                if (rightIdx != -1 && compareFunction.apply(heap.get(rightIdx), heap.get(leftIdx))) {
                    toCompare = rightIdx;
                }
                if (compareFunction.apply(heap.get(start), heap.get(toCompare))) {
                    return;
                }
                swap(heap, start, toCompare);
                start = toCompare;
                leftIdx = start * 2 + 1;
            }
        }

        public void siftUp(int start) {
            int parentIdx = (start - 1) / 2;
            while (start > 0 && compareFunction.apply(heap.get(start), heap.get(parentIdx))) {
                swap(heap, start, parentIdx);
                start = parentIdx;
                parentIdx = (start - 1) / 2;
            }
        }

        public int size() {
            return heap.size();
        }

        public Integer getTop() {
            return heap.get(0);
        }
    }

    public static void main(String[] args) {
        ContinuousMedianHandler continousMedian = new ContinuousMedianHandler();
        continousMedian.insert(5);
        continousMedian.insert(10);
        System.out.println(continousMedian.getMedian());
    }
}
