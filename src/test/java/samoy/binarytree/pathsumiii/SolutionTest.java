package samoy.binarytree.pathsumiii;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void pathSum() {
        assertEquals(3, new Solution().pathSum(new TreeNode(10,
                new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11))), 8));
        assertEquals(3, new Solution().pathSum(new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))), 22));
    }
}