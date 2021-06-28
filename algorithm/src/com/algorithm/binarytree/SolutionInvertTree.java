package com.algorithm.binarytree;

/**
 * xiaOgang LeetCode #226
 */
public class SolutionInvertTree {

    public TreeNode invertTree1(TreeNode root) {

        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
/**
 *    4
 *   2 7
 * 1 3 6 9
 */
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        BinaryTreeTraversal treePrinter = new BinaryTreeTraversal();
        treePrinter.printTreeLevelOrder(node1);
        node1 = new SolutionInvertTree().invertTree(node1);
        System.out.println();
        treePrinter.printTreeLevelOrder(node1);
    }
}
