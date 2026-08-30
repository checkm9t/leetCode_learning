package org.example.leetcode;

public class MinDistance {


    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        // 这个注意要+1
        int[][] dp = new int[l1 + 1][l2 + 1];
        int res = Integer.MAX_VALUE;

        // 0 的时候表示没有字符，空字符串
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                // 往j插入一个
                int n1 = dp[i][j - 1] + 1;

                // 往i插入一个
                int n2 = dp[i - 1][j] + 1;

                // 变化新增的这个两个
                int n3;

                // 注意：这里注意要有判断
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    n3 = dp[i - 1][j - 1];
                } else {
                    n3 = dp[i - 1][j - 1] + 1;
                }

                dp[i][j] = Math.min(n1, Math.min(n2, n3));
            }
        }
        return dp[l1][l2];
    }
}
