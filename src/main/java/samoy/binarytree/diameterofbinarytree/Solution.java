package samoy.binarytree.diameterofbinarytree;

import samoy.common.TreeNode;

/**
 * @link <a href="https://leetcode.cn/problems/diameter-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked">二叉树的路径</a>
 */
class Solution {

    // 初始化一个成员变量max，用来记录当前已知的二叉树的最大直径
    private int max = 0;

    private int depth(TreeNode node) {
        // 如果节点为空，则返回深度为0
        if (node == null) return 0;

        // 递归计算左子树的深度
        int l = depth(node.left);
        // 递归计算右子树的深度
        int r = depth(node.right);

        // 更新全局最大直径，可能是穿过当前节点的左子树和右子树的路径
        max = Math.max(max, l + r);

        // 返回当前节点的最大深度（左子树或右子树的深度+1）
        return Math.max(l, r) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
}
