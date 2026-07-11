package org.example.practice;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> que = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            while (!que.isEmpty() && nums[i] > nums[que.peekLast()]) {
                que.pollLast();
            }
            que.offerLast(i);
        }
        res[0] = nums[que.peekFirst()];

        for (int i = k; i < n; i++) {
            while (!que.isEmpty() && nums[i] > nums[que.peekLast()]) {
                que.pollLast();
            }
            que.offerLast(i);
            while (que.peekFirst() <= i - k) {
                que.pollFirst();
            }
            res[i - k + 1] = nums[que.peekFirst()];
        }

        return res;
    }
}
