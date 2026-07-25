package org.example.practice;

public class MinDistance {


    /**
     * for (int i = 1; i <= l1; i++) {
     * for (int j = 1; j <= l2; j++) {
     * int n1 = dp[i][j - 1] + 1;
     * int n2 = dp[i - 1][j] + 1;
     * int n3;
     * <p>
     * // 这里注意要有判断
     * if (word1.charAt(i-1) == word2.charAt(j-1)) {
     * n3 = dp[i - 1][j - 1];
     * } else {
     * n3 = dp[i - 1][j - 1] + 1;
     * }
     * <p>
     * dp[i][j] = Math.min(n1, Math.min(n2, n3));
     * }
     * }
     */
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        // 这个注意要+1
        int[][] dp = new int[l1 + 1][l2 + 1];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int n1 = dp[i][j - 1] + 1;
                int n2 = dp[i - 1][j] + 1;
                int n3;

                // 这里注意要有判断
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
