package samoy.linkedlist.linkedlistcycleii;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void detectCycle() {
        Solution s = new Solution();
        ListNode cycle1 = new ListNode(2, new ListNode(0, new ListNode(4)));
        cycle1.next = cycle1;
        ListNode node1 = new ListNode(3, cycle1);
        assertEquals(cycle1, s.detectCycle(node1));
        ListNode cycle2 = new ListNode(1, new ListNode(2));
        cycle2.next = cycle2;
        assertEquals(cycle2, s.detectCycle(cycle2));
        ListNode node3 = new ListNode(1);
        assertNull(s.detectCycle(node3));
    }
}