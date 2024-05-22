package samoy.linkedlist.reverselinkedlist;

import samoy.common.ListNode;

/**
 * @link <a href="https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked">反转链表</a>
 */
class Solution {
    // 使用迭代
    public ListNode reverseList(ListNode head) {
        // 如果链表为空，直接返回null
        if (head == null) return null;
        // 初始化前驱节点prev为null，当前节点current为头节点
        ListNode prev = null;
        ListNode current = head;

        // 循环直到当前节点为空
        while (current != null) {
            // 保存当前节点的下一个节点
            ListNode next = current.next;
            // 将后继节点指向前驱节点
            current.next = prev;
            // 将前驱节点指向当前节点
            prev = current;
            // 移动到下一节点
            current = next;
        }

        // 反转完成后，prev成为新的头节点
        return prev;
    }

    // 使用递归
    public ListNode reverseList2(ListNode head) {
        // 调用辅助方法recycle，传入头节点和空节点作为前驱节点
        return recycle(head, null);
    }

    private ListNode recycle(ListNode current, ListNode pre) {
        // 当前节点为空，递归结束，返回前驱节点作为新的头节点
        if (current == null) return pre;
        // 递归处理当前节点的下一个节点，pre作为当前节点的前驱
        ListNode node = recycle(current.next, current);
        // 反转当前节点的next指针，使其指向前驱节点
        current.next = pre;
        // 返回当前节点，作为下一层递归的头节点
        return node;
    }
}
