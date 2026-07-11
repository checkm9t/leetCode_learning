package org.example.practice;

import java.util.Arrays;
import java.util.Stack;

public class Merge {
    public int[][] merge(int[][] intervals) {
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
        return stack.toArray(new int[0][2]);

    }
}
