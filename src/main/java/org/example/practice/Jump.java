package org.example.practice;

public class Jump {

    public int jump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        int end = 0;
        int steps = 0;

        // 注意：当end为最后一个元素的时候不需要再跳，所以i<n-1
        for (int i = 0; i < n - 1; i++) {
            rightMost = Math.max(rightMost, i + nums[i]);
            if (i == end) {
                end = rightMost;
                steps++;
            }
        }

        return steps;
    }

}
