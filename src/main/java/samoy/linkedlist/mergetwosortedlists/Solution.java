package samoy.linkedlist.mergetwosortedlists;

import samoy.common.ListNode;

/**
 * @link <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked">合并两个有序链表</a>
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 如果list1为空，直接返回list2，因为list2已经是有序的
        if (list1 == null) return list2;
        // 如果list2为空，直接返回list1，因为list1已经是有序的
        if (list2 == null) return list1;

        // 比较两个链表头节点的值
        // 如果list1的值小于list2的值，则新的链表应以list1的节点开头
        if (list1.val < list2.val) {
            // 递归合并list1的下一个节点与list2，然后将结果链接到list1后面
            list1.next = mergeTwoLists(list1.next, list2);
            // 返回合并后的新链表的头节点，即list1
            return list1;
        } else {
            // 否则，新的链表应以list2的节点开头
            // 递归合并list1与list2的下一个节点，然后将结果链接到list2后面
            list2.next = mergeTwoLists(list1, list2.next);
            // 返回合并后的新链表的头节点，即list2
            return list2;
        }
    }
}
