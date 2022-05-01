package com.garinzhang.algorithm.linkedlist;

import com.garinzhang.algorithm.datastructure.ListNode;

/**
 * 148. 排序链表
 * {@link https://leetcode-cn.com/problems/sort-list/} 
 */
public class LinkedListSort {
    public static ListNode sortLinkedList(ListNode node) {
        // 1. recursion's end condition
        if (node == null || node.next == null) {
            return node;
        }
        // 2. find mid point in linked list
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 3. recursivly split linked list
        ListNode subList = slow.next;
        slow.next = null;
        node = sortLinkedList(node);
        subList = sortLinkedList(subList);
        // 4. merge two sorted linked list
        ListNode pt1 = node;
        ListNode pt2 = subList;
        ListNode prev = null;
        while (pt1 != null && pt2 != null) {
            if (pt1.val < pt2.val) {
                prev = pt1;
                pt1 = pt1.next;
            } else {
                if (prev != null) {
                    prev.next = pt2;
                }
                prev = pt2;
                pt2 = pt2.next;
                prev.next = pt1;
            }
        }
        if (pt2 != null) {
            prev.next = pt2;
        }
        return node.val < subList.val ? node : subList;
    }

    public static void main(String[] args) {
        // ListNode.print(sortLinkedList(ListNode.createListNode(new int[]{5, 4, 3, 2, 1})));
        // ListNode.print(sortLinkedList(ListNode.createListNode(new int[]{4, 6, 3, 5, 2, 0, 1})));
        ListNode.print(sortLinkedList(ListNode.createListNode(new int[]{5, 6, 6, 6, 9, 2, 1, 1})));
    }
}
