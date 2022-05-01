package com.garinzhang.algorithm.linkedlist;

import com.garinzhang.algorithm.datastructure.ListNode;

public class ReverseLinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode.print(reverseLinkedList(ListNode.createListNode(new int[]{1, 2, 3, 4, 5})));
    }
}
