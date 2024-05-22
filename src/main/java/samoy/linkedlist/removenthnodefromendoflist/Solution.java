package samoy.linkedlist.removenthnodefromendoflist;

import samoy.common.ListNode;

/**
 * @link <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked">删除链表的倒数第N个节点</a>
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建一个虚拟节点，值为0，作为新链表的头节点，便于处理边界情况
        ListNode node = new ListNode(0, head);
        ListNode fast = head; // 快指针，用于快速前进
        ListNode slow = node; // 慢指针，用于定位要删除节点的前一个节点

        // 让快指针先走n步，到达倒数第n个节点的位置
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 使用快慢指针同步前进，直到快指针到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 慢指针现在指向要删除节点的前一个节点，通过修改其next指向，删除目标节点
        slow.next = slow.next.next;

        // 返回新链表的头节点（原虚拟节点的下一个节点）
        return node.next;
    }
}
