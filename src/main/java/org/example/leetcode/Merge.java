package org.example.leetcode;

import java.util.Arrays;
import java.util.Stack;

// 合并区间
// leetcode 56
public class Merge {
    public int[][] merge(int[][] intervals) {

        // 用栈来解决
        Stack<int[]> stack = new Stack<>();
        if(intervals.length<=0){
            return null;
        }
        Arrays.sort(intervals,(a, b)->{
            return a[0] - b[0];
        });

        stack.push(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] top = stack.peek();
            int[] cur = intervals[i];
            if(top[1]>=cur[0]){
                stack.pop();
                int min = Math.min(cur[0],top[0]);
                int max = Math.max(cur[1],top[1]);
                stack.push(new int[]{min,max});
            }
            else{
                stack.push(cur);
            }
        }

        // 注意：这里把栈转换成数组的方法要记住
        // 并且传入的初始化数组第一个参数为0
        return stack.toArray(new int[0][2]);

    }
}
