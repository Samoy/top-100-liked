package samoy.binarytree.lowestcommonancestorofabinarytree;

import samoy.common.TreeNode;

/**
 * @link <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=top-100-liked">二叉树的最近公共祖先</a>
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空，或者就是p或q中的任意一个，则直接返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归查找左子树中p和q的最近公共祖先
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);

        // 递归查找右子树中p和q的最近公共祖先
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // 如果左右子树都找到了最近公共祖先（即leftLCA和rightLCA都不为空），说明当前节点就是p和q的最近公共祖先
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // 如果左子树找到了（leftLCA不为空，rightLCA为空），说明最近公共祖先在左子树中
        if (leftLCA != null) {
            return leftLCA;
        }

        // 否则，最近公共祖先在右子树中（leftLCA为空，rightLCA不为空）
        return rightLCA;
    }
}
