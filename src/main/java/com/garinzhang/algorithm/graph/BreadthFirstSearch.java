package com.garinzhang.algorithm.graph;

import java.util.*;

/**
 * @author Garin
 * @date 2020-10-30
 */
public class BreadthFirstSearch {
    public static class Node {
        String value;
        List<Node> children = new ArrayList<>();

        Node(String value) {
            this.value = value;
        }

        public void addChild(Node node) {
            children.add(node);
        }

        public List<String> breadthFirstSearch() {
            List<String> result = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (queue.size() > 0) {
                Node current = queue.poll();
                result.add(current.value);
                queue.addAll(current.children);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Node root = new Node("A");
        Node b = new Node("B");
        b.addChild(new Node("E"));
        b.addChild(new Node("F"));
        Node c = new Node("C");
        b.addChild(new Node("G"));
        b.addChild(new Node("H"));
        Node d = new Node("D");
        b.addChild(new Node("I"));
        b.addChild(new Node("J"));
        root.addChild(b);
        root.addChild(c);
        root.addChild(d);

        List<String> result = root.breadthFirstSearch();
        System.out.println(Arrays.toString(result.toArray()));

    }
}
