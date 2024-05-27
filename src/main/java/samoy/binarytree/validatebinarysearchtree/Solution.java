package samoy.binarytree.validatebinarysearchtree;

import samoy.common.TreeNode;

class Solution {
    // 初始化一个负无穷大值作为上一个节点的值，方便比较
    private double lastValue = -Double.MAX_VALUE;
    // 标记树是否有效，初始设为true
    private boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        // 通过深度优先搜索（DFS）进行中序遍历
        dfs(root);
        // 返回有效性标志
        return valid;
    }

    /**
     * 中序遍历树的私有辅助方法，用于深度优先搜索
     *
     * @param node 当前遍历的节点
     */
    private void dfs(TreeNode node) {
        // 如果节点为空，直接返回
        if (node == null) return;
        // 当标记有效时继续遍历
        if (valid) {
            // 先遍历左子树
            dfs(node.left);
            // 检查当前节点的值是否大于上一个节点的值
            // 如果当前节点的值小于等于上一个节点的值，说明不是BST
            if (node.val <= lastValue) {
                valid = false;
            } else {
                // 否则，更新上一个节点的值
                lastValue = node.val;
            }
            // 继续遍历右子树
            dfs(node.right);
        }
    }
}