package org.example.practice;

import java.util.Stack;

class MinStack {
    Stack<Integer> numStack;
    Stack<Integer> resStack;

    public MinStack() {
        numStack = new Stack<>();
        resStack = new Stack<>();
    }

    public void push(int value) {
        numStack.push(value);
        if (resStack.isEmpty() || value <= resStack.peek()) {
            resStack.push(value);
        }
    }

    public void pop() {
        if (resStack.isEmpty() || numStack.isEmpty()) {
            return;
        }
        if (resStack.peek() >= numStack.pop()) {
            resStack.pop();
        }
    }

    public int top() {
        return numStack.peek();
    }

    public int getMin() {
        return resStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
