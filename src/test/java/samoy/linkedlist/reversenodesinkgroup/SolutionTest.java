package samoy.linkedlist.reversenodesinkgroup;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseKGroup() {
        Solution s = new Solution();
        ListNode node1 = s.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        int[] nodeValues1 = new int[]{2, 1, 4, 3, 5};
        int i = 0;
        while (node1 != null) {
            assertEquals(nodeValues1[i++], node1.val);
            node1 = node1.next;
        }
        ListNode node2 = s.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3);
        int[] nodeValues2 = new int[]{3, 2, 1, 4, 5};
        int j = 0;
        while (node2 != null) {
            assertEquals(nodeValues2[j++], node2.val);
            node2 = node2.next;
        }
    }
}