package org.example.examination.bytedance;


import java.util.HashMap;
import java.util.Map;

public class LRUTTLCache {
    ListNode head;
    ListNode tail;
    int capacity;
    Map<Integer, ListNode> map;

    public class ListNode {
        int key;
        int value;
        // 过期的时间戳，System.currentTimeMillis()
        long expireTime;
        ListNode prev;
        ListNode next;

        public ListNode() {

        }

        /**
         * @param key   键
         * @param value 值
         * @param ttlMs 存活毫秒数
         */
        public ListNode(int key, int value, long ttlMs) {
            this.key = key;
            this.value = value;
            this.expireTime = System.currentTimeMillis() + ttlMs;
        }

        // 判断当前节点是否过期
        public boolean isExpired() {
            return System.currentTimeMillis() > expireTime;
        }
    }

    public LRUTTLCache(int capacity) {
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
        }
        // 检测过期
        if (curNode.isExpired()) {
            removeNode(curNode);
            map.remove(key);
            return -1;
        }
        // LRU:访问后移到头部
        moveToHead(curNode);
        return curNode.value;
    }

    /**
     * put 默认 ttl 毫秒
     *
     * @param key   key
     * @param value value
     * @param ttlMs 存活时间，毫秒
     */
    public void put(int key, int value, long ttlMs) {
        ListNode curNode = map.get(key);
        if (curNode != null) {
            // 更新值 + 重置过期时间
            curNode.value = value;
            curNode.expireTime = System.currentTimeMillis() + ttlMs;
            moveToHead(curNode);
        } else {
            ListNode newNode = new ListNode(key, value, ttlMs);
            map.put(key, newNode);
            insertToHead(newNode);
            // 超过容量：优先尝试删掉过期节点；没有过期节点，再删LRU尾节点
            if (map.size() > capacity) {

                // 这个很重要，在容量满的时候查找过期节点
                evictOne();
            }
        }
    }

    /**
     * 淘汰一个元素：优先淘汰过期的；无过期则淘汰LRU尾部
     */
    private void evictOne() {
        // 从尾部往前找第一个过期节点
        ListNode p = tail.prev;
        while (p != head) {
            if (p.isExpired()) {
                removeNode(p);
                map.remove(p.key);
                return;
            }
            p = p.prev;
        }
        // 没有过期节点，删除LRU尾部
        removeTail();
    }


    public void moveToHead(ListNode node) {
        removeNode(node);
        insertToHead(node);
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertToHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        node.prev.next = node;
    }

    public void removeTail() {
        ListNode lastNode = tail.prev;
        removeNode(lastNode);
        map.remove(lastNode.key);
    }
}
