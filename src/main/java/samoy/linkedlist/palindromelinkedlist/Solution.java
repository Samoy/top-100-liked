package samoy.linkedlist.palindromelinkedlist;

import samoy.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @link <a href="https://leetcode.cn/problems/palindrome-linked-list/?envType=study-plan-v2&envId=top-100-liked">回文链表</a>
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 使用一个名为current的指针从头节点开始遍历链表
        ListNode current = head;
        // 创建一个ArrayList list来存储链表中的值
        List<Integer> list = new ArrayList<>();

        // 遍历链表，将每个节点的值添加到list中
        while (current != null) {
            list.add(current.val); // 将当前节点的值添加到列表末尾
            current = current.next; // 移动指针到下一个节点
        }

        // 使用双指针法，从list的头部和尾部开始比较元素
        for (int i = 0; i < list.size() / 2; i++) { // 只需比较到中间位置即可
            // 如果头部和尾部的元素不相等，则链表不是回文，返回false
            if (!Objects.equals(list.get(i), list.get(list.size() - 1 - i))) {
                return false;
            }
        }

        // 如果所有比较都通过，说明链表是回文，返回true
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
