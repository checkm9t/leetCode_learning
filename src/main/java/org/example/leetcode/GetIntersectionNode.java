package org.example.leetcode;

import org.example.common.ListNode;

// 相交链表
// leetcode 160
public class GetIntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {

            // 注意，从null到下一个节点也算一步。移动之后就不能next了
            // 否则会错过相交节点，没有判断想等就跳过了
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }
}
