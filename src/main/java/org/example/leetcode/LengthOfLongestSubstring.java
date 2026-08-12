package org.example.leetcode;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int[] counts = new int[128];
        int res = 0;

        while (right < s.length()) {
            // 这里需要循环，先找左边，再找右边
            while (counts[s.charAt(right)] > 0 && left <= right) {
                counts[s.charAt(left)]--;
                left++;
            }
            counts[s.charAt(right)]++;
            right++;
            res = Math.max(res, right - left);
        }

        return res;
    }
}
