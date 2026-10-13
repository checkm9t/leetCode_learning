package org.example.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 单词拆分
// leetcode 139
public class _WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        // dp[i]:到charAt(i-1)是否可以被分开
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[n];
    }
}