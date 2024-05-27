package samoy.binarytree.symmetrictree;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isSymmetric() {
        Solution s = new Solution();
        assertTrue(s.isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
        assertFalse(s.isSymmetric(new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)))));
    }
}