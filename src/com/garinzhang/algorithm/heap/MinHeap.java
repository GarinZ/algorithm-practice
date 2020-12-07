package com.garinzhang.algorithm.heap;

import java.util.*;

/**
 * @author Garin
 * @date 2020-10-30
 */
public class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
        System.out.println(Arrays.toString(heap.toArray()));
    }

    public List<Integer> buildHeap(List<Integer> array) {
        int firstParent = (array.size() - 2) / 2;
        for (int i = firstParent; i >= 0; i --) {
            siftDown(firstParent, array.size() - 1, array);
        }
        return array;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int leftIdx = currentIdx * 2 + 1;
        while (leftIdx <= endIdx) {
            int rightIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            int toSwapIdx = leftIdx;
            if (rightIdx != -1 && heap.get(rightIdx) < heap.get(leftIdx)) {
                toSwapIdx = rightIdx;
            }
            if (heap.get(toSwapIdx) >= heap.get(currentIdx)) {
                return;
            }
            swap(heap, currentIdx, toSwapIdx);
            currentIdx = toSwapIdx;
            leftIdx = currentIdx * 2 + 1;
        }
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
        int i = currentIdx;
        while (i > 0 && heap.get(i) < heap.get((i - 1) / 2)) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public int remove() {
        swap(heap, 0, heap.size() - 1);
        int toRemove = heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return toRemove;
    }

    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }

    public static void swap(List<Integer> heap, Integer i, Integer j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    public static void main(String[] args) {
        // List<Integer> array = Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41);
        // MinHeap heap = new MinHeap(array);
    }
}
