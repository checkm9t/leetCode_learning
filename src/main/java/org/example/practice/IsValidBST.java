package org.example.practice;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode node, long low, long high) {
        if (node == null) {
            return true;
        }
        if (node.val >= high || node.val <= low) {
            return false;
        }

        boolean leftValid = isValid(node.left, low, node.val);
        boolean rightValid = isValid(node.right, node.val, high);

        return leftValid && rightValid;
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
