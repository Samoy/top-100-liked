package samoy.binarytree.binarytreemaximumpathsum;

import samoy.common.TreeNode;

/**
 * @link <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked">二叉树中的最大路径和</a>
 */
class Solution {
    // 定义一个全局变量，用来存储最大路径和，初始化为最小整数值
    private int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 如果根节点为空，返回0
        if (root == null) return 0;
        // 使用深度优先搜索（DFS）遍历二叉树，计算最大路径和
        dfs(root);
        // 返回最大路径和
        return sum;
    }

    private int dfs(TreeNode node) {
        // 如果当前节点为空，返回0
        if (node == null) return 0;

        // 递归计算左子树的最大路径和，取非负值
        int left = Math.max(dfs(node.left), 0);

        // 递归计算右子树的最大路径和，取非负值
        int right = Math.max(dfs(node.right), 0);

        // 更新全局变量sum，取当前节点、左子树和右子树之和的最大值
        sum = Math.max(sum, left + node.val + right);

        // 返回当前节点、左右子树中较大值的和，用于构建局部最大路径
        return node.val + Math.max(left, right);
    }
}
