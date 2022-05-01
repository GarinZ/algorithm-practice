package com.garinzhang.algorithm.linkedlist;

import com.garinzhang.algorithm.datastructure.ListNode;

public class AddTwoNumbers {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode tail = head;
    boolean carry = false;
    while (l1 != null || l2 != null) {
      int sum = 0;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      if (carry) {
        sum++;
      }
      tail.next = new ListNode(sum % 10);
      tail = tail.next;
      carry = sum >= 10;
    }
    if (carry) {
      tail.next = new ListNode(1);
    }
    return head.next;
  }

  public static void main(String[] args) {
    // case1: carry in middle && digit equal
    // ListNode l1 = ListNode.createListNode(new int[]{2, 4, 3});
    // ListNode l2 = ListNode.createListNode(new int[]{5, 6, 4});;
    // ListNode.print(addTwoNumbers(l1, l2));

    // case2: carry in last && digit not equal
    ListNode l1_1 = ListNode.createListNode(new int[]{9,9,9,9,9,9,9});
    ListNode l2_1 = ListNode.createListNode(new int[]{9,9,9,9});
    ListNode.print(addTwoNumbers(l1_1, l2_1));

    // case3: carry in last && digit equal
    // ListNode l1_2 = ListNode.createListNode(new int[]{5});
    // ListNode l2_2 = ListNode.createListNode(new int[]{5});
    // ListNode.print(addTwoNumbers(l1_2, l2_2));
  }
}
