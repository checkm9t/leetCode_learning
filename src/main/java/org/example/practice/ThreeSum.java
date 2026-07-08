package org.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 这个地方的校验不太一样，必须先计算一次之后，再进行跳过，而不能只计算最后一次
            // nums[i]>0时可以提前结束
            if (i > 0 && nums[i] == nums[i - 1] || nums[i] > 0) {
                continue;
            }
            int cur = nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = cur + nums[left] + nums[right];
                if (sum > 0) {
                    // 这里left<right是为了防止数组越界
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (sum < 0) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else if (sum == 0) {
                    res.add(Arrays.asList(cur, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }
            }
        }
        return res;
    }
}
