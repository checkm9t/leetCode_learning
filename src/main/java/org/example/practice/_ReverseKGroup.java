package org.example.practice;


public class _ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevGroup = dummy;
        ListNode postGroup = dummy;
        ListNode groupHead = prevGroup.next;
        ListNode groupTail = prevGroup;

        while (groupHead != null) {
            for (int i = 0; i < k; i++) {
                groupTail = groupTail.next;
                if (groupTail == null) {
                    return dummy.next;
                }
            }

            postGroup = groupTail.next;
            ListNode[] revResult = reverse(groupHead, groupTail);

            prevGroup.next = revResult[0];
            revResult[1].next = postGroup;
            prevGroup = revResult[1];
            groupHead = revResult[1].next;
            groupTail = prevGroup;
        }

        return dummy.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode post;
        ListNode cur = head;

        while (cur != tail) {
            post = cur.next;
            cur.next = prev;
            prev = cur;
            cur = post;
        }

        cur.next = prev;

        return new ListNode[]{tail, head};
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
