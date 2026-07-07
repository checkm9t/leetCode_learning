package org.example.practice;

/**
 * 以第i个数结尾的最大值
 * dp[i][1]:最大值
 * dp[i][0]:最小值
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[1];
        for (int i = 1; i < nums.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1] * nums[i], Math.max(nums[i], dp[i - 1][0] * nums[i]));
            dp[i][0] = Math.min(dp[i - 1][1] * nums[i], Math.min(nums[i], dp[i - 1][0] * nums[i]));
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
