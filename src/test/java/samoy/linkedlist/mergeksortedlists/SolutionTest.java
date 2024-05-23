package samoy.linkedlist.mergeksortedlists;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void mergeKLists() {
        Solution s = new Solution();
        ListNode result1 = s.mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        });
        List<Integer> resultValues = List.of(1, 1, 2, 3, 4, 4, 5, 6);
        int i = 0;
        while (result1 != null) {
            assertEquals(resultValues.get(i++), result1.val);
            result1 = result1.next;
        }
        assertNull(s.mergeKLists(null));
        assertNull(s.mergeKLists(new ListNode[]{}));
    }
}