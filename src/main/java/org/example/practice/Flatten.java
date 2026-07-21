package org.example.practice;

import java.util.ArrayList;
import java.util.List;

public class Flatten {

    public void flatten(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();

        preorder(root, res);

        TreeNode dummy = new TreeNode();
        TreeNode cur = dummy;

        for (int i = 0; i < res.size(); i++) {
            TreeNode node = res.get(i);
            cur.left = null;
            cur.right = node;
            cur = node;
        }

        dummy.right = null;
    }

    public void preorder(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        res.add(root);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
