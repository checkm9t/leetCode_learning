package org.example.leetcode;

import java.util.Arrays;

// 最长递增子序列
// leetcode 300
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int n = nums.length;
        // 以nums[i]结尾的最长递增子序列
        int[] dp = new int[n];

        // 这个很重要，如果没有大于上一个情况的话，应该从1开始
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
