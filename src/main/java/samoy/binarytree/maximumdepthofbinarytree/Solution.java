package samoy.binarytree.maximumdepthofbinarytree;

import samoy.common.TreeNode;

/**
 * @link <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked">二叉树的最大深度</a>
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // 如果树为空（根节点为null），则深度为0
        if (root == null) return 0;
        // 分别递归计算左子树和右子树的最大深度，然后取其最大值作为最大深度返回
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}