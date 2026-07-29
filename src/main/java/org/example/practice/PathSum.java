package org.example.practice;

import org.example.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum {

    public int res;
    Map<Long, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        res = 0;
        map = new HashMap<>();

        // 很重要，前缀和相加会超过int上限，所以用long
        // 并且，当targetSum == 前缀和时，要算上这个
        map.put(0L, 1);

        dfs(root, 0L, targetSum);
        return res;
    }

    public void dfs(TreeNode root, Long sum, int targetSum) {
        if (root == null) {
            return;
        }

        // 1.计算和
        sum += root.val;
        // 2.计算结果
        res += map.getOrDefault(sum - targetSum, 0);

        // 3.放入前缀和
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        dfs(root.left, sum, targetSum);
        dfs(root.right, sum, targetSum);

        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }
}
