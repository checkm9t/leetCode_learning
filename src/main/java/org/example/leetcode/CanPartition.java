package org.example.leetcode;

// 分割等和子集
// leetcode 416
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }

        int target = (sum >> 1);
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j - nums[i]] || dp[j];
                }
            }
        }

        return dp[target];
    }

}
