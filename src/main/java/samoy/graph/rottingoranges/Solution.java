package samoy.graph.rottingoranges;

import java.util.ArrayList;
import java.util.List;

/**
 * @link <a href="https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=top-100-liked">腐烂的橘子</a>
 */
class Solution {
    // 定义常量，表示四个可能的移动方向
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 四方向

    public int orangesRotting(int[][] grid) {
        int m = grid.length; // 网格的行数
        int n = grid[0].length; // 网格的列数
        int fresh = 0; // 记录新鲜橘子的数量
        List<int[]> q = new ArrayList<>(); // 使用队列保存腐烂橘子的位置

        // 遍历网格，计算新鲜橘子数量并将腐烂橘子的位置放入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // 初始化答案为-1，表示无法在有限时间内传播到所有新鲜橘子
        int ans = -1;

        // 当队列不为空时，继续传播腐烂橘子
        while (!q.isEmpty()) {
            ans++; // 每次循环代表时间增加一分钟
            List<int[]> tmp = q; // 复制队列，避免在循环中修改原始队列
            q = new ArrayList<>(); // 创建新队列用于存储新的腐烂橘子位置

            // 对于队列中的每一个腐烂橘子
            for (int[] pos : tmp) {
                for (int[] d : DIRECTIONS) { // 遍历四个方向
                    int i = pos[0] + d[0]; // 新位置的行
                    int j = pos[1] + d[1]; // 新位置的列

                    // 检查新位置是否在网格范围内且为新鲜橘子
                    if (0 <= i && i < m && 0 <= j && j < n && grid[i][j] == 1) {
                        fresh--; // 将新鲜橘子标记为腐烂，并减少新鲜橘子数量
                        grid[i][j] = 2; // 更新网格状态
                        q.add(new int[]{i, j}); // 将新位置的腐烂橘子加入队列
                    }
                }
            }
        }

        // 如果还有新鲜橘子未被感染，返回-1
        return fresh > 0 ? -1 : Math.max(ans, 0); // 返回传播完成需要的分钟数，或者-1表示无法传播到所有新鲜橘子
    }
}
