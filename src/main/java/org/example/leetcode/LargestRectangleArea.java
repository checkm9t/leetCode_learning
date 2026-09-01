package org.example.leetcode;

import java.util.Arrays;
import java.util.Stack;

// 柱状图中最大的矩阵
// leetcode 84
public class LargestRectangleArea {

    // 找左右延伸的最大值
    // 用单调栈找
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        // 左边比i小的第一个索引
        int[] left = new int[n];
        // 右边比i小的第一个索引
        int[] right = new int[n];

        // 因为可能单调栈没有处理完，剩余的右边界并没有设置
        Arrays.fill(right, n);

        // 递增栈
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int tmp = stack.pop();
                right[tmp] = i;
            }
            // 现在栈顶元素一定小于等于i的元素
            // 如果是空的话，左边界是-1
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }

        return res;
    }
}
