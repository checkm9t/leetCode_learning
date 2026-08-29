package org.example.leetcode;

import org.example.common.TreeNode;

// 二叉树的最大深度
// leetcode 104
public class MaxDepth {


    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftd = maxDepth(root.left);
        int rightd = maxDepth(root.right);

        return Math.max(leftd, rightd) + 1;
    }
}
