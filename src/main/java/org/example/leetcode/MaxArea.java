package org.example.leetcode;

public class MaxArea {

    /**
     * 如果我们**不移动短的 left，而去移动长的 right（right--）**：
     * 新宽度一定变小 (r-l-1)；而容器的高度受限于短板 (h[l])，高度最多还是 (h[l])。
     * 面积一定 ≤ 当前 S，不可能得到更大值。**
     */
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
