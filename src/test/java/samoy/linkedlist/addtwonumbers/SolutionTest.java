package samoy.linkedlist.addtwonumbers;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void addTwoNumbers() {
        Solution s = new Solution();
        ListNode node1 = s.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
        assertEquals(node1.val, 7);
        assertEquals(node1.next.val, 0);
        assertEquals(node1.next.next.val, 8);
        ListNode node2 = s.addTwoNumbers(new ListNode(0), new ListNode(0));
        assertEquals(node2.val, 0);
        ListNode node3 = s.addTwoNumbers(
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        assertEquals(node3.val, 8);
        assertEquals(node3.next.val, 9);
        assertEquals(node3.next.next.val, 9);
        assertEquals(node3.next.next.next.val, 9);
        assertEquals(node3.next.next.next.next.val, 0);
        assertEquals(node3.next.next.next.next.next.val, 0);
        assertEquals(node3.next.next.next.next.next.next.val, 0);
        assertEquals(node3.next.next.next.next.next.next.next.val, 1);
    }
}