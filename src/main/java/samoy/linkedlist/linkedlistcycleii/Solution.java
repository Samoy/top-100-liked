package samoy.linkedlist.linkedlistcycleii;

import samoy.common.ListNode;

/**
 * @link <a href="https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked">环形链表Ⅱ</a>
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 使用快慢指针解决环检测问题
        ListNode slow = head; // 慢指针初始化为头节点
        ListNode fast = head; // 快指针初始化为头节点

        // 使用do-while循环，确保至少执行一次循环
        do {
            // 如果快指针或其下一个节点为null，说明链表无环
            if (fast == null || fast.next == null) {
                return null;
            }

            // 指针移动
            slow = slow.next; // 慢指针向前移动一步
            fast = fast.next.next; // 快指针向前移动两步
        } while (slow != fast); // 当慢指针和快指针相遇时，退出循环

        // 如果找到了环，让快指针重新从头节点开始，慢指针保持在相遇点
        fast = head;

        // 再次移动两个指针，直到它们相遇，相遇点即为环的入口节点
        while (fast != slow) {
            fast = fast.next; // 快指针向前移动一步
            slow = slow.next; // 慢指针向前移动一步
        }

        // 返回环的入口节点
        return fast;
    }
}
