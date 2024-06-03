package samoy.dynamicprogramming.partitionequalsubsetsum;

import java.util.Arrays;

/**
 * @link <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/?envType=study-plan-v2&envId=top-100-liked">分割等和子集</a>
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length; // 获取数组长度
        int sum = Arrays.stream(nums).sum(); // 计算数组元素之和
        // 如果总和是奇数，无法分割成两个和相等的子集
        if ((sum & 1) == 1) return false;
        int target = sum / 2; // 目标和，即两个子集的期望和

        // 初始化一个布尔数组dp，长度为target+1，表示可以找到和为j的子集
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // 初始化dp[0]为true

        // 如果数组的第一个元素小于等于目标和，那么可以单独作为一个子集
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }

        // 遍历数组中的每个元素
        for (int i = 1; i < len; i++) {
            // 从目标和递减到0，检查是否可以找到和为j的子集
            for (int j = target; j >= 0; j--) {
                // 如果当前元素小于等于j，可以将它加入到和为j的子集中
                if (nums[i] <= j) {
                    dp[j] = dp[j] || dp[j - nums[i]]; // 更新dp[j]，表示可以是j或j-nums[i]
                }
            }

            // 如果在当前元素之后找到了和为目标和的子集，直接返回true
            if (dp[target]) {
                return true;
            }
        }

        // 如果遍历完所有元素都没有找到和为目标和的子集，返回dp[target]
        return dp[target];
    }
}
