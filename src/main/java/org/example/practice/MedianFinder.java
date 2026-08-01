package org.example.practice;

import java.util.PriorityQueue;

public class MedianFinder {



    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {

        // 大顶堆是较多的那一半
        max = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        min = new PriorityQueue<>((a, b) -> {
            return a - b;
        });
    }

    public void addNum(int num) {
        if (max.isEmpty() || num <= max.peek()) {
            max.add(num);
            if (max.size() > min.size() + 1) {
                min.add(max.poll());
            }
        } else {
            min.add(num);
            if (min.size() > max.size()) {
                max.add(min.poll());
            }
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return max.peek();
        }
    }
}
