package samoy.linkedlist.mergeksortedlists;

import samoy.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @link <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked">合并K个升序链表</a>
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 如果没有链表或者链表数组为空，直接返回 null
        if (lists == null || lists.length == 0) return null;

        // 使用优先队列（最小堆）来合并链表，优先队列中的元素是链表的头节点
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        // 将所有链表的头节点放入优先队列
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // 创建一个新的链表，用于存放合并后的结果
        ListNode listNode = new ListNode();
        ListNode result = listNode;

        // 当优先队列不为空时，依次取出最小的节点并连接到结果链表
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();

            // 更新结果链表的尾部节点
            listNode.next = smallest;
            listNode = listNode.next;

            // 如果当前最小节点的下一个节点不为空，将其加入优先队列
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        // 返回合并后的链表头节点
        return result.next;
    }
}
