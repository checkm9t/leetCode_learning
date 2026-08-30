package org.example.leetcode;

import java.util.Arrays;

public class CoinChange {

    // 完全背包
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // amount+1 是不可能达到的最大值，又不会像最大int容易越界
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // coins不能升序，所以不能写在循环判断条件里
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}
