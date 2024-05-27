package samoy.binarytree.diameterofbinarytree;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void diameterOfBinaryTree() {
        assertEquals(3, new Solution().diameterOfBinaryTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3))));
        assertEquals(1, new Solution().diameterOfBinaryTree(new TreeNode(1, new TreeNode(2), null)));
    }
}