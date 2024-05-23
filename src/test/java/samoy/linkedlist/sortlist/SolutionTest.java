package samoy.linkedlist.sortlist;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sortList() {
        Solution s = new Solution();
        ListNode node1 = s.sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        int[] nodeValues1 = new int[]{1, 2, 3, 4};
        int i = 0;
        while (node1 != null) {
            assertEquals(nodeValues1[i++], node1.val);
            node1 = node1.next;
        }
        ListNode node2 = s.sortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0))))));
        int[] nodeValues2 = new int[]{-1, 0, 3, 4, 5};
        int j = 0;
        while (node2 != null) {
            assertEquals(nodeValues2[j++], node2.val);
            node2 = node2.next;
        }
        ListNode node3 = s.sortList(null);
        assertNull(node3);
    }
}