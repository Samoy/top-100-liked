package samoy.multidimensionaldp.minimumpathsum;

/**
 * @link <a href="https://leetcode.cn/problems/minimum-path-sum/?envType=study-plan-v2&envId=top-100-liked">最小路径和</a>
 */
class Solution {
    // 定义一个方法来找到最小路径和
    public int minPathSum(int[][] grid) {
        // 遍历网格的每一个单元格
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 对于第一个单元格，没有路径可以选择，所以直接跳过
                if (i == 0 && j == 0) continue;

                // 如果在第一行，只能从左边的单元格过来
                if (i == 0) {
                    // 当前单元格的最小路径和为左边单元格的路径和加上当前单元格的值
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                // 如果在第一列，只能从上边的单元格过来
                else if (j == 0) {
                    // 当前单元格的最小路径和为上边单元格的路径和加上当前单元格的值
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                // 对于其他单元格，可以从上边或左边过来，取两者中路径和较小的那个
                else {
                    // 当前单元格的最小路径和为上一个最小路径和（上边或左边）加上当前单元格的值
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }

        // 最终，右下角的单元格的值即为最小路径和
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
