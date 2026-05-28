package org.example.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    ListNode head;
    ListNode tail;
    int capacity;
    Map<Integer, ListNode> map;

    public class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode curNode = map.get(key);
        if (curNode == null) {
            return -1;
        } else {
            moveToHead(curNode);
            return curNode.value;
        }
    }

    public void put(int key, int value) {
        ListNode curNode = map.get(key);
        if (curNode != null) {
            curNode.value = value;
            moveToHead(curNode);
        } else {
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            insertToHead(newNode);
            if (map.size() > capacity) {
                removeTail();
            }
        }
    }

    public void moveToHead(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        insertToHead(node);
    }

    public void insertToHead(ListNode node){
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        node.prev.next = node;
    }

    public void removeTail(){
        map.remove(tail.prev.key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }


}
