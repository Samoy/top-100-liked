package samoy.binarytree.flattenbinarytreetolinkedlist;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void flatten() {
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        new Solution().flatten(treeNode1);
        assertEquals(treeNode1.val, 1);
        assertEquals(treeNode1.right.val, 2);
        assertEquals(treeNode1.right.right.val, 3);
        assertEquals(treeNode1.right.right.right.val, 4);
        assertEquals(treeNode1.right.right.right.right.val, 5);
        assertEquals(treeNode1.right.right.right.right.right.val, 6);
        TreeNode treeNode2 = new TreeNode(0);
        new Solution().flatten(treeNode2);
        assertEquals(treeNode2.val, 0);
    }
}