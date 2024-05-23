package samoy.linkedlist.swapnodesinpairs;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void swapPairs() {
        Solution s = new Solution();
        int[] nodeValues = new int[]{2, 1, 4, 3, 5};
        ListNode node1 = s.swapPairs2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        int i = 0;
        while (node1 != null) {
            assertEquals(nodeValues[i++], node1.val);
            node1 = node1.next;
        }
        assertNull(s.swapPairs2(null));
        assertEquals(1, s.swapPairs2(new ListNode(1)).val);
    }
}