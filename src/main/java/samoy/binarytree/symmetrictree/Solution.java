package samoy.binarytree.symmetrictree;

import samoy.common.TreeNode;

/**
 * @link <a href="https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked">对称二叉树</a>
 */
class Solution {
    private boolean check(TreeNode left, TreeNode right) {
        // 基本情况1：两个节点都为空，说明对称
        if (left == null && right == null) return true;
        // 基本情况2：一个节点为空而另一个不为空，说明不对称
        if (left == null || right == null) return false;

        // 如果节点值相等，并且它们的左子节点和右子节点对称，右子节点和左子节点也对称，说明这两个节点对称
        return left.val == right.val &&
                check(left.left, right.right) &&
                check(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
}