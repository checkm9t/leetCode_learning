package org.example.leetcode;

import org.example.common.TreeNode;

public class _IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        boolean outside = dfs(left.left, right.right);
        boolean inside = dfs(left.right, right.left);

        return outside && inside;
    }
}
