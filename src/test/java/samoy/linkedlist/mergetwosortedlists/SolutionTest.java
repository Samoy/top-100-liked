package samoy.linkedlist.mergetwosortedlists;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void mergeTwoLists() {
        Solution s = new Solution();
        ListNode head1 = new ListNode(1);
        ListNode second1 = new ListNode(2);
        ListNode third1 = new ListNode(4);
        head1.next = second1;
        second1.next = third1;
        ListNode head2 = new ListNode(1);
        ListNode second2 = new ListNode(3);
        ListNode third2 = new ListNode(4);
        head2.next = second2;
        second2.next = third2;
        assertEquals(head2, s.mergeTwoLists(head1, head2));
        assertNull(s.mergeTwoLists(null, null));
        ListNode node = new ListNode(0);
        assertEquals(node, s.mergeTwoLists(null, node));
    }
}