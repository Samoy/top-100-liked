package samoy.linkedlist.reverselinkedlist;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseList() {
        Solution s = new Solution();
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        assertEquals(5, s.reverseList(listNode1).val);
        ListNode listNode2 = new ListNode(1, new ListNode(2));
        assertEquals(2, s.reverseList(listNode2).val);
        ListNode listNode3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        assertEquals(5, s.reverseList2(listNode3).val);
        ListNode listNode4 = new ListNode(1, new ListNode(2));
        assertEquals(2, s.reverseList2(listNode4).val);
    }
}