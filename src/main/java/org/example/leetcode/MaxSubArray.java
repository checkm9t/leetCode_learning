package org.example.leetcode;

// 最大子数组和
// leetcode 53
public class MaxSubArray {

    /**
     * dp[i]:以i结尾的最大数组和
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {

            // 这里nums数组记得是有左移一位的
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
