package org.example.examination.xunlei;

public class MinMakeSpan {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * minMakespan 求「先下载再转码」两级单流水线的最短完工时间（makespan）。down[i] / trans[i] 分别是资源 i 的下载耗时与转码耗时；下载器与转码器同一时刻各只能处理一个资源、都不可抢占，资源必须下载完才能开始转码，且两级使用同一个处理顺序。下载器从时刻 0 起不空转，所以它的完成时刻就是 down 的前缀和。
     * @param down int整型一维数组 down[i] 是资源 i 的下载耗时
     * @param trans int整型一维数组 trans[i] 是资源 i 的转码耗时
     * @return long长整型
     */
    public long minMakespan (int[] down, int[] trans) {
        return 1;
    }
}
