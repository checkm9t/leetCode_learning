package org.example.leetcode;

// 搜索旋转排序数组
// leetcode 33
public class Search {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target == nums[mid]) {
                return mid;
            }

            // 用最后一个数作为分界点
            if (nums[mid] > nums[n-1]) {
                // 判断是否在左边的升区间
                if (target < nums[mid] && target > nums[n-1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[n-1]) {
                // 判断是否在右边的升区间
                if (target > nums[mid] && target <= nums[n-1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
