package samoy.linkedlist.swapnodesinpairs;

import samoy.common.ListNode;

/**
 * @link <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked">两两交换链表中的节点</a>
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 如果链表为空，直接返回null
        if (head == null) return null;

        // 初始化当前节点current为头节点
        ListNode current = head;

        // 当前节点不为空且其下一个节点也不为空时，继续循环
        while (current != null && current.next != null) {
            // 保存当前节点的值
            int tmpValue = current.val;

            // 交换当前节点和下一个节点的值
            current.val = current.next.val;
            current.next.val = tmpValue;

            // 移动当前节点到下一对节点的第二个节点
            current = current.next.next;
        }

        // 返回交换后的链表头节点
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        // 创建一个虚拟头节点，值为0，连接原头节点
        ListNode dummyHead = new ListNode(0, head);
        ListNode tmp = dummyHead; // 临时指针，用于遍历链表

        // 当tmp不为空且其下一个节点和下一个的下一个节点都不为空时，继续交换
        while (tmp.next != null && tmp.next.next != null) {
            // 获取待交换的两个节点
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;

            // 调整链表连接，交换节点位置
            tmp.next = node2; // 将node2放到node1之前
            node1.next = node2.next; // node1的下一个节点变为原来的node3
            node2.next = node1; // node2的下一个节点变为node1

            // 移动tmp指针，指向交换后的node1
            tmp = node1;
        }

        // 返回虚拟头节点的下一个节点，即交换后的链表头节点
        return dummyHead.next;
    }
}