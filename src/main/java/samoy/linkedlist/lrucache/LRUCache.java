package samoy.linkedlist.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * @link <a href="https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked">LRU缓存</a>
 */
public class LRUCache {


    private final Map<Integer, DoubleLinkedNode> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private final DoubleLinkedList linkedList;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.linkedList = new DoubleLinkedList();
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        this.linkedList.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            this.linkedList.addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DoubleLinkedNode tail = this.linkedList.removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            this.linkedList.moveToHead(node);
        }
    }


}

class DoubleLinkedNode {
    int key;
    int value;
    DoubleLinkedNode prev;
    DoubleLinkedNode next;

    public DoubleLinkedNode() {
    }

    public DoubleLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkedList {
    // 重要：这两个是虚拟节点，也就是说添加和移除都不影响它们
    private final DoubleLinkedNode dummyHead;
    private final DoubleLinkedNode dummyTail;

    public DoubleLinkedList() {
        dummyHead = new DoubleLinkedNode();
        dummyTail = new DoubleLinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void addToHead(DoubleLinkedNode node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    public void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public DoubleLinkedNode removeTail() {
        DoubleLinkedNode res = dummyTail.prev;
        removeNode(res);
        return res;
    }
}