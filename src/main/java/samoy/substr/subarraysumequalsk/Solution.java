package samoy.substr.subarraysumequalsk;

import java.util.HashMap;
import java.util.Map;

/**
 * @link <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked">和为K的子数组</a>
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        // 初始化结果变量，用于存储和为k的子数组个数
        int result = 0;

        // 遍历数组，用i作为子数组的起始索引
        for (int i = 0; i < nums.length; i++) {
            // 初始化子数组的起始索引
            int start = i;
            // 初始化子数组的当前和
            int sum = 0;

            // 使用while循环，直到start超出数组边界
            while (start < nums.length) {
                // 将当前元素加入子数组的和
                sum += nums[start];

                // 如果子数组的和等于k，说明找到一个满足条件的子数组
                if (sum == k) {
                    // 增加结果计数
                    result++;
                }

                // 移动子数组的起始索引
                start++;
            }
        }

        // 返回结果
        return result;
    }

    public int subarraySum2(int[] nums, int k) {
        // 初始化结果变量
        int result = 0;
        // 初始化前缀和哈希表
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        // 初始化前缀和为0，并将其添加到哈希表中
        prefixSumMap.put(0, 1);

        // 计算前缀和并检查是否满足条件
        int sum = 0;
        for (int num : nums) {
            sum += num;
            // 如果sum-k在哈希表中，说明存在一个和为k的子数组
            // 重点解释下为什么是sum-k
            // 对于任意子数组[j...i]有sum[i] - sum[j] = nums[j+1]+...+nums[i]
            // 而 nums[j+1...i] 是连续子数组
            // 将 nums[j+1]+...+nums[i] 替换为k就是sum[i] - sum[j] = k
            // 而这就等价于sum[j] = sum[i] - k
            // 然后问题就是寻找sum[j](也就是sum[i]-k)是否存在于prefixSumMap中
            if (prefixSumMap.containsKey(sum - k)) {
                result += prefixSumMap.get(sum - k);
            }
            // 将当前前缀和添加到哈希表中
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
