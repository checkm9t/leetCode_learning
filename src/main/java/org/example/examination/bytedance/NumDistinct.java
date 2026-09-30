package org.example.examination.bytedance;

// 不同的子序列
// leetcode 115
public class NumDistinct {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        long[][] dp = new long[m+1][n+1];
        // 初始化：t为空串时，方案数=1
        for(int i = 0; i <= m; i++) dp[i][0] = 1;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    // dp[i-1][j]:不选s.charAt(i-1)去匹配
                    // dp[i-1][j-1]:选s.charAt(i-1)去匹配
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }else{
                    // 和不选的情况是一样的
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return (int)dp[m][n];
    }
}
