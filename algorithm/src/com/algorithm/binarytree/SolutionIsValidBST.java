package com.algorithm.binarytree;

/**
 * xiaOgang LeetCode #98
 */
public class SolutionIsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return validator(root.left, null, root.val) && validator(root.right, root.val, null);
    }

    private boolean validator(TreeNode node, Integer lowBound, Integer upperBound) {
        if (node == null) return true;

        if (lowBound != null && node.val <= lowBound)
            return false;

        if (upperBound != null && node.val >= upperBound)
            return false;

        return validator(node.left, lowBound, node.val) && validator(node.right, node.val, upperBound);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(new SolutionIsValidBST().isValidBST(root));

        TreeNode root1 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(new SolutionIsValidBST().isValidBST(root1));

        TreeNode root2 = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(new SolutionIsValidBST().isValidBST(root2));
    }
}
