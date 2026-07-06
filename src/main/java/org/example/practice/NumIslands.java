package org.example.practice;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {

    public int res = 0;
    public boolean[][] visited;

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        visited = new boolean[n][m];

        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    res++;
                    que.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!que.isEmpty()) {
                        int[] cur = que.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextx = cur[0] + dir[k][0];
                            int nexty = cur[1] + dir[k][1];
                            if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < m
                                    && visited[nextx][nexty] == false && grid[nextx][nexty] == '1') {
                                visited[nextx][nexty] = true;
                                que.add(new int[]{nextx, nexty});
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

}
