package samoy.binarytree.pathsumiii;

import samoy.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        // 使用一个哈希映射存储前缀和及其出现次数
        Map<Long, Integer> prefix = new HashMap<>();
        // 初始化前缀和为0的计数为1，表示空路径
        prefix.put(0L, 1);
        // 通过深度优先搜索（DFS）计算满足条件的路径数量
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode node, Map<Long, Integer> prefix, long curr, int targetSum) {
        // 如果当前节点为空，返回0
        if (node == null) return 0;

        // 更新当前路径和
        curr += node.val;

        // 检查当前路径和减去目标和是否在哈希映射中，表示之前是否有路径到达了这个和
        int ans = prefix.getOrDefault(curr - targetSum, 0);

        // 更新当前路径和在哈希映射中的计数，表示到达这个和的路径数增加
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);

        // 递归遍历左子树，累加路径数量
        ans += dfs(node.left, prefix, curr, targetSum);

        // 递归遍历右子树，累加路径数量
        ans += dfs(node.right, prefix, curr, targetSum);

        // 回溯时，减少当前路径和在哈希映射中的计数
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        // 返回当前路径下满足条件的路径数量
        return ans;
    }
}
