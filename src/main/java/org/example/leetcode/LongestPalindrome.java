package org.example.leetcode;

import java.util.Arrays;

// 最长回文子串
// leetcode 5
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = s.substring(0,1);

        // 这个初始化很重要
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }

        // 注意这个i，j初始化
        // i和j如果交错了就是true
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }
}
