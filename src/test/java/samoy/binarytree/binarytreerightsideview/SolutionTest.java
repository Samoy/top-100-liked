package samoy.binarytree.binarytreerightsideview;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void rightSideView() {
        assertIterableEquals(List.of(1, 3, 4), new Solution().rightSideView(new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)))));
        assertIterableEquals(List.of(1, 3), new Solution().rightSideView(new TreeNode(1, null, new TreeNode(3))));
        assertIterableEquals(Collections.emptyList(), new Solution().rightSideView(null));
        assertIterableEquals(List.of(1, 3, 5), new Solution().rightSideView(new TreeNode(1, new TreeNode(2, new TreeNode(5), null), new TreeNode(3))));
        assertIterableEquals(List.of(1, 3, 5), new Solution().rightSideView(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
    }
}