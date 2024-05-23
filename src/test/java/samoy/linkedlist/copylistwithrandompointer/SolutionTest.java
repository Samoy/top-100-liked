package samoy.linkedlist.copylistwithrandompointer;

import org.junit.jupiter.api.Test;
import samoy.common.Node;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void copyRandomList() {
        Solution s = new Solution();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;
        Node result = s.copyRandomList(node1);
        assertEquals(7, result.val);
        assertNull(result.random);
        assertEquals(13, result.next.val);
        assertEquals(7, result.next.random.val);
        assertEquals(11, result.next.next.val);
        assertEquals(1, result.next.next.random.val);
        assertEquals(10, result.next.next.next.val);
        assertEquals(11, result.next.next.next.random.val);
        assertEquals(1, result.next.next.next.next.val);
        assertEquals(7, result.next.next.next.next.random.val);
    }
}