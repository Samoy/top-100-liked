package samoy.binarytree.binarytreemaximumpathsum;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxPathSum() {
        assertEquals(6, new Solution().maxPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        assertEquals(42, new Solution().maxPathSum(new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }
}