package samoy.binarytree.invertbinarytree;

import samoy.common.TreeNode;

/**
 * @link <a href="https://leetcode.cn/problems/invert-binary-tree/?envType=study-plan-v2&envId=top-100-liked">翻转二叉树</a>
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // 基准情况：如果当前节点为空，则直接返回null
        if (root == null) return null;

        // 递归翻转当前节点的左右子树
        // 使用一个临时变量tmp来暂存当前节点的左子节点
        TreeNode tmp = root.left;

        // 将当前节点的左子节点设置为其右子节点的翻转结果
        root.left = invertTree(root.right);

        // 将当前节点的右子节点设置为之前左子节点（现在在tmp中）的翻转结果
        root.right = invertTree(tmp);

        // 返回处理后的当前节点，作为上一层递归的返回值
        return root;
    }
}
