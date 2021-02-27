package com.garinzhang.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.garinzhang.algorithm.datastructure.TreeNode;

public class IterativeInOrderTraversal {

    public static List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                current = node.right;
            }
        }
        return result;
    }
}
