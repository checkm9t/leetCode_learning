package org.example.practice;

public class KthSmallest {

    public static int cnt;
    public static int res;

    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        kthSmallest(root);
        return res;
    }

    public void kthSmallest(TreeNode root) {
        if (root == null || cnt == 0) {
            return;
        }

        kthSmallest(root.left);
        cnt--;
        if (cnt == 0) {
            res = root.val;
            return;
        }
        kthSmallest(root.right);

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
