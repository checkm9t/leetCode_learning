package org.example.practice;

public class _CopyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            Node cpNode = new Node(cur.val);
            cpNode.next = cur.next;
            cur.next = cpNode;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node copyHead = head.next;
        while (cur != null) {
            Node postNode = cur.next.next;
            if (postNode != null) {
                cur.next.next = postNode.next;
            }

            // 这个必须后面设置，否则会丢失复制节点
            cur.next = postNode;
            cur = postNode;
        }

        return copyHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
