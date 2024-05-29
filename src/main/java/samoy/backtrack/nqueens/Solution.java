package samoy.backtrack.nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @link <a href="https://leetcode.cn/problems/n-queens/?envType=study-plan-v2&envId=top-100-liked">N皇后</a>
 */
class Solution {
    // 主要方法，接收N值，返回所有可能的解决方案
    public List<List<String>> solveNQueens(int n) {
        // 初始化皇后位置数组，所有位置默认-1表示未放置皇后
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 初始化解决方案列表
        List<List<String>> solutions = new ArrayList<>();

        // 调用核心解决方法
        solve(solutions, queens, n, 0, 0, 0, 0);

        // 返回解决方案列表
        return solutions;
    }

    // 核心解决方法，递归处理每一行
    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        // 如果当前行数等于N，表示所有皇后都已放置，生成棋盘并添加到解决方案
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            // 计算当前行可用的位置
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));

            // 遍历可用位置
            while (availablePositions != 0) {
                // 获取第一个可用位置
                int position = availablePositions & (-availablePositions);
                // 更新可用位置掩码
                availablePositions = availablePositions & (availablePositions - 1);
                int column = Integer.bitCount(position - 1);
                // 将皇后放置在当前位置
                queens[row] = column;

                // 处理下一行，更新已占用的列、左对角线和右对角线掩码
                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);

                // 回溯，撤销皇后放置
                queens[row] = -1;
            }
        }
    }

    // 根据皇后位置数组生成棋盘表示
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 初始化棋盘行
            char[] row = new char[n];
            Arrays.fill(row, '.');

            // 如果当前位置有皇后，替换为'Q'
            if (queens[i] != -1) {
                row[queens[i]] = 'Q';
            }

            // 添加棋盘行到列表
            board.add(new String(row));
        }
        return board;
    }
}


