package com.garinzhang.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Garin
 * @date 2020-11-04
 */
public class LRU {
    static class LRUCache {
        int maxSize;
        int currentSize;
        Map<String, Node> cache = new HashMap<>();
        DoublyLinkedList list = new DoublyLinkedList();

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        public void insertKeyValuePair(String key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                list.setHead(node);
                return;
            }
            if (currentSize == maxSize) {
                cache.remove(list.tail.key);
                list.removeTail();
            } else {
                currentSize++;
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            list.setHead(node);
        }

        public LRUResult getValueFromKey(String key) {
            if (!cache.containsKey(key)) {
                return new LRUResult(false, 0);
            }
            Node node = cache.get(key);
            list.setHead(node);
            return new LRUResult(true, node.value);
        }

        public String getMostRecentKey() {
            return list.head.key;
        }
    }

    static class DoublyLinkedList {
        Node head;
        Node tail;

        DoublyLinkedList() {
            head = null;
            tail = null;
        }

        public void setHead(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            insertBefore(head, node);
        }

        public void removeTail() {
            remove(tail);
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) {
                return;
            }
            remove(nodeToInsert);
            nodeToInsert.next = node;
            nodeToInsert.prev = node.prev;
            if (node.prev == null) {
                head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        public void remove(Node node) {
            if (node == head) {
                head = head.next;
            }
            if (node == tail) {
                tail = tail.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.next = null;
            node.prev = null;
        }
    }

    static class Node {
        Node next;
        Node prev;
        int value;
        String key;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        LRUResult result = cache.getValueFromKey("a");
        System.out.println("getValueFromKey: key=a, value=" + result.value);
        cache.insertKeyValuePair("a", 1);
        result = cache.getValueFromKey("a");
        System.out.println("getValueFromKey: key=a, value=" + result.value);
        cache.insertKeyValuePair("a", 9001);
        result = cache.getValueFromKey("a");
        System.out.println("getValueFromKey: key=a, value=" + result.value);
        cache.insertKeyValuePair("b", 2);
        result = cache.getValueFromKey("a");
        System.out.println("getValueFromKey: key=a, value=" + result.value);
        result = cache.getValueFromKey("b");
        System.out.println("getValueFromKey: key=b, value=" + result.value);
        cache.insertKeyValuePair("c", 3);
        result = cache.getValueFromKey("a");
        System.out.println("getValueFromKey: key=a, value=" + result.value);
        result = cache.getValueFromKey("b");
        System.out.println("getValueFromKey: key=b, value=" + result.value);
        result = cache.getValueFromKey("c");
        System.out.println("getValueFromKey: key=c, value=" + result.value);


        cache.insertKeyValuePair("a", 1);
        cache.insertKeyValuePair("c", 3);
        String mostRecentKey = cache.getMostRecentKey();
        System.out.println("mostRecentKey: " + mostRecentKey);

        mostRecentKey = cache.getMostRecentKey();
        System.out.println("mostRecentKey: " + mostRecentKey);
        cache.insertKeyValuePair("d", 4);
        result = cache.getValueFromKey("b");
        System.out.println("getValueFromKey: key=b, value=" + result.value);
        cache.insertKeyValuePair("a", 5);
        result = cache.getValueFromKey("a");
        System.out.println("getValueFromKey: key=a, value=" + result.value);
    }
}
