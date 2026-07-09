package org.example.practice;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int[] counts = new int[128];
        int res = 0;

        while (right < s.length()) {
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
