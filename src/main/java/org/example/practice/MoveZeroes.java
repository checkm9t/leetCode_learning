package org.example.practice;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;


        while (fast < n) {
            // 需要用非0进行判断，否则会有字符之间顺序变化的情况
            if (nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
