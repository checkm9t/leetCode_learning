package org.example.leetcode;

import org.example.common.TreeNode;

// 翻转二叉树
// leetcode 226
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode t1 = invertTree(root.left);
        TreeNode t2 = invertTree(root.right);

        root.left = t2;
        root.right = t1;

        return root;
    }
}
