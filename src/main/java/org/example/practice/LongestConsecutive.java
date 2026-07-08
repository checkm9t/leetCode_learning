package org.example.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int res = 0;
        for (int a : nums) {
            numSet.add(a);
        }
        // 这个很重要，遍历set而不是数组
        for (int b : numSet) {
            // 这个很重要，防止重复计算
            if (numSet.contains(b - 1)) {
                continue;
            }

            int cnt = 1;
            while (numSet.contains(b + cnt)) {
                cnt++;
            }

            res = Math.max(res, cnt);
        }

        return res;
    }
}
