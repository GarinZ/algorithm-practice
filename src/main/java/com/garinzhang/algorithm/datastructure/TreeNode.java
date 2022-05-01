package com.garinzhang.algorithm.datastructure;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode createTreeNode(int[] array) {
        TreeNode root = new TreeNode(array[0]);
        buildSubNode(root, array, 0);
        return root;
    }
    
    private static void buildSubNode(TreeNode node, int[] array, int index) {
        int leftIndex = 2 * index + 1;
        if (leftIndex < array.length) {
            node.left = new TreeNode(array[leftIndex]);
            buildSubNode(node.left, array, leftIndex);
        }
        int rightIndex = 2 * index + 2;
        if (rightIndex < array.length) {
            node.right = new TreeNode(array[rightIndex]);
            buildSubNode(node.right, array, rightIndex);
        }
    }
    
    public static void main(String[] args) {
        TreeNode node = TreeNode.createTreeNode(new int[]{5, 3, 2, 8, 7, 4});
    }
}
