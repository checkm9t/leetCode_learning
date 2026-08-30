package org.example.leetcode;

public class _SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            //int mid = (left + right) / 2;
            int mid = ((right - left) >> 1) + left;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }

        // 因为left一定大于right
        return left;
    }
}
