package org.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;

// 滑动窗口的最大值
// leetcode 239
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // 需要用一个双向队列
        // 队列中需要保持降序
        Deque<Integer> que = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            // 从队尾加入
            // 如果大于队尾元素，队尾弹出
            while (!que.isEmpty() && nums[i] > nums[que.peekLast()]) {
                que.pollLast();
            }

            // 再加入
            que.offerLast(i);
        }

        res[0] = nums[que.peekFirst()];

        for (int i = k; i < n; i++) {

            // 执行刚才的逻辑
            while (!que.isEmpty() && nums[i] > nums[que.peekLast()]) {
                que.pollLast();
            }
            que.offerLast(i);

            // 附加：如果队头在窗口之外，则先弹出
            while (que.peekFirst() <= i - k) {
                que.pollFirst();
            }

            res[i - k + 1] = nums[que.peekFirst()];
        }

        return res;
    }
}
