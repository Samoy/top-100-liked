package samoy.binarytree.constructbinarytreefrompreorderandinordertraversal;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void buildTree() {
        TreeNode node1 = new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        assertEquals(3, node1.val);
        assertEquals(9, node1.left.val);
        assertEquals(20, node1.right.val);
        assertEquals(15, node1.right.left.val);
        assertEquals(7, node1.right.right.val);
        TreeNode node2 = new Solution().buildTree(new int[]{-1}, new int[]{-1});
        assertEquals(-1, node2.val);
    }
}