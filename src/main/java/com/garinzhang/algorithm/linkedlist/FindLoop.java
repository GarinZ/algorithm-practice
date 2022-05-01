package com.garinzhang.algorithm.linkedlist;

public class FindLoop {

    static ListNode findLoop(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode.next;
        if (fast == null) {
            return null;
        }
        fast = fast.next;
        while (fast != null && slow != fast) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
        }
        if (fast == null) {
            return null;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }

    static class ListNode {
        ListNode next;
        Integer value;
    }
}
