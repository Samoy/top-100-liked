package samoy.linkedlist.removenthnodefromendoflist;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void removeNthFromEnd() {
        Solution s = new Solution();
        int[] nodeValues = new int[]{1, 2, 3, 5};
        ListNode node1 = s.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        int i = 0;
        while (node1 != null) {
            assertEquals(nodeValues[i], node1.val);
            node1 = node1.next;
            i++;
        }
        ListNode node2 = s.removeNthFromEnd(new ListNode(1), 1);
        assertNull(node2);
        ListNode node3 = s.removeNthFromEnd(new ListNode(1, new ListNode(2)), 1);
        assertEquals(1, node3.val);
    }
}