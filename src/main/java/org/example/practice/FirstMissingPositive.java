package org.example.practice;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            //这样判断是错的。只判断了交换位置是不是相同
            //while (nums[i] > 0 && nums[i] <= n && nums[i] - 1 != i) {
            // 应该判断的是交换的值有没有变，如果没有变则不用交换。这样才能覆盖到循环的情况
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
