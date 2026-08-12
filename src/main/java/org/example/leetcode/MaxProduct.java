package org.example.leetcode;

/**
 * 以第i个数结尾的最大值
 * dp[i][1]:最大值
 * dp[i][0]:最小值
 */
public class MaxProduct {

    /**
     * dp[i][0]：以i结尾的，最小的连续乘积
     * dp[i][1]：以i结尾的，最大的连续乘积
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        // 这里需要设置为nums[0]，而不是0初始值
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1] * nums[i], Math.max(nums[i], dp[i - 1][0] * nums[i]));
            dp[i][0] = Math.min(dp[i - 1][1] * nums[i], Math.min(nums[i], dp[i - 1][0] * nums[i]));
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
