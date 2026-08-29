package org.example.leetcode;

// 轮转数组
// leetcode 189
public class Rotate {

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // 注意：这个很重要，防止数组越界
        k = k % n;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }

    public void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
