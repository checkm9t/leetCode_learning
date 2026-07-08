package org.example.practice;

public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;

        while (left < right) {
            int v = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(v, res);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
