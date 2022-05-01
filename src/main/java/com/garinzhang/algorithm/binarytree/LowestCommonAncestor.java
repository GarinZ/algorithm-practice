package com.garinzhang.algorithm.binarytree;

import com.garinzhang.algorithm.datastructure.TreeNode;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode(new int[] { 3, 5, 1, 6, 2, 0, 8, 0, 0, 7, 4 });
        TreeNode p = root.left.right;
        TreeNode q = root.left.left.left;
        System.out.println(lowestCommonAncestor(root, p, q).equals(root.left));
    }
}
