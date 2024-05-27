package samoy.binarytree.binarytreeinordertraversal;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void inorderTraversal() {
        assertArrayEquals(new int[]{1, 3, 2},
                new Solution().inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))).stream().mapToInt(Integer::intValue).toArray());
        assertTrue(new Solution().inorderTraversal(null).isEmpty());
        assertArrayEquals(new int[]{1}, new Solution().inorderTraversal(new TreeNode(1)).stream().mapToInt(Integer::intValue).toArray());
    }
}