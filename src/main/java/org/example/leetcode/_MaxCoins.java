package org.example.leetcode;

public class _MaxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // 意义：戳破 (i,j) 里面所有的气球，获得的最大硬币数
        // 左右两边各加一个虚拟气球 1
        int[][] dp = new int[n + 2][n + 2];

        // 要注意虽然dp加了两个元素，但是nums大小没变，用一个新的数组更方便
        int[] val = new int[n + 2];
        val[0] = 1;
        val[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            val[i] = nums[i - 1];
        }

        // 因为依赖于dp[k][j]
        // 如果正序的话，都还没计算出来，需要倒序
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {

                    // 注意用val而不是用nums
                    int sum = dp[i][k] + dp[k][j]
                            + val[i] * val[j] * val[k];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }

        return dp[0][n + 1];
    }

}
