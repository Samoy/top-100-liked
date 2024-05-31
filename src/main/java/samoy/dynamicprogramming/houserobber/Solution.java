package samoy.dynamicprogramming.houserobber;

/**
 * @link <a href="https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-100-liked">打家劫舍</a>
 */
class Solution {
    // 动态规划
    public int rob(int[] nums) {
        // 处理边界情况
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // 初始化dp数组，dp[i]表示抢劫到第i间房屋时能获得的最大金额
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 动态规划转移方程
        for (int i = 2; i < nums.length; i++) {
            // 抢劫当前房屋，则不能抢劫前一间，可以抢劫前两间，取最大值加上当前房屋的钱
            // 不抢劫当前房屋，则可以抢劫前一间，直接继承前一间房屋的最大金额
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        // 最终结果为dp数组的最后一个元素，即抢劫到最后一家时的最大金额
        return dp[nums.length - 1];
    }

    // 滚动变量
    public int rob2(int[] nums) {
        // 处理边界情况
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // 使用两个变量代替dp数组
        int robPrev = nums[0]; // 抢劫前一个房屋的最大金额
        int noRobPrev = 0; // 不抢劫前一个房屋的最大金额

        for (int i = 1; i < nums.length; i++) {
            // 计算当前抢劫状态下的最大金额，基于不抢劫前一个房屋的最大金额加上当前房屋的金额
            int robCurrent = noRobPrev + nums[i];
            // 更新不抢劫当前房屋的最大金额为抢劫前一个房屋和不抢劫前一个房屋中的较大值
            noRobPrev = Math.max(noRobPrev, robPrev);
            // 更新抢劫前一个房屋的最大金额为当前抢劫状态下的最大金额
            robPrev = robCurrent;
        }

        // 最终结果是抢劫最后一个房屋和不抢劫最后一个房屋中的较大值
        return Math.max(robPrev, noRobPrev);
    }
}
