package samoy.binarytree.binarytreerightsideview;

import samoy.common.TreeNode;

import java.util.*;

/**
 * @link <a href="https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked">二叉树的右视图</a>
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // 初始化结果列表
        List<Integer> ans = new ArrayList<>();
        // 通过深度优先搜索（DFS）遍历二叉树，记录右侧视图
        dfs(root, 0, ans);
        // 返回右侧视图的节点值列表
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        // 如果当前节点为空，直接返回
        if (root == null) {
            return;
        }

        // 当前深度首次到达时，将节点值添加到结果列表
        if (depth == ans.size()) {
            ans.add(root.val);
        }

        // 优先遍历右子树，确保右子节点的深度先被检查
        dfs(root.right, depth + 1, ans);

        // 然后遍历左子树
        dfs(root.left, depth + 1, ans);
    }
}

