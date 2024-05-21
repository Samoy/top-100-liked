package samoy.linkedlist.intersectionoftwolinkedlists;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getIntersectionNode() {
        Solution s = new Solution();
        ListNode node1 = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode list1A = new ListNode(4, new ListNode(1, node1));
        ListNode list1B = new ListNode(5, new ListNode(6, new ListNode(1, node1)));
        assertEquals(8, s.getIntersectionNode(list1A, list1B).val);
        ListNode node2 = new ListNode(2, new ListNode(4));
        ListNode list2A = new ListNode(1, new ListNode(9, new ListNode(1, node2)));
        ListNode list2B = new ListNode(3, node2);
        assertEquals(2, s.getIntersectionNode(list2A, list2B).val);
        ListNode list3A = new ListNode(2, new ListNode(6, new ListNode(4)));
        ListNode list3B = new ListNode(1, new ListNode(5));
        assertNull(s.getIntersectionNode(list3A, list3B));
    }
}