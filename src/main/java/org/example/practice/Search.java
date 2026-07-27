package org.example.practice;

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
            if (nums[mid] >= nums[0]) {
                if (target < nums[mid] && target >= nums[0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[0]) {
                if (target > nums[mid] && target < nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
