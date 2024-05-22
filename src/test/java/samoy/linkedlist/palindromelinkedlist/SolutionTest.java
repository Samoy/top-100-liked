package samoy.linkedlist.palindromelinkedlist;

import org.junit.jupiter.api.Test;
import samoy.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isPalindrome() {
        Solution s = new Solution();
        assertTrue(s.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        assertFalse(s.isPalindrome(new ListNode(1, new ListNode(2))));
        assertTrue(s.isPalindrome2(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        assertFalse(s.isPalindrome2(new ListNode(1, new ListNode(2, new ListNode(3)))));
    }
}