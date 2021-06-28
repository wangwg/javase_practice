package com.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * xiaOgang
 */
public class BinaryTreeTraversal {

    /**
     * 中序遍历 左-根-右
     *
     * @param root
     */
    public void printTreeInOrder(TreeNode root) {
        if (root == null) return;

        printTreeInOrder(root.left);
        System.out.print(root.val + "\t");
        printTreeInOrder(root.right);
    }

    /**
     * 先序遍历 根-左-右
     *
     * @param root
     */
    public void printTreePreOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + "\t");
        printTreeInOrder(root.left);
        printTreeInOrder(root.right);
    }

    /**
     * 后续遍历 左-右-根
     *
     * @param root
     */
    public void printTreePostOrder(TreeNode root) {
        if (root == null) return;

        printTreeInOrder(root.left);
        printTreeInOrder(root.right);
        System.out.print(root.val + "\t");
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    public void printTreeLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            System.out.print(currNode.val + "\t");

            if (currNode.left != null)
                queue.offer(currNode.left);

            if (currNode.right != null)
                queue.offer(currNode.right);
        }

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

        treePrinter.printTreeInOrder(node1);
        System.out.println();
        treePrinter.printTreePreOrder(node1);
        System.out.println();
        treePrinter.printTreePostOrder(node1);
        System.out.println();
        treePrinter.printTreeLevelOrder(node1);
    }
}
