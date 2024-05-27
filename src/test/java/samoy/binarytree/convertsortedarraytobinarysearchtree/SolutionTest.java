package samoy.binarytree.convertsortedarraytobinarysearchtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sortedArrayToBST() {
        Solution s = new Solution();
        assertEquals(0, s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}).val);
        assertNotEquals(2, s.sortedArrayToBST(new int[]{1, 3}).val);
    }
}