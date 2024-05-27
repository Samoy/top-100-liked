package samoy.binarytree.maximumdepthofbinarytree;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxDepth() {
        Solution s = new Solution();
        assertEquals(3, s.maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        assertEquals(2, s.maxDepth(new TreeNode(1, null, new TreeNode(2))));
    }
}