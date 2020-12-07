package com.garinzhang.algorithm.datastructure;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode createListNode(int[] array) {
    ListNode head = new ListNode();
    ListNode tail = head;
    for (int item : array) {
      tail.next = new ListNode(item);
      tail = tail.next;
    }
    return head.next;
  }

  public static void print(ListNode listNode) {
    StringBuffer sb = new StringBuffer();
    while (listNode != null) {
      sb.append(listNode.val).append("->");
      listNode = listNode.next;
    }
    sb.append("null");
    System.out.println(sb.toString());
  };
}
