package samoy.binarytree.lowestcommonancestorofabinarytree;

import org.junit.jupiter.api.Test;
import samoy.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lowestCommonAncestor() {
        TreeNode x = new TreeNode(4);
        TreeNode p = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), x));
        TreeNode q = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3, p, q);
        assertEquals(3, new Solution().lowestCommonAncestor(root, p, q).val);
        assertEquals(5, new Solution().lowestCommonAncestor(root, p, x).val);
        TreeNode j = new TreeNode(2);
        TreeNode k = new TreeNode(1, j, null);
        assertEquals(1, new Solution().lowestCommonAncestor(k, j, k).val);
    }
}