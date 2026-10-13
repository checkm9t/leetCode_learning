package org.example.leetcode;

// 单词搜索
// leetcode 79
public class Exist {

    public boolean[][] visited;
    public boolean flag;
    int[][] dirs;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];
        dirs = new int[][]{
                {1, 0},
                {0, -1},
                {-1, 0},
                {0, 1}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    dfs(board, i, j, 0, word);
                    visited[i][j] = false;
                }

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

        // 找到结果，可以返回
        if (index == word.length() - 1) {
            flag = true;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nextx = i + dirs[k][0];
            int nexty = j + dirs[k][1];
            // 如果该节点，不对，可以返回
            if (nextx >= 0 && nextx < board.length && nexty >= 0 && nexty < board[0].length &&
                    visited[nextx][nexty] == false && board[nextx][nexty] == word.charAt(index+1)) {

                visited[nextx][nexty] = true;
                dfs(board, nextx, nexty, index + 1, word);
                visited[nextx][nexty] = false;
            }

        }

    }
}
