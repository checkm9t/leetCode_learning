package org.example.practice;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] before = new int[n];
        int[] res = new int[n];
        before[0] = 1;

        for (int i = 1; i < n; i++) {
            before[i] = before[i - 1] * nums[i - 1];
        }

        int post = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = post * before[i];
            post = post * nums[i];
        }

        return res;
    }
}
