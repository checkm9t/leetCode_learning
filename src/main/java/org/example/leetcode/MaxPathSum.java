package org.example.leetcode;

import org.example.common.TreeNode;

public class MaxPathSum {
    public int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return res;
    }

    /**
     从下任意节点到node的最大值
     */
    public int maxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(maxPath(node.left), 0);
        int rightMax = Math.max(maxPath(node.right), 0);

        res = Math.max(res, leftMax + rightMax + node.val);

        return Math.max(leftMax, rightMax) + node.val;
    }
}
