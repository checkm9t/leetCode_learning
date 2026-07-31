package org.example.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();

        for (int n : nums) {
            cntMap.put(n, cntMap.getOrDefault(n, 0) + 1);
        }

        // 创建的反而是小顶堆
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();

            // 只维护heap的大小为k，堆顶是最小的，因为返回顺序不限制
            if (heap.size() >= k) {
                if (heap.peek()[1] < count) {
                    heap.poll();
                    heap.offer(new int[] { num, count });
                }
            } else {
                heap.offer(new int[] { num, count });
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[0];
        }

        return res;
    }
}
