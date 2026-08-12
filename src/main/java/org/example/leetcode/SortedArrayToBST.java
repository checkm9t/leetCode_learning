package org.example.leetcode;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = helper(nums, left, mid - 1);
        midNode.right = helper(nums, mid + 1, right);

        return midNode;
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
    }
}
