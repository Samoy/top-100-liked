package samoy.array.maximumsubarray;

/**
 * @link <a href="https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked">最大子数组和</a>
 */
class Solution {
    public int maxSubArray(int[] nums) {
        // 特殊情况：数组为空，返回0
        if (nums.length == 0) return 0;

        // 初始化当前子数组和(currentSum)和最大子数组和(maxSum)，都设置为数组第一个元素
        int currentSum = nums[0];
        int maxSum = nums[0];

        // 使用循环遍历数组，从第二个元素开始
        for (int i = 1; i < nums.length; i++) {
            // 使用 Kadane's algorithm 更新当前子数组和
            // 如果当前元素大于当前子数组和与当前元素之和，那么从当前元素开始新的子数组
            // 否则，当前子数组和继续累加当前元素
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // 比较当前子数组和与最大子数组和，更新最大子数组和
            maxSum = Math.max(maxSum, currentSum);
        }

        // 返回最大子数组和
        return maxSum;
    }
}
