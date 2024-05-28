package samoy.graph.numberofislands;

/**
 * @link <a href="https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-100-liked">岛屿数量</a>
 */
class Solution {
    public int numIslands(char[][] grid) {
        // 如果网格为空，直接返回0
        if (grid.length == 0) return 0;

        // 初始化岛屿计数器
        int num = 0;

        // 遍历网格的每一个元素
        for (int i = 0; i < grid.length; i++) { // 遍历行
            for (int j = 0; j < grid[i].length; j++) { // 遍历列
                // 如果当前位置是陆地（'1'），则进行深度优先搜索，并增加岛屿计数
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++; // 搜索完一个岛屿后，岛屿计数加一
                }
            }
        }

        // 返回最终的岛屿数量
        return num;
    }

    // 深度优先搜索方法，用于淹没（标记为'0'）与给定位置相连的所有陆地，防止重复计数
    private void dfs(char[][] grid, int i, int j) {
        // 如果越界或者当前位置是水（'0'），则直接返回
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;

        // 将当前位置标记为已访问（即将陆地变为水）
        grid[i][j] = '0';

        // 递归搜索当前位置的上、下、左、右四个相邻位置
        dfs(grid, i - 1, j); // 上
        dfs(grid, i + 1, j); // 下
        dfs(grid, i, j - 1); // 左
        dfs(grid, i, j + 1); // 右
    }
}
