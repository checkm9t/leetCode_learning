package org.example.leetcode;

public class Exist {

    public boolean[][] visited;
    public boolean flag;
    int[][] dirs;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];
        dirs = new int[][] {
                { 1, 0 },
                { 0, -1 },
                { -1, 0 },
                { 0, 1 }
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, i, j, 0, word);
            }
        }

        return flag;

    }

    // 查看第index个是否是对应的字符
    public void dfs(char[][] board, int i, int j, int index, String word) {
        // 已经找到结果，可以返回
        if (flag == true) {
            return;
        }
        // 如果该节点，不对，可以返回
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                visited[i][j] || board[i][j] != word.charAt(index)) {
            return;
        }
        // 找到结果，可以返回
        if (index == word.length() - 1) {
            flag = true;
            return;
        }

        //设置该节点
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nextx = i + dirs[k][0];
            int nexty = j + dirs[k][1];
            dfs(board, nextx, nexty, index + 1, word);
        }

        visited[i][j] = false;

    }
}
