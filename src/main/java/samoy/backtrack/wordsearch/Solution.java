package samoy.backtrack.wordsearch;

/**
 * @link <a href="https://leetcode.cn/problems/word-search/?envType=study-plan-v2&envId=top-100-liked">单词搜索</a>
 */
// 定义Solution类
class Solution {
    // 初始化行数和列数变量
    private int rows = 0, cols = 0;

    public boolean exist(char[][] board, String word) {
        // 获取矩阵的行数和列数
        this.rows = board.length;
        this.cols = board[0].length;

        // 遍历矩阵，从每个单元格开始尝试回溯查找单词
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果从当前位置开始能成功回溯找到单词，返回true
                if (backtrack(board, word, i, j, 0)) return true;
            }
        }

        // 如果遍历完所有位置都没有找到，返回false
        return false;
    }

    // 回溯方法，用于深度优先搜索查找单词
    private boolean backtrack(char[][] board, String word, int i, int j, int k) {
        // 边界条件：如果越界或字符不匹配，返回false
        if (i >= rows || i < 0 || j >= cols || j < 0 || board[i][j] != word.charAt(k)) return false;

        // 如果已经到达单词的最后一个字符，表示找到匹配的路径，返回true
        if (k == word.length() - 1) return true;

        // 将当前字符标记为'\0'，防止重复使用
        board[i][j] = '\0';

        // 从当前位置向四个方向进行回溯
        boolean res = backtrack(board, word, i - 1, j, k + 1) // 向上
                || backtrack(board, word, i + 1, j, k + 1) // 向下
                || backtrack(board, word, i, j - 1, k + 1) // 向左
                || backtrack(board, word, i, j + 1, k + 1); // 向右

        // 恢复当前字符，以便其他路径可以继续使用
        board[i][j] = word.charAt(k);

        // 返回回溯结果
        return res;
    }
}
