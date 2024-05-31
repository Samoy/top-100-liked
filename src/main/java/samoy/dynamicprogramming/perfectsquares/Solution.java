package samoy.dynamicprogramming.perfectsquares;

/**
 * <a href="https://leetcode.cn/problems/perfect-squares/description/?envType=study-plan-v2&envId=top-100-liked">完全平方数</a>
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minNum = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                // 查找小于等于i的完全平方数，更新最小数量
                // dp[i - j * j]表示去掉一个完全平方数j*j后，剩余部分的最少完全平方数个数
                minNum = Math.min(minNum, dp[i - j * j]);
            }
            dp[i] = minNum + 1;
        }
        return dp[n];
    }
}