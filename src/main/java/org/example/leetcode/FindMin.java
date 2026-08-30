package org.example.leetcode;

public class FindMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;

            // 用n-1判断，天然包含了没有旋转的情况
            if (nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                // 尽可能往左找
                right = mid - 1;
            }
        }

        return nums[left];
    }
}
