package samoy.linkedlist.addtwonumbers;

import samoy.common.ListNode;

/**
 * @link <a href="https://leetcode.cn/problems/add-two-numbers/?envType=study-plan-v2&envId=top-100-liked">两数相加</a>
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化新链表的头节点和尾节点为null
        ListNode head = null, tail = null;

        // 初始化进位值carry为0
        int carry = 0;

        // 当l1或l2中至少有一个非空时，进行循环
        while (l1 != null || l2 != null) {
            // 取当前节点的值，若链表已遍历完则值为0
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;

            // 计算两数之和加上进位
            int sum = n1 + n2 + carry;

            // 如果新链表为空，创建新节点作为头节点和尾节点
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            }
            // 如果新链表不为空，创建新节点并添加至尾部，更新尾节点
            else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            // 更新进位值
            carry = sum / 10;

            // 链表指针向后移动
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 如果最后还有进位，创建新节点加入链表末尾
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        // 返回新链表的头节点
        return head;
    }
}
