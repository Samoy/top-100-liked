package samoy.binarytree.invertbinarytree;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void invertTree() {
        Solution s = new Solution();
        TreeNode treeNode1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        assertEquals(treeNode1.left.val, s.invertTree(treeNode1).right.val);
        TreeNode treeNode2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        assertEquals(treeNode2.left.val, s.invertTree(treeNode2).right.val);
        assertNull(s.invertTree(null));
    }
}