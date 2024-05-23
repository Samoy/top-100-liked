package samoy.linkedlist.reversenodesinkgroup;

import samoy.common.ListNode;

/**
 * @link <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked">K个一组翻转链表</a>
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 如果头节点为空，直接返回 null
        if (head == null) return null;

        // 移动 p 指针到第 k 个节点，或到达链表末尾
        ListNode p = head;
        int i = 1;
        while (i < k && p.next != null) {
            p = p.next;
            i++;
        }

        // 如果链表长度不足 k，直接返回原链表
        if (i < k) return head;

        // 开始翻转 k 个节点
        ListNode current = head;
        ListNode prev = null;
        ListNode next = p.next;  // 下一组的起始节点

        // 反转当前子链表
        while (current != next) {
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }

        // 递归处理剩余链表部分
        head.next = reverseKGroup(next, k);

        // 返回翻转后子链表的新头节点
        return prev;
    }
}
