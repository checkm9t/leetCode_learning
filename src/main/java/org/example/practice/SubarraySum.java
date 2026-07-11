package org.example.practice;


import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preCnt = new HashMap<>();
        int res = 0;
        int sum = 0;

        // 当刚好等于k时，需要+1
        preCnt.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preCnt.containsKey(sum - k)) {
                res += preCnt.get(sum - k);
            }
            preCnt.put(sum, preCnt.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
