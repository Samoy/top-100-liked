package samoy.binarytree.validatebinarysearchtree;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isValidBST() {
        assertTrue(new Solution().isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        assertFalse(new Solution().isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))));
        assertFalse(new Solution().isValidBST(new TreeNode(2, new TreeNode(2), new TreeNode(2))));
        assertFalse(new Solution().isValidBST(new TreeNode(1, new TreeNode(1), null)));
        assertTrue(new Solution().isValidBST(new TreeNode(Integer.MIN_VALUE, null, new TreeNode(Integer.MAX_VALUE))));
    }
}