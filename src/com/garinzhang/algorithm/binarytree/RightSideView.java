package com.garinzhang.algorithm.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Garin
 * @date 2020-11-05
 */
public class RightSideView {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        // BFS
        List<Integer> array = new ArrayList<>();
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int counter = 1;
        int currentCounter = 0;
        TreeNode current = root;
        while (!queue.isEmpty()) {
            if (counter == 0) {
                counter = currentCounter;
                array.add(current.val);
            }
            current = queue.remove(0);
            counter --;
            if (current.left != null) {
                queue.add(current.left);
                currentCounter ++;
            }
            if (current.right != null) {
                queue.add(current.right);
                currentCounter ++;
            }
        }
        array.add(current.val);
        return array;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1_l = new TreeNode(2);
        TreeNode l1_r = new TreeNode(3);
        root.left = l1_l;
        root.right = l1_r;
        TreeNode l2_l_l = new TreeNode(4);
        TreeNode l2_l_r = new TreeNode(5);
        l1_l.left = l2_l_l;
        l1_l.right = l2_l_r;
        TreeNode l2_r_l = new TreeNode(6);
        l1_r.left = l2_r_l;
        TreeNode l3_r_l_l = new TreeNode(7);
        l2_r_l.left = l3_r_l_l;

        List<Integer> integers = rightSideView(root);
        System.out.println(Arrays.toString(integers.toArray()));

    }
}
