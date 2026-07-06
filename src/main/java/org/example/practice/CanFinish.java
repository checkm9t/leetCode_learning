package org.example.practice;

import java.util.*;

public class CanFinish {

    public int[] indeg;
    public Map<Integer, List<Integer>> map;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        indeg = new int[numCourses];
        map = new HashMap<>();

        for (int[] pre : prerequisites) {
            indeg[pre[0]]++;
            List<Integer> newList = map.getOrDefault(pre[1], new ArrayList<>());
            newList.add(pre[0]);
            map.put(pre[1], newList);
        }


        Queue<Integer> zeros = new LinkedList<>();
        // 这里要用i遍历，否则添加的是入度值
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                zeros.add(i);
            }
        }

        while (!zeros.isEmpty()) {
            int cur = zeros.poll();
            // 这里用getOrDefault，否则容易空指针
            List<Integer> curList = map.getOrDefault((cur), new ArrayList<>());
            for (Integer c : curList) {
                indeg[c]--;
                if (indeg[c] == 0) {
                    zeros.add(c);
                }
            }
        }

        for (int c : indeg) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
