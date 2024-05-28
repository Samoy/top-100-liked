package samoy.binarytree.flattenbinarytreetolinkedlist;

import samoy.common.TreeNode;

/**
 * @link <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">二叉树展开为链表</a>
 */
class Solution {
    public void flatten(TreeNode root) {
        // 如果根节点为空，直接返回
        if (root == null) return;
        // 使用深度优先搜索展开二叉树
        dfs(root);
    }

    // 辅助方法，使用深度优先搜索策略，递归地展开二叉树
    public TreeNode dfs(TreeNode node) {
        // 获取当前节点的左右子节点
        TreeNode left = node.left;
        TreeNode right = node.right;

        // 将当前节点的左子节点置为 null，因为展开后不再需要
        node.left = null;

        // 如果左子节点存在，将它连接到当前节点的右子节点上，然后递归展开左子树
        if (left != null) {
            node.right = left;
            node = dfs(left);
        }

        // 如果右子节点存在，将它连接到当前节点（现在已经是左子节点为 null 的节点）的右子节点上，然后递归展开右子树
        if (right != null) {
            node.right = right;
            node = dfs(right);
        }

        // 返回当前节点，用于链式调用
        return node;
    }
}
