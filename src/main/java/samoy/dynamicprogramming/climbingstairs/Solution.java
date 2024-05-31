package samoy.dynamicprogramming.climbingstairs;

import java.util.Arrays;

/**
 * @link <a href="https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-100-liked">爬楼梯</a>
 */
class Solution {
    // 动态规划
    public int climbStairs(int n) {
        // 特殊情况：1阶楼梯需要1步，2阶楼梯需要2步
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 初始化动态规划数组，大小为n+1，包含从0到n的所有阶数
        int[] dp = new int[n + 1];
        // 将数组填充为0，不是必需的，因为数组默认值就是0
        Arrays.fill(dp, 0);

        // 初始化dp[1]和dp[2]
        dp[1] = 1;
        dp[2] = 2;

        // 从第3阶开始，每一步都可能是从上一阶或上两阶跳下来的
        for (int i = 3; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2] 表示到达第i阶楼梯可以通过到达第i-1阶或第i-2阶后再走一步
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 返回到达n阶楼梯的最小步数
        return dp[n];
    }

    // 滚动变量
    public int climbStairs2(int n) {
        // 特殊情况：1阶楼梯需要1步，2阶楼梯需要2步
        if (n <= 2) return n;

        // 初始化前两个步数
        int prevStep1 = 1;
        int prevStep2 = 2;

        // 从第3阶开始，每一步都可能是从上一阶或上两阶跳下来的
        for (int i = 3; i <= n; i++) {
            // 使用一个临时变量存储当前步数
            int currentStep = prevStep1 + prevStep2;
            // 更新prevStep2为prevStep1
            prevStep2 = prevStep1;
            // 更新prevStep1为当前步数
            prevStep1 = currentStep;
        }

        // 返回到达n阶楼梯的步数
        return prevStep1;
    }

    // 递归:LeetCode超时
    @Deprecated
    public int climbStairs3(int n) {
        if (n <= 2) return n;
        return climbStairs3(n - 1) + climbStairs3(n - 2);
    }
}
