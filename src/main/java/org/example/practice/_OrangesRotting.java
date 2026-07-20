package org.example.practice;

import java.util.LinkedList;
import java.util.Queue;

public class _OrangesRotting {

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        // 初始设置为-1，否则会多算1层
        int res = 0;
        int fresh = 0;
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    que.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!que.isEmpty()) {
            int size = que.size();
            res++;
            for (int i = 0; i < size; i++) {
                int[] cur = que.poll();
                for (int k = 0; k < 4; k++) {
                    int nextx = cur[0] + dir[k][0];
                    int nexty = cur[1] + dir[k][1];
                    if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < m
                            && visited[nextx][nexty] == false && grid[nextx][nexty] == 1) {
                        //这里判断条件是 == 1，因为如果是2的话，这个地方已经被广度搜索覆盖过了
                        que.add(new int[]{nextx, nexty});
                        visited[nextx][nexty] = true;
                        fresh--;
                        //注意这里不能加了
                        //res++;
                    }
                }
            }
        }

        if (fresh > 0) {
            return -1;
        }

        // 不能直接设置res为-1，否则在没有橘子的时候，会返回-1而不是0
        return Math.max(res - 1, 0);
    }
}
