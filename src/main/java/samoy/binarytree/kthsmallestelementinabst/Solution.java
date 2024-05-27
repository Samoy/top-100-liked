package samoy.binarytree.kthsmallestelementinabst;

import samoy.common.TreeNode;

/**
 * @link 二叉搜索树中第K小的元素
 */
class Solution {
    // 初始化计数器
    public int n = 0;
    // 初始化目标值
    public int num = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        // 根据二叉搜索树的性质我们可以继续使用中序遍历
        // 由于中序遍历是递增数列，所以我们可以遍历到第k个数字时停止
        dfs(root, k);
        return num;
    }

    private void dfs(TreeNode node, int k) {
        // 如果节点为空，直接返回
        if (node == null) return;
        // 先遍历左子树
        dfs(node.left, k);
        // 更新计数器，每遍历一个节点，计数器加1
        n++;
        // 当计数器达到 k 时，更新目标值为当前节点的值，并且停止遍历
        if (n == k) {
            num = node.val;
            return;
        }
        // 继续遍历右子树
        dfs(node.right, k);
    }
}
