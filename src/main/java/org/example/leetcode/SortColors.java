package org.example.leetcode;

public class SortColors {

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;

        // 因为p2 是未处理的，所以i要进行处理
        for (int i = 0; i <= p2; i++) {

            // i<=p2 防止越界，并且 p2 小于i的部分不用关注
            // p2 交换过来的位置是有可能是2的，所以循环
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }

            // 因为可以保证 p0 在的位置没有0或2，所以不需要循环
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            }

        }
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
