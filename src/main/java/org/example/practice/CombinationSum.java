package org.example.practice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> res;

    // 因为是返回所有组合，而不是组合数量
    // 不能用完全背包
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();

        dfs(candidates, new ArrayList<>(), 0, target, 0);

        return res;
    }

    public void dfs(int[] candidates, List<Integer> tmp, int sum, int target, int index) {
        if (sum > target || index >= candidates.length) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
        }

        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            // 注意这里入参是i而不是i+1
            dfs(candidates, tmp, sum + candidates[i], target, i);
            tmp.remove((int)(tmp.size() - 1));
        }
    }
}
