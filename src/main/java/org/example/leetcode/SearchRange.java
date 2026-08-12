package org.example.leetcode;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 0) {
            return new int[]{first, last};
        }

        while (left <= right) {
            // 这里要注意括号, >>优先级比较小
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }

        // 记得要重新初始化left和right
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }

        return new int[]{first, last};
    }
}
