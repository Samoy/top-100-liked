package samoy.binarytree.binarytreelevelordertraversal;

import samoy.common.TreeNode;

import java.util.*;

/**
 * @link <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/?envType=study-plan-v2&envId=top-100-liked">二叉树的层序遍历</a>
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 如果根节点为空，返回空列表
        if (root == null) return new ArrayList<>();

        // 使用队列进行广度优先搜索
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点放入队列
        queue.offer(root);

        // 初始化结果列表，用于存储每一层的节点值列表
        List<List<Integer>> list = new ArrayList<>();

        // 当队列不为空时，继续遍历
        while (!queue.isEmpty()) {
            // 创建一个临时列表，用于存储当前层的所有节点值
            List<Integer> tmp = new ArrayList<>();

            // 遍历当前层的所有节点
            for (int i = queue.size(); i > 0; i--) {
                // 弹出队列中的第一个节点
                TreeNode node = queue.poll();

                // 如果节点非空，将其值添加到临时列表
                if (node != null) {
                    tmp.add(node.val);

                    // 将当前节点的左右子节点（如果存在）入队
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

            // 将当前层的节点值列表添加到结果列表
            list.add(tmp);
        }

        // 返回层序遍历的结果
        return list;
    }
}
