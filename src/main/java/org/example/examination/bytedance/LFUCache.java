package org.example.examination.bytedance;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    int capacity;
    int minFreq;

    // key -> 节点
    Map<Integer, Node> keyMap;

    // freq -> 该频率对应的双向链表
    Map<Integer, DoubleList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        Node node = keyMap.get(key);

        if (node == null) {
            return -1;
        }

        // 访问一次，频率 +1
        increaseFreq(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // key 已经存在
        if (keyMap.containsKey(key)) {

            Node node = keyMap.get(key);
            node.value = value;

            // put 已有 key 也算一次访问
            increaseFreq(node);

            return;
        }

        // 容量满了，需要淘汰
        if (keyMap.size() >= capacity) {

            // 找最小频率对应的链表
            DoubleList list = freqMap.get(minFreq);
            // 淘汰该频率中最久没使用的节点
            Node removeNode = list.removeLast();

            // 这里不应该主动维护寻找，因为可能会有无限循环的情况
            // 因为淘汰后一定会插入新节点，并且频率为一，所以不用管
            /*while ((list = freqMap.get(minFreq)) == null || list.size == 0) {
                minFreq++;
            }*/

            keyMap.remove(removeNode.key);
        }

        // 新节点频率默认是 1
        Node newNode = new Node(key, value);

        keyMap.put(key, newNode);

        DoubleList dList = freqMap.getOrDefault(1,new DoubleList());
        dList.addFirst(newNode);
        freqMap.put(1,dList);
        // 新插入节点 freq=1
        minFreq = 1;
    }

    private void increaseFreq(Node node) {

        int oldFreq = node.freq;
        // 删除旧节点
        DoubleList oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        // 更新minFreq
        if(node.freq==minFreq && oldList.size==0){
            minFreq++;
        }

        // 加入新的节点
        node.freq++;
        DoubleList newList = freqMap.getOrDefault(node.freq,new DoubleList());
        newList.addFirst(node);
        // 记得新建的doubleList要加入map里
        freqMap.put(node.freq,newList);

    }


    public class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }


    public class DoubleList {
        Node head;
        Node tail;
        int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        // 插入到头部：表示最近使用
        public void addFirst(Node node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        // 删除某个节点
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        // 删除尾部节点：最久没有使用
        public Node removeLast() {
            if (size == 0) {
                return null;
            }

            Node node = tail.prev;
            remove(node);

            return node;
        }
    }
}