package org.example.leetcode;

// 二叉搜索树中第k小的元素
// leetcode 230
public class KthSmallest {

    public static int cnt;
    public static int res;

    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        kthSmallest(root);
        return res;
    }

    public void kthSmallest(TreeNode root) {

        // 这里需要判断是否已经找到对应的值
        if (root == null || cnt == 0) {
            return;
        }

        kthSmallest(root.left);

        // 在 中序节点 进行减操作
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
