package samoy.dynamicprogramming.maximumproductsubarray;

import java.math.BigInteger;

/**
 * @link <a href="https://leetcode.cn/problems/maximum-product-subarray/?envType=study-plan-v2&envId=top-100-liked">乘积最大子数组</a>
 */
class Solution {
    public int maxProduct(int[] nums) {
        // 处理特殊情况：数组为空时返回0
        if (nums.length == 0) return 0;

        // 初始化最大乘积和最小乘积为数组的第一个元素
        // 使用BigInteger以支持大数运算，避免整数溢出
        BigInteger maxProd = BigInteger.valueOf(nums[0]);
        BigInteger minProd = BigInteger.valueOf(nums[0]);

        // 初始化最终结果为第一个元素的最大值
        BigInteger result = BigInteger.valueOf(nums[0]);

        // 遍历数组中的每个元素
        for (int i = 1; i < nums.length; i++) {
            // 将当前元素转换为BigInteger
            BigInteger num = BigInteger.valueOf(nums[i]);

            // 计算当前元素与之前最大乘积、最小乘积的乘积，并取三者中的最大值作为新的最大乘积
            // 这是因为负数与最小值相乘可能得到最大乘积
            BigInteger tempMax = num.max(maxProd.multiply(num).max(minProd.multiply(num)));

            // 同理，计算当前元素与之前最大乘积、最小乘积的乘积，并取三者中的最小值作为新的最小乘积
            minProd = num.min(maxProd.multiply(num).min(minProd.multiply(num)));

            // 更新最大乘积
            maxProd = tempMax;

            // 比较当前最大乘积与已知的最大乘积，更新结果
            result = result.max(maxProd);
        }

        // 将最终的最大乘积转换为int返回，注意这里假设结果不会超出int范围
        return result.intValue();
    }
}



