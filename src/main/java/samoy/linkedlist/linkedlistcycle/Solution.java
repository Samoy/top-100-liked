package samoy.linkedlist.linkedlistcycle;

import samoy.common.ListNode;

/**
 * @link <a href="https://leetcode.cn/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-100-liked">环形链表</a>
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 如果链表为空或者只有一个节点，不可能存在环
        if (head == null || head.next == null) {
            return false;
        }

        // 定义两个指针，slow指针每次移动一步，fast指针每次移动两步
        ListNode slow = head; // 慢指针初始化为头节点
        ListNode fast = head.next; // 快指针初始化为头节点的下一个节点

        // 使用while循环，当慢指针和快指针不相遇时继续移动
        while (slow != fast) {
            // 如果快指针到达了链表末尾，或者快指针的下一个节点为null，说明不存在环
            if (fast == null || fast.next == null) {
                return false;
            }

            // 指针移动
            slow = slow.next; // 慢指针向前移动一步
            fast = fast.next.next; // 快指针向前移动两步
        }

        // 如果slow和fast相遇，说明链表中存在环，返回true
        return true;
    }
}
