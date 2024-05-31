package samoy.dynamicprogramming.coinchange;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked">零钱兑换</a>
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 初始化动态规划数组，大小为amount+1，dp[i]表示凑出i金额所需的最少硬币数
        int[] dp = new int[amount + 1];
        // 初始化最大值，用来表示还没找到解
        int max = amount + 1;
        // 将dp数组全部初始化为最大值
        Arrays.fill(dp, max);
        // dp[0]表示凑出0金额，需要0个硬币
        dp[0] = 0;

        // 遍历从1到amount的所有金额
        for (int i = 1; i <= amount; i++) {
            // 遍历所有硬币
            for (int coin : coins) {
                // 如果硬币面额小于等于当前金额，尝试使用这个硬币
                if (coin <= i) {
                    // 更新dp[i]为使用当前硬币后的最小硬币数
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果dp[amount]大于amount，表示无法凑出目标金额，返回-1
        // 否则，dp[amount]就是最少硬币数量
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
