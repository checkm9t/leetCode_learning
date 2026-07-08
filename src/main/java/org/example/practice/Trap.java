package org.example.practice;

import java.util.Stack;

public class Trap {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int high = Math.min(height[i], height[left]) - height[mid];
                int wide = i - left - 1;
                res += wide * high;
            }
            stack.push(i);
        }

        return res;
    }
}
