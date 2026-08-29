package org.example.leetcode;


import java.util.HashMap;
import java.util.Map;
// 和为k的子数组
// leetcode 560
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preCnt = new HashMap<>();
        int res = 0;
        int sum = 0;

        // 当刚好等于k时，需要+1
        preCnt.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // 注意：下面两个不能交换顺序
            // 因为如果先放了再计数的话。当k为0时，会计入空数组
            if (preCnt.containsKey(sum - k)) {
                res += preCnt.get(sum - k);
            }
            preCnt.put(sum, preCnt.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
