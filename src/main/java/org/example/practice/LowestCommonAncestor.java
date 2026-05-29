package org.example.practice;

public class LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 先考虑自身，如果自身是节点之一，直接返回
        if (root == p || root == q) {
            return root;
        }

        // 再考虑子节点：
        // 如果左右节点都不为空，返回父节点
        if (left != null && right != null) {
            return root;
        }
        // 如果左右节点都为空，返回空
        if (left == null && right == null) {
            return null;
        }
        // else：返回不为空的节点
        return left != null ? left : right;
    }
}