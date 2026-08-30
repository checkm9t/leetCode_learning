package org.example.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 分割回文串
// leetcode 131
public class Partition {

    public List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        /**
         先用动态规划找到回文子串
         dp[i][j] =  s.charAt(i)==s.charAt(j) &&dp [i+1][j-1]
         */
        // 已经把i==j、i<j的情况都设置为true了
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            // 这样设置不会有越界的情况
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }

        dfs(dp, s, 0, new ArrayList<>());

        return res;
    }

    public void dfs(boolean[][] dp, String s, int index, List<String> tmp) {
        if (index == s.length()) {
            res.add(new ArrayList<>(tmp));
        }

        for (int j = index; j < s.length(); j++) {
            if (dp[index][j]) {
                tmp.add(s.substring(index, j + 1));
                dfs(dp, s, j + 1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
