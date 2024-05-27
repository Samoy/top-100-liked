package samoy.binarytree.binarytreelevelordertraversal;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void levelOrder() {
        Solution s = new Solution();
        assertArrayEquals(new int[][]{
                new int[]{3},
                new int[]{9, 20},
                new int[]{15, 7}
        }, s.levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))))
                .stream()
                .map(integers -> integers.stream().mapToInt(Integer::intValue).toArray()).toArray());
        assertArrayEquals(new int[][]{
                new int[]{1}
        }, s.levelOrder(new TreeNode(1)).stream()
                .map(integers -> integers.stream().mapToInt(Integer::intValue).toArray()).toArray());
        assertTrue(s.levelOrder(null).isEmpty());
    }
}