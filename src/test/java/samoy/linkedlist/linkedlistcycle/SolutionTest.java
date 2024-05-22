package samoy.linkedlist.linkedlistcycle;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void hasCycle() {
        // 用例1
        ListNode cycle1 = new ListNode(2, new ListNode(0, new ListNode(-4)));
        cycle1.next = cycle1;
        ListNode node1 = new ListNode(3, cycle1);
        Solution s = new Solution();
        assertTrue(s.hasCycle(node1));
        // 用例2
        ListNode cycle2 = new ListNode(1, new ListNode(2));
        cycle2.next = cycle2;
        assertTrue(s.hasCycle(cycle2));
        // 用例3
        ListNode node3 = new ListNode(1);
        assertFalse(s.hasCycle(node3));
    }
}