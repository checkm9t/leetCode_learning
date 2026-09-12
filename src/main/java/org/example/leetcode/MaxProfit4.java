package org.example.leetcode;

public class MaxProfit4 {

    /**
     * dp[i][2*j]:在第j次购入
     * dp[i][2*j+1]:在第j次卖出
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }

        int[][] dp = new int[n][k * 2 + 1];

        for (int i = 0; i <= k * 2; i++) {
            if (i % 2 == 1) {
                dp[0][i] = -prices[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 2 * k; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }
        return dp[n - 1][k * 2];
    }
}
