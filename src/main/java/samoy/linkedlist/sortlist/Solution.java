package samoy.linkedlist.sortlist;

import samoy.common.ListNode;

/**
 * @link <a href="https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked">排序链表</a>
 */
class Solution {
    // 主要方法，用于对链表进行升序排序
    public ListNode sortList(ListNode head) {
        // 如果链表为空，直接返回 null
        if (head == null) return null;

        // 计算链表的长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        // 创建虚拟头节点，用于排序过程中辅助链接
        ListNode dummyHead = new ListNode(0, head);

        // 使用二进制位移确定子链表的大小，从 1 开始逐渐扩大
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            // 使用两个指针追踪子链表的起始位置
            ListNode prev = dummyHead, curr = dummyHead.next;

            // 将链表分为子链表，对每个子链表进行两两合并
            while (curr != null) {
                // 获取子链表的两个头节点
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;

                // 断开子链表，准备合并
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }

                // 合并两个子链表
                prev.next = merge(head1, head2);

                // 更新 prev 和 curr 以处理下一个子链表
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }

        // 返回排序后的链表头节点
        return dummyHead.next;
    }

    // 合并两个已排序的链表
    public ListNode merge(ListNode head1, ListNode head2) {
        // 创建虚拟头节点，用于构建合并后的链表
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;  // 追踪合并后链表的当前位置

        // 逐个比较节点并合并
        while (head1 != null && head2 != null) {
            // 将较小的节点添加到合并链表中
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;  // 更新合并链表的位置
        }

        // 如果其中一个链表还有剩余节点，将其添加到合并链表中
        if (head1 != null) {
            temp.next = head1;
        } else if (head2 != null) {
            temp.next = head2;
        }

        // 返回合并后的链表头节点
        return dummyHead.next;
    }
}
