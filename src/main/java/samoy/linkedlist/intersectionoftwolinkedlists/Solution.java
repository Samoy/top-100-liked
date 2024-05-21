package samoy.linkedlist.intersectionoftwolinkedlists;

import samoy.common.ListNode;

/**
 * @link <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked">相交链表</a>
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA; // 第一个链表的指针
        ListNode pB = headB; // 第二个链表的指针

        // 当两个指针不相遇时，遍历链表
        while (pA != pB) {
            // 如果pA到达其链表的末尾，将它移动到另一个链表的开头
            pA = pA != null ? pA.next : headB;
            // 如果pB到达其链表的末尾，将它移动到另一个链表的开头
            pB = pB != null ? pB.next : headA;
        }

        // 返回相交节点（此时pA和pB相同）
        return pA;
    }
}
