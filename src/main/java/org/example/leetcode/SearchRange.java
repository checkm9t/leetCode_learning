package org.example.leetcode;

// 在排序数组中查找元素的第一个和最后一个位置
// leetcode 34
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 0) {
            return new int[] { first, last };
        }

        while (left <= right) {
            // 这里要注意括号, >>优先级比较小
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        first = left;

        // 这里需要先判断数组中是否有对应的数字
        if (first<0 ||first>=nums.length || nums[first] != target) {
            return new int[] { -1, -1 };
        }

        // 记得要重新初始化left和right
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        last = right;

        return new int[] { first, last };
    }
}
