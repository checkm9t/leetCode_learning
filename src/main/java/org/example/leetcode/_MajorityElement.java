package org.example.leetcode;

public class _MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;

        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }

            if (candidate == num) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return cnt == 0 ? -1 : candidate;
    }
}
