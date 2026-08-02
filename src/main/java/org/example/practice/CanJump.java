package org.example.practice;

public class CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;

        for (int i = 0; i <= rightMost; i++) {
            rightMost = Math.max(rightMost, i + nums[i]);
            if (rightMost >= n - 1) {
                return true;
            }
        }

        return false;

    }
}
