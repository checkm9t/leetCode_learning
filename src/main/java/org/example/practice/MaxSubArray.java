package org.example.practice;

/**
 * dp[i]:以i结尾的最大数组和
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
