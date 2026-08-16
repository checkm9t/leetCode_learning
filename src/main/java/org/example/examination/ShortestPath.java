package org.example.examination;

import java.util.*;

public class ShortestPath {

    public void ShortestPath(){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // 邻接表
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            // 无向图时两边都要加
            graph[from].add(to);
            graph[to].add(from);
        }

        // dist[i]：节点 1 到节点 i 的最短距离
        // -1 表示不可达
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();

        // 起点
        dist[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            for (int next : graph[cur]) {

                // 没有访问过
                if (dist[next] == -1) {

                    dist[next] = dist[cur] + 1;

                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(i + " " + dist[i]);
        }
    }
}
