package com.garinzhang.algorithm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大堆
 */
public class MinHeap {

    List<Integer> heap = new ArrayList<>();
	
    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
        int firstParentIdx = (array.size() - 2) / 2;
        for (int i = firstParentIdx; i >= 0; i --) {
            siftDown(i, array.size() - 1, array);
        }
        return array;
    }

    public void siftDown(int start, int end, List<Integer> heap) {
        Integer left = start * 2 + 1;
        while (left <= end) {
            Integer right = start * 2 + 2 <= end ? start * 2 + 2 : -1;
            Integer smaller = left;
            if (right != -1 && heap.get(right) < heap.get(left)) {
                smaller = right;
            }
            if (heap.get(start) <= heap.get(smaller)) {
                return;
            }
            swap(start, smaller, heap);
            start = smaller;
            left = smaller * 2 + 1;
        }
    }

    public void siftUp(int start, List<Integer> heap) {
        while (start > 0 && heap.get(start) < heap.get((start - 1) / 2)) {
            swap(start, (start - 1) / 2, heap);
            start = (start - 1) / 2;
        }
    }

    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }

    public int remove() {
        swap(0, heap.size() - 1, heap);
        int toRemove = heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return toRemove;
    }

    public int peek() {
        return heap.get(0);
    }

    public static void swap(int a, int b, List<Integer> array) {
        Integer tmp = array.get(a);
        array.set(a, array.get(b));
        array.set(b, tmp);
    }

    
}
