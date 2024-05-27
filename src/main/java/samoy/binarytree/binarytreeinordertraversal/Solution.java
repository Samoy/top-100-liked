package samoy.binarytree.binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.List;

import samoy.common.TreeNode;

/**
 * @link <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/?envType=study-plan-v2&envId=top-100-liked">二叉树的中序遍历</a>
 */
class Solution {
    // 创建一个ArrayList来存储遍历的结果
    private final List<Integer> list = new ArrayList<>();

    /**
     * 公共方法，接收一个二叉树的根节点，返回中序遍历的结果列表
     *
     * @param root 二叉树的根节点
     * @return 中序遍历的结果列表
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 调用深度优先搜索的递归方法进行中序遍历
        dfs(root);
        // 返回结果列表
        return list;
    }

    /**
     * 私有辅助方法，使用深度优先搜索的递归方式执行中序遍历
     *
     * @param root 当前遍历到的节点
     */
    private void dfs(TreeNode root) {
        // 如果当前节点为空，则直接返回
        if (root == null) return;
        // 首先遍历左子树
        dfs(root.left);
        // 访问当前节点并将其值添加到结果列表
        list.add(root.val);
        // 最后遍历右子树
        dfs(root.right);
    }
}
