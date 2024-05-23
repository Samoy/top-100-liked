package samoy.linkedlist.copylistwithrandompointer;

import samoy.common.Node;

import java.util.HashMap;

/**
 * @link  <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-100-liked">随机链表的复制</a>
 */
class Solution {
    // 创建一个哈希表用于存储原节点与复制节点之间的映射关系
    private final HashMap<Node, Node> cacheNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        // 递归终止条件：如果原链表为空，返回 null
        if (head == null) return null;

        // 检查当前节点是否已经在哈希表中，若不在则创建新节点并加入哈希表
        if (!cacheNode.containsKey(head)) {
            // 创建新节点，复制 val 值
            Node newNode = new Node(head.val);
            // 将原节点与新节点的对应关系存入哈希表
            cacheNode.put(head, newNode);
            // 递归复制下一个节点，并将其链接到新节点的 next 指针上
            newNode.next = copyRandomList(head.next);
            // 递归复制随机节点，并将其链接到新节点的 random 指针上
            newNode.random = copyRandomList(head.random);
        }

        // 从哈希表中获取当前节点对应的复制节点并返回
        return cacheNode.get(head);
    }
}
