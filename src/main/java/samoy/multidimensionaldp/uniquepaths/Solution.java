package samoy.multidimensionaldp.uniquepaths;

/**
 * @link <a href="https://leetcode.cn/problems/unique-paths/?envType=study-plan-v2&envId=top-100-liked">不同路径</a>
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 第一行或者第一列的所有网格的路径数为1，因为机器人只能向右向下移动
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // 对于网格中的其他位置，到达该位置的路径数等于上方网格和左方网格的路径数之和
                    // 因为机器人只能从这两个方向到达当前位置
                    // 当前位置的路径数等于上面的路径数加上左边的路径数
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        // 最终，dp[m-1][n-1]的位置存储的就是从起点到终点的不同路径总数
        return dp[m - 1][n - 1];
    }
}