package org.example.examination;

import org.example.common.TreeNode;

// 二叉树的直径
// leetcode 543
public class DiameterOfBinaryTree {

    public int res;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftd = maxDepth(root.left);
        int rightd = maxDepth(root.right);

        res = Math.max(res, leftd + rightd);

        return Math.max(leftd, rightd) + 1;
    }
}
