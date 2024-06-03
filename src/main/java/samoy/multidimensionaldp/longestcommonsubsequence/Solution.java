package samoy.multidimensionaldp.longestcommonsubsequence;

/**
 * @link <a href="https://leetcode.cn/problems/longest-common-subsequence/?envType=study-plan-v2&envId=top-100-liked">最长公共子序列</a>
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // 初始化m,n为text1和text2的长度
        int m = text1.length(), n = text2.length();
        // 初始化一个二维数组dp，用于存储长度为 (m + 1) x (n + 1)的动态规划表
        int[][] dp = new int[m + 1][n + 1];
        // 遍历text1和text2的所有字符组合
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果当前字符在两个字符串中都出现，那么LCS长度就是在不考虑当前字符的情况下LCS长度加1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 如果当前字符在两个字符串中不匹配，那么LCS长度就是两个选项中LCS长度较大的那个
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 最后一行最后一列的值就是两个字符串的LCS长度
        return dp[m][n];
    }
}