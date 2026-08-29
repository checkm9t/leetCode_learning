package org.example.examination.bytedance;

public class AtMostNGivenDigitSet {


    // 最大为N的数字组合
    // leetcode 902
    public int atMostNGivenDigitSet(String[] digits, int n) {

        String s = String.valueOf(n);
        int k = s.length();
        int l = digits.length;

        // dp[i][0]:位数不超过 i，并且小于 n 当前前缀的数字数量
        // dp[i][1]:使用前i位时，是否有等于
        int[][] dp = new int[k + 1][2];

        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < l; j++) {

                // 计算前缀相同时的数量
                if (dp[i - 1][1] == 1) {
                    if (s.charAt(i - 1) == digits[j].charAt(0)) {
                        dp[i][1] = dp[i - 1][1];
                    } else if (digits[j].charAt(0) < s.charAt(i - 1)) {
                        // 最后一位小于时就添加
                        dp[i][0]++;
                    } else {
                        // 最后一位大于了就应该直接终止内层循环
                        break;
                    }
                }
            }

            // 计算前缀小于n前缀时的数量
            if (i > 1) {
                // 把每个前缀后面都接上第j个字符
                // 接上之后还要加上长度为1的那几个字符
                dp[i][0] += dp[i - 1][0] * l + l;
            }
        }

        return dp[k][0] + dp[k][1];
    }
}
