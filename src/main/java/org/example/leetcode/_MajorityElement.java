package org.example.leetcode;

// 多数元素
// leetcode 169
public class _MajorityElement {

    // 思路就是，大多数元素，减到最后一定是大于1的
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;

        for (int num : nums) {

            // 顺序不能变，需要先校验
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
